package net.kinguin.expresstrade.trade.getoffer.v1.dto;

import lombok.Data;
import net.kinguin.expresstrade.trade.StandardTradeObject;

public class GetOfferDto {
  private GetOfferResponseDto response;

  @Data
  public static class GetOfferResponseDto {

    private StandardTradeObject offer;
  }
}
