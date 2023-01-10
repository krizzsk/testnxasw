package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.didi.hawaii.mapsdk.gesture.ScaleGestureDetector;
import java.util.HashSet;
import java.util.Set;

public class StandardScaleGestureDetector extends ProgressiveGesture<StandardOnScaleGestureListener> {

    /* renamed from: m */
    private static final Set<Integer> f25889m;

    /* renamed from: a */
    ScaleGestureDetector.OnScaleGestureListener f25890a;

    /* renamed from: b */
    float f25891b;

    /* renamed from: l */
    float f25892l;

    /* renamed from: n */
    private ScaleGestureDetector f25893n;

    /* renamed from: o */
    private boolean f25894o;

    /* renamed from: p */
    private boolean f25895p;

    /* renamed from: q */
    private float f25896q;

    /* renamed from: r */
    private float f25897r;

    /* renamed from: s */
    private float f25898s;

    /* renamed from: t */
    private long f25899t;

    /* renamed from: u */
    private long f25900u;

    public static class SimpleStandardOnScaleGestureListener implements StandardOnScaleGestureListener {
        public boolean onScale(StandardScaleGestureDetector standardScaleGestureDetector) {
            return false;
        }

        public boolean onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector) {
            return true;
        }

        public void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector, float f, float f2) {
        }
    }

    public interface StandardOnScaleGestureListener {
        boolean onScale(StandardScaleGestureDetector standardScaleGestureDetector);

        boolean onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector);

        void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector, float f, float f2);
    }

    static {
        HashSet hashSet = new HashSet();
        f25889m = hashSet;
        hashSet.add(1);
    }

    public StandardScaleGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
        C97051 r3 = new ScaleGestureDetector.OnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                return StandardScaleGestureDetector.this.mo74619a(scaleGestureDetector);
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return StandardScaleGestureDetector.this.mo74620b(scaleGestureDetector);
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                StandardScaleGestureDetector.this.mo74621c(scaleGestureDetector);
            }
        };
        this.f25890a = r3;
        this.f25893n = new ScaleGestureDetector(context, r3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo74619a(ScaleGestureDetector scaleGestureDetector) {
        if (this.f25891b == 0.0f) {
            this.f25891b = scaleGestureDetector.getCurrentSpan();
        }
        this.f25892l = Math.abs(this.f25891b - scaleGestureDetector.getCurrentSpan());
        boolean z = false;
        if (!isInProgress() && canExecute(1) && this.f25892l >= this.f25896q) {
            if (!((StandardOnScaleGestureListener) this.listener).onScaleBegin(this)) {
                return false;
            }
            gestureStarted();
            this.f25899t = SystemClock.uptimeMillis();
        }
        if (!isInProgress()) {
            return true;
        }
        if (!canExecute(1)) {
            super.gestureStopped();
            ((StandardOnScaleGestureListener) this.listener).onScaleEnd(this, 0.0f, 0.0f);
            return false;
        }
        if (scaleGestureDetector.getScaleFactor() < 1.0f) {
            z = true;
        }
        this.f25895p = z;
        return ((StandardOnScaleGestureListener) this.listener).onScale(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo74620b(ScaleGestureDetector scaleGestureDetector) {
        this.f25891b = scaleGestureDetector.getCurrentSpan();
        if (canExecute(1)) {
            this.f25833e = VelocityTracker.obtain();
            if (this.f25896q == 0.0f && ((StandardOnScaleGestureListener) this.listener).onScaleBegin(this)) {
                gestureStarted();
                this.f25899t = SystemClock.uptimeMillis();
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo74621c(ScaleGestureDetector scaleGestureDetector) {
        this.f25894o = true;
        gestureStopped();
    }

    /* access modifiers changed from: protected */
    public boolean analyzeEvent(MotionEvent motionEvent) {
        super.analyzeEvent(motionEvent);
        return this.f25893n.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void gestureStopped() {
        if (!isInProgress()) {
            super.gestureStopped();
            return;
        }
        this.f25900u = SystemClock.uptimeMillis();
        if (this.f25894o) {
            this.f25897r = this.f25838j / ((float) this.f25839k);
            super.gestureStopped();
            float f = getPointDownXY(0).y;
            float f2 = getPointDownXY(1).y;
            float f3 = getPointMoveXY(0).y;
            float f4 = getPointMoveXY(1).y;
            float f5 = getPointDownXY(0).x;
            float f6 = getPointDownXY(1).x;
            float f7 = f6 - f5;
            float f8 = f2 - f;
            float f9 = getPointMoveXY(1).x - getPointMoveXY(0).x;
            float f10 = f4 - f3;
            this.f25898s = (float) Math.abs((Math.sqrt((double) ((f9 * f9) + (f10 * f10))) - Math.sqrt((double) ((f7 * f7) + (f8 * f8)))) / ((double) (this.f25900u - this.f25899t)));
            Pair<String, Float> classFyResult = getClassFyResult();
            if (!useNNClassfy() || classFyResult == null) {
                ((StandardOnScaleGestureListener) this.listener).onScaleEnd(this, this.f25834f, this.f25835g);
            } else if (this.f25892l >= this.f25896q && ((String) classFyResult.first).equals(NNGestureClassfy.SCALE_LABLE)) {
                ((StandardOnScaleGestureListener) this.listener).onScaleEnd(this, this.f25834f, this.f25835g);
            }
            this.f25894o = false;
        }
    }

    public void interrupt() {
        super.interrupt();
        this.f25891b = 0.0f;
    }

    /* access modifiers changed from: protected */
    public Set<Integer> provideHandledTypes() {
        return f25889m;
    }

    public boolean isScalingOut() {
        return this.f25895p;
    }

    public ScaleGestureDetector getUnderlyingScaleGestureDetector() {
        return this.f25893n;
    }

    public float getSpanSinceStartThreshold() {
        return this.f25896q;
    }

    public void setSpanSinceStartThreshold(float f) {
        this.f25896q = f;
    }

    public void setSpanSinceStartThresholdResource(int i) {
        setSpanSinceStartThreshold(this.context.getResources().getDimension(i));
    }

    public float getScaleFactor() {
        return this.f25893n.getScaleFactor();
    }

    public float getMoveVelocityAverage() {
        return this.f25897r;
    }

    public float getCustomComputeVelocity() {
        return this.f25898s;
    }
}
