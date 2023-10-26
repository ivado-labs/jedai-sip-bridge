package org.chusj.crhsj.sip_bridge.sip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import org.chusj.crhsj.sip_bridge.converters.IdentifierConverter;

@Entity
public class Encounter {
  @Transient
  @JsonIgnore
  public final String HOSPITAL_REFERENCE_NUMBER_CODE = "185975009";
  @Transient
  @JsonIgnore
  public final String HOSPITAL_REFERENCE_NUMBER_DESCRIPTION = "Hospital reference number (observable entity)";
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Convert(converter = IdentifierConverter.class)
  private Identifier encounterIdentifier;
  @OneToOne
  @JoinColumn(name = "subject", referencedColumnName = "id")
  private Patient subject;
  @OneToOne
  @JoinColumn(name = "location", referencedColumnName = "id")
  private Location location;

  @OneToOne
  @JoinColumn(name = "practitioner", referencedColumnName = "id")
  private Practitioner practitioner;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Patient getSubject() {
    return subject;
  }

  public void setSubject(Patient subject) {
    this.subject = subject;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Identifier getEncounterIdentifier() {
    return encounterIdentifier;
  }

  public void setEncounterIdentifier(Identifier encounterIdentifier) {
    this.encounterIdentifier = encounterIdentifier;
  }

  public Practitioner getPractitioner() {
    return practitioner;
  }

  public void setPractitioner(Practitioner practitioner) {
    this.practitioner = practitioner;
  }

  @PostLoad
  void postLoad() {
    var codeableConcept = new CodeableConcept();
    codeableConcept.setCode(HOSPITAL_REFERENCE_NUMBER_CODE);
    codeableConcept.setDisplay(HOSPITAL_REFERENCE_NUMBER_DESCRIPTION);
    encounterIdentifier.setType(codeableConcept);
  }
}
