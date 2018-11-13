package net.kinguin.expresstrade.trade.canceloffer;

import java.io.IOException;
import net.kinguin.expresstrade.trade.canceloffer.v1.dto.CancelOfferDto;

public interface CancelOffer {
  CancelOfferDto execute(Integer offerId) throws IOException;
}
