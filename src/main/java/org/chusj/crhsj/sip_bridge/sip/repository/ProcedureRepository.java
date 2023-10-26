package org.chusj.crhsj.sip_bridge.sip.repository;

import java.math.BigInteger;
import java.util.List;
import org.chusj.crhsj.sip_bridge.sip.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
  @Query(value = "SELECT * FROM `procedure` p LEFT JOIN codeable_concept c on c.id=p.coding " +
      "LEFT JOIN encounter e on p.encounter=e.id where e.encounter_identifier =?1 and c.code=?2 ORDER BY p.id DESC LIMIT 1 ", nativeQuery = true)
  Procedure findLatestProcedureByEncounterIdAndCode(BigInteger encounterIdentifier, String coding);

  @Query(value = "SELECT * FROM `procedure` p LEFT JOIN codeable_concept c on c.id=p.coding " +
      "LEFT JOIN encounter e on p.encounter=e.id " +
      "LEFT JOIN patient pa on pa.id=e.subject where pa.patient_identifier =?1 and c.code=?2 ORDER BY p.id DESC LIMIT 1 ", nativeQuery = true)
  Procedure findLatestProcedureWithCodeAndPatientId(BigInteger patientId, String code);

  @Query(value = "SELECT * FROM `procedure` p LEFT JOIN codeable_concept c on c.id=p.coding " +
      "LEFT JOIN encounter e on p.encounter=e.id " +
      "LEFT JOIN patient pa on pa.id=e.subject where pa.patient_identifier =?1 and c.code=?2 ", nativeQuery = true)
  List<Procedure> findProceduresWithCodeAndPatientId(BigInteger patientIdentifier, String coding);
}
