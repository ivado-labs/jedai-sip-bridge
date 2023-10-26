package org.chusj.crhsj.sip_bridge.sip.repository;

import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.sip.entities.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface EncounterRepository extends JpaRepository<Encounter, Long> {
  @Query(value="SELECT * FROM encounter where encounter_identifier=?1", nativeQuery = true)
  Encounter findEncounterByIdentifier(BigInteger identifier);
  @Query(value="SELECT * FROM encounter e " +
      "LEFT JOIN patient p ON e.subject=p.id where p.patient_identifier=?1 " +
      "ORDER BY e.id DESC LIMIT 1", nativeQuery = true)
  Encounter findEncounterByPatientId(BigInteger patientId);
}
