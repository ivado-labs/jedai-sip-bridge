package org.chusj.crhsj.sip_bridge.sip.entities;

import javax.persistence.Embeddable;

@Embeddable
public class SimpleQuantity {
  private String value;
  private String unit;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }
}
