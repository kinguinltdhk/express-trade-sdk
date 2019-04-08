package net.kinguin.expresstrade.trade.getoffer;

import java.io.IOException;
import net.kinguin.expresstrade.trade.getoffer.v1.dto.GetOfferDto;
import net.kinguin.expresstrade.trade.getoffer.v2.dto.GetOfferV2Dto;

public interface GetOfferV2 {

  GetOfferV2Dto execute(Integer offerId) throws IOException;
}
