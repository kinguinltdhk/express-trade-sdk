package net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.http.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.item.StandardItemObject;
import net.kinguin.expresstrade.user.StandardUserPublicProfileObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetUserInventoryFromSteamIdDto extends ResponseDto {

  private GetUserInventoryFromSteamIdDtoResponseDto response;

  @Data
  public static class GetUserInventoryFromSteamIdDtoResponseDto {

    private Integer total;
    private List<StandardItemObject> items;
    private StandardUserPublicProfileObject user_data;
    private List<Object> sort_parameters;
  }
}
