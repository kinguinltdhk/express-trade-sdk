package net.kinguin.expresstrade.trade.getoffers;

import java.io.IOException;
import net.kinguin.expresstrade.trade.getoffers.v1.dto.GetOffersDto;

public interface GetOffers {

  GetOffersDto execute() throws IOException;
  GetOffersDto execute(String itemIds) throws IOException;
}
