package net.kinguin.expresstrade.trade.sendoffer.v2;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.sendoffer.SendOfferV2;
import net.kinguin.expresstrade.trade.sendoffer.v2.dto.SendOfferV2Dto;

public class SendOfferV2Impl extends Client implements SendOfferV2 {

  private static final String ENDPOINT_URL = "/ITrade/SendOffer/v2/";
  private final JsonAdapter<SendOfferV2Dto> jsonAdapter =
      moshi.adapter(SendOfferV2Dto.class);

  public SendOfferV2Impl(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public SendOfferV2Dto execute(
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
