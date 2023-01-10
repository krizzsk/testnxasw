package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.didi.sdk.apm.SystemUtils;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class AxisBase extends ComponentBase {

    /* renamed from: a */
    private int f54824a = -7829368;

    /* renamed from: b */
    private float f54825b = 1.0f;

    /* renamed from: c */
    private int f54826c = -7829368;

    /* renamed from: d */
    private float f54827d = 1.0f;

    /* renamed from: e */
    private int f54828e = 6;

    /* renamed from: f */
    private DashPathEffect f54829f = null;

    /* renamed from: g */
    private DashPathEffect f54830g = null;
    public float mAxisMaximum = 0.0f;
    public float mAxisMinimum = 0.0f;
    public float mAxisRange = 0.0f;
    protected ValueFormatter mAxisValueFormatter;
    protected boolean mCenterAxisLabels = false;
    public float[] mCenteredEntries = new float[0];
    protected boolean mCustomAxisMax = false;
    protected boolean mCustomAxisMin = false;
    public int mDecimals;
    protected boolean mDrawAxisLine = true;
    protected boolean mDrawGridLines = true;
    protected boolean mDrawGridLinesBehindData = true;
    protected boolean mDrawLabels = true;
    protected boolean mDrawLimitLineBehindData = false;
    public float[] mEntries = new float[0];
    public int mEntryCount;
    protected boolean mForceLabels = false;
    protected float mGranularity = 1.0f;
    protected boolean mGranularityEnabled = false;
    protected List<LimitLine> mLimitLines;
    protected float mSpaceMax = 0.0f;
    protected float mSpaceMin = 0.0f;

    public AxisBase() {
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(5.0f);
        this.mLimitLines = new ArrayList();
    }

    public void setDrawGridLines(boolean z) {
        this.mDrawGridLines = z;
    }

    public boolean isDrawGridLinesEnabled() {
        return this.mDrawGridLines;
    }

    public void setDrawAxisLine(boolean z) {
        this.mDrawAxisLine = z;
    }

    public boolean isDrawAxisLineEnabled() {
        return this.mDrawAxisLine;
    }

    public void setCenterAxisLabels(boolean z) {
        this.mCenterAxisLabels = z;
    }

    public boolean isCenterAxisLabelsEnabled() {
        return this.mCenterAxisLabels && this.mEntryCount > 0;
    }

    public void setGridColor(int i) {
        this.f54824a = i;
    }

    public int getGridColor() {
        return this.f54824a;
    }

    public void setAxisLineWidth(float f) {
        this.f54827d = Utils.convertDpToPixel(f);
    }

    public float getAxisLineWidth() {
        return this.f54827d;
    }

    public void setGridLineWidth(float f) {
        this.f54825b = Utils.convertDpToPixel(f);
    }

    public float getGridLineWidth() {
        return this.f54825b;
    }

    public void setAxisLineColor(int i) {
        this.f54826c = i;
    }

    public int getAxisLineColor() {
        return this.f54826c;
    }

    public void setDrawLabels(boolean z) {
        this.mDrawLabels = z;
    }

    public boolean isDrawLabelsEnabled() {
        return this.mDrawLabels;
    }

    public void setLabelCount(int i) {
        if (i > 25) {
            i = 25;
        }
        if (i < 2) {
            i = 2;
        }
        this.f54828e = i;
        this.mForceLabels = false;
    }

    public void setLabelCount(int i, boolean z) {
        setLabelCount(i);
        this.mForceLabels = z;
    }

    public boolean isForceLabelsEnabled() {
        return this.mForceLabels;
    }

    public int getLabelCount() {
        return this.f54828e;
    }

    public boolean isGranularityEnabled() {
        return this.mGranularityEnabled;
    }

    public void setGranularityEnabled(boolean z) {
        this.mGranularityEnabled = z;
    }

    public float getGranularity() {
        return this.mGranularity;
    }

    public void setGranularity(float f) {
        this.mGranularity = f;
        this.mGranularityEnabled = true;
    }

    public void addLimitLine(LimitLine limitLine) {
        this.mLimitLines.add(limitLine);
        if (this.mLimitLines.size() > 6) {
            SystemUtils.log(6, "MPAndroiChart", "Warning! You have more than 6 LimitLines on your axis, do you really want that?", (Throwable) null, "com.github.mikephil.charting.components.AxisBase", 406);
        }
    }

    public void removeLimitLine(LimitLine limitLine) {
        this.mLimitLines.remove(limitLine);
    }

    public void removeAllLimitLines() {
        this.mLimitLines.clear();
    }

    public List<LimitLine> getLimitLines() {
        return this.mLimitLines;
    }

    public void setDrawLimitLinesBehindData(boolean z) {
        this.mDrawLimitLineBehindData = z;
    }

    public boolean isDrawLimitLinesBehindDataEnabled() {
        return this.mDrawLimitLineBehindData;
    }

    public void setDrawGridLinesBehindData(boolean z) {
        this.mDrawGridLinesBehindData = z;
    }

    public boolean isDrawGridLinesBehindDataEnabled() {
        return this.mDrawGridLinesBehindData;
    }

    public String getLongestLabel() {
        String str = "";
        for (int i = 0; i < this.mEntries.length; i++) {
            String formattedLabel = getFormattedLabel(i);
            if (formattedLabel != null && str.length() < formattedLabel.length()) {
                str = formattedLabel;
            }
        }
        return str;
    }

    public String getFormattedLabel(int i) {
        return (i < 0 || i >= this.mEntries.length) ? "" : getValueFormatter().getAxisLabel(this.mEntries[i], this);
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        } else {
            this.mAxisValueFormatter = valueFormatter;
        }
    }

    public ValueFormatter getValueFormatter() {
        ValueFormatter valueFormatter = this.mAxisValueFormatter;
        if (valueFormatter == null || ((valueFormatter instanceof DefaultAxisValueFormatter) && ((DefaultAxisValueFormatter) valueFormatter).getDecimalDigits() != this.mDecimals)) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        }
        return this.mAxisValueFormatter;
    }

    public void enableGridDashedLine(float f, float f2, float f3) {
        this.f54830g = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void setGridDashedLine(DashPathEffect dashPathEffect) {
        this.f54830g = dashPathEffect;
    }

    public void disableGridDashedLine() {
        this.f54830g = null;
    }

    public boolean isGridDashedLineEnabled() {
        return this.f54830g != null;
    }

    public DashPathEffect getGridDashPathEffect() {
        return this.f54830g;
    }

    public void enableAxisLineDashedLine(float f, float f2, float f3) {
        this.f54829f = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void setAxisLineDashedLine(DashPathEffect dashPathEffect) {
        this.f54829f = dashPathEffect;
    }

    public void disableAxisLineDashedLine() {
        this.f54829f = null;
    }

    public boolean isAxisLineDashedLineEnabled() {
        return this.f54829f != null;
    }

    public DashPathEffect getAxisLineDashPathEffect() {
        return this.f54829f;
    }

    public float getAxisMaximum() {
        return this.mAxisMaximum;
    }

    public float getAxisMinimum() {
        return this.mAxisMinimum;
    }

    public void resetAxisMaximum() {
        this.mCustomAxisMax = false;
    }

    public boolean isAxisMaxCustom() {
        return this.mCustomAxisMax;
    }

    public void resetAxisMinimum() {
        this.mCustomAxisMin = false;
    }

    public boolean isAxisMinCustom() {
        return this.mCustomAxisMin;
    }

    public void setAxisMinimum(float f) {
        this.mCustomAxisMin = true;
        this.mAxisMinimum = f;
        this.mAxisRange = Math.abs(this.mAxisMaximum - f);
    }

    @Deprecated
    public void setAxisMinValue(float f) {
        setAxisMinimum(f);
    }

    public void setAxisMaximum(float f) {
        this.mCustomAxisMax = true;
        this.mAxisMaximum = f;
        this.mAxisRange = Math.abs(f - this.mAxisMinimum);
    }

    @Deprecated
    public void setAxisMaxValue(float f) {
        setAxisMaximum(f);
    }

    public void calculate(float f, float f2) {
        float f3 = this.mCustomAxisMin ? this.mAxisMinimum : f - this.mSpaceMin;
        float f4 = this.mCustomAxisMax ? this.mAxisMaximum : f2 + this.mSpaceMax;
        if (Math.abs(f4 - f3) == 0.0f) {
            f4 += 1.0f;
            f3 -= 1.0f;
        }
        this.mAxisMinimum = f3;
        this.mAxisMaximum = f4;
        this.mAxisRange = Math.abs(f4 - f3);
    }

    public float getSpaceMin() {
        return this.mSpaceMin;
    }

    public void setSpaceMin(float f) {
        this.mSpaceMin = f;
    }

    public float getSpaceMax() {
        return this.mSpaceMax;
    }

    public void setSpaceMax(float f) {
        this.mSpaceMax = f;
    }
}
