package org.chusj.crhsj.sip_bridge.service;

import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.sip.repository.QuantisRepository;
import org.chusj.crhsj.sip_bridge.sip.entities.Quantis;
import org.springframework.stereotype.Service;

@Service
public class QuantisService {
  private final QuantisRepository quantisRepository;


  public QuantisService(QuantisRepository quantisRepository) {
    this.quantisRepository = quantisRepository;
  }

  public Quantis findQuantisByDossierNumber(BigInteger patientIdentifier) {
    return quantisRepository.findByPatientIdentifier(patientIdentifier);
  }
}
