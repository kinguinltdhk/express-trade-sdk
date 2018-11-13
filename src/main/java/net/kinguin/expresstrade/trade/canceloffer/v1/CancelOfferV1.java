package net.kinguin.expresstrade.trade.canceloffer.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.canceloffer.CancelOffer;
import net.kinguin.expresstrade.trade.canceloffer.v1.dto.CancelOfferDto;
import net.kinguin.expresstrade.trade.canceloffer.v1.dto.CancelOfferRequestDto;

public class CancelOfferV1 extends Client implements CancelOffer {

  private static final String ENDPOINT_URL = "/ITrade/CancelOffer/v1/";

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<CancelOfferDto> jsonAdapter =
      moshi.adapter(CancelOfferDto.class);
  private final JsonAdapter<CancelOfferRequestDto> jsonRequestAdapter =
      moshi.adapter(CancelOfferRequestDto.class);

  public CancelOfferV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    return ENDPOINT_URL;
  }

  @Override
  public CancelOfferDto execute(Integer offerId) throws IOException {
    CancelOfferRequestDto requestDto = CancelOfferRequestDto.builder()
        .offer_id(offerId)
        .build();

    String requestJson = jsonRequestAdapter.toJson(requestDto);
    return jsonAdapter.fromJson(this.makePostRequest(requestJson).source());
  }
}
