package net.kinguin.expresstrade.trade.getapps;

import java.io.IOException;
import net.kinguin.expresstrade.trade.getapps.v1.dto.GetAppsDto;

public interface GetApps {
  GetAppsDto execute() throws IOException;
}
