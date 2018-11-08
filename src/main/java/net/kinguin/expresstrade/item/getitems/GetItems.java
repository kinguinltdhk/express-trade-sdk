package net.kinguin.expresstrade.item.getitems;

import java.io.IOException;
import net.kinguin.expresstrade.item.getitems.v1.http.dto.GetItemsDto;

public interface GetItems {

  GetItemsDto execute() throws IOException;
}
