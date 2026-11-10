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
        Fixture defaults=linear("legacy-defaults","Task");
        EObject defaultStart=objects(defaults.r,"StartEvent").get(0);
        BpmnPreflight.validateAndNormalize(defaults.r);
        check(BpmnPreflight.get(defaultStart,"InterArrivalTime").equals(1.0) && BpmnPreflight.get(defaultStart,"EntitiesPerArrival").equals(1),"Legacy defaults normalized before ATL");
        BpmnPreflight.validateAndNormalize(defaults.r);
        check(BpmnPreflight.get(defaultStart,"InterArrivalTime").equals(1.0),"Normalization is idempotent for none starts");
        Fixture explicitZero=linear("legacy-zero","Task");
        EObject zeroStart=objects(explicitZero.r,"StartEvent").get(0);
        set(zeroStart,"InterArrivalTime",0.0); set(zeroStart,"EntitiesPerArrival",0);
        BpmnPreflight.validateAndNormalize(explicitZero.r);
        check(BpmnPreflight.get(zeroStart,"InterArrivalTime").equals(1.0) && BpmnPreflight.get(zeroStart,"EntitiesPerArrival").equals(1),"Documented zero/unset legacy policy");
        Fixture badStart=linear("bad-start","Task");
        EObject bad=objects(badStart.r,"StartEvent").get(0); set(bad,"EntitiesPerArrival",-1);
        rejects(badStart,"EntitiesPerArrival must be finite and nonnegative");
        check(BpmnPreflight.get(bad,"InterArrivalTime").equals(0.0),"Failed preflight does not apply staged defaults");
        Fixture chain=new Fixture("topology-consecutive");
        EObject cStart=chain.node("StartEvent","Start"), work1=chain.node("Task","Work1"), work2=chain.node("Task","Work2"), cEnd=chain.node("EndEvent","End");
        set(cStart,"FirstArrivalTime",10.0);set(cStart,"InterArrivalTime",10.0);set(work1,"Time",2.0);set(work2,"Time",3.0);
        chain.flow(cStart,work1,"First");chain.flow(work1,work2,"Between");chain.flow(work2,cEnd,"Last");
        String chainCfg=chain.run("topology-consecutive"); cfgReferences(chainCfg);
        check(chainCfg.contains("Work1 NextComponent { Conveyor_Between }") && chainCfg.contains("Conveyor_Between NextComponent { Queue_Work2 }") && chainCfg.contains("Work2 WaitQueue { Queue_Work2 }"),"Consecutive tasks route through the second queue");
        Fixture processes=new Fixture("topology-processes");
        for(String suffix:List.of("A","B")) {
            if(suffix.equals("B")){processes.process=create(processes.p,"Process");list(processes.r.getContents().get(0),"rootElements").add(processes.process);}
            EObject s=processes.node("StartEvent","Start"+suffix), w=processes.node("Task","Work"+suffix), e=processes.node("EndEvent","End"+suffix);
            set(w,"Time",suffix.equals("A")?1.0:2.0);
            processes.flow(s,w,"In"+suffix);processes.flow(w,e,"Out"+suffix);
        }
        String processCfg=processes.run("topology-processes"); cfgReferences(processCfg);
        Resource processOut=Main.resourceSet(root).getResource(Main.uri(root.resolve(".build/topology-processes.jaamsim.xmi")),true);
        check(objects(processOut,"SimulationModel").size()==1 && objects(processOut,"Server").size()==2 && objects(processOut,"EntityGenerator").size()==2,"Multiple processes are contained in one simulation");
        check(processCfg.contains("Conveyor_OutA NextComponent { EndA }") && processCfg.contains("Conveyor_OutB NextComponent { EndB }"),"Independent process destinations preserved");
        Path fourth=root.resolve("com.yourorg.main/sample_in/fourth-bpsim-test.xmi");
        Path fourthScenario=root.resolve("com.yourorg.main/sample_in/fourth-bpsim-test.bpsim.xml");
        Resource mergeInput=Main.resourceSet(root).getResource(Main.uri(fourth),true);
        EObject mergeGateway=objects(mergeInput,"ExclusiveGateway").get(0);
        check(list(mergeGateway,"incoming").size()==2,"Merge fixture has two inputs");
        set(mergeGateway,"Choice","999");
        com.yourorg.main.BpsimInput.apply(mergeInput,fourthScenario,root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"),"merge");
        check(BpmnPreflight.get(mergeGateway,"Choice").equals("1"),"BPSim merge overrides stale legacy Choice");
        Main.main(new String[]{fourth.toString(),".build/fourth-bpsim-test",root.toString(),"60",fourthScenario.toString(),"merge"});
        String fourthCfg=Files.readString(root.resolve(".build/fourth-bpsim-test.cfg"));cfgReferences(fourthCfg);
        check(fourthCfg.contains("Merge Choice { '1' }") && fourthCfg.contains("Conveyor_ToWork NextComponent { Queue_Work }"),"BPSim merge routes to task queue");
        Resource conditionalMerge=Main.resourceSet(root).getResource(Main.uri(fourth),true);
        EObject conditionalGateway=objects(conditionalMerge,"ExclusiveGateway").get(0);
        set(list(conditionalGateway,"outgoing").get(0),"conditionExpression",create(conditionalGateway.eClass().getEPackage(),"FormalExpression"));
        try {com.yourorg.main.BpsimInput.apply(conditionalMerge,fourthScenario,root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"),"merge");throw new AssertionError("Accepted conditional BPSim merge");}
        catch(IllegalArgumentException expected){check(expected.getMessage().contains("must not have a condition"),expected.getMessage());}
        check(BpmnPreflight.get(objects(conditionalMerge,"StartEvent").get(0),"InterArrivalTime").equals(0.0),"Rejected BPSim merge does not apply staged arrivals");
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
            check(cfg.contains("Start Position { 0.0 0.0 0.0 m }") && cfg.contains("Queue_Work Position { 6.0 0.0 0.0 m }")
                && cfg.contains("Simulation_2 Position { 9.0 0.0 0.0 m }") && cfg.contains("End Position { 15.0 0.0 0.0 m }"), "Layout follows execution including queue/server link");
            check(cfg.contains("Conveyor_toWork Points { { 0.0 0.0 0.0 m } { 3.0 0.0 0.0 m } { 6.0 0.0 0.0 m } }")
                && cfg.contains("Conveyor_toEnd Points { { 9.0 0.0 0.0 m } { 12.0 0.0 0.0 m } { 15.0 0.0 0.0 m } }"), "Conveyors join actual source and destination positions");
            check(cfg.contains("Simulation ShowEntityFlow { TRUE }"), "Show logical flow connections");
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
        set(objects(merge.r,"SequenceFlow").stream().filter(e->"merged".equals(BpmnPreflight.get(e,"id"))).findFirst().orElseThrow(),"conditionExpression",merge.expression("false"));
        rejects(merge,"Single-output XOR must not have a condition");
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
        String settingsXml=xml.replace("<Scenario id='baseline'>", "<Scenario id='baseline'><ScenarioParameters><Duration><FloatingParameter value='0.5'/></Duration><Warmup><DurationParameter value='PT9S'/></Warmup></ScenarioParameters>");
        Files.writeString(scenarioFile,settingsXml);
        Main.main(new String[]{bpsim.r.getURI().toFileString(),".build/scenario-settings",root.toString(),"60",scenarioFile.toString(),"baseline"});
        String settingsCfg=Files.readString(root.resolve(".build/scenario-settings.cfg"));
        check(settingsCfg.contains("RunDuration { 21.0 s }") && settingsCfg.contains("InitializationDuration { 9.0 s }"),"Scenario duration overrides CLI, includes warmup, and honors default minutes");
        var settings=com.yourorg.main.BpsimInput.apply(bpsim.r,scenarioFile,root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"),"baseline");
        check(settings.runSeconds(60)==21 && settings.warmupSeconds()==9,"Structured scenario settings");
        Files.writeString(scenarioFile,settingsXml.replace("<Duration><FloatingParameter value='0.5'/></Duration>",""));
        settings=com.yourorg.main.BpsimInput.apply(bpsim.r,scenarioFile,root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"),"baseline");
        check(settings.durationSeconds()==null && settings.runSeconds(60)==51,"Missing scenario Duration uses CLI total including warmup");
        try { settings.runSeconds(9); throw new AssertionError("Accepted warmup equal to fallback total"); }
        catch(IllegalArgumentException expected){check(expected.getMessage().contains("greater than Warmup"),expected.getMessage());}
        Files.writeString(scenarioFile,settingsXml.replace("PT9S","PT0S"));
        settings=com.yourorg.main.BpsimInput.apply(bpsim.r,scenarioFile,root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"),"baseline");
        check(settings.runSeconds(60)==30 && settings.warmupSeconds()==0,"Explicit zero warmup");
        for(String invalid : List.of(settingsXml.replace("value='0.5'","value='0'"),settingsXml.replace("PT9S","PT30S"),settingsXml.replace("PT9S","PT31S"),settingsXml.replace("PT9S","-PT1S"))) {
            Files.writeString(scenarioFile,invalid);
            try { Main.main(new String[]{bpsim.r.getURI().toFileString(),".build/scenario-settings",root.toString(),"60",scenarioFile.toString(),"baseline"}); throw new AssertionError("Accepted invalid Duration/Warmup"); }
            catch(IllegalArgumentException expected){check(settingsCfg.equals(Files.readString(root.resolve(".build/scenario-settings.cfg"))),"Invalid settings preserve prior CFG");}
        }
        String replicated=xml.replace("<Scenario id='baseline'>","<Scenario id='baseline'><ScenarioParameters seed='41' replication='3'/>");
        Files.writeString(scenarioFile,replicated);
        String[] replicationArgs={bpsim.r.getURI().toFileString(),".build/replication-check",root.toString(),"60",scenarioFile.toString(),"baseline"};
        Main.main(replicationArgs);
        List<String> saved=new ArrayList<>();
        for(int i=0;i<3;i++) {
            String suffix=i==0?"":String.format(java.util.Locale.ROOT,"-replication-%03d",i+1);
            String cfg=Files.readString(root.resolve(".build/replication-check"+suffix+".cfg"));
            check(cfg.contains("GlobalSubstreamSeed { "+(41+i)+" }"),"Distinct replication seeds");
            Resource runModel=Main.resourceSet(root).getResource(Main.uri(root.resolve(".build/replication-check"+suffix+".jaamsim.xmi")),true);
            check(((Number)BpmnPreflight.get(objects(runModel,"Simulation").get(0),"globalSubstreamSeed")).intValue()==41+i,"XMI seed matches CFG");
            saved.add(cfg);
        }
        check(Files.readAllLines(root.resolve(".build/replication-check.runs.txt")).size()==4,"Exactly three manifest entries");
        Main.main(replicationArgs);
        for(int i=0;i<3;i++)check(saved.get(i).equals(Files.readString(root.resolve(".build/replication-check"+(i==0?"":String.format(java.util.Locale.ROOT,"-replication-%03d",i+1))+".cfg"))),"Repeat export is deterministic");
        for(String attributes:List.of("seed='-1'","seed='2147483648'","seed='9223372036854775807'","seed='2147483647' replication='2'","replication='0'","replication='-1'","replication='1001'")) {
            Files.writeString(scenarioFile,xml.replace("<Scenario id='baseline'>","<Scenario id='baseline'><ScenarioParameters "+attributes+"/>"));
            try { Main.main(replicationArgs); throw new AssertionError("Accepted invalid seed/replication: "+attributes); }
            catch(IllegalArgumentException expected){check(saved.get(0).equals(Files.readString(root.resolve(".build/replication-check.cfg"))),"Invalid seed/count preserves existing CFG");}
        }
        for(String attributes:List.of("seed='0'","seed='2147483647'","")) {
            Files.writeString(scenarioFile,xml.replace("<Scenario id='baseline'>","<Scenario id='baseline'><ScenarioParameters "+attributes+"/>"));
            var parsed=com.yourorg.main.BpsimInput.apply(bpsim.r,scenarioFile,root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"),"baseline");
            check(parsed.seed()==(attributes.isEmpty()?1:attributes.contains("2147483647")?Integer.MAX_VALUE:0) && parsed.replications()==1,"Seed boundaries and default replication");
        }
        Main.main(replicationArgs);
        check(Files.readAllLines(root.resolve(".build/replication-check.runs.txt")).size()==2,"Reducing replications replaces run list; stale outputs excluded");
        check(Files.exists(root.resolve(".build/replication-check-replication-003.cfg")),"Do not delete old potentially edited outputs");
        Files.writeString(scenarioFile,xml.replace("value='3'","value='0'"));
        try { com.yourorg.main.BpsimInput.apply(bpsim.r,scenarioFile,root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"),"baseline"); throw new AssertionError("Zero count treated as unlimited"); }
        catch(IllegalArgumentException expected) { check(expected.getMessage().contains("zero is not unlimited"),expected.getMessage()); }
        Files.writeString(scenarioFile,xml.replace("value='0.1'","value='0'"));
        try {com.yourorg.main.BpsimInput.apply(bpsim.r,scenarioFile,root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"),"baseline");throw new AssertionError("Zero BPSim interval defaulted to one");}
        catch(IllegalArgumentException expected){check(expected.getMessage().contains("Instantaneous BPSim arrivals"),expected.getMessage());}
        Fixture split=xor("bpsim-split");
        Files.writeString(scenarioFile,xml.replace("<ElementParameters elementRef='Work'><TimeParameters><ProcessingTime><FloatingParameter value='2' timeUnit='s'/></ProcessingTime></TimeParameters></ElementParameters>",""));
        try {com.yourorg.main.BpsimInput.apply(split.r,scenarioFile,root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"),"baseline");throw new AssertionError("Accepted BPSim split");}
        catch(IllegalArgumentException expected){check(expected.getMessage().contains("XOR splits are not executable"),expected.getMessage());}
        check(BpmnPreflight.get(objects(split.r,"StartEvent").get(0),"InterArrivalTime").equals(0.0),"Rejected split preserves source arrivals");
        System.out.println("PASS: " + checks + " assertions; Xtend/Java/EMFTVM compilation, examples, topology, subtypes, XOR, timers, names and rejection checks");
    }
}
