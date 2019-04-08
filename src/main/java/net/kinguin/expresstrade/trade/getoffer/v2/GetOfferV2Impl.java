package net.kinguin.expresstrade.trade.getoffer.v2;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.getoffer.GetOffer;
import net.kinguin.expresstrade.trade.getoffer.GetOfferV2;
import net.kinguin.expresstrade.trade.getoffer.v2.dto.GetOfferV2Dto;

public class GetOfferV2Impl extends Client implements GetOfferV2 {

  private static final String ENDPOINT_URL = "/ITrade/GetOffer/v2/";
  private final JsonAdapter<GetOfferV2Dto> jsonAdapter =
      moshi.adapter(GetOfferV2Dto.class);

  public GetOfferV2Impl(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetOfferV2Dto execute(Integer offerId) throws IOException {
    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("offer_id", offerId);

    requestUriBuilder = new RequestUriBuilder(requiredParams);

    return jsonAdapter.fromJson(this.makeRequest().string());
  }
}
