package com.yourorg.main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import jaamsim.JaamsimPackage;
import com.your.m2t.M2T;

public class RunXtend {

	public static void main(String[] args) throws Exception {

		// 1) Input XMI
		File inFile = new File(
				"C:\\Users\\antoine.bakhos\\Desktop\\Out\\SimulationModel.xmi");

		// 2) Output CFG file
		Path outFile = Path
				.of("C:\\Users\\antoine.bakhos\\Desktop\\Out\\SimulationModel.cfg");

		// Ensure output directory exists
		Files.createDirectories(outFile.getParent());

		// 3) Register XMI factory
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		// 4) Register JaamSim metamodel (generated EPackage)
		EPackage.Registry.INSTANCE.put(JaamsimPackage.eNS_URI, JaamsimPackage.eINSTANCE);

		// 5) Load the XMI model
		ResourceSet rs = new ResourceSetImpl();
		URI inUri = URI.createFileURI(inFile.getAbsolutePath());
		Resource r = rs.getResource(inUri, true);
		r.load(null);

		if (r.getContents().isEmpty()) {
			throw new IllegalStateException("Loaded resource has no root object: " + inUri);
		}

		// test print
		System.out.println("Root EClass: " + r.getContents().get(0).eClass().getName());
		System.out.println("Root Java class: " + r.getContents().get(0).getClass().getName());

		// 6) Call your Xtend M2T
		M2T gen = new M2T();
		URI outUri = URI.createFileURI(outFile.toAbsolutePath().toString());
		gen.exportToConfig(r, outUri);

		System.out.println("CFG generated: " + outFile);
	}
}
