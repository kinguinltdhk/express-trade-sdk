package net.kinguin.expresstrade.examples.items;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.item.getitemsbyid.v1.http.dto.GetItemsByIdDto;

public class GetItemsByIdExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );

    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    GetItemsByIdDto items = expressTradeApi.getItemsByIdDto("123,345");
    System.out.println(items);
  }
}
