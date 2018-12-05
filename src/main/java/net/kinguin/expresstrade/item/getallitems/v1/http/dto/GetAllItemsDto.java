package net.kinguin.expresstrade.item.getallitems.v1.http.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.item.StandardItemObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetAllItemsDto extends ResponseDto {

  private GetAllItemsResponseDto response;

  @Data
  public static class GetAllItemsResponseDto {

    private List<StandardItemObject> items;
  }
}
