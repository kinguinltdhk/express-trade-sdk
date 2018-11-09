package net.kinguin.expresstrade.trade.getoffer.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.getoffer.GetOffer;
import net.kinguin.expresstrade.trade.getoffer.v1.dto.GetOfferDto;

public class GetOfferV1 extends Client implements GetOffer {
  private static final String ENDPOINT_URL = "/ITrade/GetOffer/v1/?offer_id=%s";

  private Integer offerId;
  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<GetOfferDto> jsonAdapter =
      moshi.adapter(GetOfferDto.class);

  public GetOfferV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    Integer id = offerId;

    return String.format(ENDPOINT_URL, id);
  }

  @Override
  public GetOfferDto execute(Integer offerId) throws IOException {
    this.offerId = offerId;
    return jsonAdapter.fromJson(this.makeRequest().source());
  }
}
