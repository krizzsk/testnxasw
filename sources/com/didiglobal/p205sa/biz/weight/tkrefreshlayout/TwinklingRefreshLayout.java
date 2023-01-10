package com.didiglobal.p205sa.biz.weight.tkrefreshlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.Footer.BallPulseView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.header.GoogleDotView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor.AnimProcessor;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor.IDecorator;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor.OverScrollDecorator;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor.RefreshProcessor;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.DensityUtil;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout */
public class TwinklingRefreshLayout extends RelativeLayout implements NestedScrollingChild, PullListener {

    /* renamed from: f */
    private static String f53816f = "";

    /* renamed from: g */
    private static String f53817g = "";

    /* renamed from: A */
    private int f53818A;

    /* renamed from: B */
    private final int[] f53819B;

    /* renamed from: C */
    private final int[] f53820C;

    /* renamed from: D */
    private final int[] f53821D;

    /* renamed from: E */
    private int f53822E;

    /* renamed from: F */
    private int f53823F;

    /* renamed from: G */
    private int f53824G;

    /* renamed from: H */
    private boolean f53825H;

    /* renamed from: I */
    private RefreshListenerAdapter f53826I;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f53827a;
    protected boolean autoLoadMore;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FrameLayout f53828b;

    /* renamed from: c */
    private int f53829c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IHeaderView f53830d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IBottomView f53831e;
    protected boolean enableKeepIView;
    protected boolean enableLoadmore;
    protected boolean enableOverScroll;
    protected boolean enableRefresh;
    protected boolean floatRefresh;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f53832h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public FrameLayout f53833i;
    protected boolean isLoadingMore;
    protected boolean isLoadingVisible;
    protected boolean isOverScrollBottomShow;
    protected boolean isOverScrollTopShow;
    protected boolean isPureScrollModeOn;
    protected boolean isRefreshVisible;
    protected boolean isRefreshing;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public CoContext f53834j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final int f53835k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public PullListener f53836l;

    /* renamed from: m */
    private final NestedScrollingChildHelper f53837m;
    protected float mHeadHeight;
    protected FrameLayout mHeadLayout;
    protected float mMaxBottomHeight;
    protected float mMaxHeadHeight;
    protected float mOverScrollHeight;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public IDecorator f53838n;

    /* renamed from: o */
    private OnGestureListener f53839o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public float f53840p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public float f53841q;

    /* renamed from: r */
    private VelocityTracker f53842r;

    /* renamed from: s */
    private float f53843s;
    protected boolean showLoadingWhenOverScroll;
    protected boolean showRefreshingWhenOverScroll;

    /* renamed from: t */
    private float f53844t;

    /* renamed from: u */
    private float f53845u;

    /* renamed from: v */
    private float f53846v;

    /* renamed from: w */
    private int f53847w;

    /* renamed from: x */
    private int f53848x;

    /* renamed from: y */
    private MotionEvent f53849y;

    /* renamed from: z */
    private boolean f53850z;

