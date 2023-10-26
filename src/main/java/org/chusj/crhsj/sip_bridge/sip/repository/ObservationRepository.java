package org.chusj.crhsj.sip_bridge.sip.repository;

import java.math.BigInteger;
import java.util.List;
import org.chusj.crhsj.sip_bridge.sip.entities.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional(readOnly = true)
public interface ObservationRepository extends JpaRepository<Observation, Long> {
  @Query(value = "SELECT * FROM observation o LEFT JOIN codeable_concept c on c.id=o.coding " +
      "LEFT JOIN encounter e on o.encounter=e.id where e.encounter_identifier =?1 and c.code=?2 ORDER BY o.id DESC LIMIT 1", nativeQuery = true)
  Observation findLatestObservationByEncounterIdAndCode(BigInteger encounterIdentifier, String coding);

  @Query(value = "SELECT * FROM observation o  LEFT JOIN codeable_concept c on c.id=o.coding " +
      "LEFT JOIN encounter e on o.encounter=e.id " +
      "LEFT JOIN patient pa on pa.id=e.subject where pa.patient_identifier =?1 and c.code=?2 ORDER BY o.id DESC LIMIT 1 ", nativeQuery = true)
  Observation findLatestObservationByPatientIdAndCode(BigInteger patientId, String code);

  @Query(value = "SELECT * FROM observation o LEFT JOIN codeable_concept c on c.id=o.coding " +
      "LEFT JOIN encounter e on o.encounter=e.id " +
      "LEFT JOIN patient pa on pa.id=e.subject where pa.patient_identifier =?1 and c.code=?2 ", nativeQuery = true)
  List<Observation> findObservationsByPatientIdAndCode(BigInteger patientIdentifier, String coding);

}
