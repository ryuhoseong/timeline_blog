package io.timelineblog.api.lecture.repository;

import io.timelineblog.api.core.domain.exception.NotFoundException;
import io.timelineblog.api.lecture.domain.Lecture;
import io.timelineblog.api.lecture.service.dto.LectureDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@DataJpaTest
public class LectureRepositoryTest {

  @Autowired
  LectureRepository lectureRepository;

  @Test
  public void 강의_저장() {
    LectureDto.Create lecture = new LectureDto.Create();

    lecture.setTitle("스프링 프레임워크 핵심 기술");
    lecture.setSubTitle("ApplicationContext와 다양한 빈 설정방법");
    lecture.setContent("applicationContext");
    lecture.setCreId("QA");

    Lecture rsLecture = lectureRepository.save(lecture.toEntity());

    assertEquals(lecture.getTitle(), rsLecture.getTitle());
    assertEquals(lecture.getSubTitle(), rsLecture.getSubTitle());
    assertEquals(lecture.getContent(), rsLecture.getContent());
    assertEquals(lecture.getCreId(), rsLecture.getCreId());
  }
  
  @Test
  public void 아이디_강의_조회() {
    
    LectureDto.Create lecture = new LectureDto.Create();

    lecture.setTitle("스프링 프레임워크 핵심 기술");
    lecture.setSubTitle("ApplicationContext와 다양한 빈 설정방법");
    lecture.setContent("applicationContext");
    lecture.setCreId("QA");

    lectureRepository.save(lecture.toEntity());
    
    Lecture rsLecture = lectureRepository.findById(1L).orElseThrow(() -> new NotFoundException("조회된 내역이 없습니다."));
    
    assertEquals(lecture.getTitle(), rsLecture.getTitle());
    assertEquals(lecture.getSubTitle(), rsLecture.getSubTitle());
    assertEquals(lecture.getContent(), rsLecture.getContent());
    assertEquals(lecture.getCreId(), rsLecture.getCreId());
    
  }

}
