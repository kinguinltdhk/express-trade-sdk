package net.kinguin.expresstrade.trade.sendoffer;

import java.io.IOException;
import net.kinguin.expresstrade.trade.sendoffer.v1.dto.SendOfferDto;

public interface SendOffer {

  SendOfferDto execute(
      Integer uid,
      String token,
      String tradeUrl,
      String itemsToSend,
      String itemsToReceive,
      Integer expirationTime,
      String message
  ) throws IOException;
}
