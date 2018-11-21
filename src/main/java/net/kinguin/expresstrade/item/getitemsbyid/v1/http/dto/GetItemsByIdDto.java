package net.kinguin.expresstrade.item.getitemsbyid.v1.http.dto;

import java.util.List;
import lombok.Data;
import net.kinguin.expresstrade.item.StandardItemObject;

@Data
public class GetItemsByIdDto {
  private GetItemsByIdResponseDto response;

  @Data
  public static class GetItemsByIdResponseDto {
    private List<StandardItemObject> items;
    private List<Integer> unknown_items;
  }
}
