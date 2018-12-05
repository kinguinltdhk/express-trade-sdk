package net.kinguin.expresstrade.trade.regeneratetradeurl.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.regeneratetradeurl.RegenerateTradeUrl;
import net.kinguin.expresstrade.trade.regeneratetradeurl.v1.dto.RegenerateTradeUrlDto;

public class RegenerateTradeUrlV1 extends Client implements RegenerateTradeUrl {

  private static final String ENDPOINT_URL = "/ITrade/RegenerateTradeURL/v1/";
  private final JsonAdapter<RegenerateTradeUrlDto> jsonAdapter =
      moshi.adapter(RegenerateTradeUrlDto.class);

  public RegenerateTradeUrlV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public RegenerateTradeUrlDto execute() throws IOException {
    return jsonAdapter.fromJson(this.makePostRequest().string());
  }
}
