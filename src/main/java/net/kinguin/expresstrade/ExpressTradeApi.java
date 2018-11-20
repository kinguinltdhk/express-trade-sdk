package net.kinguin.expresstrade;

import java.io.IOException;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.item.getitems.GetItems;
import net.kinguin.expresstrade.item.getitems.v1.GetItemsV1;
import net.kinguin.expresstrade.item.getitems.v1.http.dto.GetItemsDto;
import net.kinguin.expresstrade.trade.acceptoffer.AcceptOffer;
import net.kinguin.expresstrade.trade.acceptoffer.v1.AcceptOfferV1;
import net.kinguin.expresstrade.trade.acceptoffer.v1.dto.AcceptOfferDto;
import net.kinguin.expresstrade.trade.canceloffer.CancelOffer;
import net.kinguin.expresstrade.trade.canceloffer.v1.CancelOfferV1;
import net.kinguin.expresstrade.trade.canceloffer.v1.dto.CancelOfferDto;
import net.kinguin.expresstrade.trade.getapps.GetApps;
import net.kinguin.expresstrade.trade.getapps.v1.GetAppsV1;
import net.kinguin.expresstrade.trade.getapps.v1.dto.GetAppsDto;
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
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.GetUserInventoryFromSteamId;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.GetUserInventoryFromSteamIdV1;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.http.dto.GetUserInventoryFromSteamIdDto;
import net.kinguin.expresstrade.trade.regeneratetradeurl.RegenerateTradeUrl;
import net.kinguin.expresstrade.trade.regeneratetradeurl.v1.RegenerateTradeUrlV1;
import net.kinguin.expresstrade.trade.regeneratetradeurl.v1.dto.RegenerateTradeUrlDto;
import net.kinguin.expresstrade.trade.sendoffer.SendOffer;
import net.kinguin.expresstrade.trade.sendoffer.v1.SendOfferV1;
import net.kinguin.expresstrade.trade.sendoffer.v1.dto.SendOfferDto;
import net.kinguin.expresstrade.trade.sendoffertosteamid.SendOfferToSteamId;
import net.kinguin.expresstrade.trade.sendoffertosteamid.v1.SendOfferToSteamIdV1;
import net.kinguin.expresstrade.trade.sendoffertosteamid.v1.dto.SendOfferToSteamIdDto;

public class ExpressTradeApi {

  private GetUserInventory getUserInventory;

  private GetUserInventoryFromSteamId getUserInventoryFromSteamId;

  private GetItems getItems;

  private GetTradeURL getTradeURL;

  private GetOffers getOffers;

  private GetOffer getOffer;

  private SendOffer sendOffer;

  private SendOfferToSteamId sendOfferToSteamId;

  private AcceptOffer acceptOffer;

  private CancelOffer cancelOffer;

  private GetApps getApps;

  private RegenerateTradeUrl regenerateTradeUrl;

  public ExpressTradeApi(ExpressTradeProperties expressTradeProperties) {
    this.getUserInventory = new GetUserInventoryV1(expressTradeProperties);
    this.getUserInventoryFromSteamId = new GetUserInventoryFromSteamIdV1(expressTradeProperties);
    this.getItems = new GetItemsV1(expressTradeProperties);
    this.getTradeURL = new GetTradeURLV1(expressTradeProperties);
    this.getOffers = new GetOffersV1(expressTradeProperties);
    this.getOffer = new GetOfferV1(expressTradeProperties);
    this.sendOffer = new SendOfferV1(expressTradeProperties);
    this.sendOfferToSteamId = new SendOfferToSteamIdV1(expressTradeProperties);
    this.acceptOffer = new AcceptOfferV1(expressTradeProperties);
    this.cancelOffer = new CancelOfferV1(expressTradeProperties);
    this.getApps = new GetAppsV1(expressTradeProperties);
    this.regenerateTradeUrl = new RegenerateTradeUrlV1(expressTradeProperties);
  }

  public GetUserInventoryDto getUserInventory(
      Integer userId, Integer appId, Integer page, Integer perPage, String search,
      StandardItemSorts sort)
      throws IOException {
    return getUserInventory.execute(userId, appId, page, perPage, search, sort);
  }

  public GetUserInventoryFromSteamIdDto getUserInventoryFromSteamId(String steamId)
      throws IOException {
    return getUserInventoryFromSteamId.execute(steamId);
  }

  public GetItemsDto getItems() throws IOException {
    return getItems.execute();
  }

  public GetTradeURLDto getTradeURL() throws IOException {
    return getTradeURL.execute();
  }

  public GetOffersDto getOffers(Integer userId, String state, String type, Integer page,
      Integer perPage, String ids, String sort) throws IOException {
    return getOffers.execute(userId, state, type, page, perPage, ids, sort);
  }

  public GetOfferDto getOffer(Integer offerId) throws IOException {
    return getOffer.execute(offerId);
  }

  public SendOfferDto sendOffer(
      Integer uid,
      String token,
      String tradeUrl,
      String itemsToSend,
      String itemsToReceive,
      Integer expirationTime,
      String message
  ) throws IOException {
    return sendOffer
        .execute(uid, token, tradeUrl, itemsToSend, itemsToReceive, expirationTime, message);
  }

  public SendOfferToSteamIdDto sendOfferToSteamId(
      String steamId,
      String token,
      String tradeUrl,
      String itemsToSend,
      String itemsToReceive,
      Integer expirationTime,
      String message
  ) throws IOException {
    return sendOfferToSteamId
        .execute(steamId, token, tradeUrl, itemsToSend, itemsToReceive, expirationTime, message);
  }

  public AcceptOfferDto acceptOffer(Integer offerId) throws IOException {
    return acceptOffer.execute(offerId);
  }

  public CancelOfferDto cancelOffer(Integer offerId) throws IOException {
    return cancelOffer.execute(offerId);
  }

  public GetAppsDto getApps() throws IOException {
    return getApps.execute();
  }

  public RegenerateTradeUrlDto regenerateTradeUrl() throws IOException {
    return regenerateTradeUrl.execute();
  }
}
