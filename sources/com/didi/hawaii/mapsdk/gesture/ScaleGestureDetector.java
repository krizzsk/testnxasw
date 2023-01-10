package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import com.taxis99.R;

public class ScaleGestureDetector {

    /* renamed from: A */
    private static final int f25846A = 1;

    /* renamed from: B */
    private static final int f25847B = 2;

    /* renamed from: a */
    private static final String f25848a = "ScaleGestureDetector";

    /* renamed from: x */
    private static final long f25849x = 128;

    /* renamed from: y */
    private static final float f25850y = 0.5f;

    /* renamed from: z */
    private static final int f25851z = 0;

    /* renamed from: C */
    private GestureDetector f25852C;

    /* renamed from: D */
    private boolean f25853D;

    /* renamed from: b */
    private final Context f25854b;

    /* renamed from: c */
    private final OnScaleGestureListener f25855c;

    /* renamed from: d */
    private float f25856d;

    /* renamed from: e */
    private float f25857e;

    /* renamed from: f */
    private boolean f25858f;

    /* renamed from: g */
    private boolean f25859g;

    /* renamed from: h */
    private float f25860h;

    /* renamed from: i */
    private float f25861i;

    /* renamed from: j */
    private float f25862j;

    /* renamed from: k */
    private float f25863k;

    /* renamed from: l */
    private float f25864l;

    /* renamed from: m */
    private float f25865m;

    /* renamed from: n */
    private float f25866n;

    /* renamed from: o */
    private long f25867o;

    /* renamed from: p */
    private long f25868p;

    /* renamed from: q */
    private boolean f25869q;

    /* renamed from: r */
    private int f25870r;

    /* renamed from: s */
    private int f25871s;

    /* renamed from: t */
    private final Handler f25872t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public float f25873u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public float f25874v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f25875w;

    public interface OnScaleGestureListener {
        boolean onScale(ScaleGestureDetector scaleGestureDetector);

        boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector);

