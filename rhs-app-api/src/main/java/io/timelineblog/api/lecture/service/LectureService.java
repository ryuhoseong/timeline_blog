package io.timelineblog.api.lecture.service;

import io.timelineblog.api.core.domain.exception.NotFoundException;
import io.timelineblog.api.lecture.domain.Lecture;
import io.timelineblog.api.lecture.repository.LectureRepository;
import io.timelineblog.api.lecture.service.dto.LectureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LectureService {

  private final LectureRepository lectureRepository;
  

  public Lecture save(LectureDto.Create lecture) {
    return lectureRepository.save(lecture.toEntity());
  }

  public Lecture findById(long id) {
    return lectureRepository.findById(id).orElseThrow(() -> new NotFoundException("조회된 내역이 없습니다."));
  }

  @Transactional
  public Lecture update(LectureDto.Update lecture) {

    Lecture rsLecture = lectureRepository.findById(lecture.getId())
        .map(lecture::apply).orElseThrow(() -> new NotFoundException("조회된 내역이 없습니다."));

    return rsLecture;

  }

}
