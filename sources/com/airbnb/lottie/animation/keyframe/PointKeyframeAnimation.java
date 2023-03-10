package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class PointKeyframeAnimation extends C1482a<PointF> {

    /* renamed from: b */
    private final PointF f1334b = new PointF();

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
    }

    public PointF getValue(Keyframe<PointF> keyframe, float f) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) keyframe.startValue;
        PointF pointF2 = (PointF) keyframe.endValue;
        if (this.valueCallback != null) {
            PointF pointF3 = (PointF) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF, pointF2, f, mo15224a(), getProgress());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        this.f1334b.set(pointF.x + ((pointF2.x - pointF.x) * f), pointF.y + (f * (pointF2.y - pointF.y)));
        return this.f1334b;
    }
}
