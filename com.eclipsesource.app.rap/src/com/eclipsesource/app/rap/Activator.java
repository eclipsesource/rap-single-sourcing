package com.eclipsesource.app.rap;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.eclipsesource.app.ISingleSourcingService;

public class Activator implements BundleActivator {

  private static BundleContext context;
  private ServiceRegistration<?> registration;

  static BundleContext getContext() {
    return context;
  }

  public void start( BundleContext bundleContext ) throws Exception {
    Activator.context = bundleContext;
    registration = context.registerService( ISingleSourcingService.class.getName(), 
                                            new RAPSingelSourcingService(), 
                                            null);
  }

  public void stop( BundleContext bundleContext ) throws Exception {
    bundleContext.ungetService( registration.getReference() );
    Activator.context = null;
  }
}
