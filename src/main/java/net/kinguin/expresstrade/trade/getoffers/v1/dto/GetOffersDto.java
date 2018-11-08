package net.kinguin.expresstrade.trade.getoffers.v1.dto;

import java.util.List;
import lombok.Data;
import net.kinguin.expresstrade.trade.StandardTradeObject;

@Data
public class GetOffersDto {

  private GetOffersResponseDto response;

  @Data
  public static class GetOffersResponseDto {

    private List<StandardTradeObject> offers;
    private Integer total;
  }
}
