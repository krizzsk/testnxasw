package com.didi.soda.customer.blocks.actions;

import android.content.Context;
import com.appsflyer.internal.referrer.Payload;
import com.didi.soda.blocks.action.ActionNameMeta;
import com.didi.soda.blocks.action.ActionResult;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.business.BusinessOpen;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.blocks.BlockExtensionKt;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.coordshop.CoordShopModel;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper;
import com.didi.soda.home.topgun.manager.HomeBusinessPool;
import com.didi.soda.home.topgun.manager.HomeLogTrackerHelper;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.manager.ShopCateLandingOmegaHelper;
import com.didi.soda.search.helper.SearchLogHelper;
import com.didi.soda.search.helper.SearchNewOmegaHelper;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJH\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\b¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/soda/customer/blocks/actions/BusinessCardClickAction;", "Lcom/didi/soda/blocks/action/BaseAction;", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "context", "Landroid/content/Context;", "params", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;Landroid/content/Context;Ljava/util/HashMap;)V", "doExcute", "Lcom/didi/soda/blocks/action/ActionResult;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "isCoordShop", "", "data", "Lcom/google/gson/JsonObject;", "openBusinessHomePage", "", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "biData", "openBusinessHomePageFromSearch", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@ActionNameMeta(actionType = "businessCardClickAction")
/* compiled from: BusinessCardClickAction.kt */
public final class BusinessCardClickAction extends BaseAction {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessCardClickAction(WidgetNodeModel widgetNodeModel, Context context, HashMap<String, Object> hashMap) {
        super(widgetNodeModel, context, hashMap);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public ActionResult doExcute(Context context, IBlockScope iBlockScope, HashMap<String, Object> hashMap, Buildable buildable) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i;
        int i2;
        String str10;
        String str11;
        int i3;
        String str12;
        String str13;
        int i4;
        int i5;
        int i6;
        HashMap hashMap2;
        Object obj;
        Object filterInvalidValue;
        String obj2;
        Object obj3;
        Object filterInvalidValue2;
        String obj4;
        Object obj5;
        Object filterInvalidValue3;
        Object obj6;
        Object filterInvalidValue4;
        Object obj7;
        Object filterInvalidValue5;
        String obj8;
        Object obj9;
        Object filterInvalidValue6;
        String obj10;
        Object obj11;
        Object filterInvalidValue7;
        String obj12;
        Object obj13;
        Object filterInvalidValue8;
        String obj14;
        Object obj15;
        Object filterInvalidValue9;
        Object obj16;
        Object filterInvalidValue10;
        Object obj17;
        Object filterInvalidValue11;
        Object obj18;
        Object filterInvalidValue12;
        Object obj19;
        Object filterInvalidValue13;
        Object obj20;
        Object filterInvalidValue14;
        Object obj21;
        Object filterInvalidValue15;
        Object obj22;
        Object filterInvalidValue16;
        Object obj23;
        Object filterInvalidValue17;
        HashMap<String, Object> hashMap3 = hashMap;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(buildable, "widget");
        Object obj24 = hashMap3 == null ? null : hashMap3.get(Payload.TYPE_STORE);
        JsonObject jsonObject = obj24 instanceof JsonObject ? (JsonObject) obj24 : null;
        if (jsonObject == null || jsonObject.isJsonNull()) {
            return ActionResult.Companion.reject$default(ActionResult.Companion, (HashMap) null, 1, (Object) null);
        }
        if (hashMap3 == null || (obj23 = hashMap3.get(BlocksConst.BLOCK_PARAM_ROUTE_PATH)) == null || (filterInvalidValue17 = BlockExtensionKt.filterInvalidValue(obj23)) == null || (str = filterInvalidValue17.toString()) == null) {
            str = "";
        }
        if (hashMap3 == null || (obj22 = hashMap3.get("traceId")) == null || (filterInvalidValue16 = BlockExtensionKt.filterInvalidValue(obj22)) == null || (str2 = filterInvalidValue16.toString()) == null) {
            str2 = "";
        }
        if (hashMap3 == null || (obj21 = hashMap3.get("recId")) == null || (filterInvalidValue15 = BlockExtensionKt.filterInvalidValue(obj21)) == null || (str3 = filterInvalidValue15.toString()) == null) {
            str3 = "";
        }
        if (hashMap3 == null || (obj20 = hashMap3.get("filter")) == null || (filterInvalidValue14 = BlockExtensionKt.filterInvalidValue(obj20)) == null || (str4 = filterInvalidValue14.toString()) == null) {
            str4 = "";
        }
        if (hashMap3 == null || (obj19 = hashMap3.get("pageId")) == null || (filterInvalidValue13 = BlockExtensionKt.filterInvalidValue(obj19)) == null || (str5 = filterInvalidValue13.toString()) == null) {
            str5 = "";
        }
        if (hashMap3 == null || (obj18 = hashMap3.get(BlocksConst.BLOCK_PARAM_MODULE_ID)) == null || (filterInvalidValue12 = BlockExtensionKt.filterInvalidValue(obj18)) == null || (str6 = filterInvalidValue12.toString()) == null) {
            str6 = "";
        }
        if (hashMap3 == null || (obj17 = hashMap3.get(BlocksConst.BLOCK_PARAM_CATE_ID)) == null || (filterInvalidValue11 = BlockExtensionKt.filterInvalidValue(obj17)) == null || (str7 = filterInvalidValue11.toString()) == null) {
            str7 = "";
        }
        if (hashMap3 == null || (obj16 = hashMap3.get(BlocksConst.BLOCK_PARAM_COMPONENT_ID)) == null || (filterInvalidValue10 = BlockExtensionKt.filterInvalidValue(obj16)) == null || (str8 = filterInvalidValue10.toString()) == null) {
            str8 = "";
        }
        if (hashMap3 == null || (obj15 = hashMap3.get(BlocksConst.BLOCK_PARAM_COMPONENT_TYPE)) == null || (filterInvalidValue9 = BlockExtensionKt.filterInvalidValue(obj15)) == null || (str9 = filterInvalidValue9.toString()) == null) {
            str9 = "";
        }
        if (hashMap3 == null || (obj13 = hashMap3.get(BlocksConst.BLOCK_PARAM_PAGE_INDEX)) == null || (filterInvalidValue8 = BlockExtensionKt.filterInvalidValue(obj13)) == null || (obj14 = filterInvalidValue8.toString()) == null) {
            i = 0;
        } else {
            i = Integer.parseInt(obj14);
        }
        String str14 = "";
        if (hashMap3 == null || (obj11 = hashMap3.get(BlocksConst.BLOCK_PARAM_ABSOLUTE_POSITION)) == null || (filterInvalidValue7 = BlockExtensionKt.filterInvalidValue(obj11)) == null || (obj12 = filterInvalidValue7.toString()) == null) {
            i2 = 0;
        } else {
            i2 = Integer.parseInt(obj12);
        }
        if (hashMap3 == null || (obj9 = hashMap3.get("position")) == null || (filterInvalidValue6 = BlockExtensionKt.filterInvalidValue(obj9)) == null || (obj10 = filterInvalidValue6.toString()) == null) {
            str10 = str;
            str11 = str14;
        } else {
            str10 = str;
            str11 = obj10;
        }
        String str15 = str7;
        if (hashMap3 == null || (obj7 = hashMap3.get(BlocksConst.BLOCK_PARAM_SEARCH_INTENT)) == null || (filterInvalidValue5 = BlockExtensionKt.filterInvalidValue(obj7)) == null || (obj8 = filterInvalidValue5.toString()) == null) {
            i3 = 0;
        } else {
            i3 = Integer.parseInt(obj8);
        }
        int i7 = i3;
        if (hashMap3 == null || (obj6 = hashMap3.get("fromPage")) == null || (filterInvalidValue4 = BlockExtensionKt.filterInvalidValue(obj6)) == null || (str12 = filterInvalidValue4.toString()) == null) {
            str12 = str14;
        }
        String str16 = str12;
        if (hashMap3 == null || (obj5 = hashMap3.get(BlocksConst.BLOCK_SYNERGY_SHOP_ID)) == null || (filterInvalidValue3 = BlockExtensionKt.filterInvalidValue(obj5)) == null || (str13 = filterInvalidValue3.toString()) == null) {
            str13 = str14;
        }
        String str17 = str13;
        if (hashMap3 == null || (obj3 = hashMap3.get(BlocksConst.BLOCK_SYNERGY_SOURCE_POSITION)) == null || (filterInvalidValue2 = BlockExtensionKt.filterInvalidValue(obj3)) == null || (obj4 = filterInvalidValue2.toString()) == null) {
            i4 = 0;
        } else {
            i4 = Integer.parseInt(obj4);
        }
        int i8 = i4;
        if (hashMap3 == null || (obj = hashMap3.get(BlocksConst.BLOCK_SYNERGY_SEQ)) == null || (filterInvalidValue = BlockExtensionKt.filterInvalidValue(obj)) == null || (obj2 = filterInvalidValue.toString()) == null) {
            i5 = 0;
        } else {
            i5 = Integer.parseInt(obj2);
        }
        jsonObject.addProperty(BlocksConst.BLOCK_PARAM_MODULE_ID, str6);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add("data", jsonObject);
        jsonObject2.addProperty(BlocksConst.BLOCK_PARAM_COMPONENT_ID, str8);
        jsonObject2.addProperty("type", str9);
        jsonObject2.addProperty("position", str11);
        Unit unit = Unit.INSTANCE;
        FeedPayload feedPayload = new FeedPayload();
        feedPayload.mPageId = str5;
        feedPayload.mPageIndex = i;
        feedPayload.mComponentIndex = i2;
        feedPayload.mPageFilter = str4;
        feedPayload.mRecId = str3;
        feedPayload.mTraceId = str2;
        feedPayload.mCateId = str15;
        feedPayload.mFromPage = str16;
        feedPayload.mIntentionType = i7;
        Unit unit2 = Unit.INSTANCE;
        String str18 = str10;
        if (RoutePath.SEARCH_HOME.equals(str18)) {
            feedPayload.mSource = 2;
        }
        HomeBusinessInfoRvModel convertCompJson = HomeBusinessInfoRvModel.convertCompJson(jsonObject2, feedPayload);
        if (m32274a(jsonObject)) {
            CoordShopModel coordShopModel = new CoordShopModel();
            coordShopModel.setSynergyShopId(str17);
            coordShopModel.setSynergySeq(i5);
            coordShopModel.setSourcePosition(i8);
            Unit unit3 = Unit.INSTANCE;
            convertCompJson.coordShopModel = coordShopModel;
        }
        if ("homePage".equals(str18)) {
            HomeOmegaHelper.getInstance().setOmegaGuideParam(convertCompJson);
            HomeOmegaHelper.getInstance().onOmegaBusinessCk(convertCompJson, true);
            String businessBiData = HomeOmegaHelper.getInstance().getBusinessBiData(convertCompJson);
            Intrinsics.checkNotNullExpressionValue(convertCompJson, "businessRvModel");
            openBusinessHomePage(convertCompJson, businessBiData);
        } else if (RoutePath.BLOCKS_LANDING_PAGE.equals(str18)) {
            TopicActOmegaHelper instance = TopicActOmegaHelper.Companion.getInstance();
            Intrinsics.checkNotNullExpressionValue(convertCompJson, "businessRvModel");
            instance.setOmegaGuideParam(convertCompJson);
            TopicActOmegaHelper.Companion.getInstance().onOmegaBusinessCk(convertCompJson, true);
            openBusinessHomePage(convertCompJson, TopicActOmegaHelper.Companion.getInstance().getBusinessBiData(convertCompJson));
        } else {
            if (RoutePath.SHOP_CATEGORY_LANDING_PAGE.equals(str18)) {
                ShopCateLandingOmegaHelper.getInstance().setOmegaGuideParam(convertCompJson);
                i6 = 1;
                ShopCateLandingOmegaHelper.getInstance().onOmegaBusinessCk(convertCompJson, true);
                String businessBiData2 = ShopCateLandingOmegaHelper.getInstance().getBusinessBiData(convertCompJson);
                Intrinsics.checkNotNullExpressionValue(convertCompJson, "businessRvModel");
                openBusinessHomePage(convertCompJson, businessBiData2);
            } else {
                i6 = 1;
                if (RoutePath.SEARCH_HOME.equals(str18)) {
                    SearchNewOmegaHelper.getInstance().setBusinessGuideParam(convertCompJson);
                    hashMap2 = null;
                    SearchNewOmegaHelper.getInstance().trackBusinessClick(convertCompJson, (SearchFoodItemView.SearchFoodItemModel) null, true);
                    String genBusinessBiData = SearchNewOmegaHelper.genBusinessBiData(convertCompJson, (SearchFoodItemView.SearchFoodItemModel) null);
                    Intrinsics.checkNotNullExpressionValue(convertCompJson, "businessRvModel");
                    openBusinessHomePageFromSearch(convertCompJson, genBusinessBiData);
                    return ActionResult.Companion.resolve$default(ActionResult.Companion, hashMap2, i6, hashMap2);
                }
            }
            hashMap2 = null;
            return ActionResult.Companion.resolve$default(ActionResult.Companion, hashMap2, i6, hashMap2);
        }
        hashMap2 = null;
        i6 = 1;
        return ActionResult.Companion.resolve$default(ActionResult.Companion, hashMap2, i6, hashMap2);
    }

