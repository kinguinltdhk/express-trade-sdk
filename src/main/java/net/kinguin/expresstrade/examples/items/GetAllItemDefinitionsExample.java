package net.kinguin.expresstrade.examples.items;

import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.item.getallitemdefinitions.v1.http.dto.GetAllItemDefinitionsDto;

public class GetAllItemDefinitionsExample {

  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );

    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    GetAllItemDefinitionsDto getAllItemsDto = expressTradeApi.getAllItemDefinitionsDto(
        1,
        null,
        null,
        1,
        1
    );

    System.out.println(getAllItemsDto);
  }
}
