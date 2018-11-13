package net.kinguin.expresstrade.trade.acceptoffer.v1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AcceptOfferRequestDto {
  private Integer offer_id;
  private String twofactor_code;
}
