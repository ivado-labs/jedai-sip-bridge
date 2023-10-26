package org.chusj.crhsj.sip_bridge.adt.repository;

import org.chusj.crhsj.sip_bridge.adt.entities.AdtPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AdtPatientRepository extends JpaRepository<AdtPatient, Long> {
  AdtPatient findAdtPatientById(Long id);
}
