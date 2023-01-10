package com.didi.component.homedestination.newversion.p104b;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.model.HomeCardModel;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.SendOrderUtils;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.homedestination.model.HomeCouponAssistantModel;
import com.didi.component.homedestination.net.HomeCardListWrapperRequest;
import com.didi.component.homedestination.net.HomeCouponRequest;
import com.didi.component.homedestination.net.HomeGetRecRequest;
import com.didi.component.homedestination.net.HomeOrderBanRequest;
import com.didi.component.homedestination.newversion.AbsNewUiPresenter;
import com.didi.component.homedestination.newversion.HomeDestinationNewRecAdapter;
import com.didi.component.homedestination.newversion.p104b.IHomeDestinationPlantBNewView;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import com.didiglobal.p205sa.biz.tracker.AddressMonitorTrack;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.component.homedestination.newversion.b.HomeDestinationNewPlanBPresenter */
public class HomeDestinationNewPlanBPresenter extends AbsNewUiPresenter<IHomeDestinationPlantBNewView> implements HomeDestinationNewRecAdapter.OnItemClickListener, IHomeDestinationPlantBNewView.IClickCallBack {

    /* renamed from: a */
    private BusinessContext f15954a;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13247b() {
        HashMap hashMap = new HashMap();
        hashMap.put("message", "");
        GlobalOmegaUtils.trackEvent("ibt_gp_home_destinationbox_view_sw", (Map<String, Object>) hashMap);
    }

    public HomeDestinationNewPlanBPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f15954a = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.isFirstAdd = true;
        ((IHomeDestinationPlantBNewView) this.mView).setVisibility(0, new Runnable() {
            public void run() {
                HomeDestinationNewPlanBPresenter.this.m13247b();
                HomeDestinationNewPlanBPresenter.this.m13251c();
            }
        });
        ((IHomeDestinationPlantBNewView) this.mView).setGuessItemClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        if (this.isInHome && !this.isFirstAdd) {
            m13251c();
        }
        this.isFirstAdd = false;
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.isInHome = false;
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        this.isInHome = true;
        ((IHomeDestinationPlantBNewView) this.mView).setVisibility(0);
        m13251c();
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        this.isInHome = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m13251c() {
        HomeCardListWrapperRequest homeCardListWrapperRequest = new HomeCardListWrapperRequest(this.mContext);
        if (!showPosition()) {
            showFetchCouponOrGuess(homeCardListWrapperRequest, this.f15954a);
        } else {
            new HomeOrderBanRequest(this.mContext).getOrderBanRequest((Map) null, new ResponseListener<OrderBanCardInfo>() {
                public void onFinish(OrderBanCardInfo orderBanCardInfo) {
                    if (HomeDestinationNewPlanBPresenter.this.showOrderBanCardInfoIfNeed(orderBanCardInfo)) {
                        HomeDestinationNewPlanBPresenter.this.doPublish(BaseEventKeys.Home.ORDER_BAN_CARD_INFO, orderBanCardInfo);
                        HomeDestinationNewPlanBPresenter.this.doPublish(BaseEventKeys.Home.HIDE_HOME_DESTINATION);
                        return;
                    }
                    HomeDestinationNewPlanBPresenter.this.doPublish(BaseEventKeys.Home.ORDER_BAN_CARD_INFO, (Object) null);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void showFetchCouponOrGuess(HomeGetRecRequest homeGetRecRequest, BusinessContext businessContext) {
        if (!this.mIsRequestingRecAndCoupon) {
            super.showFetchCouponOrGuess(homeGetRecRequest, businessContext);
            m13243a(businessContext);
        }
    }

    /* renamed from: a */
    private void m13243a(BusinessContext businessContext) {
        HomeCouponRequest homeCouponRequest = new HomeCouponRequest(this.mContext);
        HashMap hashMap = new HashMap();
        hashMap.put("product_id", Integer.valueOf(BusinessUtils.getCurrentBID(businessContext)));
        homeCouponRequest.getHomeCouponAssistant(this.mContext, hashMap, new ResponseListener<HomeCouponAssistantModel>() {
            public void onSuccess(final HomeCouponAssistantModel homeCouponAssistantModel) {
                if (homeCouponAssistantModel == null || homeCouponAssistantModel.ggkData == null || homeCouponAssistantModel.ggkData.getData() == null || TextUtils.isEmpty(homeCouponAssistantModel.ggkData.getCdn()) || TextUtils.isEmpty(homeCouponAssistantModel.ggkData.getTemplate())) {
                    ((IHomeDestinationPlantBNewView) HomeDestinationNewPlanBPresenter.this.mView).hideCouponAssistant();
                } else {
                    homeCouponAssistantModel.ggkData.setCDNCallback(new GGKData.CDNCallback() {
                        public void onCDNCached() {
                            HomeDestinationNewPlanBPresenter.this.m13242a(homeCouponAssistantModel.ggkData);
                        }
                    });
                    homeCouponAssistantModel.ggkData.setEventListener(new EventListener() {
                        public boolean handleEvent(String str, String str2, Map<String, Object> map) {
                            if (map != null) {
                                for (String next : map.keySet()) {
                                }
                            }
                            if (!TextUtils.isEmpty(str2) && !"null".equals(str2)) {
                                DRouter.build(str2).start(HomeDestinationNewPlanBPresenter.this.getHost().getActivity());
                                if (homeCouponAssistantModel.ggkData != null) {
                                    HomeDestinationNewPlanBPresenter.this.m13244a(homeCouponAssistantModel.ggkData.getExt(), false);
                                }
                            }
                            return false;
                        }
                    });
                    HomeDestinationNewPlanBPresenter.this.m13242a(homeCouponAssistantModel.ggkData);
                }
                boolean unused = HomeDestinationNewPlanBPresenter.this.mIsRequestingRecAndCoupon = false;
            }

            public void onError(HomeCouponAssistantModel homeCouponAssistantModel) {
                boolean unused = HomeDestinationNewPlanBPresenter.this.mIsRequestingRecAndCoupon = false;
                ((IHomeDestinationPlantBNewView) HomeDestinationNewPlanBPresenter.this.mView).hideCouponAssistant();
            }

            public void onFail(HomeCouponAssistantModel homeCouponAssistantModel) {
                boolean unused = HomeDestinationNewPlanBPresenter.this.mIsRequestingRecAndCoupon = false;
                ((IHomeDestinationPlantBNewView) HomeDestinationNewPlanBPresenter.this.mView).hideCouponAssistant();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13242a(GGKData gGKData) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(this.mContext, gGKData);
        if (createTemplateView != null && createTemplateView.getView() != null) {
            ((IHomeDestinationPlantBNewView) this.mView).showCouponAssistant(createTemplateView.getView());
            if (gGKData != null) {
                m13244a(gGKData.getExt(), true);
            }
        }
    }

    public void clickWhereToGo() {
        clearOpenRideCarOrder();
        doPublish(BaseEventKeys.Service.EVENT_DESTINATION_CLICKED);
        m13254d();
    }

    /* renamed from: d */
    private void m13254d() {
        HashMap hashMap = new HashMap();
        hashMap.put("isRecommended", ((IHomeDestinationPlantBNewView) this.mView).isRecListShown() ? "1" : "0");
        hashMap.put("city_id", NationComponentDataUtil.getLocCityId());
        hashMap.put("country_code", NationComponentDataUtil.getLocCountry());
        hashMap.put("message", "");
        GlobalOmegaUtils.trackEvent("pas_destinationbox_ck", (Map<String, Object>) hashMap);
        prepareForward((SugResult) null);
        SearchIdUploadManager.getInstance().setEstimateAction("where_to_go");
    }

    public void onItemClick(int i, HomeCardModel homeCardModel) {
        boolean z;
        HomeCardModel homeCardModel2;
        clearOpenRideCarOrder();
        boolean z2 = true;
        FormStore.getInstance().setIsClickGuessDestination(true);
        SugResult sugResult = new SugResult();
        sugResult.isStartNeedNearRoad = true;
        Address endAddress = SendOrderUtils.getEndAddress(homeCardModel);
        Address startAddress = getStartAddress(this.mContext);
        sugResult.start = startAddress;
        sugResult.end = endAddress;
        prepareForward(sugResult);
        HashMap hashMap = new HashMap();
        String str = "null";
        if (startAddress == null || startAddress.cityId == 0 || startAddress.cityId == -1 || startAddress.latitude == 0.0d || startAddress.longitude == 0.0d) {
            this.mLogger.info("destination_tv startAddress cityid or latlng error ", new Object[0]);
            hashMap.put("start_search_id", str);
            z = true;
        } else {
            z = false;
        }
        if (endAddress == null || endAddress.cityId == 0 || endAddress.cityId == -1 || endAddress.latitude == 0.0d || endAddress.longitude == 0.0d) {
            this.mLogger.info("destination_tv endAddress cityid or latlng error ", new Object[0]);
            if (endAddress != null) {
                str = endAddress.searchId;
            }
            hashMap.put("end_search_id", str);
        } else {
            z2 = z;
        }
        if (z2) {
            AddressMonitorTrack.adddressMonitorTrack(AddressMonitorTrack.mSceneRideDestination, hashMap);
        }
        if (this.mResultList != null && this.mResultList.size() > i && (homeCardModel2 = (HomeCardModel) this.mResultList.get(i)) != null && homeCardModel2.base_info != null) {
            RpcPoiBaseInfo rpcPoiBaseInfo = homeCardModel2.base_info;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("name", rpcPoiBaseInfo.displayname);
            hashMap2.put("address", rpcPoiBaseInfo.address);
            hashMap2.put("uid", rpcPoiBaseInfo.poi_id);
            hashMap2.put("guessDesid", this.mSearchId);
            hashMap2.put("rank", Integer.valueOf(i));
            hashMap2.put(DepartureConstants.SRCTAG, rpcPoiBaseInfo.srctag);
            if (homeCardModel2.extend_info != null) {
                hashMap2.put("poi_ui_tag", homeCardModel2.extend_info.poi_ui_tag);
            }
            hashMap2.put("searchname", this.mSearchName);
            hashMap2.put(ParamConst.PARAM_ADDRESS_LAT, Double.valueOf(rpcPoiBaseInfo.lat));
            hashMap2.put(ParamConst.PARAM_ADDRESS_LNG, Double.valueOf(rpcPoiBaseInfo.lng));
            hashMap2.put("is_fastCall", false);
            GlobalOmegaUtils.trackEvent("requireDlg_guessDestination_ck", (Map<String, Object>) hashMap2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13244a(Map<String, Object> map, boolean z) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("pub_subbiz", "payment");
        if (z) {
            GlobalOmegaUtils.trackEvent("ibt_gp_couponhome_sw", (Map<String, Object>) hashMap);
        } else {
            GlobalOmegaUtils.trackEvent("ibt_gp_couponhome_ck", (Map<String, Object>) hashMap);
        }
    }
}
