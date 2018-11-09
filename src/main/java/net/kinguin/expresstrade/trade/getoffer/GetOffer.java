package net.kinguin.expresstrade.trade.getoffer;

import java.io.IOException;
import net.kinguin.expresstrade.trade.getoffer.v1.dto.GetOfferDto;

public interface GetOffer {
  GetOfferDto execute(Integer offerId) throws IOException;
}
