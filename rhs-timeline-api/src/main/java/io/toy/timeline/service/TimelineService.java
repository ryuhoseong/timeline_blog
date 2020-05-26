package io.toy.timeline.service;

import io.toy.timeline.domain.Timeline;
import io.toy.timeline.repository.TimelineRepository;
import io.toy.timeline.service.dto.TimelineDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TimelineService {

  private final TimelineRepository timelineRepository;

  public Timeline save(TimelineDto.Create create) {

    //TODO notfound exception 처리
    //if (StringUtils.isEmpty(timeline.getTitle()));

    return timelineRepository.save(create.toEntity());
  }

}
