package io.timelineblog.api.lecture.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import io.timelineblog.api.lecture.domain.Lecture;
import io.timelineblog.api.lecture.repository.LectureRepository;
import io.timelineblog.api.lecture.service.dto.LectureDto;

@ActiveProfiles("Local")
public class LectureServiceTest {

  @MockBean
  private LectureRepository lectureRepository;

  private LectureService lectureService;
  
  @Before
  public void intit() {
    this.lectureService = new LectureService(lectureRepository);
  }

  @Test
  public void 강의_저장() {

    LectureDto.Create lecture = new LectureDto.Create();

    lecture.setTitle("스프링 프레임워크 핵심 기술");
    lecture.setSubTitle("ApplicationContext와 다양한 빈 설정방법");
    lecture.setContent("applicationContext");
    lecture.setCreId("QA");

    given(lectureRepository.save(any(Lecture.class))).willReturn(lecture.toEntity());

    Lecture rsLecture = lectureService.save(lecture);

    assertEquals(lecture.getTitle(), rsLecture.getTitle());
    assertEquals(lecture.getSubTitle(), rsLecture.getSubTitle());
    assertEquals(lecture.getContent(), rsLecture.getContent());
    assertEquals(lecture.getCreId(), rsLecture.getCreId());
  }

}
