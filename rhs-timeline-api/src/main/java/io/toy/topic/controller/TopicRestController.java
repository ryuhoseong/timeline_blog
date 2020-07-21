package io.toy.topic.controller;

import io.toy.topic.service.TopicService;
import io.toy.topic.service.dto.TopicDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class TopicRestController {

  private final TopicService topicService;

  public void save(TopicDto.Create create) {

    topicService.save(create);

  }

}
