import java.nio.file.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.util.*;

public class ValidateEcore {
  public static void main(String[] a) throws Exception {
    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = db.parse(Paths.get("Jaamsim.ecore").toFile());

    NodeList enums = doc.getElementsByTagName("eClassifiers");
    Set<String> names = new LinkedHashSet<>();
    Set<String> classNames = new LinkedHashSet<>();
    Set<String> enumNames = new LinkedHashSet<>();
    List<String> errors = new ArrayList<>();
    List<Element> classEls = new ArrayList<>();

    for (int i = 0; i < enums.getLength(); i++) {
      Element e = (Element) enums.item(i);
      String n = e.getAttribute("name");
      String t = e.getAttribute("xsi:type");
      if (!names.add(n)) errors.add("duplicate classifier: " + n);
      if (t.endsWith("EClass")) classNames.add(n);
      else enumNames.add(n);
      if (t.endsWith("EClass")) classEls.add(e);
    }

    // supertype + reference integrity
    for (Element c : classEls) {
      String cn = c.getAttribute("name");
      String sup = c.getAttribute("eSuperTypes");
      if (!sup.isEmpty()) {
        String target = sup.replace("#//", "");
        if (!classNames.contains(target)) errors.add(cn + ": bad eSuperTypes " + target);
      }
      NodeList feats = c.getElementsByTagName("eStructuralFeatures");
      Set<String> featNames = new HashSet<>();
      for (int j = 0; j < feats.getLength(); j++) {
        Element f = (Element) feats.item(j);
        String fn = f.getAttribute("name");
        if (!featNames.add(fn)) errors.add(cn + ": duplicate feature " + fn);
        String ft = f.getAttribute("xsi:type");
        String et = f.getAttribute("eType");
        if (et.contains("undefined")) errors.add(cn + "." + fn + ": undefined eType");
        if (ft.endsWith("EReference")) {
          String target = et.replace("#//", "");
          if (!classNames.contains(target)) errors.add(cn + "." + fn + ": bad reference target " + target);
        } else if (et.startsWith("#//")) {
          String target = et.replace("#//", "");
          if (!enumNames.contains(target)) errors.add(cn + "." + fn + ": bad enum target " + target);
        }
      }
    }

    // inherited feature name collision check (EMF forbids same feature name in super/sub)
    Map<String,Set<String>> featsOf = new HashMap<>();
    Map<String,String> supOf = new HashMap<>();
    for (Element c : classEls) {
      String cn = c.getAttribute("name");
      Set<String> fs = new HashSet<>();
      NodeList feats = c.getElementsByTagName("eStructuralFeatures");
      for (int j = 0; j < feats.getLength(); j++) fs.add(((Element) feats.item(j)).getAttribute("name"));
      featsOf.put(cn, fs);
      supOf.put(cn, c.getAttribute("eSuperTypes").replace("#//", ""));
    }
    for (String cn : classNames) {
      String sup = supOf.get(cn);
      while (sup != null && !sup.isEmpty()) {
        for (String f : featsOf.get(cn)) if (featsOf.getOrDefault(sup, Set.of()).contains(f))
          errors.add(cn + ": feature '" + f + "' collides with supertype " + sup);
        sup = supOf.getOrDefault(sup, "");
      }
    }

    // pipeline contract: classes consumed by ATL/M2T must exist
    String[] required = {"SimEntity","EntityGenerator","EntityConveyor","EntitySink","Queue","Server","Branch","SimulationModel","Entity","Simulation"};
    for (String r : required) if (!classNames.contains(r)) errors.add("MISSING pipeline class: " + r);

    // ---- genmodel cross-check ----
    Document gm = db.parse(Paths.get("Jaamsim.genmodel").toFile());
    Map<String,Set<String>> attrOf = new HashMap<>();
    for (Element c : classEls) {
      Set<String> fs = new HashSet<>();
      NodeList feats = c.getElementsByTagName("eStructuralFeatures");
      for (int j = 0; j < feats.getLength(); j++) fs.add(((Element) feats.item(j)).getAttribute("name"));
      attrOf.put(c.getAttribute("name"), fs);
    }
    NodeList gc = gm.getElementsByTagName("genClasses");
    Set<String> gmClasses = new HashSet<>();
    for (int i = 0; i < gc.getLength(); i++) {
      String ref = ((Element) gc.item(i)).getAttribute("ecoreClass"); // Jaamsim.ecore#//X
      String cn = ref.substring(ref.lastIndexOf("//") + 2);
      gmClasses.add(cn);
      if (!classNames.contains(cn)) errors.add("genmodel genClasses for unknown class " + cn);
    }
    for (String cn : classNames) if (!gmClasses.contains(cn)) errors.add("genmodel missing genClasses for " + cn);
    NodeList gfeat = gm.getElementsByTagName("genFeatures");
    for (int i = 0; i < gfeat.getLength(); i++) {
      String ref = ((Element) gfeat.item(i)).getAttribute("ecoreFeature"); // ecore:EAttribute Jaamsim.ecore#//Cls/feat
      String tail = ref.substring(ref.lastIndexOf("//") + 2);
      int slash = tail.lastIndexOf('/');
      String cn = tail.substring(0, slash), fn = tail.substring(slash + 1);
      if (!attrOf.getOrDefault(cn, Set.of()).contains(fn)) errors.add("genmodel genFeatures unknown feature " + cn + "." + fn);
    }
    NodeList genums = gm.getElementsByTagName("genEnums");
    for (int i = 0; i < genums.getLength(); i++) {
      String ref = ((Element) genums.item(i)).getAttribute("ecoreEnum");
      String en = ref.substring(ref.lastIndexOf("//") + 2);
      if (!enumNames.contains(en)) errors.add("genmodel genEnums unknown enum " + en);
    }

    System.out.println("Classes: " + classNames.size() + ", Enums: " + enumNames.size() + ", genClasses: " + gmClasses.size());
    if (errors.isEmpty()) System.out.println("VALIDATION OK");
    else { System.out.println("VALIDATION ERRORS:"); errors.forEach(e -> System.out.println("  - " + e)); }
  }
}
