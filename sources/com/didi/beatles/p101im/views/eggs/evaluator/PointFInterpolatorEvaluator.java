package com.didi.beatles.p101im.views.eggs.evaluator;

import android.animation.TimeInterpolator;
import android.graphics.PointF;
import androidx.core.util.Pools;
import com.didi.beatles.p101im.utils.IMFactoryPools;

/* renamed from: com.didi.beatles.im.views.eggs.evaluator.PointFInterpolatorEvaluator */
public class PointFInterpolatorEvaluator extends TypeInterpolatorEvaluator<PointF> {

    /* renamed from: a */
    private static final String f12045a = PointFInterpolatorEvaluator.class.getSimpleName();

    /* renamed from: b */
    private static Pools.Pool<PointF> f12046b = IMFactoryPools.simple(30, new IMFactoryPools.Factory<PointF>() {
        public PointF create() {
            return new PointF();
        }
    });

    public static void recyclePointF(PointF pointF) {
        f12046b.release(pointF);
    }

    public PointFInterpolatorEvaluator() {
    }

    public PointFInterpolatorEvaluator(TimeInterpolator timeInterpolator) {
        super(timeInterpolator);
    }

    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        PointF acquire = f12046b.acquire();
        if (this.timeInterpolator != null) {
            f = this.timeInterpolator.getInterpolation(f);
        }
        acquire.x = pointF.x + ((pointF2.x - pointF.x) * f);
        acquire.y = pointF.y + (f * (pointF2.y - pointF.y));
        return acquire;
    }
}
