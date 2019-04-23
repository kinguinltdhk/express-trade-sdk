package net.kinguin.expresstrade.user.getprofile;

import java.io.IOException;
import net.kinguin.expresstrade.user.getprofile.v1.http.dto.GetProfileDto;

public interface GetProfile {

  GetProfileDto execute(Boolean withExtra) throws IOException;
}
