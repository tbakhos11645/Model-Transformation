package com.yourorg.main;

import java.nio.file.Path;
import java.util.*;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/** Strict constant-parameter BPSim adapter. Never evaluates vendor expressions as XPath. */
public final class BpsimInput {
 private static final String NS="http://www.bpsim.org/schemas/2.0";
 private BpsimInput() {}
 /** Total BPSim duration includes warmup; JaamSim RunDuration excludes it. */
 public record ScenarioSettings(Double durationSeconds, double warmupSeconds, int seed, int replications) {
  public double runSeconds(double fallbackTotalSeconds) {
   double total=durationSeconds==null?fallbackTotalSeconds:durationSeconds;
   if(!Double.isFinite(total)||total<=0||warmupSeconds>=total)
    throw new IllegalArgumentException("BPSim Duration must be positive and greater than Warmup");
   return total-warmupSeconds;
  }
 }
 static List<Element> children(Element e) {
  List<Element> out=new ArrayList<>();
  for(Node n=e.getFirstChild();n!=null;n=n.getNextSibling()) if(n instanceof Element) out.add((Element)n);
  return out;
 }
 static void allowed(Element e, String... names) {
  Set<String> set=Set.of(names);
  for(Element c:children(e)) if(!NS.equals(c.getNamespaceURI()) || !set.contains(c.getLocalName())) throw new IllegalArgumentException("Unsupported BPSim execution feature: "+c.getTagName());
 }
 static double factor(String unit) {
  return switch(unit) {case "ms"->.001; case "s"->1; case "min"->60; case "hour"->3600; case "day"->86400; default->throw new IllegalArgumentException("Unsupported time unit: "+unit);};
 }
 static double value(Element parameter,String base,boolean count) {
  var values=children(parameter);
  if(values.size()!=1) throw new IllegalArgumentException("Exactly one constant value is supported: "+parameter.getTagName());
  Element v=values.get(0);
  if(v.hasAttribute("validFor")||v.hasAttribute("result")||v.hasAttribute("instance")||v.hasAttribute("resultTimeStamp")) throw new IllegalArgumentException("Calendar/result values are not executable yet");
  String type=v.getLocalName();
  double x;
  if(type.equals("DurationParameter")&&!count) x=java.time.Duration.parse(v.getAttribute("value")).toNanos()/1e9;
  else {
   if(!(type.equals("NumericParameter")||(!count&&type.equals("FloatingParameter")))) throw new IllegalArgumentException("Unsupported constant type: "+type);
   x=Double.parseDouble(v.getAttribute("value"));
   if(!count) x*=factor(v.hasAttribute("timeUnit")?v.getAttribute("timeUnit"):base);
  }
  if(!Double.isFinite(x)||x<0) throw new IllegalArgumentException("Parameter must be finite and nonnegative");
  return x;
 }
 static double probability(Element parameter) {
  var values=children(parameter);
  if(values.size()!=1) throw new IllegalArgumentException("Probability requires exactly one constant");
  Element v=values.get(0);
  if(v.hasAttribute("timeUnit") || !Set.of("NumericParameter","FloatingParameter").contains(v.getLocalName()))
   throw new IllegalArgumentException("Probability requires a dimensionless numeric or floating constant");
  double p=value(parameter,"s",false);
  if(p>1) throw new IllegalArgumentException("Probability must be between 0 and 1");
  return p;
 }
 public static ScenarioSettings apply(Resource bpmn,Path xml,Path schema,String scenarioId) throws Exception {
  var sf=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
  sf.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD,""); sf.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA,"");
  var factory=DocumentBuilderFactory.newInstance(); factory.setNamespaceAware(true);
  factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl",true);
  factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD,""); factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA,"");
  var schemaModel=sf.newSchema(schema.toFile());
  var builder=factory.newDocumentBuilder();
  builder.setErrorHandler(new org.xml.sax.helpers.DefaultHandler(){public void error(org.xml.sax.SAXParseException e)throws org.xml.sax.SAXException{throw e;} public void fatalError(org.xml.sax.SAXParseException e)throws org.xml.sax.SAXException{throw e;}});
  Element document=builder.parse(xml.toFile()).getDocumentElement();
  schemaModel.newValidator().validate(new javax.xml.transform.dom.DOMSource(document));
  if(!NS.equals(document.getNamespaceURI())||!"BPSimData".equals(document.getLocalName())) throw new IllegalArgumentException("Expected BPSim 2.0 BPSimData");
  Element selected=null;
  for(Element s:children(document)) if(s.getAttribute("id").equals(scenarioId)) selected=s;
  if(selected==null) throw new IllegalArgumentException("Unknown scenario: "+scenarioId);
  if(selected.hasAttribute("inherits")||selected.hasAttribute("result")) throw new IllegalArgumentException("Inherited/result scenarios are not executable yet");
  allowed(selected,"ScenarioParameters","ElementParameters");
  String base="min";
  Double duration=null;
  double warmup=0;
  long seed=1;
  int replications=1;
  for(Element s:children(selected)) if(s.getLocalName().equals("ScenarioParameters")) {
   allowed(s,"Duration","Warmup");
   for(int i=0;i<s.getAttributes().getLength();i++) {
    String a=s.getAttributes().item(i).getNodeName();
    if(!Set.of("baseTimeUnit","seed","replication").contains(a)&&!a.startsWith("xmlns")) throw new IllegalArgumentException("Scenario setting not executable yet: "+a);
   }
   if(s.hasAttribute("baseTimeUnit")) base=s.getAttribute("baseTimeUnit");
   if(s.hasAttribute("seed")) seed=Long.parseLong(s.getAttribute("seed").trim());
   if(s.hasAttribute("replication")) replications=Integer.parseInt(s.getAttribute("replication").trim());
   for(Element p:children(s)) {
    double seconds=value(p,base,false);
    if(p.getLocalName().equals("Duration")) duration=seconds; else warmup=seconds;
   }
  }
  // Bound export fan-out and reject lossy long-to-int conversion for the target.
  if(replications<1||replications>1000) throw new IllegalArgumentException("Supported replication count is 1..1000");
  if(seed<0||seed>Integer.MAX_VALUE-(long)replications+1)
   throw new IllegalArgumentException("Seed and replication range must fit JaamSim substreams 0..2147483647");
  ScenarioSettings settings=new ScenarioSettings(duration,warmup,(int)seed,replications);
  if(duration!=null) settings.runSeconds(duration);
  Map<String,EObject> ids=new HashMap<>();
  bpmn.getAllContents().forEachRemaining(e->{Object id=BpmnPreflight.get(e,"id");if(id instanceof String&&!((String)id).isBlank()){if(ids.put((String)id,e)!=null)throw new IllegalArgumentException("Duplicate BPMN id: "+id);}});
  Map<EObject,Map<String,Object>> updates=new LinkedHashMap<>();
  Set<EObject> arrivals=new HashSet<>();
  for(Element ep:children(selected)) if(ep.getLocalName().equals("ElementParameters")) {
   String ref=ep.getAttribute("elementRef");
   // Resolve QName local part against the separately supplied BPMN model.
   if(ref.contains(":")) {String prefix=ref.substring(0,ref.indexOf(':')); String ns=ep.lookupNamespaceURI(prefix); Object target=BpmnPreflight.get(bpmn.getContents().get(0),"targetNamespace"); if(ns==null||!ns.equals(target))throw new IllegalArgumentException("elementRef namespace does not match BPMN targetNamespace");ref=ref.substring(ref.indexOf(':')+1);}
   EObject target=ids.get(ref);
   if(target==null) throw new IllegalArgumentException("Unresolved elementRef: "+ref);
   allowed(ep,"TimeParameters","ControlParameters");
   var fields=updates.computeIfAbsent(target,k->new LinkedHashMap<>());
   for(Element group:children(ep)) {
    if(group.getLocalName().equals("TimeParameters")) {
     if(!BpmnPreflight.kind(target,"Task"))throw new IllegalArgumentException("Time inputs currently require a Task");
     allowed(group,"ProcessingTime");
     for(Element p:children(group))fields.put("Time",value(p,base,false));
    } else if(BpmnPreflight.kind(target,"SequenceFlow")) {
     allowed(group,"Probability");
     for(Element p:children(group)) {
      EObject source=(EObject)BpmnPreflight.get(target,"sourceRef");
      if(!BpmnPreflight.kind(source,"ExclusiveGateway") || BpmnPreflight.list(source,"outgoing").size()<2)
       throw new IllegalArgumentException("Probability requires an outgoing SequenceFlow of an exclusive split: "+ref);
      if(fields.putIfAbsent("BpsimProbability",probability(p))!=null)
       throw new IllegalArgumentException("Duplicate BPSim Probability for "+ref);
     }
    } else {
     if(!BpmnPreflight.kind(target,"StartEvent"))throw new IllegalArgumentException("Trigger inputs currently require a StartEvent");
     allowed(group,"InterTriggerTimer","TriggerCount");
     for(Element p:children(group)) {
      boolean count=p.getLocalName().equals("TriggerCount"); double x=value(p,base,count);
      if(count) {if(x!=Math.rint(x)||x>Integer.MAX_VALUE||x==0)throw new IllegalArgumentException("TriggerCount must be 1..2147483647 for this target; zero is not unlimited");fields.put("MaxNumber",(int)x);}
      else {if(x==0)throw new IllegalArgumentException("Instantaneous BPSim arrivals are not supported by this target");fields.put("InterArrivalTime",x);fields.put("FirstArrivalTime",x);arrivals.add(target);}
     }
    }
   }
  }
  var nodes=new ArrayList<EObject>();bpmn.getAllContents().forEachRemaining(nodes::add);
  for(EObject e:nodes) {
   if(BpmnPreflight.kind(e,"Task"))updates.computeIfAbsent(e,k->new LinkedHashMap<>()).putIfAbsent("Time",0.0);
   if(BpmnPreflight.kind(e,"StartEvent")) {
    if(!arrivals.contains(e))throw new IllegalArgumentException("Start has no BPSim InterTriggerTimer; it must not inherit the legacy one-second default");
    if(!((List<?>)BpmnPreflight.get(e,"eventDefinitions")).isEmpty())throw new IllegalArgumentException("BPSim and BPMN timer definitions require an explicit precedence policy");
    var f=updates.get(e);f.putIfAbsent("MaxNumber",0);f.put("EntitiesPerArrival",1);
   }
   if(BpmnPreflight.kind(e,"ExclusiveGateway")) {
    var outgoing=BpmnPreflight.list(e,"outgoing");
    if(outgoing.size()>1) {
     for(EObject flow:outgoing) if(!updates.getOrDefault(flow,Map.of()).containsKey("BpsimProbability"))
      throw new IllegalArgumentException("BPSim Probability is required on every outgoing flow of exclusive split "
          +BpmnPreflight.get(e,"id")+"; missing "+BpmnPreflight.get(flow,"id"));
    }
   }
   if(BpmnPreflight.kind(e,"SequenceFlow") && BpmnPreflight.get(e,"BpsimProbability")!=null)
    throw new IllegalArgumentException("BPSim routing probabilities must come from the selected scenario");
   if(BpmnPreflight.kind(e,"SequenceFlow"))updates.computeIfAbsent(e,k->new LinkedHashMap<>()).put("TravelTime",0.0);
  }
  updates.forEach((e,fields)->fields.forEach((f,v)->e.eSet(e.eClass().getEStructuralFeature(f),v)));
  return settings;
 }
}

