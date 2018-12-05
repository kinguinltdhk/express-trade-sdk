package net.kinguin.expresstrade.trade;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OfferSort {
  SORT_CREATED("created"),
  SORT_EXPIRED("expired"),
  SORT_MODIFIED("modified");

  private String sort;

  public String sort() {
    return sort;
  }
}
