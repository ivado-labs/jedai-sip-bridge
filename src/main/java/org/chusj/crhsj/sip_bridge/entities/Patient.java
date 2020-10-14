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
import java.time.LocalDate;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import org.chusj.crhsj.sip_bridge.entities.converters.IdentifierConverter;

@Entity
public class Patient {
  @Transient
  @JsonIgnore
  public final String PATIENT_HOSPITAL_NUMBER_CODE = "184107009";
  @Transient
  @JsonIgnore
  public final String PATIENT_HOSPITAL_NUMBER_DESCRIPTION = "Patient hospital number (observable entity)";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Convert(converter = IdentifierConverter.class)
  private Identifier patientIdentifier;
  private Gender gender;
  @OneToOne
  @JoinColumn(name = "name", referencedColumnName = "id")
  private HumanName name;
  private LocalDate birthDate;
  @OneToOne
  @JoinColumn(name = "general_practitioner", referencedColumnName = "id")
  private Practitioner generalPractitioner;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public HumanName getName() {
    return name;
  }

  public void setName(HumanName name) {
    this.name = name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Practitioner getGeneralPractitioner() {
    return generalPractitioner;
  }

  public void setGeneralPractitioner(Practitioner generalPractitioner) {
    this.generalPractitioner = generalPractitioner;
  }

  public Identifier getPatientIdentifier() {
    return patientIdentifier;
  }

  public void setPatientIdentifier(Identifier patientIdentifier) {
    this.patientIdentifier = patientIdentifier;
  }

  @PostLoad
  void postLoad() {
    var codeableConcept = new CodeableConcept();
    codeableConcept.setCode(PATIENT_HOSPITAL_NUMBER_CODE);
    codeableConcept.setDisplay(PATIENT_HOSPITAL_NUMBER_DESCRIPTION);
    patientIdentifier.setType(codeableConcept);
  }


}
