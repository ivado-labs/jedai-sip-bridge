package org.chusj.crhsj.sip_bridge.service;

import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.dao.QuantisDao;
import org.chusj.crhsj.sip_bridge.entities.Quantis;
import org.springframework.stereotype.Service;

@Service
public class QuantisService {
  private final QuantisDao quantisDao;


  public QuantisService(QuantisDao quantisDao) {
    this.quantisDao = quantisDao;
  }

  public Quantis findQuantisByDossierNumber(BigInteger patientIdentifier) {
    return quantisDao.findByPatientIdentifier(patientIdentifier);
  }
}
