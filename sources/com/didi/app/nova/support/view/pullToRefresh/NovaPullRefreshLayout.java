package com.didi.app.nova.support.view.pullToRefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;

public class NovaPullRefreshLayout extends ViewGroup implements NestedScrollingParent {

    /* renamed from: a */
    private static final String f10386a = "NovaPullRefreshLayout";

    /* renamed from: b */
    private static final int f10387b = -1;

    /* renamed from: c */
    private static final int f10388c = 0;

    /* renamed from: d */
    private static final int f10389d = 1;

    /* renamed from: e */
    private static final int f10390e = 2;

    /* renamed from: f */
    private static final int f10391f = 4;

    /* renamed from: g */
    private static final int f10392g = 8;

    /* renamed from: h */
    private static final float f10393h = 0.4f;

    /* renamed from: A */
    private float f10394A;

    /* renamed from: B */
    private float f10395B;

    /* renamed from: C */
    private float f10396C;

    /* renamed from: D */
    private float f10397D;

    /* renamed from: E */
    private float f10398E;

    /* renamed from: F */
    private View f10399F;

    /* renamed from: G */
    private View f10400G;

    /* renamed from: H */
    private IRefreshView f10401H;

    /* renamed from: I */
    private Scroller f10402I;

    /* renamed from: J */
    private VelocityTracker f10403J;

    /* renamed from: K */
    private PullRefreshListener f10404K;

    /* renamed from: L */
    private IRefreshOffsetCalculator f10405L;

    /* renamed from: M */
    private final NestedScrollingParentHelper f10406M;

    /* renamed from: i */
    private boolean f10407i;

    /* renamed from: j */
    private boolean f10408j;

    /* renamed from: k */
    private boolean f10409k;

    /* renamed from: l */
    private boolean f10410l;

    /* renamed from: m */
    private boolean f10411m;

    /* renamed from: n */
    private boolean f10412n;

    /* renamed from: o */
    private boolean f10413o;

    /* renamed from: p */
    private boolean f10414p;

    /* renamed from: q */
    private int f10415q;

    /* renamed from: r */
    private int f10416r;

    /* renamed from: s */
    private int f10417s;

    /* renamed from: t */
    private final int f10418t;

    /* renamed from: u */
    private int f10419u;

    /* renamed from: v */
    private int f10420v;

    /* renamed from: w */
    private int f10421w;

    /* renamed from: x */
    private int f10422x;

    /* renamed from: y */
    private float f10423y;

    /* renamed from: z */
    private float f10424z;

