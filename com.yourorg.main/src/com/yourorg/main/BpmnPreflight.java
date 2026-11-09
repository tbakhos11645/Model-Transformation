package com.yourorg.main;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/** Validates the supported execution subset before ATL creates any output. */
public final class BpmnPreflight {
    private BpmnPreflight() {}

    public static Object get(EObject e, String feature) {
        if (e == null) return null;
        EStructuralFeature f = e.eClass().getEStructuralFeature(feature);
        return f == null ? null : e.eGet(f);
    }
    public static boolean kind(EObject e, String name) {
        return e != null && (e.eClass().getName().equals(name)
            || e.eClass().getEAllSuperTypes().stream().anyMatch(c -> c.getName().equals(name)));
    }
    @SuppressWarnings("unchecked")
    static List<EObject> list(EObject e, String feature) {
        Object v = get(e, feature);
        return v instanceof List<?> ? (List<EObject>) v : List.of();
    }
    private static String text(EObject e, String feature) {
        Object v = get(e, feature);
        return v instanceof String ? ((String) v).trim() : "";
    }
    private static String label(EObject e) {
        return e.eClass().getName() + " " + EcoreUtil.getURI(e);
    }
    private static void require(boolean ok, EObject e, String message, List<String> errors) {
        if (!ok) errors.add(label(e) + ": " + message);
    }
    private static boolean present(EObject e, String f) {
        Object v = get(e, f);
        return v instanceof List<?> ? !((List<?>) v).isEmpty() : v != null;
    }
    private static void nonnegative(EObject e, String f, List<String> errors) {
        Object v = get(e, f);
        require(v instanceof Number && Double.isFinite(((Number) v).doubleValue())
            && ((Number) v).doubleValue() >= 0, e, f + " must be finite and nonnegative", errors);
    }
    private static void expression(String s, EObject e, List<String> errors) {
        require(!s.isBlank() && !s.matches("(?s).*[\\r\\n'{}].*"), e,
            "Use an unquoted JaamSim expression without CFG delimiters", errors);
    }
    private static String condition(EObject expression, List<String> errors) {
        if (expression == null) return "";
        String s = text(expression, "JaamSimExpression");
        // Never stringify an EObject-valued FormalExpression.body.
        if (s.isEmpty() && get(expression, "body") instanceof String) s = text(expression, "body");
        require(text(expression, "language").equalsIgnoreCase("JaamSim"), expression,
            "Condition language must be JaamSim; arbitrary BPMN expression languages are not translated", errors);
        expression(s, expression, errors);
        return s;
    }
    private static double seconds(EObject expression) {
        String s = text(expression, "JaamSimExpression");
        if (s.isEmpty() && get(expression, "body") instanceof String) s = text(expression, "body");
        if (s.startsWith("R/")) s = s.substring(2);
        if (s.startsWith("P")) return Duration.parse(s).toNanos() / 1.0e9;
        if (s.matches("[0-9]+(\\.[0-9]+)?([eE][+-]?[0-9]+)?(\\s+s)?"))
            return Double.parseDouble(s.replaceFirst("\\s+s$", ""));
        throw new IllegalArgumentException("Timer needs a nonnegative constant in seconds or ISO duration PT...; use JaamSimExpression");
    }

