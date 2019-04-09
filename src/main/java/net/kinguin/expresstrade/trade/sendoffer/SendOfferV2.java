package net.kinguin.expresstrade.trade.sendoffer;

import java.io.IOException;
import net.kinguin.expresstrade.trade.sendoffer.v2.dto.SendOfferV2Dto;

public interface SendOfferV2 {

  SendOfferV2Dto execute(
      Integer uid,
      String token,
      String tradeUrl,
      String itemsToSend,
      String itemsToReceive,
      Integer expirationTime,
      String message
  ) throws IOException;
}