    public final void openBusinessHomePageFromSearch(HomeBusinessInfoRvModel homeBusinessInfoRvModel, String str) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "rvModel");
        BusinessOpen.Companion.create(homeBusinessInfoRvModel.mShopId).transitionName(homeBusinessInfoRvModel.mTransitionNameSet).businessAnimationSource(Integer.valueOf(homeBusinessInfoRvModel.mSource)).biData(str).businessType(homeBusinessInfoRvModel.businessType).url(homeBusinessInfoRvModel.url).open();
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("shopId", homeBusinessInfoRvModel.mShopId);
        map.put("shopName", homeBusinessInfoRvModel.mShopName);
        Serializable serializable = homeBusinessInfoRvModel.mTransitionNameSet;
        if (serializable == null) {
            serializable = "";
        }
        map.put("transitionName", serializable);
        SearchLogHelper.setLogTracker("openBusinessHomePageFromSearch", "c-act|", hashMap);
    }

    public final void openBusinessHomePage(HomeBusinessInfoRvModel homeBusinessInfoRvModel, String str) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "rvModel");
        BusinessOpen.Companion.create(homeBusinessInfoRvModel.mShopId).shopInfoEntity(HomeBusinessPool.getPool().getBusiness(homeBusinessInfoRvModel.mShopId)).biData(str).needSynergyShop(Intrinsics.areEqual((Object) homeBusinessInfoRvModel.mPageId, (Object) "homePage")).businessType(homeBusinessInfoRvModel.businessType).url(homeBusinessInfoRvModel.url).open();
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("shopId", homeBusinessInfoRvModel.mShopId);
        map.put("shopName", homeBusinessInfoRvModel.mShopName);
        String str2 = homeBusinessInfoRvModel.mPageId;
        if (str2 == null) {
            str2 = "";
        }
        map.put("pageId", str2);
        HomeLogTrackerHelper.setLogTracker("onBusinessClick", "c-act|", hashMap);
    }

    /* renamed from: a */
    private final boolean m32274a(JsonObject jsonObject) {
        JsonPrimitive asJsonPrimitive;
        JsonObject asJsonObject = jsonObject.getAsJsonObject("collaborationInfo");
        if (asJsonObject == null || asJsonObject.isJsonNull() || (asJsonPrimitive = asJsonObject.getAsJsonPrimitive("isCollaboration")) == null || !asJsonPrimitive.getAsBoolean()) {
            return false;
        }
        return true;
    }
}
