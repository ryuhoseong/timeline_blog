package io.toy.timeline.domain.embeded;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class TopicEndDt {

  private String topicEndYyyy;

  private String topicEndMm;

  private String topicEndDd;

  //기본생성자가 생성되지 않도록 생성방지
/*  protected TopicEndDt(){
    throw new AssertionError();
  }*/

  public TopicEndDt(String topicEndYyyy, String topicEndMm, String topicEndDd) {
    this.topicEndYyyy = topicEndYyyy;
    this.topicEndMm = topicEndMm;
    this.topicEndDd = topicEndDd;
  }

}
