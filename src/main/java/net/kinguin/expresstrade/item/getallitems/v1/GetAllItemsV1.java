package net.kinguin.expresstrade.item.getallitems.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.item.getallitems.GetAllItems;
import net.kinguin.expresstrade.item.getallitems.v1.http.dto.GetAllItemsDto;
import net.kinguin.expresstrade.item.getallitems.v1.http.dto.GetAllItemsRequestDto;
import org.apache.http.client.utils.URIBuilder;

public class GetAllItemsV1 extends Client implements GetAllItems {

  private static final String ENDPOINT_URL = "/IItem/GetAllItems/v1/";
  private GetAllItemsRequestDto getAllItemsRequestDto;
  private final JsonAdapter<GetAllItemsDto> jsonAdapter =
      moshi.adapter(GetAllItemsDto.class);

  public GetAllItemsV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    try {
      URIBuilder uri = new URIBuilder(ENDPOINT_URL);

      Map<String, Object> mappedObject = objectMapper
          .convertValue(getAllItemsRequestDto, Map.class);
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
  public GetAllItemsDto execute(Integer appId, String sku, String name, Integer page,
      Integer perPage, StandardItemSorts sort, Boolean noExclusions) throws IOException {
    this.getAllItemsRequestDto = GetAllItemsRequestDto.builder(appId)
        .sku(sku)
        .name(name)
        .page(page)
        .per_page(perPage)
        .sort(sort != null ? sort.getValue() : null)
        .no_exclusions(noExclusions)
        .build();

    return this.jsonAdapter.fromJson(this.makeRequest().source());
  }
}
