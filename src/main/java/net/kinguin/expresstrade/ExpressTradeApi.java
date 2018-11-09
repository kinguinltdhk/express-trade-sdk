package net.kinguin.expresstrade;

import java.io.IOException;
import net.kinguin.expresstrade.item.getitems.GetItems;
import net.kinguin.expresstrade.item.getitems.v1.GetItemsV1;
import net.kinguin.expresstrade.item.getitems.v1.http.dto.GetItemsDto;
import net.kinguin.expresstrade.trade.getoffer.GetOffer;
import net.kinguin.expresstrade.trade.getoffer.v1.GetOfferV1;
import net.kinguin.expresstrade.trade.getoffer.v1.dto.GetOfferDto;
import net.kinguin.expresstrade.trade.getoffers.GetOffers;
import net.kinguin.expresstrade.trade.getoffers.v1.GetOffersV1;
import net.kinguin.expresstrade.trade.getoffers.v1.dto.GetOffersDto;
import net.kinguin.expresstrade.trade.gettradeurl.GetTradeURL;
import net.kinguin.expresstrade.trade.gettradeurl.v1.GetTradeURLV1;
import net.kinguin.expresstrade.trade.gettradeurl.v1.dto.GetTradeURLDto;
import net.kinguin.expresstrade.trade.getuserinventory.GetUserInventory;
import net.kinguin.expresstrade.trade.getuserinventory.v1.GetUserInventoryV1;
import net.kinguin.expresstrade.trade.getuserinventory.v1.http.dto.GetUserInventoryDto;
import net.kinguin.expresstrade.trade.sendoffer.SendOffer;
import net.kinguin.expresstrade.trade.sendoffer.v1.SendOfferV1;
import net.kinguin.expresstrade.trade.sendoffer.v1.dto.SendOfferDto;

public class ExpressTradeApi {

  private GetUserInventory getUserInventory;

  private GetItems getItems;

  private GetTradeURL getTradeURL;

  private GetOffers getOffers;

  private GetOffer getOffer;

  private SendOffer sendOffer;

  public ExpressTradeApi(ExpressTradeProperties expressTradeProperties) {
    this.getUserInventory = new GetUserInventoryV1(expressTradeProperties);
    this.getItems = new GetItemsV1(expressTradeProperties);
    this.getTradeURL = new GetTradeURLV1(expressTradeProperties);
    this.getOffers = new GetOffersV1(expressTradeProperties);
    this.getOffer = new GetOfferV1(expressTradeProperties);
    this.sendOffer = new SendOfferV1(expressTradeProperties);
  }

  public GetUserInventoryDto getUserInventory(Integer userId)
      throws IOException {
    return getUserInventory.execute(userId);
  }

  public GetItemsDto getItems() throws IOException {
    return getItems.execute();
  }

  public GetTradeURLDto getTradeURL() throws IOException {
    return getTradeURL.execute();
  }

  public GetOffersDto getOffers() throws IOException {
    return getOffers.execute();
  }

  public GetOfferDto getOffer(Integer offerId) throws IOException {
    return getOffer.execute(offerId);
  }

  public SendOfferDto sendOffer(
      Integer uid,
      String token,
      String tradeUrl,
      String items_to_send,
      String items_to_receive,
      Integer expiration_time,
      String message
  ) throws IOException {
    return sendOffer
        .execute(uid, token, tradeUrl, items_to_send, items_to_receive, expiration_time, message);
  }
}
