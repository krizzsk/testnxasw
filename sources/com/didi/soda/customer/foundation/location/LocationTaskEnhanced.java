package com.didi.soda.customer.foundation.location;

import com.didi.common.map.model.LatLng;
import com.didi.foundation.sdk.location.BaseLocationListener;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;

public class LocationTaskEnhanced {

    /* renamed from: a */
    private static final String f43519a = "LocationTaskEnhanced";

    /* renamed from: b */
    private LocationUtil.LocationCallback f43520b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DIDILocation f43521c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ErrInfo f43522d;

    /* renamed from: e */
    private DIDILocationListener f43523e = new DIDILocationListener() {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (LocationTaskEnhanced.this.f43521c == null) {
                DIDILocation unused = LocationTaskEnhanced.this.f43521c = dIDILocation;
                LocationTaskEnhanced.this.m32574b();
                StringBuilder sb = new StringBuilder();
                sb.append("OnceListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m32588i(LocationTaskEnhanced.f43519a, sb.toString() != null ? dIDILocation.toString() : "");
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            ErrInfo unused = LocationTaskEnhanced.this.f43522d = errInfo;
            LocationTaskEnhanced.this.m32579d();
            StringBuilder sb = new StringBuilder();
            sb.append("OnceListener onLocationError: ");
            sb.append(errInfo);
            LogUtil.m32588i(LocationTaskEnhanced.f43519a, sb.toString() != null ? errInfo.toString() : "");
        }
    };

    /* renamed from: f */
    private BaseLocationListener f43524f = new BaseLocationListener() {
        public void onLocationChanged(DIDILocation dIDILocation) {
            super.onLocationChanged(dIDILocation);
            if (LocationTaskEnhanced.this.f43521c == null) {
                DIDILocation unused = LocationTaskEnhanced.this.f43521c = dIDILocation;
                LocationTaskEnhanced.this.m32574b();
                StringBuilder sb = new StringBuilder();
                sb.append("UpdateListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m32588i(LocationTaskEnhanced.f43519a, sb.toString() != null ? dIDILocation.toString() : "");
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            super.onLocationError(i, errInfo);
            ErrInfo unused = LocationTaskEnhanced.this.f43522d = errInfo;
            LocationUtil.setErrorInfo(LocationTaskEnhanced.this.f43522d);
            StringBuilder sb = new StringBuilder();
            sb.append("UpdateListener onLocationError: ");
            sb.append(errInfo);
            LogUtil.m32588i(LocationTaskEnhanced.f43519a, sb.toString() != null ? errInfo.toString() : "");
        }

        public void onStatusUpdate(String str, int i, String str2) {
            super.onStatusUpdate(str, i, str2);
        }
    };

    /* renamed from: g */
    private Runnable f43525g = new Runnable() {
        public void run() {
            if (LocationTaskEnhanced.this.f43521c == null) {
                if (LocationTaskEnhanced.this.f43522d == null) {
                    ErrInfo unused = LocationTaskEnhanced.this.f43522d = new ErrInfo(-1);
                }
                LocationTaskEnhanced.this.m32576c();
                LogUtil.m32588i(LocationTaskEnhanced.f43519a, "TimeOutRunnable onTimeout");
            }
        }
    };

    /* renamed from: h */
    private int f43526h;

    /* renamed from: i */
    private LocationOmegaHelper f43527i = new LocationOmegaHelper();

    public LocationTaskEnhanced(LocationUtil.LocationCallback locationCallback, int i) {
        this.f43520b = locationCallback;
        this.f43526h = i;
    }

    /* renamed from: a */
    private void m32573a() {
        LocationUtil.LocationCallback locationCallback = this.f43520b;
        if (locationCallback != null && (locationCallback instanceof LocationUtil.LocationCallbackWithTrack)) {
            UiHandlerUtil.post(new Runnable() {
                public final void run() {
                    LocationTaskEnhanced.this.m32582f();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m32582f() {
        ((LocationUtil.LocationCallbackWithTrack) this.f43520b).onTrack();
    }

    public void startLocation() {
        this.f43527i.traceLocStart();
        m32573a();
        LocationService.getInstance().requestOnceLocation(this.f43523e);
        LocationService.getInstance().registerLocationListener(this.f43524f);
        UiHandlerUtil.postDelayed(this.f43525g, (long) this.f43526h);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32574b() {
        LocationUtil.setErrorInfo((ErrInfo) null);
        this.f43527i.traceLocEnd(this.f43521c);
        m32580e();
        LatLng latLng = new LatLng(this.f43521c.getLatitude(), this.f43521c.getLongitude());
        LocationUtil.LocationCallback locationCallback = this.f43520b;
        if (locationCallback != null) {
            locationCallback.onLocationSuccess(latLng);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m32576c() {
        LocationUtil.setErrorInfo(this.f43522d);
        m32580e();
        LocationUtil.LocationCallback locationCallback = this.f43520b;
        if (locationCallback != null) {
            locationCallback.onLocationError();
        }
        this.f43527i.traceLocError(this.f43522d);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m32579d() {
        if (!CustomerSystemUtil.isGpsEnabled(GlobalContext.getContext())) {
            m32576c();
        }
    }

    /* renamed from: e */
    private void m32580e() {
        LocationService.getInstance().unRegisterLocationListener(this.f43524f);
        UiHandlerUtil.removeCallbacks(this.f43525g);
    }
}
