package net.kinguin.expresstrade;

import java.io.IOException;
import java.util.List;
import net.kinguin.expresstrade.item.StandardItemSorts;
import net.kinguin.expresstrade.item.getallitemdefinitions.GetAllItemDefinitions;
import net.kinguin.expresstrade.item.getallitemdefinitions.v1.GetAllItemDefinitionsV1;
import net.kinguin.expresstrade.item.getallitemdefinitions.v1.http.dto.GetAllItemDefinitionsDto;
import net.kinguin.expresstrade.item.getallitems.GetAllItems;
import net.kinguin.expresstrade.item.getallitems.v1.GetAllItemsV1;
import net.kinguin.expresstrade.item.getallitems.v1.http.dto.GetAllItemsDto;
import net.kinguin.expresstrade.item.getitemcounts.GetItemCounts;
import net.kinguin.expresstrade.item.getitemcounts.v1.GetItemCountsV1Impl;
import net.kinguin.expresstrade.item.getitemcounts.v1.dto.GetItemCountsV1Dto;
import net.kinguin.expresstrade.item.getitems.GetItems;
import net.kinguin.expresstrade.item.getitems.v1.GetItemsV1;
import net.kinguin.expresstrade.item.getitems.v1.http.dto.GetItemsDto;
import net.kinguin.expresstrade.item.getitemsbyid.GetItemsById;
import net.kinguin.expresstrade.item.getitemsbyid.v1.GetItemsByIdV1;
import net.kinguin.expresstrade.item.getitemsbyid.v1.http.dto.GetItemsByIdDto;
import net.kinguin.expresstrade.trade.acceptoffer.AcceptOffer;
import net.kinguin.expresstrade.trade.acceptoffer.AcceptOfferV2;
import net.kinguin.expresstrade.trade.acceptoffer.v1.AcceptOfferV1;
import net.kinguin.expresstrade.trade.acceptoffer.v1.dto.AcceptOfferDto;
import net.kinguin.expresstrade.trade.acceptoffer.v2.AcceptOfferV2Impl;
import net.kinguin.expresstrade.trade.acceptoffer.v2.dto.AcceptOfferV2Dto;
import net.kinguin.expresstrade.trade.canceloffer.CancelOffer;
import net.kinguin.expresstrade.trade.canceloffer.v1.CancelOfferV1;
import net.kinguin.expresstrade.trade.canceloffer.v1.dto.CancelOfferDto;
import net.kinguin.expresstrade.trade.getapps.GetApps;
import net.kinguin.expresstrade.trade.getapps.v1.GetAppsV1;
import net.kinguin.expresstrade.trade.getapps.v1.dto.GetAppsDto;
import net.kinguin.expresstrade.trade.getoffer.GetOffer;
import net.kinguin.expresstrade.trade.getoffer.GetOfferV2;
import net.kinguin.expresstrade.trade.getoffer.v1.GetOfferV1;
import net.kinguin.expresstrade.trade.getoffer.v1.dto.GetOfferDto;
import net.kinguin.expresstrade.trade.getoffer.v2.GetOfferV2Impl;
import net.kinguin.expresstrade.trade.getoffer.v2.dto.GetOfferV2Dto;
import net.kinguin.expresstrade.trade.getoffers.GetOffers;
import net.kinguin.expresstrade.trade.getoffers.GetOffersV2;
import net.kinguin.expresstrade.trade.getoffers.v1.GetOffersV1;
import net.kinguin.expresstrade.trade.getoffers.v1.dto.GetOffersDto;
import net.kinguin.expresstrade.trade.getoffers.v2.GetOffersV2Impl;
import net.kinguin.expresstrade.trade.getoffers.v2.dto.GetOffersV2Dto;
import net.kinguin.expresstrade.trade.gettradeurl.GetTradeUrl;
import net.kinguin.expresstrade.trade.gettradeurl.v1.GetTradeUrlV1;
import net.kinguin.expresstrade.trade.gettradeurl.v1.dto.GetTradeUrlDto;
import net.kinguin.expresstrade.trade.getuserinventory.GetUserInventory;
import net.kinguin.expresstrade.trade.getuserinventory.GetUserInventoryV2;
import net.kinguin.expresstrade.trade.getuserinventory.v1.GetUserInventoryV1;
import net.kinguin.expresstrade.trade.getuserinventory.v1.http.dto.GetUserInventoryDto;
import net.kinguin.expresstrade.trade.getuserinventory.v2.GetUserInventoryV2Impl;
import net.kinguin.expresstrade.trade.getuserinventory.v2.dto.GetUserInventoryV2Dto;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.GetUserInventoryFromSteamId;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.GetUserInventoryFromSteamIdV1;
import net.kinguin.expresstrade.trade.getuserinventoryfromsteamid.v1.http.dto.GetUserInventoryFromSteamIdDto;
import net.kinguin.expresstrade.trade.regeneratetradeurl.RegenerateTradeUrl;
import net.kinguin.expresstrade.trade.regeneratetradeurl.v1.RegenerateTradeUrlV1;
import net.kinguin.expresstrade.trade.regeneratetradeurl.v1.dto.RegenerateTradeUrlDto;
import net.kinguin.expresstrade.trade.sendoffer.SendOffer;
import net.kinguin.expresstrade.trade.sendoffer.SendOfferV2;
import net.kinguin.expresstrade.trade.sendoffer.v1.SendOfferV1;
import net.kinguin.expresstrade.trade.sendoffer.v1.dto.SendOfferDto;
import net.kinguin.expresstrade.trade.sendoffer.v2.SendOfferV2Impl;
import net.kinguin.expresstrade.trade.sendoffer.v2.dto.SendOfferV2Dto;
import net.kinguin.expresstrade.trade.sendoffertosteamid.SendOfferToSteamId;
import net.kinguin.expresstrade.trade.sendoffertosteamid.v1.SendOfferToSteamIdV1;
import net.kinguin.expresstrade.trade.sendoffertosteamid.v1.dto.SendOfferToSteamIdDto;

