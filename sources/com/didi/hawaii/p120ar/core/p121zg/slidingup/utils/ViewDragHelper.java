package com.didi.hawaii.p120ar.core.p121zg.slidingup.utils;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
import java.util.Arrays;

/* renamed from: com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper */
public class ViewDragHelper {
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: a */
    private static final String f25514a = "ViewDragHelper";

    /* renamed from: b */
    private static final int f25515b = 20;

    /* renamed from: c */
    private static final int f25516c = 256;

    /* renamed from: d */
    private static final int f25517d = 600;

    /* renamed from: z */
    private static final Interpolator f25518z = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: A */
    private final Runnable f25519A = new Runnable() {
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };

    /* renamed from: e */
    private int f25520e;

    /* renamed from: f */
    private int f25521f;

    /* renamed from: g */
    private int f25522g = -1;

    /* renamed from: h */
    private float[] f25523h;

    /* renamed from: i */
    private float[] f25524i;

    /* renamed from: j */
    private float[] f25525j;

    /* renamed from: k */
    private float[] f25526k;

    /* renamed from: l */
    private int[] f25527l;

    /* renamed from: m */
    private int[] f25528m;

    /* renamed from: n */
    private int[] f25529n;

    /* renamed from: o */
    private int f25530o;

    /* renamed from: p */
    private VelocityTracker f25531p;

    /* renamed from: q */
    private float f25532q;

    /* renamed from: r */
    private float f25533r;

    /* renamed from: s */
    private int f25534s;

    /* renamed from: t */
    private int f25535t;

    /* renamed from: u */
    private ScrollerCompat f25536u;

    /* renamed from: v */
    private final Callback f25537v;

    /* renamed from: w */
    private View f25538w;

    /* renamed from: x */
    private boolean f25539x;

    /* renamed from: y */
    private final ViewGroup f25540y;

