import java.lang.reflect.Proxy;
import java.util.*;
import com.jaamsim.events.EventTraceListener;
import com.jaamsim.basicsim.JaamSimModel;
import com.jaamsim.ProcessFlow.EntitySink;

/** Verify real sink arrivals for independent processes, consecutive tasks and XOR merges. */
public final class TopologyObserver {
 final JaamSimModel model;
 final Map<String,List<Double>> expected=new LinkedHashMap<>(), actual=new LinkedHashMap<>();
 TopologyObserver(JaamSimModel model,String filename){
  this.model=model;
  if(filename.contains("fourth-bpsim"))expected.put("End",List.of(12.0,17.0,22.0,32.0));
  else if(filename.contains("topology-consecutive"))expected.put("End",List.of(15.0,25.0,35.0));
  else {expected.put("EndA",List.of(1.0,2.0,3.0));expected.put("EndB",List.of(2.0,4.0,6.0));}
  expected.keySet().forEach(name->actual.put(name,new ArrayList<>()));
 }
 synchronized void sample(){
  double time=model.getSimTime();
  actual.forEach((name,times)->{
   long count=((EntitySink)model.getNamedEntity(name)).getNumberAdded(time);
   while(times.size()<count)times.add(time);
  });
 }
 EventTraceListener listener(){return (EventTraceListener)Proxy.newProxyInstance(EventTraceListener.class.getClassLoader(),new Class<?>[]{EventTraceListener.class},(proxy,method,args)->{sample();return null;});}
 void verify(){
  sample();
  if(!actual.equals(expected))throw new AssertionError("Topology completion times: expected="+expected+", actual="+actual);
  System.out.println("PASS topology completion times: "+actual);
 }
}
