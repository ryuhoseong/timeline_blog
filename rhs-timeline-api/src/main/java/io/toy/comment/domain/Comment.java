package io.toy.comment.domain;

import io.toy.timeline.domain.Timeline;
import java.nio.MappedByteBuffer;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@NoArgsConstructor
@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private long parentId;

  private String message;

  @ManyToOne
  private Timeline timeline;

  private String creId;

  @CreationTimestamp
  private LocalDateTime creDtt;

  private String updId;

  @UpdateTimestamp
  private LocalDateTime updDtt;

  @Builder
  public Comment(long parentId, String message,
      Timeline timeline, String creId, LocalDateTime creDtt, String updId,
      LocalDateTime updDtt) {
    this.parentId = parentId;
    this.message = message;
    this.timeline = timeline;
    this.creId = creId;
    this.creDtt = creDtt;
    this.updId = updId;
    this.updDtt = updDtt;
  }
}
