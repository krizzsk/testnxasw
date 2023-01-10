package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

public class ShoveGestureDetector extends ProgressiveGesture<OnShoveGestureListener> {

    /* renamed from: m */
    private static final Set<Integer> f25876m;

    /* renamed from: a */
    float f25877a;

    /* renamed from: b */
    float f25878b;

    /* renamed from: l */
    float f25879l = 0.0f;

    /* renamed from: n */
    private float f25880n;

    /* renamed from: o */
    private float f25881o;

    public interface OnShoveGestureListener {
        boolean onShove(ShoveGestureDetector shoveGestureDetector, float f, float f2);

        boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector);

        void onShoveEnd(ShoveGestureDetector shoveGestureDetector, float f, float f2);
    }

    public static class SimpleOnShoveGestureListener implements OnShoveGestureListener {
        public boolean onShove(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
            return false;
        }

        public boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector) {
            return true;
        }

        public void onShoveEnd(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f25876m = hashSet;
        hashSet.add(3);
    }

    public ShoveGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    /* access modifiers changed from: protected */
    public Set<Integer> provideHandledTypes() {
        return f25876m;
    }

    /* access modifiers changed from: protected */
    public boolean analyzeMovement() {
        super.analyzeMovement();
        float d = mo74575d();
        this.f25878b = d;
        this.f25877a += d;
        if (isInProgress() && this.f25878b != 0.0f) {
            return ((OnShoveGestureListener) this.listener).onShove(this, this.f25878b, this.f25877a);
        }
        if (!canExecute(3) || !((OnShoveGestureListener) this.listener).onShoveBegin(this)) {
            return false;
        }
        gestureStarted();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        return super.canExecute(i) && Math.abs(this.f25877a) >= this.f25881o;
    }

    /* access modifiers changed from: protected */
    public boolean isSloppyGesture() {
        return super.isSloppyGesture() || !mo74491a();
    }

    /* access modifiers changed from: protected */
    public void gestureStopped() {
        super.gestureStopped();
        ((OnShoveGestureListener) this.listener).onShoveEnd(this, this.f25834f, this.f25835g);
    }

    /* access modifiers changed from: protected */
    public void reset() {
        super.reset();
        this.f25877a = 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo74491a() {
        float f = getPointDownXY(0).y;
        float f2 = getPointDownXY(1).y;
        float f3 = getPointMoveXY(0).y;
        float f4 = getPointMoveXY(1).y;
        float f5 = getPointDownXY(0).x;
        float f6 = getPointDownXY(1).x;
        float f7 = getPointMoveXY(0).x - f5;
        float f8 = f3 - f;
        float f9 = getPointMoveXY(1).x - f6;
        float f10 = f4 - f2;
        if (Math.abs(f - f2) <= this.f25879l && Math.abs(f5 - f6) >= this.f25879l / 3.0f) {
            return (Math.abs(f7) > 10.0f || Math.abs(f8) > 10.0f || Math.abs(f9) > 10.0f || Math.abs(f10) > 10.0f) && f8 * f10 > 0.0f && ((double) Math.abs(f8)) > ((double) Math.abs(f7)) * 1.16d && ((double) Math.abs(f10)) > ((double) Math.abs(f9)) * 1.16d;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo74575d() {
        return ((getCurrentEvent().getY(getCurrentEvent().findPointerIndex(((Integer) this.f25799c.get(0)).intValue())) + getCurrentEvent().getY(getCurrentEvent().findPointerIndex(((Integer) this.f25799c.get(1)).intValue()))) / 2.0f) - ((getPreviousEvent().getY(getPreviousEvent().findPointerIndex(((Integer) this.f25799c.get(0)).intValue())) + getPreviousEvent().getY(getPreviousEvent().findPointerIndex(((Integer) this.f25799c.get(1)).intValue()))) / 2.0f);
    }

    public float getDeltaPixelsSinceStart() {
        return this.f25877a;
    }

    public float getDeltaPixelSinceLast() {
        return this.f25878b;
    }

    public float getPixelDeltaThreshold() {
        return this.f25881o;
    }

    public void setPixelDeltaThreshold(float f) {
        this.f25881o = f;
    }

    public void setPixelDeltaThresholdResource(int i) {
        setPixelDeltaThreshold(this.context.getResources().getDimension(i));
    }

    public float getMaxShoveAngle() {
        return this.f25880n;
    }

    public void setMaxShoveAngle(float f) {
        this.f25880n = f;
    }

    public void setDeltYdistanceThreshold(float f) {
        this.f25879l = f;
    }

    public void setDeltTwoFingerCloser(int i) {
        setDeltYdistanceThreshold(this.context.getResources().getDimension(i));
    }
}
