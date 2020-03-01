package io.toy.timeline.domain;

import io.toy.comment.domain.Comment;
import io.toy.timeline.domain.embeded.TopicEndDt;
import io.toy.timeline.domain.embeded.TopicStartDt;
import io.toy.timeline.domain.enumeration.Topic;
import io.toy.timeline.domain.enumeration.TopicConverter;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Entity
public class Timeline {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Convert(converter = TopicConverter.class)
  private Topic topic;

  private String title;

  private String subTitle;

  private String content;

  @Embedded
  private TopicStartDt topicStartDt;

  @Embedded
  private TopicEndDt topicEndDt;

  @OneToMany(mappedBy = "timeline")
  private List<Comment> comment;

  private String creId;

  @CreationTimestamp
  private LocalDateTime creDtt;

  private String updId;

  @UpdateTimestamp
  private LocalDateTime updDtt;

}
