package com.didi.map.sdk.sharetrack.entity;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class DiDiRouteSegment {

    /* renamed from: a */
    private LatLng f31086a;

    /* renamed from: b */
    private List<LatLng> f31087b;

    public LatLng getDestPoint() {
        return this.f31086a;
    }

    public void setDestPoint(LatLng latLng) {
        this.f31086a = latLng;
    }

    public List<LatLng> getLatLngList() {
        return this.f31087b;
    }

    public void setLatLngList(List<LatLng> list) {
        this.f31087b = list;
    }
}
