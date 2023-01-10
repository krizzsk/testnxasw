package com.dmap.navigation.simple;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.location.IPassPoint;

public class SimplePassPoint implements IPassPoint {

    /* renamed from: a */
    private final int f54585a;

    /* renamed from: b */
    private final int f54586b;

    /* renamed from: c */
    private final LatLng f54587c;

    public SimplePassPoint(int i, int i2, LatLng latLng) {
        this.f54585a = i;
        this.f54586b = i2;
        this.f54587c = latLng;
    }

    public String toString() {
        return "SimplePassPoint{pointIndex=" + this.f54585a + ", coorIndex=" + this.f54586b + ", latLng=" + this.f54587c + '}';
    }

    public int getPointIndex() {
        return this.f54585a;
    }

    public int getCoorIndex() {
        return this.f54586b;
    }

    public LatLng getLatLng() {
        return this.f54587c;
    }
}
