package com.eclipsesource.app.rcp;

import com.eclipsesource.app.ISingleSourcingService;


public class RCPSingleSourcingService implements ISingleSourcingService {

  @Override
  public String getCustomVariantString() {
    // There are no cusotm variants in RCP
    return "";
  }
}
