package com.didi.soda.home.topgun.manager;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CategoryNotifyEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.model.HomeRealExposureModelV2;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.RichTextParser;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;

public class ShopCateLandingOmegaHelper implements HomeBusinessItemBinder.HomeBusinessOmegaInterface {

    /* renamed from: a */
    private static final String f45511a = "ShopCateLandingOmegaHelper";

    /* renamed from: b */
    private static ShopCateLandingOmegaHelper f45512b = new ShopCateLandingOmegaHelper();

    /* renamed from: c */
    private WeakReference<ScopeContext> f45513c;

    /* renamed from: d */
    private OnceActionUtil.ActionPool f45514d;

    public static ShopCateLandingOmegaHelper getInstance() {
        return f45512b;
    }

    public void attach(ScopeContext scopeContext) {
        this.f45513c = new WeakReference<>(scopeContext);
        this.f45514d = new OnceActionUtil.ActionPool();
    }

    public void detach(ScopeContext scopeContext) {
        WeakReference<ScopeContext> weakReference = this.f45513c;
        if (weakReference != null && scopeContext == weakReference.get()) {
            this.f45513c = null;
            this.f45514d = null;
        }
    }

    public void reset() {
        OnceActionUtil.ActionPool actionPool = this.f45514d;
        if (actionPool != null) {
            actionPool.reset();
        }
    }

    public void trackShopCateLandingSW(String str, String str2) {
        OmegaTracker.Builder.create(EventConst.ShopCateLanding.SAILING_C_X_SECOND_CATEGORY_SW).addEventParam(ParamConst.TRACE_ID, str).addEventParam(ParamConst.PARAM_CATEGORY_ID, str2).build().track();
    }

