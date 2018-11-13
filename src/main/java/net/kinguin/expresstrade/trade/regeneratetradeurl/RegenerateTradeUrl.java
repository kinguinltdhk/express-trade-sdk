package net.kinguin.expresstrade.trade.regeneratetradeurl;

import java.io.IOException;
import net.kinguin.expresstrade.trade.regeneratetradeurl.v1.dto.RegenerateTradeUrlDto;

public interface RegenerateTradeUrl {
  RegenerateTradeUrlDto execute() throws IOException;
}
