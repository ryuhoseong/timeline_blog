package io.timelineblog.api.lecture.repository;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import io.timelineblog.api.lecture.domain.Lecture;
import io.timelineblog.api.lecture.service.dto.LectureDto;

@ActiveProfiles("local")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LectureRepositoryTest {

  @Autowired
  LectureRepository lectureRepository;

  @Test
  public void save() {
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

}
