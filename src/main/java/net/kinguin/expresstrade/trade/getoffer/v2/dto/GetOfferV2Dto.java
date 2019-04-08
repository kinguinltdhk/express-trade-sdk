package net.kinguin.expresstrade.trade.getoffer.v2.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.trade.StandardTradeObject;
import net.kinguin.expresstrade.trade.StandardTradeObjectV2;
import net.kinguin.expresstrade.trade.getoffer.GetOfferV2;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetOfferV2Dto extends ResponseDto {

  private GetOfferV2ResponseDto response;

  @Data
  public static class GetOfferV2ResponseDto {

    private StandardTradeObjectV2 offer;
  }
}
