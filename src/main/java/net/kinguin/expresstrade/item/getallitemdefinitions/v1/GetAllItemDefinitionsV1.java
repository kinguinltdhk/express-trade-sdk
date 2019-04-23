package net.kinguin.expresstrade.item.getallitemdefinitions.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.item.getallitemdefinitions.GetAllItemDefinitions;
import net.kinguin.expresstrade.item.getallitemdefinitions.v1.http.dto.GetAllItemDefinitionsDto;

public class GetAllItemDefinitionsV1 extends Client implements GetAllItemDefinitions {

  private static final String ENDPOINT_URL = "/IItem/GetItemDefinitions/v1/";
  private final JsonAdapter<GetAllItemDefinitionsDto> jsonAdapter =
      moshi.adapter(GetAllItemDefinitionsDto.class);

  public GetAllItemDefinitionsV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public GetAllItemDefinitionsDto execute(Integer appId, String defIdFilter, String indexBy,
      Integer page, Integer perPage) throws IOException {

    Map<String, Object> requiredParams = new HashMap<>();
    requiredParams.put("app_id", appId);

    requestUriBuilder = new RequestUriBuilder(requiredParams)
        .addParam("def_id_filter", defIdFilter)
        .addParam("index_by", indexBy)
        .addParam("page", page)
        .addParam("per_page", perPage);

    return this.jsonAdapter.fromJson(this.makeRequest().string());
  }
}
