package io.timelineblog.api.lecture.service.dto;

import javax.validation.constraints.NotEmpty;
import io.timelineblog.api.lecture.domain.Lecture;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureDto {

  @Getter
  @Setter
  public static class Create {

    @NotEmpty(message = "제목을 확인해주세요.")
    private String title;

    private String subTitle;

    private String content;

    private String creId;


    public Lecture toEntity() {

      return Lecture.builder().title(title).subTitle(subTitle).content(content).creId(creId)
          .build();

    }

  }

  @Getter
  public static class Response {

    private long id;
    
    private String title;

    private String subTitle;

    private String content;

    private String creId;

    @Builder
    public Response(long id, String title, String subTitle, String content, String creId) {
      this.id = id;
      this.title = title;
      this.subTitle = subTitle;
      this.content = content;
      this.creId = creId;

    }

    public static Response of(Lecture lecture) {

      return Response.builder()
          .id(lecture.getId())
          .title(lecture.getTitle())
          .subTitle(lecture.getSubTitle())
          .content(lecture.getContent())
          .creId(lecture.getCreId())
          .build();

    }

  }
  
  @Getter
  @Setter
  public static class Update {
    
    private long id;

    private String title;

    private String subTitle;

    private String content;

    public Lecture apply(Lecture lecture) {
        return lecture.update(id, title, subTitle, content);
    }

  }
}
