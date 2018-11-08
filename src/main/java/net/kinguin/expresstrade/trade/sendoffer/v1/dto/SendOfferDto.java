package net.kinguin.expresstrade.trade.sendoffer.v1.dto;

import lombok.Data;
import net.kinguin.expresstrade.trade.StandardTradeObject;

@Data
public class SendOfferDto {

  private SendOfferResponseDto response;

  @Data
  public static class SendOfferResponseDto {

    private StandardTradeObject offer;
  }
}
