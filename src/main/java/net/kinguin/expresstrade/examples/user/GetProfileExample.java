package net.kinguin.expresstrade.examples.user;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.user.getprofile.v1.http.dto.GetProfileDto;

public class GetProfileExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );
    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    GetProfileDto getProfileDto = expressTradeApi.getProfile();

    System.out.println(getProfileDto);
  }
}
