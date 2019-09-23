package io.timelineblog.api.lecture.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import io.timelineblog.api.lecture.domain.Lecture;
import io.timelineblog.api.lecture.repository.LectureRepository;

@ActiveProfiles("Local")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LectureService.class)
public class LectureServiceTest {

  @MockBean
  private LectureRepository lectureRepository;

  @Autowired
  private LectureService lectureService;

  @Test
  public void save() {

    Lecture lecture = new Lecture();

    lecture.setTitle("스프링 프레임워크 핵심 기술");
    lecture.setSubTitle("ApplicationContext와 다양한 빈 설정방법");
    lecture.setContent("applicationContext");
    lecture.setCreId("QA");

    given(lectureRepository.save(any(Lecture.class))).willReturn(lecture);

    Lecture rsLecture = lectureService.save(lecture);

    assertEquals(lecture.getTitle(), rsLecture.getTitle());
    assertEquals(lecture.getSubTitle(), rsLecture.getSubTitle());
    assertEquals(lecture.getContent(), rsLecture.getContent());
    assertEquals(lecture.getCreId(), rsLecture.getCreId());
  }

}
