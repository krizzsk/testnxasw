package com.didi.entrega.customer.widget.countdown;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class BaseBackgroundSpan extends ImageSpan {

    /* renamed from: a */
    private Rect f22222a = new Rect();

    /* renamed from: b */
    private int f22223b = 0;

    /* renamed from: c */
    private int f22224c = 0;

    /* renamed from: d */
    private int f22225d = 20;

    /* renamed from: e */
    private int f22226e = 20;

    /* renamed from: f */
    private int f22227f = 20;

    /* renamed from: g */
    private int f22228g = 20;

    /* renamed from: h */
    private int f22229h = -16711936;

    /* renamed from: i */
    private int f22230i = 50;

    public BaseBackgroundSpan(Drawable drawable, int i) {
        super(drawable, i);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.setTextSize((float) this.f22230i);
        paint.getTextBounds(charSequence.toString(), i, i2, this.f22222a);
        this.f22224c = this.f22224c < this.f22222a.width() ? this.f22222a.width() : this.f22224c;
        this.f22223b = this.f22223b < this.f22222a.height() ? this.f22222a.height() : this.f22223b;
        getDrawable().setBounds(0, 0, this.f22224c + this.f22225d + this.f22226e, this.f22227f + this.f22228g + this.f22223b);
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        paint.setColor(this.f22229h);
        paint.setTextSize((float) this.f22230i);
        canvas.drawText(charSequence.subSequence(i, i2).toString(), f + ((float) ((getDrawable().getBounds().width() - this.f22224c) / 2)), (float) ((i4 - ((getDrawable().getBounds().height() - this.f22223b) / 2)) + (this.f22223b / 3)), paint);
    }

    public BaseBackgroundSpan setTimerPadding(int i, int i2, int i3, int i4) {
        this.f22225d = i;
        this.f22226e = i3;
        this.f22228g = i4;
        this.f22227f = i2;
        return this;
    }

    public BaseBackgroundSpan setTimerTextColor(int i) {
        this.f22229h = i;
        return this;
    }

    public BaseBackgroundSpan setTimerTextSize(int i) {
        this.f22230i = i;
        return this;
    }
}
