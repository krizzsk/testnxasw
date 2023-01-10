package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

public class StackedValueFormatter extends ValueFormatter {

    /* renamed from: a */
    private boolean f54959a;

    /* renamed from: b */
    private String f54960b;

    /* renamed from: c */
    private DecimalFormat f54961c;

    public StackedValueFormatter(boolean z, String str, int i) {
        this.f54959a = z;
        this.f54960b = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f54961c = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String getBarStackedLabel(float f, BarEntry barEntry) {
        float[] yVals;
        if (this.f54959a || (yVals = barEntry.getYVals()) == null) {
            return this.f54961c.format((double) f) + this.f54960b;
        } else if (yVals[yVals.length - 1] != f) {
            return "";
        } else {
            return this.f54961c.format((double) barEntry.getY()) + this.f54960b;
        }
    }
}
