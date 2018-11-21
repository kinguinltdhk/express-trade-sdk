package net.kinguin.expresstrade.item.getitemsbyid.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.item.getitemsbyid.GetItemsById;
import net.kinguin.expresstrade.item.getitemsbyid.v1.http.dto.GetItemsByIdDto;
import net.kinguin.expresstrade.item.getitemsbyid.v1.http.dto.GetItemsByIdRequestDto;
import org.apache.http.client.utils.URIBuilder;

public class GetItemsByIdV1 extends Client implements GetItemsById {
  private static final String ENDPOINT_URL = "/IItem/GetItemsById/v1/";
  private GetItemsByIdRequestDto getItemsByIdRequestDto;
  private final JsonAdapter<GetItemsByIdDto> jsonAdapter =
      moshi.adapter(GetItemsByIdDto.class);

  public GetItemsByIdV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    try {
      URIBuilder uri = new URIBuilder(ENDPOINT_URL);

      Map<String, Object> mappedObject = objectMapper
          .convertValue(getItemsByIdRequestDto, Map.class);
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
  public GetItemsByIdDto execute(String itemId) throws IOException {
    this.getItemsByIdRequestDto = GetItemsByIdRequestDto.builder(itemId).build();

    return this.jsonAdapter.fromJson(this.makeRequest().source());
  }
}
