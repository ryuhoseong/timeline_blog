package io.timelineblog.api.lecture.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.timelineblog.api.lecture.domain.Lecture;
import io.timelineblog.api.lecture.repository.LectureRepository;
import io.timelineblog.api.lecture.service.dto.LectureDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = {LectureRepository.class})
public class LectureServiceTest {

  @MockBean
  private LectureRepository lectureRepository;

  private LectureService lectureService;
  
  @BeforeEach
  public void init() {
    this.lectureService = new LectureService(lectureRepository);
  }

  @Test
  public void 강의_저장() {

    LectureDto.Create lecture = new LectureDto.Create();

    lecture.setTitle("스프링 프레임워크 핵심 기술");
    lecture.setSubTitle("ApplicationContext 와 다양한 빈 설정방법");
    lecture.setContent("applicationContext");
    lecture.setCreId("QA");

    when(lectureRepository.save(any(Lecture.class))).thenReturn(lecture.toEntity());

    Lecture rsLecture = lectureService.save(lecture);

    assertEquals(lecture.getTitle(), rsLecture.getTitle());
    assertEquals(lecture.getSubTitle(), rsLecture.getSubTitle());
    assertEquals(lecture.getContent(), rsLecture.getContent());
    assertEquals(lecture.getCreId(), rsLecture.getCreId());
  }

}
