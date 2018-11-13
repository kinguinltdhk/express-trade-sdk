package net.kinguin.expresstrade.trade.acceptoffer.v1.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.item.StandardItemObject;
import net.kinguin.expresstrade.trade.StandardTradeObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class AcceptOfferDto extends ResponseDto {

  private AcceptOfferResponseDto response;

  @Data
  public static class AcceptOfferResponseDto {

    private StandardTradeObject offer;

    private List<StandardItemObject> new_items;

    private Integer failed_cases;
  }
}
