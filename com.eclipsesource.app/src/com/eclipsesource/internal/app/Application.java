package com.eclipsesource.internal.app;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.eclipsesource.app.ISingleSourcingService;


public class Application implements IApplication {

  @Override
  public Object start( IApplicationContext context ) throws Exception {
    Display display = new Display();
    Shell shell = new Shell( display );
    shell.setLayout( new GridLayout( 1, false ) );
    
    Button button = new Button( shell, SWT.PUSH );
    button.setLayoutData( new GridData( SWT.BEGINNING, SWT.CENTER, false, false ) );
    button.setText( "I'm a singel sourced button" );
    
    // Let's get the SingleSourcing service
    ISingleSourcingService service = getSingleSourcingService();
    // Now we set a custom variant which only exists in RAP
    service.applyTheming( button, "variant" );
    
    shell.setSize( 500, 500 );
    shell.open();
    while( !shell.isDisposed() ) {
      if( !display.readAndDispatch() )
        display.sleep();
    }
    display.dispose();
    return null;
  }

  private ISingleSourcingService getSingleSourcingService() {
    // We use a tracker to get the service. We also can use DS to get it.
    Bundle bundle = FrameworkUtil.getBundle( getClass() );
    BundleContext context = bundle.getBundleContext();
    ServiceTracker<ISingleSourcingService, ISingleSourcingService> tracker 
      = new ServiceTracker<ISingleSourcingService, ISingleSourcingService>( context,
                                                                            ISingleSourcingService.class.getName(),
                                                                            null );
    tracker.open();
    ISingleSourcingService service = tracker.getService();
    tracker.close();
    return service;
  }

  @Override
  public void stop() {
  }
}
