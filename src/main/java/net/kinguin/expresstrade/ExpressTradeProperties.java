package net.kinguin.expresstrade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ExpressTradeProperties {

  private final Integer uid;
  private final String apiAuthKey;
  private final String secret;
  private String apiBaseUrl = "https://api-trade.opskins.com";
}
