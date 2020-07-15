package io.toy.keyword.domain;

import static javax.persistence.FetchType.LAZY;

import io.toy.timelinekeyword.domain.TimelineKeyword;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@NoArgsConstructor
@Entity
public class Keyword {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String keyword;

  @OneToMany(mappedBy = "keyword", cascade = CascadeType.ALL, fetch = LAZY)
  private List<TimelineKeyword> timelineKeywordList;

  private String creId;

  @CreationTimestamp
  private LocalDateTime creDtt;

  private String updId;

  @UpdateTimestamp
  private LocalDateTime updDtt;

  @Builder
  public Keyword(String keyword,
      List<TimelineKeyword> timelineKeywordList, String creId, String updId) {
    this.keyword = keyword;
    this.timelineKeywordList = timelineKeywordList
        == null ? new ArrayList<>() : timelineKeywordList;
    this.creId = creId;
    this.updId = updId;
  }

  public void addTimeLineKeyword(TimelineKeyword timelineKeyword){
    this.timelineKeywordList.add(timelineKeyword);
    timelineKeyword.addKeyword(this);
  }

  public Keyword update(String keyword) {

    this.keyword = keyword;

    return this;

  }
}
