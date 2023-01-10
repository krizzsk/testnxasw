package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.BezierCurve;
import com.didi.map.outer.model.BezierCurveOption;

public class BezierCurveControl {

    /* renamed from: a */
    private IBezierCurveDelegate f26707a;

    public BezierCurveControl(IBezierCurveDelegate iBezierCurveDelegate) {
        this.f26707a = iBezierCurveDelegate;
    }

    public BezierCurve addBezierCurve(BezierCurveOption bezierCurveOption) {
        return this.f26707a.addBezierCurve(bezierCurveOption, this);
    }

    public void update(String str, float f) {
        this.f26707a.update(str, f);
    }

    public void remove(String str) {
        this.f26707a.remove(str);
    }

    public void clearBezierCurves() {
        this.f26707a.clearBezierCurves();
    }
}
