package net.kinguin.expresstrade.item.getallitemdefinitions.v1.http.dto;

import lombok.Data;

@Data
public class GetAllItemDefinitionsResponseItemDto {

  private String def_id;
  private Integer internal_app_id;
  private String name;
  private String market_name;
  private String color;
  private String image;
  private Integer suggested_price;
  private Integer suggested_price_floor;
  private Object attributes;
}
