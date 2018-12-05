package net.kinguin.expresstrade.item.getallitems;

import java.io.IOException;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.item.getallitems.v1.http.dto.GetAllItemsDto;

public interface GetAllItems {

  GetAllItemsDto execute(Integer appId, String sku, String name, Integer page, Integer perPage,
      StandardItemSorts sort, Boolean noExclusions) throws IOException;
}
