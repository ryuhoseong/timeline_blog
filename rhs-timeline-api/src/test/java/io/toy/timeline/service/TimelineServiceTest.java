package io.toy.timeline.service;

import io.toy.comment.domain.Comment;
import io.toy.timeline.domain.Timeline;
import io.toy.timeline.domain.embeded.TopicEndDt;
import io.toy.timeline.domain.embeded.TopicStartDt;
import io.toy.timeline.repository.TimelineRepository;
import io.toy.topic.domain.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

class TimelineServiceTest {

  @MockBean
  private TimelineRepository timelineRepository;

  private TimelineService timelineService = new TimelineService(timelineRepository);

  @Test
  void 저장() {

    TopicStartDt topicStartDt = new TopicStartDt("2020", "02", "27");
    TopicEndDt topicEndDt = new TopicEndDt("2020", "02", "28");

    Topic topic = Topic.builder()
        .name("추리소설")
        .build()
        ;

    Timeline timeline = Timeline.builder()
        .topic(topic)
        .title("Y의 비극")
        .subTitle("부제")
        .content("내용")
        .topicStartDt(topicStartDt)
        .topicEndDt(topicEndDt)
        .build()
        ;

    Comment comment = Comment.builder()
        .message("comment message")
        .timeline(timeline)
        .build()
        ;

  }

}