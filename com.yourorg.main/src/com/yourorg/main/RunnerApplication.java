//Eclipse Wrapper
package com.yourorg.main;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class RunnerApplication implements IApplication {

  @Override
  public Object start(IApplicationContext context) throws Exception {
    System.err.println(">>> RunnerApplication.start()");
    Main.main(new String[0]);   //Main.java
    System.err.println(">>> RunnerApplication.end()");
    return IApplication.EXIT_OK;
  }

  @Override
  public void stop() {
  }
}
