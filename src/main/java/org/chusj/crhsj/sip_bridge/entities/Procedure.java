package org.chusj.crhsj.sip_bridge.entities;

import java.time.LocalDateTime;
import javax.persistence.Embedded;
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
  @OneToOne
  @JoinColumn(name = "coding", referencedColumnName = "id")
  private CodeableConcept coding;
  @OneToOne
  @JoinColumn(name = "encounter", referencedColumnName = "id")
  private Encounter encounter;
  private LocalDateTime issued;
  private SimpleQuantity valueQuantity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CodeableConcept getCoding() {
    return coding;
  }

  public void setCoding(CodeableConcept coding) {
    this.coding = coding;
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

  public Encounter getEncounter() {
    return encounter;
  }

  public void setEncounter(Encounter encounter) {
    this.encounter = encounter;
  }

}
