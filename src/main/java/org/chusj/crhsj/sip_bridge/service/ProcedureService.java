package org.chusj.crhsj.sip_bridge.service;

import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.dao.ProcedureDao;
import org.chusj.crhsj.sip_bridge.entities.Procedure;
import org.springframework.stereotype.Service;

@Service
public class ProcedureService {
  private final ProcedureDao procedureDao;

  public ProcedureService(ProcedureDao procedureDao) {
    this.procedureDao = procedureDao;
  }

  public Procedure findProcedureWithCodeByEncounterId(BigInteger encounterId, String code) {
    return procedureDao.findProceduresByEncounterIdAndCode(encounterId, code);
  }

  public Procedure findProcedureWithCodeByPatientId(BigInteger patientId, String code) {
    return procedureDao.findProceduresByPatientIdAndCode(patientId, code);
  }
}