package com.didi.component.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.didichuxing.publicservice.resourcecontrol.utils.DensityUtil;

public class CustomVerticalCenterSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f13825a;

    /* renamed from: b */
    private Context f13826b;

    /* renamed from: c */
    private int f13827c;

    public CustomVerticalCenterSpan(Context context, int i, int i2) {
        this.f13826b = context;
        this.f13825a = i;
        this.f13827c = i2;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return (int) m11458a(paint).measureText(charSequence.subSequence(i, i2).toString());
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        TextPaint a = m11458a(paint);
        Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
        a.setColor(this.f13827c);
        canvas.drawText(subSequence.toString(), f, (float) (i4 - (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((i5 + i3) / 2))), a);
    }

    /* renamed from: a */
    private TextPaint m11458a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setColor(this.f13826b.getResources().getColor(17170444));
        textPaint.setTextSize((float) DensityUtil.dip2px(this.f13826b, (float) this.f13825a));
        return textPaint;
    }
}
