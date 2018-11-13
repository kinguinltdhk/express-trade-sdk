package net.kinguin.expresstrade.trade.getapps.v1.dto;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetAppsDto extends ResponseDto {
  private GetAppsResponseDto response;

  @Data
  public static class GetAppsResponseDto {
    private List<GetAppsResponseAppsDto> apps;

    @Data
    public static class GetAppsResponseAppsDto {
      private Integer internal_app_id;
      private Integer steam_app_id;
      private Integer steam_context_id;
      private String name;
      private String long_name;
      private String img;
    }
  }
}
