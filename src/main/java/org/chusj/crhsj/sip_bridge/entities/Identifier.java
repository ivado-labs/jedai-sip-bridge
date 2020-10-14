package org.chusj.crhsj.sip_bridge.entities;

import java.math.BigInteger;

public class Identifier {
  private Long id;
  private CodeableConcept type;
  private BigInteger value;

  public CodeableConcept getType() {
    return type;
  }

  public void setType(CodeableConcept type) {
    this.type = type;
  }

  public BigInteger getValue() {
    return value;
  }

  public void setValue(BigInteger value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Identifier)) {
      return false;
    }

    Identifier that = (Identifier) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (type != null ? !type.equals(that.type) : that.type != null) {
      return false;
    }
    return value != null ? value.equals(that.value) : that.value == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }
}
