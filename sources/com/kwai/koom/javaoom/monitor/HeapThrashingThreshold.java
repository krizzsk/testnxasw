package com.kwai.koom.javaoom.monitor;

import com.kwai.koom.javaoom.common.KConstants;

public class HeapThrashingThreshold implements Threshold {

    /* renamed from: a */
    private static final int f58469a = 100;

    /* renamed from: b */
    private static final int f58470b = 3;

    /* renamed from: c */
    private static final int f58471c = 5000;

    public boolean ascending() {
        return false;
    }

    public float maxValue() {
        return 0.0f;
    }

    public int overTimes() {
        return 3;
    }

    public int pollInterval() {
        return 5000;
    }

    public float value() {
        return (float) (KConstants.Bytes.f58430MB * 100);
    }

    public ThresholdValueType valueType() {
        return ThresholdValueType.BYTES;
    }
}
