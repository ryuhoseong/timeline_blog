package io.toy.timeline.service.dto;

import io.toy.timeline.domain.Timeline;
import io.toy.timeline.domain.embeded.TopicEndDt;
import io.toy.timeline.domain.embeded.TopicStartDt;
import io.toy.timelinekeyword.domain.TimelineKeyword;
import io.toy.topic.domain.Topic;
import java.util.List;
import javax.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

public class TimelineDto {

  @Getter
  @Setter
  public static class Create {

    private Topic topic;

    private String title;

    private String subTitle;

    private String content;

    @Embedded
    private TopicStartDt topicStartDt;

    @Embedded
    private TopicEndDt topicEndDt;

    private List<TimelineKeyword> timelineKeywords;

    private String creId;

    public Timeline toEntity (){
      return Timeline.builder()
          .topic(this.topic)
          .title(this.title)
          .subTitle(this.subTitle)
          .content(this.content)
          .topicStartDt(this.topicStartDt)
          .topicEndDt(this.topicEndDt)
          .timelineKeywords(this.timelineKeywords)
          .creId(this.creId)
          .build();
    }

  }

}
