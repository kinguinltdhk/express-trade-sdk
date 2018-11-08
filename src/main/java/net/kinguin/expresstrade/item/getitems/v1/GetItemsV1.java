package net.kinguin.expresstrade.item.getitems.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.item.getitems.GetItems;
import net.kinguin.expresstrade.item.getitems.v1.http.dto.GetItemsDto;

public class GetItemsV1 extends Client implements GetItems {

  private static final String ENDPOINT_URL = "/IItem/GetItems/v1/";

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<GetItemsDto> itemsJsonAdapter = moshi.adapter(GetItemsDto.class);

  public GetItemsV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    return ENDPOINT_URL;
  }

  @Override
  public GetItemsDto execute() throws IOException {
    return itemsJsonAdapter.fromJson(this.makeRequest().source());
  }
}
