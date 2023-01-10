package com.didi.common.map.model;

import com.didi.common.map.internal.IMapElementOptions;

@Deprecated
public final class MaskLayerOptions extends IMapElementOptions {

    /* renamed from: a */
    private int f12722a = 0;

    /* renamed from: b */
    private long f12723b = 0;

    public MaskLayerOptions color(int i) {
        this.f12722a = i;
        return this;
    }

    public int getColor() {
        return this.f12722a;
    }

    public MaskLayerOptions animationDuration(long j) {
        this.f12723b = j;
        return this;
    }

    public long getAnimationDuration() {
        return this.f12723b;
    }
}
