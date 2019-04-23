package net.kinguin.expresstrade.user;

import lombok.Data;

@Data
public class StandardUserProfileObject {

  private Integer id;
  private String steam_id;
  private String display_name;
  private String avatar;
  private Boolean twofactor_enabled;
  private Boolean api_keys_exists;
  private String sms_phone;
  private String contact_email;
  private Boolean inventory_is_private;
  private Boolean allow_twofactor_code_reuse;
  private Boolean auto_accept_gift_trades;
  private Boolean anonymous_transactions;
}
