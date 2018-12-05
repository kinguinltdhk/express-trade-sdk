package net.kinguin.expresstrade.trade.canceloffer.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.canceloffer.CancelOffer;
import net.kinguin.expresstrade.trade.canceloffer.v1.dto.CancelOfferDto;

public class CancelOfferV1 extends Client implements CancelOffer {

  private static final String ENDPOINT_URL = "/ITrade/CancelOffer/v1/";
  private final JsonAdapter<CancelOfferDto> jsonAdapter =
      moshi.adapter(CancelOfferDto.class);

  public CancelOfferV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public CancelOfferDto execute(Integer offerId) throws IOException {
    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("offer_id", offerId);

    requestUriBuilder = new RequestUriBuilder(requiredParams);

    return jsonAdapter.fromJson(this.makePostRequest().string());
  }
}
