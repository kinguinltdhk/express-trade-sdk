package net.kinguin.expresstrade.trade.sendoffer.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.sendoffer.SendOffer;
import net.kinguin.expresstrade.trade.sendoffer.v1.dto.SendOfferDto;
import net.kinguin.expresstrade.trade.sendoffer.v1.dto.SendOfferRequestDto;

public class SendOfferV1 extends Client implements SendOffer {

  private static final String ENDPOINT_URL = "/ITrade/SendOffer/v1/";

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<SendOfferDto> jsonAdapter =
      moshi.adapter(SendOfferDto.class);
  private final JsonAdapter<SendOfferRequestDto> jsonRequestAdapter =
      moshi.adapter(SendOfferRequestDto.class);

  public SendOfferV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    return ENDPOINT_URL;
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
    SendOfferRequestDto requestDto = SendOfferRequestDto.builder()
        .uid(uid)
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
