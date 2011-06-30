package com.eclipsesource.app.rcp;

import com.eclipsesource.app.ISingleSourcingService;
import org.eclipse.swt.widgets.Widget;

public class RCPSingleSourcingService implements ISingleSourcingService {

  @Override
  public void applyTheming( Widget widget, String variant ) {
    // There are no custom variants in RCP
  }
}
