package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

public class PercentFormatter extends ValueFormatter {

    /* renamed from: a */
    private PieChart f54958a;
    public DecimalFormat mFormat;

    public PercentFormatter() {
        this.mFormat = new DecimalFormat("###,###,##0.0");
    }

    public PercentFormatter(PieChart pieChart) {
        this();
        this.f54958a = pieChart;
    }

    public String getFormattedValue(float f) {
        return this.mFormat.format((double) f) + " %";
    }

    public String getPieLabel(float f, PieEntry pieEntry) {
        PieChart pieChart = this.f54958a;
        if (pieChart == null || !pieChart.isUsePercentValuesEnabled()) {
            return this.mFormat.format((double) f);
        }
        return getFormattedValue(f);
    }
}
