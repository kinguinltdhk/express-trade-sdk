package net.kinguin.expresstrade.item.getitemsbyid.v1.http.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder()
public class GetItemsByIdRequestDto {
  private String item_id;

  public static GetItemsByIdRequestDtoBuilder builder(String item_id) {
    if (item_id == null) {
      throw new IllegalArgumentException("item_id parameter is required");
    }

    return new GetItemsByIdRequestDtoBuilder().item_id(item_id);
  }
}
