package org.chusj.crhsj.sip_bridge.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Location {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;
  @OneToOne
  @JoinColumn(name = "room", referencedColumnName = "id")
  private Room room;
  @OneToOne
  @JoinColumn(name = "bed", referencedColumnName = "id")
  private Bed bed;

  @OneToOne
  @JoinColumn(name = "organization", referencedColumnName = "id")
  private Organization organization;
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Bed getBed() {
    return bed;
  }

  public void setBed(Bed bed) {
    this.bed = bed;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }
}
