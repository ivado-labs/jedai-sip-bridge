package org.chusj.crhsj.sip_bridge.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.sip.entities.Quantis;
import org.chusj.crhsj.sip_bridge.service.QuantisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.base-path}")
public class QuantisController {
  private final QuantisService quantisService;

  public QuantisController(QuantisService quantisService) {
    this.quantisService = quantisService;
  }

  @GetMapping(value = "/quantis", produces = APPLICATION_JSON_VALUE)
  public Quantis quantis(@RequestParam("dossier") BigInteger patientIdentifier) {
    return quantisService.findQuantisByDossierNumber(patientIdentifier);
  }
}
