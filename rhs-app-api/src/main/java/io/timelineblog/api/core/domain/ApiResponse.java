package io.timelineblog.api.core.domain;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {

  private HttpStatus status;
  private String message;
  private T result;

}
