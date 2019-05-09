package net.kinguin.expresstrade.user.updateprofile;

import java.io.IOException;
import net.kinguin.expresstrade.user.updateprofile.v1.http.dto.UpdateProfileDto;

public interface UpdateProfile {

  UpdateProfileDto execute(String displayName, Boolean inventoryIsPrivate,
      Boolean allowTwoFactorCodeReuse, Boolean autoAcceptGiftTrades, Boolean anonymousTransactions)
      throws IOException;
}
