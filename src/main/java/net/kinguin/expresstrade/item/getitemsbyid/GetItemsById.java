package net.kinguin.expresstrade.item.getitemsbyid;

import java.io.IOException;
import net.kinguin.expresstrade.item.getitemsbyid.v1.http.dto.GetItemsByIdDto;

public interface GetItemsById {

  GetItemsByIdDto execute(String itemId) throws IOException;
}
