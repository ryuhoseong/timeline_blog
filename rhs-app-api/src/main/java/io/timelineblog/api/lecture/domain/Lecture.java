package io.timelineblog.api.lecture.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "LECTURE")
public class Lecture {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;

  private String subTitle;

  private String content;

  private String creId;

  @CreationTimestamp
  private LocalDateTime creDtt;

  private String updId;

  @UpdateTimestamp
  private LocalDateTime updDtt;

  @Builder
  public Lecture(String title, String subTitle, String content, String creId) {

    this.title      = title;

    this.subTitle   = subTitle;

    this.content    = content;
    
    this.creId      = creId;

  }

  public Lecture update(long id, String title, String subTitle, String contentc) {
   
    this.id         = id;    
    this.title      = title;
    this.subTitle   = subTitle;
    this.content    = contentc;

    return this;
  }

}
