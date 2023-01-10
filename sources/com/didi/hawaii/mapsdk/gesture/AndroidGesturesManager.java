package com.didi.hawaii.mapsdk.gesture;

import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import com.didi.hawaii.mapsdk.gesture.MoveGestureDetector;
import com.didi.hawaii.mapsdk.gesture.MultiFingerTapGestureDetector;
import com.didi.hawaii.mapsdk.gesture.RotateGestureDetector;
import com.didi.hawaii.mapsdk.gesture.ShoveGestureDetector;
import com.didi.hawaii.mapsdk.gesture.SidewaysShoveGestureDetector;
import com.didi.hawaii.mapsdk.gesture.StandardGestureDetector;
import com.didi.hawaii.mapsdk.gesture.StandardScaleGestureDetector;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AndroidGesturesManager {
    public static final int GESTURE_TYPE_DOUBLE_TAP = 10;
    public static final int GESTURE_TYPE_DOUBLE_TAP_EVENT = 11;
    public static final int GESTURE_TYPE_DOWN = 9;
    public static final int GESTURE_TYPE_FLING = 7;
    public static final int GESTURE_TYPE_LONG_PRESS = 6;
    public static final int GESTURE_TYPE_MOVE = 13;
    public static final int GESTURE_TYPE_MULTI_FINGER_TAP = 4;
    public static final int GESTURE_TYPE_ROTATE = 2;
    public static final int GESTURE_TYPE_SCALE = 1;
    public static final int GESTURE_TYPE_SCROLL = 0;
    public static final int GESTURE_TYPE_SHOVE = 3;
    public static final int GESTURE_TYPE_SHOW_PRESS = 8;
    public static final int GESTURE_TYPE_SIDEWAYS_SHOVE = 14;
    public static final int GESTURE_TYPE_SINGLE_TAP_CONFIRMED = 12;
    public static final int GESTURE_TYPE_SINGLE_TAP_UP = 5;

    /* renamed from: a */
    private static final int f25744a = 255;

    /* renamed from: b */
    private static final int f25745b = 5;

    /* renamed from: c */
    private static final int f25746c = 6;

    /* renamed from: d */
    private final List<Set<Integer>> f25747d = new ArrayList();

    /* renamed from: e */
    private final List<BaseGesture> f25748e = new ArrayList();

    /* renamed from: f */
    private final StandardGestureDetector f25749f;

    /* renamed from: g */
    private final StandardScaleGestureDetector f25750g;

    /* renamed from: h */
    private final RotateGestureDetector f25751h;

    /* renamed from: i */
    private final ShoveGestureDetector f25752i;

    /* renamed from: j */
    private final MultiFingerTapGestureDetector f25753j;

    /* renamed from: k */
    private final MoveGestureDetector f25754k;

    /* renamed from: l */
    private final SidewaysShoveGestureDetector f25755l;

    /* renamed from: m */
    private NNGestureClassfy f25756m;

    /* renamed from: n */
    private AndroidGestureOption f25757n;

    /* renamed from: o */
    private boolean f25758o = false;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureType {
    }

    public AndroidGesturesManager(Context context, AndroidGestureOption androidGestureOption) {
        this.f25751h = new RotateGestureDetector(context, this);
        this.f25750g = new StandardScaleGestureDetector(context, this);
        this.f25752i = new ShoveGestureDetector(context, this);
        this.f25755l = new SidewaysShoveGestureDetector(context, this);
        this.f25753j = new MultiFingerTapGestureDetector(context, this);
        this.f25754k = new MoveGestureDetector(context, this);
        this.f25749f = new StandardGestureDetector(context, this);
        this.f25748e.add(this.f25752i);
        this.f25748e.add(this.f25751h);
        this.f25748e.add(this.f25754k);
        this.f25748e.add(this.f25750g);
        this.f25748e.add(this.f25755l);
        this.f25748e.add(this.f25753j);
        this.f25748e.add(this.f25749f);
        if (androidGestureOption != null) {
            if (androidGestureOption.exclusiveGestures != null && androidGestureOption.exclusiveGestures.size() > 0) {
                this.f25747d.addAll(androidGestureOption.exclusiveGestures);
            }
            if (androidGestureOption.useNNClassfy) {
                this.f25756m = new NNGestureClassfy();
            } else {
                Constants.m20458a();
            }
            if (androidGestureOption.applyDefaultThresholds) {
                m20456a();
            }
            this.f25757n = androidGestureOption;
        }
    }

    /* renamed from: a */
    private void m20456a() {
        for (BaseGesture next : this.f25748e) {
            boolean z = next instanceof MultiFingerTapGestureDetector;
            if (z) {
                ((MultiFingerGesture) next).setSpanThresholdResource(R.dimen.dmap_defaultMutliFingerSpanThreshold);
            }
            if (next instanceof StandardScaleGestureDetector) {
                ((StandardScaleGestureDetector) next).setSpanSinceStartThreshold((float) Constants.DEFAULT_SCALE_SPAN_START);
            }
            if (next instanceof MoveGestureDetector) {
                ((MoveGestureDetector) next).setMoveThresholdResource(R.dimen.min_multi_move_distance);
            }
            if (next instanceof ShoveGestureDetector) {
                ShoveGestureDetector shoveGestureDetector = (ShoveGestureDetector) next;
                shoveGestureDetector.setPixelDeltaThresholdResource(R.dimen.dmap_defaultShovePixelThreshold);
                shoveGestureDetector.setMaxShoveAngle(20.0f);
                shoveGestureDetector.setDeltTwoFingerCloser(R.dimen.dmap_shove_y_threshold);
            }
            if (next instanceof SidewaysShoveGestureDetector) {
                SidewaysShoveGestureDetector sidewaysShoveGestureDetector = (SidewaysShoveGestureDetector) next;
                sidewaysShoveGestureDetector.setPixelDeltaThresholdResource(R.dimen.dmap_defaultShovePixelThreshold);
                sidewaysShoveGestureDetector.setMaxShoveAngle(20.0f);
            }
            if (z) {
                MultiFingerTapGestureDetector multiFingerTapGestureDetector = (MultiFingerTapGestureDetector) next;
                multiFingerTapGestureDetector.setMultiFingerTapMovementThresholdResource(R.dimen.dmap_defaultMultiTapMovementThreshold);
                multiFingerTapGestureDetector.setMultiFingerTapTimeThreshold(150);
            }
            if (next instanceof RotateGestureDetector) {
                ((RotateGestureDetector) next).setAngleThreshold(Constants.DEFAULT_ROTATE_ANGLE_THRESHOLD);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        NNGestureClassfy nNGestureClassfy = this.f25756m;
        if (nNGestureClassfy != null) {
            nNGestureClassfy.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f25758o = false;
        } else if (action == 5) {
            this.f25758o = true;
        }
        for (BaseGesture next : this.f25748e) {
            if (!(next instanceof StandardGestureDetector) || !this.f25758o || action != 2) {
                next.onTouchEvent(motionEvent);
            }
        }
        return true;
    }

    public void setStandardGestureListener(StandardGestureDetector.StandardOnGestureListener standardOnGestureListener) {
        this.f25749f.setListener(standardOnGestureListener);
    }

    public void removeStandardGestureListener() {
        this.f25749f.removeListener();
    }

    public void setStandardScaleGestureListener(StandardScaleGestureDetector.StandardOnScaleGestureListener standardOnScaleGestureListener) {
        this.f25750g.setListener(standardOnScaleGestureListener);
    }

    public void removeStandardScaleGestureListener() {
        this.f25750g.removeListener();
    }

    public void setRotateGestureListener(RotateGestureDetector.OnRotateGestureListener onRotateGestureListener) {
        this.f25751h.setListener(onRotateGestureListener);
    }

    public void removeRotateGestureListener() {
        this.f25751h.removeListener();
    }

    public void setShoveGestureListener(ShoveGestureDetector.OnShoveGestureListener onShoveGestureListener) {
        this.f25752i.setListener(onShoveGestureListener);
    }

    public void removeShoveGestureListener() {
        this.f25752i.removeListener();
    }

    public void setMultiFingerTapGestureListener(MultiFingerTapGestureDetector.OnMultiFingerTapGestureListener onMultiFingerTapGestureListener) {
        this.f25753j.setListener(onMultiFingerTapGestureListener);
    }

    public void removeMultiFingerTapGestureListener() {
        this.f25753j.removeListener();
    }

    public void setMoveGestureListener(MoveGestureDetector.OnMoveGestureListener onMoveGestureListener) {
        this.f25754k.setListener(onMoveGestureListener);
    }

    public void removeMoveGestureListener() {
        this.f25754k.removeListener();
    }

    public void setSidewaysShoveGestureListener(SidewaysShoveGestureDetector.OnSidewaysShoveGestureListener onSidewaysShoveGestureListener) {
        this.f25755l.setListener(onSidewaysShoveGestureListener);
    }

    public void removeSidewaysShoveGestureListener() {
        this.f25755l.removeListener();
    }

    public List<BaseGesture> getDetectors() {
        return this.f25748e;
    }

    public StandardGestureDetector getStandardGestureDetector() {
        return this.f25749f;
    }

    public StandardScaleGestureDetector getStandardScaleGestureDetector() {
        return this.f25750g;
    }

    public RotateGestureDetector getRotateGestureDetector() {
        return this.f25751h;
    }

    public ShoveGestureDetector getShoveGestureDetector() {
        return this.f25752i;
    }

    public MultiFingerTapGestureDetector getMultiFingerTapGestureDetector() {
        return this.f25753j;
    }

    public MoveGestureDetector getMoveGestureDetector() {
        return this.f25754k;
    }

    public SidewaysShoveGestureDetector getSidewaysShoveGestureDetector() {
        return this.f25755l;
    }

    @SafeVarargs
    public final void setMutuallyExclusiveGestures(Set<Integer>... setArr) {
        setMutuallyExclusiveGestures((List<Set<Integer>>) Arrays.asList(setArr));
    }

    public void setMutuallyExclusiveGestures(List<Set<Integer>> list) {
        this.f25747d.clear();
        this.f25747d.addAll(list);
    }

    public List<Set<Integer>> getMutuallyExclusiveGestures() {
        return this.f25747d;
    }

    public boolean useNNClassfy() {
        AndroidGestureOption androidGestureOption = this.f25757n;
        return androidGestureOption != null && androidGestureOption.useNNClassfy;
    }

    public Pair<String, Float> getClassFyResult() {
        if (this.f25756m != null) {
            return new Pair<>(this.f25756m.getLable(), Float.valueOf(this.f25756m.getCurAngle()));
        }
        return null;
    }
}
