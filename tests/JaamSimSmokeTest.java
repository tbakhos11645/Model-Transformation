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
   FirstBpsimObserver observer=new File(arg).getName().startsWith("first-bpsim-")?new FirstBpsimObserver(model):null;
   SecondBpsimObserver secondObserver=second?new SecondBpsimObserver(model,arg.contains("warmup")):null;
   model.start(new RunListener() {
    public void runEnded() { done.countDown(); }
    public void handleRuntimeError(JaamSimModel sm, Throwable t) { error.set(t); done.countDown(); }
   }, secondObserver!=null?secondObserver.listener():observer==null?null:observer.listener());
   if (!done.await(10, TimeUnit.SECONDS)) { model.pause(); throw new AssertionError("Timed out: "+arg); }
   if(error.get()!=null) throw new AssertionError("Runtime error: "+arg,error.get());
   if(model.getSimTime()!=(second?30.0:60.0)) throw new AssertionError("Unexpected stop time: "+model.getSimTime());
   System.out.println("PASS JaamSim: "+arg+" at "+model.getSimTime()+" s, warnings="+model.getNumWarnings());
   if(observer!=null) observer.verify();
   if(secondObserver!=null) secondObserver.verify();
   model.closeLogFile();
  }
  System.exit(0); // JaamSim event-manager worker threads remain alive after the last run.
 }
}