    public static void validateAndNormalize(Resource input) {
        EcoreUtil.resolveAll(input);
        List<String> errors = new ArrayList<>();
        List<EObject> all = new ArrayList<>();
        input.getAllContents().forEachRemaining(all::add);
        Map<EObject, Map<String, Object>> updates = new LinkedHashMap<>();
        require(input.getContents().size() == 1 && kind(input.getContents().get(0), "Definitions"),
            all.isEmpty() ? org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEObject() : all.get(0),
            "Expected one Definitions root", errors);
        List<EObject> processes = all.stream().filter(e -> kind(e, "Process")).toList();
        if (processes.isEmpty()) errors.add("No BPMN Process found");
        Set<String> ids = new HashSet<>();
        for (EObject e : all) {
            String id = text(e, "id");
            require(id.isEmpty() || ids.add(id), e, "Duplicate id " + id, errors);
            require(!e.eIsProxy(), e, "Unresolved proxy", errors);
            if (kind(e, "Definitions")) {
                for (EObject root : list(e, "rootElements"))
                    require(kind(root, "Process"), root, "Only Process root elements are supported", errors);
            }
            if (kind(e, "FlowElement")) {
                boolean supported = kind(e, "StartEvent") || kind(e, "EndEvent") || kind(e, "Task")
                    || kind(e, "ExclusiveGateway") || kind(e, "SequenceFlow");
                require(supported, e, "Unsupported flow element; parallel/inclusive joins, subprocesses and intermediate/boundary events require additional execution semantics", errors);
                require(kind(e.eContainer(), "Process"), e, "Nested process elements are not supported", errors);
            }
            for (String f : List.of("resources", "resourceRoles", "loopCharacteristics", "dataInputAssociations", "dataOutputAssociations", "properties", "eventDefinitionRefs"))
                require(!present(e, f), e, "Unsupported execution feature " + f, errors);
            require(!Boolean.TRUE.equals(get(e, "isForCompensation")), e, "Compensation activities are unsupported", errors);
            if (kind(e, "Task")) {
                // Subclasses share timing/queue semantics; their external work is not executed.
                require(!kind(e, "SendTask") && !kind(e, "ReceiveTask"), e, "Message send/receive semantics are unsupported", errors);
                require(!present(e, "script"), e, "Script execution is unsupported", errors);
                nonnegative(e, "Time", errors);
            }
            if (kind(e, "StartEvent")) {
                for (String f : List.of("FirstArrivalTime", "InterArrivalTime", "EntitiesPerArrival", "MaxNumber")) nonnegative(e, f, errors);
                List<EObject> defs = list(e, "eventDefinitions");
                require(defs.size() <= 1, e, "Multiple start event definitions are unsupported", errors);
                for (EObject timer : defs) {
                    require(kind(timer, "TimerEventDefinition"), e, "Only none/timer start events are supported", errors);
                    if (!kind(timer, "TimerEventDefinition")) continue;
                    require(get(timer, "timeDate") == null, timer, "Absolute timer dates are unsupported", errors);
                    require(get(timer, "timeCycle") == null || get(timer, "timeDuration") == null, timer, "Use one timer expression: timeCycle or timeDuration", errors);
                    require(get(timer, "timeCycle") != null || get(timer, "timeDuration") != null, timer, "Timer has no duration/cycle", errors);
                    for (String f : List.of("timeDuration", "timeCycle")) {
                        Object ex = get(timer, f);
                        if (ex instanceof EObject) {
                            try {
                                double seconds = seconds((EObject) ex);
                                require(Double.isFinite(seconds) && seconds >= 0 && (!f.equals("timeCycle") || seconds > 0), timer, "Invalid timer value", errors);
                                String target = f.equals("timeCycle") ? "InterArrivalTime" : "FirstArrivalTime";
                                require(!e.eIsSet(e.eClass().getEStructuralFeature(target)), e, "Specify either timer " + f + " or " + target + ", not both", errors);
                                updates.computeIfAbsent(e, k -> new LinkedHashMap<>()).put(target, seconds);
                                if (f.equals("timeCycle") && !e.eIsSet(e.eClass().getEStructuralFeature("FirstArrivalTime")))
                                    updates.get(e).put("FirstArrivalTime", seconds);
                                // A duration-only timer starts the process once unless MaxNumber overrides it.
                                if (f.equals("timeDuration") && get(timer, "timeCycle") == null && ((Number) get(e, "MaxNumber")).intValue() == 0)
                                    updates.get(e).put("MaxNumber", 1);
                            } catch (RuntimeException exn) { errors.add(label(timer) + ": " + exn.getMessage()); }
                        }
                    }
                }
            } else if (kind(e, "EndEvent")) {
                require(list(e, "eventDefinitions").isEmpty(), e, "Only none end events are supported", errors);
            }
            if (kind(e, "SequenceFlow")) {
                nonnegative(e, "TravelTime", errors);
                EObject source = (EObject) get(e, "sourceRef"), target = (EObject) get(e, "targetRef");
                require(source != null && target != null && !source.eIsProxy() && !target.eIsProxy(), e, "Missing/unresolved source or target", errors);
                if (present(e, "BpsimProbability"))
                    require(kind(source, "ExclusiveGateway") && list(source, "outgoing").size() > 1, e,
                        "A routing probability requires an outgoing flow of an exclusive split", errors);
                if (source != null && target != null) {
                    require(source.eContainer() == e.eContainer() && target.eContainer() == e.eContainer(), e, "Cross-process sequence flow", errors);
                    require(list(source, "outgoing").contains(e) && list(target, "incoming").contains(e), e, "Sequence flow and node incoming/outgoing references disagree", errors);
                    require(get(e, "conditionExpression") == null || kind(source, "ExclusiveGateway"), e, "Conditions are only supported on XOR outgoing flows", errors);
                }
            }
            if (kind(e, "FlowNode")) {
                List<EObject> in = list(e, "incoming"), out = list(e, "outgoing");
                for (EObject f : in) require(get(f, "targetRef") == e, e, "Incoming flow has a different target", errors);
                for (EObject f : out) require(get(f, "sourceRef") == e, e, "Outgoing flow has a different source", errors);
                require(!kind(e, "StartEvent") || in.isEmpty(), e, "Start must have no incoming flows", errors);
                require(kind(e, "StartEvent") || !in.isEmpty(), e, "Node has no incoming flow", errors);
                require(kind(e, "EndEvent") ? out.isEmpty() : kind(e, "ExclusiveGateway") ? !out.isEmpty() : out.size() == 1,
                    e, "Expected zero outputs for end, one for ordinary nodes, or one/more for XOR", errors);
                if (kind(e, "ExclusiveGateway") && !out.isEmpty()) {
                    String choice = text(e, "Choice");
                    if (out.stream().anyMatch(f -> present(f, "BpsimProbability"))) {
                        require(out.size() > 1 && choice.isEmpty() && get(e, "default") == null, e,
                            "Probability routing cannot be combined with Choice or a default flow", errors);
                        double sum = 0;
                        for (EObject f : out) {
                            Object raw = get(f, "BpsimProbability");
                            double p = raw instanceof Number ? ((Number) raw).doubleValue() : Double.NaN;
                            require(Double.isFinite(p) && p >= 0 && p <= 1, f,
                                "Every outgoing flow needs a probability between 0 and 1", errors);
                            require(get(f, "conditionExpression") == null, f,
                                "A probability cannot be combined with a condition expression", errors);
                            sum += p;
                        }
                        require(Math.abs(sum - 1) <= 1e-9, e, "Outgoing probabilities must sum to 1", errors);
                        continue;
                    }
                    EObject fallback = (EObject) get(e, "default");
                    if (out.size() == 1) choice = "1"; // Merge/pass-through: no routing condition.
                    else if (choice.isEmpty()) {
                        require(fallback != null && out.contains(fallback), e, "Conditional XOR needs a default outgoing flow or explicit Choice", errors);
                        if (fallback != null && out.contains(fallback)) {
                            require(get(fallback, "conditionExpression") == null, fallback, "Default flow must not have a condition", errors);
                            choice = Integer.toString(out.indexOf(fallback) + 1);
                            for (int i = out.size() - 1; i >= 0; i--) {
                                EObject f = out.get(i);
                                if (f == fallback) continue;
                                EObject ex = (EObject) get(f, "conditionExpression");
                                String cond = condition(ex, errors);
                                require(!cond.isEmpty(), f, "Non-default XOR flow requires a JaamSim condition", errors);
                                choice = "(" + cond + ") ? " + (i + 1) + " : (" + choice + ")";
                            }
                        }
                    }
                    expression(choice, e, errors);
                    if (choice.matches("[0-9]+")) {
                        try { require(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= out.size(), e, "Choice index out of range", errors); }
                        catch (NumberFormatException ex) { errors.add(label(e) + ": Choice index out of range"); }
                    }
                    updates.computeIfAbsent(e, k -> new LinkedHashMap<>()).put("Choice", choice);
                }
            }
        }
        for (EObject p : processes) {
            List<EObject> nodes = list(p, "flowElements").stream().filter(e -> kind(e, "FlowNode")).toList();
            require(nodes.stream().anyMatch(e -> kind(e, "StartEvent")), p, "Process has no start", errors);
            require(nodes.stream().anyMatch(e -> kind(e, "EndEvent")), p, "Process has no end", errors);
            Set<EObject> reached = new HashSet<>();
            List<EObject> work = new ArrayList<>(nodes.stream().filter(e -> kind(e, "StartEvent")).toList());
            for (int i = 0; i < work.size(); i++) {
                EObject n = work.get(i);
                if (!reached.add(n)) continue;
                for (EObject f : list(n, "outgoing")) if (get(f, "targetRef") instanceof EObject) work.add((EObject) get(f, "targetRef"));
            }
            for (EObject n : nodes) require(reached.contains(n), n, "Node is unreachable from every start", errors);
            Set<EObject> terminating = new HashSet<>();
            work = new ArrayList<>(nodes.stream().filter(e -> kind(e, "EndEvent")).toList());
            for (int i = 0; i < work.size(); i++) {
                EObject n = work.get(i);
                if (!terminating.add(n)) continue;
                for (EObject f : list(n, "incoming")) if (get(f, "sourceRef") instanceof EObject) work.add((EObject) get(f, "sourceRef"));
            }
            for (EObject n : nodes) require(terminating.contains(n), n, "Node has no structural path to an end", errors);
        }
        if (!errors.isEmpty()) throw new IllegalArgumentException("BPMN preflight failed:\n - " + String.join("\n - ", errors));
        updates.forEach((e, fields) -> fields.forEach((name, value) -> e.eSet(e.eClass().getEStructuralFeature(name), value)));
    }
}
