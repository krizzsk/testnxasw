package com.github.mikephil.charting.formatter;

import com.didi.raven.config.RavenKey;
import java.text.DecimalFormat;

public class LargeValueFormatter extends ValueFormatter {

    /* renamed from: a */
    private String[] f54954a;

    /* renamed from: b */
    private int f54955b;

    /* renamed from: c */
    private DecimalFormat f54956c;

    /* renamed from: d */
    private String f54957d;

    public int getDecimalDigits() {
        return 0;
    }

    public LargeValueFormatter() {
        this.f54954a = new String[]{"", "k", "m", "b", RavenKey.TYPE};
        this.f54955b = 5;
        this.f54957d = "";
        this.f54956c = new DecimalFormat("###E00");
    }

    public LargeValueFormatter(String str) {
        this();
        this.f54957d = str;
    }

    public String getFormattedValue(float f) {
        return m40696a((double) f) + this.f54957d;
    }

    public void setAppendix(String str) {
        this.f54957d = str;
    }

    public void setSuffix(String[] strArr) {
        this.f54954a = strArr;
    }

    public void setMaxLength(int i) {
        this.f54955b = i;
    }

    /* renamed from: a */
    private String m40696a(double d) {
        String format = this.f54956c.format(d);
        int numericValue = Character.getNumericValue(format.charAt(format.length() - 1));
        String replaceAll = format.replaceAll("E[0-9][0-9]", this.f54954a[Integer.valueOf(Character.getNumericValue(format.charAt(format.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            if (replaceAll.length() <= this.f54955b && !replaceAll.matches("[0-9]+\\.[a-z]")) {
                return replaceAll;
            }
            replaceAll = replaceAll.substring(0, replaceAll.length() - 2) + replaceAll.substring(replaceAll.length() - 1);
        }
    }
}
