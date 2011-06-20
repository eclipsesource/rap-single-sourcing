package com.eclipsesource.app.rap;

import org.eclipse.rwt.lifecycle.WidgetUtil;

import com.eclipsesource.app.ISingleSourcingService;


public class RAPSingelSourcingService implements ISingleSourcingService {

  @Override
  public String getCustomVariantString() {
    return WidgetUtil.CUSTOM_VARIANT;
  }
}
