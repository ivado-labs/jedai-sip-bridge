package org.chusj.crhsj.sip_bridge.sip.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CodeableConcept {
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;
  private String code;
  private String display;

  public CodeableConcept() {
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDisplay() {
    return display;
  }

  public void setDisplay(String display) {
    this.display = display;
  }
}
