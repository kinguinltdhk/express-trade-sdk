package net.kinguin.expresstrade.trade.getuserinventoryfromsteamid;

import java.io.IOException;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.http.dto.GetUserInventoryFromSteamIdDto;

public interface GetUserInventoryFromSteamId {

  GetUserInventoryFromSteamIdDto execute(String steamId) throws IOException;
}
