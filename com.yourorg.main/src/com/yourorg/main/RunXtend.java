package com.yourorg.main;

import java.nio.file.Files;
import java.nio.file.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import com.your.m2t.M2T;

/** Usage: RunXtend input.jaamsim.xmi output.cfg [repository-root]. */
public class RunXtend {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) throw new IllegalArgumentException("Usage: RunXtend input.xmi output.cfg [repository-root]");
        Path root = Main.repository(args);
        ResourceSet rs = Main.resourceSet(root);
        Resource model = rs.getResource(Main.uri(root.resolve(args[0])), true);
        Path output = root.resolve(args[1]).toAbsolutePath().normalize();
        Files.createDirectories(output.getParent());
        new M2T().exportToConfig(model, Main.uri(output));
        System.out.println("CFG generated: " + output);
    }
}
