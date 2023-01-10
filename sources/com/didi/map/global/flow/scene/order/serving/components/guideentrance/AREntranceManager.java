package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.hawaii.p120ar.DiARNavActivity;
import com.didi.hawaii.p120ar.utils.ARCoreCheckerAndGenerator;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.taxis99.R;
import java.util.Map;

public class AREntranceManager {

    /* renamed from: a */
    private Context f29351a;
    public Map<String, String> arParams;

    /* renamed from: b */
    private ServingParam f29352b;

    /* renamed from: c */
    private DIDILocation f29353c;

    /* renamed from: d */
    private DiARNavActivity.NotifyStatusSubscriber f29354d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f29355e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f29356f;

    /* renamed from: g */
    private LatLng f29357g;

    /* renamed from: h */
    private boolean f29358h;

    /* renamed from: i */
    private OutdoorArDialog f29359i;

    /* renamed from: j */
    private ARCoreCheckerAndGenerator.CheckCallBack f29360j = new ARCoreCheckerAndGenerator.CheckCallBack() {
        public void onCheckSuccessOrNot(boolean z, int i, String str) {
            long unused = AREntranceManager.this.f29356f = System.currentTimeMillis() - AREntranceManager.this.f29355e;
            AREntranceManager.this.arParams = ARCoreCheckerAndGenerator.getARLogData();
            AREntranceManager.this.m22769a(z, i, str);
        }
    };

    public AREntranceManager(Context context, ServingParam servingParam, boolean z) {
        CommonMarkerParam markerParam;
        LatLng point;
        this.f29351a = context;
        this.f29352b = servingParam;
        this.f29358h = z;
        if (servingParam != null && (markerParam = servingParam.getMarkerParam(MapElementId.ID_MARKER_START)) != null && (point = markerParam.getPoint()) != null) {
            this.f29357g = new LatLng(point.latitude, point.longitude);
        }
    }

    public void setOutdoor(boolean z) {
        this.f29358h = z;
    }

    public void setCurrentLocation(DIDILocation dIDILocation) {
        this.f29353c = dIDILocation;
    }

    public void showAR() {
        m22766a(this.f29360j);
    }

    public long getLoadTime() {
        return this.f29356f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22769a(boolean z, int i, String str) {
        Context context = this.f29351a;
        if (context != null) {
            if (z) {
                this.f29354d = DiARNavActivity.startARNavActivity(context);
            } else if (this.f29358h) {
                m22765a(i, str);
                ServingParam servingParam = this.f29352b;
                MapFlowOmegaUtil.trackOutArErrorDialogShow((servingParam == null || servingParam.getOrderParams() == null) ? "" : this.f29352b.getOrderParams().orderId, i);
            } else if (this.f29352b.getGuideEntranceCallback() != null) {
                this.f29352b.getGuideEntranceCallback().onShowARErrorDialog(this.f29352b.getOrderParams().stationWalkGuideLink, str);
                MapFlowOmegaUtil.trackArErrorDialogShow(i);
            }
        }
    }

    /* renamed from: a */
    private void m22765a(int i, String str) {
        ServingParam servingParam = this.f29352b;
        if (servingParam != null && servingParam.getContext() != null && (this.f29352b.getContext() instanceof Activity)) {
            Activity activity = (Activity) this.f29352b.getContext();
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                this.f29359i = new OutdoorArDialog(this.f29352b.getContext());
                this.f29359i.setTitle(this.f29351a.getResources().getString(R.string.GRider_new_Sorry_AR_FsvP));
                this.f29359i.setSubTitle(str);
                this.f29359i.setCanceledOnTouchOutside(true);
                SystemUtils.showDialog(this.f29359i);
            }
        }
    }

    /* renamed from: a */
    private void m22766a(ARCoreCheckerAndGenerator.CheckCallBack checkCallBack) {
        float f;
        ServingParam servingParam = this.f29352b;
        if (servingParam == null) {
            return;
        }
        if ((servingParam.getOrderParams() == null || !TextUtils.isEmpty(this.f29352b.getOrderParams().orderId)) && this.f29357g != null) {
            LatLng latLng = null;
            DIDILocation dIDILocation = this.f29353c;
            float f2 = 0.0f;
            if (dIDILocation != null) {
                latLng = new LatLng(dIDILocation.getLatitude(), this.f29353c.getLongitude());
                f2 = (float) this.f29353c.getAltitude();
                f = this.f29353c.getAccuracy();
            } else {
                f = 0.0f;
            }
            ARCoreCheckerAndGenerator.checkAvailabilityWithRequestData(this.f29351a, new ARCoreCheckerAndGenerator.CheckOption.CheckOptionBuilder().setUID(SystemUtil.getIMEI()).setOrderId(this.f29352b.getOrderParams().orderId).setCurAltitude(f2).setCurLocation(latLng).setHorizontalAccuracy(f).setVerticalAccuracy(f).setDestLocation(this.f29357g).build(), checkCallBack);
            this.f29355e = System.currentTimeMillis();
        }
    }

    public void onOrderStateChanged(int i) {
        Context context;
        if (i == 1) {
            String str = null;
            ServingParam servingParam = this.f29352b;
            if (!(servingParam == null || servingParam.getOrderParams() == null || TextUtils.isEmpty(this.f29352b.getOrderParams().licensePlateNumber))) {
                str = this.f29352b.getOrderParams().licensePlateNumber;
            }
            if (!TextUtils.isEmpty(str) && (context = this.f29351a) != null) {
                m22768a(context.getResources().getString(R.string.GRider_guide_The_driver_fAJr, new Object[]{str}));
            }
        } else if (i == 2) {
            m22770b();
        } else if (i == 3) {
            m22764a();
        } else if (i == 4) {
            m22771c();
        }
    }

    public void updateStartPosition(LatLng latLng) {
        this.f29357g = latLng;
    }

    /* renamed from: a */
    private void m22764a() {
        SystemUtils.log(3, "ARXXX", " order cancel ", (Throwable) null, "com.didi.map.global.flow.scene.order.serving.components.guideentrance.AREntranceManager", 215);
        DiARNavActivity.NotifyStatusSubscriber notifyStatusSubscriber = this.f29354d;
        if (notifyStatusSubscriber != null) {
            notifyStatusSubscriber.onStatusChange(1);
        }
    }

    /* renamed from: a */
    private void m22768a(String str) {
        DiARNavActivity.NotifyStatusSubscriber notifyStatusSubscriber = this.f29354d;
        if (notifyStatusSubscriber != null) {
            notifyStatusSubscriber.onDriverArrived(str);
        }
    }

    /* renamed from: b */
    private void m22770b() {
        DiARNavActivity.NotifyStatusSubscriber notifyStatusSubscriber = this.f29354d;
        if (notifyStatusSubscriber != null) {
            notifyStatusSubscriber.onStatusChange(2);
        }
    }

    /* renamed from: c */
    private void m22771c() {
        DiARNavActivity.NotifyStatusSubscriber notifyStatusSubscriber = this.f29354d;
        if (notifyStatusSubscriber != null) {
            notifyStatusSubscriber.onStatusChange(3);
        }
    }

    public void destroy() {
        this.f29354d = null;
        this.f29352b = null;
        this.f29351a = null;
    }
}