public class ExpressTradeApi {

  private GetUserInventory getUserInventory;

  private GetUserInventoryV2 getUserInventoryV2;

  private GetUserInventoryFromSteamId getUserInventoryFromSteamId;

  private GetItems getItems;

  private GetTradeUrl getTradeUrl;

  private GetOffers getOffers;

  private GetOffersV2 getOffersV2;

  private GetOffer getOffer;

  private GetOfferV2 getOfferV2;

  private SendOffer sendOffer;

  private SendOfferV2 sendOfferV2;

  private SendOfferToSteamId sendOfferToSteamId;

  private AcceptOffer acceptOffer;

  private AcceptOfferV2 acceptOfferV2;

  private CancelOffer cancelOffer;

  private GetApps getApps;

  private RegenerateTradeUrl regenerateTradeUrl;

  private GetAllItems getAllItems;

  private GetItemsById getItemsById;

  private GetAllItemDefinitions getAllItemDefinitions;

  private GetItemCounts getItemCounts;

  public ExpressTradeApi(ExpressTradeProperties expressTradeProperties) {
    this.getUserInventory = new GetUserInventoryV1(expressTradeProperties);
    this.getUserInventoryFromSteamId = new GetUserInventoryFromSteamIdV1(expressTradeProperties);
    this.getItems = new GetItemsV1(expressTradeProperties);
    this.getTradeUrl = new GetTradeUrlV1(expressTradeProperties);
    this.getOffers = new GetOffersV1(expressTradeProperties);
    this.getOffer = new GetOfferV1(expressTradeProperties);
    this.sendOffer = new SendOfferV1(expressTradeProperties);
    this.sendOfferToSteamId = new SendOfferToSteamIdV1(expressTradeProperties);
    this.acceptOffer = new AcceptOfferV1(expressTradeProperties);
    this.cancelOffer = new CancelOfferV1(expressTradeProperties);
    this.getApps = new GetAppsV1(expressTradeProperties);
    this.regenerateTradeUrl = new RegenerateTradeUrlV1(expressTradeProperties);
    this.getAllItems = new GetAllItemsV1(expressTradeProperties);
    this.getItemsById = new GetItemsByIdV1(expressTradeProperties);
    this.getAllItemDefinitions = new GetAllItemDefinitionsV1(expressTradeProperties);
    this.getUserInventoryV2 = new GetUserInventoryV2Impl(expressTradeProperties);
    this.getOffersV2 = new GetOffersV2Impl(expressTradeProperties);
    this.getOfferV2 = new GetOfferV2Impl(expressTradeProperties);
    this.acceptOfferV2 = new AcceptOfferV2Impl(expressTradeProperties);
    this.sendOfferV2 = new SendOfferV2Impl(expressTradeProperties);
    this.getItemCounts = new GetItemCountsV1Impl(expressTradeProperties);
  }

