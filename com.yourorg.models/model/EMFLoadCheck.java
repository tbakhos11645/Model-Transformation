import java.io.File;
import java.util.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

public class EMFLoadCheck {
  static List<String> errors = new ArrayList<>();

  public static void main(String[] a) throws Exception {
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

    ResourceSet rs = new ResourceSetImpl();
    Resource res = rs.getResource(URI.createFileURI(new File("Jaamsim.ecore").getAbsolutePath()), true);
    res.load(Collections.emptyMap());

    EPackage pkg = (EPackage) res.getContents().get(0);
    System.out.println("Loaded package: " + pkg.getName() + " nsURI=" + pkg.getNsURI());
    int nClass = 0, nEnum = 0;
    for (EClassifier c : pkg.getEClassifiers()) {
      if (c instanceof EClass) nClass++; else if (c instanceof EEnum) nEnum++;
      // force resolution of every feature type
      if (c instanceof EClass) {
        for (EStructuralFeature f : ((EClass) c).getEStructuralFeatures()) {
          EClassifier t = f.getEType();
          if (t == null) errors.add("unresolved eType for " + c.getName() + "." + f.getName());
          if (t instanceof EEnum) {
            EEnum ee = (EEnum) t;
            if (ee.getELiterals().isEmpty()) errors.add("empty enum " + ee.getName());
          }
        }
        for (EClass sup : ((EClass) c).getESuperTypes())
          if (sup == null) errors.add("unresolved supertype of " + c.getName());
      }
    }
    System.out.println("Classifiers: " + nClass + " classes, " + nEnum + " enums");

    // ---- dynamic instantiation of a realistic pipeline instance ----
    EClass smc = (EClass) pkg.getEClassifier("SimulationModel");
    EClass ent = (EClass) pkg.getEClassifier("SimEntity");
    EClass gen = (EClass) pkg.getEClassifier("EntityGenerator");
    EClass q = (EClass) pkg.getEClassifier("Queue");
    EClass srv = (EClass) pkg.getEClassifier("Server");
    EClass conv = (EClass) pkg.getEClassifier("EntityConveyor");
    EClass sink = (EClass) pkg.getEClassifier("EntitySink");
    EClass br = (EClass) pkg.getEClassifier("Branch");

    EObject model = pkg.getEFactoryInstance().create(smc);
    model.eSet(smc.getEStructuralFeature("name"), "Ex1");

    EObject e1 = inst(ent, "name", "Entity1");
    EObject g  = inst(gen, "name", "Gen1");
    EObject qu = inst(q,   "name", "Queue1");
    EObject sv = inst(srv, "name", "Server1");
    EObject cv = inst(conv,"name", "Conveyor1");
    EObject sk = inst(sink,"name", "Sink1");
    EObject bc = inst(br,  "name", "Branch1");

    // scalar contract features (types must accept these values)
    g.eSet(gen.getEStructuralFeature("interArrivalTime"), 2.0);
    g.eSet(gen.getEStructuralFeature("entitiesPerArrival"), 1);
    g.eSet(gen.getEStructuralFeature("maxNumber"), 8);
    sv.eSet(srv.getEStructuralFeature("serviceTime"), 10.0);   // MUST be a literal double, not a ref
    cv.eSet(conv.getEStructuralFeature("travelTime"), 2.0);
    bc.eSet(br.getEStructuralFeature("choice"), "Random");
    qu.eSet(q.getEStructuralFeature("priority"), "FIFO");
    qu.eSet(q.getEStructuralFeature("match"), "none");
    qu.eSet(q.getEStructuralFeature("fifo"), Boolean.TRUE);

    // references (the exact shape ATL writes)
    EReference ents = (EReference) smc.getEStructuralFeature("entities");
    @SuppressWarnings("unchecked") List<Object> list = (List<Object>) model.eGet(ents);
    list.add(e1); list.add(g); list.add(qu); list.add(sv); list.add(cv); list.add(sk); list.add(bc);

    setRef(g, "prototype", e1);
    setRef(g, "nextComponent", qu);
    setRef(sv, "waitQueue", qu);
    setRef(sv, "nextComponent", cv);
    setRef(cv, "nextComponent", sk);
    EReference ncl = (EReference) br.getEStructuralFeature("nextComponentList");
    if (ncl == null) errors.add("Branch.nextComponentList missing");
    else { @SuppressWarnings("unchecked") List<Object> bl = (List<Object>) bc.eGet(ncl); bl.add(sk); }

    // ---- serialize to XMI and reload ----
    ResourceSet rs2 = new ResourceSetImpl();
    Resource out = rs2.createResource(URI.createFileURI(new File("roundtrip.xmi").getAbsolutePath()));
    out.getContents().add(model);
    out.save(Collections.emptyMap());

    ResourceSet rs3 = new ResourceSetImpl();
    rs3.getPackageRegistry().put(pkg.getNsURI(), pkg);
    Resource in = rs3.getResource(URI.createFileURI(new File("roundtrip.xmi").getAbsolutePath()), true);
    in.load(Collections.emptyMap());
    EObject reloaded = in.getContents().get(0);
    List<?> rl = (List<?>) reloaded.eGet(reloaded.eClass().getEStructuralFeature("entities"));
    System.out.println("Round-trip entities: " + rl.size());

    System.out.println(errors.isEmpty() ? "EMF LOAD + ROUND-TRIP OK" : "EMF ERRORS:");
    errors.forEach(e -> System.out.println("  - " + e));
  }

  static EObject inst(EClass c, String f, Object v) {
    EObject o = c.getEPackage().getEFactoryInstance().create(c);
    o.eSet(c.getEStructuralFeature(f), v);
    return o;
  }
  static void setRef(EObject o, String f, EObject target) {
    EStructuralFeature sf = o.eClass().getEStructuralFeature(f);
    if (sf == null) errors.add(o.eClass().getName() + "." + f + " missing");
    else o.eSet(sf, target);
  }
}
