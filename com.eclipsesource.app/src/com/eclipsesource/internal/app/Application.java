package com.eclipsesource.internal.app;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class Application implements IApplication {
  
  @Override
  public Object start( IApplicationContext context ) throws Exception {
    Display display = new Display();
    Shell shell = new Shell( display );
    shell.setLayout( new GridLayout( 1, false ) );
    
    Button button = new Button( shell, SWT.PUSH );
    button.setLayoutData( new GridData( SWT.BEGINNING, SWT.CENTER, false, false ) );
    button.setText( "I'm a singel sourced button" );
    
    // Now we set a custom variant which only exists in RAP
    Activator.getSingleSourcingService().applyTheming( button, "variant" );
    
    shell.setSize( 500, 500 );
    shell.open();
    while( !shell.isDisposed() ) {
      if( !display.readAndDispatch() )
        display.sleep();
    }
    display.dispose();
    return null;
  }

  @Override
  public void stop() {
  }
}
