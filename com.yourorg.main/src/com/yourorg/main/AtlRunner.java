package com.yourorg.main;

import java.io.File;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;

public class AtlRunner {

	public static void main(String[] args) throws Exception {

		//Register XMI for all extensions
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();

		//file paths
		File bpmnEcoreFile = new File("C:\\Users\\antoine.bakhos\\eclipse-workspace\\com.yourorg.models\\model\\BPMN20.ecore");
		File jaamEcoreFile = new File("C:\\Users\\antoine.bakhos\\eclipse-workspace\\com.yourorg.models\\model\\Jaamsim.ecore");
		File inFile = new File("C:\\Users\\antoine.bakhos\\eclipse-workspace\\com.yourorg.main\\sample_in\\Definitions1.xmi");
		File outFile = new File("C:\\Users\\antoine.bakhos\\eclipse-workspace\\com.yourorg.main\\output\\JaamSimModel.xmi");

		URI bpmnEcore = URI.createFileURI(bpmnEcoreFile.getAbsolutePath());
		URI jaamEcore = URI.createFileURI(jaamEcoreFile.getAbsolutePath());
		URI bpmnIn = URI.createFileURI(inFile.getAbsolutePath());
		URI jaamOut = URI.createFileURI(outFile.getAbsolutePath());

		//Load metamodels
		Resource bpmnMMRes = rs.getResource(bpmnEcore, true);
		Resource jaamMMRes = rs.getResource(jaamEcore, true);

		//Register packages
		EPackage bpmnPkg = (EPackage) bpmnMMRes.getContents().get(0);
		rs.getPackageRegistry().put(bpmnPkg.getNsURI(), bpmnPkg);

		EPackage jaamPkg = (EPackage) jaamMMRes.getContents().get(0);
		rs.getPackageRegistry().put(jaamPkg.getNsURI(), jaamPkg);

		//Wrap metamodels for EMFTVM
		Metamodel bpmnMM = EmftvmFactory.eINSTANCE.createMetamodel();
		bpmnMM.setResource(bpmnMMRes);

		Metamodel jaamsimMM = EmftvmFactory.eINSTANCE.createMetamodel();
		jaamsimMM.setResource(jaamMMRes);

		//Input model
		Model inModel = EmftvmFactory.eINSTANCE.createModel();
		inModel.setResource(rs.getResource(bpmnIn, true));

		//Output model
		Model outModel = EmftvmFactory.eINSTANCE.createModel();
		Resource outRes = rs.createResource(jaamOut);
		outModel.setResource(outRes);

		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		env.registerMetaModel("BPMN", bpmnMM);
		env.registerMetaModel("JaamSim", jaamsimMM);
		env.registerInputModel("IN", inModel);
		env.registerOutputModel("OUT", outModel);

		//ATL Module
		File emftvmFolder = new File("C:\\Users\\antoine.bakhos\\eclipse-workspace\\com.yourorg.atl\\Rules");
		DefaultModuleResolver resolver = new DefaultModuleResolver(emftvmFolder.toURI().toString(), rs);

		env.loadModule(resolver, "Rules 2");
		env.run(null);

		outRes.save(Collections.emptyMap());
		System.out.println("ATL done: " + outFile.getAbsolutePath());
	}
}
