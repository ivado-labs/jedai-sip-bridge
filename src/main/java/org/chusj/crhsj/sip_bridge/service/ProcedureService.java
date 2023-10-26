package org.chusj.crhsj.sip_bridge.service;

import java.math.BigInteger;
import java.util.List;
import org.chusj.crhsj.sip_bridge.sip.repository.ProcedureRepository;
import org.chusj.crhsj.sip_bridge.sip.entities.Procedure;
import org.springframework.stereotype.Service;

@Service
public class ProcedureService {
  private final ProcedureRepository procedureRepository;

  public ProcedureService(ProcedureRepository procedureRepository) {
    this.procedureRepository = procedureRepository;
  }

  public Procedure findLatestProcedureByEncounterIdAndCode(BigInteger encounterId, String code) {
    return procedureRepository.findLatestProcedureByEncounterIdAndCode(encounterId, code);
  }
  public Procedure findLatestProcedureWithCodeAndPatientId(BigInteger patientId, String code) {
    return procedureRepository.findLatestProcedureWithCodeAndPatientId(patientId, code);
  }
  public List<Procedure> findProceduresWithCodeAndPatientId(BigInteger patientId, String code) {
    return procedureRepository.findProceduresWithCodeAndPatientId(patientId, code);
  }

}