package com.didi.entrega.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class CustomerRadiusBackgroundSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f21960a;

    /* renamed from: b */
    private int f21961b;

    /* renamed from: c */
    private int f21962c;

    /* renamed from: d */
    private int f21963d;

    /* renamed from: e */
    private int f21964e;

    /* renamed from: f */
    private int f21965f;

    /* renamed from: g */
    private int f21966g;

    public CustomerRadiusBackgroundSpan(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f21965f = i;
        this.f21961b = i2;
        this.f21963d = i4;
        this.f21964e = i5;
        this.f21962c = i3;
        this.f21966g = i6;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.setTextSize((float) this.f21965f);
        int measureText = (int) (paint.measureText(charSequence, i, i2) + ((float) (this.f21964e * 2)));
        this.f21960a = measureText;
        return measureText;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2 = f;
        Paint paint2 = paint;
        paint2.setColor(this.f21962c);
        paint2.setAntiAlias(true);
        RectF rectF = new RectF(f, (float) (this.f21963d + i3), ((float) this.f21960a) + f2, (float) this.f21966g);
        int i6 = this.f21963d;
        Canvas canvas2 = canvas;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint2);
        paint2.setColor(this.f21961b);
        paint2.setTextSize((float) this.f21965f);
        canvas.drawText(charSequence, i, i2, f2 + ((float) this.f21964e), (float) i4, paint2);
    }
}
