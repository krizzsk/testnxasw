package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MoveGestureDetector extends ProgressiveGesture<OnMoveGestureListener> {

    /* renamed from: l */
    private static final int f25783l = 2;

    /* renamed from: m */
    private static final Set<Integer> f25784m;

    /* renamed from: a */
    float f25785a;

    /* renamed from: b */
    float f25786b;

    /* renamed from: n */
    private PointF f25787n;

    /* renamed from: o */
    private boolean f25788o;

    /* renamed from: p */
    private float f25789p;

    /* renamed from: q */
    private final Map<Integer, MoveDistancesObject> f25790q = new HashMap();

    public interface OnMoveGestureListener {
        boolean onMove(MoveGestureDetector moveGestureDetector, float f, float f2);

        boolean onMoveBegin(MoveGestureDetector moveGestureDetector);

        void onMoveEnd(MoveGestureDetector moveGestureDetector, float f, float f2);
    }

    public static class SimpleOnMoveGestureListener implements OnMoveGestureListener {
        public boolean onMove(MoveGestureDetector moveGestureDetector, float f, float f2) {
            return false;
        }

        public boolean onMoveBegin(MoveGestureDetector moveGestureDetector) {
            return true;
        }

        public void onMoveEnd(MoveGestureDetector moveGestureDetector, float f, float f2) {
        }
    }

    /* access modifiers changed from: protected */
    public int getRequiredPointersCount() {
        return 2;
    }

    static {
        HashSet hashSet = new HashSet();
        f25784m = hashSet;
        hashSet.add(13);
    }

    public MoveGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    /* access modifiers changed from: protected */
    public Set<Integer> provideHandledTypes() {
        return f25784m;
    }

    /* access modifiers changed from: protected */
    public boolean analyzeEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.f25790q.clear();
            } else if (actionMasked == 3) {
                this.f25790q.clear();
            } else if (actionMasked != 5) {
                if (actionMasked == 6) {
                    this.f25788o = true;
                    this.f25790q.remove(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
                }
            }
            return super.analyzeEvent(motionEvent);
        }
        this.f25788o = true;
        this.f25790q.put(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())), new MoveDistancesObject(motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex())));
        return super.analyzeEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public boolean analyzeMovement() {
        super.analyzeMovement();
        m20459d();
        if (isInProgress()) {
            if (!canExecute(13)) {
                super.gestureStopped();
                ((OnMoveGestureListener) this.listener).onMoveEnd(this, 0.0f, 0.0f);
                return false;
            }
            PointF focalPoint = getFocalPoint();
            this.f25785a = this.f25787n.x - focalPoint.x;
            this.f25786b = this.f25787n.y - focalPoint.y;
            this.f25787n = focalPoint;
            if (!this.f25788o) {
                return ((OnMoveGestureListener) this.listener).onMove(this, this.f25785a, this.f25786b);
            }
            this.f25788o = false;
            return ((OnMoveGestureListener) this.listener).onMove(this, 0.0f, 0.0f);
        } else if (!canExecute(13) || !((OnMoveGestureListener) this.listener).onMoveBegin(this)) {
            return false;
        } else {
            gestureStarted();
            this.f25787n = getFocalPoint();
            this.f25788o = false;
            return true;
        }
    }

    /* renamed from: d */
    private void m20459d() {
        for (Integer intValue : this.f25799c) {
            int intValue2 = intValue.intValue();
            this.f25790q.get(Integer.valueOf(intValue2)).addNewPosition(getCurrentEvent().getX(getCurrentEvent().findPointerIndex(intValue2)), getCurrentEvent().getY(getCurrentEvent().findPointerIndex(intValue2)));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo74491a() {
        Class<float> cls = float.class;
        int size = this.f25790q.size();
        if (size < 2) {
            return false;
        }
        int[] iArr = new int[2];
        iArr[1] = size;
        iArr[0] = size;
        float[][] fArr = (float[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = size;
        iArr2[0] = size;
        float[][] fArr2 = (float[][]) Array.newInstance(cls, iArr2);
        int i = 0;
        for (MoveDistancesObject next : this.f25790q.values()) {
            fArr[0][i] = next.getDistanceXSinceLast();
            fArr2[0][i] = next.getDistanceYSinceLast();
            fArr[1][i] = next.getDistanceXSinceStart();
            fArr2[1][i] = next.getDistanceYSinceStart();
            i++;
        }
        double sqrt = Math.sqrt((double) ((fArr[0][0] * fArr[0][0]) + (fArr2[0][0] * fArr2[0][0])));
        double sqrt2 = Math.sqrt((double) ((fArr[0][1] * fArr[0][1]) + (fArr2[0][1] * fArr2[0][1])));
        char c = !isInScaleOrRotate();
        float f = isInScaleOrRotate() ? 10.0f : this.f25789p;
        return (fArr[c][0] * fArr[c][1] > 0.0f || fArr2[c][0] * fArr2[c][1] > 0.0f) && (Math.abs(fArr[c][0] + fArr[c][1]) > f || Math.abs(fArr2[c][0] + fArr2[c][1]) > f) && Math.acos(((double) ((fArr[0][0] * fArr[0][1]) + (fArr2[0][0] * fArr2[0][1]))) / (sqrt * sqrt2)) < 1.121997376282069d;
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        return super.canExecute(i) && mo74491a();
    }

    /* access modifiers changed from: protected */
    public void reset() {
        super.reset();
    }

    /* access modifiers changed from: protected */
    public void gestureStopped() {
        super.gestureStopped();
        ((OnMoveGestureListener) this.listener).onMoveEnd(this, this.f25834f, this.f25835g);
    }

    public float getMoveThreshold() {
        return this.f25789p;
    }

    public void setMoveThreshold(float f) {
        this.f25789p = f;
    }

    public void setMoveThresholdResource(int i) {
        setMoveThreshold(this.context.getResources().getDimension(i));
    }

    public float getLastDistanceX() {
        return this.f25785a;
    }

    public float getLastDistanceY() {
        return this.f25786b;
    }

    public MoveDistancesObject getMoveObject(int i) {
        if (!isInProgress() || i < 0 || i >= getPointersCount()) {
            return null;
        }
        return this.f25790q.get(this.f25799c.get(i));
    }
}
