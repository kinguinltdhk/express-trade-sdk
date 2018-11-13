package net.kinguin.expresstrade.trade.canceloffer.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.trade.StandardTradeObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class CancelOfferDto extends ResponseDto {

  private CancelOfferResponseDto response;

  @Data
  public static class CancelOfferResponseDto {

    private StandardTradeObject offer;
  }
}
