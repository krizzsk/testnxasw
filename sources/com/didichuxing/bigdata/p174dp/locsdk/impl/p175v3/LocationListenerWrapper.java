package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationListenerWrapper */
public class LocationListenerWrapper {

    /* renamed from: a */
    long f48543a;

    /* renamed from: b */
    private DIDILocationUpdateOption f48544b;

    /* renamed from: c */
    private DIDILocationListener f48545c;

    /* renamed from: d */
    private long f48546d;

    public long getNotifyLocTime() {
        return this.f48546d;
    }

    public void setNotifyLocTime(long j) {
        this.f48546d = j;
    }

    public LocationListenerWrapper(DIDILocationListener dIDILocationListener, DIDILocationUpdateOption dIDILocationUpdateOption) {
        this.f48545c = dIDILocationListener;
        this.f48544b = dIDILocationUpdateOption;
    }

    public DIDILocationUpdateOption getOption() {
        return this.f48544b;
    }

    public void setOption(DIDILocationUpdateOption dIDILocationUpdateOption) {
        this.f48544b = dIDILocationUpdateOption;
    }

    public DIDILocationListener getListener() {
        return this.f48545c;
    }

    public void setListener(DIDILocationListener dIDILocationListener) {
        this.f48545c = dIDILocationListener;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LocationListenerWrapper)) {
            return false;
        }
        LocationListenerWrapper locationListenerWrapper = (LocationListenerWrapper) obj;
        if (!this.f48545c.equals(locationListenerWrapper.getListener()) || this.f48544b.getInterval().getValue() != locationListenerWrapper.getOption().getInterval().getValue()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f48545c.hashCode();
    }
}
