package net.kinguin.expresstrade.user.updateprofile.v1;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import net.kinguin.expresstrade.ExpressTradeProperties;
import net.kinguin.expresstrade.http.Client;
import net.kinguin.expresstrade.http.RequestUriBuilder;
import net.kinguin.expresstrade.user.updateprofile.UpdateProfile;
import net.kinguin.expresstrade.user.updateprofile.v1.http.dto.UpdateProfileDto;

public class UpdateProfileV1 extends Client implements UpdateProfile {

  private static final String ENDPOINT_URL = "/IUser/UpdateProfile/v1/";
  private final JsonAdapter<UpdateProfileDto> jsonAdapter =
      moshi.adapter(UpdateProfileDto.class);

  public UpdateProfileV1(ExpressTradeProperties expressTradeProperties) {
    super(expressTradeProperties, ENDPOINT_URL);
  }

  @Override
  public UpdateProfileDto execute(String displayName, Boolean inventoryIsPrivate,
      Boolean allowTwoFactorCodeReuse, Boolean autoAcceptGiftTrades, Boolean anonymousTransactions)
      throws IOException {
    requestUriBuilder = new RequestUriBuilder()
        .addParam("display_name", displayName)
        .addParam("inventory_is_private", inventoryIsPrivate)
        .addParam("allow_twofactor_code_reuse", allowTwoFactorCodeReuse)
        .addParam("auto_accept_gift_trades", autoAcceptGiftTrades)
        .addParam("anonymous_transactions", anonymousTransactions);

    return this.jsonAdapter.fromJson(this.makePostRequest().string());
  }
}
