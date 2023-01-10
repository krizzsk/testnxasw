package com.didi.map.outer.model;

import com.didi.map.alpha.maps.internal.BezierCurveControl;

public class BezierCurve {

    /* renamed from: a */
    private BezierCurveOption f30335a;

    /* renamed from: b */
    private BezierCurveControl f30336b;

    /* renamed from: c */
    private String f30337c;

    public BezierCurve(BezierCurveOption bezierCurveOption, BezierCurveControl bezierCurveControl, String str) {
        this.f30335a = bezierCurveOption;
        this.f30336b = bezierCurveControl;
        this.f30337c = str;
    }

    public void update(float f) {
        this.f30336b.update(this.f30337c, f);
    }

    public void remove() {
        this.f30336b.remove(this.f30337c);
    }

    public String getId() {
        return this.f30337c;
    }
}
