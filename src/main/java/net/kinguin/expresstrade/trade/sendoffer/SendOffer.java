package net.kinguin.expresstrade.trade.sendoffer;

import java.io.IOException;
import net.kinguin.expresstrade.trade.sendoffer.v1.dto.SendOfferDto;

public interface SendOffer {

  SendOfferDto execute(
      Integer uid,
      String token,
      String tradeUrl,
      String items_to_send,
      String items_to_receive,
      Integer expiration_time,
      String message
  ) throws IOException;
}
