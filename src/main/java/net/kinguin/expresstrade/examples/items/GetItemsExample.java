package net.kinguin.expresstrade.examples.items;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.item.getitems.v1.http.dto.GetItemsDto;

public class GetItemsExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );

    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    GetItemsDto items = expressTradeApi.getItems(null, null);
    System.out.println(items);
  }
}
