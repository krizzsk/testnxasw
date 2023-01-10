package com.didi.map.global.component.departure.manager;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.model.SPoi;
import com.didi.map.global.component.departure.view.DepartureCardViewController;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.sdk.push.ServerParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;
import java.util.HashMap;

public class DepartureOmegaManager {

    /* renamed from: a */
    private FenceInfo f27430a;

    /* renamed from: b */
    private String f27431b;

    /* renamed from: c */
    private String f27432c;

    /* renamed from: d */
    private String f27433d;

    /* renamed from: e */
    private float f27434e = 0.0f;

    /* renamed from: f */
    private RpcPoi f27435f;

    public interface OmegaChangePickupPointType {
        public static final int MAP_DRAGG = 1;
        public static final int REC_MARKER_CLICK = 2;
        public static final int TERMINAL_LIST_ITEM_SELECTED = 3;
    }

    public void setDefaultRecTerminalPickupPoi(RpcPoi rpcPoi) {
        this.f27431b = (rpcPoi == null || rpcPoi.base_info == null) ? "" : rpcPoi.base_info.poi_id;
        this.f27435f = rpcPoi;
    }

    public void setPickupPoiDescription(String str) {
        this.f27433d = str;
    }

    public void setSelectedTerminalSPoi(SPoi sPoi) {
        if (sPoi != null && sPoi.area != null) {
            this.f27432c = sPoi.area.f27471id;
        }
    }

    public void setLocationAccuracy(float f) {
        this.f27434e = f;
    }

    public void reportOmegaOnShowTerminalWelcome(DepartureCardViewController departureCardViewController, FenceInfo fenceInfo, boolean z) {
        this.f27430a = fenceInfo;
        if (departureCardViewController != null && fenceInfo != null && departureCardViewController.isWelcomeViewValid()) {
            HashMap hashMap = new HashMap();
            hashMap.put("pudozoneid", fenceInfo.fenceId);
            hashMap.put("type", Integer.valueOf(z ? 1 : 2));
            GlobalOmegaTracker.trackEvent("ibt_gp_pudozone_card_sw", hashMap);
        }
    }

    public void reportOmegaOnWelcomeButtonClick() {
        if (this.f27430a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("pudozoneid", this.f27430a.fenceId);
            GlobalOmegaTracker.trackEvent("ibt_gp_pudozone_setpickup_ck", hashMap);
        }
    }

    public void reportOmegaOnOtherAreaClick() {
        if (this.f27430a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("pudozoneid", this.f27430a.fenceId);
            GlobalOmegaTracker.trackEvent("ibt_gp_pudozone_other_ck", hashMap);
            return;
        }
        m21751a(" reportOmegaOnOtherAreaClick fence is null.");
    }

    public void reportOmegaOnTerminalConfirmButtonClick(RpcPoi rpcPoi) {
        if (rpcPoi == null || this.f27430a == null) {
            m21751a(" reportOmegaOnOtherAreaClick fence is null or rpcPoi is null,rpcPoi=" + rpcPoi);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pudoptid", this.f27431b);
        hashMap.put("pudofinalptid", rpcPoi.base_info != null ? rpcPoi.base_info.poi_id : "");
        hashMap.put("pudozoneid", this.f27430a.fenceId);
        hashMap.put("pudosubdivisionid", this.f27432c);
        hashMap.put(ServerParam.PARAM_ACCURACY, Float.valueOf(this.f27434e));
        hashMap.put("message", this.f27433d);
        GlobalOmegaTracker.trackEvent("ibt_gp_pudoptpanel_setpickup_ck", hashMap);
    }

    public void reportOmegaOnTerminalRecPickupChange(RpcPoi rpcPoi, int i) {
        if (rpcPoi != null && !m21752a(rpcPoi, this.f27435f)) {
            RpcPoi rpcPoi2 = this.f27435f;
            String str = "";
            String str2 = (rpcPoi2 == null || rpcPoi2.base_info == null) ? str : this.f27435f.base_info.poi_id;
            this.f27435f = rpcPoi;
            if (rpcPoi != null && this.f27430a != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("pudozoneid", this.f27430a.fenceId);
                hashMap.put("pudosubdivisionid", this.f27432c);
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("b_pudoptid", str2);
                }
                if (rpcPoi.base_info != null) {
                    str = rpcPoi.base_info.poi_id;
                }
                hashMap.put("pudoptid", str);
                hashMap.put("type", Integer.valueOf(i));
                GlobalOmegaTracker.trackEvent("ibt_gp_changepudopt_ck", hashMap);
            }
        }
    }

    public void reportOmegaStationAreaBroadFromOther() {
        if (this.f27430a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("pudozoneid", this.f27430a.fenceId);
            GlobalOmegaTracker.trackEvent("ibt_gp_pudozone_other_ck", hashMap);
            return;
        }
        m21751a("reportOmegaStationAreaBroadFromOther fenceId is null.");
    }

    public void reportOmegaChangeStartCircle(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        GlobalOmegaTracker.trackEvent("ibt_gp_waitresponse_changeorigin_mapdrag_ck", hashMap);
    }

    /* renamed from: a */
    private boolean m21752a(RpcPoi rpcPoi, RpcPoi rpcPoi2) {
        if (rpcPoi == null || rpcPoi.base_info == null || rpcPoi2 == null || rpcPoi2.base_info == null) {
            return false;
        }
        String str = rpcPoi.base_info.poi_id;
        String str2 = rpcPoi2.base_info.poi_id;
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2);
    }

    public void clearTerminalCache() {
        this.f27430a = null;
        this.f27431b = null;
        this.f27432c = null;
        this.f27433d = null;
        this.f27435f = null;
    }

    /* renamed from: a */
    private void m21751a(String str) {
        DLog.m10773d("DepartureOmegaManager", str, new Object[0]);
    }
}
