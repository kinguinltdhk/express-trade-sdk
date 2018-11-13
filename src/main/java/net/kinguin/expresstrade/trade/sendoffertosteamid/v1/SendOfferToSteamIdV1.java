package net.kinguin.expresstrade.trade.sendoffertosteamid.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.sendoffertosteamid.SendOfferToSteamId;
import net.kinguin.expresstrade.trade.sendoffertosteamid.v1.dto.SendOfferToSteamIdDto;
import net.kinguin.expresstrade.trade.sendoffertosteamid.v1.dto.SendOfferToSteamIdRequestDto;

public class SendOfferToSteamIdV1 extends Client implements SendOfferToSteamId {

  private static final String ENDPOINT_URL = "/ITrade/SendOfferToSteamId/v1/";

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<SendOfferToSteamIdDto> jsonAdapter =
      moshi.adapter(SendOfferToSteamIdDto.class);
  private final JsonAdapter<SendOfferToSteamIdRequestDto> jsonRequestAdapter =
      moshi.adapter(SendOfferToSteamIdRequestDto.class);

  public SendOfferToSteamIdV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    return ENDPOINT_URL;
  }

  @Override
  public SendOfferToSteamIdDto execute(
      String steamId,
      String token,
      String tradeUrl,
      String itemsToSend,
      String itemsToReceive,
      Integer expirationTime,
      String message
  ) throws IOException {
    SendOfferToSteamIdRequestDto requestDto = SendOfferToSteamIdRequestDto.builder()
        .steam_id(steamId)
        .token(token)
        .trade_url(tradeUrl)
        .items_to_send(itemsToSend)
        .items_to_receive(itemsToReceive)
        .expiration_time(expirationTime)
        .message(message)
        .twofactor_code(generate2AuthCode())
        .build();

    String requestJson = jsonRequestAdapter.toJson(requestDto);
    return jsonAdapter.fromJson(this.makePostRequest(requestJson).source());
  }
}
