package net.kinguin.expresstrade.trade.getuserinventory.v1.http.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder()
public class GetUserInventoryRequestDto {

  private Integer uid;
  private Integer app_id;
  private Integer page;
  private Integer per_page;
  private String search;
  private Integer sort;

  public static GetUserInventoryRequestDtoBuilder builder(Integer uid, Integer app_id) {
    if (uid == null) {
      throw new IllegalArgumentException("uid parameter is required");
    }
    if (app_id == null) {
      throw new IllegalArgumentException("app_id parameter is required");
    }

    return new GetUserInventoryRequestDtoBuilder().uid(uid).app_id(app_id);
  }
}
