package net.kinguin.expresstrade.examples.trade;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.trade.getapps.v1.dto.GetAppsDto;
import net.kinguin.expresstrade.trade.gettradeurl.v1.dto.GetTradeURLDto;
import net.kinguin.expresstrade.trade.regeneratetradeurl.v1.dto.RegenerateTradeUrlDto;
import net.kinguin.expresstrade.trade.sendoffer.SendOffer;

public class RegenerateTradeUrlExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );
    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    RegenerateTradeUrlDto regenerateTradeUrlDto = expressTradeApi.regenerateTradeUrl();
    System.out.println(regenerateTradeUrlDto);
  }
}
