package com.didi.entrega.customer.foundation.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.app.GlobalContext;

public class CustomerRadiusEdgeBgSpan extends ReplacementSpan {

    /* renamed from: a */
    private int f21967a;

    /* renamed from: b */
    private int f21968b;

    /* renamed from: c */
    private int f21969c;

    /* renamed from: d */
    private int f21970d;

    /* renamed from: e */
    private int f21971e;

    /* renamed from: f */
    private int f21972f;

    /* renamed from: g */
    private int f21973g;

    /* renamed from: h */
    private int f21974h = DisplayUtils.dip2px(GlobalContext.getContext(), 0.5f);

    public CustomerRadiusEdgeBgSpan(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f21972f = i;
        this.f21968b = i2;
        this.f21970d = i4;
        this.f21971e = i5;
        this.f21969c = i3;
        this.f21973g = i6;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.setTextSize((float) this.f21972f);
        int measureText = (int) (paint.measureText(charSequence, i, i2) + ((float) (this.f21971e * 2)));
        this.f21967a = measureText;
        return measureText;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2 = f;
        int i6 = i4;
        Paint paint2 = paint;
        paint2.setColor(this.f21969c);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth((float) this.f21974h);
        float f3 = (float) i6;
        RectF rectF = new RectF(f2, paint.ascent() + f3, ((float) this.f21967a) + f2, (f3 + paint.descent()) - (((float) this.f21970d) / 2.0f));
        int i7 = this.f21970d;
        Canvas canvas2 = canvas;
        canvas.drawRoundRect(rectF, (float) i7, (float) i7, paint2);
        paint.reset();
        paint2.setAntiAlias(true);
        paint2.setColor(this.f21968b);
        paint2.setTextSize((float) this.f21972f);
        canvas.drawText(charSequence, i, i2, f2 + ((float) this.f21971e), (float) (i6 - this.f21970d), paint2);
    }
}
