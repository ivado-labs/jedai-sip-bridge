package org.chusj.crhsj.sip_bridge.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quantis {
  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @JsonProperty("dossier")
  private BigInteger patientIdentifier;
  @JsonProperty("Date_entree")
  private LocalDate enteredDate;
  @JsonProperty("ReelHorraire")
  private String reelHorraire;
  @JsonProperty("Cote_Reel")
  private Integer coteReel;
  @JsonProperty("Niveau_Reel")
  private Integer niveauReel;
  @JsonProperty("Lit")
  private String lit;
  @JsonProperty("PlanHorraire")
  private String planHorraire;
  @JsonProperty("Cote_Planifie")
  private String cotePlanifie;
  @JsonProperty("Niveau_Planifie")
  private String niveauPlanifie;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigInteger getPatientIdentifier() {
    return patientIdentifier;
  }

  public void setPatientIdentifier(BigInteger patient) {
    this.patientIdentifier = patient;
  }

  public LocalDate getEnteredDate() {
    return enteredDate;
  }

  public void setEnteredDate(LocalDate enteredDate) {
    this.enteredDate = enteredDate;
  }

  public String getReelHorraire() {
    return reelHorraire;
  }

  public void setReelHorraire(String reelHorraire) {
    this.reelHorraire = reelHorraire;
  }

  public Integer getCoteReel() {
    return coteReel;
  }

  public void setCoteReel(Integer coteReel) {
    this.coteReel = coteReel;
  }

  public Integer getNiveauReel() {
    return niveauReel;
  }

  public void setNiveauReel(Integer niveauReel) {
    this.niveauReel = niveauReel;
  }

  public String getLit() {
    return lit;
  }

  public void setLit(String lit) {
    this.lit = lit;
  }

  public String getPlanHorraire() {
    return planHorraire;
  }

  public void setPlanHorraire(String planHorraire) {
    this.planHorraire = planHorraire;
  }

  public String getCotePlanifie() {
    return cotePlanifie;
  }

  public void setCotePlanifie(String cotePlanifie) {
    this.cotePlanifie = cotePlanifie;
  }

  public String getNiveauPlanifie() {
    return niveauPlanifie;
  }

  public void setNiveauPlanifie(String niveauPlanifie) {
    this.niveauPlanifie = niveauPlanifie;
  }
}
