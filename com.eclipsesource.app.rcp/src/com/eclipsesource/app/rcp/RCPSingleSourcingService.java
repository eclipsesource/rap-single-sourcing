package com.eclipsesource.app.rcp;

import org.eclipse.swt.widgets.Widget;

import com.eclipsesource.app.ISingleSourcingService;

public class RCPSingleSourcingService implements ISingleSourcingService {

  @Override
  public void applyTheming( Widget widget, String variant ) {
    // There are no custom variants in RCP
  }
}
