package com.didi.map.global.flow.scene.order.bluetooth_meet;

import com.didi.common.map.util.DLog;
import com.didi.map.global.flow.scene.order.bluetooth_meet.model.BTMState;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;

@Metadata(mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eJ\u001a\u0010#\u001a\u00020\u001e2\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u001eJ\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007J\u0016\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u001cJ\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0019J\u0006\u0010/\u001a\u00020\u001eJ\b\u00100\u001a\u00020\u001eH\u0002J\b\u00101\u001a\u00020\u001eH\u0002J\u0006\u00102\u001a\u00020\u001eJ\b\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020\u001eH\u0002J\u001a\u00105\u001a\u00020\u001e2\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u0007J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0007R\u000e\u0010\u0005\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/BTMOmegaHelper;", "", "orderId", "", "(Ljava/lang/String;)V", "TAG", "connect_error", "", "endGuideTimeStamp", "", "endPairTimeStamp", "firstFailWrapper", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/FailureStateWrapper;", "hasPairingFailed", "getHasPairingFailed", "()Z", "setHasPairingFailed", "(Z)V", "getOrderId", "()Ljava/lang/String;", "secondFailWrapper", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/SecondFailureStateWrapper;", "startGuideTimeStamp", "startPairTimeStamp", "uiState", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMState;", "userInitiaClickClose", "wrongDirectionCount", "", "onClickBluetoothIcon", "", "onCloseWay", "onCloseWhen", "onDestroy", "onFailed", "onPairedFailureDialogClick", "clickContinue", "quit", "onUserInitiaClickClose", "setBluetoothState", "hasPermission", "enable", "setPermissionGrantedState", "granted", "channel", "setUiState", "state", "startPair", "trackFindingProcess", "trackFirstBadcase1ck", "trackMapBtnaviLinkbroken_bt", "trackMapBtnaviPaxmatchBt", "trackSecondBadcase2bt", "trackSecondBadcase2ck", "tryAgain", "fromTryAgainBtn", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BTMOmegaHelper.kt */
public final class BTMOmegaHelper {

    /* renamed from: a */
    private final String f28951a;

    /* renamed from: b */
    private final String f28952b = "btm_omega";

    /* renamed from: c */
    private long f28953c;

    /* renamed from: d */
    private long f28954d;

    /* renamed from: e */
    private boolean f28955e;

    /* renamed from: f */
    private BTMState f28956f;

    /* renamed from: g */
    private long f28957g;

    /* renamed from: h */
    private long f28958h;

    /* renamed from: i */
    private int f28959i;

    /* renamed from: j */
    private boolean f28960j;

    /* renamed from: k */
    private final FailureStateWrapper f28961k = new FailureStateWrapper();

    /* renamed from: l */
    private final SecondFailureStateWrapper f28962l = new SecondFailureStateWrapper();

    /* renamed from: m */
    private boolean f28963m;

    public BTMOmegaHelper(String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        this.f28951a = str;
    }

    public final String getOrderId() {
        return this.f28951a;
    }

    public final boolean getHasPairingFailed() {
        return this.f28955e;
    }

    public final void setHasPairingFailed(boolean z) {
        this.f28955e = z;
    }

    public final void startPair() {
        if (!this.f28955e) {
            this.f28953c = System.currentTimeMillis();
            this.f28961k.setStartPairTimeStamp(System.currentTimeMillis());
        }
    }

    public final void onFailed() {
        BTMState bTMState = this.f28956f;
        if (bTMState != null) {
            if (bTMState.getValue() < BTMState.PAIRED.getValue() && !this.f28955e) {
                this.f28961k.setEndPairTimeStamp(System.currentTimeMillis());
                this.f28955e = true;
            }
            if (bTMState.getValue() >= BTMState.PAIRED.getValue()) {
                this.f28963m = true;
            }
        }
    }

    public final void tryAgain(boolean z) {
        if (z) {
            this.f28961k.setClickTryAgain(z);
            m22561c();
            this.f28962l.setStartPairTimeStamp(System.currentTimeMillis());
        }
    }

    /* renamed from: a */
    private final void m22559a() {
        int i;
        if (this.f28956f == BTMState.VERY_NEAR || this.f28956f == BTMState.ON_BOARD) {
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("order_id", this.f28951a);
            if (!this.f28960j || !(this.f28956f == BTMState.VERY_NEAR || this.f28956f == BTMState.ON_BOARD)) {
                i = (this.f28960j || this.f28956f != BTMState.ON_BOARD) ? -1 : 1;
            } else {
                i = 0;
            }
            linkedHashMap.put("close_way", Integer.valueOf(i));
            GlobalOmegaTracker.trackEvent("map_btnavi_closeway_ck", linkedHashMap);
        }
    }

    /* renamed from: b */
    private final void m22560b() {
        int i;
        BTMState bTMState = this.f28956f;
        if (bTMState != null) {
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("order_id", this.f28951a);
            if (bTMState == BTMState.PAIRING) {
                i = 0;
            } else if (bTMState == BTMState.PAIRED) {
                i = 1;
            } else if (bTMState == BTMState.INIT_DIRECTION || bTMState == BTMState.RIGHT_DIRECTION || bTMState == BTMState.WRONG_DIRECTION || bTMState == BTMState.WRONG_DIRECTION_TOTALLY || bTMState == BTMState.VERY_NEAR) {
                i = 2;
            } else if (bTMState == BTMState.PAIRING_FAILURE && !this.f28961k.getClickTryAgain()) {
                i = 3;
            } else if (bTMState == BTMState.PAIRING && this.f28961k.getClickTryAgain()) {
                i = 4;
            } else if (bTMState != BTMState.PAIRING_FAILURE || !this.f28961k.getClickTryAgain()) {
                i = bTMState == BTMState.VERY_NEAR ? 6 : (bTMState == BTMState.NO_PERMISSION || bTMState == BTMState.BLUETOOTH_TURNOFF) ? 7 : -1;
            } else {
                i = 5;
            }
            linkedHashMap.put("close_when", Integer.valueOf(i));
            GlobalOmegaTracker.trackEvent("map_btnavi_closewhen_ck", linkedHashMap);
        }
    }

    public final void onClickBluetoothIcon() {
        String str;
        if (this.f28956f == BTMState.PAIRING) {
            str = "map_btnavi_paxmatch1_ck";
        } else if (this.f28956f == BTMState.NO_PERMISSION) {
            str = "map_btnavi_paxmatch2_ck";
        } else {
            str = null;
        }
        if (str != null) {
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("order_id", this.f28951a);
            GlobalOmegaTracker.trackEvent(str, linkedHashMap);
        }
    }

    public final void onUserInitiaClickClose() {
        this.f28960j = true;
    }

    /* renamed from: c */
    private final void m22561c() {
        long j;
        long j2;
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f28951a);
        if (this.f28961k.getStartPairTimeStamp() > 0) {
            if (this.f28961k.getEndPairTimeStamp() == 0) {
                j2 = System.currentTimeMillis();
                j = this.f28961k.getStartPairTimeStamp();
            } else {
                j2 = this.f28961k.getEndPairTimeStamp();
                j = this.f28961k.getStartPairTimeStamp();
            }
            linkedHashMap.put("duration", Long.valueOf(j2 - j));
        }
        GlobalOmegaTracker.trackEvent("map_btnavi_paxbadcase1_ck", linkedHashMap);
    }

    public static /* synthetic */ void onPairedFailureDialogClick$default(BTMOmegaHelper bTMOmegaHelper, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        bTMOmegaHelper.onPairedFailureDialogClick(z, z2);
    }

    public final void onPairedFailureDialogClick(boolean z, boolean z2) {
        trackSecondBadcase2ck(z, z2);
        if (z) {
            this.f28962l.setClickTryAgain(true);
        }
    }

    public static /* synthetic */ void trackSecondBadcase2ck$default(BTMOmegaHelper bTMOmegaHelper, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        bTMOmegaHelper.trackSecondBadcase2ck(z, z2);
    }

    public final void trackSecondBadcase2ck(boolean z, boolean z2) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f28951a);
        linkedHashMap.put("click_continue", Integer.valueOf(z ? 1 : 0));
        linkedHashMap.put("quit", Integer.valueOf(z2 ? 1 : 0));
        GlobalOmegaTracker.trackEvent("map_btnavi_paxbadcase2_ck", linkedHashMap);
    }

    /* renamed from: d */
    private final void m22562d() {
        Boolean secondTrySuccess = this.f28962l.getSecondTrySuccess();
        if (secondTrySuccess != null) {
            boolean booleanValue = secondTrySuccess.booleanValue();
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("order_id", this.f28951a);
            linkedHashMap.put("success", Integer.valueOf(booleanValue ? 1 : 0));
            linkedHashMap.put("duration", Long.valueOf(this.f28962l.getEndPairTimeStamp() - this.f28962l.getStartPairTimeStamp()));
            GlobalOmegaTracker.trackEvent("map_btnavi_paxbadcase2_bt", linkedHashMap);
        }
    }

    public final void trackMapBtnaviLinkbroken_bt() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f28951a);
        GlobalOmegaTracker.trackEvent("map_btnavi_linkbroken_bt", linkedHashMap);
    }

    /* renamed from: e */
    private final void m22563e() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f28951a);
        if (this.f28958h == 0) {
            this.f28958h = System.currentTimeMillis();
        }
        long j = this.f28957g;
        if (j > 0) {
            linkedHashMap.put("duration", Long.valueOf(this.f28958h - j));
        }
        linkedHashMap.put("conn_error", Integer.valueOf(this.f28963m ? 1 : 0));
        linkedHashMap.put("user_initia_quit", Integer.valueOf(this.f28960j ? 1 : 0));
        linkedHashMap.put("wrong_dir_cnt", Integer.valueOf(this.f28959i));
        GlobalOmegaTracker.trackEvent("map_btnavi_paxfind_bt", linkedHashMap);
    }

    public final void setPermissionGrantedState(boolean z, int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f28951a);
        linkedHashMap.put("request_permission", Integer.valueOf(z ? 1 : 0));
        linkedHashMap.put("channel", Integer.valueOf(i));
        GlobalOmegaTracker.trackEvent("map_btnavi_drvbt_ck", linkedHashMap);
    }

    public final void setBluetoothState(boolean z, boolean z2) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f28951a);
        linkedHashMap.put("permission", Integer.valueOf(z ? 1 : 0));
        linkedHashMap.put(JoinPoint.SYNCHRONIZATION_LOCK, Integer.valueOf(z2 ? 1 : 0));
        GlobalOmegaTracker.trackEvent("map_btnavi_paxauthority_bt", linkedHashMap);
    }

    /* renamed from: f */
    private final void m22564f() {
        int i;
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("order_id", this.f28951a);
        if (this.f28954d == 0) {
            this.f28954d = System.currentTimeMillis();
        }
        long j = this.f28953c;
        if (j > 0) {
            linkedHashMap.put("pair_duration", Long.valueOf(this.f28954d - j));
        }
        BTMState bTMState = this.f28956f;
        if (bTMState == null) {
            bTMState = BTMState.PAIRING;
        }
        if (this.f28955e || bTMState.compareTo(BTMState.PAIRED) < 0) {
            i = (!this.f28955e || bTMState.compareTo(BTMState.PAIRED) < 0) ? 2 : 1;
        } else {
            i = 0;
        }
        linkedHashMap.put("pair_status", Integer.valueOf(i));
        GlobalOmegaTracker.trackEvent("map_btnavi_paxmatch_bt", linkedHashMap);
    }

    public final void onDestroy() {
        m22564f();
        m22563e();
        m22559a();
        m22560b();
        m22562d();
    }

    public final void setUiState(BTMState bTMState) {
        Intrinsics.checkNotNullParameter(bTMState, "state");
        DLog.m10773d(this.f28952b, Intrinsics.stringPlus("to State ", bTMState), new Object[0]);
        if (bTMState == BTMState.PAIRING) {
            this.f28954d = 0;
        }
        if (bTMState == BTMState.PAIRED) {
            this.f28954d = System.currentTimeMillis();
            this.f28957g = System.currentTimeMillis();
            if (this.f28955e && !this.f28962l.getClickTryAgain()) {
                this.f28962l.setSecondTrySuccess(true);
                this.f28962l.setEndPairTimeStamp(System.currentTimeMillis());
            }
        }
        if (bTMState == BTMState.PAIRING_FAILURE) {
            this.f28954d = System.currentTimeMillis();
            if (this.f28955e && !this.f28962l.getClickTryAgain()) {
                this.f28962l.setSecondTrySuccess(false);
                this.f28962l.setEndPairTimeStamp(System.currentTimeMillis());
            }
        }
        if (bTMState == BTMState.ON_BOARD) {
            this.f28958h = System.currentTimeMillis();
        }
        if (bTMState == BTMState.WRONG_DIRECTION || bTMState == BTMState.WRONG_DIRECTION_TOTALLY) {
            this.f28959i++;
        }
        this.f28956f = bTMState;
    }
}
