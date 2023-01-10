package com.didi.entrega.customer.foundation.location;

import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.foundation.sdk.location.BaseLocationListener;
import com.didi.foundation.sdk.location.LocationService;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;

public class LocationTaskEnhanced {

    /* renamed from: a */
    private static final String f21776a = "LocationTaskEnhanced";

    /* renamed from: b */
    private LocationUtil.LocationCallback f21777b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DIDILocation f21778c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ErrInfo f21779d;

    /* renamed from: e */
    private DIDILocationListener f21780e = new DIDILocationListener() {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (LocationTaskEnhanced.this.f21778c == null) {
                DIDILocation unused = LocationTaskEnhanced.this.f21778c = dIDILocation;
                LocationTaskEnhanced.this.m18172a();
                StringBuilder sb = new StringBuilder();
                sb.append("OnceListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m18185i(LocationTaskEnhanced.f21776a, sb.toString() != null ? dIDILocation.toString() : "");
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            ErrInfo unused = LocationTaskEnhanced.this.f21779d = errInfo;
            LocationTaskEnhanced.this.m18175c();
            StringBuilder sb = new StringBuilder();
            sb.append("OnceListener onLocationError: ");
            sb.append(errInfo);
            LogUtil.m18185i(LocationTaskEnhanced.f21776a, sb.toString() != null ? errInfo.toString() : "");
        }
    };

    /* renamed from: f */
    private BaseLocationListener f21781f = new BaseLocationListener() {
        public void onLocationChanged(DIDILocation dIDILocation) {
            super.onLocationChanged(dIDILocation);
            if (LocationTaskEnhanced.this.f21778c == null) {
                DIDILocation unused = LocationTaskEnhanced.this.f21778c = dIDILocation;
                LocationTaskEnhanced.this.m18172a();
                StringBuilder sb = new StringBuilder();
                sb.append("UpdateListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m18185i(LocationTaskEnhanced.f21776a, sb.toString() != null ? dIDILocation.toString() : "");
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            super.onLocationError(i, errInfo);
            ErrInfo unused = LocationTaskEnhanced.this.f21779d = errInfo;
            StringBuilder sb = new StringBuilder();
            sb.append("UpdateListener onLocationError: ");
            sb.append(errInfo);
            LogUtil.m18185i(LocationTaskEnhanced.f21776a, sb.toString() != null ? errInfo.toString() : "");
        }

        public void onStatusUpdate(String str, int i, String str2) {
            super.onStatusUpdate(str, i, str2);
        }
    };

    /* renamed from: g */
    private Runnable f21782g = new Runnable() {
        public void run() {
            if (LocationTaskEnhanced.this.f21778c == null) {
                if (LocationTaskEnhanced.this.f21779d == null) {
                    ErrInfo unused = LocationTaskEnhanced.this.f21779d = new ErrInfo(-1);
                }
                LocationTaskEnhanced.this.m18173b();
                LogUtil.m18185i(LocationTaskEnhanced.f21776a, "TimeOutRunnable onTimeout");
            }
        }
    };

    /* renamed from: h */
    private int f21783h;

    /* renamed from: i */
    private LocationOmegaHelper f21784i = new LocationOmegaHelper();

    public LocationTaskEnhanced(LocationUtil.LocationCallback locationCallback, int i) {
        this.f21777b = locationCallback;
        this.f21783h = i;
    }

    public void startLocation() {
        this.f21784i.traceLocStart();
        LocationService.getInstance().requestOnceLocation(this.f21780e);
        LocationService.getInstance().registerLocationListener(this.f21781f);
        UiHandlerUtil.postDelayed(this.f21782g, (long) this.f21783h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18172a() {
        this.f21784i.traceLocEnd(this.f21778c);
        m18178d();
        LatLng latLng = new LatLng(this.f21778c.getLatitude(), this.f21778c.getLongitude());
        LocationUtil.LocationCallback locationCallback = this.f21777b;
        if (locationCallback != null) {
            locationCallback.onLocationSuccess(latLng);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18173b() {
        m18178d();
        LocationUtil.LocationCallback locationCallback = this.f21777b;
        if (locationCallback != null) {
            locationCallback.onLocationError();
        }
        this.f21784i.traceLocError(this.f21779d);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m18175c() {
        if (!CustomerSystemUtil.isGpsEnabled(GlobalContext.getContext())) {
            m18173b();
        }
    }

    /* renamed from: d */
    private void m18178d() {
        LocationService.getInstance().unRegisterLocationListener(this.f21781f);
        UiHandlerUtil.removeCallbacks(this.f21782g);
    }
}
