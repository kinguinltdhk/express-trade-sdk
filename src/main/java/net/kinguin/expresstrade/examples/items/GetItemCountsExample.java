package net.kinguin.expresstrade.examples.items;

import java.io.IOException;
import java.util.Arrays;
import net.kinguin.expresstrade.ExpressTradeApi;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.item.getitemcounts.v1.dto.GetItemCountsV1Dto;

public class GetItemCountsExample {
  public static void main(String[] args) throws IOException {
    ExpressTradeProperties expressTradeProperties =
        new ExpressTradeProperties(
            1234,
            "apiKey",
            "secret"
        );

    ExpressTradeApi expressTradeApi = new ExpressTradeApi(expressTradeProperties);

    GetItemCountsV1Dto itemCounts = expressTradeApi.getItemCountsV1(Arrays.asList(1, 2));
    System.out.println(itemCounts);
  }
}
