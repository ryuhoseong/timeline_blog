package io.toy.topic.service;

import io.toy.topic.domain.Topic;
import io.toy.topic.repository.TopicRepository;
import io.toy.topic.service.dto.TopicDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TopicService {

  private final TopicRepository topicRepository;

  public Topic save(TopicDto.Create create) {
    return topicRepository.save(create.toEntity());
  }

}
