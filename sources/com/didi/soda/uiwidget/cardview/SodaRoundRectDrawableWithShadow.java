package com.didi.soda.uiwidget.cardview;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.taxis99.R;

class SodaRoundRectDrawableWithShadow extends Drawable {

    /* renamed from: a */
    static RoundRectHelper f46387a = null;

    /* renamed from: b */
    private static final double f46388b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c */
    private static final float f46389c = 1.5f;

    /* renamed from: d */
    private final int f46390d;

    /* renamed from: e */
    private float f46391e;

    /* renamed from: f */
    private Paint f46392f;

    /* renamed from: g */
    private Paint f46393g;

    /* renamed from: h */
    private Paint f46394h;

    /* renamed from: i */
    private RectF f46395i;

    /* renamed from: j */
    private float f46396j;

    /* renamed from: k */
    private Path f46397k;

    /* renamed from: l */
    private float f46398l;

    /* renamed from: m */
    private float f46399m;

    /* renamed from: n */
    private float f46400n;

    /* renamed from: o */
    private float f46401o;

    /* renamed from: p */
    private boolean f46402p = true;

    /* renamed from: q */
    private int f46403q;

    /* renamed from: r */
    private int f46404r;

    /* renamed from: s */
    private boolean f46405s = true;

    /* renamed from: t */
    private boolean f46406t = false;

    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public int getOpacity() {
        return -3;
    }

    SodaRoundRectDrawableWithShadow(Resources resources, int i, float f, float f2, float f3, float f4, int i2, int i3) {
        if (i2 != 0) {
            this.f46403q = i2;
        } else {
            this.f46403q = resources.getColor(R.color.soda_cardview_shadow_start_color);
        }
        if (i3 != 0) {
            this.f46404r = i3;
        } else {
            this.f46404r = resources.getColor(R.color.soda_cardview_shadow_end_color);
        }
        this.f46390d = resources.getDimensionPixelSize(R.dimen.ui_widget_4px);
        this.f46391e = f4;
        if (f4 > f2) {
            this.f46391e = f2;
        }
        Paint paint = new Paint(5);
        this.f46392f = paint;
        paint.setColor(i);
        Paint paint2 = new Paint(5);
        this.f46393g = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f46396j = (float) ((int) (f + 0.5f));
        this.f46395i = new RectF();
        Paint paint3 = new Paint(this.f46393g);
        this.f46394h = paint3;
        paint3.setAntiAlias(false);
        mo115568a(f2, f3);
    }

