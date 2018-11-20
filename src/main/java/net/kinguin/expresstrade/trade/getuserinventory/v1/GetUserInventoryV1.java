package net.kinguin.expresstrade.trade.getuserinventory.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.trade.getuserinventory.GetUserInventory;
import net.kinguin.expresstrade.trade.getuserinventory.v1.http.dto.GetUserInventoryDto;
import net.kinguin.expresstrade.trade.getuserinventory.v1.http.dto.GetUserInventoryRequestDto;
import org.apache.http.client.utils.URIBuilder;

public class GetUserInventoryV1 extends Client implements GetUserInventory {

  private static final String ENDPOINT_URL = "/ITrade/GetUserInventory/v1/";

  private GetUserInventoryRequestDto getUserInventoryRequestDto;
  private final JsonAdapter<GetUserInventoryDto> inventoryJsonAdapter =
      moshi.adapter(GetUserInventoryDto.class);

  public GetUserInventoryV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    try {
      URIBuilder uri = new URIBuilder(ENDPOINT_URL);

      Map<String, Object> mappedObject = objectMapper
          .convertValue(getUserInventoryRequestDto, Map.class);
      mappedObject.forEach((key, value) -> {
        if (mappedObject.get(key) != null) {
          uri.addParameter(key, value.toString());
        }
      });

      return uri.toString();
    } catch (URISyntaxException e) {
      return ENDPOINT_URL;
    }
  }

  @Override
  public GetUserInventoryDto execute(Integer userId, Integer appId, Integer page,
      Integer perPage, String search, StandardItemSorts sort) throws IOException {
    this.getUserInventoryRequestDto = GetUserInventoryRequestDto.builder(userId, appId)
        .page(page)
        .per_page(perPage)
        .search(search)
        .sort(sort != null ? sort.getValue() : null)
        .build();

    return inventoryJsonAdapter.fromJson(this.makeRequest().source());
  }
}
