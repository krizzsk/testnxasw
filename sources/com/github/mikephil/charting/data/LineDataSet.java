package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import com.didi.sdk.apm.SystemUtils;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {

    /* renamed from: a */
    private Mode f54918a = Mode.LINEAR;

    /* renamed from: b */
    private List<Integer> f54919b = null;

    /* renamed from: c */
    private int f54920c = -1;

    /* renamed from: d */
    private float f54921d = 8.0f;

    /* renamed from: e */
    private float f54922e = 4.0f;

    /* renamed from: f */
    private float f54923f = 0.2f;

    /* renamed from: g */
    private DashPathEffect f54924g = null;

    /* renamed from: h */
    private IFillFormatter f54925h = new DefaultFillFormatter();

    /* renamed from: i */
    private boolean f54926i = true;

    /* renamed from: j */
    private boolean f54927j = true;

    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        if (this.f54919b == null) {
            this.f54919b = new ArrayList();
        }
        this.f54919b.clear();
        this.f54919b.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mValues.size(); i++) {
            arrayList.add(((Entry) this.mValues.get(i)).copy());
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, getLabel());
        copy(lineDataSet);
        return lineDataSet;
    }

    /* access modifiers changed from: protected */
    public void copy(LineDataSet lineDataSet) {
        super.copy(lineDataSet);
        lineDataSet.f54919b = this.f54919b;
        lineDataSet.f54920c = this.f54920c;
        lineDataSet.f54922e = this.f54922e;
        lineDataSet.f54921d = this.f54921d;
        lineDataSet.f54923f = this.f54923f;
        lineDataSet.f54924g = this.f54924g;
        lineDataSet.f54927j = this.f54927j;
        lineDataSet.f54926i = this.f54927j;
        lineDataSet.f54925h = this.f54925h;
        lineDataSet.f54918a = this.f54918a;
    }

    public Mode getMode() {
        return this.f54918a;
    }

    public void setMode(Mode mode) {
        this.f54918a = mode;
    }

    public void setCubicIntensity(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f < 0.05f) {
            f = 0.05f;
        }
        this.f54923f = f;
    }

    public float getCubicIntensity() {
        return this.f54923f;
    }

    public void setCircleRadius(float f) {
        if (f >= 1.0f) {
            this.f54921d = Utils.convertDpToPixel(f);
        } else {
            SystemUtils.log(6, "LineDataSet", "Circle radius cannot be < 1", (Throwable) null, "com.github.mikephil.charting.data.LineDataSet", 162);
        }
    }

    public float getCircleRadius() {
        return this.f54921d;
    }

    public void setCircleHoleRadius(float f) {
        if (f >= 0.5f) {
            this.f54922e = Utils.convertDpToPixel(f);
        } else {
            SystemUtils.log(6, "LineDataSet", "Circle radius cannot be < 0.5", (Throwable) null, "com.github.mikephil.charting.data.LineDataSet", 182);
        }
    }

    public float getCircleHoleRadius() {
        return this.f54922e;
    }

    @Deprecated
    public void setCircleSize(float f) {
        setCircleRadius(f);
    }

    @Deprecated
    public float getCircleSize() {
        return getCircleRadius();
    }

    public void enableDashedLine(float f, float f2, float f3) {
        this.f54924g = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void disableDashedLine() {
        this.f54924g = null;
    }

    public boolean isDashedLineEnabled() {
        return this.f54924g != null;
    }

    public DashPathEffect getDashPathEffect() {
        return this.f54924g;
    }

    public void setDrawCircles(boolean z) {
        this.f54926i = z;
    }

    public boolean isDrawCirclesEnabled() {
        return this.f54926i;
    }

    @Deprecated
    public boolean isDrawCubicEnabled() {
        return this.f54918a == Mode.CUBIC_BEZIER;
    }

    @Deprecated
    public boolean isDrawSteppedEnabled() {
        return this.f54918a == Mode.STEPPED;
    }

    public List<Integer> getCircleColors() {
        return this.f54919b;
    }

    public int getCircleColor(int i) {
        return this.f54919b.get(i).intValue();
    }

    public int getCircleColorCount() {
        return this.f54919b.size();
    }

    public void setCircleColors(List<Integer> list) {
        this.f54919b = list;
    }

    public void setCircleColors(int... iArr) {
        this.f54919b = ColorTemplate.createColors(iArr);
    }

    public void setCircleColors(int[] iArr, Context context) {
        List<Integer> list = this.f54919b;
        if (list == null) {
            list = new ArrayList<>();
        }
        list.clear();
        for (int color : iArr) {
            list.add(Integer.valueOf(context.getResources().getColor(color)));
        }
        this.f54919b = list;
    }

    public void setCircleColor(int i) {
        resetCircleColors();
        this.f54919b.add(Integer.valueOf(i));
    }

    public void resetCircleColors() {
        if (this.f54919b == null) {
            this.f54919b = new ArrayList();
        }
        this.f54919b.clear();
    }

    public void setCircleHoleColor(int i) {
        this.f54920c = i;
    }

    public int getCircleHoleColor() {
        return this.f54920c;
    }

    public void setDrawCircleHole(boolean z) {
        this.f54927j = z;
    }

    public boolean isDrawCircleHoleEnabled() {
        return this.f54927j;
    }

    public void setFillFormatter(IFillFormatter iFillFormatter) {
        if (iFillFormatter == null) {
            this.f54925h = new DefaultFillFormatter();
        } else {
            this.f54925h = iFillFormatter;
        }
    }

    public IFillFormatter getFillFormatter() {
        return this.f54925h;
    }
}