    /* renamed from: com.didi.hawaii.ar.core.zg.slidingup.utils.ViewDragHelper$Callback */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, (Interpolator) null, callback);
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Interpolator interpolator, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, interpolator, callback);
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.f25521f = (int) (((float) create.f25521f) * (1.0f / f));
        return create;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Interpolator interpolator, Callback callback) {
        ViewDragHelper create = create(viewGroup, interpolator, callback);
        create.f25521f = (int) (((float) create.f25521f) * (1.0f / f));
        return create;
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Interpolator interpolator, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback != null) {
            this.f25540y = viewGroup;
            this.f25537v = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f25534s = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f25521f = viewConfiguration.getScaledTouchSlop();
            this.f25532q = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f25533r = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f25536u = ScrollerCompat.create(context, interpolator == null ? f25518z : interpolator);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    public void setMinVelocity(float f) {
        this.f25533r = f;
    }

    public float getMinVelocity() {
        return this.f25533r;
    }

    public int getViewDragState() {
        return this.f25520e;
    }

    public void setEdgeTrackingEnabled(int i) {
        this.f25535t = i;
    }

    public int getEdgeSize() {
        return this.f25534s;
    }

    public void captureChildView(View view, int i) {
        if (view.getParent() == this.f25540y) {
            this.f25538w = view;
            this.f25522g = i;
            this.f25537v.onViewCaptured(view, i);
            setDragState(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f25540y + ")");
    }

    public View getCapturedView() {
        return this.f25538w;
    }

    public int getActivePointerId() {
        return this.f25522g;
    }

    public int getTouchSlop() {
        return this.f25521f;
    }

    public void cancel() {
        this.f25522g = -1;
        m20357a();
        VelocityTracker velocityTracker = this.f25531p;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f25531p = null;
        }
    }

    public void abort() {
        cancel();
        if (this.f25520e == 2) {
            int currX = this.f25536u.getCurrX();
            int currY = this.f25536u.getCurrY();
            this.f25536u.abortAnimation();
            int currX2 = this.f25536u.getCurrX();
            int currY2 = this.f25536u.getCurrY();
            this.f25537v.onViewPositionChanged(this.f25538w, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        this.f25538w = view;
        this.f25522g = -1;
        return m20363a(i, i2, 0, 0);
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.f25539x) {
            return m20363a(i, i2, (int) VelocityTrackerCompat.getXVelocity(this.f25531p, this.f25522g), (int) VelocityTrackerCompat.getYVelocity(this.f25531p, this.f25522g));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* renamed from: a */
    private boolean m20363a(int i, int i2, int i3, int i4) {
        int left = this.f25538w.getLeft();
        int top = this.f25538w.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f25536u.abortAnimation();
            setDragState(0);
            return false;
        }
        this.f25536u.startScroll(left, top, i5, i6, m20356a(this.f25538w, i5, i6, i3, i4));
        setDragState(2);
        return true;
    }

    /* renamed from: a */
    private int m20356a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int b = m20365b(i3, (int) this.f25533r, (int) this.f25532q);
        int b2 = m20365b(i4, (int) this.f25533r, (int) this.f25532q);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (b != 0) {
            f2 = (float) abs3;
            f = (float) i5;
        } else {
            f2 = (float) abs;
            f = (float) i6;
        }
        float f5 = f2 / f;
        if (b2 != 0) {
            f4 = (float) abs4;
            f3 = (float) i5;
        } else {
            f4 = (float) abs2;
            f3 = (float) i6;
        }
        float f6 = f4 / f3;
        return (int) ((((float) m20355a(i, b, this.f25537v.getViewHorizontalDragRange(view))) * f5) + (((float) m20355a(i2, b2, this.f25537v.getViewVerticalDragRange(view))) * f6));
    }

    /* renamed from: a */
    private int m20355a(int i, int i2, int i3) {
        int i4;
        if (i == 0) {
            return 0;
        }
        int width = this.f25540y.getWidth();
        float f = (float) (width / 2);
        float a = f + (m20352a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * f);
        int abs = Math.abs(i2);
        if (abs > 0) {
            i4 = Math.round(Math.abs(a / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(i4, 600);
    }

    /* renamed from: b */
    private int m20365b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs > i3) {
            return i > 0 ? i3 : -i3;
        }
        return i;
    }

    /* renamed from: a */
    private float m20353a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs > f3) {
            return f > 0.0f ? f3 : -f3;
        }
        return f;
    }

    /* renamed from: a */
    private float m20352a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (this.f25539x) {
            this.f25536u.fling(this.f25538w.getLeft(), this.f25538w.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.f25531p, this.f25522g), (int) VelocityTrackerCompat.getYVelocity(this.f25531p, this.f25522g), i, i3, i2, i4);
            setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public boolean continueSettling(boolean z) {
        if (this.f25538w == null) {
            return false;
        }
        if (this.f25520e == 2) {
            boolean computeScrollOffset = this.f25536u.computeScrollOffset();
            int currX = this.f25536u.getCurrX();
            int currY = this.f25536u.getCurrY();
            int left = currX - this.f25538w.getLeft();
            int top = currY - this.f25538w.getTop();
            if (computeScrollOffset || top == 0) {
                if (left != 0) {
                    this.f25538w.offsetLeftAndRight(left);
                }
                if (top != 0) {
                    this.f25538w.offsetTopAndBottom(top);
                }
                if (!(left == 0 && top == 0)) {
                    this.f25537v.onViewPositionChanged(this.f25538w, currX, currY, left, top);
                }
                if (computeScrollOffset && currX == this.f25536u.getFinalX() && currY == this.f25536u.getFinalY()) {
                    this.f25536u.abortAnimation();
                    computeScrollOffset = this.f25536u.isFinished();
                }
                if (!computeScrollOffset) {
                    if (z) {
                        this.f25540y.post(this.f25519A);
                    } else {
                        setDragState(0);
                    }
                }
            } else {
                this.f25538w.setTop(0);
                return true;
            }
        }
        if (this.f25520e == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m20358a(float f, float f2) {
        this.f25539x = true;
        this.f25537v.onViewReleased(this.f25538w, f, f2);
        this.f25539x = false;
        if (this.f25520e == 1) {
            setDragState(0);
        }
    }

    /* renamed from: a */
    private void m20357a() {
        float[] fArr = this.f25523h;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f25524i, 0.0f);
            Arrays.fill(this.f25525j, 0.0f);
            Arrays.fill(this.f25526k, 0.0f);
            Arrays.fill(this.f25527l, 0);
            Arrays.fill(this.f25528m, 0);
            Arrays.fill(this.f25529n, 0);
            this.f25530o = 0;
        }
    }

    /* renamed from: a */
    private void m20360a(int i) {
        float[] fArr = this.f25523h;
        if (fArr != null && fArr.length > i) {
            fArr[i] = 0.0f;
            this.f25524i[i] = 0.0f;
            this.f25525j[i] = 0.0f;
            this.f25526k[i] = 0.0f;
            this.f25527l[i] = 0;
            this.f25528m[i] = 0;
            this.f25529n[i] = 0;
            this.f25530o = (~(1 << i)) & this.f25530o;
        }
    }

    /* renamed from: b */
    private void m20368b(int i) {
        float[] fArr = this.f25523h;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.f25523h;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f25524i;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f25525j;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f25526k;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f25527l;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f25528m;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f25529n;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f25523h = fArr2;
            this.f25524i = fArr3;
            this.f25525j = fArr4;
            this.f25526k = fArr5;
            this.f25527l = iArr;
            this.f25528m = iArr2;
            this.f25529n = iArr3;
        }
    }

    /* renamed from: a */
    private void m20359a(float f, float f2, int i) {
        m20368b(i);
        float[] fArr = this.f25523h;
        this.f25525j[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f25524i;
        this.f25526k[i] = f2;
        fArr2[i] = f2;
        this.f25527l[i] = m20354a((int) f, (int) f2);
        this.f25530o |= 1 << i;
    }

    /* renamed from: a */
    private void m20361a(MotionEvent motionEvent) {
        float[] fArr;
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
            float x = MotionEventCompat.getX(motionEvent, i);
            float y = MotionEventCompat.getY(motionEvent, i);
            float[] fArr2 = this.f25525j;
            if (fArr2 != null && (fArr = this.f25526k) != null && fArr2.length > pointerId && fArr.length > pointerId) {
                fArr2[pointerId] = x;
                fArr[pointerId] = y;
            }
        }
    }

    public boolean isPointerDown(int i) {
        return ((1 << i) & this.f25530o) != 0;
    }

    public void setDragState(int i) {
        if (this.f25520e != i) {
            this.f25520e = i;
            this.f25537v.onViewDragStateChanged(i);
            if (this.f25520e == 0) {
                this.f25538w = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo73669a(View view, int i) {
        if (view == this.f25538w && this.f25522g == i) {
            return true;
        }
        if (view == null || !this.f25537v.tryCaptureView(view, i)) {
            return false;
        }
        this.f25522g = i;
        captureChildView(view, i);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3, int i4) {
        int i5;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z || (!ViewCompat.canScrollHorizontally(view, -i) && !ViewCompat.canScrollVertically(view, -i2))) {
            return false;
        }
        return true;
    }

    public boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        View findTopChildUnder;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f25531p == null) {
            this.f25531p = VelocityTracker.obtain();
        }
        this.f25531p.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    for (int i = 0; i < pointerCount && this.f25523h != null && this.f25524i != null; i++) {
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
                        if (pointerId < this.f25523h.length && pointerId < this.f25524i.length) {
                            float x = MotionEventCompat.getX(motionEvent, i);
                            float y = MotionEventCompat.getY(motionEvent, i);
                            float f = x - this.f25523h[pointerId];
                            float f2 = y - this.f25524i[pointerId];
                            m20367b(f, f2, pointerId);
                            if (this.f25520e == 1) {
                                break;
                            }
                            View findTopChildUnder2 = findTopChildUnder((int) this.f25523h[pointerId], (int) this.f25524i[pointerId]);
                            if (findTopChildUnder2 != null && m20364a(findTopChildUnder2, f, f2) && mo73669a(findTopChildUnder2, pointerId)) {
                                break;
                            }
                        }
                    }
                    m20361a(motionEvent);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        float x2 = MotionEventCompat.getX(motionEvent, actionIndex);
                        float y2 = MotionEventCompat.getY(motionEvent, actionIndex);
                        m20359a(x2, y2, pointerId2);
                        int i2 = this.f25520e;
                        if (i2 == 0) {
                            int i3 = this.f25527l[pointerId2];
                            int i4 = this.f25535t;
                            if ((i3 & i4) != 0) {
                                this.f25537v.onEdgeTouched(i3 & i4, pointerId2);
                            }
                        } else if (i2 == 2 && (findTopChildUnder = findTopChildUnder((int) x2, (int) y2)) == this.f25538w) {
                            mo73669a(findTopChildUnder, pointerId2);
                        }
                    } else if (actionMasked == 6) {
                        m20360a(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                    }
                }
            }
            cancel();
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, 0);
            m20359a(x3, y3, pointerId3);
            View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
            if (findTopChildUnder3 == this.f25538w && this.f25520e == 2) {
                mo73669a(findTopChildUnder3, pointerId3);
            }
            int i5 = this.f25527l[pointerId3];
            int i6 = this.f25535t;
            if ((i5 & i6) != 0) {
                this.f25537v.onEdgeTouched(i5 & i6, pointerId3);
            }
        }
        if (this.f25520e == 1) {
            return true;
        }
        return false;
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int i;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f25531p == null) {
            this.f25531p = VelocityTracker.obtain();
        }
        this.f25531p.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            m20359a(x, y, pointerId);
            mo73669a(findTopChildUnder, pointerId);
            int i3 = this.f25527l[pointerId];
            int i4 = this.f25535t;
            if ((i3 & i4) != 0) {
                this.f25537v.onEdgeTouched(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f25520e == 1) {
                m20366b();
            }
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f25520e == 1) {
                    m20358a(0.0f, 0.0f);
                }
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                float x2 = MotionEventCompat.getX(motionEvent, actionIndex);
                float y2 = MotionEventCompat.getY(motionEvent, actionIndex);
                m20359a(x2, y2, pointerId2);
                if (this.f25520e == 0) {
                    mo73669a(findTopChildUnder((int) x2, (int) y2), pointerId2);
                    int i5 = this.f25527l[pointerId2];
                    int i6 = this.f25535t;
                    if ((i5 & i6) != 0) {
                        this.f25537v.onEdgeTouched(i5 & i6, pointerId2);
                    }
                } else if (isCapturedViewUnder((int) x2, (int) y2)) {
                    mo73669a(this.f25538w, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (this.f25520e == 1 && pointerId3 == this.f25522g) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    while (true) {
                        if (i2 >= pointerCount) {
                            i = -1;
                            break;
                        }
                        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, i2);
                        if (pointerId4 != this.f25522g) {
                            View findTopChildUnder2 = findTopChildUnder((int) MotionEventCompat.getX(motionEvent, i2), (int) MotionEventCompat.getY(motionEvent, i2));
                            View view = this.f25538w;
                            if (findTopChildUnder2 == view && mo73669a(view, pointerId4)) {
                                i = this.f25522g;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        m20366b();
                    }
                }
                m20360a(pointerId3);
            }
        } else if (this.f25520e == 1) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f25522g);
            float x3 = MotionEventCompat.getX(motionEvent, findPointerIndex);
            float y3 = MotionEventCompat.getY(motionEvent, findPointerIndex);
            float[] fArr = this.f25525j;
            int i7 = this.f25522g;
            int i8 = (int) (x3 - fArr[i7]);
            int i9 = (int) (y3 - this.f25526k[i7]);
            m20369b(this.f25538w.getLeft() + i8, this.f25538w.getTop() + i9, i8, i9);
            m20361a(motionEvent);
        } else {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (i2 < pointerCount2) {
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i2);
                float x4 = MotionEventCompat.getX(motionEvent, i2);
                float y4 = MotionEventCompat.getY(motionEvent, i2);
                float f = x4 - this.f25523h[pointerId5];
                float f2 = y4 - this.f25524i[pointerId5];
                m20367b(f, f2, pointerId5);
                if (this.f25520e != 1) {
                    View findTopChildUnder3 = findTopChildUnder((int) this.f25523h[pointerId5], (int) this.f25524i[pointerId5]);
                    if (m20364a(findTopChildUnder3, f, f2) && mo73669a(findTopChildUnder3, pointerId5)) {
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            m20361a(motionEvent);
        }
    }

    /* renamed from: b */
    private void m20367b(float f, float f2, int i) {
        int i2 = 1;
        if (!m20362a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m20362a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m20362a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m20362a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f25528m;
            iArr[i] = iArr[i] | i2;
            this.f25537v.onEdgeDragStarted(i2, i);
        }
    }

    /* renamed from: a */
    private boolean m20362a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f25527l[i] & i2) != i2 || (this.f25535t & i2) == 0 || (this.f25529n[i] & i2) == i2 || (this.f25528m[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f25521f;
        if (abs <= ((float) i3) && abs2 <= ((float) i3)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f25537v.onEdgeLock(i2)) {
            int[] iArr = this.f25529n;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f25528m[i] & i2) != 0 || abs <= ((float) this.f25521f)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    private boolean m20364a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f25537v.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.f25537v.getViewVerticalDragRange(view) > 0;
        if (z && z2) {
            int i = this.f25521f;
            if ((f * f) + (f2 * f2) > ((float) (i * i))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f25521f)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f25521f)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkTouchSlop(int i) {
        int length = this.f25523h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f25525j[i2] - this.f25523h[i2];
        float f2 = this.f25526k[i2] - this.f25524i[i2];
        if (z && z2) {
            int i3 = this.f25521f;
            if ((f * f) + (f2 * f2) > ((float) (i3 * i3))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f25521f)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f25521f)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isEdgeTouched(int i) {
        int length = this.f25527l.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (i & this.f25527l[i2]) != 0;
    }

    public boolean isDragging() {
        return this.f25520e == 1;
    }

    /* renamed from: b */
    private void m20366b() {
        this.f25531p.computeCurrentVelocity(1000, this.f25532q);
        m20358a(m20353a(VelocityTrackerCompat.getXVelocity(this.f25531p, this.f25522g), this.f25533r, this.f25532q), m20353a(VelocityTrackerCompat.getYVelocity(this.f25531p, this.f25522g), this.f25533r, this.f25532q));
    }

    /* renamed from: b */
    private void m20369b(int i, int i2, int i3, int i4) {
        int left = this.f25538w.getLeft();
        int top = this.f25538w.getTop();
        if (i3 != 0) {
            i = this.f25537v.clampViewPositionHorizontal(this.f25538w, i, i3);
            this.f25538w.offsetLeftAndRight(i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f25537v.clampViewPositionVertical(this.f25538w, i2, i4);
            this.f25538w.offsetTopAndBottom(i2 - top);
        }
        int i6 = i2;
        if (i3 != 0 || i4 != 0) {
            this.f25537v.onViewPositionChanged(this.f25538w, i5, i6, i5 - left, i6 - top);
        }
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.f25538w, i, i2);
    }

    public boolean isViewUnder(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View findTopChildUnder(int i, int i2) {
        for (int childCount = this.f25540y.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f25540y.getChildAt(this.f25537v.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    private int m20354a(int i, int i2) {
        int i3 = i < this.f25540y.getLeft() + this.f25534s ? 1 : 0;
        if (i2 < this.f25540y.getTop() + this.f25534s) {
            i3 |= 4;
        }
        if (i > this.f25540y.getRight() - this.f25534s) {
            i3 |= 2;
        }
        return i2 > this.f25540y.getBottom() - this.f25534s ? i3 | 8 : i3;
    }
}
