package org.chusj.crhsj.sip_bridge.service;

import org.chusj.crhsj.sip_bridge.adt.entities.AdtPatient;
import org.chusj.crhsj.sip_bridge.adt.repository.AdtPatientRepository;
import org.springframework.stereotype.Service;

@Service
public class AdtPatientService {
  private final AdtPatientRepository adtPatientRepository;

  public AdtPatientService(AdtPatientRepository adtPatientRepository) {
    this.adtPatientRepository = adtPatientRepository;
  }

  public AdtPatient findAdtPatientByPatientIdentifier(Long patientIdentifier) {
    return adtPatientRepository.findAdtPatientById(patientIdentifier);
  }
}
