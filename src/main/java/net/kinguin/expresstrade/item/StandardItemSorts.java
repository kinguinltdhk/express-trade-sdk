package net.kinguin.expresstrade.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StandardItemSorts {
  ASC_NAME(1),
  DESC_NAME(2),
  ASC_LAST_UPDATE(3),
  DESC_LAST_UPDATE(4),
  ASC_SUGGESTED_PRICE(5),
  DESC_SUGGESTED_PRICE(6),
  ASC_ID(7),
  DESC_ID(8);

  private Integer value;
}
