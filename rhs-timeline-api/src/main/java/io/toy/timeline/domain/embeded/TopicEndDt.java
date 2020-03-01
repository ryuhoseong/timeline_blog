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

}
