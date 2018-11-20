package net.kinguin.expresstrade.trade;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OfferState {
  STATE_ACTIVE(2),
  STATE_ACCEPTED(3),
  STATE_EXPIRED(5),
  STATE_CANCELED(6),
  STATE_DECLINED(7),
  STATE_INVALID_ITEMS(8),
  STATE_PENDING_CASE_OPEN(9),
  STATE_EXPIRED_CASE_OPEN(10),
  STATE_FAILED_CASE_OPEN(12);

  private Integer state;

  public Integer state() {
    return state;
  }
}
