package com.didi.soda.customer.foundation.location;

import com.didi.soda.customer.foundation.util.LocationUtil;

public class LocationWrapper {

    /* renamed from: a */
    private LocationUtil.LocationCallback f43528a;

    /* renamed from: b */
    private int f43529b;

    public static class Timeout {
        public static final int DEFAULT_GPS_TIMEOUT = 4000;
        public static final int SAFE_GPS_TIMEOUT = 1000;
    }

    public LocationWrapper(LocationUtil.LocationCallback locationCallback, int i) {
        this.f43528a = locationCallback;
        this.f43529b = i;
    }

    public void startLocation() {
        int i = this.f43529b;
        if (i < 1000) {
            new LocationTaskDefault(this.f43528a).startLocation();
        } else {
            new LocationTaskEnhanced(this.f43528a, i).startLocation();
        }
    }
}
