package com.didi.unifiedPay.component.widget.loading;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.didi.unifiedPay.component.widget.loading.CircularProgressDrawable;
import com.taxis99.R;

/* renamed from: com.didi.unifiedPay.component.widget.loading.a */
/* compiled from: DefaultDelegate */
class C15291a implements C15295e {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final ArgbEvaluator f47155c = new ArgbEvaluator();

    /* renamed from: d */
    private static final Interpolator f47156d = new LinearInterpolator();

    /* renamed from: e */
    private static final long f47157e = 2000;

    /* renamed from: f */
    private static final long f47158f = 1500;

    /* renamed from: g */
    private static final long f47159g = 200;

    /* renamed from: h */
    private static long f47160h = 500;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f47161A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f47162B;

    /* renamed from: C */
    private int f47163C;

    /* renamed from: D */
    private int f47164D;

    /* renamed from: E */
    private C15294d f47165E;

    /* renamed from: F */
    private long f47166F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public CircularProgressDrawable f47167G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public CircularProgressDrawable.OnEndListener f47168H;

    /* renamed from: a */
    protected Bitmap f47169a;

    /* renamed from: b */
    protected boolean f47170b;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ValueAnimator f47171i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ValueAnimator f47172j;

    /* renamed from: k */
    private ValueAnimator f47173k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ValueAnimator f47174l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f47175m;

    /* renamed from: n */
    private Context f47176n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f47177o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f47178p;

    /* renamed from: q */
    private float f47179q;

    /* renamed from: r */
    private float f47180r = 0.0f;

    /* renamed from: s */
    private float f47181s = 0.0f;

    /* renamed from: t */
    private float f47182t = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f47183u;

    /* renamed from: v */
    private Interpolator f47184v;

    /* renamed from: w */
    private Interpolator f47185w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int[] f47186x;

    /* renamed from: y */
    private float f47187y;

    /* renamed from: z */
    private float f47188z;

    /* renamed from: c */
    private float m35098c(float f) {
        return (360.0f - (f % 360.0f)) % 360.0f;
    }

    public C15291a(Context context, CircularProgressDrawable circularProgressDrawable, C15294d dVar) {
        this.f47176n = context;
        this.f47167G = circularProgressDrawable;
        this.f47165E = dVar;
        this.f47185w = dVar.f47193b;
        this.f47184v = dVar.f47192a;
        this.f47178p = 0;
        int[] iArr = dVar.f47195d;
        this.f47186x = iArr;
        this.f47177o = iArr[0];
        this.f47187y = dVar.f47196e;
        this.f47188z = dVar.f47197f;
        this.f47161A = dVar.f47198g;
        this.f47162B = dVar.f47199h;
        this.f47163C = dVar.f47200i;
        m35113j();
    }

    /* renamed from: e */
    private void m35104e() {
        this.f47183u = true;
        this.f47182t = 1.0f;
        this.f47167G.getCurrentPaint().setColor(this.f47177o);
    }

    /* renamed from: a */
    public void mo118210a(Bitmap bitmap) {
        this.f47169a = bitmap;
        this.f47166F = System.currentTimeMillis();
        this.f47164D = this.f47176n.getResources().getColor(R.color.cpb_success_bgcolor);
        this.f47170b = true;
    }

    /* renamed from: a */
    public void mo118208a() {
        this.f47170b = false;
    }

    /* renamed from: a */
    public void mo118211a(Canvas canvas, Paint paint) {
        RectF drawableBounds = this.f47167G.getDrawableBounds();
        int i = (int) (drawableBounds.left + ((drawableBounds.right - drawableBounds.left) / 2.0f));
        int i2 = (int) (drawableBounds.top + ((drawableBounds.right - drawableBounds.left) / 2.0f));
        int i3 = ((int) (drawableBounds.right - drawableBounds.left)) / 2;
        m35088a(canvas, paint, i, i2, (float) i3, !this.f47170b);
        if (this.f47170b) {
            m35089a(canvas, paint, i, i2, i3);
        } else {
            m35087a(canvas);
        }
    }

    /* renamed from: a */
    private void m35088a(Canvas canvas, Paint paint, int i, int i2, float f, boolean z) {
        m35090a(paint, z);
        canvas.drawCircle((float) i, (float) i2, f, paint);
    }

    /* renamed from: a */
    private void m35089a(Canvas canvas, Paint paint, int i, int i2, int i3) {
        int i4 = i3 * 2;
        int i5 = i - i3;
        int i6 = i2 - i3;
        Rect rect = new Rect(i5, i6, ((int) (((float) i4) * m35105f())) + i5, i4 + i6);
        RectF rectF = new RectF(rect);
        Bitmap a = m35085a(this.f47169a, i3);
        if (a != null) {
            canvas.drawBitmap(a, rect, rectF, paint);
        }
    }

