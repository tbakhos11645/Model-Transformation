import java.nio.file.Path;
import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;
public class GenerateBpsim {
 public static void main(String[] args) throws Exception {
  Path root=Path.of(args[0]);
  var rs=new ResourceSetImpl();
  rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",new EcoreResourceFactoryImpl());
  var out=rs.createResource(URI.createFileURI(root.resolve("com.yourorg.models/model/BPSim.ecore").toString()));
  for(Object p:new XSDEcoreBuilder().generate(URI.createFileURI(root.resolve("com.yourorg.models/model/BPSim-2.0.xsd").toString()))) out.getContents().add((EObject)p);
  out.save(Collections.emptyMap());
 }
}
