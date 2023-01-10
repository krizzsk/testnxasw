package com.didi.beatles.p101im.views.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: com.didi.beatles.im.views.widget.IMHookAnimatorView */
public class IMHookAnimatorView extends View {

    /* renamed from: g */
    private static final int f12299g = 16;

    /* renamed from: h */
    private static final int f12300h = 7;

    /* renamed from: a */
    private int f12301a;

    /* renamed from: b */
    private long f12302b;

    /* renamed from: c */
    private float f12303c;

    /* renamed from: d */
    private float f12304d;

    /* renamed from: e */
    private float f12305e;

    /* renamed from: f */
    private float f12306f;

    /* renamed from: i */
    private int f12307i;

    /* renamed from: j */
    private int f12308j;

    /* renamed from: k */
    private int f12309k;

    /* renamed from: l */
    private int f12310l;

    public IMHookAnimatorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMHookAnimatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMHookAnimatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12301a = -16776961;
        this.f12302b = 200;
        this.f12303c = 0.0f;
        this.f12304d = 0.0f;
        this.f12305e = 0.0f;
        this.f12306f = 0.0f;
        this.f12308j = 1;
        this.f12309k = 5;
        m10500a();
    }

    /* renamed from: a */
    private void m10500a() {
        int i = ((int) this.f12302b) / 16;
        this.f12307i = i;
        this.f12308j = i / 7;
        this.f12310l = this.f12309k / 2;
    }

    public void setDuration(long j) {
        this.f12302b = j;
    }

    public void setColor(int i) {
        this.f12301a = i;
    }

    public void setTextWidth(int i) {
        this.f12309k = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(this.f12301a);
        paint.setStrokeWidth((float) this.f12309k);
        paint.setAntiAlias(true);
        int width = getWidth() / 3;
        int height = getHeight() / 2;
        if (this.f12303c == 0.0f && this.f12304d == 0.0f) {
            int i = this.f12308j;
            this.f12303c = (float) ((width / (i * 3)) + 0);
            this.f12304d = (float) ((height / (i * 3)) + height);
        } else {
            float f = this.f12303c;
            if (2.0f + f < ((float) width)) {
                int i2 = this.f12308j;
                this.f12303c = f + ((float) (width / (i2 * 3)));
                this.f12304d += (float) (height / (i2 * 3));
            }
        }
        canvas.drawLine(0.0f, (float) height, this.f12303c, this.f12304d, paint);
        float f2 = (float) width;
        if (this.f12303c + 5.0f > f2) {
            float f3 = this.f12305e;
            if (f3 == 0.0f) {
                int i3 = this.f12308j;
                this.f12305e = (float) ((width / (i3 * 2)) + width);
                this.f12306f = (float) ((height * 2) - (height / (i3 * 2)));
            } else if (f3 != ((float) (width * 3))) {
                int i4 = this.f12308j;
                this.f12305e = f3 + ((float) (width / (i4 * 2)));
                this.f12306f -= (float) (height / (i4 * 2));
            }
            int i5 = this.f12310l;
            canvas.drawLine((float) (width - i5), (float) ((height * 2) + i5), this.f12305e, this.f12306f, paint);
        }
        if (this.f12303c != f2 || this.f12305e != ((float) (width * 3))) {
            postInvalidateDelayed(16);
        }
    }
}
