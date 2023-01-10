package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.highlight.Range;

public class BarEntry extends Entry {

    /* renamed from: a */
    private float[] f54889a;

    /* renamed from: b */
    private Range[] f54890b;

    /* renamed from: c */
    private float f54891c;

    /* renamed from: d */
    private float f54892d;

    public BarEntry(float f, float f2) {
        super(f, f2);
    }

    public BarEntry(float f, float f2, Object obj) {
        super(f, f2, obj);
    }

    public BarEntry(float f, float f2, Drawable drawable) {
        super(f, f2, drawable);
    }

    public BarEntry(float f, float f2, Drawable drawable, Object obj) {
        super(f, f2, drawable, obj);
    }

    public BarEntry(float f, float[] fArr) {
        super(f, m40692a(fArr));
        this.f54889a = fArr;
        m40693a();
        calcRanges();
    }

    public BarEntry(float f, float[] fArr, Object obj) {
        super(f, m40692a(fArr), obj);
        this.f54889a = fArr;
        m40693a();
        calcRanges();
    }

    public BarEntry(float f, float[] fArr, Drawable drawable) {
        super(f, m40692a(fArr), drawable);
        this.f54889a = fArr;
        m40693a();
        calcRanges();
    }

    public BarEntry(float f, float[] fArr, Drawable drawable, Object obj) {
        super(f, m40692a(fArr), drawable, obj);
        this.f54889a = fArr;
        m40693a();
        calcRanges();
    }

    public BarEntry copy() {
        BarEntry barEntry = new BarEntry(getX(), getY(), getData());
        barEntry.setVals(this.f54889a);
        return barEntry;
    }

    public float[] getYVals() {
        return this.f54889a;
    }

    public void setVals(float[] fArr) {
        setY(m40692a(fArr));
        this.f54889a = fArr;
        m40693a();
        calcRanges();
    }

    public float getY() {
        return super.getY();
    }

    public Range[] getRanges() {
        return this.f54890b;
    }

    public boolean isStacked() {
        return this.f54889a != null;
    }

    @Deprecated
    public float getBelowSum(int i) {
        return getSumBelow(i);
    }

    public float getSumBelow(int i) {
        float[] fArr = this.f54889a;
        float f = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        int length = fArr.length - 1;
        while (length > i && length >= 0) {
            f += this.f54889a[length];
            length--;
        }
        return f;
    }

    public float getPositiveSum() {
        return this.f54892d;
    }

    public float getNegativeSum() {
        return this.f54891c;
    }

    /* renamed from: a */
    private void m40693a() {
        float[] fArr = this.f54889a;
        if (fArr == null) {
            this.f54891c = 0.0f;
            this.f54892d = 0.0f;
            return;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        for (float f3 : fArr) {
            if (f3 <= 0.0f) {
                f += Math.abs(f3);
            } else {
                f2 += f3;
            }
        }
        this.f54891c = f;
        this.f54892d = f2;
    }

    /* renamed from: a */
    private static float m40692a(float[] fArr) {
        float f = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    /* access modifiers changed from: protected */
    public void calcRanges() {
        float[] yVals = getYVals();
        if (yVals != null && yVals.length != 0) {
            this.f54890b = new Range[yVals.length];
            float f = -getNegativeSum();
            int i = 0;
            float f2 = 0.0f;
            while (true) {
                Range[] rangeArr = this.f54890b;
                if (i < rangeArr.length) {
                    float f3 = yVals[i];
                    if (f3 < 0.0f) {
                        float f4 = f - f3;
                        rangeArr[i] = new Range(f, f4);
                        f = f4;
                    } else {
                        float f5 = f3 + f2;
                        rangeArr[i] = new Range(f2, f5);
                        f2 = f5;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
