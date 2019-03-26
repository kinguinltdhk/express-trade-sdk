package net.kinguin.expresstrade.trade.getuserinventory.v2.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.item.StandardItemObject;
import net.kinguin.expresstrade.item.StandardItemObjectV2;
import net.kinguin.expresstrade.user.StandardUserPublicProfileObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetUserInventoryV2Dto extends ResponseDto {

  private GetUserInventoryResponseDto response;

  @Data
  public static class GetUserInventoryResponseDto {

    private Integer total;
    private List<StandardItemObjectV2> items;
    private StandardUserPublicProfileObject user_data;
    private List<Object> sort_parameters;
  }
}
