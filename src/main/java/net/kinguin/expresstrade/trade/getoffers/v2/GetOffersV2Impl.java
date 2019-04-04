package net.kinguin.expresstrade.trade.getoffers.v2;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.getoffers.GetOffersV2;
import net.kinguin.expresstrade.trade.getoffers.v2.dto.GetOffersV2Dto;

public class GetOffersV2Impl extends Client implements GetOffersV2 {

  private static final String ENDPOINT_URL = "/ITrade/GetOffers/v2/";
  private final JsonAdapter<GetOffersV2Dto> jsonAdapter =
      moshi.adapter(GetOffersV2Dto.class);

  public GetOffersV2Impl(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetOffersV2Dto execute(
      Integer uid, String state, String type, Integer page, Integer perPage,
      String ids, String sort
  ) throws IOException {
    requestUriBuilder = new RequestUriBuilder()
        .addParam("uid", uid)
        .addParam("state", state)
        .addParam("type", type)
        .addParam("page", page)
        .addParam("per_page", perPage)
        .addParam("ids", ids)
        .addParam("sort", sort);

    return jsonAdapter.fromJson(this.makeRequest().string());
  }
}
