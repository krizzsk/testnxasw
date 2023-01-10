package com.didi.nova.assembly.components.bigimage.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: com.didi.nova.assembly.components.bigimage.photoview.b */
/* compiled from: CustomGestureDetector */
class C11080b {

    /* renamed from: a */
    private static final int f31595a = -1;

    /* renamed from: b */
    private int f31596b = -1;

    /* renamed from: c */
    private int f31597c = 0;

    /* renamed from: d */
    private final ScaleGestureDetector f31598d;

    /* renamed from: e */
    private VelocityTracker f31599e;

    /* renamed from: f */
    private boolean f31600f;

    /* renamed from: g */
    private float f31601g;

    /* renamed from: h */
    private float f31602h;

    /* renamed from: i */
    private final float f31603i;

    /* renamed from: j */
    private final float f31604j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C11081c f31605k;

    C11080b(Context context, C11081c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f31604j = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f31603i = (float) viewConfiguration.getScaledTouchSlop();
        this.f31605k = cVar;
        this.f31598d = new ScaleGestureDetector(context, new CustomGestureDetector$1(this));
    }

    /* renamed from: b */
    private float m24158b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f31597c);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    /* renamed from: c */
    private float m24159c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f31597c);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    /* renamed from: a */
    public boolean mo86051a() {
        return this.f31598d.isInProgress();
    }

    /* renamed from: b */
    public boolean mo86053b() {
        return this.f31600f;
    }

    /* renamed from: a */
    public boolean mo86052a(MotionEvent motionEvent) {
        try {
            this.f31598d.onTouchEvent(motionEvent);
            return m24160d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    /* renamed from: d */
    private boolean m24160d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int i = 0;
        if (action == 0) {
            this.f31596b = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f31599e = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f31601g = m24158b(motionEvent);
            this.f31602h = m24159c(motionEvent);
            this.f31600f = false;
        } else if (action == 1) {
            this.f31596b = -1;
            if (this.f31600f && this.f31599e != null) {
                this.f31601g = m24158b(motionEvent);
                this.f31602h = m24159c(motionEvent);
                this.f31599e.addMovement(motionEvent);
                this.f31599e.computeCurrentVelocity(1000);
                float xVelocity = this.f31599e.getXVelocity();
                float yVelocity = this.f31599e.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f31604j) {
                    this.f31605k.onFling(this.f31601g, this.f31602h, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f31599e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f31599e = null;
            }
        } else if (action == 2) {
            float b = m24158b(motionEvent);
            float c = m24159c(motionEvent);
            float f = b - this.f31601g;
            float f2 = c - this.f31602h;
            if (!this.f31600f) {
                this.f31600f = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.f31603i);
            }
            if (this.f31600f) {
                this.f31605k.onDrag(f, f2);
                this.f31601g = b;
                this.f31602h = c;
                VelocityTracker velocityTracker2 = this.f31599e;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f31596b = -1;
            VelocityTracker velocityTracker3 = this.f31599e;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f31599e = null;
            }
        } else if (action == 6) {
            int a = C11082d.m24164a(motionEvent.getAction());
            if (motionEvent.getPointerId(a) == this.f31596b) {
                int i2 = a == 0 ? 1 : 0;
                this.f31596b = motionEvent.getPointerId(i2);
                this.f31601g = motionEvent.getX(i2);
                this.f31602h = motionEvent.getY(i2);
            }
        }
        int i3 = this.f31596b;
        if (i3 != -1) {
            i = i3;
        }
        this.f31597c = motionEvent.findPointerIndex(i);
        return true;
    }
}
