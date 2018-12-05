package net.kinguin.expresstrade.trade.getoffers.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.getoffers.GetOffers;
import net.kinguin.expresstrade.trade.getoffers.v1.dto.GetOffersDto;

public class GetOffersV1 extends Client implements GetOffers {

  private static final String ENDPOINT_URL = "/ITrade/GetOffers/v1/";
  private final JsonAdapter<GetOffersDto> jsonAdapter =
      moshi.adapter(GetOffersDto.class);

  public GetOffersV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetOffersDto execute(
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
