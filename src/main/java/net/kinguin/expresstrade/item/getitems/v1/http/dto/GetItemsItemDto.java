package net.kinguin.expresstrade.item.getitems.v1.http.dto;

import java.util.Map;
import lombok.Data;

@Data
public class GetItemsItemDto {

  private String name;
  private String category;
  private String rarity;
  private String type;
  private String color;
  private Map<String, String> image;
  private Integer suggested_price;
  private Integer paint_index;
}
