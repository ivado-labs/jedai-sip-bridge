package org.chusj.crhsj.sip_bridge.service;

import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.sip.repository.EncounterRepository;
import org.chusj.crhsj.sip_bridge.sip.entities.Encounter;
import org.springframework.stereotype.Service;

@Service
public class EncounterService {
  private final EncounterRepository encounterRepository;

  public EncounterService(EncounterRepository encounterRepository) {
    this.encounterRepository = encounterRepository;
  }

  public Encounter findByIdentifier(BigInteger identifier) {
    return this.encounterRepository.findEncounterByIdentifier(identifier);
  }

  public Encounter findEncounterByPatientId(BigInteger patientId) {
    return this.encounterRepository.findEncounterByPatientId(patientId);
  }

  public Encounter saveEncounter(Encounter encounter) {
    return this.encounterRepository.save(encounter);
  }
}
