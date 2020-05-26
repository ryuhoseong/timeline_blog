package io.toy.timeline.service.dto;

import io.toy.comment.domain.Comment;
import io.toy.timeline.domain.Timeline;
import io.toy.timeline.domain.embeded.TopicEndDt;
import io.toy.timeline.domain.embeded.TopicStartDt;
import io.toy.timelinekeyword.domain.TimeLineKeyword;
import io.toy.topic.domain.Topic;
import java.util.List;
import javax.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

public class TimeLineDto {

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

    private List<TimeLineKeyword> timeLineKeywords;

    private String creId;

    public Timeline toEntity (){
      return Timeline.builder()
          .topic(this.topic)
          .title(this.title)
          .subTitle(this.subTitle)
          .content(this.content)
          .topicStartDt(this.topicStartDt)
          .topicEndDt(this.topicEndDt)
          .timeLineKeywords(this.timeLineKeywords)
          .creId(this.creId)
          .build();
    }

  }

}
