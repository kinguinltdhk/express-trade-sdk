package net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.GetUserInventoryFromSteamId;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.http.dto.GetUserInventoryFromSteamIdDto;

public class GetUserInventoryFromSteamIdV1 extends Client implements GetUserInventoryFromSteamId {

  private static final String ENDPOINT_URL = "/ITrade/GetUserInventoryFromSteamId/v1/?steam_id=%s&app_id=1";

  private String steamId;
  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<GetUserInventoryFromSteamIdDto> inventoryJsonAdapter =
      moshi.adapter(GetUserInventoryFromSteamIdDto.class);

  public GetUserInventoryFromSteamIdV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    return String.format(ENDPOINT_URL, steamId);
  }

  @Override
  public GetUserInventoryFromSteamIdDto execute(String steamId) throws IOException {
    this.steamId = steamId;

    return inventoryJsonAdapter.fromJson(this.makeRequest().source());
  }
}
