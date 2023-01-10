package com.didi.soda.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;

public class CustomerRadiusEdgeBgSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f43804a;

    /* renamed from: b */
    private int f43805b;

    /* renamed from: c */
    private int f43806c;

    /* renamed from: d */
    private int f43807d;

    /* renamed from: e */
    private int f43808e;

    /* renamed from: f */
    private int f43809f;

    /* renamed from: g */
    private int f43810g;

    /* renamed from: h */
    private int f43811h = DisplayUtils.dip2px(GlobalContext.getContext(), 0.5f);

    public CustomerRadiusEdgeBgSpan(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f43809f = i;
        this.f43805b = i2;
        this.f43807d = i4;
        this.f43808e = i5;
        this.f43806c = i3;
        this.f43810g = i6;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.setTextSize((float) this.f43809f);
        int measureText = (int) (paint.measureText(charSequence, i, i2) + ((float) (this.f43808e * 2)));
        this.f43804a = measureText;
        return measureText;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2 = f;
        int i6 = i4;
        Paint paint2 = paint;
        paint2.setColor(this.f43806c);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth((float) this.f43811h);
        float f3 = (float) i6;
        RectF rectF = new RectF(f2, paint.ascent() + f3, ((float) this.f43804a) + f2, (f3 + paint.descent()) - (((float) this.f43807d) / 2.0f));
        int i7 = this.f43807d;
        Canvas canvas2 = canvas;
        canvas.drawRoundRect(rectF, (float) i7, (float) i7, paint2);
        paint.reset();
        paint2.setAntiAlias(true);
        paint2.setColor(this.f43805b);
        paint2.setTextSize((float) this.f43809f);
        canvas.drawText(charSequence, i, i2, f2 + ((float) this.f43808e), (float) (i6 - this.f43807d), paint2);
    }
}
