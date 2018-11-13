package net.kinguin.expresstrade.trade.canceloffer.v1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelOfferRequestDto {
  private Integer offer_id;
}
