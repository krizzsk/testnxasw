package com.didi.common.map.model.animation;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.animation.Animation;

public class TranslateAnimation extends Animation {

    /* renamed from: a */
    private LatLng f12756a;

    public TranslateAnimation(LatLng latLng) {
        this.mType = Animation.AnimationType.TRANSLATE;
        this.f12756a = latLng;
    }

    public LatLng getTarget() {
        return this.f12756a;
    }
}
