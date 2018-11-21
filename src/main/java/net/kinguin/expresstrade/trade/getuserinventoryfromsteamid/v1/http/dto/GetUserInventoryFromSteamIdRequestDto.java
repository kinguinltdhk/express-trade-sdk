package net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.http.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder()
public class GetUserInventoryFromSteamIdRequestDto {

  private String steam_id;
  private Integer app_id;
  private Integer page;
  private Integer per_page;
  private String search;
  private Integer sort;

  public static GetUserInventoryFromSteamIdRequestDtoBuilder builder(String steam_id,
      Integer app_id) {
    if (steam_id == null) {
      throw new IllegalArgumentException("steam_id parameter is required");
    }
    if (app_id == null) {
      throw new IllegalArgumentException("app_id parameter is required");
    }

    return new GetUserInventoryFromSteamIdRequestDtoBuilder().steam_id(steam_id).app_id(app_id);
  }

}
