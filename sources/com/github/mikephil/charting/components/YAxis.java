package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

public class YAxis extends AxisBase {

    /* renamed from: a */
    private boolean f54875a;

    /* renamed from: b */
    private boolean f54876b;

    /* renamed from: c */
    private boolean f54877c;

    /* renamed from: d */
    private boolean f54878d;

    /* renamed from: e */
    private YAxisLabelPosition f54879e;

    /* renamed from: f */
    private AxisDependency f54880f;
    protected boolean mDrawZeroLine;
    protected boolean mInverted;
    protected float mMaxWidth;
    protected float mMinWidth;
    protected float mSpacePercentBottom;
    protected float mSpacePercentTop;
    protected int mZeroLineColor;
    protected float mZeroLineWidth;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.f54875a = true;
        this.f54876b = true;
        this.mInverted = false;
        this.mDrawZeroLine = false;
        this.f54877c = false;
        this.f54878d = false;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.f54879e = YAxisLabelPosition.OUTSIDE_CHART;
        this.mMinWidth = 0.0f;
        this.mMaxWidth = Float.POSITIVE_INFINITY;
        this.f54880f = AxisDependency.LEFT;
        this.mYOffset = 0.0f;
    }

    public YAxis(AxisDependency axisDependency) {
        this.f54875a = true;
        this.f54876b = true;
        this.mInverted = false;
        this.mDrawZeroLine = false;
        this.f54877c = false;
        this.f54878d = false;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.f54879e = YAxisLabelPosition.OUTSIDE_CHART;
        this.mMinWidth = 0.0f;
        this.mMaxWidth = Float.POSITIVE_INFINITY;
        this.f54880f = axisDependency;
        this.mYOffset = 0.0f;
    }

    public AxisDependency getAxisDependency() {
        return this.f54880f;
    }

    public float getMinWidth() {
        return this.mMinWidth;
    }

    public void setMinWidth(float f) {
        this.mMinWidth = f;
    }

    public float getMaxWidth() {
        return this.mMaxWidth;
    }

    public void setMaxWidth(float f) {
        this.mMaxWidth = f;
    }

    public YAxisLabelPosition getLabelPosition() {
        return this.f54879e;
    }

    public void setPosition(YAxisLabelPosition yAxisLabelPosition) {
        this.f54879e = yAxisLabelPosition;
    }

    public boolean isDrawTopYLabelEntryEnabled() {
        return this.f54876b;
    }

    public boolean isDrawBottomYLabelEntryEnabled() {
        return this.f54875a;
    }

    public void setDrawTopYLabelEntry(boolean z) {
        this.f54876b = z;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    public boolean isInverted() {
        return this.mInverted;
    }

    @Deprecated
    public void setStartAtZero(boolean z) {
        if (z) {
            setAxisMinimum(0.0f);
        } else {
            resetAxisMinimum();
        }
    }

    public void setSpaceTop(float f) {
        this.mSpacePercentTop = f;
    }

    public float getSpaceTop() {
        return this.mSpacePercentTop;
    }

    public void setSpaceBottom(float f) {
        this.mSpacePercentBottom = f;
    }

    public float getSpaceBottom() {
        return this.mSpacePercentBottom;
    }

    public boolean isDrawZeroLineEnabled() {
        return this.mDrawZeroLine;
    }

    public void setDrawZeroLine(boolean z) {
        this.mDrawZeroLine = z;
    }

    public int getZeroLineColor() {
        return this.mZeroLineColor;
    }

    public void setZeroLineColor(int i) {
        this.mZeroLineColor = i;
    }

    public float getZeroLineWidth() {
        return this.mZeroLineWidth;
    }

    public void setZeroLineWidth(float f) {
        this.mZeroLineWidth = Utils.convertDpToPixel(f);
    }

    public float getRequiredWidthSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        float calcTextWidth = ((float) Utils.calcTextWidth(paint, getLongestLabel())) + (getXOffset() * 2.0f);
        float minWidth = getMinWidth();
        float maxWidth = getMaxWidth();
        if (minWidth > 0.0f) {
            minWidth = Utils.convertDpToPixel(minWidth);
        }
        if (maxWidth > 0.0f && maxWidth != Float.POSITIVE_INFINITY) {
            maxWidth = Utils.convertDpToPixel(maxWidth);
        }
        if (((double) maxWidth) <= 0.0d) {
            maxWidth = calcTextWidth;
        }
        return Math.max(minWidth, Math.min(calcTextWidth, maxWidth));
    }

    public float getRequiredHeightSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        return ((float) Utils.calcTextHeight(paint, getLongestLabel())) + (getYOffset() * 2.0f);
    }

    public boolean needsOffset() {
        return isEnabled() && isDrawLabelsEnabled() && getLabelPosition() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    @Deprecated
    public boolean isUseAutoScaleMinRestriction() {
        return this.f54877c;
    }

    @Deprecated
    public void setUseAutoScaleMinRestriction(boolean z) {
        this.f54877c = z;
    }

    @Deprecated
    public boolean isUseAutoScaleMaxRestriction() {
        return this.f54878d;
    }

    @Deprecated
    public void setUseAutoScaleMaxRestriction(boolean z) {
        this.f54878d = z;
    }

    public void calculate(float f, float f2) {
        if (Math.abs(f2 - f) == 0.0f) {
            f2 += 1.0f;
            f -= 1.0f;
        }
        float abs = Math.abs(f2 - f);
        this.mAxisMinimum = this.mCustomAxisMin ? this.mAxisMinimum : f - ((abs / 100.0f) * getSpaceBottom());
        this.mAxisMaximum = this.mCustomAxisMax ? this.mAxisMaximum : f2 + ((abs / 100.0f) * getSpaceTop());
        this.mAxisRange = Math.abs(this.mAxisMinimum - this.mAxisMaximum);
    }
}
