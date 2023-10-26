package org.chusj.crhsj.sip_bridge.controllers;


import org.chusj.crhsj.sip_bridge.adt.entities.AdtPatient;
import org.chusj.crhsj.sip_bridge.service.AdtPatientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.base-path}")
public class AdtPatientController {
  private final AdtPatientService adtPatientService;

  public AdtPatientController(AdtPatientService adtPatientService) {
    this.adtPatientService = adtPatientService;
  }

  @GetMapping(value = "/getAdtPatient", produces = MediaType.APPLICATION_JSON_VALUE)
  public AdtPatient getAdtPatientByPatientIdentifier(@RequestParam Long patientIdentifier) {
    return adtPatientService.findAdtPatientByPatientIdentifier(patientIdentifier);
  }
}
