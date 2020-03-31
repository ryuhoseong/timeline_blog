package io.toy.timeline.service;

import io.toy.timeline.repository.TimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TimelineService {

  private final TimelineRepository timelineRepository;

}
