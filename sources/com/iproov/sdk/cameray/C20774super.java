package com.iproov.sdk.cameray;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;

/* renamed from: com.iproov.sdk.cameray.super */
/* compiled from: FPSUtils */
public class C20774super {
    /* renamed from: a */
    private static int m42943a(int i, int i2) {
        return i > 1000 ? i2 * 1000 : i2;
    }

    /* renamed from: a */
    static Range<Integer> m42944a(CameraCharacteristics cameraCharacteristics, int i) {
        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        return m42945a((Range<Integer>[]) rangeArr, m42943a(((Integer) rangeArr[0].getLower()).intValue(), i));
    }

    /* renamed from: a */
    private static Range<Integer> m42945a(Range<Integer>[] rangeArr, int i) {
        Range<Integer> range = null;
        for (Range<Integer> range2 : rangeArr) {
            if (range2.getUpper().intValue() == i) {
                return range2;
            }
            if (range == null || ((range2.getUpper().intValue() <= i || range.getUpper().intValue() >= i) && ((range2.getUpper().intValue() < i && range.getUpper().intValue() > i) || Math.abs(i - range2.getUpper().intValue()) < Math.abs(i - range.getUpper().intValue())))) {
                range = range2;
            }
        }
        return range;
    }
}
