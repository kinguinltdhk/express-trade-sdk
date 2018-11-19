package net.kinguin.expresstrade.examples.trade;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.trade.getuserinventory.v1.http.dto.GetUserInventoryDto;

public class GetUserInventoryExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );
    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    GetUserInventoryDto getUserInventoryDto = expressTradeApi.getUserInventory(5631183);
    System.out.println(getUserInventoryDto);
  }
}
