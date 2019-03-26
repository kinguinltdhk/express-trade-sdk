package net.kinguin.expresstrade.item;

import java.util.Map;
import lombok.Data;

@Data
public class StandardItemObjectV2 {

  private Integer id;
  private Integer internal_app_id;
  private String name;
  private String color;
  private String image;
  private Integer suggested_price;
  private Integer suggested_price_floor;
  private Boolean tradable;
  private Boolean is_trade_restricted;
  private Map<String, Object> attributes;
}
