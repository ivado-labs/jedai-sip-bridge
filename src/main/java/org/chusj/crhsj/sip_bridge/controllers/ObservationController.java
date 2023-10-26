package org.chusj.crhsj.sip_bridge.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import java.math.BigInteger;
import java.util.List;
import org.chusj.crhsj.sip_bridge.sip.entities.Observation;
import org.chusj.crhsj.sip_bridge.service.ObservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.base-path}")
public class ObservationController {
  private final ObservationService ObservationService;

  public ObservationController(ObservationService ObservationService) {
    this.ObservationService = ObservationService;
  }

  @GetMapping(value = "/latestObservationByEncounterId", produces = APPLICATION_JSON_VALUE)
  public Observation findObservationByEncounterId(@RequestParam BigInteger encounterId, @RequestParam String code) {
    return ObservationService.findLatestObservationByEncounterIdAndCode(encounterId,code);
  }

  @GetMapping(value = "/latestObservationByPatientId", produces = APPLICATION_JSON_VALUE)
  public Observation findLatestObservationByPatientId(@RequestParam BigInteger patientId, @RequestParam String code) {
    return ObservationService.findLatestObservationWithCodeAndPatientId(patientId, code);
  }

  @GetMapping(value = "/ObservationsByPatientId", produces = APPLICATION_JSON_VALUE)
  public List<Observation> findObservationsByPatientId(@RequestParam BigInteger patientId, @RequestParam String code) {
    return ObservationService.findObservationsWithCodeAndPatientId(patientId, code);
  }

}
