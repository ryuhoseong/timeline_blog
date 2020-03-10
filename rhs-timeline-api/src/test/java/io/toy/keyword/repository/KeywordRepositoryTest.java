package io.toy.keyword.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.toy.comment.domain.Comment;
import io.toy.keyword.domain.Keyword;
import io.toy.timeline.domain.Timeline;
import io.toy.timeline.domain.embeded.TopicEndDt;
import io.toy.timeline.domain.embeded.TopicStartDt;
import io.toy.timelinekeyword.domain.TimeLineKeyword;
import io.toy.topic.domain.Topic;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@DataJpaTest
class KeywordRepositoryTest {

  @Autowired
  private KeywordRepository keywordRepository;

  @Autowired
  private TestEntityManager testEntityManager;


  @Test
  void 저장_With_Timeline(){

    TopicStartDt topicStartDt = new TopicStartDt("2020", "02", "27");
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

    testEntityManager.persist(timeline);

    TimeLineKeyword timeLineKeyword = TimeLineKeyword.builder()
        .timeline(timeline)
        .creId("QA")
        .build()
        ;

    Keyword keyword = Keyword.builder()
        .keyword("세계3대추리소설")
        .creId("QA")
        .build()
        ;

    keyword.addTimeLineKeyword(timeLineKeyword);

    Keyword rsKeyword = keywordRepository.save(keyword);

    assertEquals(keyword.getKeyword(), rsKeyword.getKeyword());
    assertEquals(keyword.getTimeLineKeywordList().get(0).getTimeline().getTitle(),
        rsKeyword.getTimeLineKeywordList().get(0).getTimeline().getTitle());

  }

}