package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.didi.sdk.apm.SystemUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {

    /* renamed from: a */
    private Matrix f54977a = new Matrix();

    /* renamed from: b */
    private Matrix f54978b = new Matrix();

    /* renamed from: c */
    private MPPointF f54979c = MPPointF.getInstance(0.0f, 0.0f);

    /* renamed from: d */
    private MPPointF f54980d = MPPointF.getInstance(0.0f, 0.0f);

    /* renamed from: e */
    private float f54981e = 1.0f;

    /* renamed from: f */
    private float f54982f = 1.0f;

    /* renamed from: g */
    private float f54983g = 1.0f;

    /* renamed from: h */
    private IDataSet f54984h;

    /* renamed from: i */
    private VelocityTracker f54985i;

    /* renamed from: j */
    private long f54986j = 0;

    /* renamed from: k */
    private MPPointF f54987k = MPPointF.getInstance(0.0f, 0.0f);

    /* renamed from: l */
    private MPPointF f54988l = MPPointF.getInstance(0.0f, 0.0f);

    /* renamed from: m */
    private float f54989m;

    /* renamed from: n */
    private float f54990n;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> barLineChartBase, Matrix matrix, float f) {
        super(barLineChartBase);
        this.f54977a = matrix;
        this.f54989m = Utils.convertDpToPixel(f);
        this.f54990n = Utils.convertDpToPixel(3.5f);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.f54985i == null) {
            this.f54985i = VelocityTracker.obtain();
        }
        this.f54985i.addMovement(motionEvent);
        int i = 3;
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.f54985i) != null) {
            velocityTracker.recycle();
            this.f54985i = null;
        }
        if (this.mTouchMode == 0) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.mChart).isDragEnabled() && !((BarLineChartBase) this.mChart).isScaleXEnabled() && !((BarLineChartBase) this.mChart).isScaleYEnabled()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            boolean z = false;
            if (action == 1) {
                VelocityTracker velocityTracker2 = this.f54985i;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker2.computeCurrentVelocity(1000, (float) Utils.getMaximumFlingVelocity());
                float yVelocity = velocityTracker2.getYVelocity(pointerId);
                float xVelocity = velocityTracker2.getXVelocity(pointerId);
                if ((Math.abs(xVelocity) > ((float) Utils.getMinimumFlingVelocity()) || Math.abs(yVelocity) > ((float) Utils.getMinimumFlingVelocity())) && this.mTouchMode == 1 && ((BarLineChartBase) this.mChart).isDragDecelerationEnabled()) {
                    stopDeceleration();
                    this.f54986j = AnimationUtils.currentAnimationTimeMillis();
                    this.f54987k.f55042x = motionEvent.getX();
                    this.f54987k.f55043y = motionEvent.getY();
                    this.f54988l.f55042x = xVelocity;
                    this.f54988l.f55043y = yVelocity;
                    Utils.postInvalidateOnAnimation(this.mChart);
                }
                if (this.mTouchMode == 2 || this.mTouchMode == 3 || this.mTouchMode == 4 || this.mTouchMode == 5) {
                    ((BarLineChartBase) this.mChart).calculateOffsets();
                    ((BarLineChartBase) this.mChart).postInvalidate();
                }
                this.mTouchMode = 0;
                ((BarLineChartBase) this.mChart).enableScroll();
                VelocityTracker velocityTracker3 = this.f54985i;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f54985i = null;
                }
                endAction(motionEvent);
            } else if (action != 2) {
                if (action == 3) {
                    this.mTouchMode = 0;
                    endAction(motionEvent);
                } else if (action != 5) {
                    if (action == 6) {
                        Utils.velocityTrackerPointerUpCleanUpIfNecessary(motionEvent, this.f54985i);
                        this.mTouchMode = 5;
                    }
                } else if (motionEvent.getPointerCount() >= 2) {
                    ((BarLineChartBase) this.mChart).disableScroll();
                    m40697a(motionEvent);
                    this.f54981e = m40704e(motionEvent);
                    this.f54982f = m40705f(motionEvent);
                    float d = m40703d(motionEvent);
                    this.f54983g = d;
                    if (d > 10.0f) {
                        if (((BarLineChartBase) this.mChart).isPinchZoomEnabled()) {
                            this.mTouchMode = 4;
                        } else if (((BarLineChartBase) this.mChart).isScaleXEnabled() != ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                            if (((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                                i = 2;
                            }
                            this.mTouchMode = i;
                        } else {
                            if (this.f54981e > this.f54982f) {
                                i = 2;
                            }
                            this.mTouchMode = i;
                        }
                    }
                    m40699a(this.f54980d, motionEvent);
                }
            } else if (this.mTouchMode == 1) {
                ((BarLineChartBase) this.mChart).disableScroll();
                float f = 0.0f;
                float x = ((BarLineChartBase) this.mChart).isDragXEnabled() ? motionEvent.getX() - this.f54979c.f55042x : 0.0f;
                if (((BarLineChartBase) this.mChart).isDragYEnabled()) {
                    f = motionEvent.getY() - this.f54979c.f55043y;
                }
                m40698a(motionEvent, x, f);
            } else if (this.mTouchMode == 2 || this.mTouchMode == 3 || this.mTouchMode == 4) {
                ((BarLineChartBase) this.mChart).disableScroll();
                if (((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    m40701b(motionEvent);
                }
            } else if (this.mTouchMode == 0 && Math.abs(distance(motionEvent.getX(), this.f54979c.f55042x, motionEvent.getY(), this.f54979c.f55043y)) > this.f54989m && ((BarLineChartBase) this.mChart).isDragEnabled()) {
                if (!((BarLineChartBase) this.mChart).isFullyZoomedOut() || !((BarLineChartBase) this.mChart).hasNoDragOffset()) {
                    z = true;
                }
                if (z) {
                    float abs = Math.abs(motionEvent.getX() - this.f54979c.f55042x);
                    float abs2 = Math.abs(motionEvent.getY() - this.f54979c.f55043y);
                    if ((((BarLineChartBase) this.mChart).isDragXEnabled() || abs2 >= abs) && (((BarLineChartBase) this.mChart).isDragYEnabled() || abs2 <= abs)) {
                        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                        this.mTouchMode = 1;
                    }
                } else if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                    if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                        m40702c(motionEvent);
                    }
                }
            }
        } else {
            startAction(motionEvent);
            stopDeceleration();
            m40697a(motionEvent);
        }
        this.f54977a = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.f54977a, this.mChart, true);
        return true;
    }

    /* renamed from: a */
    private void m40697a(MotionEvent motionEvent) {
        this.f54978b.set(this.f54977a);
        this.f54979c.f55042x = motionEvent.getX();
        this.f54979c.f55043y = motionEvent.getY();
        this.f54984h = ((BarLineChartBase) this.mChart).getDataSetByTouchPoint(motionEvent.getX(), motionEvent.getY());
    }

    /* renamed from: a */
    private void m40698a(MotionEvent motionEvent, float f, float f2) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
        this.f54977a.set(this.f54978b);
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (m40700a()) {
            if (this.mChart instanceof HorizontalBarChart) {
                f = -f;
            } else {
                f2 = -f2;
            }
        }
        this.f54977a.postTranslate(f, f2);
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartTranslate(motionEvent, f, f2);
        }
    }

    /* renamed from: b */
    private void m40701b(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (motionEvent.getPointerCount() >= 2) {
            OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
            float d = m40703d(motionEvent);
            if (d > this.f54990n) {
                MPPointF trans = getTrans(this.f54980d.f55042x, this.f54980d.f55043y);
                ViewPortHandler viewPortHandler = ((BarLineChartBase) this.mChart).getViewPortHandler();
                boolean z5 = true;
                float f = 1.0f;
                if (this.mTouchMode == 4) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f2 = d / this.f54983g;
                    if (f2 >= 1.0f) {
                        z5 = false;
                    }
                    if (z5) {
                        z3 = viewPortHandler.canZoomOutMoreX();
                    } else {
                        z3 = viewPortHandler.canZoomInMoreX();
                    }
                    if (z5) {
                        z4 = viewPortHandler.canZoomOutMoreY();
                    } else {
                        z4 = viewPortHandler.canZoomInMoreY();
                    }
                    float f3 = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? f2 : 1.0f;
                    if (((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                        f = f2;
                    }
                    if (z4 || z3) {
                        this.f54977a.set(this.f54978b);
                        this.f54977a.postScale(f3, f, trans.f55042x, trans.f55043y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, f3, f);
                        }
                    }
                } else if (this.mTouchMode == 2 && ((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.X_ZOOM;
                    float e = m40704e(motionEvent) / this.f54981e;
                    if (e >= 1.0f) {
                        z5 = false;
                    }
                    if (z5) {
                        z2 = viewPortHandler.canZoomOutMoreX();
                    } else {
                        z2 = viewPortHandler.canZoomInMoreX();
                    }
                    if (z2) {
                        this.f54977a.set(this.f54978b);
                        this.f54977a.postScale(e, 1.0f, trans.f55042x, trans.f55043y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, e, 1.0f);
                        }
                    }
                } else if (this.mTouchMode == 3 && ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float f4 = m40705f(motionEvent) / this.f54982f;
                    if (f4 >= 1.0f) {
                        z5 = false;
                    }
                    if (z5) {
                        z = viewPortHandler.canZoomOutMoreY();
                    } else {
                        z = viewPortHandler.canZoomInMoreY();
                    }
                    if (z) {
                        this.f54977a.set(this.f54978b);
                        this.f54977a.postScale(1.0f, f4, trans.f55042x, trans.f55043y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, 1.0f, f4);
                        }
                    }
                }
                MPPointF.recycleInstance(trans);
            }
        }
    }

    /* renamed from: c */
    private void m40702c(MotionEvent motionEvent) {
        Highlight highlightByTouchPoint = ((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlightByTouchPoint != null && !highlightByTouchPoint.equalTo(this.mLastHighlighted)) {
            this.mLastHighlighted = highlightByTouchPoint;
            ((BarLineChartBase) this.mChart).highlightValue(highlightByTouchPoint, true);
        }
    }

    /* renamed from: a */
    private static void m40699a(MPPointF mPPointF, MotionEvent motionEvent) {
        mPPointF.f55042x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        mPPointF.f55043y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
    }

    /* renamed from: d */
    private static float m40703d(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    /* renamed from: e */
    private static float m40704e(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    /* renamed from: f */
    private static float m40705f(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    public MPPointF getTrans(float f, float f2) {
        float f3;
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.mChart).getViewPortHandler();
        float offsetLeft = f - viewPortHandler.offsetLeft();
        if (m40700a()) {
            f3 = -(f2 - viewPortHandler.offsetTop());
        } else {
            f3 = -((((float) ((BarLineChartBase) this.mChart).getMeasuredHeight()) - f2) - viewPortHandler.offsetBottom());
        }
        return MPPointF.getInstance(offsetLeft, f3);
    }

    /* renamed from: a */
    private boolean m40700a() {
        return (this.f54984h == null && ((BarLineChartBase) this.mChart).isAnyAxisInverted()) || (this.f54984h != null && ((BarLineChartBase) this.mChart).isInverted(this.f54984h.getAxisDependency()));
    }

    public Matrix getMatrix() {
        return this.f54977a;
    }

    public void setDragTriggerDist(float f) {
        this.f54989m = Utils.convertDpToPixel(f);
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartDoubleTapped(motionEvent);
        }
        if (((BarLineChartBase) this.mChart).isDoubleTapToZoomEnabled() && ((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.mChart).getData()).getEntryCount() > 0) {
            MPPointF trans = getTrans(motionEvent.getX(), motionEvent.getY());
            BarLineChartBase barLineChartBase = (BarLineChartBase) this.mChart;
            float f = 1.4f;
            float f2 = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? 1.4f : 1.0f;
            if (!((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                f = 1.0f;
            }
            barLineChartBase.zoom(f2, f, trans.f55042x, trans.f55043y);
            if (((BarLineChartBase) this.mChart).isLogEnabled()) {
                SystemUtils.log(4, "BarlineChartTouch", "Double-Tap, Zooming In, x: " + trans.f55042x + ", y: " + trans.f55043y, (Throwable) null, "com.github.mikephil.charting.listener.BarLineChartTouchListener", 586);
            }
            MPPointF.recycleInstance(trans);
        }
        return super.onDoubleTap(motionEvent);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        if (!((BarLineChartBase) this.mChart).isHighlightPerTapEnabled()) {
            return false;
        }
        performHighlight(((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.mLastGesture = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartFling(motionEvent, motionEvent2, f, f2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    public void stopDeceleration() {
        this.f54988l.f55042x = 0.0f;
        this.f54988l.f55043y = 0.0f;
    }

    public void computeScroll() {
        float f = 0.0f;
        if (this.f54988l.f55042x != 0.0f || this.f54988l.f55043y != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f54988l.f55042x *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
            this.f54988l.f55043y *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
            float f2 = ((float) (currentAnimationTimeMillis - this.f54986j)) / 1000.0f;
            float f3 = this.f54988l.f55042x * f2;
            float f4 = this.f54988l.f55043y * f2;
            this.f54987k.f55042x += f3;
            this.f54987k.f55043y += f4;
            MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, this.f54987k.f55042x, this.f54987k.f55043y, 0);
            float f5 = ((BarLineChartBase) this.mChart).isDragXEnabled() ? this.f54987k.f55042x - this.f54979c.f55042x : 0.0f;
            if (((BarLineChartBase) this.mChart).isDragYEnabled()) {
                f = this.f54987k.f55043y - this.f54979c.f55043y;
            }
            m40698a(obtain, f5, f);
            obtain.recycle();
            this.f54977a = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.f54977a, this.mChart, false);
            this.f54986j = currentAnimationTimeMillis;
            if (((double) Math.abs(this.f54988l.f55042x)) >= 0.01d || ((double) Math.abs(this.f54988l.f55043y)) >= 0.01d) {
                Utils.postInvalidateOnAnimation(this.mChart);
                return;
            }
            ((BarLineChartBase) this.mChart).calculateOffsets();
            ((BarLineChartBase) this.mChart).postInvalidate();
            stopDeceleration();
        }
    }
}
