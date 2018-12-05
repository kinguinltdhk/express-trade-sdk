package net.kinguin.expresstrade.item.getitems.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.item.getitems.GetItems;
import net.kinguin.expresstrade.item.getitems.v1.http.dto.GetItemsDto;

public class GetItemsV1 extends Client implements GetItems {

  private static final String ENDPOINT_URL = "/IItem/GetItems/v1/";
  private final JsonAdapter<GetItemsDto> itemsJsonAdapter = moshi.adapter(GetItemsDto.class);

  public GetItemsV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetItemsDto execute(String skuFilter, Integer wearTierIndex) throws IOException {
    requestUriBuilder = new RequestUriBuilder();
    requestUriBuilder.addParam("sku_filter", skuFilter)
        .addParam("wear_tier_index", wearTierIndex);

    return itemsJsonAdapter.fromJson(this.makeRequest().string());
  }
}
