package net.kinguin.expresstrade.trade.sendoffer.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.trade.StandardTradeObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class SendOfferDto extends ResponseDto {

  private SendOfferResponseDto response;

  @Data
  public static class SendOfferResponseDto {

    private StandardTradeObject offer;
  }
}