    public void onOmegaBusinessSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel, boolean z) {
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mShopId)) {
            final String moduleString = homeBusinessInfoRvModel.toModuleString();
            final HomeBusinessInfoRvModel homeBusinessInfoRvModel2 = homeBusinessInfoRvModel;
            final boolean z2 = z;
            m33819a(new OnceActionUtil.OnceAction(new Object[]{homeBusinessInfoRvModel.mShopId, homeBusinessInfoRvModel.mComponentType, moduleString}) {
                public void run() {
                    HomeRealExposureModelV2 homeRealExposureModelV2 = new HomeRealExposureModelV2();
                    homeRealExposureModelV2.f43697id = homeBusinessInfoRvModel2.mShopId;
                    homeRealExposureModelV2.type = homeBusinessInfoRvModel2.mComponentType;
                    homeRealExposureModelV2.location = moduleString;
                    homeRealExposureModelV2.status = homeBusinessInfoRvModel2.mShopStatus;
                    homeRealExposureModelV2.deliveryFee = homeBusinessInfoRvModel2.mCurrency + "_" + homeBusinessInfoRvModel2.mDeliveryPriceOri + "_" + homeBusinessInfoRvModel2.mDeliveryPriceAct;
                    homeRealExposureModelV2.deliveryTime = homeBusinessInfoRvModel2.mDeliveryTime;
                    homeRealExposureModelV2.deliveryType = homeBusinessInfoRvModel2.mDeliveryType;
                    homeRealExposureModelV2.recId = homeBusinessInfoRvModel2.mRecId;
                    int i = 2;
                    homeRealExposureModelV2.hasCouponLogo = homeBusinessInfoRvModel2.mIsCouponLogo ? 1 : 2;
                    if (z2) {
                        if (homeBusinessInfoRvModel2.mRecInfo != null) {
                            i = 1;
                        }
                        homeRealExposureModelV2.hasRecInfo = i;
                    }
                    homeRealExposureModelV2.page = Const.HomeBusinessPageSource.SHOP_SPECIAL_PAGE;
                    homeRealExposureModelV2.module = Const.HomeV3TraceModelId.SHOP_SPECIAL_PAGE;
                    homeRealExposureModelV2.index = homeBusinessInfoRvModel2.mIndexInModule;
                    homeRealExposureModelV2.absolutePosition = homeBusinessInfoRvModel2.mAbsoluteIndex;
                    homeRealExposureModelV2.cateId = homeBusinessInfoRvModel2.mCateId;
                    homeRealExposureModelV2.isShopLogo = TextUtils.isEmpty(homeBusinessInfoRvModel2.mLogo) ^ true ? 1 : 0;
                    if (!CollectionsUtil.isEmpty(homeBusinessInfoRvModel2.mTags)) {
                        JsonArray jsonArray = new JsonArray();
                        for (PromptEntity next : homeBusinessInfoRvModel2.mTags) {
                            if (next != null) {
                                JsonObject jsonObject = new JsonObject();
                                if (!TextUtils.isEmpty(next.activityId)) {
                                    jsonObject.addProperty("activity_id", next.activityId);
                                }
                                if (!TextUtils.isEmpty(next.activityType)) {
                                    jsonObject.addProperty("activity_type", next.activityType);
                                }
                                if (jsonObject.size() > 0) {
                                    jsonArray.add((JsonElement) jsonObject);
                                }
                            }
                        }
                        if (!jsonArray.isEmpty()) {
                            homeRealExposureModelV2.activityInfos = jsonArray;
                        }
                    }
                    String appInstanceID = ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getAppInstanceID();
                    OmegaTracker.Builder addEventParam = ShopCateLandingOmegaHelper.this.m33817a(EventConst.Home.HOME_REAL_EXPOSURE_SW).addEventParam("content_json", GsonUtil.toJson(homeRealExposureModelV2)).addEventParam(ParamConst.FILTER_PARAM, homeBusinessInfoRvModel2.mPageFilter).addEventParam(ParamConst.PARAM_MODULE_TYPE, homeBusinessInfoRvModel2.mModuleType).addEventParam(ParamConst.PARAM_MODULE_SEQUENCE, homeBusinessInfoRvModel2.mModuleIndex).addEventParam(ParamConst.TRACE_ID, homeBusinessInfoRvModel2.mTraceId).addEventParam("resource_id", homeBusinessInfoRvModel2.mResourceId);
                    if (appInstanceID == null) {
                        appInstanceID = "";
                    }
                    addEventParam.addEventParam(ParamConst.PARAMS_GOOGLE_APP_INSTANCE_ID, appInstanceID).build().track();
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOmegaBusinessCk(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r7, boolean r8) {
        /*
            r6 = this;
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.PromptEntity> r0 = r7.mTags
            boolean r0 = com.didi.soda.customer.foundation.util.CollectionsUtil.isEmpty(r0)
            if (r0 != 0) goto L_0x0059
            com.google.gson.JsonArray r0 = new com.google.gson.JsonArray
            r0.<init>()
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.PromptEntity> r1 = r7.mTags
            java.util.Iterator r1 = r1.iterator()
        L_0x0013:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r1.next()
            com.didi.soda.customer.foundation.rpc.entity.PromptEntity r2 = (com.didi.soda.customer.foundation.rpc.entity.PromptEntity) r2
            if (r2 == 0) goto L_0x0013
            com.google.gson.JsonObject r3 = new com.google.gson.JsonObject
            r3.<init>()
            java.lang.String r4 = r2.activityId
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0035
            java.lang.String r4 = r2.activityId
            java.lang.String r5 = "activity_id"
            r3.addProperty((java.lang.String) r5, (java.lang.String) r4)
        L_0x0035:
            java.lang.String r4 = r2.activityType
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0044
            java.lang.String r2 = r2.activityType
            java.lang.String r4 = "activity_type"
            r3.addProperty((java.lang.String) r4, (java.lang.String) r2)
        L_0x0044:
            int r2 = r3.size()
            if (r2 <= 0) goto L_0x0013
            r0.add((com.google.gson.JsonElement) r3)
            goto L_0x0013
        L_0x004e:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0059
            java.lang.String r0 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r0)
            goto L_0x005b
        L_0x0059:
            java.lang.String r0 = ""
        L_0x005b:
            java.lang.String r1 = "sailing_c_x_homepage_shop_ck"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r6.m33817a((java.lang.String) r1)
            java.lang.String r2 = r7.mShopId
            java.lang.String r3 = "shop_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            java.lang.String r2 = r7.mShopName
            java.lang.String r3 = "shop_name"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            int r2 = r7.mShopStatus
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "shop_status"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r7.mCurrency
            r2.append(r3)
            java.lang.String r3 = "_"
            r2.append(r3)
            int r4 = r7.mDeliveryPriceOri
            r2.append(r4)
            r2.append(r3)
            int r3 = r7.mDeliveryPriceAct
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "shop_delivery_fee"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            int r2 = r7.mDeliveryTime
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "shop_delivery_time"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            java.util.List<java.lang.String> r2 = r7.mShopTipList
            java.lang.String r3 = ","
            java.lang.String r2 = com.didi.soda.customer.foundation.util.SentenceUtil.foldStringList(r2, r3)
            java.lang.String r4 = "shop_tag"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r4, r2)
            java.util.List<java.lang.String> r2 = r7.mActTipList
            java.lang.String r2 = com.didi.soda.customer.foundation.util.SentenceUtil.foldStringList(r2, r3)
            java.lang.String r3 = "shop_discount_tag"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            java.lang.CharSequence r2 = r7.mShopCateInfoDescForTrack
            java.lang.String r3 = "shop_main_tag"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            java.lang.String r2 = r7.mModuleType
            java.lang.String r3 = "module_type"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            java.lang.String r2 = r7.mModuleIndex
            java.lang.String r3 = "module_sequence"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            int r2 = r7.mDeliveryType
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "delivery_type"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = r1.addEventParam(r3, r2)
            r2 = 1
            if (r8 == 0) goto L_0x00f8
            com.didi.soda.customer.foundation.rpc.entity.PromptEntity r8 = r7.mRecInfo
            if (r8 != 0) goto L_0x00f6
            r8 = 2
            goto L_0x00f9
        L_0x00f6:
            r8 = 1
            goto L_0x00f9
        L_0x00f8:
            r8 = 0
        L_0x00f9:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r3 = "is_recommend_reason"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r8 = r1.addEventParam(r3, r8)
            java.lang.String r1 = r7.mResourceId
            java.lang.String r3 = "resource_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r8 = r8.addEventParam(r3, r1)
            java.lang.String r1 = r7.mTraceId
            java.lang.String r3 = "trace_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r8 = r8.addEventParam(r3, r1)
            java.lang.String r1 = r7.mLogo
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r1 = r1 ^ r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "is_shop_logo"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r8 = r8.addEventParam(r2, r1)
            java.lang.String r1 = "page"
            java.lang.String r2 = "specialpage"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r8 = r8.addEventParam(r1, r2)
            java.lang.String r1 = "module"
            java.lang.String r2 = "7777"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r8 = r8.addEventParam(r1, r2)
            int r1 = r7.mIndexInModule
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "index"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r8 = r8.addEventParam(r2, r1)
            int r1 = r7.mAbsoluteIndex
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "absolute_position"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r8 = r8.addEventParam(r2, r1)
            java.lang.String r7 = r7.mCateId
            java.lang.String r1 = "category_id"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r8.addEventParam(r1, r7)
            java.lang.String r8 = "activity_info"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.addEventParam(r8, r0)
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r7 = r7.enableGuideParam()
            com.didi.soda.customer.foundation.tracker.OmegaTracker r7 = r7.build()
            r7.track()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.manager.ShopCateLandingOmegaHelper.onOmegaBusinessCk(com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel, boolean):void");
    }

    public void setOmegaGuideParam(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        String moduleString = homeBusinessInfoRvModel.toModuleString();
        String str = homeBusinessInfoRvModel.mRecId;
        m33818a(moduleString, str, "shop_" + homeBusinessInfoRvModel.mShopId, homeBusinessInfoRvModel.mPageFilter);
    }

    public String getBusinessBiData(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("user_id", LoginUtil.getUid());
        jsonObject.addProperty("shop_id", homeBusinessInfoRvModel.mShopId);
        jsonObject.addProperty("from_page", homeBusinessInfoRvModel.mPageId);
        JsonElement jsonElement = FilterEntity.toJsonElement(homeBusinessInfoRvModel.mPageFilter);
        if (jsonElement != null) {
            jsonObject.add("lv1_filter", jsonElement);
        }
        jsonObject.addProperty("lv1_location", homeBusinessInfoRvModel.toModuleString());
        jsonObject.addProperty("lv1_recid", homeBusinessInfoRvModel.mRecId);
        return jsonObject.toString();
    }

    /* renamed from: a */
    private void m33818a(String str, String str2, String str3, String str4) {
        OmegaCommonParamHelper.setLv1Location(str);
        OmegaCommonParamHelper.setLv1RecId(str2);
        OmegaCommonParamHelper.setLv1Body(str3);
        OmegaCommonParamHelper.setLv1Filter(str4);
    }

    public void headerFilterSw(final String str, final String str2, String str3) {
        m33819a(new OnceActionUtil.OnceAction(str3) {
            public void run() {
                ShopCateLandingOmegaHelper.this.m33817a(EventConst.Home.HOME_FILTER_ITEM_REALEXPOSURE_SW).addEventParam(ParamConst.PARAM_FILTER_INFO, str2).addEventParam("resource_id", str).addEventParam("from", 2).build().track();
            }
        });
    }

    public void categoryNotifySw(JsonElement jsonElement) {
        CategoryNotifyEntity categoryNotifyEntity = (CategoryNotifyEntity) GsonUtil.fromJson(jsonElement, (Type) CategoryNotifyEntity.class);
        if (categoryNotifyEntity != null && categoryNotifyEntity.getTip() != null && !TextUtils.isEmpty(categoryNotifyEntity.getTip().getContent())) {
            m33817a(EventConst.Home.SAILING_C_X_PROMPT_MSG_SW).addEventParam(ParamConst.PARAM_FLAG_CONTENT, RichTextParser.parseText(categoryNotifyEntity.getTip().getContent()).toString()).addEventParam("page", Const.HomeBusinessPageSource.SHOP_SPECIAL_PAGE).build().track();
        }
    }

    public void onSearchCk() {
        m33817a(EventConst.ShopCateLanding.SAILING_C_X_HOMEPAGE_SECOND_SEARCH_CK).build().track();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public OmegaTracker.Builder m33817a(String str) {
        WeakReference<ScopeContext> weakReference = this.f45513c;
        if (weakReference != null) {
            return OmegaTracker.Builder.create(str, (ScopeContext) weakReference.get());
        }
        return OmegaTracker.Builder.create(str);
    }

    /* renamed from: a */
    private void m33819a(OnceActionUtil.OnceAction... onceActionArr) {
        OnceActionUtil.ActionPool actionPool = this.f45514d;
        if (actionPool != null) {
            actionPool.doAction(onceActionArr);
        }
    }
}
