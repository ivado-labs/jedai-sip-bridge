package org.chusj.crhsj.sip_bridge.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import java.math.BigInteger;
import java.util.List;
import org.chusj.crhsj.sip_bridge.sip.entities.Procedure;
import org.chusj.crhsj.sip_bridge.service.ProcedureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.base-path}")
public class ProcedureController {
  private final ProcedureService procedureService;

  public ProcedureController(ProcedureService procedureService) {
    this.procedureService = procedureService;
  }

  @GetMapping(value = "/latestProcedureByEncounterId", produces = APPLICATION_JSON_VALUE)
  public Procedure findLatestProcedureByEncounterId(@RequestParam BigInteger encounterId,@RequestParam String code) {
    return procedureService.findLatestProcedureByEncounterIdAndCode(encounterId,code);
  }

  @GetMapping(value = "/latestProcedureByPatientId", produces = APPLICATION_JSON_VALUE)
  public Procedure findLatestProcedureByPatientId(@RequestParam BigInteger patientId, @RequestParam String code) {
    return procedureService.findLatestProcedureWithCodeAndPatientId(patientId, code);
  }

  @GetMapping(value = "/proceduresByPatientId", produces = APPLICATION_JSON_VALUE)
  public List<Procedure> findProceduresByPatientId(@RequestParam BigInteger patientId, @RequestParam String code) {
    return procedureService.findProceduresWithCodeAndPatientId(patientId, code);
  }


}