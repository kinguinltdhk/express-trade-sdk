package net.kinguin.expresstrade.user.updateprofile.v1.http.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kinguin.expresstrade.http.dto.ResponseDto;
import net.kinguin.expresstrade.user.StandardUserProfileObject;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateProfileDto extends ResponseDto {

  private StandardUserProfileObjectDto response;

  @Data
  public static class StandardUserProfileObjectDto {

    private StandardUserProfileObject user;
  }
}
