package org.chusj.crhsj.sip_bridge.service;

import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.dao.EncounterDao;
import org.chusj.crhsj.sip_bridge.entities.Encounter;
import org.springframework.stereotype.Service;

@Service
public class EncounterService {
  private final EncounterDao encounterDao;

  public EncounterService(EncounterDao encounterDao) {
    this.encounterDao = encounterDao;
  }

  public Encounter findByIdentifier(BigInteger identifier) {
    return this.encounterDao.findEncounterByIdentifier(identifier);
  }

  public Encounter findEncounterByPatientId(BigInteger patientId) {
    return this.encounterDao.findEncounterByPatientId(patientId);
  }

  public Encounter saveEncounter(Encounter encounter) {
    return this.encounterDao.save(encounter);
  }
}
