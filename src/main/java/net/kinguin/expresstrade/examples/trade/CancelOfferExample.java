package net.kinguin.expresstrade.examples.trade;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.trade.canceloffer.v1.dto.CancelOfferDto;
import net.kinguin.expresstrade.trade.getoffer.v1.dto.GetOfferDto;

public class CancelOfferExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "https://api-trade.opskins.com",
            "secret"
        );
    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    CancelOfferDto cancelOfferDto = expressTradeApi.cancelOffer(1234);
    System.out.println(cancelOfferDto);
  }
}
