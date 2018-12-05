package net.kinguin.expresstrade.trade.getoffer.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.getoffer.GetOffer;
import net.kinguin.expresstrade.trade.getoffer.v1.dto.GetOfferDto;

public class GetOfferV1 extends Client implements GetOffer {

  private static final String ENDPOINT_URL = "/ITrade/GetOffer/v1/";
  private final JsonAdapter<GetOfferDto> jsonAdapter =
      moshi.adapter(GetOfferDto.class);

  public GetOfferV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetOfferDto execute(Integer offerId) throws IOException {
    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("offer_id", offerId);

    requestUriBuilder = new RequestUriBuilder(requiredParams);

    return jsonAdapter.fromJson(this.makeRequest().string());
  }
}