    public TwinklingRefreshLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public TwinklingRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public TwinklingRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f53829c = 0;
        this.isRefreshVisible = false;
        this.isLoadingVisible = false;
        this.isRefreshing = false;
        this.isLoadingMore = false;
        this.enableLoadmore = true;
        this.enableRefresh = true;
        this.isOverScrollTopShow = true;
        this.isOverScrollBottomShow = true;
        this.isPureScrollModeOn = false;
        this.autoLoadMore = false;
        this.floatRefresh = false;
        this.enableOverScroll = true;
        this.enableKeepIView = true;
        this.showRefreshingWhenOverScroll = true;
        this.showLoadingWhenOverScroll = true;
        this.f53835k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f53836l = this;
        this.f53847w = ViewConfiguration.getMaximumFlingVelocity();
        this.f53848x = ViewConfiguration.getMinimumFlingVelocity();
        int i2 = this.f53835k;
        this.f53818A = i2 * i2;
        this.f53819B = new int[2];
        this.f53820C = new int[2];
        this.f53821D = new int[2];
        this.f53822E = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.TwinklingRefreshLayout, i, 0);
        try {
            this.mMaxHeadHeight = (float) obtainStyledAttributes.getDimensionPixelSize(11, DensityUtil.dp2px(context, 120.0f));
            this.mHeadHeight = (float) obtainStyledAttributes.getDimensionPixelSize(8, DensityUtil.dp2px(context, 50.0f));
            this.mMaxBottomHeight = (float) obtainStyledAttributes.getDimensionPixelSize(10, DensityUtil.dp2px(context, 120.0f));
            this.f53832h = (float) obtainStyledAttributes.getDimensionPixelSize(2, DensityUtil.dp2px(context, 58.0f));
            this.mOverScrollHeight = (float) obtainStyledAttributes.getDimensionPixelSize(13, (int) this.mHeadHeight);
            this.enableRefresh = obtainStyledAttributes.getBoolean(6, true);
            this.enableLoadmore = obtainStyledAttributes.getBoolean(4, true);
            this.isPureScrollModeOn = obtainStyledAttributes.getBoolean(15, false);
            this.isOverScrollTopShow = obtainStyledAttributes.getBoolean(14, true);
            this.isOverScrollBottomShow = obtainStyledAttributes.getBoolean(12, true);
            this.enableOverScroll = obtainStyledAttributes.getBoolean(5, true);
            this.floatRefresh = obtainStyledAttributes.getBoolean(7, false);
            this.autoLoadMore = obtainStyledAttributes.getBoolean(0, false);
            this.enableKeepIView = obtainStyledAttributes.getBoolean(3, true);
            this.showRefreshingWhenOverScroll = obtainStyledAttributes.getBoolean(17, true);
            this.showLoadingWhenOverScroll = obtainStyledAttributes.getBoolean(16, true);
            obtainStyledAttributes.recycle();
            this.f53834j = new CoContext();
            m40145a();
            m40150b();
            setFloatRefresh(this.floatRefresh);
            setAutoLoadMore(this.autoLoadMore);
            setEnableRefresh(this.enableRefresh);
            setEnableLoadmore(this.enableLoadmore);
            this.f53837m = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: a */
    private void m40145a() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 0);
        layoutParams.addRule(10);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        addView(frameLayout2, new RelativeLayout.LayoutParams(-1, -2));
        addView(frameLayout, layoutParams);
        this.f53828b = frameLayout2;
        this.mHeadLayout = frameLayout;
        if (this.f53830d == null) {
            setHeaderView(new GoogleDotView(getContext()));
        }
    }

    /* renamed from: b */
    private void m40150b() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 0);
        layoutParams.addRule(12);
        frameLayout.setLayoutParams(layoutParams);
        this.f53833i = frameLayout;
        addView(frameLayout);
        if (this.f53831e == null) {
            setBottomView(new BallPulseView(getContext()));
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f53827a = getChildAt(3);
        this.f53834j.init();
        CoContext coContext = this.f53834j;
        this.f53838n = new OverScrollDecorator(coContext, new RefreshProcessor(coContext));
        m40152c();
    }

    /* renamed from: c */
    private void m40152c() {
        this.f53839o = new OnGestureListener() {
            public void onDown(MotionEvent motionEvent) {
                TwinklingRefreshLayout.this.f53838n.onFingerDown(motionEvent);
            }

            public void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                TwinklingRefreshLayout.this.f53838n.onFingerScroll(motionEvent, motionEvent2, f, f2, TwinklingRefreshLayout.this.f53840p, TwinklingRefreshLayout.this.f53841q);
            }

            public void onUp(MotionEvent motionEvent, boolean z) {
                TwinklingRefreshLayout.this.f53838n.onFingerUp(motionEvent, z);
            }

            public void onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                TwinklingRefreshLayout.this.f53838n.onFingerFling(motionEvent, motionEvent2, f, f2);
            }
        };
    }

    /* renamed from: a */
    private void m40146a(MotionEvent motionEvent, OnGestureListener onGestureListener) {
        int action = motionEvent.getAction();
        if (this.f53842r == null) {
            this.f53842r = VelocityTracker.obtain();
        }
        this.f53842r.addMovement(motionEvent);
        int i = action & 255;
        boolean z = true;
        boolean z2 = i == 6;
        int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                f += motionEvent.getX(i2);
                f2 += motionEvent.getY(i2);
            }
        }
        float f3 = (float) (z2 ? pointerCount - 1 : pointerCount);
        float f4 = f / f3;
        float f5 = f2 / f3;
        if (i == 0) {
            this.f53843s = f4;
            this.f53845u = f4;
            this.f53844t = f5;
            this.f53846v = f5;
            MotionEvent motionEvent2 = this.f53849y;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.f53849y = MotionEvent.obtain(motionEvent);
            this.f53850z = true;
            onGestureListener.onDown(motionEvent);
        } else if (i == 1) {
            int pointerId = motionEvent.getPointerId(0);
            this.f53842r.computeCurrentVelocity(1000, (float) this.f53847w);
            this.f53841q = this.f53842r.getYVelocity(pointerId);
            this.f53840p = this.f53842r.getXVelocity(pointerId);
            if (Math.abs(this.f53841q) > ((float) this.f53848x) || Math.abs(this.f53840p) > ((float) this.f53848x)) {
                onGestureListener.onFling(this.f53849y, motionEvent, this.f53840p, this.f53841q);
            } else {
                z = false;
            }
            onGestureListener.onUp(motionEvent, z);
            VelocityTracker velocityTracker = this.f53842r;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f53842r = null;
            }
        } else if (i == 2) {
            float f6 = this.f53843s - f4;
            float f7 = this.f53844t - f5;
            if (this.f53850z) {
                int i3 = (int) (f4 - this.f53845u);
                int i4 = (int) (f5 - this.f53846v);
                if ((i3 * i3) + (i4 * i4) > this.f53818A) {
                    onGestureListener.onScroll(this.f53849y, motionEvent, f6, f7);
                    this.f53843s = f4;
                    this.f53844t = f5;
                    this.f53850z = false;
                }
            } else if (Math.abs(f6) >= 1.0f || Math.abs(f7) >= 1.0f) {
                onGestureListener.onScroll(this.f53849y, motionEvent, f6, f7);
                this.f53843s = f4;
                this.f53844t = f5;
            }
        } else if (i == 3) {
            this.f53850z = false;
            VelocityTracker velocityTracker2 = this.f53842r;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f53842r = null;
            }
        } else if (i == 5) {
            this.f53843s = f4;
            this.f53845u = f4;
            this.f53844t = f5;
            this.f53846v = f5;
        } else if (i == 6) {
            this.f53843s = f4;
            this.f53845u = f4;
            this.f53844t = f5;
            this.f53846v = f5;
            this.f53842r.computeCurrentVelocity(1000, (float) this.f53847w);
            int actionIndex2 = motionEvent.getActionIndex();
            int pointerId2 = motionEvent.getPointerId(actionIndex2);
            float xVelocity = this.f53842r.getXVelocity(pointerId2);
            float yVelocity = this.f53842r.getYVelocity(pointerId2);
            for (int i5 = 0; i5 < pointerCount; i5++) {
                if (i5 != actionIndex2) {
                    int pointerId3 = motionEvent.getPointerId(i5);
                    if ((this.f53842r.getXVelocity(pointerId3) * xVelocity) + (this.f53842r.getYVelocity(pointerId3) * yVelocity) < 0.0f) {
                        this.f53842r.clear();
                        return;
                    }
                }
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = this.f53838n.dispatchTouchEvent(motionEvent);
        m40146a(motionEvent, this.f53839o);
        m40147a(motionEvent);
        return dispatchTouchEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f53838n.interceptTouchEvent(motionEvent) || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f53838n.dealTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private boolean m40147a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            int[] iArr = this.f53821D;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.f53821D;
        obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f53822E);
                    if (findPointerIndex < 0) {
                        SystemUtils.log(6, "TwinklingRefreshLayout", "Error processing scroll; pointer index for id " + this.f53822E + " not found. Did any MotionEvents get skipped?", (Throwable) null, "com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout", 435);
                        return false;
                    }
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int x = this.f53823F - ((int) motionEvent.getX(findPointerIndex));
                    int i = this.f53824G - y;
                    if (dispatchNestedPreScroll(x, i, this.f53820C, this.f53819B)) {
                        int[] iArr3 = this.f53820C;
                        int i2 = iArr3[0];
                        i -= iArr3[1];
                        int[] iArr4 = this.f53819B;
                        obtain.offsetLocation((float) iArr4[0], (float) iArr4[1]);
                        int[] iArr5 = this.f53821D;
                        int i3 = iArr5[0];
                        int[] iArr6 = this.f53819B;
                        iArr5[0] = i3 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                    }
                    if (!this.f53825H && Math.abs(i) > this.f53835k) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f53825H = true;
                        if (i > 0) {
                            i -= this.f53835k;
                        } else {
                            i += this.f53835k;
                        }
                    }
                    if (this.f53825H) {
                        int[] iArr7 = this.f53819B;
                        this.f53824G = y - iArr7[1];
                        if (dispatchNestedScroll(0, 0, 0, i + 0, iArr7)) {
                            int i4 = this.f53823F;
                            int[] iArr8 = this.f53819B;
                            this.f53823F = i4 - iArr8[0];
                            this.f53824G -= iArr8[1];
                            obtain.offsetLocation((float) iArr8[0], (float) iArr8[1]);
                            int[] iArr9 = this.f53821D;
                            int i5 = iArr9[0];
                            int[] iArr10 = this.f53819B;
                            iArr9[0] = i5 + iArr10[0];
                            iArr9[1] = iArr9[1] + iArr10[1];
                        }
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        this.f53822E = motionEvent.getPointerId(actionIndex);
                        this.f53823F = (int) motionEvent.getX(actionIndex);
                        this.f53824G = (int) motionEvent.getY(actionIndex);
                    }
                }
            }
            stopNestedScroll();
            this.f53825H = false;
            this.f53822E = -1;
        } else {
            this.f53822E = motionEvent.getPointerId(0);
            this.f53823F = (int) motionEvent.getX();
            this.f53824G = (int) motionEvent.getY();
            startNestedScroll(2);
        }
        obtain.recycle();
        return true;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f53837m.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f53837m.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return this.f53837m.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.f53837m.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.f53837m.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f53837m.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f53837m.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f53837m.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f53837m.dispatchNestedPreFling(f, f2);
    }

    public static void setDefaultHeader(String str) {
        f53816f = str;
    }

    public static void setDefaultFooter(String str) {
        f53817g = str;
    }

    public void startRefresh() {
        this.f53834j.startRefresh();
    }

    public boolean isRefreshing() {
        return this.f53834j.isRefreshing();
    }

    public boolean isLoadingMore() {
        return this.f53834j.isLoadingMore();
    }

    public void startLoadMore() {
        this.f53834j.startLoadMore();
    }

    public void finishRefreshing() {
        this.f53834j.finishRefreshing();
    }

    public void finishLoadmore() {
        this.f53834j.finishLoadmore();
    }

    public void setTargetView(View view) {
        if (view != null) {
            this.f53827a = view;
        }
    }

    public void setDecorator(IDecorator iDecorator) {
        if (iDecorator != null) {
            this.f53838n = iDecorator;
        }
    }

    public void setHeaderView(IHeaderView iHeaderView) {
        if (iHeaderView != null) {
            this.mHeadLayout.removeAllViewsInLayout();
            this.mHeadLayout.addView(iHeaderView.getView());
            this.f53830d = iHeaderView;
        }
    }

    @Deprecated
    public void addFixedExHeader(View view) {
        FrameLayout frameLayout;
        if (view != null && (frameLayout = this.f53828b) != null) {
            frameLayout.addView(view);
            this.f53828b.bringToFront();
            if (this.floatRefresh) {
                this.mHeadLayout.bringToFront();
            }
            this.f53834j.onAddExHead();
            this.f53834j.setExHeadFixed();
        }
    }

    public View getExtraHeaderView() {
        return this.f53828b;
    }

    public void setBottomView(IBottomView iBottomView) {
        if (iBottomView != null) {
            this.f53833i.removeAllViewsInLayout();
            this.f53833i.addView(iBottomView.getView());
            this.f53831e = iBottomView;
        }
    }

    public void setFloatRefresh(boolean z) {
        this.floatRefresh = z;
        if (z) {
            post(new Runnable() {
                public void run() {
                    if (TwinklingRefreshLayout.this.mHeadLayout != null) {
                        TwinklingRefreshLayout.this.mHeadLayout.bringToFront();
                    }
                }
            });
        }
    }

    public void setMaxHeadHeight(float f) {
        this.mMaxHeadHeight = (float) DensityUtil.dp2px(getContext(), f);
    }

    public void setHeaderHeight(float f) {
        this.mHeadHeight = (float) DensityUtil.dp2px(getContext(), f);
    }

    public void setMaxBottomHeight(float f) {
        this.mMaxBottomHeight = (float) DensityUtil.dp2px(getContext(), f);
    }

    public void setBottomHeight(float f) {
        this.f53832h = (float) DensityUtil.dp2px(getContext(), f);
    }

    public void setEnableLoadmore(boolean z) {
        this.enableLoadmore = z;
        IBottomView iBottomView = this.f53831e;
        if (iBottomView == null) {
            return;
        }
        if (z) {
            iBottomView.getView().setVisibility(0);
        } else {
            iBottomView.getView().setVisibility(8);
        }
    }

    public void setEnableRefresh(boolean z) {
        this.enableRefresh = z;
        IHeaderView iHeaderView = this.f53830d;
        if (iHeaderView == null) {
            return;
        }
        if (z) {
            iHeaderView.getView().setVisibility(0);
        } else {
            iHeaderView.getView().setVisibility(8);
        }
    }

    public void setOverScrollTopShow(boolean z) {
        this.isOverScrollTopShow = z;
    }

    public void setOverScrollBottomShow(boolean z) {
        this.isOverScrollBottomShow = z;
    }

    public void setOverScrollRefreshShow(boolean z) {
        this.isOverScrollTopShow = z;
        this.isOverScrollBottomShow = z;
    }

    public void setEnableOverScroll(boolean z) {
        this.enableOverScroll = z;
    }

    public void setPureScrollModeOn() {
        this.isPureScrollModeOn = true;
        this.isOverScrollTopShow = false;
        this.isOverScrollBottomShow = false;
        setMaxHeadHeight(this.mOverScrollHeight);
        setHeaderHeight(this.mOverScrollHeight);
        setMaxBottomHeight(this.mOverScrollHeight);
        setBottomHeight(this.mOverScrollHeight);
    }

    public void setOverScrollHeight(float f) {
        this.mOverScrollHeight = (float) DensityUtil.dp2px(getContext(), f);
    }

    public void setAutoLoadMore(boolean z) {
        this.autoLoadMore = z;
        if (z) {
            setEnableLoadmore(true);
        }
    }

    public void showRefreshingWhenOverScroll(boolean z) {
        this.showRefreshingWhenOverScroll = z;
    }

    public void showLoadingWhenOverScroll(boolean z) {
        this.showLoadingWhenOverScroll = z;
    }

    public void setEnableKeepIView(boolean z) {
        this.enableKeepIView = z;
    }

    public void setOnRefreshListener(RefreshListenerAdapter refreshListenerAdapter) {
        if (refreshListenerAdapter != null) {
            this.f53826I = refreshListenerAdapter;
        }
    }

    public void onPullingDown(TwinklingRefreshLayout twinklingRefreshLayout, float f) {
        RefreshListenerAdapter refreshListenerAdapter;
        this.f53830d.onPullingDown(f, this.mMaxHeadHeight, this.mHeadHeight);
        if (this.enableRefresh && (refreshListenerAdapter = this.f53826I) != null) {
            refreshListenerAdapter.onPullingDown(twinklingRefreshLayout, f);
        }
    }

    public void onPullingUp(TwinklingRefreshLayout twinklingRefreshLayout, float f) {
        RefreshListenerAdapter refreshListenerAdapter;
        this.f53831e.onPullingUp(f, this.mMaxHeadHeight, this.mHeadHeight);
        if (this.enableLoadmore && (refreshListenerAdapter = this.f53826I) != null) {
            refreshListenerAdapter.onPullingUp(twinklingRefreshLayout, f);
        }
    }

    public void onPullDownReleasing(TwinklingRefreshLayout twinklingRefreshLayout, float f) {
        RefreshListenerAdapter refreshListenerAdapter;
        this.f53830d.onPullReleasing(f, this.mMaxHeadHeight, this.mHeadHeight);
        if (this.enableRefresh && (refreshListenerAdapter = this.f53826I) != null) {
            refreshListenerAdapter.onPullDownReleasing(twinklingRefreshLayout, f);
        }
    }

    public void onPullUpReleasing(TwinklingRefreshLayout twinklingRefreshLayout, float f) {
        RefreshListenerAdapter refreshListenerAdapter;
        this.f53831e.onPullReleasing(f, this.mMaxBottomHeight, this.f53832h);
        if (this.enableLoadmore && (refreshListenerAdapter = this.f53826I) != null) {
            refreshListenerAdapter.onPullUpReleasing(twinklingRefreshLayout, f);
        }
    }

    public void onRefresh(TwinklingRefreshLayout twinklingRefreshLayout) {
        this.f53830d.startAnim(this.mMaxHeadHeight, this.mHeadHeight);
        RefreshListenerAdapter refreshListenerAdapter = this.f53826I;
        if (refreshListenerAdapter != null) {
            refreshListenerAdapter.onRefresh(twinklingRefreshLayout);
        }
    }

    public void onLoadMore(TwinklingRefreshLayout twinklingRefreshLayout) {
        this.f53831e.startAnim(this.mMaxBottomHeight, this.f53832h);
        RefreshListenerAdapter refreshListenerAdapter = this.f53826I;
        if (refreshListenerAdapter != null) {
            refreshListenerAdapter.onLoadMore(twinklingRefreshLayout);
        }
    }

    public void onFinishRefresh() {
        RefreshListenerAdapter refreshListenerAdapter = this.f53826I;
        if (refreshListenerAdapter != null) {
            refreshListenerAdapter.onFinishRefresh();
        }
        if (this.f53834j.isEnableKeepIView() || this.f53834j.isRefreshing()) {
            this.f53830d.onFinish(new OnAnimEndListener() {
                public void onAnimEnd() {
                    TwinklingRefreshLayout.this.f53834j.finishRefreshAfterAnim();
                }
            });
        }
    }

    public void onFinishLoadMore() {
        RefreshListenerAdapter refreshListenerAdapter = this.f53826I;
        if (refreshListenerAdapter != null) {
            refreshListenerAdapter.onFinishLoadMore();
        }
        if (this.f53834j.isEnableKeepIView() || this.f53834j.isLoadingMore()) {
            this.f53831e.onFinish();
        }
    }

    public void onRefreshCanceled() {
        RefreshListenerAdapter refreshListenerAdapter = this.f53826I;
        if (refreshListenerAdapter != null) {
            refreshListenerAdapter.onRefreshCanceled();
        }
    }

    public void onLoadmoreCanceled() {
        RefreshListenerAdapter refreshListenerAdapter = this.f53826I;
        if (refreshListenerAdapter != null) {
            refreshListenerAdapter.onLoadmoreCanceled();
        }
    }

    /* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout$CoContext */
    public class CoContext {
        private static final int EX_MODE_FIXED = 1;
        private static final int EX_MODE_NORMAL = 0;
        private static final int PULLING_BOTTOM_UP = 1;
        private static final int PULLING_TOP_DOWN = 0;
        /* access modifiers changed from: private */
        public AnimProcessor animProcessor = new AnimProcessor(this);
        private int exHeadMode = 0;
        private boolean isExHeadLocked = true;
        private boolean prepareFinishLoadMore = false;
        private boolean prepareFinishRefresh = false;
        private int state = 0;

        public CoContext() {
        }

        public void init() {
            if (TwinklingRefreshLayout.this.isPureScrollModeOn) {
                TwinklingRefreshLayout.this.setOverScrollTopShow(false);
                TwinklingRefreshLayout.this.setOverScrollBottomShow(false);
                if (TwinklingRefreshLayout.this.mHeadLayout != null) {
                    TwinklingRefreshLayout.this.mHeadLayout.setVisibility(8);
                }
                if (TwinklingRefreshLayout.this.f53833i != null) {
                    TwinklingRefreshLayout.this.f53833i.setVisibility(8);
                }
            }
        }

        public AnimProcessor getAnimProcessor() {
            return this.animProcessor;
        }

        public boolean isEnableKeepIView() {
            return TwinklingRefreshLayout.this.enableKeepIView;
        }

        public boolean showRefreshingWhenOverScroll() {
            return TwinklingRefreshLayout.this.showRefreshingWhenOverScroll;
        }

        public boolean showLoadingWhenOverScroll() {
            return TwinklingRefreshLayout.this.showLoadingWhenOverScroll;
        }

        public float getMaxHeadHeight() {
            return TwinklingRefreshLayout.this.mMaxHeadHeight;
        }

        public int getHeadHeight() {
            return (int) TwinklingRefreshLayout.this.mHeadHeight;
        }

        public int getExtraHeadHeight() {
            return TwinklingRefreshLayout.this.f53828b.getHeight();
        }

        public int getMaxBottomHeight() {
            return (int) TwinklingRefreshLayout.this.mMaxBottomHeight;
        }

        public int getBottomHeight() {
            return (int) TwinklingRefreshLayout.this.f53832h;
        }

        public int getOsHeight() {
            return (int) TwinklingRefreshLayout.this.mOverScrollHeight;
        }

        public View getTargetView() {
            return TwinklingRefreshLayout.this.f53827a;
        }

        public View getHeader() {
            return TwinklingRefreshLayout.this.mHeadLayout;
        }

        public View getFooter() {
            return TwinklingRefreshLayout.this.f53833i;
        }

        public int getTouchSlop() {
            return TwinklingRefreshLayout.this.f53835k;
        }

        public void resetHeaderView() {
            if (TwinklingRefreshLayout.this.f53830d != null) {
                TwinklingRefreshLayout.this.f53830d.reset();
            }
        }

        public void resetBottomView() {
            if (TwinklingRefreshLayout.this.f53831e != null) {
                TwinklingRefreshLayout.this.f53831e.reset();
            }
        }

        public View getExHead() {
            return TwinklingRefreshLayout.this.f53828b;
        }

        public void setExHeadNormal() {
            this.exHeadMode = 0;
        }

        public void setExHeadFixed() {
            this.exHeadMode = 1;
        }

        public boolean isExHeadNormal() {
            return this.exHeadMode == 0;
        }

        public boolean isExHeadFixed() {
            return this.exHeadMode == 1;
        }

        public boolean isExHeadLocked() {
            return this.isExHeadLocked;
        }

        public void onAddExHead() {
            this.isExHeadLocked = false;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) TwinklingRefreshLayout.this.f53827a.getLayoutParams();
            layoutParams.addRule(3, TwinklingRefreshLayout.this.f53828b.getId());
            TwinklingRefreshLayout.this.f53827a.setLayoutParams(layoutParams);
            TwinklingRefreshLayout.this.requestLayout();
        }

        public void startRefresh() {
            TwinklingRefreshLayout.this.post(new Runnable() {
                public void run() {
                    CoContext.this.setStatePTD();
                    if (!TwinklingRefreshLayout.this.isPureScrollModeOn && TwinklingRefreshLayout.this.f53827a != null) {
                        CoContext.this.setRefreshing(true);
                        CoContext.this.animProcessor.animHeadToRefresh();
                    }
                }
            });
        }

        public void startLoadMore() {
            TwinklingRefreshLayout.this.post(new Runnable() {
                public void run() {
                    CoContext.this.setStatePBU();
                    if (!TwinklingRefreshLayout.this.isPureScrollModeOn && TwinklingRefreshLayout.this.f53827a != null) {
                        CoContext.this.setLoadingMore(true);
                        CoContext.this.animProcessor.animBottomToLoad();
                    }
                }
            });
        }

        public void finishRefreshing() {
            onFinishRefresh();
        }

        public void finishRefreshAfterAnim() {
            if (TwinklingRefreshLayout.this.f53827a != null) {
                this.animProcessor.animHeadBack(true);
            }
        }

        public void finishLoadmore() {
            onFinishLoadMore();
            if (TwinklingRefreshLayout.this.f53827a != null) {
                this.animProcessor.animBottomBack(true);
            }
        }

        public boolean enableOverScroll() {
            return TwinklingRefreshLayout.this.enableOverScroll;
        }

        public boolean allowPullDown() {
            return TwinklingRefreshLayout.this.enableRefresh || TwinklingRefreshLayout.this.enableOverScroll;
        }

        public boolean allowPullUp() {
            return TwinklingRefreshLayout.this.enableLoadmore || TwinklingRefreshLayout.this.enableOverScroll;
        }

        public boolean enableRefresh() {
            return TwinklingRefreshLayout.this.enableRefresh;
        }

        public boolean enableLoadmore() {
            return TwinklingRefreshLayout.this.enableLoadmore;
        }

        public boolean allowOverScroll() {
            return !TwinklingRefreshLayout.this.isRefreshVisible && !TwinklingRefreshLayout.this.isLoadingVisible;
        }

        public boolean isRefreshVisible() {
            return TwinklingRefreshLayout.this.isRefreshVisible;
        }

        public boolean isLoadingVisible() {
            return TwinklingRefreshLayout.this.isLoadingVisible;
        }

        public void setRefreshVisible(boolean z) {
            TwinklingRefreshLayout.this.isRefreshVisible = z;
        }

        public void setLoadVisible(boolean z) {
            TwinklingRefreshLayout.this.isLoadingVisible = z;
        }

        public void setRefreshing(boolean z) {
            TwinklingRefreshLayout.this.isRefreshing = z;
        }

        public boolean isRefreshing() {
            return TwinklingRefreshLayout.this.isRefreshing;
        }

        public boolean isLoadingMore() {
            return TwinklingRefreshLayout.this.isLoadingMore;
        }

        public void setLoadingMore(boolean z) {
            TwinklingRefreshLayout.this.isLoadingMore = z;
        }

        public boolean isOpenFloatRefresh() {
            return TwinklingRefreshLayout.this.floatRefresh;
        }

        public boolean autoLoadMore() {
            return TwinklingRefreshLayout.this.autoLoadMore;
        }

        public boolean isPureScrollModeOn() {
            return TwinklingRefreshLayout.this.isPureScrollModeOn;
        }

        public boolean isOverScrollTopShow() {
            return TwinklingRefreshLayout.this.isOverScrollTopShow;
        }

        public boolean isOverScrollBottomShow() {
            return TwinklingRefreshLayout.this.isOverScrollBottomShow;
        }

        public void onPullingDown(float f) {
            PullListener l = TwinklingRefreshLayout.this.f53836l;
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            l.onPullingDown(twinklingRefreshLayout, f / twinklingRefreshLayout.mHeadHeight);
        }

        public void onPullingUp(float f) {
            PullListener l = TwinklingRefreshLayout.this.f53836l;
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            l.onPullingUp(twinklingRefreshLayout, f / twinklingRefreshLayout.f53832h);
        }

        public void onRefresh() {
            TwinklingRefreshLayout.this.f53836l.onRefresh(TwinklingRefreshLayout.this);
        }

        public void onLoadMore() {
            TwinklingRefreshLayout.this.f53836l.onLoadMore(TwinklingRefreshLayout.this);
        }

        public void onFinishRefresh() {
            TwinklingRefreshLayout.this.f53836l.onFinishRefresh();
        }

        public void onFinishLoadMore() {
            TwinklingRefreshLayout.this.f53836l.onFinishLoadMore();
        }

        public void onPullDownReleasing(float f) {
            PullListener l = TwinklingRefreshLayout.this.f53836l;
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            l.onPullDownReleasing(twinklingRefreshLayout, f / twinklingRefreshLayout.mHeadHeight);
        }

        public void onPullUpReleasing(float f) {
            PullListener l = TwinklingRefreshLayout.this.f53836l;
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            l.onPullUpReleasing(twinklingRefreshLayout, f / twinklingRefreshLayout.f53832h);
        }

        public boolean dispatchTouchEventSuper(MotionEvent motionEvent) {
            return TwinklingRefreshLayout.super.dispatchTouchEvent(motionEvent);
        }

        public void onRefreshCanceled() {
            TwinklingRefreshLayout.this.f53836l.onRefreshCanceled();
        }

        public void onLoadmoreCanceled() {
            TwinklingRefreshLayout.this.f53836l.onLoadmoreCanceled();
        }

        public void setStatePTD() {
            this.state = 0;
        }

        public void setStatePBU() {
            this.state = 1;
        }

        public boolean isStatePTD() {
            return this.state == 0;
        }

        public boolean isStatePBU() {
            return 1 == this.state;
        }

        public boolean isPrepareFinishRefresh() {
            return this.prepareFinishRefresh;
        }

        public boolean isPrepareFinishLoadMore() {
            return this.prepareFinishLoadMore;
        }

        public void setPrepareFinishRefresh(boolean z) {
            this.prepareFinishRefresh = z;
        }

        public void setPrepareFinishLoadMore(boolean z) {
            this.prepareFinishLoadMore = z;
        }
    }
}