  public GetUserInventoryDto getUserInventory(
      Integer userId, Integer appId, Integer page, Integer perPage, String search,
      StandardItemSorts sort)
      throws IOException {
    return getUserInventory.execute(userId, appId, page, perPage, search, sort);
  }

  public GetUserInventoryFromSteamIdDto getUserInventoryFromSteamId(String steamId, Integer appId,
      Integer page, Integer perPage, String search, StandardItemSorts sort)
      throws IOException {
    return getUserInventoryFromSteamId.execute(steamId, appId, page, perPage, search, sort);
  }

  public GetItemsDto getItems(String skuFilter, Integer wearTierIndex) throws IOException {
    return getItems.execute(skuFilter, wearTierIndex);
  }

  public GetTradeUrlDto getTradeUrl() throws IOException {
    return getTradeUrl.execute();
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
      String itemsToSend,
      String itemsToReceive,
      Integer expirationTime,
      String message
  ) throws IOException {
    return sendOfferToSteamId
        .execute(steamId, itemsToSend, itemsToReceive, expirationTime, message);
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

  public GetAllItemsDto getAllItems(
      Integer appId, String sku, String name, Integer page, Integer perPage,
      StandardItemSorts sort, Boolean noExclusions
  ) throws IOException {
    return getAllItems.execute(appId, sku, name, page, perPage, sort, noExclusions);
  }

  public GetItemsByIdDto getItemsByIdDto(String itemId) throws IOException {
    return getItemsById.execute(itemId);
  }

  public GetAllItemDefinitionsDto getAllItemDefinitionsDto(Integer appId, String defIdFilter,
      String indexBy, Integer page, Integer perPage) throws IOException {
    return getAllItemDefinitions.execute(appId, defIdFilter, indexBy, page, perPage);
  }

  public GetUserInventoryV2Dto getUserInventoryV2(Integer userId, Integer appId, Integer page,
      Integer perPage, String search,
      StandardItemSorts sort)
      throws IOException {
    return getUserInventoryV2.execute(userId, appId, page, perPage, search, sort);
  }

  public GetOffersV2Dto getOffersV2(Integer userId, String state, String type, Integer page,
      Integer perPage, String ids, String sort) throws IOException {
    return getOffersV2.execute(userId, state, type, page, perPage, ids, sort);
  }

  public GetOfferV2Dto getOfferV2(Integer offerId) throws IOException {
    return getOfferV2.execute(offerId);
  }

  public AcceptOfferV2Dto acceptOfferV2(Integer offerId) throws IOException {
    return acceptOfferV2.execute(offerId);
  }

  public SendOfferV2Dto sendOfferV2(
      Integer uid,
      String token,
      String tradeUrl,
      String itemsToSend,
      String itemsToReceive,
      Integer expirationTime,
      String message
  ) throws IOException {
    return sendOfferV2
        .execute(uid, token, tradeUrl, itemsToSend, itemsToReceive, expirationTime, message);
  }

  public GetItemCountsV1Dto getItemCountsV1(List<Integer> appIds) throws IOException {
    return getItemCounts.execute(appIds);
  }
}
