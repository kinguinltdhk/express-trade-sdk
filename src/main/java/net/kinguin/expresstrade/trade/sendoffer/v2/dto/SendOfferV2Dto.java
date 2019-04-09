package net.kinguin.expresstrade.trade.sendoffer.v2.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.trade.StandardTradeObjectV2;

@Data
@EqualsAndHashCode(callSuper = false)
public class SendOfferV2Dto extends ResponseDto {

  private SendOfferResponseDto response;

  @Data
  public static class SendOfferResponseDto {

    private StandardTradeObjectV2 offer;
  }
}
