package com.didi.component.comp_homecard.destination;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.model.HomeCardModel;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.SendOrderUtils;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.p205sa.biz.tracker.AddressMonitorTrack;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import java.util.HashMap;
import java.util.Map;

public class HomeDestinationCardPresenter extends AbsHomeDestinationCardPresenter {

    /* renamed from: a */
    private BusinessContext f14081a;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11680b() {
        HashMap hashMap = new HashMap();
        hashMap.put("message", "");
        GlobalOmegaUtils.trackEvent("ibt_gp_home_destinationbox_view_sw", (Map<String, Object>) hashMap);
    }

    public HomeDestinationCardPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f14081a = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        ((IHomeDestinationCardView) this.mView).setVisibility(0, new Runnable() {
            public void run() {
                HomeDestinationCardPresenter.this.m11680b();
            }
        });
        ((IHomeDestinationCardView) this.mView).setGuessItemClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        ((IHomeDestinationCardView) this.mView).setVisibility(0, (Runnable) null);
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
    }

    public void clickWhereToGo() {
        clearOpenRideCarOrder();
        doPublish(BaseEventKeys.Service.EVENT_DESTINATION_CLICKED);
        m11681c();
    }

    /* renamed from: c */
    private void m11681c() {
        HashMap hashMap = new HashMap();
        hashMap.put("isRecommended", ((IHomeDestinationCardView) this.mView).isRecListShown() ? "1" : "0");
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
}
