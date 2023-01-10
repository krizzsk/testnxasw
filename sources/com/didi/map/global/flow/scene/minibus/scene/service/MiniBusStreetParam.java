package com.didi.map.global.flow.scene.minibus.scene.service;

import com.didi.common.map.model.LatLng;

public class MiniBusStreetParam {

    /* renamed from: a */
    private String f28928a;

    /* renamed from: b */
    private LatLng f28929b;

    /* renamed from: c */
    private String f28930c;

    /* renamed from: d */
    private String f28931d;

    public MiniBusStreetParam(String str, LatLng latLng, String str2, String str3) {
        this.f28928a = str;
        this.f28929b = latLng;
        this.f28930c = str2;
        this.f28931d = str3;
    }

    public String getStreetViewUrl() {
        return this.f28928a;
    }

    public LatLng getAddressPosition() {
        return this.f28929b;
    }

    public String getAddressName() {
        return this.f28930c;
    }

    public String getAddressPoiId() {
        return this.f28931d;
    }

    public String toString() {
        return "MiniBusStreetParam{streetViewUrl='" + this.f28928a + '\'' + ", addressPosition=" + this.f28929b + ", addressName='" + this.f28930c + '\'' + ", addressPoiId='" + this.f28931d + '\'' + '}';
    }
}
