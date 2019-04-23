package net.kinguin.expresstrade.examples.trade;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.trade.sendoffer.v2.dto.SendOfferV2Dto;

public class SendOfferExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );
    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    SendOfferV2Dto sendOfferDto =
        expressTradeApi.sendOfferV2(
            1234,
            "token",
            "trade_url",
            "12345",
            null,
            3600,
            "TEST");

    System.out.println(sendOfferDto);
  }
}
