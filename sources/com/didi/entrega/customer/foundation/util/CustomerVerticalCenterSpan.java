package com.didi.entrega.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;

public class CustomerVerticalCenterSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f21984a;

    /* renamed from: b */
    private int f21985b;

    public CustomerVerticalCenterSpan(int i) {
        this(i, 0);
    }

    public CustomerVerticalCenterSpan(int i, int i2) {
        this.f21984a = i;
        this.f21985b = i2;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) m18250a(paint).measureText(charSequence.subSequence(i, i2).toString());
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        TextPaint a = m18250a(paint);
        Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
        canvas.drawText(subSequence.toString(), f, (float) (i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2))), a);
    }

    /* renamed from: a */
    private TextPaint m18250a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize((float) DisplayUtils.dip2px(GlobalContext.getContext(), (float) this.f21984a));
        int i = this.f21985b;
        if (i != 0) {
            textPaint.setColor(i);
        }
        return textPaint;
    }
}
