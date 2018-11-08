package net.kinguin.expresstrade.trade.getoffers.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.getoffers.GetOffers;
import net.kinguin.expresstrade.trade.getoffers.v1.dto.GetOffersDto;

public class GetOffersV1 extends Client implements GetOffers {

  private static final String ENDPOINT_URL = "/ITrade/GetOffers/v1/";

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<GetOffersDto> jsonAdapter =
      moshi.adapter(GetOffersDto.class);

  public GetOffersV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    return ENDPOINT_URL;
  }

  @Override
  public GetOffersDto execute() throws IOException {
    return jsonAdapter.fromJson(this.makeRequest().source());
  }
}
