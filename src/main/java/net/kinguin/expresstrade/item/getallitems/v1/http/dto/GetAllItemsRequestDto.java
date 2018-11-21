package net.kinguin.expresstrade.item.getallitems.v1.http.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder()
public class GetAllItemsRequestDto {

  private Integer app_id;
  private String sku;
  private String name;
  private Integer page;
  private Integer per_page;
  private Integer sort;
  private Boolean no_exclusions;

  public static GetAllItemsRequestDtoBuilder builder(Integer app_id) {
    if (app_id == null) {
      throw new IllegalArgumentException("app_id parameter is required");
    }

    return new GetAllItemsRequestDtoBuilder().app_id(app_id);
  }
}
