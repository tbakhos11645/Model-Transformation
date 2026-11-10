import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import com.jaamsim.basicsim.JaamSimModel;
import com.jaamsim.basicsim.RunListener;
import com.jaamsim.basicsim.Log;

public class JaamSimSmokeTest {
 public static void main(String[] args) throws Exception {
  try { run(args); }
  catch (Throwable error) { error.printStackTrace(); System.exit(1); }
 }
 private static void run(String[] args) throws Exception {
  for(String arg : args) {
   JaamSimModel model = new JaamSimModel(arg);
   model.autoLoad();
   try { model.configure(new File(arg).getAbsoluteFile()); }
   catch (Throwable t) { for(String line : Log.getLog(0)) System.err.println(line); throw t; }
   if(model.getNumErrors()!=0) throw new AssertionError("Configuration errors");
   if(model.getNumWarnings()!=0) throw new AssertionError("Configuration warnings");
   CountDownLatch done = new CountDownLatch(1);
   AtomicReference<Throwable> error = new AtomicReference<>();
   boolean second=new File(arg).getName().startsWith("second-bpsim-");
   boolean third=new File(arg).getName().startsWith("third-bpsim-");
   FirstBpsimObserver observer=third||new File(arg).getName().startsWith("first-bpsim-")?new FirstBpsimObserver(model):null;
   SecondBpsimObserver secondObserver=second?new SecondBpsimObserver(model,arg.contains("warmup")):null;
   TopologyObserver topology=arg.contains("topology-")||arg.contains("fourth-bpsim-")?new TopologyObserver(model,arg):null;
   model.start(new RunListener() {
    public void runEnded() { done.countDown(); }
    public void handleRuntimeError(JaamSimModel sm, Throwable t) { error.set(t); done.countDown(); }
   }, topology!=null?topology.listener():secondObserver!=null?secondObserver.listener():observer==null?null:observer.listener());
   if (!done.await(10, TimeUnit.SECONDS)) { model.pause(); throw new AssertionError("Timed out: "+arg); }
   if(error.get()!=null) throw new AssertionError("Runtime error: "+arg,error.get());
   if(model.getSimTime()!=(second?30.0:60.0)) throw new AssertionError("Unexpected stop time: "+model.getSimTime());
   System.out.println("PASS JaamSim: "+arg+" at "+model.getSimTime()+" s, warnings="+model.getNumWarnings());
   if(observer!=null) observer.verify();
   if(secondObserver!=null) secondObserver.verify();
   if(topology!=null) topology.verify();
   if(third) {
    int expected=arg.contains("003")?43:arg.contains("002")?42:41;
    int seed=model.getSimulation().getSubstreamNumber();
    if(seed!=expected)throw new AssertionError("Wrong native seed: "+seed);
    var a=new com.jaamsim.rng.MRG1999a(1,seed);
    var b=new com.jaamsim.rng.MRG1999a(1,seed);
    var c=new com.jaamsim.rng.MRG1999a(1,seed+1);
    boolean distinct=false;
    for(int n=0;n<32;n++){double sample=a.nextUniform();if(sample!=b.nextUniform())throw new AssertionError("Seed not repeatable");distinct|=sample!=c.nextUniform();}
    if(!distinct)throw new AssertionError("Substreams are identical");
    System.out.println("PASS native seed="+seed+": repeatable RNG probe, distinct adjacent substream");
   }
   model.closeLogFile();
  }
  System.exit(0); // JaamSim event-manager worker threads remain alive after the last run.
 }
}
