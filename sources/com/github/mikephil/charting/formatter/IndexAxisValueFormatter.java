package com.github.mikephil.charting.formatter;

import java.util.Collection;

public class IndexAxisValueFormatter extends ValueFormatter {

    /* renamed from: a */
    private String[] f54952a = new String[0];

    /* renamed from: b */
    private int f54953b = 0;

    public IndexAxisValueFormatter() {
    }

    public IndexAxisValueFormatter(String[] strArr) {
        if (strArr != null) {
            setValues(strArr);
        }
    }

    public IndexAxisValueFormatter(Collection<String> collection) {
        if (collection != null) {
            setValues((String[]) collection.toArray(new String[collection.size()]));
        }
    }

    public String getFormattedValue(float f) {
        int round = Math.round(f);
        return (round < 0 || round >= this.f54953b || round != ((int) f)) ? "" : this.f54952a[round];
    }

    public String[] getValues() {
        return this.f54952a;
    }

    public void setValues(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.f54952a = strArr;
        this.f54953b = strArr.length;
    }
}
