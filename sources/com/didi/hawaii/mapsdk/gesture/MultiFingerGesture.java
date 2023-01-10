package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class MultiFingerGesture<L> extends BaseGesture<L> {

    /* renamed from: a */
    private static final float f25797a = 0.67f;

    /* renamed from: b */
    private static final int f25798b = 2;

    /* renamed from: c */
    final List<Integer> f25799c = new ArrayList();

    /* renamed from: d */
    final HashMap<PointerDistancePair, MultiFingerDistancesObject> f25800d = new HashMap<>();

    /* renamed from: e */
    private final float f25801e;

    /* renamed from: f */
    private float f25802f;

    /* renamed from: g */
    private final C9706a f25803g = new C9706a();

    /* renamed from: h */
    private PointF f25804h = new PointF();

    /* access modifiers changed from: protected */
    public boolean analyzeMovement() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getRequiredPointersCount() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public void reset() {
    }

    public MultiFingerGesture(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
        this.f25801e = (float) ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    /* access modifiers changed from: protected */
    public boolean analyzeEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        boolean a = this.f25803g.mo74633a(actionMasked, motionEvent.getPointerCount(), this.f25799c.size());
        if (a) {
            if (this instanceof ProgressiveGesture) {
                ProgressiveGesture progressiveGesture = (ProgressiveGesture) this;
                if (progressiveGesture.isInProgress()) {
                    progressiveGesture.gestureStopped();
                }
            }
            this.f25799c.clear();
            this.f25800d.clear();
        }
        if (!a || actionMasked == 0) {
            m20461a(motionEvent);
        }
        if (!a && actionMasked == 2 && this.f25799c.size() >= getRequiredPointersCount() && mo74512b()) {
            mo74538c();
            if (!isSloppyGesture()) {
                this.f25804h = Utils.determineFocalPoint(motionEvent);
                return analyzeMovement();
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m20461a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            this.f25799c.add(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
        } else if (actionMasked == 1 || actionMasked == 6) {
            this.f25799c.remove(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo74512b() {
        return getCurrentEvent().getPressure() / getPreviousEvent().getPressure() > f25797a;
    }

    /* renamed from: a */
    private boolean mo74491a() {
        for (MultiFingerDistancesObject currFingersDiffXY : this.f25800d.values()) {
            if (currFingersDiffXY.getCurrFingersDiffXY() < this.f25802f) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isSloppyGesture() {
        boolean z;
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.widthPixels) - this.f25801e;
        float f2 = this.f25801e;
        float f3 = ((float) displayMetrics.heightPixels) - f2;
        for (Integer intValue : this.f25799c) {
            int findPointerIndex = getCurrentEvent().findPointerIndex(intValue.intValue());
            float rawX = Utils.getRawX(getCurrentEvent(), findPointerIndex);
            float rawY = Utils.getRawY(getCurrentEvent(), findPointerIndex);
            if (rawX < f2 || rawY < f2 || rawX > f || rawY > f3) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return true;
            }
        }
        return mo74491a();
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        return super.canExecute(i) && !isSloppyGesture();
    }

    /* renamed from: c */
    private void mo74538c() {
        this.f25800d.clear();
        int i = 0;
        while (i < this.f25799c.size() - 1) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f25799c.size(); i3++) {
                int intValue = this.f25799c.get(i).intValue();
                int intValue2 = this.f25799c.get(i3).intValue();
                float x = getPreviousEvent().getX(getPreviousEvent().findPointerIndex(intValue));
                float y = getPreviousEvent().getY(getPreviousEvent().findPointerIndex(intValue));
                float x2 = getPreviousEvent().getX(getPreviousEvent().findPointerIndex(intValue2)) - x;
                float y2 = getPreviousEvent().getY(getPreviousEvent().findPointerIndex(intValue2)) - y;
                float x3 = getCurrentEvent().getX(getCurrentEvent().findPointerIndex(intValue));
                float y3 = getCurrentEvent().getY(getCurrentEvent().findPointerIndex(intValue));
                this.f25800d.put(new PointerDistancePair(Integer.valueOf(intValue), Integer.valueOf(intValue2)), new MultiFingerDistancesObject(x2, y2, getCurrentEvent().getX(getCurrentEvent().findPointerIndex(intValue2)) - x3, getCurrentEvent().getY(getCurrentEvent().findPointerIndex(intValue2)) - y3));
            }
            i = i2;
        }
    }

    public float getCurrentSpan(int i, int i2) {
        if (m20463a(i, i2)) {
            return this.f25800d.get(new PointerDistancePair(this.f25799c.get(i), this.f25799c.get(i2))).getCurrFingersDiffXY();
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    public float getPreviousSpan(int i, int i2) {
        if (m20463a(i, i2)) {
            return this.f25800d.get(new PointerDistancePair(this.f25799c.get(i), this.f25799c.get(i2))).getPrevFingersDiffXY();
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    public float getCurrentSpanX(int i, int i2) {
        if (m20463a(i, i2)) {
            return Math.abs(this.f25800d.get(new PointerDistancePair(this.f25799c.get(i), this.f25799c.get(i2))).getCurrFingersDiffX());
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    public float getCurrentSpanY(int i, int i2) {
        if (m20463a(i, i2)) {
            return Math.abs(this.f25800d.get(new PointerDistancePair(this.f25799c.get(i), this.f25799c.get(i2))).getCurrFingersDiffY());
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    public float getPreviousSpanX(int i, int i2) {
        if (m20463a(i, i2)) {
            return Math.abs(this.f25800d.get(new PointerDistancePair(this.f25799c.get(i), this.f25799c.get(i2))).getPrevFingersDiffX());
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    public float getPreviousSpanY(int i, int i2) {
        if (m20463a(i, i2)) {
            return Math.abs(this.f25800d.get(new PointerDistancePair(this.f25799c.get(i), this.f25799c.get(i2))).getPrevFingersDiffY());
        }
        throw new NoSuchElementException("There is no such pair of pointers!");
    }

    /* renamed from: a */
    private boolean m20463a(int i, int i2) {
        return i != i2 && i >= 0 && i2 >= 0 && i < getPointersCount() && i2 < getPointersCount();
    }

    public int getPointersCount() {
        return this.f25799c.size();
    }

    public PointF getFocalPoint() {
        return this.f25804h;
    }

    public float getSpanThreshold() {
        return this.f25802f;
    }

    public void setSpanThreshold(float f) {
        this.f25802f = f;
    }

    public void setSpanThresholdResource(int i) {
        setSpanThreshold(this.context.getResources().getDimension(i));
    }
}
