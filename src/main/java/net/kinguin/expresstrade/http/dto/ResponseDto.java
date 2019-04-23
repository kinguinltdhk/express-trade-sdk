package net.kinguin.expresstrade.http.dto;

import lombok.Data;

@Data
public class ResponseDto {

  private Integer status;
  private Integer time;
  private Integer current_page;
  private Integer total_pages;
  private String message;
}
