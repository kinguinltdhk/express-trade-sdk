package net.kinguin.expresstrade.trade.sendoffertosteamid.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.sendoffertosteamid.SendOfferToSteamId;
import net.kinguin.expresstrade.trade.sendoffertosteamid.v1.dto.SendOfferToSteamIdDto;

public class SendOfferToSteamIdV1 extends Client implements SendOfferToSteamId {

  private static final String ENDPOINT_URL = "/ITrade/SendOfferToSteamId/v1/";
  private final JsonAdapter<SendOfferToSteamIdDto> jsonAdapter =
      moshi.adapter(SendOfferToSteamIdDto.class);

  public SendOfferToSteamIdV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public SendOfferToSteamIdDto execute(
      String steamId,
      String itemsToSend,
      String itemsToReceive,
      Integer expirationTime,
      String message
  ) throws IOException {
    requestUriBuilder = new RequestUriBuilder()
        .addParam("steam_id", steamId)
        .addParam("items_to_send", itemsToSend)
        .addParam("items_to_receive", itemsToReceive)
        .addParam("expiration_time", expirationTime)
        .addParam("message", message)
        .addParam("twofactor_code", generate2AuthCode());

    return jsonAdapter.fromJson(this.makePostRequest().string());
  }
}
