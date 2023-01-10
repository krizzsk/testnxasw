package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

public class LimitLine extends ComponentBase {

    /* renamed from: a */
    private float f54856a = 0.0f;

    /* renamed from: b */
    private float f54857b = 2.0f;

    /* renamed from: c */
    private int f54858c = Color.rgb(237, 91, 91);

    /* renamed from: d */
    private Paint.Style f54859d = Paint.Style.FILL_AND_STROKE;

    /* renamed from: e */
    private String f54860e = "";

    /* renamed from: f */
    private DashPathEffect f54861f = null;

    /* renamed from: g */
    private LimitLabelPosition f54862g = LimitLabelPosition.RIGHT_TOP;

    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public LimitLine(float f) {
        this.f54856a = f;
    }

    public LimitLine(float f, String str) {
        this.f54856a = f;
        this.f54860e = str;
    }

    public float getLimit() {
        return this.f54856a;
    }

    public void setLineWidth(float f) {
        if (f < 0.2f) {
            f = 0.2f;
        }
        if (f > 12.0f) {
            f = 12.0f;
        }
        this.f54857b = Utils.convertDpToPixel(f);
    }

    public float getLineWidth() {
        return this.f54857b;
    }

    public void setLineColor(int i) {
        this.f54858c = i;
    }

    public int getLineColor() {
        return this.f54858c;
    }

    public void enableDashedLine(float f, float f2, float f3) {
        this.f54861f = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void disableDashedLine() {
        this.f54861f = null;
    }

    public boolean isDashedLineEnabled() {
        return this.f54861f != null;
    }

    public DashPathEffect getDashPathEffect() {
        return this.f54861f;
    }

    public void setTextStyle(Paint.Style style) {
        this.f54859d = style;
    }

    public Paint.Style getTextStyle() {
        return this.f54859d;
    }

    public void setLabelPosition(LimitLabelPosition limitLabelPosition) {
        this.f54862g = limitLabelPosition;
    }

    public LimitLabelPosition getLabelPosition() {
        return this.f54862g;
    }

    public void setLabel(String str) {
        this.f54860e = str;
    }

    public String getLabel() {
        return this.f54860e;
    }
}
