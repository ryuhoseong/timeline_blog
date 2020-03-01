package io.toy.timeline.repository;

import io.toy.timeline.domain.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelineRepository extends JpaRepository<Timeline, Long> {

}
