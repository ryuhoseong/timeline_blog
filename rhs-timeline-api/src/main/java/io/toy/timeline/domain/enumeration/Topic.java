package io.toy.timeline.domain.enumeration;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum Topic {

  HISTORY("history", "역사"),
  BOOK("book", "책"),
  MOVIE("moive", "영화"),
  SPORTS("sports", "스포츠")
  ;

  private String legacyCode;
  private String desc;

  Topic(String legacyCode, String desc) {
    this.legacyCode = legacyCode;
    this.desc = desc;
  }

  public static Topic ofLegacyCode(String legacyCode) {
    return Arrays.stream(Topic.values())
        .filter(v -> v.getLegacyCode().equals(legacyCode))
        .findAny()
        .orElseThrow(() -> new IllegalStateException(String.format(
            "[%s]가 존재하지 않습니다.", legacyCode)));
  }
}
