package com.didi.map.global.component.bluetooth.client;

import com.didi.common.map.model.LatLng;

public class DriverInfoResult {

    /* renamed from: a */
    private LatLng f27047a;

    /* renamed from: b */
    private float f27048b;

    public LatLng getDriverPos() {
        return this.f27047a;
    }

    public void setDriverPos(LatLng latLng) {
        this.f27047a = latLng;
    }

    public float getDriverAcc() {
        return this.f27048b;
    }

    public void setDriverAcc(float f) {
        this.f27048b = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DriverInfoResult{driverLoc=");
        LatLng latLng = this.f27047a;
        sb.append(latLng == null ? "null" : latLng.toString());
        sb.append(", driverAcc=");
        sb.append(this.f27048b);
        sb.append('}');
        return sb.toString();
    }
}
