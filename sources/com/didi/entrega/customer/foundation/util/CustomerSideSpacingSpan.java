package com.didi.entrega.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;

public class CustomerSideSpacingSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f21975a;

    /* renamed from: b */
    private int f21976b;

    /* renamed from: c */
    private int f21977c;

    public CustomerSideSpacingSpan(int i, int i2, int i3) {
        this.f21975a = i;
        this.f21976b = i2;
        this.f21977c = i3;
    }

    public CustomerSideSpacingSpan(int i, int i2) {
        this(i, 0, i2);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return ((int) m18245a(paint).measureText(charSequence.subSequence(i, i2).toString())) + (this.f21977c * 2);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        TextPaint a = m18245a(paint);
        Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
        canvas.drawText(subSequence.toString(), f + ((float) this.f21977c), (float) (i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2))), a);
    }

    /* renamed from: a */
    private TextPaint m18245a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize((float) DisplayUtils.dip2px(GlobalContext.getContext(), (float) this.f21975a));
        int i = this.f21976b;
        if (i != 0) {
            textPaint.setColor(i);
        }
        return textPaint;
    }
}
