package net.kinguin.expresstrade.trade.acceptoffer;

import java.io.IOException;
import net.kinguin.expresstrade.trade.acceptoffer.v2.dto.AcceptOfferV2Dto;

public interface AcceptOfferV2 {

  AcceptOfferV2Dto execute(Integer offerId) throws IOException;
}
