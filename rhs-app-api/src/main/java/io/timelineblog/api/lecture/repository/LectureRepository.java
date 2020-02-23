package io.timelineblog.api.lecture.repository;

import io.timelineblog.api.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long>{

}
