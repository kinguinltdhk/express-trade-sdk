package net.kinguin.expresstrade.trade.sendoffer.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.sendoffer.SendOffer;
import net.kinguin.expresstrade.trade.sendoffer.v1.dto.SendOfferDto;

public class SendOfferV1 extends Client implements SendOffer {

  private static final String ENDPOINT_URL = "/ITrade/SendOffer/v1/";
  private final JsonAdapter<SendOfferDto> jsonAdapter =
      moshi.adapter(SendOfferDto.class);

  public SendOfferV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public SendOfferDto execute(
      Integer uid,
      String token,
      String tradeUrl,
      String itemsToSend,
      String itemsToReceive,
      Integer expirationTime,
      String message
  ) throws IOException {
    requestUriBuilder = new RequestUriBuilder()
        .addParam("uid", uid)
        .addParam("token", token)
        .addParam("trade_url", tradeUrl)
        .addParam("items_to_send", itemsToSend)
        .addParam("items_to_receive", itemsToReceive)
        .addParam("expiration_time", expirationTime)
        .addParam("message", message)
        .addParam("twofactor_code", generate2AuthCode());

    return jsonAdapter.fromJson(this.makePostRequest().string());
  }
}
