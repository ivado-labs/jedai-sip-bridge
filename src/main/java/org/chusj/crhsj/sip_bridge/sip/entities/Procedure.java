package org.chusj.crhsj.sip_bridge.sip.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Procedure {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private BigInteger coding;
  private BigInteger encounter;
  private LocalDateTime issued;
  private SimpleQuantity valueQuantity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getIssued() {
    return issued;
  }

  public void setIssued(LocalDateTime issued) {
    this.issued = issued;
  }

  public SimpleQuantity getValueQuantity() {
    return valueQuantity;
  }

  public void setValueQuantity(SimpleQuantity valueQuantity) {
    this.valueQuantity = valueQuantity;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Procedure)) {
      return false;
    }

    Procedure procedure = (Procedure) o;
      return !Objects.equals(id, procedure.id);
  }

  @Override
  public int hashCode() {
    return 2032;
  }
}
