package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Iterator;

public class MultiFingerTapGestureDetector extends MultiFingerGesture<OnMultiFingerTapGestureListener> {

    /* renamed from: a */
    private long f25805a;

    /* renamed from: b */
    private float f25806b;

    /* renamed from: e */
    private boolean f25807e;

    /* renamed from: f */
    private boolean f25808f;

    /* renamed from: g */
    private int f25809g;

    public interface OnMultiFingerTapGestureListener {
        boolean onMultiFingerDown(MotionEvent motionEvent);

        boolean onMultiFingerTap(MultiFingerTapGestureDetector multiFingerTapGestureDetector, int i);

        boolean onMultiFingerUp(MotionEvent motionEvent);
    }

    public MultiFingerTapGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    /* access modifiers changed from: protected */
    public boolean analyzeEvent(MotionEvent motionEvent) {
        super.analyzeEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        boolean z = false;
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked == 5) {
                    if (this.f25808f) {
                        this.f25807e = true;
                    }
                    this.f25809g = this.f25799c.size();
                    if (canExecute(4)) {
                        return ((OnMultiFingerTapGestureListener) this.listener).onMultiFingerDown(motionEvent);
                    }
                } else if (actionMasked == 6) {
                    this.f25808f = true;
                    if (canExecute(4)) {
                        return ((OnMultiFingerTapGestureListener) this.listener).onMultiFingerUp(motionEvent);
                    }
                }
            } else if (!this.f25807e) {
                this.f25807e = mo74525a(this.f25800d);
            }
            return false;
        }
        if (canExecute(4)) {
            z = ((OnMultiFingerTapGestureListener) this.listener).onMultiFingerTap(this, this.f25809g);
        }
        reset();
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo74525a(HashMap<PointerDistancePair, MultiFingerDistancesObject> hashMap) {
        boolean z;
        Iterator<MultiFingerDistancesObject> it = hashMap.values().iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            MultiFingerDistancesObject next = it.next();
            float abs = Math.abs(next.getCurrFingersDiffX() - next.getPrevFingersDiffX());
            float abs2 = Math.abs(next.getCurrFingersDiffY() - next.getPrevFingersDiffY());
            float f = this.f25806b;
            if (abs > f || abs2 > f) {
                z = true;
            }
            this.f25807e = z;
        } while (!z);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        if (this.f25809g <= 1 || this.f25807e || getGestureDuration() >= this.f25805a || !super.canExecute(i)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void reset() {
        super.reset();
        this.f25809g = 0;
        this.f25807e = false;
        this.f25808f = false;
    }

    public long getMultiFingerTapTimeThreshold() {
        return this.f25805a;
    }

    public void setMultiFingerTapTimeThreshold(long j) {
        this.f25805a = j;
    }

    public float getMultiFingerTapMovementThreshold() {
        return this.f25806b;
    }

    public void setMultiFingerTapMovementThreshold(float f) {
        this.f25806b = f;
    }

    public void setMultiFingerTapMovementThresholdResource(int i) {
        setMultiFingerTapMovementThreshold(this.context.getResources().getDimension(i));
    }
}
