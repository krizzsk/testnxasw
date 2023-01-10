package com.didi.zxing.barcodescanner.scale;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class ScaleGestureDetector {

    /* renamed from: A */
    private static final int f48078A = 1;

    /* renamed from: B */
    private static final int f48079B = 2;

    /* renamed from: a */
    private static final String f48080a = "ScaleGestureDetector";

    /* renamed from: x */
    private static final long f48081x = 128;

    /* renamed from: y */
    private static final float f48082y = 0.5f;

    /* renamed from: z */
    private static final int f48083z = 0;

    /* renamed from: C */
    private GestureDetector f48084C;

    /* renamed from: D */
    private boolean f48085D;

    /* renamed from: b */
    private final Context f48086b;

    /* renamed from: c */
    private final OnScaleGestureListener f48087c;

    /* renamed from: d */
    private float f48088d;

    /* renamed from: e */
    private float f48089e;

    /* renamed from: f */
    private boolean f48090f;

    /* renamed from: g */
    private boolean f48091g;

    /* renamed from: h */
    private float f48092h;

    /* renamed from: i */
    private float f48093i;

    /* renamed from: j */
    private float f48094j;

    /* renamed from: k */
    private float f48095k;

    /* renamed from: l */
    private float f48096l;

    /* renamed from: m */
    private float f48097m;

    /* renamed from: n */
    private float f48098n;

    /* renamed from: o */
    private long f48099o;

    /* renamed from: p */
    private long f48100p;

    /* renamed from: q */
    private boolean f48101q;

    /* renamed from: r */
    private int f48102r;

    /* renamed from: s */
    private int f48103s;

    /* renamed from: t */
    private final Handler f48104t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f48105u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public float f48106v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f48107w;

    public interface OnScaleGestureListener {
        boolean onScale(ScaleGestureDetector scaleGestureDetector);

        boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector);

        void onScaleEnd(ScaleGestureDetector scaleGestureDetector);
    }

    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener) {
        this(context, onScaleGestureListener, (Handler) null);
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener, Handler handler) {
        this.f48107w = 0;
        this.f48086b = context;
        this.f48087c = onScaleGestureListener;
        this.f48102r = 0;
        context.getResources();
        this.f48103s = 10;
        this.f48104t = handler;
        int i = context.getApplicationInfo().targetSdkVersion;
        if (i > 18) {
            setQuickScaleEnabled(true);
        }
        if (i > 22) {
            setStylusScaleEnabled(true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        float f3;
        MotionEvent motionEvent2 = motionEvent;
        this.f48099o = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f48090f) {
            this.f48084C.onTouchEvent(motionEvent2);
        }
        int pointerCount = motionEvent.getPointerCount();
        boolean z = (motionEvent.getButtonState() & 32) != 0;
        boolean z2 = this.f48107w == 2 && !z;
        boolean z3 = actionMasked == 1 || actionMasked == 3 || z2;
        float f4 = 0.0f;
        if (actionMasked == 0 || z3) {
            if (this.f48101q) {
                this.f48087c.onScaleEnd(this);
                this.f48101q = false;
                this.f48094j = 0.0f;
                this.f48107w = 0;
            } else if (m36094a() && z3) {
                this.f48101q = false;
                this.f48094j = 0.0f;
                this.f48107w = 0;
            }
            if (z3) {
                return true;
            }
        }
        if (!this.f48101q && this.f48091g && !m36094a() && !z3 && z) {
            this.f48105u = motionEvent.getX();
            this.f48106v = motionEvent.getY();
            this.f48107w = 2;
            this.f48094j = 0.0f;
        }
        boolean z4 = actionMasked == 0 || actionMasked == 6 || actionMasked == 5 || z2;
        boolean z5 = actionMasked == 6;
        int actionIndex = z5 ? motionEvent.getActionIndex() : -1;
        int i = z5 ? pointerCount - 1 : pointerCount;
        if (m36094a()) {
            f2 = this.f48105u;
            f = this.f48106v;
            if (motionEvent.getY() < f) {
                this.f48085D = true;
            } else {
                this.f48085D = false;
            }
        } else {
            float f5 = 0.0f;
            float f6 = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    f5 += motionEvent2.getX(i2);
                    f6 += motionEvent2.getY(i2);
                }
            }
            float f7 = (float) i;
            float f8 = f5 / f7;
            f = f6 / f7;
            f2 = f8;
        }
        float f9 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                f4 += Math.abs(motionEvent2.getX(i3) - f2);
                f9 += Math.abs(motionEvent2.getY(i3) - f);
            }
        }
        float f10 = (float) i;
        float f11 = (f4 / f10) * 2.0f;
        float f12 = (f9 / f10) * 2.0f;
        if (m36094a()) {
            f3 = f12;
        } else {
            f3 = (float) Math.hypot((double) f11, (double) f12);
        }
        boolean z6 = this.f48101q;
        this.f48088d = f2;
        this.f48089e = f;
        if (!m36094a() && this.f48101q && (f3 < ((float) this.f48103s) || z4)) {
            this.f48087c.onScaleEnd(this);
            this.f48101q = false;
            this.f48094j = f3;
        }
        if (z4) {
            this.f48095k = f11;
            this.f48097m = f11;
            this.f48096l = f12;
            this.f48098n = f12;
            this.f48092h = f3;
            this.f48093i = f3;
            this.f48094j = f3;
        }
        int i4 = m36094a() ? this.f48102r : this.f48103s;
        if (!this.f48101q && f3 >= ((float) i4) && (z6 || Math.abs(f3 - this.f48094j) > ((float) this.f48102r))) {
            this.f48095k = f11;
            this.f48097m = f11;
            this.f48096l = f12;
            this.f48098n = f12;
            this.f48092h = f3;
            this.f48093i = f3;
            this.f48100p = this.f48099o;
            this.f48101q = this.f48087c.onScaleBegin(this);
        }
        if (actionMasked == 2) {
            this.f48095k = f11;
            this.f48096l = f12;
            this.f48092h = f3;
            if (this.f48101q ? this.f48087c.onScale(this) : true) {
                this.f48097m = this.f48095k;
                this.f48098n = this.f48096l;
                this.f48093i = this.f48092h;
                this.f48100p = this.f48099o;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m36094a() {
        return this.f48107w != 0;
    }

    public void setQuickScaleEnabled(boolean z) {
        this.f48090f = z;
        if (z && this.f48084C == null) {
            this.f48084C = new GestureDetector(this.f48086b, new GestureDetector.SimpleOnGestureListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    float unused = ScaleGestureDetector.this.f48105u = motionEvent.getX();
                    float unused2 = ScaleGestureDetector.this.f48106v = motionEvent.getY();
                    int unused3 = ScaleGestureDetector.this.f48107w = 1;
                    return true;
                }
            }, this.f48104t);
        }
    }

    public boolean isQuickScaleEnabled() {
        return this.f48090f;
    }

    public void setStylusScaleEnabled(boolean z) {
        this.f48091g = z;
    }

    public boolean isStylusScaleEnabled() {
        return this.f48091g;
    }

    public boolean isInProgress() {
        return this.f48101q;
    }

    public float getFocusX() {
        return this.f48088d;
    }

    public float getFocusY() {
        return this.f48089e;
    }

    public float getCurrentSpan() {
        return this.f48092h;
    }

    public float getCurrentSpanX() {
        return this.f48095k;
    }

    public float getCurrentSpanY() {
        return this.f48096l;
    }

    public float getPreviousSpan() {
        return this.f48093i;
    }

    public float getPreviousSpanX() {
        return this.f48097m;
    }

    public float getPreviousSpanY() {
        return this.f48098n;
    }

    public float getScaleFactor() {
        if (m36094a()) {
            boolean z = (this.f48085D && this.f48092h < this.f48093i) || (!this.f48085D && this.f48092h > this.f48093i);
            float abs = Math.abs(1.0f - (this.f48092h / this.f48093i)) * 0.5f;
            if (this.f48093i <= 0.0f) {
                return 1.0f;
            }
            return z ? 1.0f + abs : 1.0f - abs;
        }
        float f = this.f48093i;
        if (f > 0.0f) {
            return this.f48092h / f;
        }
        return 1.0f;
    }

    public long getTimeDelta() {
        return this.f48099o - this.f48100p;
    }

    public long getEventTime() {
        return this.f48099o;
    }
}
