package net.kinguin.expresstrade.item.getallitems.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.item.getallitems.GetAllItems;
import net.kinguin.expresstrade.item.getallitems.v1.http.dto.GetAllItemsDto;

public class GetAllItemsV1 extends Client implements GetAllItems {

  private static final String ENDPOINT_URL = "/IItem/GetAllItems/v1/";
  private final JsonAdapter<GetAllItemsDto> jsonAdapter =
      moshi.adapter(GetAllItemsDto.class);

  public GetAllItemsV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetAllItemsDto execute(Integer appId, String sku, String name, Integer page,
      Integer perPage, StandardItemSorts sort, Boolean noExclusions) throws IOException {

    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("app_id", appId);

    requestUriBuilder = new RequestUriBuilder(requiredParams)
        .addParam("sku", sku)
        .addParam("name", name)
        .addParam("page", page)
        .addParam("per_page", perPage)
        .addParam("sort", sort != null ? sort.getValue() : null)
        .addParam("no_exclusions", noExclusions);

    return this.jsonAdapter.fromJson(this.makeRequest().string());
  }
}
