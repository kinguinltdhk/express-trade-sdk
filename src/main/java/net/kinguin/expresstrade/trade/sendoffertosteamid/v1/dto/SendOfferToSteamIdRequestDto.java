package net.kinguin.expresstrade.trade.sendoffertosteamid.v1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendOfferToSteamIdRequestDto {

  private String steam_id;
  private String token;
  private String trade_url;
  private String items_to_send;
  private String items_to_receive;
  private Integer expiration_time;
  private String message;
  private String twofactor_code;
}
