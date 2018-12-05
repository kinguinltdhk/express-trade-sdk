package net.kinguin.expresstrade.trade.gettradeurl.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.trade.gettradeurl.GetTradeUrl;
import net.kinguin.expresstrade.trade.gettradeurl.v1.dto.GetTradeUrlDto;

public class GetTradeUrlV1 extends Client implements GetTradeUrl {

  private static final String ENDPOINT_URL = "/ITrade/GetTradeURL/v1/";
  private final JsonAdapter<GetTradeUrlDto> inventoryJsonAdapter =
      moshi.adapter(GetTradeUrlDto.class);

  public GetTradeUrlV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetTradeUrlDto execute() throws IOException {
    requestUriBuilder = new RequestUriBuilder();
    return inventoryJsonAdapter.fromJson(this.makeRequest().string());
  }
}
