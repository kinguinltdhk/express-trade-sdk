package net.kinguin.expresstrade.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.moshi.Moshi;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import net.kinguin.expresstrade.ExpressTradeProperties;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.codec.binary.Base64;

@RequiredArgsConstructor
public abstract class Client {

  public final ExpressTradeProperties expressTradeProperties;
  private static final MediaType JSON
      = MediaType.parse("application/json; charset=utf-8");
  private OkHttpClient okHttpClient = new OkHttpClient();
  protected final Moshi moshi = new Moshi.Builder().build();
  protected ObjectMapper objectMapper = new ObjectMapper();

  /**
   * Base method for requests.
   *
   * @return Response object
   * @throws IOException exception
   */
  public ResponseBody makeRequest() throws IOException {
    Builder requestBuilder = getRequestBuilder();
    Request request = requestBuilder.build();

    Response response = okHttpClient.newCall(request).execute();
    return response.body();
  }

  /**
   * Base method for POST requests.
   *
   * @param jsonBody Strigify json of body
   * @return ResponseBody ResponseBody object
   * @throws IOException exception
   */
  public ResponseBody makePostRequest(String jsonBody) throws IOException {
    Builder requestBuilder = getRequestBuilder();
    RequestBody requestBody = RequestBody.create(JSON, jsonBody);
    requestBuilder.post(requestBody);

    Request request = requestBuilder.build();

    Response response = okHttpClient.newCall(request).execute();
    return response.body();
  }

  private Builder getRequestBuilder() throws MalformedURLException {
    return new Builder()
        .url(this.getFullUrl())
        .headers(createHttpHeaders());
  }

  private URL getFullUrl() throws MalformedURLException {
    return new URL(expressTradeProperties.getApiBaseUrl() + this.getEndpointUrl());
  }

  protected Headers createHttpHeaders() {
    String authorizationHeaderValue = "Basic ";
    return new Headers.Builder()
        .add("Content-Type", "application/json")
        .add("Authorization", authorizationHeaderValue.concat(getEncryptApiKey()))
        .build();
  }

  protected String getEncryptApiKey() {
    String apiKeyPlain = expressTradeProperties.getApiAuthKey();
    byte[] bytesApiKey = apiKeyPlain.concat(":").getBytes();
    byte[] encryptedApiKey = Base64.encodeBase64(bytesApiKey);

    return new String(encryptedApiKey);
  }

  protected String generate2AuthCode() {
    GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator();
    int code = googleAuthenticator.getTotpPassword(expressTradeProperties.getSecret());
    return Integer.toString(code);

  }

  protected abstract String getEndpointUrl();
}
