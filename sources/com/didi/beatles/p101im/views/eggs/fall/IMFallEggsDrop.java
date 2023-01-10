package com.didi.beatles.p101im.views.eggs.fall;

import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Pools;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMFactoryPools;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMWindowUtil;
import com.didi.beatles.p101im.views.eggs.IIMEggsDrop;
import com.didi.beatles.p101im.views.eggs.evaluator.PointFInterpolatorEvaluator;
import java.util.Random;

/* renamed from: com.didi.beatles.im.views.eggs.fall.IMFallEggsDrop */
public class IMFallEggsDrop implements IIMEggsDrop {

    /* renamed from: a */
    private static final String f12047a = IMFallEggsDrop.class.getSimpleName();

    /* renamed from: b */
    private static int f12048b = IMWindowUtil.dip2px(100.0f);

    /* renamed from: c */
    private static Pools.Pool<IMFallEggsDrop> f12049c = IMFactoryPools.simple(30, new IMFactoryPools.Factory<IMFallEggsDrop>() {
        public IMFallEggsDrop create() {
            return new IMFallEggsDrop();
        }
    }, new IMFactoryPools.Resetter<IMFallEggsDrop>() {
        public void reset(IMFallEggsDrop iMFallEggsDrop) {
        }
    });

    /* renamed from: d */
    private Matrix f12050d;

    /* renamed from: e */
    private Paint f12051e;

    /* renamed from: f */
    private Bitmap f12052f;

    /* renamed from: g */
    private PointF f12053g;

    /* renamed from: h */
    private PointF f12054h;

    /* renamed from: i */
    private PointF f12055i;

    /* renamed from: j */
    private int f12056j;

    /* renamed from: k */
    private int f12057k;

    /* renamed from: l */
    private int f12058l;

    /* renamed from: m */
    private int f12059m;

    /* renamed from: n */
    private float f12060n;

    /* renamed from: o */
    private long f12061o;

    /* renamed from: p */
    private long f12062p;

    /* renamed from: q */
    private long f12063q;

    /* renamed from: r */
    private long f12064r;

    /* renamed from: s */
    private TypeEvaluator<PointF> f12065s;

    /* renamed from: t */
    private boolean f12066t;

    /* renamed from: u */
    private boolean f12067u;

    /* renamed from: v */
    private boolean f12068v;

    /* renamed from: w */
    private Random f12069w;

    public static IMFallEggsDrop obtain() {
        return f12049c.acquire();
    }

    private IMFallEggsDrop() {
        this.f12053g = new PointF();
        this.f12054h = new PointF();
        this.f12055i = new PointF();
        this.f12060n = 1.0f;
        this.f12069w = new Random();
    }

    public void init(Bitmap bitmap, int i, int i2) {
        init((long) (this.f12069w.nextInt(1000) + 4000), (long) this.f12069w.nextInt(3000), bitmap, i, i2);
    }

    public void init(long j, long j2, Bitmap bitmap, int i, int i2) {
        this.f12066t = true;
        this.f12050d = new Matrix();
        this.f12051e = new Paint();
        this.f12061o = j;
        this.f12062p = j2;
        this.f12065s = new PointFInterpolatorEvaluator(new LinearInterpolator());
        setBitmap(bitmap, i, i2);
    }

    public void setBitmap(Bitmap bitmap, int i, int i2) {
        this.f12052f = bitmap;
        if (bitmap != null) {
            this.f12056j = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.f12057k = height;
            int i3 = this.f12056j;
            if (i3 == 0 || height == 0) {
                IMLog.m10021e(f12047a, C4786I.m9980t("[setBitmap] invalid size -> bmpWidth=", Integer.valueOf(this.f12056j), " |bmpHeight=", Integer.valueOf(this.f12057k)));
                return;
            }
            this.f12060n = Math.min(((float) i) / ((float) i3), ((float) i2) / ((float) height));
        }
    }

    public boolean isActive() {
        return !this.f12067u;
    }

    public void draw(Canvas canvas) {
        m10361a(canvas, SystemClock.uptimeMillis());
    }

