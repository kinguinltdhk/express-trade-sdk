package net.kinguin.expresstrade.item.getallitemdefinitions;

import java.io.IOException;
import net.kinguin.expresstrade.item.getallitemdefinitions.v1.http.dto.GetAllItemDefinitionsDto;

public interface GetAllItemDefinitions {

  GetAllItemDefinitionsDto execute(Integer appId, String defIdFilter, String indexBy, Integer page,
      Integer perPage) throws IOException;
}
