package com.didi.map.sdk.sharetrack.external.round;

import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.sharetrack.common.ShareTrackApolloHelper;
import com.didi.map.sdk.sharetrack.common.ShareTrackUtils;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b$\b&\u0018\u0000 G2\u00020\u0001:\u0001GB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H&J\b\u0010(\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020\u0004H&J\n\u0010*\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010+\u001a\u00020\u0004H&J\b\u0010,\u001a\u00020\u0004H&J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0011H\u0004J\b\u0010/\u001a\u00020$H\u0002J\b\u00100\u001a\u00020$H\u0002J\b\u00101\u001a\u00020$H\u0016J\b\u00102\u001a\u00020$H\u0016J\u0012\u00103\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u00105\u001a\u00020$2\b\u00106\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u00107\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u00010\"H\u0016J\b\u00109\u001a\u00020$H\u0002J\b\u0010:\u001a\u00020$H\u0016J\b\u0010;\u001a\u00020$H\u0016J\b\u0010<\u001a\u00020$H\u0002J\u0010\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u0004H\u0016J\u0010\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020\u0004H\u0016J\u0012\u0010A\u001a\u00020$2\b\u0010B\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020\u0004H\u0016J\u0012\u0010E\u001a\u00020$2\b\u0010F\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u000e\u0010\u001b\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, mo148868d2 = {"Lcom/didi/map/sdk/sharetrack/external/round/BaseRoundStrategy;", "Lcom/didi/map/sdk/sharetrack/external/round/IBaseStrategy;", "()V", "mCurETA", "", "mCurLocation", "Lcom/didi/common/map/model/GpsLocation;", "mCurRouteId", "", "mEDA", "getMEDA", "()I", "setMEDA", "(I)V", "mEndPoint", "Lcom/didi/common/map/model/LatLng;", "mHasApproaching", "", "mHasArrived", "getMHasArrived", "()Z", "setMHasArrived", "(Z)V", "mHasDriveAway", "mIsNeverArrived", "getMIsNeverArrived", "setMIsNeverArrived", "mLineVisible", "mOrderInfo", "Lcom/didi/map/sdk/sharetrack/entity/OrderInfo;", "mParkingStatus", "getMParkingStatus", "setMParkingStatus", "mStatusChangeListener", "Lcom/didi/map/sdk/sharetrack/external/round/IRoundStatusChangeListener;", "changeLineStatus", "", "visible", "checkApproachStatus", "checkArriveStatus", "checkDriveAwayStatus", "getArriveThreshold", "getCurTimeString", "getDriveAwayThreshold", "getRoundType", "handleArrive", "lineVisible", "handleDriveAway", "handleOffRoute", "initComplete", "offRoute", "setEndPoint", "latLng", "setOrderInfo", "orderInfo", "setStatusChangeListener", "listener", "trackApproaching", "trackWhenRouteInvisibleDirectly", "tryTrackWhenRouteInvisible", "tryTrackWhenRouteVisible", "updateEDA", "eda", "updateETA", "eta", "updateMatchLocation", "loc", "updateParkingStatus", "parkingStatus", "updateRouteId", "routeId", "Companion", "CommonShareTrack_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: BaseRoundStrategy.kt */
public abstract class BaseRoundStrategy implements IBaseStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "RoundRoad";

    /* renamed from: a */
    private IRoundStatusChangeListener f31133a;

    /* renamed from: b */
    private LatLng f31134b;

    /* renamed from: c */
    private int f31135c;

    /* renamed from: d */
    private int f31136d;

    /* renamed from: e */
    private GpsLocation f31137e;

    /* renamed from: f */
    private String f31138f = "0";

    /* renamed from: g */
    private boolean f31139g = true;

    /* renamed from: h */
    private boolean f31140h;

    /* renamed from: i */
    private int f31141i;

    /* renamed from: j */
    private boolean f31142j;

    /* renamed from: k */
    private boolean f31143k = true;

    /* renamed from: l */
    private boolean f31144l;

    /* renamed from: m */
    private OrderInfo f31145m;

    public abstract void checkArriveStatus();

    public abstract int getArriveThreshold();

    public abstract int getDriveAwayThreshold();

    public abstract int getRoundType();

    public void initComplete() {
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/map/sdk/sharetrack/external/round/BaseRoundStrategy$Companion;", "", "()V", "TAG", "", "CommonShareTrack_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: BaseRoundStrategy.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final int getMEDA() {
        return this.f31135c;
    }

    /* access modifiers changed from: protected */
    public final void setMEDA(int i) {
        this.f31135c = i;
    }

    /* access modifiers changed from: protected */
    public final boolean getMIsNeverArrived() {
        return this.f31139g;
    }

    /* access modifiers changed from: protected */
    public final void setMIsNeverArrived(boolean z) {
        this.f31139g = z;
    }

    /* access modifiers changed from: protected */
    public final boolean getMHasArrived() {
        return this.f31140h;
    }

    /* access modifiers changed from: protected */
    public final void setMHasArrived(boolean z) {
        this.f31140h = z;
    }

    /* access modifiers changed from: protected */
    public final int getMParkingStatus() {
        return this.f31141i;
    }

    /* access modifiers changed from: protected */
    public final void setMParkingStatus(int i) {
        this.f31141i = i;
    }

    public void setStatusChangeListener(IRoundStatusChangeListener iRoundStatusChangeListener) {
        this.f31133a = iRoundStatusChangeListener;
    }

    public void setEndPoint(LatLng latLng) {
        this.f31134b = latLng;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.f31145m = orderInfo;
    }

    public void updateEDA(int i) {
        this.f31135c = i;
    }

    public void updateETA(int i) {
        this.f31136d = i;
    }

    public void updateRouteId(String str) {
        this.f31138f = str;
    }

    public void updateMatchLocation(GpsLocation gpsLocation) {
        this.f31137e = gpsLocation;
        checkArriveStatus();
        m23829c();
        m23830d();
    }

    public void updateParkingStatus(int i) {
        this.f31141i = i;
        DLog.m10773d(TAG, "updateParkingStatus: " + i, new Object[0]);
    }

    public void offRoute() {
        m23832f();
    }

    public void tryTrackWhenRouteInvisible() {
        if (this.f31140h && !this.f31142j) {
            trackWhenRouteInvisibleDirectly();
        }
    }

    public void trackWhenRouteInvisibleDirectly() {
        if (ShareTrackApolloHelper.INSTANCE.getShouldTrackEvent() == 1) {
            Map hashMap = new HashMap();
            hashMap.put("time", m23833g());
            hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, this.f31138f);
            hashMap.put("route_eta", Integer.valueOf(this.f31136d));
            hashMap.put("category", Integer.valueOf(getRoundType()));
            ShareTrackUtils.INSTANCE.traceEvent("map_yawETA_sw", hashMap, TAG);
        }
    }

    /* renamed from: a */
    private final void m23826a() {
        if (ShareTrackApolloHelper.INSTANCE.getShouldTrackEvent() == 1) {
            Map hashMap = new HashMap();
            hashMap.put("time", m23833g());
            hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, this.f31138f);
            hashMap.put("route_eta", Integer.valueOf(this.f31136d));
            hashMap.put("category", Integer.valueOf(getRoundType()));
            ShareTrackUtils.INSTANCE.traceEvent("map_yaw_accept_route_request_sw", hashMap, TAG);
        }
    }

    /* renamed from: b */
    private final void m23828b() {
        String str;
        if (ShareTrackApolloHelper.INSTANCE.getShouldTrackEvent() == 1) {
            Map hashMap = new HashMap();
            hashMap.put("time", m23833g());
            PlatInfo instance = PlatInfo.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "PlatInfo.getInstance()");
            hashMap.put(ParamKeys.PARAM_RES.PARAM_RES_DRIVERID, Long.valueOf(instance.getDriverId()));
            OrderInfo orderInfo = this.f31145m;
            if (orderInfo != null) {
                if (orderInfo == null) {
                    Intrinsics.throwNpe();
                }
                str = orderInfo.getOrderId();
            } else {
                str = "";
            }
            hashMap.put("orderid", str);
            ShareTrackUtils.INSTANCE.traceEvent("map_arriving_drv_sw", hashMap, TAG);
        }
    }

    /* renamed from: c */
    private final void m23829c() {
        if (ShareTrackApolloHelper.INSTANCE.isV3Enable() != 0 && !this.f31140h && !this.f31144l && !ShareTrackUtils.INSTANCE.isNoRoadNet()) {
            int eDA_arriving_TTS = ShareTrackApolloHelper.INSTANCE.getEDA_arriving_TTS();
            int i = this.f31135c;
            if (1 <= i && eDA_arriving_TTS > i) {
                DLog.m10773d(TAG, "HANDLE APPROACHING", new Object[0]);
                if (ShareTrackUtils.INSTANCE.shouldShowApproachTTSAndDisable()) {
                    m23828b();
                    IRoundStatusChangeListener iRoundStatusChangeListener = this.f31133a;
                    if (iRoundStatusChangeListener != null) {
                        iRoundStatusChangeListener.onApproaching(this.f31135c);
                    }
                }
                this.f31144l = true;
            }
        }
    }

    /* renamed from: d */
    private final void m23830d() {
        GpsLocation gpsLocation;
        if (this.f31140h && !this.f31142j && (gpsLocation = this.f31137e) != null) {
            int computeDistanceBetween = (int) DDSphericalUtil.computeDistanceBetween(new LatLng(gpsLocation.latitude, gpsLocation.longitude), this.f31134b);
            DLog.m10773d(TAG, "calculate straight dis when arrive: " + computeDistanceBetween, new Object[0]);
            if (computeDistanceBetween > getDriveAwayThreshold()) {
                m23831e();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void handleArrive(boolean z) {
        if (!this.f31140h) {
            DLog.m10773d(TAG, "HANDLE ARRIVE: " + z, new Object[0]);
            this.f31140h = true;
            this.f31142j = false;
            if (!z) {
                m23827a(false);
            }
            IRoundStatusChangeListener iRoundStatusChangeListener = this.f31133a;
            if (iRoundStatusChangeListener != null) {
                iRoundStatusChangeListener.onArrived(z);
            }
        }
    }

    /* renamed from: e */
    private final void m23831e() {
        if (!this.f31142j) {
            DLog.m10773d(TAG, "HANDLE DRIVE AWAY", new Object[0]);
            this.f31140h = false;
            this.f31142j = true;
            m23827a(true);
            m23826a();
            IRoundStatusChangeListener iRoundStatusChangeListener = this.f31133a;
            if (iRoundStatusChangeListener != null) {
                iRoundStatusChangeListener.onDriveAway();
            }
        }
    }

    /* renamed from: f */
    private final void m23832f() {
        DLog.m10773d(TAG, "round road off route", new Object[0]);
        if (this.f31140h && !this.f31142j) {
            m23827a(false);
            IRoundStatusChangeListener iRoundStatusChangeListener = this.f31133a;
            if (iRoundStatusChangeListener != null) {
                iRoundStatusChangeListener.onPassPointYaw();
            }
        }
    }

    /* renamed from: a */
    private final void m23827a(boolean z) {
        DLog.m10773d(TAG, "line visible change: origin:" + this.f31143k + ", now:" + z, new Object[0]);
        if (this.f31143k != z) {
            this.f31143k = z;
            IRoundStatusChangeListener iRoundStatusChangeListener = this.f31133a;
            if (iRoundStatusChangeListener != null) {
                iRoundStatusChangeListener.onLineVisibleChange(z);
            }
        }
    }

    /* renamed from: g */
    private final String m23833g() {
        return new SimpleDateFormat("yyyy/MM/dd HH-mm-ss", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }
}
