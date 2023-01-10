package com.didi.entrega.customer.foundation.location;

import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;

public class LocationOmegaHelper {

    /* renamed from: a */
    private static boolean f21770a = true;

    /* renamed from: b */
    private long f21771b;

    /* renamed from: c */
    private long f21772c;

    /* access modifiers changed from: protected */
    public void traceLocStart() {
        this.f21771b = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void traceLocEnd(DIDILocation dIDILocation) {
        this.f21772c = System.currentTimeMillis();
        OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_SERVICE_LOCATION_SUCCESS).addEventParam("time", Long.valueOf(this.f21772c - this.f21771b)).addEventParam("lat", Double.valueOf(dIDILocation.getLatitude())).addEventParam("lng", Double.valueOf(dIDILocation.getLongitude())).addEventParam("first_locate", Integer.valueOf(f21770a ? 1 : 2)).build().track();
        f21770a = false;
    }

    /* access modifiers changed from: protected */
    public void traceLocError(ErrInfo errInfo) {
        OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_SERVICE_LOCATION_ERROR).addEventParam("error_code", Integer.valueOf(errInfo.getErrNo())).build().track();
    }
}
