package net.kinguin.expresstrade.trade.getoffers.v1;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.trade.getoffers.GetOffers;
import net.kinguin.expresstrade.trade.getoffers.v1.dto.GetOffersDto;
import org.apache.http.client.utils.URIBuilder;

public class GetOffersV1 extends Client implements GetOffers {

  private static final String ENDPOINT_URL = "/ITrade/GetOffers/v1/";

  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<GetOffersDto> jsonAdapter =
      moshi.adapter(GetOffersDto.class);
  private String offerIds;

  public GetOffersV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties);
  }

  @Override
  protected String getEndpointUrl() {
    try {
      URIBuilder uri = new URIBuilder(ENDPOINT_URL);
      if (offerIds != null) {
        uri.addParameter("ids", offerIds);
      }
      return uri.toString();
    } catch (URISyntaxException e) {
      return ENDPOINT_URL;
    }
  }

  @Override
  public GetOffersDto execute() throws IOException {
    return jsonAdapter.fromJson(this.makeRequest().source());
  }

  @Override
  public GetOffersDto execute(String offerIds) throws IOException {
    this.offerIds = offerIds;
    return jsonAdapter.fromJson(this.makeRequest().source());
  }
}
