package io.toy.timeline.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.toy.timeline.domain.Timeline;
import io.toy.timeline.domain.embeded.TopicEndDt;
import io.toy.timeline.domain.embeded.TopicStartDt;
import io.toy.timeline.repository.TimelineRepository;
import io.toy.timeline.service.dto.TimelineDto;
import io.toy.timeline.service.dto.TimelineDto.Create;
import io.toy.topic.domain.Topic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = {TimelineRepository.class})
class TimelineServiceTest {

  @MockBean
  private TimelineRepository timelineRepository;

  private TimelineService timelineService;

  @BeforeEach
  public void init() {
    this.timelineService = new TimelineService(timelineRepository);
  }

  @Test
  void 저장() {

    TopicStartDt topicStartDt = new TopicStartDt("20200227");
    TopicEndDt topicEndDt = new TopicEndDt("20200228");

    Timeline timeline = Timeline.builder()
        .title("Y의 비극")
        .subTitle("부제")
        .content("내용")
        .topicStartDt(topicStartDt)
        .topicEndDt(topicEndDt)
        .build()
        ;

    TimelineDto.Create create = new Create();

    BeanUtils.copyProperties(timeline, create);

    when(timelineRepository.save(any(Timeline.class))).thenReturn(timeline);

    Timeline rsTimeLine = timelineService.save(create);

    assertEquals(timeline.getTitle(), rsTimeLine.getTitle());
    assertEquals(timeline.getTopicStartDt(), rsTimeLine.getTopicStartDt());
    assertEquals(timeline.getTopicEndDt(), rsTimeLine.getTopicEndDt());

  }

}