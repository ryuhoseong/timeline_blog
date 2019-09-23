package io.timelineblog.api.lecture.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.timelineblog.api.core.domain.ApiResponse;
import io.timelineblog.api.lecture.domain.Lecture;
import io.timelineblog.api.lecture.service.LectureService;
import io.timelineblog.api.lecture.service.dto.LectureDto;
import lombok.RequiredArgsConstructor;

@RequestMapping("/timeline/v1")
@RequiredArgsConstructor
@RestController
public class LectureRestController {
  
    private final LectureService lectureService;
	
    @PostMapping("/lecture")
	public ResponseEntity<Object> save(@RequestBody @Valid LectureDto.Create lecture){
	  
      Lecture rsLecture = lectureService.save(lecture);
      
	  ApiResponse<LectureDto.Response> response = new ApiResponse<>(HttpStatus.OK, "success", LectureDto.Response.of(rsLecture));

      return new ResponseEntity<Object>(response, HttpStatus.OK);
	  
	}
    
    @GetMapping("/lecture/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") long id){
      
      Lecture rsLecture = lectureService.findById(id);
      
      ApiResponse<LectureDto.Response> response = new ApiResponse<>(HttpStatus.OK, "success", LectureDto.Response.of(rsLecture));

      return new ResponseEntity<Object>(response, HttpStatus.OK);
      
    }
    
    @PutMapping("/lecture/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid LectureDto.Update lecture){
      
      Lecture rsLecture = lectureService.update(lecture);
      
      ApiResponse<LectureDto.Response> response = new ApiResponse<>(HttpStatus.OK, "success", LectureDto.Response.of(rsLecture));

      return new ResponseEntity<Object>(response, HttpStatus.OK);
      
    }

}