        void onScaleEnd(ScaleGestureDetector scaleGestureDetector);
    }

    public static class SimpleOnScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
        public boolean onScale(android.view.ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        public boolean onScaleBegin(android.view.ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(android.view.ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener) {
        this(context, onScaleGestureListener, (Handler) null);
    }

    public ScaleGestureDetector(Context context, OnScaleGestureListener onScaleGestureListener, Handler handler) {
        this.f25875w = 0;
        this.f25854b = context;
        this.f25855c = onScaleGestureListener;
        this.f25870r = ViewConfiguration.get(context).getScaledTouchSlop();
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT >= 24) {
            this.f25871s = resources.getDimensionPixelSize(R.dimen.dmap_internalScaleMinSpan24);
        } else {
            this.f25871s = resources.getDimensionPixelSize(R.dimen.dmap_internalScaleMinSpan23);
        }
        this.f25872t = handler;
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
        this.f25867o = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f25858f) {
            this.f25852C.onTouchEvent(motionEvent2);
        }
        int pointerCount = motionEvent.getPointerCount();
        boolean z = (motionEvent.getButtonState() & 32) != 0;
        boolean z2 = this.f25875w == 2 && !z;
        boolean z3 = actionMasked == 1 || actionMasked == 3 || z2;
        float f4 = 0.0f;
        if (actionMasked == 0 || z3) {
            if (this.f25869q) {
                this.f25855c.onScaleEnd(this);
                this.f25869q = false;
                this.f25862j = 0.0f;
                this.f25875w = 0;
            } else if (m20475a() && z3) {
                this.f25869q = false;
                this.f25862j = 0.0f;
                this.f25875w = 0;
            }
            if (z3) {
                return true;
            }
        }
        if (!this.f25869q && this.f25859g && !m20475a() && !z3 && z) {
            this.f25873u = motionEvent.getX();
            this.f25874v = motionEvent.getY();
            this.f25875w = 2;
            this.f25862j = 0.0f;
        }
        boolean z4 = actionMasked == 0 || actionMasked == 6 || actionMasked == 5 || z2;
        boolean z5 = actionMasked == 6;
        int actionIndex = z5 ? motionEvent.getActionIndex() : -1;
        int i = z5 ? pointerCount - 1 : pointerCount;
        if (m20475a()) {
            f2 = this.f25873u;
            f = this.f25874v;
            if (motionEvent.getY() < f) {
                this.f25853D = true;
            } else {
                this.f25853D = false;
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
        if (m20475a()) {
            f3 = f12;
        } else {
            f3 = (float) Math.hypot((double) f11, (double) f12);
        }
        boolean z6 = this.f25869q;
        this.f25856d = f2;
        this.f25857e = f;
        if (!m20475a() && this.f25869q && (f3 < ((float) this.f25871s) || z4)) {
            this.f25855c.onScaleEnd(this);
            this.f25869q = false;
            this.f25862j = f3;
        }
        if (z4) {
            this.f25863k = f11;
            this.f25865m = f11;
            this.f25864l = f12;
            this.f25866n = f12;
            this.f25860h = f3;
            this.f25861i = f3;
            this.f25862j = f3;
        }
        int i4 = m20475a() ? this.f25870r : this.f25871s;
        if (!this.f25869q && f3 >= ((float) i4) && (z6 || Math.abs(f3 - this.f25862j) > ((float) this.f25870r))) {
            this.f25863k = f11;
            this.f25865m = f11;
            this.f25864l = f12;
            this.f25866n = f12;
            this.f25860h = f3;
            this.f25861i = f3;
            this.f25868p = this.f25867o;
            this.f25869q = this.f25855c.onScaleBegin(this);
        }
        if (actionMasked == 2) {
            this.f25863k = f11;
            this.f25864l = f12;
            this.f25860h = f3;
            if (this.f25869q ? this.f25855c.onScale(this) : true) {
                this.f25865m = this.f25863k;
                this.f25866n = this.f25864l;
                this.f25861i = this.f25860h;
                this.f25868p = this.f25867o;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m20475a() {
        return this.f25875w != 0;
    }

    public void setQuickScaleEnabled(boolean z) {
        this.f25858f = z;
        if (z && this.f25852C == null) {
            this.f25852C = new GestureDetector(this.f25854b, new GestureDetector.SimpleOnGestureListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    float unused = ScaleGestureDetector.this.f25873u = motionEvent.getX();
                    float unused2 = ScaleGestureDetector.this.f25874v = motionEvent.getY();
                    int unused3 = ScaleGestureDetector.this.f25875w = 1;
                    return true;
                }
            }, this.f25872t);
        }
    }

    public boolean isQuickScaleEnabled() {
        return this.f25858f;
    }

    public void setStylusScaleEnabled(boolean z) {
        this.f25859g = z;
    }

    public boolean isStylusScaleEnabled() {
        return this.f25859g;
    }

    public boolean isInProgress() {
        return this.f25869q;
    }

    public float getFocusX() {
        return this.f25856d;
    }

    public float getFocusY() {
        return this.f25857e;
    }

    public float getCurrentSpan() {
        return this.f25860h;
    }

    public float getCurrentSpanX() {
        return this.f25863k;
    }

    public float getCurrentSpanY() {
        return this.f25864l;
    }

    public float getPreviousSpan() {
        return this.f25861i;
    }

    public float getPreviousSpanX() {
        return this.f25865m;
    }

    public float getPreviousSpanY() {
        return this.f25866n;
    }

    public float getScaleFactor() {
        if (m20475a()) {
            boolean z = (this.f25853D && this.f25860h < this.f25861i) || (!this.f25853D && this.f25860h > this.f25861i);
            float abs = Math.abs(1.0f - (this.f25860h / this.f25861i)) * 0.5f;
            if (this.f25861i <= 0.0f) {
                return 1.0f;
            }
            return z ? 1.0f + abs : 1.0f - abs;
        }
        float f = this.f25861i;
        if (f > 0.0f) {
            return this.f25860h / f;
        }
        return 1.0f;
    }

    public long getTimeDelta() {
        return this.f25867o - this.f25868p;
    }

    public long getEventTime() {
        return this.f25867o;
    }
}
