package net.kinguin.expresstrade.http;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class Client {

  protected RequestUriBuilder requestUriBuilder;
  protected final Moshi moshi = new Moshi.Builder().build();

  private final ExpressTradeProperties expressTradeProperties;
  private final String endpointUrl;
  private final OkHttpClient okHttpClient;
  private final JsonAdapter<ResponseDto> baseResponseAdapter =
      moshi.adapter(ResponseDto.class);

  private static final MediaType JSON
      = MediaType.parse("application/json; charset=utf-8");

  public Client(ExpressTradeProperties expressTradeProperties, String endpointUrl) {
    this.expressTradeProperties = expressTradeProperties;
    this.endpointUrl = endpointUrl;
    this.okHttpClient = setupOkHttpClient();
  }

  /**
   * Base method for requests.
   *
   * @return Response object
   * @throws IOException exception
   */
  public ResponseBody makeRequest() throws IOException {
    Builder requestBuilder = getRequestBuilder(getFullUrl());
    Request request = requestBuilder.build();

    Response response = okHttpClient.newCall(request).execute();

    isResponseSuccessful(response);

    return response.body();
  }

  /**
   * Base method for POST requests.
   *
   * @return ResponseBody ResponseBody object
   * @throws IOException exception
   */
  public ResponseBody makePostRequest() throws IOException {
    Builder requestBuilder = getRequestBuilder(getPostUrl());
    RequestBody requestBody = RequestBody.create(JSON, requestUriBuilder.getJsonBody());
    requestBuilder.post(requestBody);

    Request request = requestBuilder.build();

    Response response = okHttpClient.newCall(request).execute();

    isResponseSuccessful(response);

    return response.body();
  }

  private void isResponseSuccessful(Response response) throws IOException {
    if (!response.isSuccessful()) {
      response.close();
      throw new OpskinsApiException(response);
    }

    ResponseBody responseBody = response.peekBody(Long.MAX_VALUE);

    ResponseDto baseResponseDto = this.baseResponseAdapter.fromJson(responseBody.string());

    if (baseResponseDto != null && !baseResponseDto.getStatus().equals(1)) {
      response.close();
      throw new OpskinsApiException(baseResponseDto.getMessage());
    }
  }

  private Builder getRequestBuilder(URL url) {
    return new Builder().url(url);
  }

  private OkHttpClient setupOkHttpClient() {
    OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

    clientBuilder.readTimeout(10, TimeUnit.SECONDS);
    clientBuilder.writeTimeout(10, TimeUnit.SECONDS);

    clientBuilder.authenticator(getAuthenticator());

    return clientBuilder.build();
  }

  private Authenticator getAuthenticator() {
    return (route, response) -> {
      if (response.request().header("Authorization") != null) {
        return null;
      }

      String credential = Credentials.basic(expressTradeProperties.getApiAuthKey(), "");

      return response.request().newBuilder()
          .header("Authorization", credential)
          .build();
    };
  }

  private URL getPostUrl() throws MalformedURLException {
    return new URL(
        expressTradeProperties.getApiBaseUrl() + endpointUrl);
  }

  private URL getFullUrl() throws MalformedURLException {
    return new URL(
        expressTradeProperties.getApiBaseUrl() + requestUriBuilder.getEndpointUrl(endpointUrl));
  }

  protected String generate2AuthCode() {
    GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator();
    int code = googleAuthenticator.getTotpPassword(expressTradeProperties.getSecret());
    return String.format("%06d", code);
  }
}
