package net.kinguin.expresstrade.item;

import java.util.Map;
import lombok.Data;

@Data
public class StandardItemObject {

  private Integer id;
  private Integer internal_app_id;
  private Integer sku;
  private Double wear;
  private Integer trade_hold_expires;
  private String name;
  private String category;
  private String rarity;
  private String type;
  private String color;
  private Map<String, String> image;
  private Integer suggested_price;
  private Integer suggested_price_floor;
  private Map<String, String> preview_urls;
  private String inspect;
  private String eth_inspect;
  private Integer pattern_index;
  private Integer paint_index;
  private Integer wear_tier_index;
  private Boolean tradable;
}
