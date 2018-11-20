package net.kinguin.expresstrade.trade.getoffers;

import java.io.IOException;
import net.kinguin.expresstrade.trade.getoffers.v1.dto.GetOffersDto;

public interface GetOffers {

  GetOffersDto execute(Integer userId, String state, String type, Integer page, Integer perPage,
      String ids, String sort) throws IOException;
}
