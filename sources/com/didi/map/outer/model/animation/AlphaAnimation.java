package com.didi.map.outer.model.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.animation.MapAlphaAnimation;

public class AlphaAnimation extends Animation {

    /* renamed from: a */
    private float f30521a;

    /* renamed from: b */
    private float f30522b;

    public float getFromAlpha() {
        return this.f30521a;
    }

    public float getToAlpha() {
        return this.f30522b;
    }

    public AlphaAnimation(float f, float f2) {
        this.f30521a = f;
        this.f30522b = f2;
        if (this.animation == null) {
            this.animation = new MapAlphaAnimation(f, f2);
        }
    }

    public void setDuration(long j) {
        super.setDuration(j);
        if (this.animation != null) {
            this.animation.setDuration(j);
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        if (this.animation != null && interpolator != null) {
            this.animation.setInterpolator(interpolator);
        }
    }

    public void setDelay(long j) {
        super.setDelay(j);
        if (this.animation != null) {
            this.animation.setDelay(j);
        }
    }
}
