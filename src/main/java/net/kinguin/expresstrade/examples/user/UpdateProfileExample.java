package net.kinguin.expresstrade.examples.user;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.user.updateprofile.v1.http.dto.UpdateProfileDto;

public class UpdateProfileExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );
    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    UpdateProfileDto updateProfileDto = expressTradeApi
        .updateProfile("TEST_NAME", false, true, true, false);

    System.out.println(updateProfileDto);
  }
}
