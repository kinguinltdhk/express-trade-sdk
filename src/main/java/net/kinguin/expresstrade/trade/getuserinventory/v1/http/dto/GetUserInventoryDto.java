package net.kinguin.expresstrade.trade.getuserinventory.v1.http.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.item.StandardItemObject;
import net.kinguin.expresstrade.user.StandardUserPublicProfileObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetUserInventoryDto extends ResponseDto {

  private GetUserInventoryResponseDto response;

  @Data
  public static class GetUserInventoryResponseDto {

    private Integer total;
    private List<StandardItemObject> items;
    private StandardUserPublicProfileObject user_data;
    private List<Object> sort_parameters;
  }
}
