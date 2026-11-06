import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.regex.Pattern;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.atl.emftvm.compiler.AtlToEmftvmCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;
import com.yourorg.main.Main;
import com.yourorg.main.BpmnPreflight;
import com.your.m2t.M2T;

/** Standalone integration checks; fixtures/output live only in .build. */
public class TransformationSmokeTest {
    static Path root;
    static int checks;
    static void check(boolean ok, String message) {
        checks++;
        if (!ok) throw new AssertionError(message);
    }
    static void set(EObject e, String name, Object value) { e.eSet(e.eClass().getEStructuralFeature(name), value); }
    @SuppressWarnings("unchecked")
    static List<EObject> list(EObject e, String name) { return (List<EObject>) BpmnPreflight.get(e, name); }
    static List<EObject> objects(Resource r, String name) {
        List<EObject> result = new ArrayList<>();
        r.getAllContents().forEachRemaining(e -> { if (BpmnPreflight.kind(e, name)) result.add(e); });
        return result;
    }
    static EObject create(EPackage p, String type) { return p.getEFactoryInstance().create((EClass) p.getEClassifier(type)); }
    static class Fixture {
        ResourceSet rs = Main.resourceSet(root);
        Resource r;
        EPackage p;
        EObject process;
        Fixture(String name) {
            r = rs.createResource(Main.uri(root.resolve(".build/" + name + ".bpmn.xmi")));
            p = rs.getPackageRegistry().getEPackage("http://www.omg.org/spec/BPMN/20100524/MODEL-XMI");
            EObject definitions = create(p, "Definitions");
            r.getContents().add(definitions);
            process = create(p, "Process");
            list(definitions, "rootElements").add(process);
        }
        EObject node(String type, String id) {
            EObject n = create(p, type);
            set(n, "id", id);
            set(n, "name", id);
            list(process, "flowElements").add(n);
            if (type.equals("StartEvent")) set(n, "MaxNumber", 3);
            return n;
        }
        EObject flow(EObject from, EObject to, String id) {
            EObject f = node("SequenceFlow", id);
            set(f, "sourceRef", from); set(f, "targetRef", to);
            if (!list(from, "outgoing").contains(f)) list(from, "outgoing").add(f);
            if (!list(to, "incoming").contains(f)) list(to, "incoming").add(f);
            return f;
        }
        EObject expression(String text) {
            EObject e = create(p, "FormalExpression");
            set(e, "language", "JaamSim"); set(e, "JaamSimExpression", text);
            return e;
        }
        String run(String name) throws Exception {
            r.save(Collections.emptyMap());
            Main.main(new String[]{r.getURI().toFileString(), ".build/" + name, root.toString(), "60"});
            return Files.readString(root.resolve(".build/" + name + ".cfg"));
        }
    }
    static Fixture linear(String name, String taskType) {
        Fixture f = new Fixture(name);
        EObject start = f.node("StartEvent", "Start");
        EObject task = f.node(taskType, "Work");
        EObject end = f.node("EndEvent", "End");
        f.flow(start, task, "toWork"); f.flow(task, end, "toEnd");
        return f;
    }
    static Fixture xor(String name) {
        Fixture f = new Fixture(name);
        EObject start = f.node("StartEvent", "Start");
        EObject gw = f.node("ExclusiveGateway", "Route");
        EObject end = f.node("EndEvent", "End");
        f.flow(start, gw, "in");
        EObject fallback = f.flow(gw, end, "defaultPath");
        EObject conditional = f.flow(gw, end, "conditionalPath");
        set(gw, "default", fallback);
        set(conditional, "conditionExpression", f.expression("this.NumberProcessed <= 2"));
        return f;
    }
    static void rejects(Fixture f, String message) {
        try { BpmnPreflight.validateAndNormalize(f.r); throw new AssertionError("Accepted invalid fixture: " + message); }
        catch (IllegalArgumentException expected) { check(expected.getMessage().contains(message), expected.getMessage()); }
    }
    static void cfgReferences(String cfg) {
        HashSet<String> declared = new HashSet<>();
        declared.add("Simulation");
        var definitions = Pattern.compile("(?m)^Define \\w+ \\{ ([^}]+) }").matcher(cfg);
        while (definitions.find()) for (String n : definitions.group(1).trim().split("\\s+"))
            check(declared.add(n), "Duplicate CFG name " + n);
        var references = Pattern.compile("(?m)^\\S+ (?:NextComponent|NextComponentList|WaitQueue|PrototypeEntity) \\{ ([^}]+) }").matcher(cfg);
        while (references.find()) for (String n : references.group(1).trim().split("\\s+"))
            check(declared.contains(n), "Missing CFG declaration " + n);
    }
    public static void main(String[] args) throws Exception {
        root = Path.of(args[0]);
        try (InputStream in = Files.newInputStream(root.resolve("com.yourorg.atl/Rules/Rules.atl"))) {
            CompileTimeError[] problems = new AtlToEmftvmCompiler().compile(in,
                root.resolve("com.yourorg.atl/Rules/Rules.emftvm").toString());
            for (CompileTimeError p : problems) {
                System.out.println(p.getSeverity() + " " + p.getLocation() + ": " + p.getDescription());
                check(!"error".equalsIgnoreCase(p.getSeverity()), "ATL compilation failed");
            }
        }
        for (int i = 1; i <= 2; i++) {
            Main.main(new String[]{"com.yourorg.main/sample_in/Ex" + i + "_BPMN.xmi", ".build/ex" + i, root.toString(), "60"});
            String cfg = Files.readString(root.resolve(".build/ex" + i + ".cfg"));
            cfgReferences(cfg);
            check(cfg.contains("TravelTime { 0.0 s }"), "Conveyors must have no fabricated delay");
            Resource out = Main.resourceSet(root).getResource(Main.uri(root.resolve(".build/ex" + i + ".jaamsim.xmi")), true);
            check(out.getContents().size() == 1, "All target objects must be contained by one root");
            for (EObject server : objects(out, "Server")) {
                EObject q = (EObject) BpmnPreflight.get(server, "waitQueue");
                check(objects(out, "EntityConveyor").stream().anyMatch(c -> BpmnPreflight.get(c, "nextComponent") == q), "Task inputs must reach the queue");
            }
            M2T exporter = new M2T();
            Path repeat = root.resolve(".build/repeat.cfg");
            exporter.exportToConfig(out, Main.uri(repeat));
            check(cfg.equals(Files.readString(repeat)), "Reloading dynamic XMI must preserve CFG");
            exporter.exportToConfig(out, Main.uri(repeat));
            check(cfg.equals(Files.readString(repeat)), "Exporter state must reset between runs");
            EObject conveyor = objects(out, "EntityConveyor").get(0);
            set(conveyor, "nextComponent", create(conveyor.eClass().getEPackage(), "Queue"));
            try { exporter.exportToConfig(out, Main.uri(repeat)); throw new AssertionError("Accepted undeclared reference"); }
            catch (IllegalArgumentException expected) { check(cfg.equals(Files.readString(repeat)), "Invalid export must preserve the existing CFG"); }
        }
        for (String type : List.of("Task", "UserTask", "ServiceTask", "ManualTask", "ScriptTask", "BusinessRuleTask")) {
            Fixture f = linear("subtype-" + type, type);
            EObject start = objects(f.r, "StartEvent").get(0);
            set(start, "InterArrivalTime", 2.0); set(start, "EntitiesPerArrival", 2); set(start, "FirstArrivalTime", 4.0);
            EObject task = objects(f.r, "Task").get(0);
            set(task, "name", "Simulation"); // Reserved UI name must get a suffix.
            String cfg = f.run("subtype-" + type);
            check(cfg.contains("Define Server { Simulation_2 }"), "Inherited names/reserved names");
            check(cfg.contains("ServiceTime { 0.0 s }"), "Zero service time must be emitted");
            check(cfg.contains("InterArrivalTime { 2.0 s }") && cfg.contains("EntitiesPerArrival { 2 }") && cfg.contains("FirstArrivalTime { 4.0 s }"), "Explicit arrival inputs");
            cfgReferences(cfg);
        }
        Fixture collision = linear("collision", "Task");
        set(objects(collision.r, "StartEvent").get(0), "name", "Same name");
        set(objects(collision.r, "EndEvent").get(0), "name", "Same-name");
        String collisionCfg = collision.run("collision");
        check(collisionCfg.contains("Same_name_2"), "Normalized names must be globally unique");
        cfgReferences(collisionCfg);
        Fixture conditional = xor("conditional");
        String conditionalCfg = conditional.run("conditional");
        check(conditionalCfg.contains("Choice { '(this.NumberProcessed <= 2) ? 2 : (1)' }"), "Default branch/index order");
        cfgReferences(conditionalCfg);
        Fixture merge = linear("merge", "Task");
        EObject oldFlow = objects(merge.r, "SequenceFlow").get(1);
        EObject end = objects(merge.r, "EndEvent").get(0);
        EObject gw = merge.node("ExclusiveGateway", "Merge");
        list(end, "incoming").remove(oldFlow); set(oldFlow, "targetRef", gw); list(gw, "incoming").add(oldFlow);
        merge.flow(gw, end, "merged");
        check(merge.run("merge").contains("Choice { '1' }"), "XOR merge needs no Choice input");
        Fixture timer = linear("timer", "Task");
        EObject start = objects(timer.r, "StartEvent").get(0);
        EObject timerDef = create(timer.p, "TimerEventDefinition");
        set(timerDef, "timeCycle", timer.expression("R/PT5S")); list(start, "eventDefinitions").add(timerDef);
        String timerCfg = timer.run("timer");
        check(timerCfg.contains("FirstArrivalTime { 5.0 s }") && timerCfg.contains("InterArrivalTime { 5.0 s }"), "Timer cycle conversion");
        Fixture parallel = linear("parallel", "Task"); parallel.node("ParallelGateway", "Unsupported");
        rejects(parallel, "Unsupported flow element");
        Fixture negative = linear("negative", "Task"); set(objects(negative.r, "Task").get(0), "Time", -1.0);
        rejects(negative, "Time must be finite and nonnegative");
        Fixture missing = xor("missing-choice"); set(objects(missing.r, "ExclusiveGateway").get(0), "default", null);
        rejects(missing, "needs a default");
        Fixture language = xor("language"); set(objects(language.r, "FormalExpression").get(0), "language", "XPath");
        rejects(language, "language must be JaamSim");
        Fixture disconnected = linear("disconnected", "Task");
        EObject sf = objects(disconnected.r, "SequenceFlow").get(0); set(sf, "targetRef", null);
        rejects(disconnected, "Missing/unresolved source or target");
        Fixture script = linear("script", "ScriptTask"); set(objects(script.r, "ScriptTask").get(0), "script", "doSomething()");
        rejects(script, "Script execution is unsupported");
        Fixture duration = linear("duration", "Task");
        EObject durationStart = objects(duration.r, "StartEvent").get(0); set(durationStart, "MaxNumber", 0);
        EObject durationTimer = create(duration.p, "TimerEventDefinition");
        set(durationTimer, "timeDuration", duration.expression("PT2S")); list(durationStart, "eventDefinitions").add(durationTimer);
        String durationCfg = duration.run("duration");
        check(durationCfg.contains("FirstArrivalTime { 2.0 s }") && durationCfg.contains("MaxNumber { 1 }"), "Duration-only timer should fire once");
        Fixture bpsim = linear("bpsim", "Task");
        bpsim.r.save(Collections.emptyMap());
        Path scenarioFile=root.resolve(".build/scenario.xml");
        String xml="<BPSimData xmlns='http://www.bpsim.org/schemas/2.0'><Scenario id='baseline'><ElementParameters elementRef='Start'><ControlParameters><InterTriggerTimer><FloatingParameter value='0.1'/></InterTriggerTimer><TriggerCount><NumericParameter value='3'/></TriggerCount></ControlParameters></ElementParameters><ElementParameters elementRef='Work'><TimeParameters><ProcessingTime><FloatingParameter value='2' timeUnit='s'/></ProcessingTime></TimeParameters></ElementParameters></Scenario></BPSimData>";
        Files.writeString(scenarioFile,xml);
        Main.main(new String[]{bpsim.r.getURI().toFileString(),".build/bpsim-output",root.toString(),"60",scenarioFile.toString(),"baseline"});
        String bpsimCfg=Files.readString(root.resolve(".build/bpsim-output.cfg"));
        check(bpsimCfg.contains("InterArrivalTime { 6.0 s }"),"BPSim default unit is minutes");
        check(bpsimCfg.contains("ServiceTime { 2.0 s }"),"BPSim local unit override");
        check(bpsimCfg.contains("MaxNumber { 3 }"),"BPSim trigger count");
        Files.writeString(scenarioFile,xml.replace("value='3'","value='0'"));
        try { com.yourorg.main.BpsimInput.apply(bpsim.r,scenarioFile,root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"),"baseline"); throw new AssertionError("Zero count treated as unlimited"); }
        catch(IllegalArgumentException expected) { check(expected.getMessage().contains("zero is not unlimited"),expected.getMessage()); }
        System.out.println("PASS: " + checks + " assertions; Xtend/Java/EMFTVM compilation, both examples, subtypes, XOR, timers, names and rejection checks");
    }
}
