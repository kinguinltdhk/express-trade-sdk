package net.kinguin.expresstrade.item.getitemcounts;

import java.io.IOException;
import java.util.List;
import net.kinguin.expresstrade.item.getitemcounts.v1.dto.GetItemCountsV1Dto;

public interface GetItemCounts {
  GetItemCountsV1Dto execute(List<Integer> appIds) throws IOException;
}
