package com.didi.sdk.view.wheel;

import android.graphics.Canvas;
import android.graphics.Paint;

public class WheelItem {
    public static final int MARGIN = 5;
    public static final int TEXT_ALIGN_BOTTOM = 1048576;
    public static final int TEXT_ALIGN_CENTER_HORIZONTAL = 4096;
    public static final int TEXT_ALIGN_CENTER_VERTICAL = 256;
    public static final int TEXT_ALIGN_LEFT = 1;
    public static final int TEXT_ALIGN_RIGHT = 16;
    public static final int TEXT_ALIGN_TOP = 65536;

    /* renamed from: a */
    private Paint f41059a;

    /* renamed from: b */
    private int f41060b;

    /* renamed from: c */
    private float f41061c;

    /* renamed from: d */
    private float f41062d;

    /* renamed from: e */
    private float f41063e;

    /* renamed from: f */
    private float f41064f;

    /* renamed from: g */
    private float f41065g;

    /* renamed from: h */
    private String f41066h;

    /* renamed from: i */
    private int f41067i;

    public WheelItem(int i, int i2, int i3) {
        this.f41062d = (float) i;
        this.f41060b = i2;
        this.f41067i = i3;
    }

    public void setPaint(Paint paint) {
        this.f41059a = paint;
    }

    public String getTitle() {
        return this.f41066h;
    }

    public void setTitle(String str) {
        this.f41066h = str;
    }

    public float getTextCenterX() {
        return this.f41064f;
    }

    public void setTextCenterX(float f) {
        this.f41064f = f;
    }

    public float getTextBaselineY() {
        return this.f41065g;
    }

    public void setTextBaselineY(float f) {
        this.f41065g = f;
    }

    public float getWidth() {
        return this.f41062d;
    }

    public int getHeight() {
        return this.f41060b;
    }

    public float getLeft() {
        return this.f41061c;
    }

    public void setLeft(float f) {
        this.f41061c = f;
    }

    public float getRight() {
        return this.f41061c + this.f41062d;
    }

    public float getTop() {
        return this.f41063e;
    }

    public void setTop(float f) {
        this.f41063e = f;
    }

    public void draw(Canvas canvas) {
        String str = this.f41066h;
        float measureText = this.f41059a.measureText(str);
        int length = str.length();
        float f = this.f41062d - ((float) this.f41067i);
        do {
            if (measureText > f) {
                StringBuilder sb = new StringBuilder();
                length--;
                sb.append(str.substring(0, length));
                sb.append("...");
                str = sb.toString();
                measureText = this.f41059a.measureText(str);
            }
            if (measureText <= f) {
                break;
            }
        } while (length > 0);
        canvas.drawText(str, this.f41064f, this.f41063e + this.f41065g, this.f41059a);
    }
}
