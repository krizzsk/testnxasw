package com.didi.entrega.customer.foundation.location;

import com.didi.entrega.customer.foundation.util.LocationUtil;

public class LocationWrapper {

    /* renamed from: a */
    private LocationUtil.LocationCallback f21785a;

    /* renamed from: b */
    private int f21786b;

    public static class Timeout {
        public static final int DEFAULT_GPS_TIMEOUT = 4000;
        public static final int SAFE_GPS_TIMEOUT = 1000;
    }

    public LocationWrapper(LocationUtil.LocationCallback locationCallback, int i) {
        this.f21785a = locationCallback;
        this.f21786b = i;
    }

    public void startLocation() {
        int i = this.f21786b;
        if (i < 1000) {
            new LocationTaskDefault(this.f21785a).startLocation();
        } else {
            new LocationTaskEnhanced(this.f21785a, i).startLocation();
        }
    }
}