    public NovaPullRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public NovaPullRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NovaPullRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10407i = false;
        this.f10409k = false;
        this.f10411m = false;
        this.f10412n = false;
        this.f10413o = true;
        this.f10414p = false;
        this.f10415q = -1;
        this.f10417s = 0;
        this.f10418t = 0;
        this.f10422x = -1;
        this.f10423y = 1.0f;
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f10397D = (float) viewConfiguration.getScaledMaximumFlingVelocity();
        this.f10398E = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f10416r = viewConfiguration.getScaledTouchSlop();
        Scroller scroller = new Scroller(getContext());
        this.f10402I = scroller;
        scroller.setFriction(getScrollerFriction());
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.f10406M = new NestedScrollingParentHelper(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.NovaPullRefreshLayout, i, 0);
            setAutoRefreshThresholdPercent(obtainStyledAttributes.getFloat(0, this.f10423y));
            setEnableOverPull(obtainStyledAttributes.getBoolean(2, this.f10413o));
            this.f10414p = obtainStyledAttributes.getBoolean(1, this.f10414p);
            setRefreshViewOffsetFixedWhenRefreshing(obtainStyledAttributes.getBoolean(3, this.f10412n));
            obtainStyledAttributes.recycle();
        }
    }

    public void setAutoRefreshThresholdPercent(float f) {
        this.f10423y = f;
        if (f > 1.0f) {
            this.f10423y = 1.0f;
        }
        if (this.f10423y < 0.0f) {
            this.f10423y = 0.0f;
        }
    }

    public void setEnableOverPull(boolean z) {
        this.f10413o = z;
    }

    public void setRefreshViewOffsetFixedWhenRefreshing(boolean z) {
        this.f10412n = z;
    }

    public static boolean defaultCanScrollUp(View view) {
        return view != null && ViewCompat.canScrollVertically(view, -1);
    }

    public void setPullRefreshListener(PullRefreshListener pullRefreshListener) {
        this.f10404K = pullRefreshListener;
    }

    public void setRefreshOffsetCalculator(IRefreshOffsetCalculator iRefreshOffsetCalculator) {
        this.f10405L = iRefreshOffsetCalculator;
    }

    /* access modifiers changed from: protected */
    public float getScrollerFriction() {
        return ViewConfiguration.getScrollFriction();
    }

    public void setRefreshView(View view) {
        setRefreshView(view, (ViewGroup.LayoutParams) null);
    }

    public void setRefreshView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof IRefreshView) {
            View view2 = this.f10400G;
            if (view2 != null) {
                removeView(view2);
            }
            this.f10400G = view;
            this.f10401H = (IRefreshView) view;
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            addView(this.f10400G, layoutParams);
            return;
        }
        throw new RuntimeException("refreshView must be a instance of IRefreshView");
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (!this.f10414p) {
            return super.getChildDrawingOrder(i, i2);
        }
        int i3 = this.f10415q;
        if (i3 < 0) {
            return i2;
        }
        if (i2 == i3) {
            return i - 1;
        }
        return i2 > i3 ? i2 - 1 : i2;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f10399F instanceof AbsListView)) {
            View view = this.f10399F;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() != 0) {
            m9083a();
            if (this.f10399F == null) {
                m9086a("onMeasure: mTargetView == null");
                return;
            }
            this.f10399F.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f10415q = -1;
            View view = this.f10400G;
            if (view == null) {
                m9086a("onMeasure: mRefreshView == null");
                return;
            }
            measureChild(view, i, i2);
            int i3 = 0;
            while (true) {
                if (i3 >= getChildCount()) {
                    break;
                } else if (getChildAt(i3) == this.f10400G) {
                    this.f10415q = i3;
                    break;
                } else {
                    i3++;
                }
            }
            int measuredHeight = this.f10400G.getMeasuredHeight();
            if (measuredHeight != this.f10420v) {
                this.f10420v = measuredHeight;
                if (!this.f10408j && !this.f10409k && !this.f10410l) {
                    this.f10421w = -measuredHeight;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() != 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            m9083a();
            if (this.f10399F == null) {
                m9086a("onLayout: mTargetView == null");
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingLeft2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
            int paddingTop2 = (measuredHeight - getPaddingTop()) - getPaddingBottom();
            View view = this.f10399F;
            int i5 = this.f10419u;
            view.layout(paddingLeft, paddingTop + i5, paddingLeft2 + paddingLeft, paddingTop + paddingTop2 + i5);
            View view2 = this.f10400G;
            if (view2 == null) {
                m9086a("onLayout: mRefreshView == null");
                return;
            }
            int measuredWidth2 = view2.getMeasuredWidth();
            int measuredHeight2 = this.f10400G.getMeasuredHeight();
            int i6 = measuredWidth / 2;
            int i7 = measuredWidth2 / 2;
            int i8 = this.f10421w;
            this.f10400G.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m9083a();
        int action = motionEvent.getAction();
        if (!isEnabled() || canChildScrollUp() || this.f10410l) {
            m9086a("fast end onIntercept: isEnabled = " + isEnabled() + "; canChildScrollUp = " + canChildScrollUp() + " ; mNestedScrollInProgress = " + this.f10410l);
            return false;
        }
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f10422x);
                    if (findPointerIndex < 0) {
                        m9089b("Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    startDragging(motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex));
                } else if (action != 3) {
                    if (action == 6) {
                        m9085a(motionEvent);
                    }
                }
            }
            this.f10408j = false;
            this.f10422x = -1;
        } else {
            this.f10408j = false;
            int pointerId = motionEvent.getPointerId(0);
            this.f10422x = pointerId;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f10394A = motionEvent.getX(findPointerIndex2);
            this.f10424z = motionEvent.getY(findPointerIndex2);
        }
        return this.f10408j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!isEnabled() || canChildScrollUp() || this.f10410l) {
            m9086a("fast end onTouchEvent: isEnabled = " + isEnabled() + "; canChildScrollUp = " + canChildScrollUp() + " ; mNestedScrollInProgress = " + this.f10410l);
            return false;
        }
        m9088b(motionEvent);
        if (action != 0) {
            float f = 0.0f;
            if (action != 1) {
                if (action == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f10422x);
                    if (findPointerIndex < 0) {
                        m9089b("onTouchEvent Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    startDragging(x, y);
                    if (this.f10408j) {
                        float f2 = y - this.f10396C;
                        if (f2 >= 0.0f) {
                            m9080a(f2, true);
                        } else {
                            float abs = Math.abs(f2) - ((float) Math.abs(m9080a(f2, true)));
                            if (abs > 0.0f) {
                                motionEvent.setAction(0);
                                float f3 = (float) (this.f10416r + 1);
                                if (abs <= f3) {
                                    abs = f3;
                                }
                                motionEvent.offsetLocation(0.0f, abs);
                                dispatchTouchEvent(motionEvent);
                                motionEvent.setAction(action);
                                motionEvent.offsetLocation(0.0f, -abs);
                                dispatchTouchEvent(motionEvent);
                            }
                        }
                        this.f10396C = y;
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        if (actionIndex < 0) {
                            m9089b("Got ACTION_POINTER_DOWN event but have an invalid action index.");
                            return false;
                        }
                        this.f10422x = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        m9085a(motionEvent);
                    }
                }
            }
            if (motionEvent.findPointerIndex(this.f10422x) < 0) {
                m9089b("Got ACTION_UP or ACTION_CANCEL event but don't have an active pointer id.");
                return false;
            }
            if (this.f10408j) {
                this.f10408j = false;
                this.f10403J.computeCurrentVelocity(1000, this.f10397D);
                float yVelocity = this.f10403J.getYVelocity(this.f10422x);
                if (Math.abs(yVelocity) >= this.f10398E) {
                    f = yVelocity;
                }
                m9084a((int) f);
            }
            this.f10422x = -1;
            m9087b();
            return false;
        }
        this.f10408j = false;
        this.f10417s = 0;
        if (!this.f10402I.isFinished()) {
            this.f10402I.abortAnimation();
        }
        this.f10422x = motionEvent.getPointerId(0);
        return true;
    }

    /* renamed from: a */
    private void m9083a() {
        if (this.f10399F == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f10400G)) {
                    if (this.f10399F == null) {
                        this.f10399F = childAt;
                    } else {
                        throw new IllegalStateException("PullRefreshLayout 除去 RefreshView 以外应该只有一个子 View");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m9084a(int i) {
        m9086a("finishPull: vy = " + i + " ; mTargetCurrentOffset = " + this.f10419u + " ; mTargetRefreshOffset = " + this.f10420v + " ; mTargetInitOffset = " + 0 + " ; mScroller.isFinished() = " + this.f10402I.isFinished());
        if (((float) this.f10419u) >= this.f10423y * ((float) this.f10420v)) {
            this.f10417s = 12;
        } else {
            this.f10417s = 1;
        }
        invalidate();
        IRefreshView iRefreshView = this.f10401H;
        if (iRefreshView != null) {
            iRefreshView.onRelease(m9090b(8));
        }
    }

    /* access modifiers changed from: protected */
    public void onRefresh() {
        if (!this.f10409k) {
            this.f10409k = true;
            IRefreshView iRefreshView = this.f10401H;
            if (iRefreshView != null) {
                iRefreshView.onPullToRefresh();
            }
            PullRefreshListener pullRefreshListener = this.f10404K;
            if (pullRefreshListener != null) {
                pullRefreshListener.onPullToRefresh();
            }
        }
    }

    public void dismissPullToRefresh() {
        this.f10409k = false;
        IRefreshView iRefreshView = this.f10401H;
        if (iRefreshView != null) {
            iRefreshView.onComplete();
        }
        this.f10417s = 2;
        this.f10402I.forceFinished(true);
        invalidate();
    }

    /* renamed from: a */
    private void m9085a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.f10422x) {
            this.f10422x = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public void reset() {
        m9081a(0, false);
        IRefreshView iRefreshView = this.f10401H;
        if (iRefreshView != null) {
            iRefreshView.onReset();
        }
        this.f10409k = false;
        this.f10402I.forceFinished(true);
        this.f10417s = 1;
    }

    /* access modifiers changed from: protected */
    public void startDragging(float f, float f2) {
        if (!this.f10409k || !this.f10412n) {
            float f3 = f - this.f10394A;
            float f4 = f2 - this.f10424z;
            if (isYDrag(f3, f4)) {
                int i = this.f10416r;
                if ((f4 > ((float) i) || (f4 < ((float) (-i)) && this.f10419u > 0)) && !this.f10408j) {
                    float f5 = this.f10424z + ((float) this.f10416r);
                    this.f10395B = f5;
                    this.f10396C = f5;
                    this.f10408j = true;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isYDrag(float f, float f2) {
        return Math.abs(f2) > Math.abs(f);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
            invalidate();
        }
    }

    public boolean canChildScrollUp() {
        return defaultCanScrollUp(this.f10399F);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        m9086a("onStartNestedScroll: nestedScrollAxes = " + i);
        return isEnabled() && (i & 2) != 0 && (!this.f10409k || !this.f10412n);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        m9086a("onNestedScrollAccepted: axes = " + i);
        this.f10406M.onNestedScrollAccepted(view, view2, i);
        this.f10410l = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        m9086a("onNestedPreScroll: dx = " + i + " ; dy = " + i2);
        int i3 = this.f10419u - 0;
        if (i2 > 0 && i3 > 0) {
            if (i2 >= i3) {
                iArr[1] = i3;
                m9081a(0, true);
                return;
            }
            iArr[1] = i2;
            m9080a((float) (-i2), true);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        m9086a("onNestedScroll: dxConsumed = " + i + " ; dyConsumed = " + i2 + " ; dxUnconsumed = " + i3 + " ; dyUnconsumed = " + i4);
        if (i4 < 0 && !canChildScrollUp()) {
            m9080a((float) (-i4), true);
        }
    }

    public int getNestedScrollAxes() {
        return this.f10406M.getNestedScrollAxes();
    }

    public void onStopNestedScroll(View view) {
        m9086a("onStopNestedScroll: mNestedScrollInProgress = " + this.f10410l);
        this.f10406M.onStopNestedScroll(view);
        if (this.f10410l) {
            this.f10410l = false;
            if (this.f10407i) {
                m9084a(0);
            }
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        m9086a("onNestedPreFling: mTargetCurrentOffset = " + this.f10419u + " ; velocityX = " + f + " ; velocityY = " + f2);
        if (this.f10419u <= 0) {
            return false;
        }
        this.f10410l = false;
        m9084a((int) (-f2));
        return true;
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        try {
            return super.onNestedFling(view, f, f2, z);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private int m9080a(float f, boolean z) {
        return m9081a((int) (((float) this.f10419u) + (f * 0.4f)), z);
    }

    /* renamed from: a */
    private int m9081a(int i, boolean z) {
        return m9082a(i, z, false);
    }

    /* renamed from: a */
    private int m9082a(int i, boolean z, boolean z2) {
        int i2 = 0;
        if (!(this.f10399F == null || this.f10400G == null)) {
            int max = Math.max(i, 0);
            if (!this.f10413o) {
                max = Math.min(max, this.f10420v);
            }
            if (max != this.f10419u || z2) {
                if (z) {
                    this.f10407i = true;
                }
                i2 = max - this.f10419u;
                ViewCompat.offsetTopAndBottom(this.f10399F, i2);
                this.f10419u = max;
                PullRefreshListener pullRefreshListener = this.f10404K;
                if (pullRefreshListener != null) {
                    pullRefreshListener.onMoveTargetView(max);
                }
                if (this.f10405L == null) {
                    this.f10405L = new C4338a();
                }
                int height = this.f10400G.getHeight();
                int calculateRefreshOffset = this.f10405L.calculateRefreshOffset(this.f10400G.getHeight(), this.f10419u, this.f10420v);
                int i3 = this.f10421w;
                if (calculateRefreshOffset != i3) {
                    ViewCompat.offsetTopAndBottom(this.f10400G, calculateRefreshOffset - i3);
                    this.f10421w = calculateRefreshOffset;
                    IRefreshView iRefreshView = this.f10401H;
                    if (iRefreshView != null) {
                        iRefreshView.onMove(z, calculateRefreshOffset + height);
                    }
                    PullRefreshListener pullRefreshListener2 = this.f10404K;
                    if (pullRefreshListener2 != null) {
                        pullRefreshListener2.onMoveRefreshView(this.f10421w);
                    }
                }
            }
        }
        return i2;
    }

    /* renamed from: b */
    private void m9088b(MotionEvent motionEvent) {
        if (this.f10403J == null) {
            this.f10403J = VelocityTracker.obtain();
        }
        this.f10403J.addMovement(motionEvent);
    }

    /* renamed from: b */
    private void m9087b() {
        VelocityTracker velocityTracker = this.f10403J;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f10403J.recycle();
            this.f10403J = null;
        }
    }

    /* renamed from: b */
    private boolean m9090b(int i) {
        return (this.f10417s & i) == i;
    }

    /* renamed from: c */
    private void m9091c(int i) {
        this.f10417s = (~i) & this.f10417s;
    }

    public void computeScroll() {
        this.f10407i = false;
        if (this.f10402I.computeScrollOffset()) {
            m9081a(this.f10402I.getCurrY(), false);
            invalidate();
        } else if (m9090b(1)) {
            IRefreshView iRefreshView = this.f10401H;
            if (iRefreshView != null) {
                iRefreshView.onReset();
            }
            m9091c(1);
            int i = this.f10419u;
            if (i != 0) {
                this.f10402I.startScroll(0, i, 0, 0 - i);
            }
            invalidate();
        } else if (m9090b(2)) {
            m9091c(2);
            int i2 = this.f10419u;
            if (i2 != 0) {
                this.f10402I.startScroll(0, i2, 0, 0 - i2);
            }
            invalidate();
        } else if (m9090b(4)) {
            m9091c(4);
            int i3 = this.f10419u;
            int i4 = this.f10420v;
            if (i3 != i4) {
                this.f10402I.startScroll(0, i3, 0, i4 - i3);
            } else {
                m9082a(i4, false, true);
            }
            invalidate();
        } else if (m9090b(8)) {
            m9091c(8);
            m9082a(this.f10420v, false, true);
            onRefresh();
        }
    }

    /* renamed from: a */
    private void m9086a(String str) {
        SystemUtils.log(4, f10386a, str, (Throwable) null, "com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout", 820);
    }

    /* renamed from: b */
    private void m9089b(String str) {
        SystemUtils.log(6, f10386a, str, (Throwable) null, "com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout", 824);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f10411m = this.f10409k;
        } else if (this.f10411m) {
            if (action != 2) {
                this.f10411m = false;
            } else if (!this.f10409k) {
                this.f10411m = false;
                motionEvent.setAction(0);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
