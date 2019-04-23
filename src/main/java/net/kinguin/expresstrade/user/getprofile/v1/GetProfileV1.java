package net.kinguin.expresstrade.user.getprofile.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
  public GetProfileDto execute() throws IOException {
    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("with_extra", Boolean.TRUE);

    requestUriBuilder = new RequestUriBuilder(requiredParams)
        .addParam(" twofactor_code", generate2AuthCode());

    return this.jsonAdapter.fromJson(this.makeRequest().string());
  }
}
