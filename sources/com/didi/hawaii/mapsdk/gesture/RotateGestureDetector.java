package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.util.Pair;
import java.util.HashSet;
import java.util.Set;

public class RotateGestureDetector extends ProgressiveGesture<OnRotateGestureListener> {

    /* renamed from: l */
    private static final Set<Integer> f25841l;

    /* renamed from: n */
    private static final float f25842n = ((float) Math.cos(0.0017453292780017621d));

    /* renamed from: a */
    float f25843a;

    /* renamed from: b */
    float f25844b;

    /* renamed from: m */
    private float f25845m;

    public interface OnRotateGestureListener {
        boolean onRotate(RotateGestureDetector rotateGestureDetector, float f);

        boolean onRotateBegin(RotateGestureDetector rotateGestureDetector);

        void onRotateEnd(RotateGestureDetector rotateGestureDetector, float f, float f2, float f3);
    }

    public static class SimpleOnRotateGestureListener implements OnRotateGestureListener {
        public boolean onRotate(RotateGestureDetector rotateGestureDetector, float f) {
            return true;
        }

        public boolean onRotateBegin(RotateGestureDetector rotateGestureDetector) {
            return true;
        }

        public void onRotateEnd(RotateGestureDetector rotateGestureDetector, float f, float f2, float f3) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f25841l = hashSet;
        hashSet.add(2);
    }

    public RotateGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    /* access modifiers changed from: protected */
    public Set<Integer> provideHandledTypes() {
        return f25841l;
    }

    /* access modifiers changed from: protected */
    public boolean analyzeMovement() {
        super.analyzeMovement();
        if (isInProgress()) {
            if (!canExecute(2)) {
                super.gestureStopped();
                ((OnRotateGestureListener) this.listener).onRotateEnd(this, 0.0f, 0.0f, 0.0f);
                return false;
            }
            this.f25844b = mo74491a();
            return ((OnRotateGestureListener) this.listener).onRotate(this, this.f25844b);
        } else if (!canExecute(2) || !((OnRotateGestureListener) this.listener).onRotateBegin(this)) {
            return false;
        } else {
            gestureStarted();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        float f = getPointDownXY(0).y;
        float f2 = getPointDownXY(1).y;
        float f3 = getPointMoveXY(0).y;
        float f4 = getPointMoveXY(1).y;
        float f5 = getPointDownXY(0).x;
        float f6 = getPointDownXY(1).x;
        float f7 = getPointMoveXY(0).x;
        float f8 = getPointMoveXY(1).x;
        float f9 = this.f25845m;
        double d = (double) f9;
        if ((f3 - f) * (f4 - f2) > 0.0f) {
            d = f9 > 16.3f ? (double) f9 : 16.299999237060547d;
        }
        float f10 = f6 - f5;
        float f11 = f2 - f;
        float f12 = f8 - f7;
        float f13 = f4 - f3;
        double sqrt = ((double) ((f10 * f12) + (f11 * f13))) / (Math.sqrt((double) ((f10 * f10) + (f11 * f11))) * Math.sqrt((double) ((f12 * f12) + (f13 * f13))));
        if (Math.abs(sqrt) >= ((double) f25842n) || Math.abs((Math.acos(sqrt) * 180.0d) / 3.141592653589793d) <= d) {
            return false;
        }
        return super.canExecute(i);
    }

    /* access modifiers changed from: protected */
    public void gestureStopped() {
        super.gestureStopped();
        if (this.f25844b == 0.0f) {
            this.f25834f = 0.0f;
            this.f25835g = 0.0f;
        }
        if (Math.abs(this.f25844b) > 2.0f && Math.abs(this.f25834f) < 1.0f && Math.abs(this.f25835g) < 1.0f) {
            this.f25834f = this.f25844b * 500.0f;
            this.f25835g = this.f25844b * 500.0f;
        }
        boolean z = true;
        Pair<String, Float> classFyResult = getClassFyResult();
        if (useNNClassfy() && classFyResult != null && !((String) classFyResult.first).equals(NNGestureClassfy.ROTATE_LABLE)) {
            z = false;
        }
        if (!z) {
            return;
        }
        if (Math.abs(this.f25834f) + Math.abs(this.f25835g) < 500.0f) {
            ((OnRotateGestureListener) this.listener).onRotateEnd(this, 0.0f, 0.0f, 0.0f);
            return;
        }
        ((OnRotateGestureListener) this.listener).onRotateEnd(this, this.f25834f, this.f25835g, mo74542a(this.f25834f, this.f25835g));
    }

    /* access modifiers changed from: protected */
    public void reset() {
        super.reset();
        this.f25843a = 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo74491a() {
        double d;
        MultiFingerDistancesObject multiFingerDistancesObject = (MultiFingerDistancesObject) this.f25800d.get(new PointerDistancePair((Integer) this.f25799c.get(0), (Integer) this.f25799c.get(1)));
        float prevFingersDiffX = multiFingerDistancesObject.getPrevFingersDiffX();
        float currFingersDiffX = multiFingerDistancesObject.getCurrFingersDiffX();
        float prevFingersDiffY = multiFingerDistancesObject.getPrevFingersDiffY();
        float currFingersDiffY = multiFingerDistancesObject.getCurrFingersDiffY();
        double sqrt = ((double) ((prevFingersDiffX * currFingersDiffX) + (prevFingersDiffY * currFingersDiffY))) / (Math.sqrt((double) ((prevFingersDiffX * prevFingersDiffX) + (prevFingersDiffY * prevFingersDiffY))) * Math.sqrt((double) ((currFingersDiffX * currFingersDiffX) + (currFingersDiffY * currFingersDiffY))));
        if (Math.abs(sqrt) < ((double) f25842n)) {
            d = (Math.acos(sqrt) * 180.0d) / 3.141592653589793d;
            if ((prevFingersDiffX * currFingersDiffY) - (prevFingersDiffY * currFingersDiffX) > 0.0f) {
                d = -d;
            }
        } else {
            d = 0.0d;
        }
        return (float) d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo74542a(float f, float f2) {
        float abs = Math.abs((float) (((double) ((getFocalPoint().x * f2) + (getFocalPoint().y * f))) / (Math.pow((double) getFocalPoint().x, 2.0d) + Math.pow((double) getFocalPoint().y, 2.0d))));
        return this.f25844b < 0.0f ? -abs : abs;
    }

    public float getDeltaSinceStart() {
        return this.f25843a;
    }

    public float getDeltaSinceLast() {
        return this.f25844b;
    }

    public float getAngleThreshold() {
        return this.f25845m;
    }

    public void setAngleThreshold(float f) {
        this.f25845m = f;
    }

    public void setAngleThresholdWhenMove(float f) {
        if (f > this.f25845m) {
            this.f25845m = f;
        }
    }
}
