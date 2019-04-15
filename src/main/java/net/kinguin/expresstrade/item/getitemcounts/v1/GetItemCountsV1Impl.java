package net.kinguin.expresstrade.item.getitemcounts.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.item.getitemcounts.GetItemCounts;
import net.kinguin.expresstrade.item.getitemcounts.v1.dto.GetItemCountsV1Dto;

public class GetItemCountsV1Impl extends Client implements GetItemCounts {

  private static final String ENDPOINT_URL = "/IItem/GetItemCounts/v1/";
  private final JsonAdapter<GetItemCountsV1Dto> jsonAdapter =
      moshi.adapter(GetItemCountsV1Dto.class);

  public GetItemCountsV1Impl(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetItemCountsV1Dto execute(List<Integer> appIds) throws IOException {
    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("app_id", appIds.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(","))
    );

    requestUriBuilder = new RequestUriBuilder(requiredParams);

    return jsonAdapter.fromJson(this.makeRequest().string());
  }
}
