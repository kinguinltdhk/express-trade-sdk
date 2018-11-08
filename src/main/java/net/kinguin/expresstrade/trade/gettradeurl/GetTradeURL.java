package net.kinguin.expresstrade.trade.gettradeurl;

import java.io.IOException;
import net.kinguin.expresstrade.trade.gettradeurl.v1.dto.GetTradeURLDto;

public interface GetTradeURL {

  GetTradeURLDto execute() throws IOException;
}
