package com.didichuxing.carsliding.model;

import com.didi.common.map.model.Marker;

public class RenderResult {

    /* renamed from: a */
    private String f48925a;

    /* renamed from: b */
    private Marker f48926b;

    public RenderResult(String str, Marker marker) {
        this.f48925a = str;
        this.f48926b = marker;
    }

    public String getId() {
        return this.f48925a;
    }

    public Marker getMarkerWrapper() {
        return this.f48926b;
    }

    public String toString() {
        return this.f48925a;
    }
}
