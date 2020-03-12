package io.toy.keyword.domain;

import io.toy.timelinekeyword.domain.TimeLineKeyword;
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

  @OneToMany(mappedBy = "keyword", cascade = CascadeType.ALL)
  private List<TimeLineKeyword> timeLineKeywordList;

  private String creId;

  @CreationTimestamp
  private LocalDateTime creDtt;

  private String updId;

  @UpdateTimestamp
  private LocalDateTime updDtt;

  @Builder
  public Keyword(String keyword,
      List<TimeLineKeyword> timeLineKeywordList, String creId, LocalDateTime creDtt,
      String updId, LocalDateTime updDtt) {
    this.keyword = keyword;
    this.timeLineKeywordList = timeLineKeywordList == null ? new ArrayList<>() : timeLineKeywordList;
    this.creId = creId;
    this.creDtt = creDtt;
    this.updId = updId;
    this.updDtt = updDtt;
  }

  public void addTimeLineKeyword(TimeLineKeyword timeLineKeyword){
    this.timeLineKeywordList.add(timeLineKeyword);
    timeLineKeyword.addKeyword(this);
  }
}
