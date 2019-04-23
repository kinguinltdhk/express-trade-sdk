package net.kinguin.expresstrade.trade.getoffers;

import java.io.IOException;
import net.kinguin.expresstrade.trade.getoffers.v2.dto.GetOffersV2Dto;

public interface GetOffersV2 {

  GetOffersV2Dto execute(Integer userId, String state, String type, Integer page, Integer perPage,
      String ids, String sort) throws IOException;
}
