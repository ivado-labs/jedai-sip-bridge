package org.chusj.crhsj.sip_bridge.sip.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Observation {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private BigInteger coding;
  private BigInteger encounter;
  private LocalDateTime effectiveDateTime;
  private SimpleQuantity valueQuantity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigInteger getCoding() {
    return coding;
  }

  public void setCoding(BigInteger coding) {
    this.coding = coding;
  }

  public BigInteger getEncounter() {
    return encounter;
  }

  public void setEncounter(BigInteger encounter) {
    this.encounter = encounter;
  }

  public LocalDateTime getEffectiveDateTime() {
    return effectiveDateTime;
  }

  public void setEffectiveDateTime(LocalDateTime issued) {
    this.effectiveDateTime = issued;
  }

  public SimpleQuantity getValueQuantity() {
    return valueQuantity;
  }

  public void setValueQuantity(SimpleQuantity valueQuantity) {
    this.valueQuantity = valueQuantity;
  }
}
