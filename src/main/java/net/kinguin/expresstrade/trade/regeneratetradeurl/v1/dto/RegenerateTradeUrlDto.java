package net.kinguin.expresstrade.trade.regeneratetradeurl.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegenerateTradeUrlDto extends ResponseDto {

  private RegenerateTradeUrlResponseDto response;

  @Data
  public static class RegenerateTradeUrlResponseDto {

    private Integer uid;
    private String token;
    private String long_url;
    private String short_url;
  }
}
