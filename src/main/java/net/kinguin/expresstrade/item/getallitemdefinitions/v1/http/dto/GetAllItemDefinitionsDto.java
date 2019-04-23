package net.kinguin.expresstrade.item.getallitemdefinitions.v1.http.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetAllItemDefinitionsDto extends ResponseDto {

  private GetAllItemDefinitionsResponseDto response;

  @Data
  public static class GetAllItemDefinitionsResponseDto {

    private List<GetAllItemDefinitionsResponseItemDto> definitions;
  }
}
