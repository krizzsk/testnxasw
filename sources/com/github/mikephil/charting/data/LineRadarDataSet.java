package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> implements ILineRadarDataSet<T> {

    /* renamed from: a */
    private int f54928a = Color.rgb(140, 234, 255);

    /* renamed from: b */
    private int f54929b = 85;

    /* renamed from: c */
    private float f54930c = 2.5f;

    /* renamed from: d */
    private boolean f54931d = false;
    protected Drawable mFillDrawable;

    public LineRadarDataSet(List<T> list, String str) {
        super(list, str);
    }

    public int getFillColor() {
        return this.f54928a;
    }

    public void setFillColor(int i) {
        this.f54928a = i;
        this.mFillDrawable = null;
    }

    public Drawable getFillDrawable() {
        return this.mFillDrawable;
    }

    public void setFillDrawable(Drawable drawable) {
        this.mFillDrawable = drawable;
    }

    public int getFillAlpha() {
        return this.f54929b;
    }

    public void setFillAlpha(int i) {
        this.f54929b = i;
    }

    public void setLineWidth(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.f54930c = Utils.convertDpToPixel(f);
    }

    public float getLineWidth() {
        return this.f54930c;
    }

    public void setDrawFilled(boolean z) {
        this.f54931d = z;
    }

    public boolean isDrawFilledEnabled() {
        return this.f54931d;
    }

    /* access modifiers changed from: protected */
    public void copy(LineRadarDataSet lineRadarDataSet) {
        super.copy(lineRadarDataSet);
        lineRadarDataSet.f54931d = this.f54931d;
        lineRadarDataSet.f54929b = this.f54929b;
        lineRadarDataSet.f54928a = this.f54928a;
        lineRadarDataSet.mFillDrawable = this.mFillDrawable;
        lineRadarDataSet.f54930c = this.f54930c;
    }
}
