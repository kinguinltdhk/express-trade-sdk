package net.kinguin.expresstrade.trade.getoffers.v2.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.trade.StandardTradeObjectV2;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetOffersV2Dto extends ResponseDto {

  private GetOffersV2ResponseDto response;

  @Data
  public static class GetOffersV2ResponseDto {

    private List<StandardTradeObjectV2> offers;
    private Integer total;
  }
}
