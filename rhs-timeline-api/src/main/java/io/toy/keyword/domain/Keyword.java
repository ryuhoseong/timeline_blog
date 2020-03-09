package io.toy.keyword.domain;

import io.toy.timelinekeyword.domain.TimeLineKeyword;
import java.time.LocalDateTime;
import java.util.List;
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
public class Keyword {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String keyword;

  @OneToMany(mappedBy = "keyword")
  private List<TimeLineKeyword> timeLineKeywordList;

  private String creId;

  @CreationTimestamp
  private LocalDateTime creDtt;

  private String updId;

  @UpdateTimestamp
  private LocalDateTime updDtt;


}
