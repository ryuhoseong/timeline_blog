package io.toy.topic.repository;

import static org.junit.jupiter.api.Assertions.*;

import io.toy.topic.domain.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TopicRepositoryTest {

  @Autowired
  private TopicRepository topicRepository;

  @Test
  void 저장(){

    Topic parent = Topic.builder()
        .name("책")
        .build()
        ;

    Topic topic = Topic.builder()
        .name("추리소설")
        .parent(parent)
        .build()
        ;

    Topic rsTopic = topicRepository.save(topic);

    assertEquals(topic.getName(), rsTopic.getName());
    assertEquals(topic.getParent().getName(), rsTopic.getParent().getName());


  }

}