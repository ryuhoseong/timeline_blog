package io.toy.timeline.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Entity
@Table
public class Timeline {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String topic;

  private String title;

  private String subTitle;

  private String content;

  private String topicStartYyyy;

  private String topicStartMm;

  private String topicStartDd;

  private String topicEndYyyy;

  private String topicEndMm;

  private String topicEndDd;

  private String creId;

  @CreationTimestamp
  private LocalDateTime creDtt;

  private String updId;

  @UpdateTimestamp
  private LocalDateTime updDtt;

}
