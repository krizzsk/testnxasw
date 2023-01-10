package com.didi.unifiedPay.component.widget.loading;

import android.view.animation.Interpolator;

/* renamed from: com.didi.unifiedPay.component.widget.loading.c */
/* compiled from: LookupTableInterpolator */
abstract class C15293c implements Interpolator {

    /* renamed from: a */
    private final float[] f47190a;

    /* renamed from: b */
    private final float f47191b;

    public C15293c(float[] fArr) {
        this.f47190a = fArr;
        this.f47191b = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f47190a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.f47191b;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.f47190a;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
