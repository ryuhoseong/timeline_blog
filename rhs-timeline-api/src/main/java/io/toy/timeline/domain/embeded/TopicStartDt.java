package io.toy.timeline.domain.embeded;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class TopicStartDt {

  private String topicStartYyyy;

  private String topicStartMm;

  private String topicStartDd;

  //기본생성자가 생성되지 않도록 생성방지
/*  protected TopicStartDt() {
    throw new AssertionError();
  }*/

  public TopicStartDt(String topicStartYyyy, String topicStartMm, String topicStartDd) {
    this.topicStartYyyy = topicStartYyyy;
    this.topicStartMm = topicStartMm;
    this.topicStartDd = topicStartDd;
  }

}
