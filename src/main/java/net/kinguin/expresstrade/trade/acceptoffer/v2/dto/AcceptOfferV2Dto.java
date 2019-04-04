package net.kinguin.expresstrade.trade.acceptoffer.v2.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.item.StandardItemObject;
import net.kinguin.expresstrade.item.StandardItemObjectV2;
import net.kinguin.expresstrade.trade.StandardTradeObject;
import net.kinguin.expresstrade.trade.StandardTradeObjectV2;

@Data
@EqualsAndHashCode(callSuper = false)
public class AcceptOfferV2Dto extends ResponseDto {

  private AcceptOfferV2ResponseDto response;

  @Data
  public static class AcceptOfferV2ResponseDto {

    private StandardTradeObjectV2 offer;

    private List<StandardItemObjectV2> new_items;

    private Integer failed_cases;
  }
}
