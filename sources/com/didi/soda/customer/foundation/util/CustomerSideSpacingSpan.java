package com.didi.soda.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;

public class CustomerSideSpacingSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f43821a;

    /* renamed from: b */
    private int f43822b;

    /* renamed from: c */
    private int f43823c;

    public CustomerSideSpacingSpan(int i, int i2, int i3) {
        this.f43821a = i;
        this.f43822b = i2;
        this.f43823c = i3;
    }

    public CustomerSideSpacingSpan(int i, int i2) {
        this(i, 0, i2);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return ((int) m32686a(paint).measureText(charSequence.subSequence(i, i2).toString())) + (this.f43823c * 2);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        TextPaint a = m32686a(paint);
        Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
        canvas.drawText(subSequence.toString(), f + ((float) this.f43823c), (float) (i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2))), a);
    }

    /* renamed from: a */
    private TextPaint m32686a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize((float) DisplayUtils.dip2px(GlobalContext.getContext(), (float) this.f43821a));
        int i = this.f43822b;
        if (i != 0) {
            textPaint.setColor(i);
        }
        return textPaint;
    }
}
