package com.didi.hawaii.mapsdkv2.common.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class ScrollByPointFEvaluator implements TypeEvaluator<PointF> {

    /* renamed from: a */
    private PointF f26055a;

    /* renamed from: b */
    private PointF f26056b = new PointF();

    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        float f2 = (pointF2.x - pointF.x) * f;
        float f3 = (pointF2.y - pointF.y) * f;
        float f4 = f2 - this.f26056b.x;
        float f5 = f3 - this.f26056b.y;
        PointF pointF3 = this.f26055a;
        if (pointF3 != null) {
            pointF3.set(f4, f5);
        } else {
            this.f26055a = new PointF(f4, f5);
        }
        this.f26056b.set(f2, f3);
        return this.f26055a;
    }
}
