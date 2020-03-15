package io.toy.keyword.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.toy.keyword.domain.Keyword;
import io.toy.timeline.domain.Timeline;
import io.toy.timeline.domain.embeded.TopicEndDt;
import io.toy.timeline.domain.embeded.TopicStartDt;
import io.toy.timelinekeyword.domain.TimeLineKeyword;
import io.toy.topic.domain.Topic;
import java.util.ArrayList;
import java.util.List;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DataJpaTest
class KeywordRepositoryTest {

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private KeywordRepository keywordRepository;

  private final String NOTFOUND_MESSAGE = "조회된 내역이 없습니다.";


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

    testEntityManager.persist(timeline);

    Timeline rsTimeline = testEntityManager.find(Timeline.class, 1L);

    TimeLineKeyword timeLineKeyword = TimeLineKeyword.builder()
        .timeline(rsTimeline)
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
    assertEquals(keyword.getKeyword(), rsKeyword.getTimeLineKeywordList().get(0).getKeyword().getKeyword());

  }

  @Test
  void 조회_연관된_timeline_반환() throws NotFoundException {

    TopicStartDt topicStartDt = new TopicStartDt("2020", "02", "27");
    TopicEndDt topicEndDt = new TopicEndDt("2020", "02", "28");

    Topic topic = Topic.builder()
        .name("추리소설")
        .build()
        ;

    testEntityManager.persist(topic);

    Timeline timeline1 = Timeline.builder()
        .topic(topic)
        .title("Y의 비극")
        .subTitle("부제1")
        .content("내용1")
        .topicStartDt(topicStartDt)
        .topicEndDt(topicEndDt)
        .build()
        ;

    Timeline timeline2 = Timeline.builder()
        .topic(topic)
        .title("그리고 아무도 없었다")
        .subTitle("부제2")
        .content("내용2")
        .topicStartDt(topicStartDt)
        .topicEndDt(topicEndDt)
        .build()
        ;

    Timeline timeline3 = Timeline.builder()
        .topic(topic)
        .title("환상의 여인")
        .subTitle("부제3")
        .content("내용3")
        .topicStartDt(topicStartDt)
        .topicEndDt(topicEndDt)
        .build()
        ;

    testEntityManager.persist(timeline1);
    testEntityManager.persist(timeline2);
    testEntityManager.persist(timeline3);

    Timeline rsTimeline1 = testEntityManager.find(Timeline.class, 1L);
    Timeline rsTimeline2 = testEntityManager.find(Timeline.class, 2L);
    Timeline rsTimeline3 = testEntityManager.find(Timeline.class, 3L);

    TimeLineKeyword timeLineKeyword1 = TimeLineKeyword.builder()
        .timeline(rsTimeline1)
        .creId("QA")
        .build()
        ;

    TimeLineKeyword timeLineKeyword2 = TimeLineKeyword.builder()
        .timeline(rsTimeline2)
        .creId("QA")
        .build()
        ;

    TimeLineKeyword timeLineKeyword3 = TimeLineKeyword.builder()
        .timeline(rsTimeline3)
        .creId("QA")
        .build()
        ;

    Keyword keyword = Keyword.builder()
        .keyword("세계3대추리소설")
        .creId("QA")
        .build()
        ;

    List<TimeLineKeyword> timeLineKeywordList = new ArrayList<>();
    timeLineKeywordList.add(timeLineKeyword1);
    timeLineKeywordList.add(timeLineKeyword2);
    timeLineKeywordList.add(timeLineKeyword3);

    for (TimeLineKeyword timeLineKeyword: timeLineKeywordList) {

      keyword.addTimeLineKeyword(timeLineKeyword);

    }

    testEntityManager.persist(keyword);

    Keyword findKeyword = keywordRepository.findById(1L).orElseThrow(() -> new NotFoundException(NOTFOUND_MESSAGE));

    assertEquals(keyword.getKeyword(), findKeyword.getKeyword());
    assertEquals(keyword.getTimeLineKeywordList().get(0).getTimeline().getTitle(),
        findKeyword.getTimeLineKeywordList().get(0).getTimeline().getTitle());
    assertEquals(keyword.getTimeLineKeywordList().get(1).getTimeline().getTitle(),
        findKeyword.getTimeLineKeywordList().get(1).getTimeline().getTitle());
    assertEquals(keyword.getTimeLineKeywordList().get(2).getTimeline().getTitle(),
        findKeyword.getTimeLineKeywordList().get(2).getTimeline().getTitle());

  }

  @Test
  void 수정() throws NotFoundException {

    Keyword keyword = Keyword.builder()
        .keyword("세계3대추리소설")
        .creId("QA")
        .build()
        ;
    testEntityManager.persist(keyword);

    Keyword rsKeyword = keywordRepository.findById(1L)
        .orElseThrow(() -> new NotFoundException(NOTFOUND_MESSAGE));

    String updateKeyword = "3대 추리소설";

    rsKeyword.update(updateKeyword);

    assertEquals(updateKeyword, rsKeyword.getKeyword());

  }

  @Test
  void 삭제() throws NotFoundException {

    TopicStartDt topicStartDt = new TopicStartDt("2020", "02", "27");
    TopicEndDt topicEndDt = new TopicEndDt("2020", "02", "28");

    Topic topic = Topic.builder()
        .name("추리소설")
        .build()
        ;

    testEntityManager.persist(topic);

    Timeline timeline1 = Timeline.builder()
        .topic(topic)
        .title("Y의 비극")
        .subTitle("부제1")
        .content("내용1")
        .topicStartDt(topicStartDt)
        .topicEndDt(topicEndDt)
        .build()
        ;

    Timeline timeline2 = Timeline.builder()
        .topic(topic)
        .title("그리고 아무도 없었다")
        .subTitle("부제2")
        .content("내용2")
        .topicStartDt(topicStartDt)
        .topicEndDt(topicEndDt)
        .build()
        ;

    Timeline timeline3 = Timeline.builder()
        .topic(topic)
        .title("환상의 여인")
        .subTitle("부제3")
        .content("내용3")
        .topicStartDt(topicStartDt)
        .topicEndDt(topicEndDt)
        .build()
        ;

    testEntityManager.persist(timeline1);
    testEntityManager.persist(timeline2);
    testEntityManager.persist(timeline3);

    Timeline rsTimeline1 = testEntityManager.find(Timeline.class, 1L);
    Timeline rsTimeline2 = testEntityManager.find(Timeline.class, 2L);
    Timeline rsTimeline3 = testEntityManager.find(Timeline.class, 3L);

    TimeLineKeyword timeLineKeyword1 = TimeLineKeyword.builder()
        .timeline(rsTimeline1)
        .creId("QA")
        .build()
        ;

    TimeLineKeyword timeLineKeyword2 = TimeLineKeyword.builder()
        .timeline(rsTimeline2)
        .creId("QA")
        .build()
        ;

    TimeLineKeyword timeLineKeyword3 = TimeLineKeyword.builder()
        .timeline(rsTimeline3)
        .creId("QA")
        .build()
        ;

    Keyword keyword = Keyword.builder()
        .keyword("세계3대추리소설")
        .creId("QA")
        .build()
        ;

    List<TimeLineKeyword> timeLineKeywordList = new ArrayList<>();
    timeLineKeywordList.add(timeLineKeyword1);
    timeLineKeywordList.add(timeLineKeyword2);
    timeLineKeywordList.add(timeLineKeyword3);

    for (TimeLineKeyword timeLineKeyword: timeLineKeywordList) {

      keyword.addTimeLineKeyword(timeLineKeyword);

    }

    testEntityManager.persist(keyword);

    Keyword findKeyword = keywordRepository.findById(1L).orElseThrow(() -> new NotFoundException(NOTFOUND_MESSAGE));

    keywordRepository.delete(findKeyword);

    Throwable e = assertThrows(NotFoundException.class, () -> {
      Keyword delKeyword = keywordRepository.findById(1L)
          .orElseThrow(()->new NotFoundException(NOTFOUND_MESSAGE));
    });

    assertEquals(NOTFOUND_MESSAGE, e.getMessage());

  }

}