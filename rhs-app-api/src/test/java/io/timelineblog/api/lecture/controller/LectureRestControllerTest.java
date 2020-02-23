package io.timelineblog.api.lecture.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.timelineblog.api.lecture.service.LectureService;
import io.timelineblog.api.lecture.service.dto.LectureDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(LectureRestController.class)
public class LectureRestControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private LectureService lectureService;
  
  @Test
  public void 강의_저장() throws Exception {
    
    LectureDto.Create lecture = new LectureDto.Create();

    lecture.setTitle("스프링 프레임워크 핵심 기술");
    lecture.setSubTitle("ApplicationContext와 다양한 빈 설정방법");
    lecture.setContent("applicationContext");
    lecture.setCreId("QA");
    
    when(lectureService.save(any(LectureDto.Create.class))).thenReturn(lecture.toEntity());
    
    ObjectMapper objectMapper = new ObjectMapper();
    String lectureStr  = objectMapper.writeValueAsString(lecture);
    
    mockMvc.perform(post("/timeline/v1/lecture")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(lectureStr)
        )
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.message", containsString("success")))
    .andExpect(jsonPath("$.result.title", containsString("스프링 프레임워크 핵심 기술")))
    .andDo(print())
    ;
    
  }

}
