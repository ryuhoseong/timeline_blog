package io.toy.timeline.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.toy.comment.domain.Comment;
import io.toy.timeline.domain.Timeline;
import io.toy.timeline.domain.embeded.TopicEndDt;
import io.toy.timeline.domain.embeded.TopicStartDt;
import io.toy.topic.domain.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@DataJpaTest
class TimelineRepositoryTest {

  @Autowired
  private TimelineRepository timelineRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  @Test
  void 저장() {

    TopicStartDt topicStartDt = new TopicStartDt("20200227");
    TopicEndDt topicEndDt = new TopicEndDt("2020", "02", "28");

    Topic topic = Topic.builder()
        .name("추리소설")
        .build()
        ;

    testEntityManager.persist(topic);

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

    Timeline rsTimeline = timelineRepository.save(timeline);

    assertEquals(timeline.getTitle(), rsTimeline.getTitle());
    assertEquals(timeline.getTopic().getName(), rsTimeline.getTopic().getName());

  }

}