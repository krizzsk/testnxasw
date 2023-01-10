package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class XAxisRendererRadarChart extends XAxisRenderer {

    /* renamed from: b */
    private RadarChart f55033b;

    public void renderLimitLines(Canvas canvas) {
    }

    public XAxisRendererRadarChart(ViewPortHandler viewPortHandler, XAxis xAxis, RadarChart radarChart) {
        super(viewPortHandler, xAxis, (Transformer) null);
        this.f55033b = radarChart;
    }

    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float labelRotationAngle = this.mXAxis.getLabelRotationAngle();
            MPPointF instance = MPPointF.getInstance(0.5f, 0.25f);
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            float sliceAngle = this.f55033b.getSliceAngle();
            float factor = this.f55033b.getFactor();
            MPPointF centerOffsets = this.f55033b.getCenterOffsets();
            MPPointF instance2 = MPPointF.getInstance(0.0f, 0.0f);
            for (int i = 0; i < ((IRadarDataSet) ((RadarData) this.f55033b.getData()).getMaxEntryCountSet()).getEntryCount(); i++) {
                float f = (float) i;
                String axisLabel = this.mXAxis.getValueFormatter().getAxisLabel(f, this.mXAxis);
                Utils.getPosition(centerOffsets, (this.f55033b.getYRange() * factor) + (((float) this.mXAxis.mLabelRotatedWidth) / 2.0f), ((f * sliceAngle) + this.f55033b.getRotationAngle()) % 360.0f, instance2);
                drawLabel(canvas, axisLabel, instance2.f55042x, instance2.f55043y - (((float) this.mXAxis.mLabelRotatedHeight) / 2.0f), instance, labelRotationAngle);
            }
            MPPointF.recycleInstance(centerOffsets);
            MPPointF.recycleInstance(instance2);
            MPPointF.recycleInstance(instance);
        }
    }
}
