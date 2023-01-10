package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.filter;

import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.IAccTimeTracker */
public interface IAccTimeTracker {
    void startTracking();

    void stopTracking();

    void updateNotifiedLocation(DIDILocation dIDILocation, String str);
}
