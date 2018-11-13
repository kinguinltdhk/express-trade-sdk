package net.kinguin.expresstrade.trade.sendoffertosteamid.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.trade.StandardTradeObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class SendOfferToSteamIdDto extends ResponseDto {

  private SendOfferToSteamIdResponseDto response;

  @Data
  public static class SendOfferToSteamIdResponseDto {

    private StandardTradeObject offer;
  }
}
