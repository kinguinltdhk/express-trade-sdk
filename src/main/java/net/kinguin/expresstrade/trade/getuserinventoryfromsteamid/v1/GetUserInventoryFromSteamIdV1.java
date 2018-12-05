package net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.GetUserInventoryFromSteamId;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.http.dto.GetUserInventoryFromSteamIdDto;

public class GetUserInventoryFromSteamIdV1 extends Client implements GetUserInventoryFromSteamId {

  private static final String ENDPOINT_URL = "/ITrade/GetUserInventoryFromSteamId/v1/";
  private final JsonAdapter<GetUserInventoryFromSteamIdDto> inventoryJsonAdapter =
      moshi.adapter(GetUserInventoryFromSteamIdDto.class);

  public GetUserInventoryFromSteamIdV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetUserInventoryFromSteamIdDto execute(String steamId, Integer appId, Integer page,
      Integer perPage, String search, StandardItemSorts sort) throws IOException {
    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("steam_id", steamId);
    requiredParams.put("app_id", appId);

    requestUriBuilder = new RequestUriBuilder(requiredParams)
        .addParam("page", page)
        .addParam("per_page", perPage)
        .addParam("search", search)
        .addParam("sort", sort != null ? sort.getValue() : null);

    return inventoryJsonAdapter.fromJson(this.makeRequest().string());
  }
}
