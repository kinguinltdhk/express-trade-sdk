package net.kinguin.expresstrade.trade.getuserinventory.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.getuserinventory.GetUserInventory;
import net.kinguin.expresstrade.trade.getuserinventory.v1.http.dto.GetUserInventoryDto;

public class GetUserInventoryV1 extends Client implements GetUserInventory {

  private static final String ENDPOINT_URL = "/ITrade/GetUserInventory/v1/?uid=%s&app_id=1";

  private Integer userId;
  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<GetUserInventoryDto> inventoryJsonAdapter =
      moshi.adapter(GetUserInventoryDto.class);

  public GetUserInventoryV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    Integer uid = userId;

    return String.format(ENDPOINT_URL, uid);
  }

  @Override
  public GetUserInventoryDto execute(Integer userId) throws IOException {
    this.userId = userId;

    return inventoryJsonAdapter.fromJson(this.makeRequest().source());
  }
}
