package net.kinguin.expresstrade.trade.getoffers.v1.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.trade.StandardTradeObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetOffersDto extends ResponseDto {

  private GetOffersResponseDto response;

  @Data
  public static class GetOffersResponseDto {

    private List<StandardTradeObject> offers;
    private Integer total;
  }
}
