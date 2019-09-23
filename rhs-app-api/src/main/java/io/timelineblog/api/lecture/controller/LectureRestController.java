package io.timelineblog.api.lecture.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.timelineblog.api.core.domain.ApiResponse;
import io.timelineblog.api.lecture.domain.Lecture;
import io.timelineblog.api.lecture.service.LectureService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/timeline/v1")
@RequiredArgsConstructor
@RestController
public class LectureRestController {
  
    private final LectureService lectureService;
	
    @PostMapping("/lecture")
	public ResponseEntity<Object> save(Lecture lecture){
	  
      Lecture rsLecture = lectureService.save(lecture);
      
	  ApiResponse<Lecture> response = new ApiResponse<>(HttpStatus.OK, "success", rsLecture);

      return new ResponseEntity<Object>(response, HttpStatus.OK);
	  
	}

}
