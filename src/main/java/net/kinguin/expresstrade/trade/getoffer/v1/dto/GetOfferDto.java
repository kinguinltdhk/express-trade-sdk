package net.kinguin.expresstrade.trade.getoffer.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.trade.StandardTradeObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetOfferDto extends ResponseDto {
  private GetOfferResponseDto response;

  @Data
  public static class GetOfferResponseDto {

    private StandardTradeObject offer;
  }
}
