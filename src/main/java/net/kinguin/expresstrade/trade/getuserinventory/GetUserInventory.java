package net.kinguin.expresstrade.trade.getuserinventory;

import java.io.IOException;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.trade.getuserinventory.v1.http.dto.GetUserInventoryDto;

public interface GetUserInventory {

  GetUserInventoryDto execute(Integer userId, Integer appId, Integer page, Integer perPage,
      String search, StandardItemSorts sort) throws IOException;
}
