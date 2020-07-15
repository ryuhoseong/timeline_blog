package io.toy.keyword.repository;

import io.toy.keyword.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

  Keyword findByKeyword(String keyword);

}
