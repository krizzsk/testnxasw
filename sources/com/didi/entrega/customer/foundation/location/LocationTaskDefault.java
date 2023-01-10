package com.didi.entrega.customer.foundation.location;

import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.foundation.sdk.location.LocationService;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;

public class LocationTaskDefault {

    /* renamed from: a */
    private static final String f21773a = "LocationTaskDefault";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LocationUtil.LocationCallback f21774b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LocationOmegaHelper f21775c = new LocationOmegaHelper();

    public LocationTaskDefault(LocationUtil.LocationCallback locationCallback) {
        this.f21774b = locationCallback;
    }

    public void startLocation() {
        this.f21775c.traceLocStart();
        LocationService.getInstance().requestOnceLocation(new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                LocationTaskDefault.this.f21775c.traceLocEnd(dIDILocation);
                LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                if (LocationTaskDefault.this.f21774b != null) {
                    LocationTaskDefault.this.f21774b.onLocationSuccess(latLng);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("OnceListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m18185i(LocationTaskDefault.f21773a, sb.toString() != null ? dIDILocation.toString() : "");
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                if (LocationTaskDefault.this.f21774b != null) {
                    LocationTaskDefault.this.f21774b.onLocationError();
                }
                LocationTaskDefault.this.f21775c.traceLocError(errInfo);
                StringBuilder sb = new StringBuilder();
                sb.append("UpdateListener onLocationError: ");
                sb.append(errInfo);
                LogUtil.m18185i(LocationTaskDefault.f21773a, sb.toString() != null ? errInfo.toString() : "");
            }
        });
    }
}
