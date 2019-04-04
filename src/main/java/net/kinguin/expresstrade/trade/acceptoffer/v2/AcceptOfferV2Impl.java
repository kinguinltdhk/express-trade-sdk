package net.kinguin.expresstrade.trade.acceptoffer.v2;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.acceptoffer.AcceptOfferV2;
import net.kinguin.expresstrade.trade.acceptoffer.v2.dto.AcceptOfferV2Dto;

public class AcceptOfferV2Impl extends Client implements AcceptOfferV2 {

  private static final String ENDPOINT_URL = "/ITrade/AcceptOffer/v2/";
  private final JsonAdapter<AcceptOfferV2Dto> jsonAdapter =
      moshi.adapter(AcceptOfferV2Dto.class);

  public AcceptOfferV2Impl(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public AcceptOfferV2Dto execute(Integer offerId) throws IOException {
    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("offer_id", offerId);

    requestUriBuilder = new RequestUriBuilder(requiredParams)
        .addParam(" twofactor_code", generate2AuthCode());

    return jsonAdapter.fromJson(this.makePostRequest().string());
  }
}
