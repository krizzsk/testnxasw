package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Set;

public abstract class ProgressiveGesture<L> extends MultiFingerGesture<L> {

    /* renamed from: a */
    private final Set<Integer> f25831a = provideHandledTypes();

    /* renamed from: b */
    private boolean f25832b;

    /* renamed from: e */
    VelocityTracker f25833e;

    /* renamed from: f */
    float f25834f;

    /* renamed from: g */
    float f25835g;

    /* renamed from: h */
    float f25836h;

    /* renamed from: i */
    float f25837i;

    /* renamed from: j */
    float f25838j;

    /* renamed from: k */
    int f25839k;

    /* renamed from: l */
    private boolean f25840l;

    /* access modifiers changed from: protected */
    public abstract Set<Integer> provideHandledTypes();

    public ProgressiveGesture(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    /* access modifiers changed from: protected */
    public boolean analyzeEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.f25840l) {
            this.f25840l = false;
            gestureStopped();
        }
        VelocityTracker velocityTracker2 = this.f25833e;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(getCurrentEvent());
        }
        boolean analyzeEvent = super.analyzeEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            VelocityTracker velocityTracker3 = this.f25833e;
            if (velocityTracker3 != null) {
                velocityTracker3.clear();
                this.f25838j = 0.0f;
                this.f25839k = 0;
            }
        } else if (actionMasked == 1 || actionMasked == 6) {
            if (this.f25799c.size() < getRequiredPointersCount() && this.f25832b) {
                gestureStopped();
                return true;
            }
        } else if (actionMasked == 3) {
            VelocityTracker velocityTracker4 = this.f25833e;
            if (velocityTracker4 != null) {
                velocityTracker4.clear();
                this.f25838j = 0.0f;
                this.f25839k = 0;
            }
            if (this.f25832b) {
                gestureStopped();
                return true;
            }
        } else if (actionMasked == 2 && (velocityTracker = this.f25833e) != null) {
            velocityTracker.computeCurrentVelocity(1000);
            this.f25836h = this.f25833e.getXVelocity();
            this.f25837i = this.f25833e.getYVelocity();
            this.f25838j += Math.abs(this.f25836h) + Math.abs(this.f25837i);
            this.f25839k++;
        }
        return analyzeEvent;
    }

    /* access modifiers changed from: protected */
    public void gestureStarted() {
        this.f25832b = true;
        if (this.f25833e == null) {
            this.f25833e = VelocityTracker.obtain();
        }
    }

    /* access modifiers changed from: protected */
    public void gestureStopped() {
        this.f25832b = false;
        VelocityTracker velocityTracker = this.f25833e;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000);
            this.f25834f = this.f25833e.getXVelocity();
            this.f25835g = this.f25833e.getYVelocity();
            this.f25838j = 0.0f;
            this.f25839k = 0;
            this.f25833e.recycle();
            this.f25833e = null;
        }
        reset();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Set<Integer> mo74538c() {
        return this.f25831a;
    }

    public boolean isInProgress() {
        return this.f25832b;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            interrupt();
        }
    }

    public void interrupt() {
        if (isInProgress()) {
            this.f25840l = true;
        }
    }
}
