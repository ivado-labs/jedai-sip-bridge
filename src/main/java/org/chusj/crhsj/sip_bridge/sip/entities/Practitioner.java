package org.chusj.crhsj.sip_bridge.sip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Practitioner {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @JsonIgnore
  private Long id;
  @OneToOne
  @JoinColumn(name="name",referencedColumnName = "id")
  private HumanName name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public HumanName getName() {
    return name;
  }

  public void setName(HumanName name) {
    this.name = name;
  }
}
