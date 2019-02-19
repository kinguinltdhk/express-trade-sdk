package net.kinguin.expresstrade.trade;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.kinguin.expresstrade.item.StandardItemObject;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class StandardTradeObject {

  private Integer id;
  private TradeUser sender;
  private TradeUser recipient;
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
  public static class TradeUser {

    private Integer id;
    private String steam_id;
    private String username;
    private String avatar;
    private Boolean verified;
    private List<StandardItemObject> items;
  }
}
