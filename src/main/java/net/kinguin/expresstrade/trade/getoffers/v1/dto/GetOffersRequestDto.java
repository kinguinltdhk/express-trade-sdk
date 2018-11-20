package net.kinguin.expresstrade.trade.getoffers.v1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetOffersRequestDto {

  private Integer uid;
  private String state;
  private String type;
  private Integer page;
  private Integer per_page;
  private String ids;
  private String sort;
}
