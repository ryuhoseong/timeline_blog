package io.timelineblog.api.lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.timelineblog.api.lecture.domain.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long>{

}
