package com.didi.map.global.component.slideCars.navigator;

public class CarNavigatorConfigParam {
    public static final int SKIP = 1;
    public static final int SLIDE = 2;

    /* renamed from: a */
    private int f28461a = 2;

    /* renamed from: b */
    private long f28462b;

    /* renamed from: c */
    private boolean f28463c = true;

    /* renamed from: d */
    private boolean f28464d = true;

    /* renamed from: e */
    private boolean f28465e;

    public int getRenderStrategy() {
        return this.f28461a;
    }

    public void setRenderStrategy(int i) {
        this.f28461a = i;
    }

    public long getSlidingTime() {
        return this.f28462b;
    }

    public void setSlidingTime(long j) {
        this.f28462b = j;
    }

    public boolean isFadeAnimInEnable() {
        return this.f28463c;
    }

    public void setFadeAnimInEnable(boolean z) {
        this.f28463c = z;
    }

    public boolean isFadeAnimOutEnable() {
        return this.f28464d;
    }

    public void setFadeAnimOutEnable(boolean z) {
        this.f28464d = z;
    }

    public boolean isAngleSensitive() {
        return this.f28465e;
    }

    public void setAngleSensitive(boolean z) {
        this.f28465e = z;
    }
}
