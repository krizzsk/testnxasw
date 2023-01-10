package com.didi.component.estimate.newui.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class DynamicArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_BOTTOM = 3;
    public static final int ARROW_DIRECTION_LEFT = 4;
    public static final int ARROW_DIRECTION_RIGHT = 2;
    public static final int ARROW_DIRECTION_TOP = 1;

    /* renamed from: a */
    private float f14888a;

    /* renamed from: b */
    private float f14889b;

    /* renamed from: c */
    private float f14890c;

    /* renamed from: d */
    private float f14891d;

    /* renamed from: e */
    private float f14892e;

    /* renamed from: f */
    private float f14893f;

    /* renamed from: g */
    private float f14894g;

    /* renamed from: h */
    private float f14895h;

    /* renamed from: i */
    private RectF f14896i = new RectF();

    /* renamed from: j */
    private RectF f14897j = new RectF();

    /* renamed from: k */
    private RectF f14898k = new RectF();

    /* renamed from: l */
    private RectF f14899l = new RectF();

    /* renamed from: m */
    private int f14900m = 3;

    /* renamed from: n */
    private float f14901n;

    /* renamed from: o */
    private float f14902o;

    /* renamed from: p */
    private float f14903p;

    /* renamed from: q */
    private float f14904q;

    /* renamed from: r */
    private Drawable f14905r;

    /* renamed from: s */
    private Rect f14906s;

    /* renamed from: t */
    private RectF f14907t = new RectF();

    /* renamed from: u */
    private Path f14908u = new Path();

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f14906s = rect;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        m12255a(this.f14907t);
        this.f14908u.reset();
        this.f14908u.moveTo(m12259c(), m12263e());
        m12256a(this.f14908u);
        this.f14908u.arcTo(m12264f(), 270.0f, 90.0f);
        m12258b(this.f14908u);
        this.f14908u.arcTo(m12268j(), 0.0f, 90.0f);
        m12260c(this.f14908u);
        this.f14908u.arcTo(m12272n(), 90.0f, 90.0f);
        m12262d(this.f14908u);
        this.f14908u.arcTo(m12276r(), 180.0f, 90.0f);
        this.f14908u.close();
        canvas.clipPath(this.f14908u);
        Rect rect = this.f14906s;
        if (rect != null) {
            this.f14905r.setBounds(rect);
        } else {
            this.f14905r.setBounds(getBounds());
        }
        this.f14905r.draw(canvas);
    }

    public void setSrcDrawable(Drawable drawable) {
        this.f14905r = drawable;
        invalidateSelf();
    }

    public void setMargin(float f) {
        this.f14889b = f;
        this.f14890c = f;
        this.f14891d = f;
        this.f14888a = f;
        invalidateSelf();
    }

    public void setMargin(float f, float f2, float f3, float f4) {
        this.f14889b = f;
        this.f14890c = f2;
        this.f14891d = f3;
        this.f14888a = f4;
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        if (f >= 0.0f) {
            this.f14892e = f;
            this.f14893f = f;
            this.f14894g = f;
            this.f14895h = f;
            invalidateSelf();
        }
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.f14892e = f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f14893f = f2;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        this.f14894g = f3;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        this.f14895h = f4;
        invalidateSelf();
    }

    public void setArrow(int i, float f, float f2, float f3, float f4) {
        this.f14900m = i;
        this.f14901n = f;
        this.f14902o = f2;
        this.f14903p = f3;
        this.f14904q = f4;
        invalidateSelf();
    }

    /* renamed from: a */
    private RectF m12255a(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        rectF.top = ((float) this.f14906s.top) + this.f14889b + m12254a(1);
        rectF.right = (((float) this.f14906s.right) - this.f14890c) - m12254a(2);
        rectF.bottom = (((float) this.f14906s.bottom) - this.f14891d) - m12254a(3);
        rectF.left = ((float) this.f14906s.left) + this.f14888a + m12254a(4);
        return rectF;
    }

    /* renamed from: a */
    private float m12254a(int i) {
        if (i == this.f14900m) {
            return this.f14904q;
        }
        return 0.0f;
    }

    /* renamed from: a */
    private float m12253a() {
        float f = this.f14907t.right - this.f14907t.left;
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* renamed from: b */
    private float m12257b() {
        float f = this.f14907t.bottom - this.f14907t.top;
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    /* renamed from: a */
    private void m12256a(Path path) {
        float c = m12259c();
        float d = m12261d();
        float e = m12263e();
        if (this.f14900m == 1) {
            float f = this.f14903p;
            if (f > 0.0f && this.f14904q > 0.0f) {
                float f2 = this.f14901n;
                if (f2 - (f / 2.0f) > c && (f / 2.0f) + f2 < d) {
                    path.lineTo(f2 - (f / 2.0f), e);
                    path.lineTo(this.f14901n, e - this.f14904q);
                    path.lineTo(this.f14901n + (this.f14903p / 2.0f), e);
                    path.lineTo(d, e);
                    return;
                }
            }
        }
        path.lineTo(d, e);
    }

    /* renamed from: b */
    private void m12258b(Path path) {
        float h = m12266h();
        float i = m12267i();
        float g = m12265g();
        if (this.f14900m == 2) {
            float f = this.f14903p;
            if (f > 0.0f && this.f14904q > 0.0f) {
                float f2 = this.f14902o;
                if (f2 - (f / 2.0f) > h && (f / 2.0f) + f2 < i) {
                    path.lineTo(g, f2 - (f / 2.0f));
                    path.lineTo(this.f14904q + g, this.f14902o);
                    path.lineTo(g, this.f14902o + (this.f14903p / 2.0f));
                    path.lineTo(g, i);
                    return;
                }
            }
        }
        path.lineTo(g, i);
    }

    /* renamed from: c */
    private void m12260c(Path path) {
        float l = m12270l();
        float k = m12269k();
        float m = m12271m();
        if (this.f14900m == 3) {
            float f = this.f14903p;
            if (f > 0.0f && this.f14904q > 0.0f) {
                float f2 = this.f14901n;
                if (f2 - (f / 2.0f) > l && (f / 2.0f) + f2 < k) {
                    path.lineTo(f2 + (f / 2.0f), m);
                    path.lineTo(this.f14901n, this.f14904q + m);
                    path.lineTo(this.f14901n - (this.f14903p / 2.0f), m);
                    path.lineTo(l, m);
                    return;
                }
            }
        }
        path.lineTo(l, m);
    }

    /* renamed from: d */
    private void m12262d(Path path) {
        float q = m12275q();
        float p = m12274p();
        float o = m12273o();
        if (this.f14900m == 4) {
            float f = this.f14903p;
            if (f > 0.0f && this.f14904q > 0.0f) {
                float f2 = this.f14902o;
                if (f2 - (f / 2.0f) > q && (f / 2.0f) + f2 < p) {
                    path.lineTo(o, f2 + (f / 2.0f));
                    path.lineTo(o - this.f14904q, this.f14902o);
                    path.lineTo(o, this.f14902o - (this.f14903p / 2.0f));
                    path.lineTo(o, q);
                    return;
                }
            }
        }
        path.lineTo(o, q);
    }

    /* renamed from: c */
    private float m12259c() {
        float a = m12253a();
        if (a > 0.0f) {
            return this.f14907t.left + Math.min(this.f14892e, a / 2.0f);
        }
        return (float) this.f14906s.left;
    }

    /* renamed from: d */
    private float m12261d() {
        float a = m12253a();
        if (a > 0.0f) {
            return this.f14907t.right - Math.min(this.f14893f, a / 2.0f);
        }
        return (float) this.f14906s.right;
    }

    /* renamed from: e */
    private float m12263e() {
        if (m12257b() > 0.0f) {
            return this.f14907t.top;
        }
        return (float) this.f14906s.top;
    }

    /* renamed from: f */
    private RectF m12264f() {
        float a = m12253a();
        float b = m12257b();
        if (a > 0.0f && b > 0.0f) {
            this.f14897j.right = this.f14907t.right;
            RectF rectF = this.f14897j;
            rectF.left = rectF.right - Math.min(this.f14893f * 2.0f, a);
            this.f14897j.top = this.f14907t.top;
            RectF rectF2 = this.f14897j;
            rectF2.bottom = rectF2.top + Math.min(this.f14893f * 2.0f, b);
        }
        return this.f14897j;
    }

    /* renamed from: g */
    private float m12265g() {
        if (m12253a() > 0.0f) {
            return this.f14907t.right;
        }
        return (float) this.f14906s.right;
    }

    /* renamed from: h */
    private float m12266h() {
        float b = m12257b();
        if (b > 0.0f) {
            return this.f14907t.top + Math.min(this.f14893f, b / 2.0f);
        }
        return (float) this.f14906s.top;
    }

    /* renamed from: i */
    private float m12267i() {
        float b = m12257b();
        if (b > 0.0f) {
            return this.f14907t.bottom - Math.min(this.f14895h, b / 2.0f);
        }
        return (float) this.f14906s.bottom;
    }

    /* renamed from: j */
    private RectF m12268j() {
        float a = m12253a();
        float b = m12257b();
        if (a > 0.0f && b > 0.0f) {
            this.f14899l.right = this.f14907t.right;
            RectF rectF = this.f14899l;
            rectF.left = rectF.right - Math.min(this.f14895h * 2.0f, a);
            this.f14899l.bottom = this.f14907t.bottom;
            RectF rectF2 = this.f14899l;
            rectF2.top = rectF2.bottom - Math.min(this.f14895h * 2.0f, b);
        }
        return this.f14899l;
    }

    /* renamed from: k */
    private float m12269k() {
        float a = m12253a();
        if (a > 0.0f) {
            return this.f14907t.right - Math.min(this.f14895h, a / 2.0f);
        }
        return (float) this.f14906s.right;
    }

    /* renamed from: l */
    private float m12270l() {
        float a = m12253a();
        if (a > 0.0f) {
            return this.f14907t.left + Math.min(this.f14894g, a / 2.0f);
        }
        return (float) this.f14906s.left;
    }

    /* renamed from: m */
    private float m12271m() {
        if (m12257b() > 0.0f) {
            return this.f14907t.bottom;
        }
        return (float) this.f14906s.bottom;
    }

    /* renamed from: n */
    private RectF m12272n() {
        float a = m12253a();
        float b = m12257b();
        if (a > 0.0f && b > 0.0f) {
            this.f14898k.left = this.f14907t.left;
            RectF rectF = this.f14898k;
            rectF.right = rectF.left + Math.min(this.f14894g * 2.0f, a);
            this.f14898k.bottom = this.f14907t.bottom;
            RectF rectF2 = this.f14898k;
            rectF2.top = rectF2.bottom - Math.min(this.f14894g * 2.0f, b);
        }
        return this.f14898k;
    }

    /* renamed from: o */
    private float m12273o() {
        if (m12253a() > 0.0f) {
            return this.f14907t.left;
        }
        return (float) this.f14906s.left;
    }

    /* renamed from: p */
    private float m12274p() {
        float b = m12257b();
        if (b > 0.0f) {
            return this.f14907t.bottom - Math.min(this.f14894g, b / 2.0f);
        }
        return (float) this.f14906s.bottom;
    }

    /* renamed from: q */
    private float m12275q() {
        float b = m12257b();
        if (b > 0.0f) {
            return this.f14907t.top + Math.min(this.f14892e, b / 2.0f);
        }
        return (float) this.f14906s.top;
    }

    /* renamed from: r */
    private RectF m12276r() {
        float a = m12253a();
        float b = m12257b();
        if (a > 0.0f && b > 0.0f) {
            this.f14896i.left = this.f14907t.left;
            RectF rectF = this.f14896i;
            rectF.right = rectF.left + Math.min(this.f14892e * 2.0f, a);
            this.f14896i.top = this.f14907t.top;
            RectF rectF2 = this.f14896i;
            rectF2.bottom = rectF2.top + Math.min(this.f14892e * 2.0f, b);
        }
        return this.f14896i;
    }
}
