package com.didi.map.outer.model.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.animation.MapRotateAnimation;

public class RotateAnimation extends Animation {

    /* renamed from: a */
    private float f30526a = 0.0f;

    /* renamed from: b */
    private float f30527b = 0.0f;

    /* renamed from: c */
    private float f30528c = 0.0f;

    /* renamed from: d */
    private float f30529d = 0.0f;

    /* renamed from: e */
    private float f30530e = 0.0f;

    public float getFromAngle() {
        return this.f30526a;
    }

    public float getToAngle() {
        return this.f30527b;
    }

    public RotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.f30526a = f;
        this.f30527b = f2;
        this.f30528c = f3;
        this.f30529d = f4;
        this.f30530e = f5;
        if (this.animation == null) {
            this.animation = new MapRotateAnimation(f, f2, f3, f4, f5);
        }
    }

    public void setDuration(long j) {
        super.setDuration(j);
        if (this.animation != null) {
            this.animation.setDuration(j);
        }
    }

    public void setDelay(long j) {
        super.setDelay(j);
        if (this.animation != null) {
            this.animation.setDelay(j);
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        if (this.animation != null && interpolator != null) {
            this.animation.setInterpolator(interpolator);
        }
    }
}
