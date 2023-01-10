package com.didi.soda.customer.foundation.location;

import com.didi.common.map.model.LatLng;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;

public class LocationTaskDefault {

    /* renamed from: a */
    private static final String f43516a = "LocationTaskDefault";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LocationUtil.LocationCallback f43517b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LocationOmegaHelper f43518c = new LocationOmegaHelper();

    public LocationTaskDefault(LocationUtil.LocationCallback locationCallback) {
        this.f43517b = locationCallback;
    }

    public void startLocation() {
        this.f43518c.traceLocStart();
        LocationService.getInstance().requestOnceLocation(new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                LocationUtil.setErrorInfo((ErrInfo) null);
                LocationTaskDefault.this.f43518c.traceLocEnd(dIDILocation);
                LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                if (LocationTaskDefault.this.f43517b != null) {
                    LocationTaskDefault.this.f43517b.onLocationSuccess(latLng);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("OnceListener onLocationChanged: ");
                sb.append(dIDILocation);
                LogUtil.m32588i(LocationTaskDefault.f43516a, sb.toString() != null ? dIDILocation.toString() : "");
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                if (LocationTaskDefault.this.f43517b != null) {
                    LocationTaskDefault.this.f43517b.onLocationError();
                }
                LocationUtil.setErrorInfo(errInfo);
                LocationTaskDefault.this.f43518c.traceLocError(errInfo);
                StringBuilder sb = new StringBuilder();
                sb.append("UpdateListener onLocationError: ");
                sb.append(errInfo);
                LogUtil.m32588i(LocationTaskDefault.f43516a, sb.toString() != null ? errInfo.toString() : "");
            }
        });
    }
}
