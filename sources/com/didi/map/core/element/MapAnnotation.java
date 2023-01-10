package com.didi.map.core.element;

import com.didi.map.outer.model.LatLng;

public class MapAnnotation {

    /* renamed from: e */
    private static final int f26984e = 0;

    /* renamed from: f */
    private static final int f26985f = 1;

    /* renamed from: g */
    private static final int f26986g = 2;

    /* renamed from: a */
    private long f26987a;

    /* renamed from: b */
    private LatLng f26988b;

    /* renamed from: c */
    private String f26989c;

    /* renamed from: d */
    private final long f26990d;

    /* renamed from: h */
    private final int f26991h;

    public MapAnnotation(long j, String str, LatLng latLng, long j2, int i) {
        this.f26987a = j;
        this.f26988b = latLng;
        this.f26989c = str;
        this.f26990d = j2;
        this.f26991h = i;
    }

    public long getId() {
        return this.f26987a;
    }

    public LatLng getPosition() {
        return this.f26988b;
    }

    public String getName() {
        return this.f26989c;
    }

    public long getPoiId() {
        return this.f26990d;
    }

    public int getPoiType() {
        return this.f26991h;
    }
}
