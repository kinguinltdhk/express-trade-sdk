package net.kinguin.expresstrade.trade.acceptoffer.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.acceptoffer.AcceptOffer;
import net.kinguin.expresstrade.trade.acceptoffer.v1.dto.AcceptOfferDto;
import net.kinguin.expresstrade.trade.acceptoffer.v1.dto.AcceptOfferRequestDto;

public class AcceptOfferV1 extends Client implements AcceptOffer {

  private static final String ENDPOINT_URL = "/ITrade/AcceptOffer/v1/";

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<AcceptOfferDto> jsonAdapter =
      moshi.adapter(AcceptOfferDto.class);
  private final JsonAdapter<AcceptOfferRequestDto> jsonRequestAdapter =
      moshi.adapter(AcceptOfferRequestDto.class);

  public AcceptOfferV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    return ENDPOINT_URL;
  }

  @Override
  public AcceptOfferDto execute(
      Integer offerId
  ) throws IOException {
    AcceptOfferRequestDto requestDto = AcceptOfferRequestDto.builder()
        .offer_id(offerId)
        .twofactor_code(generate2AuthCode())
        .build();

    String requestJson = jsonRequestAdapter.toJson(requestDto);
    return jsonAdapter.fromJson(this.makePostRequest(requestJson).source());
  }
}
