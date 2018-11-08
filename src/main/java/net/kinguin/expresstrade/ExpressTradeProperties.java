package net.kinguin.expresstrade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpressTradeProperties {

  private Integer uid;
  private String apiAuthKey;
  private String apiBaseUrl;
  private String secret;
}
