package net.kinguin.expresstrade.trade.acceptoffer.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.acceptoffer.AcceptOffer;
import net.kinguin.expresstrade.trade.acceptoffer.v1.dto.AcceptOfferDto;

public class AcceptOfferV1 extends Client implements AcceptOffer {

  private static final String ENDPOINT_URL = "/ITrade/AcceptOffer/v1/";
  private final JsonAdapter<AcceptOfferDto> jsonAdapter =
      moshi.adapter(AcceptOfferDto.class);

  public AcceptOfferV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public AcceptOfferDto execute(Integer offerId) throws IOException {
    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("offer_id", offerId);

    requestUriBuilder = new RequestUriBuilder(requiredParams)
        .addParam(" twofactor_code", generate2AuthCode());

    return jsonAdapter.fromJson(this.makePostRequest().string());
  }
}
