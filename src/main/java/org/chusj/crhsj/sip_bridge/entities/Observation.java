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
public class Observation {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @OneToOne
  @JoinColumn(name = "coding", referencedColumnName = "id")
  private CodeableConcept coding;
  @OneToOne
  @JoinColumn(name = "subject", referencedColumnName = "id")
  private Patient subject;
  private LocalDateTime issued;
  //private Practitioner performer;
  @Embedded
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

  public Patient getSubject() {
    return subject;
  }

  public void setSubject(Patient subject) {
    this.subject = subject;
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
}
