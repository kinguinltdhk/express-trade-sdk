package net.kinguin.expresstrade.examples.trade;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.trade.acceptoffer.v1.dto.AcceptOfferDto;

public class AcceptOfferExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );
    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    AcceptOfferDto acceptOfferDto = expressTradeApi.acceptOffer(1234);
    System.out.println(acceptOfferDto);
  }
}
