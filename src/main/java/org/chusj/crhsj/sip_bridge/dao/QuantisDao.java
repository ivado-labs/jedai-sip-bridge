package org.chusj.crhsj.sip_bridge.dao;

import java.math.BigInteger;
import org.chusj.crhsj.sip_bridge.entities.Quantis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantisDao extends JpaRepository<Quantis, Long> {
  @Query(value = "SELECT * FROM quantis where patient_identifier=?1", nativeQuery = true)
  Quantis findByPatientIdentifier(BigInteger patientIdentifier);
}
