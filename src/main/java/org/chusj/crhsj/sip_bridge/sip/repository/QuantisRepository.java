package org.chusj.crhsj.sip_bridge.sip.repository;

import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.sip.entities.Quantis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface QuantisRepository extends JpaRepository<Quantis, Long> {
  @Query(value = "SELECT * FROM quantis where patient_identifier=?1", nativeQuery = true)
  Quantis findByPatientIdentifier(BigInteger patientIdentifier);
}
