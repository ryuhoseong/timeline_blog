package io.toy.topic.service.dto;

import io.toy.topic.domain.Topic;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TopicDto {

  @Getter
  @Setter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class Create {

    private String name;

    private Topic parent;

    private List<Topic> child;

    private String creId;

    public Create(String name) {
      this.name = name;
    }

    public Topic toEntity () {
      return Topic.builder()
          .name(this.name)
          .parent(this.parent)
          .child(this.child)
          .creId(this.creId)
          .build()
          ;
    }
  }

}
