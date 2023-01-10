package com.didi.soda.customer.foundation.location;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;

public class LocationOmegaHelper {

    /* renamed from: a */
    private static boolean f43513a = true;

    /* renamed from: b */
    private long f43514b;

    /* renamed from: c */
    private long f43515c;

    /* access modifiers changed from: protected */
    public void traceLocStart() {
        this.f43514b = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void traceLocEnd(DIDILocation dIDILocation) {
        this.f43515c = System.currentTimeMillis();
        OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_SERVICE_LOCATION_SUCCESS).addEventParam("time", Long.valueOf(this.f43515c - this.f43514b)).addEventParam("lat", Double.valueOf(dIDILocation.getLatitude())).addEventParam("lng", Double.valueOf(dIDILocation.getLongitude())).addEventParam("first_locate", Integer.valueOf(f43513a ? 1 : 2)).build().track();
        f43513a = false;
    }

    /* access modifiers changed from: protected */
    public void traceLocError(ErrInfo errInfo) {
        OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_SERVICE_LOCATION_ERROR).addEventParam("error_code", Integer.valueOf(errInfo.getErrNo())).build().track();
    }
}
