package net.kinguin.expresstrade.trade.sendoffertosteamid;

import java.io.IOException;
import net.kinguin.expresstrade.trade.sendoffertosteamid.v1.dto.SendOfferToSteamIdDto;

public interface SendOfferToSteamId {

  SendOfferToSteamIdDto execute(
      String steamId,
      String itemsToSend,
      String itemsToReceive,
      Integer expirationTime,
      String message
  ) throws IOException;
}
