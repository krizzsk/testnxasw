package com.didi.map.core.animation;

import android.view.animation.Interpolator;
import com.didi.map.outer.model.LatLng;

public class MapEmergeAnimation extends MapAnimation {

    /* renamed from: a */
    private LatLng f26964a = null;

    public MapEmergeAnimation(LatLng latLng) {
        this.f26964a = latLng;
    }

    /* access modifiers changed from: protected */
    public void performAnimation(float f, Interpolator interpolator) {
        float interpolation = interpolator.getInterpolation(f);
        if (this.animationProperty != null) {
            this.animationProperty.setRatio(interpolation);
        }
    }

    public LatLng getStartPoint() {
        return this.f26964a;
    }
}
