package net.kinguin.expresstrade.trade.gettradeurl;

import java.io.IOException;
import net.kinguin.expresstrade.trade.gettradeurl.v1.dto.GetTradeUrlDto;

public interface GetTradeUrl {

  GetTradeUrlDto execute() throws IOException;
}
