package io.toy.timeline.domain.enumeration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TopicConverter implements AttributeConverter<Topic, String> {

  @Override
  public String convertToDatabaseColumn(Topic attribute) {

    return attribute.getLegacyCode();
  }

  @Override
  public Topic convertToEntityAttribute(String dbData) {

    return Topic.ofLegacyCode(dbData);
  }

}
