package io.toy.timeline.domain;

import io.toy.comment.domain.Comment;
import io.toy.timeline.domain.embeded.TopicEndDt;
import io.toy.timeline.domain.embeded.TopicStartDt;
import io.toy.topic.domain.Topic;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@NoArgsConstructor
@Entity
public class Timeline {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Topic topic;

  private String title;

  private String subTitle;

  private String content;

  @Embedded
  private TopicStartDt topicStartDt;

  @Embedded
  private TopicEndDt topicEndDt;

  @OneToMany(mappedBy = "timeline")
  private List<Comment> comment = new ArrayList<>();

  private String creId;

  @CreationTimestamp
  private LocalDateTime creDtt;

  private String updId;

  @UpdateTimestamp
  private LocalDateTime updDtt;

  @Builder
  public Timeline(Topic topic, String title, String subTitle, String content,
      TopicStartDt topicStartDt, TopicEndDt topicEndDt,
      List<Comment> comment, String creId, LocalDateTime creDtt, String updId,
      LocalDateTime updDtt) {
    this.topic = topic;
    this.title = title;
    this.subTitle = subTitle;
    this.content = content;
    this.topicStartDt = topicStartDt;
    this.topicEndDt = topicEndDt;
    this.comment = comment;
    this.creId = creId;
    this.creDtt = creDtt;
    this.updId = updId;
    this.updDtt = updDtt;
  }

}
