package com.eclipsesource.internal.app;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.eclipsesource.app.ISingleSourcingService;



public class Activator implements BundleActivator {
  
  private static ISingleSourcingService service;

  void setSingleSourcingService( ISingleSourcingService service ) {
    Activator.service = service;
  }
  
  void unsetSingleSourcingService( ISingleSourcingService service ) {
    Activator.service = null;
  }
  
  public static ISingleSourcingService getSingleSourcingService() {
    return service;
  }

  @Override
  public void start( BundleContext context ) throws Exception {
  }

  @Override
  public void stop( BundleContext context ) throws Exception {
  }
}
