package io.toy.keyword.service;

import io.toy.keyword.domain.Keyword;
import io.toy.keyword.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KeywordService {

  private final KeywordRepository keywordRepository;

  public Keyword findByKeyword(String keyword) {
    return keywordRepository.findByKeyword(keyword);
  }

}
