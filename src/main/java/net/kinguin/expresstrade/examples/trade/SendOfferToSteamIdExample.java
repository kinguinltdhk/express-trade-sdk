package net.kinguin.expresstrade.examples.trade;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.trade.sendoffertosteamid.v1.dto.SendOfferToSteamIdDto;

public class SendOfferToSteamIdExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );
    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    SendOfferToSteamIdDto sendOfferToSteamIdDto =
        expressTradeApi.sendOfferToSteamId(
            "4321",
            "1234,4567",
            "1234,4567",
            3600,
            "message");

    System.out.println(sendOfferToSteamIdDto);
  }
}
