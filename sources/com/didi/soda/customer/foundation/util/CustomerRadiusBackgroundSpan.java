package com.didi.soda.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class CustomerRadiusBackgroundSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f43797a;

    /* renamed from: b */
    private int f43798b;

    /* renamed from: c */
    private int f43799c;

    /* renamed from: d */
    private int f43800d;

    /* renamed from: e */
    private int f43801e;

    /* renamed from: f */
    private int f43802f;

    /* renamed from: g */
    private int f43803g;

    public CustomerRadiusBackgroundSpan(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f43802f = i;
        this.f43798b = i2;
        this.f43800d = i4;
        this.f43801e = i5;
        this.f43799c = i3;
        this.f43803g = i6;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.setTextSize((float) this.f43802f);
        int measureText = (int) (paint.measureText(charSequence, i, i2) + ((float) (this.f43801e * 2)));
        this.f43797a = measureText;
        return measureText;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2 = f;
        Paint paint2 = paint;
        paint2.setColor(this.f43799c);
        paint2.setAntiAlias(true);
        RectF rectF = new RectF(f, (float) (this.f43800d + i3), ((float) this.f43797a) + f2, (float) this.f43803g);
        int i6 = this.f43800d;
        Canvas canvas2 = canvas;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint2);
        paint2.setColor(this.f43798b);
        paint2.setTextSize((float) this.f43802f);
        canvas.drawText(charSequence, i, i2, f2 + ((float) this.f43801e), (float) i4, paint2);
    }
}
