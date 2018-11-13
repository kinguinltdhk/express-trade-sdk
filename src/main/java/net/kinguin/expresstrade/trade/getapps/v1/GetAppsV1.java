package net.kinguin.expresstrade.trade.getapps.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.getapps.GetApps;
import net.kinguin.expresstrade.trade.getapps.v1.dto.GetAppsDto;

public class GetAppsV1 extends Client implements GetApps {

  private static final String ENDPOINT_URL = "/ITrade/GetApps/v1/";

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<GetAppsDto> jsonAdapter =
      moshi.adapter(GetAppsDto.class);

  public GetAppsV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    return ENDPOINT_URL;
  }

  @Override
  public GetAppsDto execute() throws IOException {
    return jsonAdapter.fromJson(this.makeRequest().source());
  }
}
