import java.lang.reflect.Proxy;
import java.util.*;
import com.jaamsim.events.EventTraceListener;
import com.jaamsim.basicsim.JaamSimModel;
import com.jaamsim.ProcessFlow.EntityGenerator;
import com.jaamsim.ProcessFlow.EntitySink;
/** Observe real counter transitions on the simulation thread, without altering routing. */
public final class FirstBpsimObserver {
 final JaamSimModel model;
 final List<Double> arrivals=new ArrayList<>(), completions=new ArrayList<>();
 FirstBpsimObserver(JaamSimModel model){this.model=model;}
 synchronized void sample(){
  double time=model.getSimTime();
  int generated=((EntityGenerator)model.getNamedEntity("Start")).getNumberGenerated(time);
  long finished=((EntitySink)model.getNamedEntity("End")).getNumberAdded(time);
  while(arrivals.size()<generated)arrivals.add(time);
  while(completions.size()<finished)completions.add(time);
 }
 EventTraceListener listener(){return (EventTraceListener)Proxy.newProxyInstance(EventTraceListener.class.getClassLoader(),new Class<?>[]{EventTraceListener.class},(proxy,method,args)->{sample();return null;});}
 void verify(){
  sample();
  if(!arrivals.equals(Arrays.asList(6.0,12.0,18.0))||!completions.equals(Arrays.asList(8.0,14.0,20.0)))
   throw new AssertionError("Unexpected timeline: arrivals="+arrivals+", completions="+completions);
  System.out.println("PASS first BPSim timeline: arrivals="+arrivals+", completions="+completions);
 }
}
