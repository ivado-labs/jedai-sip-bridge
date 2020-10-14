package org.chusj.crhsj.sip_bridge.dao;

import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureDao extends JpaRepository<Procedure, Long> {
  @Query(value = "SELECT * FROM `procedure` p LEFT JOIN codeable_concept c on c.id=p.coding " +
      "LEFT JOIN encounter e on p.encounter=e.id where e.encounter_identifier =?1 and c.code=?2 ", nativeQuery = true)
  Procedure findProceduresByEncounterIdAndCode(BigInteger encounterIdentifier, String coding);

  @Query(value = "SELECT * FROM `procedure` p LEFT JOIN codeable_concept c on c.id=p.coding " +
      "LEFT JOIN encounter e on p.encounter=e.id " +
      "LEFT JOIN patient pa on pa.id=e.subject where pa.patient_identifier =?1 and c.code=?2 ", nativeQuery = true)
  Procedure findProceduresByPatientIdAndCode(BigInteger patientIdentifier, String coding);
}
