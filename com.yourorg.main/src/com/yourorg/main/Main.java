package com.yourorg.main;

import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import com.your.m2t.M2T; //Xtend exporter

public class Main {

	public static void main(String[] args) throws Exception {

		// 1) Register XMI support
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

		// 2) Paths
		URI bpmnIn = URI.createPlatformResourceURI("/com.yourorg.main/sample_in/Definitions.xmi", true);

		URI jaamsimOut = URI.createPlatformResourceURI("/com.yourorg.main/out/sample.jaamsim.xmi", true);

		URI cfgOut = URI.createPlatformResourceURI("/com.yourorg.main/out/sample.cfg", true);

		// 3) EMF ResourceSet
		ResourceSet rs = new ResourceSetImpl();

		// 4) Load metamodels
		URI bpmnEcore = URI.createURI(
		  "platform:/plugin/com.yourorg.models/model/BPMN20.ecore");

		URI jaamsimEcore = URI.createURI(
		  "platform:/plugin/com.yourorg.models/model/Jaamsim.ecore");

		Metamodel bpmnMM = EmftvmFactory.eINSTANCE.createMetamodel();
		bpmnMM.setResource(rs.getResource(bpmnEcore, true));

		Metamodel jaamsimMM = EmftvmFactory.eINSTANCE.createMetamodel();
		jaamsimMM.setResource(rs.getResource(jaamsimEcore, true));


		// 5) Load BPMN model
		Model inModel = EmftvmFactory.eINSTANCE.createModel();
		Resource inRes = rs.getResource(bpmnIn, true);
		inModel.setResource(inRes);

		// 6) Create output model resource
		Model outModel = EmftvmFactory.eINSTANCE.createModel();
		Resource outRes = rs.createResource(jaamsimOut);
		outModel.setResource(outRes);

		// 7) Run ATL (EMFTVM)
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		env.registerMetaModel("BPMN", bpmnMM);
		env.registerMetaModel("JaamSim", jaamsimMM);
		env.registerInputModel("IN", inModel);
		env.registerOutputModel("OUT", outModel);

		// ATL module location
		DefaultModuleResolver resolver = new DefaultModuleResolver("platform:/resource/com.yourorg.atl/Rules/", rs);

		env.loadModule(resolver, "Rules");
		env.run(null);

		// Save JaamSim XMI
		outRes.save(Collections.emptyMap());

		// 8) Call Xtend
		new M2T().exportToConfig(outRes, cfgOut);

		System.out.println("Done.\nJaamSim XMI: " + jaamsimOut + "\nCFG: " + cfgOut);
	}
}