    /* renamed from: a */
    public void mo115571a(boolean z) {
        this.f46405s = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.f46392f.setAlpha(i);
        this.f46393g.setAlpha(i);
        this.f46394h.setAlpha(i);
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) mo115565a(this.f46399m, this.f46396j, this.f46405s));
        int ceil2 = (int) Math.ceil((double) mo115573b(this.f46399m, this.f46396j, this.f46405s));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f46392f.setColorFilter(colorFilter);
    }

    public void draw(Canvas canvas) {
        if (this.f46402p) {
            m34518b(getBounds());
            this.f46402p = false;
        }
        canvas.translate(0.0f, this.f46391e);
        m34517a(canvas);
        canvas.translate(0.0f, -this.f46391e);
        f46387a.drawRoundRect(canvas, this.f46395i, this.f46396j, this.f46392f);
    }

    /* renamed from: a */
    public void mo115569a(int i) {
        this.f46392f.setColor(i);
        invalidateSelf();
    }

    /* renamed from: a */
    public int mo115566a() {
        return this.f46392f.getColor();
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect((int) this.f46395i.left, (int) this.f46395i.top, (int) this.f46395i.right, (int) this.f46395i.bottom, this.f46396j);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f46402p = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115568a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 >= 0.0f) {
            float e = (float) m34519e(f);
            float e2 = (float) m34519e(f2);
            if (e > e2) {
                if (!this.f46406t) {
                    this.f46406t = true;
                }
                e = e2;
            }
            if (this.f46401o != e || this.f46399m != e2) {
                this.f46401o = e;
                this.f46399m = e2;
                int i = this.f46390d;
                this.f46400n = (float) ((int) ((e * 1.5f) + ((float) i) + 0.5f));
                this.f46398l = e2 + ((float) i);
                this.f46402p = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo115565a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f46388b) * ((double) f2))) : f * 1.5f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo115573b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f46388b) * ((double) f2))) : f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115567a(float f) {
        if (f >= 0.0f) {
            float f2 = (float) ((int) (f + 0.5f));
            if (this.f46396j != f2) {
                this.f46396j = f2;
                this.f46402p = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo115575b(int i) {
        this.f46403q = i;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo115578c(int i) {
        this.f46404r = i;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo115574b(float f) {
        this.f46391e = f;
        float f2 = this.f46401o;
        if (f > f2) {
            this.f46391e = f2;
        }
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo115572b() {
        return this.f46391e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo115576c() {
        return this.f46403q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo115579d() {
        return this.f46404r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public float mo115582e() {
        return this.f46396j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115570a(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo115577c(float f) {
        mo115568a(f, this.f46399m);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo115580d(float f) {
        mo115568a(this.f46401o, f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public float mo115583f() {
        return this.f46401o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public float mo115584g() {
        return this.f46399m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public float mo115588h() {
        float f = this.f46399m;
        return (Math.max(f, this.f46396j + ((float) this.f46390d) + (f / 2.0f)) * 2.0f) + ((this.f46399m + ((float) this.f46390d)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public float mo115589i() {
        float f = this.f46399m;
        return (Math.max(f, this.f46396j + ((float) this.f46390d) + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.f46399m * 1.5f) + ((float) this.f46390d)) * 2.0f);
    }

    /* renamed from: e */
    private int m34519e(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    /* renamed from: a */
    private void m34517a(Canvas canvas) {
        float f = this.f46396j;
        float f2 = (-f) - this.f46400n;
        float f3 = f + ((float) this.f46390d) + (this.f46401o / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.f46395i.width() - f4 > 0.0f;
        boolean z2 = this.f46395i.height() - f4 > 0.0f;
        int save = canvas.save();
        canvas.translate(this.f46395i.left + f3, this.f46395i.top + f3);
        canvas.drawPath(this.f46397k, this.f46393g);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f46395i.width() - f4, -this.f46396j, this.f46394h);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f46395i.right - f3, this.f46395i.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f46397k, this.f46393g);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f46395i.width() - f4, (-this.f46396j) + this.f46400n, this.f46394h);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f46395i.left + f3, this.f46395i.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f46397k, this.f46393g);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f46395i.height() - f4, -this.f46396j, this.f46394h);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.f46395i.right - f3, this.f46395i.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f46397k, this.f46393g);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f46395i.height() - f4, -this.f46396j, this.f46394h);
        }
        canvas.restoreToCount(save4);
    }

    /* renamed from: j */
    private void m34520j() {
        float f = this.f46396j;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.f46400n;
        rectF2.inset(-f2, -f2);
        Path path = this.f46397k;
        if (path == null) {
            this.f46397k = new Path();
        } else {
            path.reset();
        }
        this.f46397k.setFillType(Path.FillType.EVEN_ODD);
        this.f46397k.moveTo(-this.f46396j, 0.0f);
        this.f46397k.rLineTo(-this.f46400n, 0.0f);
        this.f46397k.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f46397k.arcTo(rectF, 270.0f, -90.0f, false);
        this.f46397k.close();
        float f3 = this.f46396j;
        float f4 = f3 / (this.f46400n + f3);
        Paint paint = this.f46393g;
        float f5 = this.f46396j + this.f46400n;
        int i = this.f46403q;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.f46404r}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f46394h;
        float f6 = this.f46396j;
        float f7 = this.f46400n;
        int i2 = this.f46403q;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.f46404r}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f46394h.setAntiAlias(false);
    }

    /* renamed from: b */
    private void m34518b(Rect rect) {
        float f = this.f46399m * 1.5f;
        this.f46395i.set(((float) rect.left) + this.f46399m, ((float) rect.top) + f, ((float) rect.right) - this.f46399m, ((float) rect.bottom) - f);
        m34520j();
    }
}
