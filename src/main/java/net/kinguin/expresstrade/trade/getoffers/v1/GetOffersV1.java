package net.kinguin.expresstrade.trade.getoffers.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.getoffers.GetOffers;
import net.kinguin.expresstrade.trade.getoffers.v1.dto.GetOffersDto;
import net.kinguin.expresstrade.trade.getoffers.v1.dto.GetOffersRequestDto;
import org.apache.http.client.utils.URIBuilder;

public class GetOffersV1 extends Client implements GetOffers {

  private static final String ENDPOINT_URL = "/ITrade/GetOffers/v1/";
  private final JsonAdapter<GetOffersDto> jsonAdapter =
      moshi.adapter(GetOffersDto.class);
  private GetOffersRequestDto getOffersRequestDto;

  public GetOffersV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    try {
      URIBuilder uri = new URIBuilder(ENDPOINT_URL);

      Map<String, Object> mappedObject = objectMapper
          .convertValue(getOffersRequestDto, Map.class);
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
  public GetOffersDto execute(
      Integer userId, String state, String type, Integer page, Integer perPage,
      String ids, String sort
  ) throws IOException {
    this.getOffersRequestDto = GetOffersRequestDto.builder()
        .uid(userId)
        .state(state)
        .type(type)
        .page(page)
        .per_page(perPage)
        .ids(ids)
        .sort(sort)
        .build();

    return jsonAdapter.fromJson(this.makeRequest().source());
  }
}
