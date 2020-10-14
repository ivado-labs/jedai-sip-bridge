package org.chusj.crhsj.sip_bridge.entities.converters;

import java.math.BigInteger;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.chusj.crhsj.sip_bridge.entities.DataException;
import org.chusj.crhsj.sip_bridge.entities.Identifier;

@Converter
public class IdentifierConverter implements
    AttributeConverter<Identifier, BigInteger> {
  @Override
  public BigInteger convertToDatabaseColumn(Identifier identifier) {
    if (identifier != null && identifier.getValue()!=null) {
      return identifier.getValue();
    }
    throw new DataException("Unable to convert identifier to database column, identifier value is null");
  }

  @Override
  public Identifier convertToEntityAttribute(BigInteger value) {
    var identifier = new Identifier();
    identifier.setValue(value);
    return identifier;
  }
}
