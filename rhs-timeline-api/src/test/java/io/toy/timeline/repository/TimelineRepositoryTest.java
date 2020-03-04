package io.toy.timeline.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.toy.comment.domain.Comment;
import io.toy.timeline.domain.Timeline;
import io.toy.timeline.domain.embeded.TopicEndDt;
import io.toy.timeline.domain.embeded.TopicStartDt;
import io.toy.timeline.domain.enumeration.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@DataJpaTest
class TimelineRepositoryTest {

  @Autowired
  private TimelineRepository timelineRepository;

  @Test
  void 저장() {

    TopicStartDt topicStartDt = new TopicStartDt("2020", "02", "27");
    TopicEndDt topicEndDt = new TopicEndDt("2020", "02", "28");

    Timeline timeline = Timeline.builder()
        .topic(Topic.BOOK)
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

    Timeline rsTimeline = timelineRepository.save(timeline);

    assertEquals(rsTimeline.getTitle(), timeline.getTitle());



  }

}