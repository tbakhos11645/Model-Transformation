package com.yourorg.main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import com.your.m2t.M2T;

/** Usage: Main input.xmi output-prefix repository-root run-seconds [bpsim.xml scenario-id]. */
public class Main {
    public static URI uri(Path path) { return URI.createFileURI(path.toAbsolutePath().normalize().toString()); }
    public static Path repository(String[] args) {
        Path root = args.length > 2 ? Path.of(args[2]) : Path.of(System.getProperty("user.dir"));
        root = root.toAbsolutePath().normalize();
        while (root != null && !Files.isDirectory(root.resolve("com.yourorg.models/model"))) root = root.getParent();
        if (root == null) throw new IllegalArgumentException("Set repository-root (third argument) to the Git checkout");
        return root;
    }
    public static ResourceSet resourceSet(Path root) {
        ResourceSet rs = new ResourceSetImpl();
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emftvm", new org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
        // Both models deliberately use dynamic packages from this checkout, not stale generated Java.
        for (String name : new String[]{"DC", "DI", "BPMNDI", "BPMN20", "Jaamsim"}) {
            Resource mm = rs.getResource(uri(root.resolve("com.yourorg.models/model/" + name + ".ecore")), true);
            for (EObject object : mm.getContents()) if (object instanceof EPackage) {
                EPackage pkg = (EPackage) object;
                rs.getPackageRegistry().put(pkg.getNsURI(), pkg);
            }
        }
        return rs;
    }
    public static void main(String[] args) throws Exception {
        Path root = repository(args);
        Path input = args.length > 0 ? root.resolve(args[0]) : root.resolve("com.yourorg.main/sample_in/Ex1_BPMN.xmi");
        Path prefix = args.length > 1 ? root.resolve(args[1]) : root.resolve("com.yourorg.main/out/sample");
        prefix = prefix.toAbsolutePath().normalize();
        double runSeconds = args.length > 3 ? Double.parseDouble(args[3]) : 3600.0;
        if (!Double.isFinite(runSeconds) || runSeconds <= 0) throw new IllegalArgumentException("run-seconds must be positive and finite");
        ResourceSet rs = resourceSet(root);
        Resource inRes = rs.getResource(uri(input), true);
        if (args.length == 5) throw new IllegalArgumentException("BPSim file requires a sixth argument: scenario id");
        double warmupSeconds = 0;
        int seed = 1, replications = 1;
        if (args.length > 5) {
            var settings = BpsimInput.apply(inRes, root.resolve(args[4]), root.resolve("com.yourorg.models/model/BPSim-2.0.xsd"), args[5]);
            runSeconds = settings.runSeconds(runSeconds);
            warmupSeconds = settings.warmupSeconds();
            seed = settings.seed();
            replications = settings.replications();
            System.out.println("BPSim scenario " + args[5] + ": total=" + (runSeconds + warmupSeconds)
                + " s, warmup=" + warmupSeconds + " s, measurement=" + runSeconds + " s"
                + (settings.durationSeconds() == null ? " (command-line/default duration)" : " (scenario Duration takes precedence)"));
        }
        BpmnPreflight.validateAndNormalize(inRes);
        Metamodel bpmnMM = EmftvmFactory.eINSTANCE.createMetamodel();
        bpmnMM.setResource(rs.getResource(uri(root.resolve("com.yourorg.models/model/BPMN20.ecore")), true));
        Metamodel jaamsimMM = EmftvmFactory.eINSTANCE.createMetamodel();
        jaamsimMM.setResource(rs.getResource(uri(root.resolve("com.yourorg.models/model/Jaamsim.ecore")), true));
        Model inModel = EmftvmFactory.eINSTANCE.createModel();
        inModel.setResource(inRes);
        Resource outRes = rs.createResource(uri(Path.of(prefix + ".jaamsim.xmi")));
        Model outModel = EmftvmFactory.eINSTANCE.createModel();
        outModel.setResource(outRes);
        ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
        env.registerMetaModel("BPMN", bpmnMM);
        env.registerMetaModel("Jaamsim", jaamsimMM);
        env.registerInputModel("IN", inModel);
        env.registerOutputModel("OUT", outModel);
        Path rules = root.resolve("com.yourorg.atl/Rules");
        if (!Files.isRegularFile(rules.resolve("Rules.emftvm"))
            || Files.getLastModifiedTime(rules.resolve("Rules.atl")).compareTo(Files.getLastModifiedTime(rules.resolve("Rules.emftvm"))) > 0)
            throw new IllegalStateException("Build Rules.atl with the Eclipse EMFTVM compiler first");
        env.loadModule(new DefaultModuleResolver(rules.toUri().toString(), rs), "Rules");
        env.run(null);
        if (outRes.getContents().size() != 1) throw new IllegalStateException("ATL did not produce one SimulationModel root");
        EObject simulationModel = outRes.getContents().get(0);
        EPackage pkg = simulationModel.eClass().getEPackage();
        EObject simulation = pkg.getEFactoryInstance().create((org.eclipse.emf.ecore.EClass) pkg.getEClassifier("Simulation"));
        simulation.eSet(simulation.eClass().getEStructuralFeature("runDuration"), runSeconds);
        simulation.eSet(simulation.eClass().getEStructuralFeature("initializationDuration"), warmupSeconds);
        simulationModel.eSet(simulationModel.eClass().getEStructuralFeature("simulation"), simulation);
        Files.createDirectories(prefix.getParent());
        StringBuilder runs = new StringBuilder("# Generated replication files; execute each CFG once. Only entries in this list belong to this export.\n");
        for (int i = 0; i < replications; i++) {
            String runPrefix = prefix + (i == 0 ? "" : String.format(java.util.Locale.ROOT, "-replication-%03d", i + 1));
            simulation.eSet(simulation.eClass().getEStructuralFeature("globalSubstreamSeed"), seed + i);
            outRes.setURI(uri(Path.of(runPrefix + ".jaamsim.xmi")));
            new M2T().exportToConfig(outRes, uri(Path.of(runPrefix + ".cfg")));
            outRes.save(Collections.emptyMap());
            runs.append(i + 1).append('\t').append(seed + i).append('\t').append(runPrefix).append(".cfg\n");
            System.out.println("Replication " + (i + 1) + "/" + replications + ", seed=" + (seed + i) + "\nCFG: " + runPrefix + ".cfg");
        }
        // Always replace the list, even when reducing replication count; never delete user-edited old CFGs.
        Files.writeString(Path.of(prefix + ".runs.txt"), runs.toString());
    }
}

