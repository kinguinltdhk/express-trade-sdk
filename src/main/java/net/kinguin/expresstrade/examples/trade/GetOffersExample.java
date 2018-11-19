package net.kinguin.expresstrade.examples.trade;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.trade.getoffers.v1.dto.GetOffersDto;

public class GetOffersExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );
    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    GetOffersDto getOffersDto = expressTradeApi.getOffers();
    System.out.println(getOffersDto);
  }
}