    /* renamed from: a */
    private Bitmap m35085a(Bitmap bitmap, int i) {
        int width = (int) (((float) bitmap.getWidth()) * m35105f());
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return createBitmap;
    }

    /* renamed from: f */
    private float m35105f() {
        float currentTimeMillis = (((float) (System.currentTimeMillis() - this.f47166F)) * 1.0f) / ((float) f47160h);
        if (currentTimeMillis > 1.0f) {
            return 1.0f;
        }
        return currentTimeMillis;
    }

    /* renamed from: b */
    private Bitmap m35096b(Bitmap bitmap, int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f = (float) (i / 2);
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    /* renamed from: a */
    private void m35087a(Canvas canvas) {
        float f;
        Paint initPaint = this.f47167G.initPaint(this.f47165E);
        float f2 = this.f47181s - this.f47180r;
        float f3 = this.f47179q;
        if (!this.f47175m) {
            f2 += 360.0f - f3;
        }
        float f4 = f2 % 360.0f;
        float f5 = this.f47182t;
        if (f5 < 1.0f) {
            float f6 = f5 * f3;
            f4 = (f4 + (f3 - f6)) % 360.0f;
            f = f6;
        } else {
            f = f3;
        }
        float c = m35098c(f4 + f);
        float f7 = c + f;
        if (f7 > 360.0f) {
            Paint paint = initPaint;
            canvas.drawArc(this.f47167G.getDrawableBounds(), c, 360.0f - c, false, paint);
            canvas.drawArc(this.f47167G.getDrawableBounds(), 0.0f, f7 - 360.0f, false, paint);
            return;
        }
        canvas.drawArc(this.f47167G.getDrawableBounds(), c, f, false, initPaint);
    }

    /* renamed from: a */
    private void m35090a(Paint paint, boolean z) {
        if (z) {
            paint.setColor(this.f47163C);
        } else {
            paint.setColor(this.f47164D);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(0.0f);
        paint.setAntiAlias(true);
    }

    /* renamed from: b */
    public void mo118213b() {
        this.f47174l.cancel();
        m35104e();
        this.f47173k.start();
        this.f47171i.start();
    }

    /* renamed from: c */
    public void mo118215c() {
        m35108g();
    }

    /* renamed from: g */
    private void m35108g() {
        this.f47173k.cancel();
        this.f47171i.cancel();
        this.f47172j.cancel();
        this.f47174l.cancel();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m35110h() {
        this.f47175m = true;
        this.f47180r += (float) this.f47161A;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m35112i() {
        this.f47175m = false;
        this.f47180r += (float) (360 - this.f47162B);
    }

    /* renamed from: a */
    public void mo118209a(float f) {
        this.f47181s = f;
        this.f47167G.invalidate();
    }

    /* renamed from: b */
    public void mo118214b(float f) {
        this.f47179q = f;
        this.f47167G.invalidate();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m35101d(float f) {
        this.f47182t = f;
        this.f47167G.invalidate();
    }

    /* renamed from: j */
    private void m35113j() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        this.f47173k = ofFloat;
        ofFloat.setInterpolator(this.f47184v);
        this.f47173k.setDuration((long) (2000.0f / this.f47188z));
        this.f47173k.addUpdateListener(new DefaultDelegate$1(this));
        this.f47173k.setRepeatCount(-1);
        this.f47173k.setRepeatMode(1);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) this.f47161A, (float) this.f47162B});
        this.f47171i = ofFloat2;
        ofFloat2.setInterpolator(this.f47185w);
        this.f47171i.setDuration((long) (1500.0f / this.f47187y));
        this.f47171i.addUpdateListener(new DefaultDelegate$2(this));
        this.f47171i.addListener(new DefaultDelegate$3(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{(float) this.f47162B, (float) this.f47161A});
        this.f47172j = ofFloat3;
        ofFloat3.setInterpolator(this.f47185w);
        this.f47172j.setDuration((long) (1500.0f / this.f47187y));
        this.f47172j.addUpdateListener(new DefaultDelegate$4(this));
        this.f47172j.addListener(new DefaultDelegate$5(this));
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f47174l = ofFloat4;
        ofFloat4.setInterpolator(f47156d);
        this.f47174l.setDuration(200);
        this.f47174l.addUpdateListener(new DefaultDelegate$6(this));
    }

    /* renamed from: a */
    public void mo118212a(CircularProgressDrawable.OnEndListener onEndListener) {
        if (this.f47167G.isRunning() && !this.f47174l.isRunning()) {
            this.f47168H = onEndListener;
            this.f47174l.addListener(new DefaultDelegate$7(this));
            this.f47174l.start();
        }
    }
}
