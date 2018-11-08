package net.kinguin.expresstrade.trade.gettradeurl.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.gettradeurl.GetTradeURL;
import net.kinguin.expresstrade.trade.gettradeurl.v1.dto.GetTradeURLDto;

public class GetTradeURLV1 extends Client implements GetTradeURL {

  private static final String ENDPOINT_URL = "/ITrade/GetTradeURL/v1/";

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<GetTradeURLDto> inventoryJsonAdapter =
      moshi.adapter(GetTradeURLDto.class);

  public GetTradeURLV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    return ENDPOINT_URL;
  }

  @Override
  public GetTradeURLDto execute() throws IOException {
    return inventoryJsonAdapter.fromJson(this.makeRequest().source());
  }
}
