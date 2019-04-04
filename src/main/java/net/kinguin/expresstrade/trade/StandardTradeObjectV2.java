package net.kinguin.expresstrade.trade;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.kinguin.expresstrade.item.StandardItemObjectV2;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class StandardTradeObjectV2 {

  private Integer id;
  private TradeUserV2 sender;
  private TradeUserV2 recipient;
  private Integer state;
  private String state_name;
  private Integer time_created;
  private Integer time_updated;
  private Integer time_expires;
  private String message;
  private Boolean is_gift;
  private Boolean is_case_opening;
  private Boolean sent_by_you;

  @Data
  @NoArgsConstructor(access = AccessLevel.PUBLIC)
  @AllArgsConstructor(access = AccessLevel.PUBLIC)
  @Builder
  public static class TradeUserV2 {

    private Integer uid;
    private String steam_id;
    private String display_name;
    private String avatar;
    private Boolean verified;
    private List<StandardItemObjectV2> items;
  }
}
