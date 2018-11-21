package net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.GetUserInventoryFromSteamId;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.http.dto.GetUserInventoryFromSteamIdDto;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.http.dto.GetUserInventoryFromSteamIdRequestDto;
import org.apache.http.client.utils.URIBuilder;

public class GetUserInventoryFromSteamIdV1 extends Client implements GetUserInventoryFromSteamId {

  private static final String ENDPOINT_URL = "/ITrade/GetUserInventoryFromSteamId/v1/";

  private GetUserInventoryFromSteamIdRequestDto getUserInventoryFromSteamIdRequestDto;
  private final JsonAdapter<GetUserInventoryFromSteamIdDto> inventoryJsonAdapter =
      moshi.adapter(GetUserInventoryFromSteamIdDto.class);

  public GetUserInventoryFromSteamIdV1(
      ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    try {
      URIBuilder uri = new URIBuilder(ENDPOINT_URL);

      Map<String, Object> mappedObject = objectMapper
          .convertValue(getUserInventoryFromSteamIdRequestDto, Map.class);
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
  public GetUserInventoryFromSteamIdDto execute(String steamId, Integer appId, Integer page,
      Integer perPage, String search, StandardItemSorts sort) throws IOException {
    this.getUserInventoryFromSteamIdRequestDto = GetUserInventoryFromSteamIdRequestDto
        .builder(steamId, appId)
        .page(page)
        .per_page(perPage)
        .search(search)
        .sort(sort != null ? sort.getValue() : null)
        .build();

    return inventoryJsonAdapter.fromJson(this.makeRequest().source());
  }
}
