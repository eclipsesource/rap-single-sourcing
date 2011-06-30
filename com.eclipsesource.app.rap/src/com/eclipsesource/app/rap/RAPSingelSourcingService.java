package com.eclipsesource.app.rap;

import org.eclipse.rwt.lifecycle.WidgetUtil;
import org.eclipse.swt.widgets.Widget;

import com.eclipsesource.app.ISingleSourcingService;


public class RAPSingelSourcingService implements ISingleSourcingService {

  @Override
  public void applyTheming( Widget widget, String variant ) {
    widget.setData( WidgetUtil.CUSTOM_VARIANT, variant );
  }
}
