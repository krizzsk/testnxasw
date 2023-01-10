package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

public class SidewaysShoveGestureDetector extends ProgressiveGesture<OnSidewaysShoveGestureListener> {

    /* renamed from: l */
    private static final Set<Integer> f25882l;

    /* renamed from: a */
    float f25883a;

    /* renamed from: b */
    float f25884b;

    /* renamed from: m */
    private float f25885m;

    /* renamed from: n */
    private float f25886n;

    public interface OnSidewaysShoveGestureListener {
        boolean onSidewaysShove(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2);

        boolean onSidewaysShoveBegin(SidewaysShoveGestureDetector sidewaysShoveGestureDetector);

        void onSidewaysShoveEnd(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2);
    }

    public static class SimpleOnSidewaysShoveGestureListener implements OnSidewaysShoveGestureListener {
        public boolean onSidewaysShove(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2) {
            return false;
        }

        public boolean onSidewaysShoveBegin(SidewaysShoveGestureDetector sidewaysShoveGestureDetector) {
            return true;
        }

        public void onSidewaysShoveEnd(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f25882l = hashSet;
        hashSet.add(14);
    }

    public SidewaysShoveGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    /* access modifiers changed from: protected */
    public Set<Integer> provideHandledTypes() {
        return f25882l;
    }

    /* access modifiers changed from: protected */
    public boolean analyzeMovement() {
        super.analyzeMovement();
        float d = mo74588d();
        this.f25884b = d;
        this.f25883a += d;
        if (isInProgress() && this.f25884b != 0.0f) {
            return ((OnSidewaysShoveGestureListener) this.listener).onSidewaysShove(this, this.f25884b, this.f25883a);
        }
        if (!canExecute(14) || !((OnSidewaysShoveGestureListener) this.listener).onSidewaysShoveBegin(this)) {
            return false;
        }
        gestureStarted();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        return Math.abs(this.f25883a) >= this.f25886n && super.canExecute(i);
    }

    /* access modifiers changed from: protected */
    public boolean isSloppyGesture() {
        return super.isSloppyGesture() || !mo74491a();
    }

    /* access modifiers changed from: protected */
    public void gestureStopped() {
        super.gestureStopped();
        ((OnSidewaysShoveGestureListener) this.listener).onSidewaysShoveEnd(this, this.f25834f, this.f25835g);
    }

    /* access modifiers changed from: protected */
    public void reset() {
        super.reset();
        this.f25883a = 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo74491a() {
        MultiFingerDistancesObject multiFingerDistancesObject = (MultiFingerDistancesObject) this.f25800d.get(new PointerDistancePair((Integer) this.f25799c.get(0), (Integer) this.f25799c.get(1)));
        if (Math.abs(Math.toDegrees(Math.abs(Math.atan2((double) multiFingerDistancesObject.getCurrFingersDiffY(), (double) multiFingerDistancesObject.getCurrFingersDiffX()))) - 90.0d) <= ((double) this.f25885m)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo74588d() {
        return ((getCurrentEvent().getX(getCurrentEvent().findPointerIndex(((Integer) this.f25799c.get(0)).intValue())) + getCurrentEvent().getX(getCurrentEvent().findPointerIndex(((Integer) this.f25799c.get(1)).intValue()))) / 2.0f) - ((getPreviousEvent().getX(getPreviousEvent().findPointerIndex(((Integer) this.f25799c.get(0)).intValue())) + getPreviousEvent().getX(getPreviousEvent().findPointerIndex(((Integer) this.f25799c.get(1)).intValue()))) / 2.0f);
    }

    public float getDeltaPixelsSinceStart() {
        return this.f25883a;
    }

    public float getDeltaPixelSinceLast() {
        return this.f25884b;
    }

    public float getPixelDeltaThreshold() {
        return this.f25886n;
    }

    public void setPixelDeltaThreshold(float f) {
        this.f25886n = f;
    }

    public void setPixelDeltaThresholdResource(int i) {
        setPixelDeltaThreshold(this.context.getResources().getDimension(i));
    }

    public float getMaxShoveAngle() {
        return this.f25885m;
    }

    public void setMaxShoveAngle(float f) {
        this.f25885m = f;
    }
}
