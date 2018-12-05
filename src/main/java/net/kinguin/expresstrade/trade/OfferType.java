package net.kinguin.expresstrade.trade;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OfferType {
  TYPE_SENT("sent"),
  TYPE_RECEIVED("received");

  private String type;

  public String type() {
    return type;
  }
}
