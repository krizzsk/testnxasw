package com.kwai.koom.javaoom.monitor;

public class HeapThreshold implements Threshold {

    /* renamed from: a */
    private float f58472a;

    /* renamed from: b */
    private float f58473b;

    /* renamed from: c */
    private int f58474c;

    /* renamed from: d */
    private int f58475d;

    public boolean ascending() {
        return true;
    }

    public HeapThreshold(float f, float f2, int i, int i2) {
        this.f58472a = f;
        this.f58473b = f2;
        this.f58474c = i;
        this.f58475d = i2;
    }

    public float value() {
        return this.f58472a;
    }

    public float maxValue() {
        return this.f58473b;
    }

    public int overTimes() {
        return this.f58474c;
    }

    public final ThresholdValueType valueType() {
        return ThresholdValueType.PERCENT;
    }

    public int pollInterval() {
        return this.f58475d;
    }
}
