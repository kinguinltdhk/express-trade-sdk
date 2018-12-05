package net.kinguin.expresstrade.item.getitemsbyid.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.item.getitemsbyid.GetItemsById;
import net.kinguin.expresstrade.item.getitemsbyid.v1.http.dto.GetItemsByIdDto;

public class GetItemsByIdV1 extends Client implements GetItemsById {

  private static final String ENDPOINT_URL = "/IItem/GetItemsById/v1/";
  private final JsonAdapter<GetItemsByIdDto> jsonAdapter =
      moshi.adapter(GetItemsByIdDto.class);

  public GetItemsByIdV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetItemsByIdDto execute(String itemId) throws IOException {
    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("item_id", itemId);
    requestUriBuilder = new RequestUriBuilder(requiredParams);

    return this.jsonAdapter.fromJson(this.makeRequest().string());
  }
}
