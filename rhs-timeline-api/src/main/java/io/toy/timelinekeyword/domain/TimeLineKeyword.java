package io.toy.timelinekeyword.domain;

import io.toy.keyword.domain.Keyword;
import io.toy.timeline.domain.Timeline;
import java.security.Key;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class TimeLineKeyword {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Keyword keyword;

  @ManyToOne(fetch = FetchType.LAZY)
  private Timeline timeline;

  private String creId;

  @CreationTimestamp
  private LocalDateTime creDtt;

  private String updId;

  @UpdateTimestamp
  private LocalDateTime updDtt;

  @Builder
  public TimeLineKeyword(Keyword keyword, Timeline timeline, String creId, String updId) {
    this.keyword = keyword == null ? new Keyword() : keyword;
    this.timeline = timeline == null ? new Timeline() : timeline;
    this.creId = creId;
    this.updId = updId;
  }

  public void addTimeline(Timeline timeline){
    this.timeline = timeline;
  }

  public void addKeyword(Keyword keyword) {
    this.keyword = keyword;
  }

}
