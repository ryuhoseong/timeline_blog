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
}
