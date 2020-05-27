package io.toy.timeline.domain.embeded;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class TopicEndDt {

  private String topicEndYyyymmdd;

  private String topicEndYyyy;

  private String topicEndMm;

  private String topicEndDd;

  public TopicEndDt(String topicEndYyyymmdd) {
    this.topicEndYyyymmdd = topicEndYyyymmdd;
    this.topicEndYyyy = topicEndYyyymmdd.substring(0, 4);
    this.topicEndMm = topicEndYyyymmdd.substring(4, 6);
    this.topicEndDd = topicEndYyyymmdd.substring(6);
  }

}
