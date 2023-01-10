package com.didi.soda.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;

public class CustomerVerticalCenterSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f43830a;

    /* renamed from: b */
    private int f43831b;

    public CustomerVerticalCenterSpan(int i) {
        this(i, 0);
    }

    public CustomerVerticalCenterSpan(int i, int i2) {
        this.f43830a = i;
        this.f43831b = i2;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) m32691a(paint).measureText(charSequence.subSequence(i, i2).toString());
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        TextPaint a = m32691a(paint);
        Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
        canvas.drawText(subSequence.toString(), f, (float) (i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2))), a);
    }

    /* renamed from: a */
    private TextPaint m32691a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize((float) DisplayUtils.dip2px(GlobalContext.getContext(), (float) this.f43830a));
        int i = this.f43831b;
        if (i != 0) {
            textPaint.setColor(i);
        }
        return textPaint;
    }
}
