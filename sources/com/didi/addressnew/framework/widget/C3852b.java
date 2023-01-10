package com.didi.addressnew.framework.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;

/* renamed from: com.didi.addressnew.framework.widget.b */
/* compiled from: Dot */
class C3852b {

    /* renamed from: a */
    int f9268a = 0;

    /* renamed from: b */
    public int f9269b;

    /* renamed from: c */
    float f9270c;

    /* renamed from: d */
    float f9271d;

    /* renamed from: e */
    int f9272e;

    /* renamed from: f */
    ValueAnimator f9273f;

    /* renamed from: g */
    ValueAnimator f9274g;

    /* renamed from: h */
    private Paint f9275h;

    /* renamed from: i */
    private Integer[] f9276i;

    C3852b(DotLoader dotLoader, int i, int i2) {
        this.f9272e = i2;
        this.f9276i = dotLoader.f9254a;
        this.f9269b = i;
        Paint paint = new Paint(1);
        this.f9275h = paint;
        paint.setColor(this.f9276i[this.f9268a].intValue());
        this.f9275h.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43995a(int i) {
        this.f9268a = i;
        this.f9275h.setColor(this.f9276i[i].intValue());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo43998b(int i) {
        this.f9275h.setColor(i);
    }

    /* renamed from: d */
    private int m8062d() {
        return this.f9276i[this.f9268a].intValue();
    }

    /* renamed from: a */
    public int mo43994a() {
        mo43999c();
        return m8062d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo43997b() {
        int i = this.f9268a + 1;
        this.f9268a = i;
        if (i >= this.f9276i.length) {
            this.f9268a = 0;
        }
        this.f9275h.setColor(this.f9276i[this.f9268a].intValue());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo43999c() {
        int i = this.f9268a + 1;
        this.f9268a = i;
        if (i >= this.f9276i.length) {
            this.f9268a = 0;
        }
        return this.f9268a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43996a(Canvas canvas) {
        canvas.drawCircle(this.f9270c, this.f9271d, (float) this.f9269b, this.f9275h);
    }
}
