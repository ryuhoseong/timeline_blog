package io.toy.timeline.domain.embeded;

import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class TopicStartDt {

  private String topicStartDt;

  private String topicStartYyyy;

  private String topicStartMm;

  private String topicStartDd;


  public TopicStartDt(String topicStartDt) {
    this.topicStartDt = topicStartDt;
    this.topicStartYyyy = topicStartDt.substring(0, 4);
    this.topicStartMm = topicStartDt.substring(4, 6);
    this.topicStartDd = topicStartDt.substring(6);
  }

  public String getTopicStartDt() {
    return topicStartDt;
  }

  public String getTopicStartYyyy() {
    return topicStartYyyy;
  }

  public String getTopicStartMm() {
    return topicStartMm;
  }

  public String getTopicStartDd() {
    return topicStartDd;
  }

}
