package org.chusj.crhsj.sip_bridge.service;

import java.math.BigInteger;
import java.util.List;
import org.chusj.crhsj.sip_bridge.sip.repository.ObservationRepository;
import org.chusj.crhsj.sip_bridge.sip.entities.Observation;
import org.springframework.stereotype.Service;

@Service
public class ObservationService {
  private final ObservationRepository observationRepository;

  public ObservationService(ObservationRepository observationRepository) {
    this.observationRepository = observationRepository;
  }

  public Observation findLatestObservationByEncounterIdAndCode(BigInteger encounterId, String code) {
    return observationRepository.findLatestObservationByEncounterIdAndCode(encounterId, code);
  }

  public Observation findLatestObservationWithCodeAndPatientId(BigInteger patientId, String code) {
    return observationRepository.findLatestObservationByPatientIdAndCode(patientId, code);
  }

  public List<Observation> findObservationsWithCodeAndPatientId(BigInteger patientId, String code) {
    return observationRepository.findObservationsByPatientIdAndCode(patientId, code);
  }
}