    public void recycle() {
        this.f12066t = false;
        this.f12068v = false;
        this.f12067u = false;
        this.f12052f = null;
        try {
            f12049c.release(this);
        } catch (Exception e) {
            IMLog.m10021e(f12047a, "[recycle]", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r6.f12065s != null) goto L_0x001d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10361a(android.graphics.Canvas r7, long r8) {
        /*
            r6 = this;
            boolean r0 = r6.f12066t
            if (r0 == 0) goto L_0x010a
            android.graphics.Bitmap r0 = r6.f12052f
            r1 = 1
            if (r0 == 0) goto L_0x001b
            long r2 = r6.f12061o
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x001b
            long r4 = r6.f12062p
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x001b
            android.animation.TypeEvaluator<android.graphics.PointF> r0 = r6.f12065s
            if (r0 != 0) goto L_0x001d
        L_0x001b:
            r6.f12067u = r1
        L_0x001d:
            boolean r0 = r6.f12068v
            if (r0 != 0) goto L_0x0056
            r6.f12068v = r1
            int r0 = r7.getWidth()
            r6.f12058l = r0
            int r0 = r7.getHeight()
            r6.f12059m = r0
            long r2 = r6.f12062p
            long r2 = r2 + r8
            r6.f12063q = r2
            long r4 = r6.f12061o
            long r2 = r2 + r4
            r6.f12064r = r2
            android.graphics.PointF r0 = r6.f12054h
            android.graphics.PointF r0 = r6.m10359a(r0)
            r6.f12054h = r0
            android.graphics.PointF r2 = r6.f12053g
            float r0 = r0.x
            android.graphics.PointF r3 = r6.f12054h
            float r3 = r3.y
            r2.set(r0, r3)
            android.graphics.PointF r0 = r6.f12054h
            android.graphics.PointF r2 = r6.f12055i
            android.graphics.PointF r0 = r6.m10360a((android.graphics.PointF) r0, (android.graphics.PointF) r2)
            r6.f12055i = r0
        L_0x0056:
            long r2 = r6.f12063q
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x005d
            return
        L_0x005d:
            long r2 = r6.f12064r
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x006c
            java.lang.String r0 = f12047a
            java.lang.String r2 = "[draw]============finished============"
            com.didi.beatles.p101im.utils.IMLog.m10020d(r0, r2)
            r6.f12067u = r1
        L_0x006c:
            int r0 = r6.f12056j
            int r2 = r6.f12058l
            if (r0 > r2) goto L_0x0078
            int r0 = r6.f12057k
            int r2 = r6.f12059m
            if (r0 <= r2) goto L_0x00b5
        L_0x0078:
            java.lang.String r0 = f12047a
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "[draw] #Invalid Size# bitmapWidth="
            r4.append(r5)
            int r5 = r6.f12056j
            r4.append(r5)
            java.lang.String r5 = " |bitmapHeight="
            r4.append(r5)
            int r5 = r6.f12057k
            r4.append(r5)
            java.lang.String r5 = " |canvasWidth="
            r4.append(r5)
            int r5 = r6.f12058l
            r4.append(r5)
            java.lang.String r5 = " |canvasHeight="
            r4.append(r5)
            int r5 = r6.f12059m
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2[r3] = r4
            com.didi.beatles.p101im.utils.IMLog.m10021e(r0, r2)
            r6.f12067u = r1
        L_0x00b5:
            boolean r0 = r6.f12067u
            if (r0 != 0) goto L_0x0109
            boolean r0 = r6.f12068v
            if (r0 == 0) goto L_0x0109
            long r0 = r6.f12063q
            long r8 = r8 - r0
            float r8 = (float) r8
            long r0 = r6.f12061o
            float r9 = (float) r0
            float r8 = r8 / r9
            android.graphics.PointF r9 = r6.f12054h
            android.graphics.PointF r0 = r6.f12055i
            android.graphics.PointF r8 = r6.m10358a(r8, r9, r0)
            android.graphics.Matrix r9 = r6.f12050d
            android.graphics.PointF r0 = r6.f12053g
            float r1 = r8.x
            int r2 = r6.f12056j
            int r2 = r2 / 2
            float r2 = (float) r2
            float r1 = r1 - r2
            r0.x = r1
            android.graphics.PointF r0 = r6.f12053g
            float r2 = r8.y
            r0.y = r2
            r9.setTranslate(r1, r2)
            android.graphics.Matrix r9 = r6.f12050d
            float r0 = r6.f12060n
            int r1 = r6.f12056j
            int r1 = r1 / 2
            float r1 = (float) r1
            int r2 = r6.f12057k
            float r2 = (float) r2
            r9.preScale(r0, r0, r1, r2)
            android.graphics.Bitmap r9 = r6.f12052f
            if (r9 == 0) goto L_0x0106
            boolean r9 = r9.isRecycled()
            if (r9 != 0) goto L_0x0106
            android.graphics.Bitmap r9 = r6.f12052f
            android.graphics.Matrix r0 = r6.f12050d
            android.graphics.Paint r1 = r6.f12051e
            r7.drawBitmap(r9, r0, r1)
        L_0x0106:
            com.didi.beatles.p101im.views.eggs.evaluator.PointFInterpolatorEvaluator.recyclePointF(r8)
        L_0x0109:
            return
        L_0x010a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "You should call #init first!"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.views.eggs.fall.IMFallEggsDrop.m10361a(android.graphics.Canvas, long):void");
    }

    /* renamed from: a */
    private PointF m10358a(float f, PointF pointF, PointF pointF2) {
        return this.f12065s.evaluate(f, pointF, pointF2);
    }

    /* renamed from: a */
    private PointF m10359a(PointF pointF) {
        int i = this.f12056j;
        pointF.set((float) (i + this.f12069w.nextInt(this.f12058l - i)), (float) (-this.f12057k));
        return pointF;
    }

    /* renamed from: a */
    private PointF m10360a(PointF pointF, PointF pointF2) {
        pointF2.set(pointF.x + ((float) ((this.f12069w.nextBoolean() ? 1 : -1) * (this.f12056j + this.f12069w.nextInt(this.f12058l / 4)))), (float) (IMWindowUtil.getScreenHeight() - f12048b));
        return pointF2;
    }
}
