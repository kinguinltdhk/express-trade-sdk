package net.kinguin.expresstrade.examples.trade;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.trade.sendoffer.v1.dto.SendOfferDto;

public class SendOfferExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "https://api-trade.opskins.com",
            "secret"
        );
    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    SendOfferDto getUserInventoryDto =
        expressTradeApi.sendOffer(
            4321,
            "token",
            "tradeUrl",
            "1234,4567",
            "1234,4567",
            3600,
            "message");

    System.out.println(getUserInventoryDto);
  }
}
