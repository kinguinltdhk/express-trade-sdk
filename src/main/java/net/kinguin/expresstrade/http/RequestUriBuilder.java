package net.kinguin.expresstrade.http;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import lombok.NoArgsConstructor;
import org.apache.http.client.utils.URIBuilder;

@NoArgsConstructor
public class RequestUriBuilder {

  private Map<String, Object> urlParams = new HashMap<>();
  private final Moshi moshi = new Moshi.Builder().build();
  private final JsonAdapter<Map> jsonAdapter =
      moshi.adapter(Map.class);

  public RequestUriBuilder(Map<String, Object> requiredParams) {
    requiredParams.forEach((key, value) -> {
      if (requiredParams.get(key) == null) {
        throw new IllegalArgumentException(String.format("%s is required param", key));
      }

      urlParams.put(key, value.toString());
    });
  }

  public RequestUriBuilder addParam(String fieldName, Object value) {
    if (value != null) {
      urlParams.put(fieldName, value.toString());
    }
    return this;
  }

  public String getEndpointUrl(String basePath) {
    try {
      URIBuilder uri = new URIBuilder(basePath);

      urlParams.forEach((key, value) -> {
        if (urlParams.get(key) != null) {
          uri.addParameter(key, value.toString());
        }
      });

      return uri.toString();
    } catch (URISyntaxException e) {
      return basePath;
    }
  }

  public String getJsonBody() {
    return jsonAdapter.toJson(urlParams);
  }
}
