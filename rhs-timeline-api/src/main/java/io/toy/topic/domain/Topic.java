package io.toy.topic.domain;

import com.sun.javafx.beans.IDProperty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Entity
public class Topic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Topic parent;

  @OneToMany(mappedBy = "parent")
  private List<Topic> child = new ArrayList<>();

  private String creId;

  @CreationTimestamp
  private LocalDateTime creDtt;

  private String updId;

  @UpdateTimestamp
  private LocalDateTime updDtt;

  @Builder
  public Topic(String name, Topic parent, List<Topic> child, String creId,
      LocalDateTime creDtt, String updId, LocalDateTime updDtt) {
    this.name = name;
    this.parent = parent;
    this.child = child;
    this.creId = creId;
    this.creDtt = creDtt;
    this.updId = updId;
    this.updDtt = updDtt;
  }

  public void addChildTopic(Topic topic) {
    if (this.child == null) this.child = new ArrayList<>();
    this.child.add(topic);
  }
}
