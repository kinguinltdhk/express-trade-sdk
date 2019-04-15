package net.kinguin.expresstrade.item.getitemcounts.v1.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetItemCountsV1Dto extends ResponseDto {

  private List<GetItemCountsV1ResponseDto> response;

  @Data
  public static class GetItemCountsV1ResponseDto {

    private Integer count;
    private Integer internal_app_id;
  }
}
