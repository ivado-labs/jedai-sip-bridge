/*
 * ____________________________________________________________________________
 *
 * (c) 2019, CHUSJ Org. All Rights Reserved
 *
 * The contents of this file may not be disclosed, copied or duplicated in
 * any form, in whole or part, without the prior written permission of
 * CHUSJ Org.
 * ____________________________________________________________________________
 */

package org.chusj.crhsj.sip_bridge.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class HumanName {
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;
  private String family;
  private String given;
  private String prefix;
  private String suffix;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFamily() {
    return family;
  }

  public void setFamily(String family) {
    this.family = family;
  }

  public String getGiven() {
    return given;
  }

  public void setGiven(String given) {
    this.given = given;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }
}
