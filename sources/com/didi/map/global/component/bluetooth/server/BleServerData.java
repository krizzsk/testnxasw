package com.didi.map.global.component.bluetooth.server;

import com.didi.common.map.model.LatLng;

public class BleServerData {

    /* renamed from: a */
    private LatLng f27065a;

    /* renamed from: b */
    private float f27066b;

    /* renamed from: c */
    private long f27067c;

    public LatLng getDriverPos() {
        return this.f27065a;
    }

    public void setDriverPos(LatLng latLng) {
        this.f27065a = latLng;
    }

    public float getDriverAcc() {
        return this.f27066b;
    }

    public void setDriverAcc(float f) {
        this.f27066b = f;
    }

    public long getDriverTime() {
        return this.f27067c;
    }

    public void setDriverTime(long j) {
        this.f27067c = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BleServerData{driverLoc=");
        LatLng latLng = this.f27065a;
        sb.append(latLng == null ? "null" : latLng.toString());
        sb.append(", driverAcc=");
        sb.append(this.f27066b);
        sb.append(", driverTime=");
        sb.append(this.f27067c);
        sb.append('}');
        return sb.toString();
    }
}
