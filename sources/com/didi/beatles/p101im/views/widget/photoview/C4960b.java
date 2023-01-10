package com.didi.beatles.p101im.views.widget.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: com.didi.beatles.im.views.widget.photoview.b */
/* compiled from: CustomGestureDetector */
class C4960b {

    /* renamed from: a */
    private static final int f12489a = -1;

    /* renamed from: b */
    private int f12490b = -1;

    /* renamed from: c */
    private int f12491c = 0;

    /* renamed from: d */
    private final ScaleGestureDetector f12492d;

    /* renamed from: e */
    private VelocityTracker f12493e;

    /* renamed from: f */
    private boolean f12494f;

    /* renamed from: g */
    private float f12495g;

    /* renamed from: h */
    private float f12496h;

    /* renamed from: i */
    private final float f12497i;

    /* renamed from: j */
    private final float f12498j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C4961c f12499k;

    C4960b(Context context, C4961c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f12498j = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f12497i = (float) viewConfiguration.getScaledTouchSlop();
        this.f12499k = cVar;
        this.f12492d = new ScaleGestureDetector(context, new CustomGestureDetector$1(this));
    }

    /* renamed from: b */
    private float m10653b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f12491c);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    /* renamed from: c */
    private float m10654c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f12491c);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    /* renamed from: a */
    public boolean mo49507a() {
        return this.f12492d.isInProgress();
    }

    /* renamed from: b */
    public boolean mo49509b() {
        return this.f12494f;
    }

    /* renamed from: a */
    public boolean mo49508a(MotionEvent motionEvent) {
        try {
            this.f12492d.onTouchEvent(motionEvent);
            return m10655d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    /* renamed from: d */
    private boolean m10655d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int i = 0;
        if (action == 0) {
            this.f12490b = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f12493e = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f12495g = m10653b(motionEvent);
            this.f12496h = m10654c(motionEvent);
            this.f12494f = false;
        } else if (action == 1) {
            this.f12490b = -1;
            if (this.f12494f && this.f12493e != null) {
                this.f12495g = m10653b(motionEvent);
                this.f12496h = m10654c(motionEvent);
                this.f12493e.addMovement(motionEvent);
                this.f12493e.computeCurrentVelocity(1000);
                float xVelocity = this.f12493e.getXVelocity();
                float yVelocity = this.f12493e.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f12498j) {
                    this.f12499k.onFling(this.f12495g, this.f12496h, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f12493e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f12493e = null;
            }
        } else if (action == 2) {
            float b = m10653b(motionEvent);
            float c = m10654c(motionEvent);
            float f = b - this.f12495g;
            float f2 = c - this.f12496h;
            if (!this.f12494f) {
                this.f12494f = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.f12497i);
            }
            if (this.f12494f) {
                this.f12499k.onDrag(f, f2);
                this.f12495g = b;
                this.f12496h = c;
                VelocityTracker velocityTracker2 = this.f12493e;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f12490b = -1;
            VelocityTracker velocityTracker3 = this.f12493e;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f12493e = null;
            }
        } else if (action == 6) {
            int a = C4962d.m10659a(motionEvent.getAction());
            if (motionEvent.getPointerId(a) == this.f12490b) {
                int i2 = a == 0 ? 1 : 0;
                this.f12490b = motionEvent.getPointerId(i2);
                this.f12495g = motionEvent.getX(i2);
                this.f12496h = motionEvent.getY(i2);
            }
        }
        int i3 = this.f12490b;
        if (i3 != -1) {
            i = i3;
        }
        this.f12491c = motionEvent.findPointerIndex(i);
        return true;
    }
}
