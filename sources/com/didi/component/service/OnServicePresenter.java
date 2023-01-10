package com.didi.component.service;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.core.ComponentParams;
import com.didi.globalsafetoolkit.apollo.SfApolloUtil;
import com.didi.globalsafetoolkit.business.triprecording.GlobalTripRecordingManagerNew;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.Map;

public class OnServicePresenter extends AbsOnServicePresenter {
    public static final int DIALOG_ID_FIXED_PRICE_EXCEED = 101;

    public OnServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        UIHandler.postDelayed(500, new Runnable() {
            public void run() {
                OnServicePresenter.this.m14814b();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPageStop() {
        super.onPageStop();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14814b() {
        if (SceneHelper.getInstance().isAppOnResume()) {
            Object globalAttr = OmegaSDK.getGlobalAttr("g_PageId");
            if (globalAttr instanceof String) {
                HashMap hashMap = new HashMap();
                hashMap.put("fixed", CarOrderHelper.isQuotaOrder() ? "1" : "0");
                String str = (String) globalAttr;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -734206983) {
                    if (hashCode != 3440673) {
                        if (hashCode == 3449686 && str.equals(GPageIdConstant.G_PAGE_ID_PROC)) {
                            c = 2;
                        }
                    } else if (str.equals("pick")) {
                        c = 0;
                    }
                } else if (str.equals(GPageIdConstant.G_PAGE_ID_ARRIVAL)) {
                    c = 1;
                }
                if (c == 0) {
                    GlobalOmegaUtils.trackEvent("pas_waitfordriver_sw", (Map<String, Object>) hashMap);
                } else if (c == 1) {
                    GlobalOmegaUtils.trackEvent("gp_onservice_service_driver_arrive");
                } else if (c == 2) {
                    CarOrder order = CarOrderHelper.getOrder();
                    if (order != null && !TextUtils.isEmpty(order.oid)) {
                        hashMap.put("g_OrderId", order.oid);
                    }
                    GlobalOmegaUtils.trackEvent("pas_tripservice_sw", (Map<String, Object>) hashMap);
                }
            }
            SceneHelper.getInstance().setAppOnResume(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m14815c();
        if (this.mContext instanceof Activity) {
            if (SfApolloUtil.isNewSafe()) {
                GlobalTripRecordingManagerNew.Companion.getInstance().recoveryRecord((Activity) this.mContext);
            } else {
                TripRecordingManager.Companion.getInstance().recoveryRecord((Activity) this.mContext);
            }
        }
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            checkDashCamAgreement(order);
        }
    }

    /* renamed from: c */
    private void m14815c() {
        HashMap hashMap = new HashMap();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            hashMap.put("oid", order.getOid());
            hashMap.put("status", Integer.valueOf(order.getStatus()));
            hashMap.put(ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(order.getSubStatus()));
            hashMap.put("product_id", Integer.valueOf(order.getProductId()));
        }
        GlobalOmegaUtils.trackEvent("tech_pax_order_onservice", (Map<String, Object>) hashMap);
    }
}
