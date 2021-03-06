package net.kinguin.expresstrade.trade.getuserinventory.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.trade.getuserinventory.GetUserInventory;
import net.kinguin.expresstrade.trade.getuserinventory.v1.http.dto.GetUserInventoryDto;

public class GetUserInventoryV1 extends Client implements GetUserInventory {

  private static final String ENDPOINT_URL = "/ITrade/GetUserInventory/v1/";
  private final JsonAdapter<GetUserInventoryDto> inventoryJsonAdapter =
      moshi.adapter(GetUserInventoryDto.class);

  public GetUserInventoryV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetUserInventoryDto execute(Integer userId, Integer appId, Integer page,
      Integer perPage, String search, StandardItemSorts sort) throws IOException {
    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("uid", userId);
    requiredParams.put("app_id", appId);

    requestUriBuilder = new RequestUriBuilder(requiredParams)
        .addParam("page", page)
        .addParam("per_page", perPage)
        .addParam("search", search)
        .addParam("sort", sort != null ? sort.getValue() : null);

    return inventoryJsonAdapter.fromJson(this.makeRequest().string());
  }
}
