package com.didi.map.global.component.line.pax.walkanddropoff.newversion;

import com.didi.common.map.model.LatLng;

public class NewWalkParam {

    /* renamed from: a */
    private LatLng f28221a;

    /* renamed from: b */
    private long f28222b;

    /* renamed from: c */
    private String f28223c;

    /* renamed from: d */
    private String f28224d;

    /* renamed from: e */
    private long f28225e;

    public NewWalkParam(LatLng latLng, long j, String str, String str2, long j2) {
        this.f28221a = latLng;
        this.f28222b = j;
        this.f28223c = str;
        this.f28224d = str2;
        this.f28225e = j2;
    }

    public LatLng getEndPoint() {
        return this.f28221a;
    }

    public long getDriverId() {
        return this.f28222b;
    }

    public String getOrderId() {
        return this.f28223c;
    }

    public String getProductId() {
        return this.f28224d;
    }

    public void setEndPoint(LatLng latLng) {
        this.f28221a = latLng;
    }

    public void setProductId(String str) {
        this.f28224d = str;
    }

    public long getPushInterval() {
        return this.f28225e;
    }
}
