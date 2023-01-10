package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class PieChart extends PieRadarChartBase<PieData> {

    /* renamed from: a */
    private RectF f54796a = new RectF();

    /* renamed from: b */
    private boolean f54797b = true;

    /* renamed from: c */
    private float[] f54798c = new float[1];

    /* renamed from: d */
    private float[] f54799d = new float[1];

    /* renamed from: e */
    private boolean f54800e = true;

    /* renamed from: f */
    private boolean f54801f = false;

    /* renamed from: g */
    private boolean f54802g = false;

    /* renamed from: h */
    private boolean f54803h = false;

    /* renamed from: i */
    private CharSequence f54804i = "";

    /* renamed from: j */
    private MPPointF f54805j = MPPointF.getInstance(0.0f, 0.0f);

    /* renamed from: k */
    private float f54806k = 50.0f;

    /* renamed from: l */
    private boolean f54807l = true;

    /* renamed from: m */
    private float f54808m = 100.0f;
    protected float mMaxAngle = 360.0f;
    protected float mTransparentCircleRadiusPercent = 55.0f;

    /* renamed from: n */
    private float f54809n = 0.0f;

    /* access modifiers changed from: protected */
    public float getRequiredBaseOffset() {
        return 0.0f;
    }

    public PieChart(Context context) {
        super(context);
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxis = null;
        this.mHighlighter = new PieHighlighter(this);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData != null) {
            this.mRenderer.drawData(canvas);
            if (valuesToHighlight()) {
                this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
            }
            this.mRenderer.drawExtras(canvas);
            this.mRenderer.drawValues(canvas);
            this.mLegendRenderer.renderLegend(canvas);
            drawDescription(canvas);
            drawMarkers(canvas);
        }
    }

    public void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData != null) {
            float diameter = getDiameter() / 2.0f;
            MPPointF centerOffsets = getCenterOffsets();
            float selectionShift = ((PieData) this.mData).getDataSet().getSelectionShift();
            this.f54796a.set((centerOffsets.f55042x - diameter) + selectionShift, (centerOffsets.f55043y - diameter) + selectionShift, (centerOffsets.f55042x + diameter) - selectionShift, (centerOffsets.f55043y + diameter) - selectionShift);
            MPPointF.recycleInstance(centerOffsets);
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMax() {
        m40689a();
    }

    /* access modifiers changed from: protected */
    public float[] getMarkerPosition(Highlight highlight) {
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f = (radius / 10.0f) * 3.6f;
        if (isDrawHoleEnabled()) {
            f = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f2 = radius - f;
        float rotationAngle = getRotationAngle();
        int x = (int) highlight.getX();
        float f3 = this.f54798c[x] / 2.0f;
        double d = (double) f2;
        float cos = (float) ((Math.cos(Math.toRadians((double) (((this.f54799d[x] + rotationAngle) - f3) * this.mAnimator.getPhaseY()))) * d) + ((double) centerCircleBox.f55042x));
        MPPointF.recycleInstance(centerCircleBox);
        return new float[]{cos, (float) ((d * Math.sin(Math.toRadians((double) (((rotationAngle + this.f54799d[x]) - f3) * this.mAnimator.getPhaseY())))) + ((double) centerCircleBox.f55043y))};
    }

    /* renamed from: a */
    private void m40689a() {
        int entryCount = ((PieData) this.mData).getEntryCount();
        if (this.f54798c.length != entryCount) {
            this.f54798c = new float[entryCount];
        } else {
            for (int i = 0; i < entryCount; i++) {
                this.f54798c[i] = 0.0f;
            }
        }
        if (this.f54799d.length != entryCount) {
            this.f54799d = new float[entryCount];
        } else {
            for (int i2 = 0; i2 < entryCount; i2++) {
                this.f54799d[i2] = 0.0f;
            }
        }
        float yValueSum = ((PieData) this.mData).getYValueSum();
        List dataSets = ((PieData) this.mData).getDataSets();
        float f = this.f54809n;
        boolean z = f != 0.0f && ((float) entryCount) * f <= this.mMaxAngle;
        float[] fArr = new float[entryCount];
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i3 = 0;
        for (int i4 = 0; i4 < ((PieData) this.mData).getDataSetCount(); i4++) {
            IPieDataSet iPieDataSet = (IPieDataSet) dataSets.get(i4);
            for (int i5 = 0; i5 < iPieDataSet.getEntryCount(); i5++) {
                float a = m40688a(Math.abs(((PieEntry) iPieDataSet.getEntryForIndex(i5)).getY()), yValueSum);
                if (z) {
                    float f4 = this.f54809n;
                    float f5 = a - f4;
                    if (f5 <= 0.0f) {
                        fArr[i3] = f4;
                        f2 += -f5;
                    } else {
                        fArr[i3] = a;
                        f3 += f5;
                    }
                }
                float[] fArr2 = this.f54798c;
                fArr2[i3] = a;
                if (i3 == 0) {
                    this.f54799d[i3] = fArr2[i3];
                } else {
                    float[] fArr3 = this.f54799d;
                    fArr3[i3] = fArr3[i3 - 1] + fArr2[i3];
                }
                i3++;
            }
        }
        if (z) {
            for (int i6 = 0; i6 < entryCount; i6++) {
                fArr[i6] = fArr[i6] - (((fArr[i6] - this.f54809n) / f3) * f2);
                if (i6 == 0) {
                    this.f54799d[0] = fArr[0];
                } else {
                    float[] fArr4 = this.f54799d;
                    fArr4[i6] = fArr4[i6 - 1] + fArr[i6];
                }
            }
            this.f54798c = fArr;
        }
    }

    public boolean needsHighlight(int i) {
        if (!valuesToHighlight()) {
            return false;
        }
        for (Highlight x : this.mIndicesToHighlight) {
            if (((int) x.getX()) == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private float m40687a(float f) {
        return m40688a(f, ((PieData) this.mData).getYValueSum());
    }

    /* renamed from: a */
    private float m40688a(float f, float f2) {
        return (f / f2) * this.mMaxAngle;
    }

    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    public int getIndexForAngle(float f) {
        float normalizedAngle = Utils.getNormalizedAngle(f - getRotationAngle());
        int i = 0;
        while (true) {
            float[] fArr = this.f54799d;
            if (i >= fArr.length) {
                return -1;
            }
            if (fArr[i] > normalizedAngle) {
                return i;
            }
            i++;
        }
    }

    public int getDataSetIndexForIndex(int i) {
        List dataSets = ((PieData) this.mData).getDataSets();
        for (int i2 = 0; i2 < dataSets.size(); i2++) {
            if (((IPieDataSet) dataSets.get(i2)).getEntryForXValue((float) i, Float.NaN) != null) {
                return i2;
            }
        }
        return -1;
    }

    public float[] getDrawAngles() {
        return this.f54798c;
    }

    public float[] getAbsoluteAngles() {
        return this.f54799d;
    }

    public void setHoleColor(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintHole().setColor(i);
    }

    public void setDrawSlicesUnderHole(boolean z) {
        this.f54801f = z;
    }

    public boolean isDrawSlicesUnderHoleEnabled() {
        return this.f54801f;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.f54800e = z;
    }

    public boolean isDrawHoleEnabled() {
        return this.f54800e;
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.f54804i = "";
        } else {
            this.f54804i = charSequence;
        }
    }

    public CharSequence getCenterText() {
        return this.f54804i;
    }

    public void setDrawCenterText(boolean z) {
        this.f54807l = z;
    }

    public boolean isDrawCenterTextEnabled() {
        return this.f54807l;
    }

    /* access modifiers changed from: protected */
    public float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 2.0f;
    }

    public float getRadius() {
        RectF rectF = this.f54796a;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.f54796a.height() / 2.0f);
    }

    public RectF getCircleBox() {
        return this.f54796a;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.getInstance(this.f54796a.centerX(), this.f54796a.centerY());
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTypeface(typeface);
    }

    public void setCenterTextSize(float f) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(Utils.convertDpToPixel(f));
    }

    public void setCenterTextSizePixels(float f) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(f);
    }

    public void setCenterTextOffset(float f, float f2) {
        this.f54805j.f55042x = Utils.convertDpToPixel(f);
        this.f54805j.f55043y = Utils.convertDpToPixel(f2);
    }

    public MPPointF getCenterTextOffset() {
        return MPPointF.getInstance(this.f54805j.f55042x, this.f54805j.f55043y);
    }

    public void setCenterTextColor(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setColor(i);
    }

    public void setHoleRadius(float f) {
        this.f54806k = f;
    }

    public float getHoleRadius() {
        return this.f54806k;
    }

    public void setTransparentCircleColor(int i) {
        Paint paintTransparentCircle = ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle();
        int alpha = paintTransparentCircle.getAlpha();
        paintTransparentCircle.setColor(i);
        paintTransparentCircle.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f) {
        this.mTransparentCircleRadiusPercent = f;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    public void setTransparentCircleAlpha(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle().setAlpha(i);
    }

    @Deprecated
    public void setDrawSliceText(boolean z) {
        this.f54797b = z;
    }

    public void setDrawEntryLabels(boolean z) {
        this.f54797b = z;
    }

    public boolean isDrawEntryLabelsEnabled() {
        return this.f54797b;
    }

    public void setEntryLabelColor(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setColor(i);
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTypeface(typeface);
    }

    public void setEntryLabelTextSize(float f) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTextSize(Utils.convertDpToPixel(f));
    }

    public void setDrawRoundedSlices(boolean z) {
        this.f54803h = z;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.f54803h;
    }

    public void setUsePercentValues(boolean z) {
        this.f54802g = z;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.f54802g;
    }

    public void setCenterTextRadiusPercent(float f) {
        this.f54808m = f;
    }

    public float getCenterTextRadiusPercent() {
        return this.f54808m;
    }

    public float getMaxAngle() {
        return this.mMaxAngle;
    }

    public void setMaxAngle(float f) {
        if (f > 360.0f) {
            f = 360.0f;
        }
        if (f < 90.0f) {
            f = 90.0f;
        }
        this.mMaxAngle = f;
    }

    public float getMinAngleForSlices() {
        return this.f54809n;
    }

    public void setMinAngleForSlices(float f) {
        float f2 = this.mMaxAngle;
        if (f > f2 / 2.0f) {
            f = f2 / 2.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f54809n = f;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.mRenderer != null && (this.mRenderer instanceof PieChartRenderer)) {
            ((PieChartRenderer) this.mRenderer).releaseBitmap();
        }
        super.onDetachedFromWindow();
    }
}
