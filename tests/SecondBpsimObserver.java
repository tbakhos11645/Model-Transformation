import java.lang.reflect.Proxy;
import java.util.*;
import com.jaamsim.events.EventTraceListener;
import com.jaamsim.basicsim.JaamSimModel;
import com.jaamsim.Graphics.DisplayEntity;
import com.jaamsim.ProcessFlow.EntityGenerator;
import com.jaamsim.ProcessFlow.EntitySink;
import com.jaamsim.ProcessFlow.Server;
import com.jaamsim.ProcessFlow.Queue;

/** Observe entity identities, not just counts, to detect FIFO/routing regressions. */
public final class SecondBpsimObserver {
 final JaamSimModel model;
 final boolean warmed;
 final Map<DisplayEntity,Double> arrivals=new LinkedHashMap<>(), starts=new LinkedHashMap<>(), ends=new LinkedHashMap<>();
 int peakQueue;
 SecondBpsimObserver(JaamSimModel model,boolean warmed){this.model=model;this.warmed=warmed;}
 void record(Map<DisplayEntity,Double> map,DisplayEntity entity,double time){if(entity!=null)map.putIfAbsent(entity,time);}
 synchronized void sample(){
  double t=model.getSimTime();
  Queue q=(Queue)model.getNamedEntity("Queue_Work");
  record(arrivals,q.getReceivedEntity(t),t);
  record(starts,((Server)model.getNamedEntity("Work")).getReceivedEntity(t),t);
  record(ends,((EntitySink)model.getNamedEntity("End")).getReceivedEntity(t),t);
  peakQueue=Math.max(peakQueue,q.getQueueLength(t));
 }
 EventTraceListener listener(){return (EventTraceListener)Proxy.newProxyInstance(EventTraceListener.class.getClassLoader(),new Class<?>[]{EventTraceListener.class},(proxy,method,args)->{sample();return null;});}
 static void require(boolean ok,String message){if(!ok)throw new AssertionError(message);}
 void verify(){
  sample();
  require(new ArrayList<>(arrivals.values()).equals(List.of(2.0,4.0,6.0,8.0)),"Wrong arrivals: "+arrivals.values());
  require(new ArrayList<>(starts.values()).equals(List.of(2.0,7.0,12.0,17.0)),"Wrong service starts: "+starts.values());
  require(new ArrayList<>(ends.values()).equals(List.of(7.0,12.0,17.0,22.0)),"Wrong completions: "+ends.values());
  require(new ArrayList<>(arrivals.keySet()).equals(new ArrayList<>(starts.keySet())) && new ArrayList<>(starts.keySet()).equals(new ArrayList<>(ends.keySet())),"FIFO identity order changed or entity lost/duplicated");
  List<Double> waits=new ArrayList<>();
  for(DisplayEntity e:arrivals.keySet())waits.add(starts.get(e)-arrivals.get(e));
  require(waits.equals(List.of(0.0,3.0,6.0,9.0)),"Wrong waiting times: "+waits);
  Queue q=(Queue)model.getNamedEntity("Queue_Work");
  EntitySink sink=(EntitySink)model.getNamedEntity("End");
  require(peakQueue==2 && q.getQueueLength(30)==0,"Expected peak queue 2 and final empty queue, peak="+peakQueue);
  require(((EntityGenerator)model.getNamedEntity("Start")).getNumberGenerated(30)==4 && sink.getNumberDestroyed(30)==4,"Wrong lifetime entity counts");
  require(sink.getNumberAdded(30)==(warmed?3:4),"Warmup statistics must exclude the completion at 7 seconds");
  require(model.getSimTime()==30,"Duration must include warmup");
  System.out.println("PASS second BPSim: FIFO identities, waits="+waits+", completions="+ends.values()+", peak queue=2, measured sink="+sink.getNumberAdded(30)+", warmed="+warmed);
 }
}
