package com.didi.map.outer.model;

public class MaskLayerOptions {

    /* renamed from: a */
    private int f30444a = 0;

    /* renamed from: b */
    private long f30445b = 0;

    /* renamed from: c */
    private int f30446c = 0;

    public MaskLayerOptions color(int i) {
        this.f30444a = i;
        return this;
    }

    public int getColor() {
        return this.f30444a;
    }

    public MaskLayerOptions animationDuration(long j) {
        this.f30445b = j;
        return this;
    }

    public long getAnimationDuration() {
        return this.f30445b;
    }

    public MaskLayerOptions zIndex(int i) {
        this.f30446c = i;
        return this;
    }

    public int getZIndex() {
        return this.f30446c;
    }
}
