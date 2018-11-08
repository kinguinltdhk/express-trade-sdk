package net.kinguin.expresstrade.trade.gettradeurl.v1.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetTradeURLDto extends ResponseDto {

  private GetTradeUrlResponseDto response;

  @Data
  public static class GetTradeUrlResponseDto {

    private Integer uid;
    private String token;
    private String long_url;
    private String short_url;
  }
}
