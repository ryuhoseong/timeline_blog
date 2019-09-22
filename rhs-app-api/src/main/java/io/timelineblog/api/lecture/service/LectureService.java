package io.timelineblog.api.lecture.service;

import org.springframework.stereotype.Service;

import io.timelineblog.api.lecture.domain.Lecture;
import io.timelineblog.api.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LectureService {
	
	private final LectureRepository lectureRepository;
	

	public Lecture save(Lecture lecture) {
		return lectureRepository.save(lecture);
	}

}
