package net.kinguin.expresstrade.trade.acceptoffer;

import java.io.IOException;
import net.kinguin.expresstrade.trade.acceptoffer.v1.dto.AcceptOfferDto;

public interface AcceptOffer {

  AcceptOfferDto execute(Integer offerId) throws IOException;
}
