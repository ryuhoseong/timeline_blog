package io.toy.topic.repository;

import static org.junit.jupiter.api.Assertions.*;

import io.toy.topic.domain.Topic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class TopicRepositoryTest {

  @Autowired
  private TopicRepository topicRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  @Test
  void TOPIC_저장(){

    Topic parent = Topic.builder()
        .name("책")
        .build()
        ;

    testEntityManager.persist(parent);

    Topic rsParent = testEntityManager.find(Topic.class, 1L);

    Topic topic = Topic.builder()
        .name("추리소설")
        .parent(rsParent)
        .build()
        ;

    Topic rsTopic = topicRepository.save(topic);

    assertEquals(topic.getName(), rsTopic.getName());
    assertEquals(topic.getParent().getName(), rsTopic.getParent().getName());


  }

}