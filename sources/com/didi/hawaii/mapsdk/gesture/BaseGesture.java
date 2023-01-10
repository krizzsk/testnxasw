package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.graphics.PointF;
import android.util.Pair;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Set;

public abstract class BaseGesture<L> {

    /* renamed from: j */
    private static final int f25759j = 255;

    /* renamed from: k */
    private static final int f25760k = 6;

    /* renamed from: l */
    private static final int f25761l = 5;

    /* renamed from: a */
    private final AndroidGesturesManager f25762a;

    /* renamed from: b */
    private MotionEvent f25763b;

    /* renamed from: c */
    private MotionEvent f25764c;
    protected final Context context;

    /* renamed from: d */
    private PointF f25765d = new PointF();

    /* renamed from: e */
    private PointF f25766e = new PointF();

    /* renamed from: f */
    private PointF f25767f = new PointF();

    /* renamed from: g */
    private PointF f25768g = new PointF();

    /* renamed from: h */
    private long f25769h;

    /* renamed from: i */
    private boolean f25770i = true;
    protected L listener;
    protected boolean mIsMultiTouch;
    protected boolean mIsMultiTouchEnd;

    /* access modifiers changed from: protected */
    public abstract boolean analyzeEvent(MotionEvent motionEvent);

    public BaseGesture(Context context2, AndroidGesturesManager androidGesturesManager) {
        this.context = context2;
        this.f25762a = androidGesturesManager;
    }

    /* access modifiers changed from: protected */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return m20457a(motionEvent);
    }

    /* renamed from: a */
    private boolean m20457a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mIsMultiTouch = false;
        } else if (action != 2) {
            if (action == 5) {
                this.f25767f.set(motionEvent.getX(0), motionEvent.getY(0));
                if (pointerCount > 1) {
                    this.f25768g.set(motionEvent.getX(1), motionEvent.getY(1));
                }
                this.mIsMultiTouch = true;
                this.mIsMultiTouchEnd = false;
            } else if (action == 6 && !this.mIsMultiTouchEnd) {
                this.mIsMultiTouchEnd = true;
            }
        } else if (this.mIsMultiTouch && !this.mIsMultiTouchEnd) {
            this.f25765d.set(motionEvent.getX(0), motionEvent.getY(0));
            if (pointerCount > 1) {
                this.f25766e.set(motionEvent.getX(1), motionEvent.getY(1));
            }
        }
        MotionEvent motionEvent2 = this.f25764c;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f25764c = null;
        }
        MotionEvent motionEvent3 = this.f25763b;
        if (motionEvent3 != null) {
            this.f25764c = MotionEvent.obtain(motionEvent3);
            this.f25763b.recycle();
            this.f25763b = null;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.f25763b = obtain;
        this.f25769h = obtain.getEventTime() - this.f25763b.getDownTime();
        return analyzeEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public boolean canExecute(int i) {
        if (this.listener == null || !this.f25770i) {
            return false;
        }
        if (i == 3) {
            return true;
        }
        for (Set<Integer> next : this.f25762a.getMutuallyExclusiveGestures()) {
            if (next.contains(Integer.valueOf(i))) {
                for (Integer intValue : next) {
                    int intValue2 = intValue.intValue();
                    Iterator<BaseGesture> it = this.f25762a.getDetectors().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            BaseGesture next2 = it.next();
                            if ((next2 instanceof ProgressiveGesture) && i != intValue2) {
                                ProgressiveGesture progressiveGesture = (ProgressiveGesture) next2;
                                if (progressiveGesture.mo74538c().contains(Integer.valueOf(intValue2)) && progressiveGesture.isInProgress()) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                continue;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isInScaleOrRotate() {
        for (BaseGesture next : this.f25762a.getDetectors()) {
            if (next instanceof ProgressiveGesture) {
                ProgressiveGesture progressiveGesture = (ProgressiveGesture) next;
                Set<Integer> c = progressiveGesture.mo74538c();
                if ((c.contains(1) || c.contains(2)) && progressiveGesture.isInProgress()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void setListener(L l) {
        this.listener = l;
    }

    /* access modifiers changed from: protected */
    public void removeListener() {
        this.listener = null;
    }

    public long getGestureDuration() {
        return this.f25769h;
    }

    public MotionEvent getCurrentEvent() {
        return this.f25763b;
    }

    public PointF getPointDownXY(int i) {
        if (i == 0) {
            return this.f25767f;
        }
        return this.f25768g;
    }

    public PointF getPointMoveXY(int i) {
        if (i == 0) {
            return this.f25765d;
        }
        return this.f25766e;
    }

    public void copyMoveXY2DownXY() {
        this.f25767f.set(this.f25765d.x, this.f25765d.y);
        this.f25768g.set(this.f25766e.x, this.f25766e.y);
    }

    public MotionEvent getPreviousEvent() {
        return this.f25764c;
    }

    public boolean isEnabled() {
        return this.f25770i;
    }

    public void setEnabled(boolean z) {
        this.f25770i = z;
    }

    /* access modifiers changed from: protected */
    public boolean useNNClassfy() {
        return this.f25762a.useNNClassfy();
    }

    /* access modifiers changed from: protected */
    public Pair<String, Float> getClassFyResult() {
        return this.f25762a.getClassFyResult();
    }
}
