package org.chusj.crhsj.sip_bridge.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.entities.Procedure;
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


  @GetMapping(value = "/procedureByPatientId", produces = APPLICATION_JSON_VALUE)
  public Procedure findProcedureByPatientId(@RequestParam BigInteger patientId, @RequestParam String code) {
    return procedureService.findProcedureWithCodeByPatientId(patientId, code);
  }
}