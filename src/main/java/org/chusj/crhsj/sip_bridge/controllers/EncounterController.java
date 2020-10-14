package org.chusj.crhsj.sip_bridge.controllers;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.entities.Encounter;
import org.chusj.crhsj.sip_bridge.service.EncounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncounterController {
  private final EncounterService encounterService;

  public EncounterController(EncounterService encounterService) {
    this.encounterService = encounterService;
  }


  @GetMapping(value = "/getLatestEncounterByPatientId", produces = APPLICATION_JSON_VALUE)
  public Encounter findLatestEncounterByPatientIdentifier(@RequestParam BigInteger patientId) {
    return encounterService.findEncounterByPatientId(patientId);
  }
}
