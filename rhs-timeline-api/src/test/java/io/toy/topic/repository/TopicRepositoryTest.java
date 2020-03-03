package io.toy.topic.repository;

import static org.junit.jupiter.api.Assertions.*;

import io.toy.topic.domain.Topic;
import java.util.Optional;
import javassist.NotFoundException;
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


  @Test
  void 최상위_TOPIC_조회() throws NotFoundException {

    Topic topic = Topic.builder()
        .name("책")
        .build()
        ;

    testEntityManager.persist(topic);

    Topic rsTopic = topicRepository.findById(1L)
        .orElseThrow(() -> new NotFoundException("조회된 내역이 없습니다."));

    assertEquals(topic.getName(), rsTopic.getName());

  }

  @Test
  void 하위_TOPIC_조회() throws NotFoundException {

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

    testEntityManager.persist(topic);

    Topic rsTopic = topicRepository.findById(2L)
        .orElseThrow(()->new NotFoundException("조회된 내역이 없습니다"));


    assertEquals(topic.getName(), rsTopic.getName());
    assertEquals(topic.getParent().getName(), rsTopic.getParent().getName());

  }

  @Test
  void 중간_TOPIC_조회() throws NotFoundException {

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

    testEntityManager.persist(topic);

    Topic rsParent2 = testEntityManager.find(Topic.class, 2L);

    Topic child = Topic.builder()
        .name("Y의 비극")
        .parent(rsParent2)
        .build()
        ;
    testEntityManager.persist(child);

    Topic child2 = Topic.builder()
        .name("환상의 여의")
        .parent(rsParent2)
        .build()
        ;
    testEntityManager.persist(child2);

    rsParent2.addChildTopic(child);
    rsParent2.addChildTopic(child2);

    Topic rsTopic = topicRepository.findById(2L)
        .orElseThrow(()->new NotFoundException("조회된 내역이 없습니다"));


    assertEquals(topic.getName(), rsTopic.getName());
    assertEquals(topic.getParent().getName(), rsTopic.getParent().getName());
    assertEquals(2, rsTopic.getChild().size());

  }

  @Test
  void TOPIC_NAME_수정() throws NotFoundException {
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

    testEntityManager.persist(topic);

    String updateName = "SF소설";

    Topic rsTopic = topicRepository.findById(2L)
        .orElseThrow(()->new NotFoundException("조회된 내역이 없습니다"));
    rsTopic.update(updateName);

    assertEquals(updateName, rsTopic.getName());
    assertEquals(topic.getParent().getName(), rsTopic.getParent().getName());
  }
}