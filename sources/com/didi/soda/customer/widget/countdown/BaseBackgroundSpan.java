package com.didi.soda.customer.widget.countdown;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class BaseBackgroundSpan extends ImageSpan {

    /* renamed from: a */
    private Rect f44281a = new Rect();

    /* renamed from: b */
    private int f44282b = 0;

    /* renamed from: c */
    private int f44283c = 0;

    /* renamed from: d */
    private int f44284d = 20;

    /* renamed from: e */
    private int f44285e = 20;

    /* renamed from: f */
    private int f44286f = 20;

    /* renamed from: g */
    private int f44287g = 20;

    /* renamed from: h */
    private int f44288h = -16711936;

    /* renamed from: i */
    private int f44289i = 50;

    public BaseBackgroundSpan(Drawable drawable, int i) {
        super(drawable, i);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.setTextSize((float) this.f44289i);
        paint.getTextBounds(charSequence.toString(), i, i2, this.f44281a);
        this.f44283c = this.f44283c < this.f44281a.width() ? this.f44281a.width() : this.f44283c;
        this.f44282b = this.f44282b < this.f44281a.height() ? this.f44281a.height() : this.f44282b;
        getDrawable().setBounds(0, 0, this.f44283c + this.f44284d + this.f44285e, this.f44286f + this.f44287g + this.f44282b);
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        paint.setColor(this.f44288h);
        paint.setTextSize((float) this.f44289i);
        canvas.drawText(charSequence.subSequence(i, i2).toString(), f + ((float) ((getDrawable().getBounds().width() - this.f44283c) / 2)), (float) ((i4 - ((getDrawable().getBounds().height() - this.f44282b) / 2)) + (this.f44282b / 3)), paint);
    }

    public BaseBackgroundSpan setTimerPadding(int i, int i2, int i3, int i4) {
        this.f44284d = i;
        this.f44285e = i3;
        this.f44287g = i4;
        this.f44286f = i2;
        return this;
    }

    public BaseBackgroundSpan setTimerTextColor(int i) {
        this.f44288h = i;
        return this;
    }

    public BaseBackgroundSpan setTimerTextSize(int i) {
        this.f44289i = i;
        return this;
    }
}
