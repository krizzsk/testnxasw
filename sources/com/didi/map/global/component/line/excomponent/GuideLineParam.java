package com.didi.map.global.component.line.excomponent;

import com.didi.common.map.model.LatLng;

public class GuideLineParam {

    /* renamed from: a */
    int f28109a;

    /* renamed from: b */
    int f28110b = 0;

    /* renamed from: c */
    float f28111c;

    /* renamed from: d */
    int f28112d;

    /* renamed from: e */
    LatLng f28113e;

    /* renamed from: f */
    LatLng f28114f;

    public GuideLineParam(int i, LatLng latLng, LatLng latLng2) {
        this.f28109a = i;
        this.f28113e = latLng;
        this.f28114f = latLng2;
    }

    public GuideLineParam(int i, int i2, int i3, float f, LatLng latLng, LatLng latLng2) {
        this.f28109a = i;
        this.f28113e = latLng;
        this.f28114f = latLng2;
        this.f28112d = i3;
        this.f28111c = f;
        this.f28110b = i2;
    }
}
