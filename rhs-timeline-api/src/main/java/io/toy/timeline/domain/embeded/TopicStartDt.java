package io.toy.timeline.domain.embeded;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class TopicStartDt {

  private String topicStartYyyymmdd;

  private String topicStartYyyy;

  private String topicStartMm;

  private String topicStartDd;


  public TopicStartDt(String topicStartYyyymmdd) {
    this.topicStartYyyymmdd = topicStartYyyymmdd;
    this.topicStartYyyy = topicStartYyyymmdd.substring(0, 4);
    this.topicStartMm = topicStartYyyymmdd.substring(4, 6);
    this.topicStartDd = topicStartYyyymmdd.substring(6);
  }


}
