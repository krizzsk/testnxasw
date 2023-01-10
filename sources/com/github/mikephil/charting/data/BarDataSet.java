package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;

public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {

    /* renamed from: a */
    private int f54882a = 1;

    /* renamed from: b */
    private int f54883b = Color.rgb(215, 215, 215);

    /* renamed from: c */
    private float f54884c = 0.0f;

    /* renamed from: d */
    private int f54885d = -16777216;

    /* renamed from: e */
    private int f54886e = 120;

    /* renamed from: f */
    private int f54887f = 0;

    /* renamed from: g */
    private String[] f54888g = {"Stack"};

    public BarDataSet(List<BarEntry> list, String str) {
        super(list, str);
        this.mHighLightColor = Color.rgb(0, 0, 0);
        m40691b(list);
        m40690a(list);
    }

    public DataSet<BarEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mValues.size(); i++) {
            arrayList.add(((BarEntry) this.mValues.get(i)).copy());
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, getLabel());
        copy(barDataSet);
        return barDataSet;
    }

    /* access modifiers changed from: protected */
    public void copy(BarDataSet barDataSet) {
        super.copy(barDataSet);
        barDataSet.f54882a = this.f54882a;
        barDataSet.f54883b = this.f54883b;
        barDataSet.f54884c = this.f54884c;
        barDataSet.f54888g = this.f54888g;
        barDataSet.f54886e = this.f54886e;
    }

    /* renamed from: a */
    private void m40690a(List<BarEntry> list) {
        this.f54887f = 0;
        for (int i = 0; i < list.size(); i++) {
            float[] yVals = list.get(i).getYVals();
            if (yVals == null) {
                this.f54887f++;
            } else {
                this.f54887f += yVals.length;
            }
        }
    }

    /* renamed from: b */
    private void m40691b(List<BarEntry> list) {
        for (int i = 0; i < list.size(); i++) {
            float[] yVals = list.get(i).getYVals();
            if (yVals != null && yVals.length > this.f54882a) {
                this.f54882a = yVals.length;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(BarEntry barEntry) {
        if (barEntry != null && !Float.isNaN(barEntry.getY())) {
            if (barEntry.getYVals() == null) {
                if (barEntry.getY() < this.mYMin) {
                    this.mYMin = barEntry.getY();
                }
                if (barEntry.getY() > this.mYMax) {
                    this.mYMax = barEntry.getY();
                }
            } else {
                if ((-barEntry.getNegativeSum()) < this.mYMin) {
                    this.mYMin = -barEntry.getNegativeSum();
                }
                if (barEntry.getPositiveSum() > this.mYMax) {
                    this.mYMax = barEntry.getPositiveSum();
                }
            }
            calcMinMaxX(barEntry);
        }
    }

    public int getStackSize() {
        return this.f54882a;
    }

    public boolean isStacked() {
        return this.f54882a > 1;
    }

    public int getEntryCountStacks() {
        return this.f54887f;
    }

    public void setBarShadowColor(int i) {
        this.f54883b = i;
    }

    public int getBarShadowColor() {
        return this.f54883b;
    }

    public void setBarBorderWidth(float f) {
        this.f54884c = f;
    }

    public float getBarBorderWidth() {
        return this.f54884c;
    }

    public void setBarBorderColor(int i) {
        this.f54885d = i;
    }

    public int getBarBorderColor() {
        return this.f54885d;
    }

    public void setHighLightAlpha(int i) {
        this.f54886e = i;
    }

    public int getHighLightAlpha() {
        return this.f54886e;
    }

    public void setStackLabels(String[] strArr) {
        this.f54888g = strArr;
    }

    public String[] getStackLabels() {
        return this.f54888g;
    }
}
