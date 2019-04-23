package net.kinguin.expresstrade.user.getprofile.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.user.getprofile.GetProfile;
import net.kinguin.expresstrade.user.getprofile.v1.http.dto.GetProfileDto;

public class GetProfileV1 extends Client implements GetProfile {

  private static final String ENDPOINT_URL = "/IUser/GetProfile/v1/";
  private final JsonAdapter<GetProfileDto> jsonAdapter =
      moshi.adapter(GetProfileDto.class);

  public GetProfileV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetProfileDto execute(Boolean withExtra) throws IOException {
    requestUriBuilder = new RequestUriBuilder()
        .addParam("with_extra", withExtra);

    return this.jsonAdapter.fromJson(this.makeRequest().string());
  }
}
