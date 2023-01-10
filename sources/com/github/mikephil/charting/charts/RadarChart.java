package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.highlight.RadarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;

public class RadarChart extends PieRadarChartBase<RadarData> {

    /* renamed from: a */
    private float f54815a = 2.5f;

    /* renamed from: b */
    private float f54816b = 1.5f;

    /* renamed from: c */
    private int f54817c = Color.rgb(122, 122, 122);

    /* renamed from: d */
    private int f54818d = Color.rgb(122, 122, 122);

    /* renamed from: e */
    private int f54819e = 150;

    /* renamed from: f */
    private boolean f54820f = true;

    /* renamed from: g */
    private int f54821g = 0;

    /* renamed from: h */
    private YAxis f54822h;
    protected XAxisRendererRadarChart mXAxisRenderer;
    protected YAxisRendererRadarChart mYAxisRenderer;

    public RadarChart(Context context) {
        super(context);
    }

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.f54822h = new YAxis(YAxis.AxisDependency.LEFT);
        this.f54815a = Utils.convertDpToPixel(1.5f);
        this.f54816b = Utils.convertDpToPixel(0.75f);
        this.mRenderer = new RadarChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mYAxisRenderer = new YAxisRendererRadarChart(this.mViewPortHandler, this.f54822h, this);
        this.mXAxisRenderer = new XAxisRendererRadarChart(this.mViewPortHandler, this.mXAxis, this);
        this.mHighlighter = new RadarHighlighter(this);
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        super.calcMinMax();
        this.f54822h.calculate(((RadarData) this.mData).getYMin(YAxis.AxisDependency.LEFT), ((RadarData) this.mData).getYMax(YAxis.AxisDependency.LEFT));
        this.mXAxis.calculate(0.0f, (float) ((IRadarDataSet) ((RadarData) this.mData).getMaxEntryCountSet()).getEntryCount());
    }

    public void notifyDataSetChanged() {
        if (this.mData != null) {
            calcMinMax();
            this.mYAxisRenderer.computeAxis(this.f54822h.mAxisMinimum, this.f54822h.mAxisMaximum, this.f54822h.isInverted());
            this.mXAxisRenderer.computeAxis(this.mXAxis.mAxisMinimum, this.mXAxis.mAxisMaximum, false);
            if (this.mLegend != null && !this.mLegend.isLegendCustom()) {
                this.mLegendRenderer.computeLegend(this.mData);
            }
            calculateOffsets();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData != null) {
            if (this.mXAxis.isEnabled()) {
                this.mXAxisRenderer.computeAxis(this.mXAxis.mAxisMinimum, this.mXAxis.mAxisMaximum, false);
            }
            this.mXAxisRenderer.renderAxisLabels(canvas);
            if (this.f54820f) {
                this.mRenderer.drawExtras(canvas);
            }
            if (this.f54822h.isEnabled() && this.f54822h.isDrawLimitLinesBehindDataEnabled()) {
                this.mYAxisRenderer.renderLimitLines(canvas);
            }
            this.mRenderer.drawData(canvas);
            if (valuesToHighlight()) {
                this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
            }
            if (this.f54822h.isEnabled() && !this.f54822h.isDrawLimitLinesBehindDataEnabled()) {
                this.mYAxisRenderer.renderLimitLines(canvas);
            }
            this.mYAxisRenderer.renderAxisLabels(canvas);
            this.mRenderer.drawValues(canvas);
            this.mLegendRenderer.renderLegend(canvas);
            drawDescription(canvas);
            drawMarkers(canvas);
        }
    }

    public float getFactor() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        return Math.min(contentRect.width() / 2.0f, contentRect.height() / 2.0f) / this.f54822h.mAxisRange;
    }

    public float getSliceAngle() {
        return 360.0f / ((float) ((IRadarDataSet) ((RadarData) this.mData).getMaxEntryCountSet()).getEntryCount());
    }

    public int getIndexForAngle(float f) {
        float normalizedAngle = Utils.getNormalizedAngle(f - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int entryCount = ((IRadarDataSet) ((RadarData) this.mData).getMaxEntryCountSet()).getEntryCount();
        int i = 0;
        while (i < entryCount) {
            int i2 = i + 1;
            if ((((float) i2) * sliceAngle) - (sliceAngle / 2.0f) > normalizedAngle) {
                return i;
            }
            i = i2;
        }
        return 0;
    }

    public YAxis getYAxis() {
        return this.f54822h;
    }

    public void setWebLineWidth(float f) {
        this.f54815a = Utils.convertDpToPixel(f);
    }

    public float getWebLineWidth() {
        return this.f54815a;
    }

    public void setWebLineWidthInner(float f) {
        this.f54816b = Utils.convertDpToPixel(f);
    }

    public float getWebLineWidthInner() {
        return this.f54816b;
    }

    public void setWebAlpha(int i) {
        this.f54819e = i;
    }

    public int getWebAlpha() {
        return this.f54819e;
    }

    public void setWebColor(int i) {
        this.f54817c = i;
    }

    public int getWebColor() {
        return this.f54817c;
    }

    public void setWebColorInner(int i) {
        this.f54818d = i;
    }

    public int getWebColorInner() {
        return this.f54818d;
    }

    public void setDrawWeb(boolean z) {
        this.f54820f = z;
    }

    public void setSkipWebLineCount(int i) {
        this.f54821g = Math.max(0, i);
    }

    public int getSkipWebLineCount() {
        return this.f54821g;
    }

    /* access modifiers changed from: protected */
    public float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 4.0f;
    }

    /* access modifiers changed from: protected */
    public float getRequiredBaseOffset() {
        if (!this.mXAxis.isEnabled() || !this.mXAxis.isDrawLabelsEnabled()) {
            return Utils.convertDpToPixel(10.0f);
        }
        return (float) this.mXAxis.mLabelRotatedWidth;
    }

    public float getRadius() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        return Math.min(contentRect.width() / 2.0f, contentRect.height() / 2.0f);
    }

    public float getYChartMax() {
        return this.f54822h.mAxisMaximum;
    }

    public float getYChartMin() {
        return this.f54822h.mAxisMinimum;
    }

    public float getYRange() {
        return this.f54822h.mAxisRange;
    }
}
