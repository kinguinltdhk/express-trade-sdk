package net.kinguin.expresstrade.item.getitems.v1.http.dto;

import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetItemsDto extends ResponseDto {

  private GetItemsResponseDto response;

  @Data
  public static class GetItemsResponseDto {

    private Map<String, Object> items;
  }
}
