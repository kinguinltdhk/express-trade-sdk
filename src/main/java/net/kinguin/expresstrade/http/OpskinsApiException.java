package net.kinguin.expresstrade.http;

import java.io.IOException;
import lombok.Getter;
import okhttp3.Response;

@Getter
public class OpskinsApiException extends IOException {
  private Response response;

  public OpskinsApiException(Response response) {
    super(String.format("Unexpected API response: %s", response));

    this.response = response;
  }
}
