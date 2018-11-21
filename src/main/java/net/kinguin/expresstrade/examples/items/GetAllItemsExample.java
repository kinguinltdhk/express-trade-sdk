package net.kinguin.expresstrade.examples.items;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.item.getallitems.v1.http.dto.GetAllItemsDto;

public class GetAllItemsExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );

    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    GetAllItemsDto items = expressTradeApi.getAllItems(
        1,
        "sku",
        "name",
        1,
        1,
        StandardItemSorts.ASC_ID,
        false
    );
    System.out.println(items);
  }
}
