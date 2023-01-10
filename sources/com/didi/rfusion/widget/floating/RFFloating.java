package com.didi.rfusion.widget.floating;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.internal.page.PageWrapper;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.config.RFusionConfig;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.RFSystemBarUtils;
import com.didi.rfusion.utils.RFUtils;
import com.didi.rfusion.utils.tracker.RFTrackerHelper;
import com.didi.rfusion.widget.floating.RFExpandRelativeLayout;
import com.didi.rfusion.widget.floating.RFFloating;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RFFloating extends Page {
    public static final int LAUNCH_MODE_CLEAR_TASK = 1;
    public static final int LAUNCH_MODE_STANDARD = 0;
    public static final int TYPE_AUTO = 1;
    public static final int TYPE_FIXED = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f36286a;

    /* renamed from: b */
    private static final String f36287b = "RFFloating";

    /* renamed from: l */
    static final String f36288l;

    /* renamed from: m */
    static final String f36289m;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final RFusionConfig.IRFusionLogger f36290c = RFLogger.getLogger();

    /* renamed from: d */
    private OnDismissListener f36291d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FrameLayout f36292e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public RFRoundRelativeLayout f36293f;

    /* renamed from: g */
    private RFExpandRelativeLayout f36294g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RelativeLayout f36295h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public FrameLayout f36296i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PageInstrument f36297j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public RFFloatingNavBarController f36298k = new RFFloatingNavBarController();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C12381a f36299n = new C12381a();

    /* renamed from: o */
    private RFFloatingChangeHandler f36300o = new RFFloatingChangeHandler(false);

    /* renamed from: p */
    private boolean f36301p;

    /* renamed from: q */
    private int f36302q = 1;

    /* renamed from: r */
    private boolean f36303r = true;

    /* renamed from: s */
    private int f36304s = 1;

    /* renamed from: t */
    private boolean f36305t = false;

    /* renamed from: u */
    private IScopeLifecycle f36306u = new IScopeLifecycle() {
        LinkedList<Integer> mPageIdList = new LinkedList<>();

        public void onPause(ILive iLive) {
        }

        public void onStop(ILive iLive) {
        }

        public void onCreate(ILive iLive) {
            int navBarId = getNavBarId(iLive);
            RFFloating.this.f36298k.mo94268a(navBarId);
            RFFloating.this.f36298k.mo94273a(navBarId, true);
            RFFloating.this.f36299n.mo94311b(navBarId);
            RFFloating.this.f36299n.mo94309a(navBarId);
            this.mPageIdList.add(Integer.valueOf(navBarId));
            RFusionConfig.IRFusionLogger d = RFFloating.this.f36290c;
            d.info(RFFloating.f36287b, "onCreate: " + navBarId);
        }

        public void onStart(ILive iLive) {
            int navBarId = getNavBarId(iLive);
            if (this.mPageIdList.getLast().intValue() != navBarId) {
                RFFloating.this.f36298k.mo94273a(navBarId, false);
                RFFloating.this.f36299n.mo94309a(navBarId);
            }
            RFusionConfig.IRFusionLogger d = RFFloating.this.f36290c;
            d.info(RFFloating.f36287b, "onStart: " + navBarId);
        }

        public void onResume(ILive iLive) {
            int navBarId = getNavBarId(iLive);
            if (this.mPageIdList.getLast().intValue() == navBarId) {
                RFFloating.this.f36299n.mo94309a(navBarId);
            }
        }

        public void onDestroy(ILive iLive) {
            int navBarId = getNavBarId(iLive);
            RFFloating.this.f36298k.mo94275b(navBarId);
            RFFloating.this.f36299n.mo94312c(navBarId);
            this.mPageIdList.remove(Integer.valueOf(navBarId));
            RFusionConfig.IRFusionLogger d = RFFloating.this.f36290c;
            d.info(RFFloating.f36287b, "onDestroy: " + navBarId);
            if (!RFFloating.this.f36297j.hasRootPage()) {
                RFFloating.this.dismiss();
            }
        }

        private int getNavBarId(ILive iLive) {
            return ((PageWrapper) iLive).getArgs().getInt(RFFloating.f36286a);
        }
    };

    public interface OnDismissListener {
        void onDismiss(RFFloating rFFloating);
    }

    /* access modifiers changed from: protected */
    public void initNavBar(RFFloatingNavBar rFFloatingNavBar) {
    }

    @Deprecated
    public void setupComponents(View view) {
    }

    static {
        Class<RFFloating> cls = RFFloating.class;
        f36288l = cls.getSimpleName() + ":CONTROLLER";
        f36289m = cls.getSimpleName() + ":NAV_BAR";
        f36286a = cls.getSimpleName() + ":ID";
    }

    public void show(ScopeContext scopeContext) {
        if (!this.f36305t) {
            scopeContext.getNavigator().push(this);
            this.f36305t = true;
        }
    }

    public void dismiss() {
        dismiss((Bundle) null);
    }

    public void dismiss(final Bundle bundle) {
        if (this.f36305t) {
            this.f36305t = false;
            this.f36290c.info(f36287b, "dismiss: start exit animator");
            Animator exitAnimator = this.f36300o.getExitAnimator(getView());
            exitAnimator.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    RFFloating.this.m27325a(bundle);
                }
            });
            exitAnimator.start();
        }
    }

    public void setDismissible(boolean z) {
        this.f36301p = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27325a(Bundle bundle) {
        m27337d();
        finish(bundle);
        this.f36290c.info(f36287b, "dismiss: success");
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f36291d = onDismissListener;
    }

    public void setShowBackground(boolean z) {
        this.f36303r = z;
        if (this.f36292e != null) {
            m27330a(z);
        }
    }

    public void setFitSystemWindow(boolean z) {
        int statusBarHeight = z ? RFSystemBarUtils.getStatusBarHeight(getBaseContext()) : 0;
        FrameLayout frameLayout = this.f36292e;
        frameLayout.setPadding(frameLayout.getLeft(), statusBarHeight, this.f36292e.getRight(), this.f36292e.getBottom());
    }

    public final View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.rf_floating_main, viewGroup, false);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        this.f36292e = (FrameLayout) findViewById(R.id.rf_fl_floating);
        this.f36293f = (RFRoundRelativeLayout) findViewById(R.id.rf_rrl_frame);
        this.f36294g = (RFExpandRelativeLayout) findViewById(R.id.rf_erl_frame);
        this.f36295h = (RelativeLayout) findViewById(R.id.rf_rl_container);
        this.f36296i = (FrameLayout) findViewById(R.id.rf_fl_nav_bar_container);
        this.f36298k.mo94274a(view);
        m27330a(this.f36303r);
        Context baseContext = getBaseContext();
        if ((baseContext instanceof Activity) && RFSystemBarUtils.isTranslucentStatusBar((Activity) baseContext)) {
            setFitSystemWindow(true);
        }
        setType(1);
        m27327a((Page) this);
        initNavBar(getNavBar());
        this.f36294g.setGestureListener(new RFFloatingGesture(this.f36295h));
        this.f36292e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RFFloating.this.m27333b(view);
            }
        });
        this.f36295h.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            public void onChildViewRemoved(View view, View view2) {
            }

            public void onChildViewAdded(View view, View view2) {
                RFFloating.this.m27332b();
            }
        });
        this.f36305t = true;
        RFTrackerHelper.trackFloatingShow();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m27333b(View view) {
        if (this.f36301p) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27327a(Page page) {
        int e = m27338e();
        if (!this.f36298k.mo94278b()) {
            this.f36298k.mo94272a(e, new C12383c((RFFloatingTextAttr) null, new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    RFFloating.this.m27326a(view);
                }
            }).build(), (RFFloatingTextAttr) null, true, false, RFResUtils.getColor(R.color.rf_color_white_100_FFFFFF)));
            this.f36299n.mo94311b(e);
            this.f36299n.mo94309a(e);
        }
        Bundle bundle = new Bundle();
        RFFloatingNavBar rFFloatingNavBar = new RFFloatingNavBar(this.f36298k, e);
        bundle.putSerializable(f36288l, new RFFloatingControllerProxy(this, this.f36299n, e));
        bundle.putSerializable(f36289m, rFFloatingNavBar);
        bundle.putSerializable(f36286a, Integer.valueOf(e));
        page.setArgs(bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27326a(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27332b() {
        if (this.f36295h.getChildCount() > 0) {
            int i = this.f36295h.getChildAt(0).getLayoutParams().height;
            if (!RFUtils.isPadFlavor() && this.f36304s == 1) {
                ViewGroup.LayoutParams layoutParams = this.f36294g.getLayoutParams();
                if (i == -1) {
                    layoutParams.height = this.f36294g.getMinimumHeight();
                } else {
                    layoutParams.height = -2;
                }
                this.f36294g.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: a */
    private void m27330a(boolean z) {
        if (z) {
            this.f36292e.setBackgroundColor(RFResUtils.getColor(getBaseContext(), R.color.rf_color_gery_12_0_7F000000));
        } else {
            this.f36292e.setBackgroundColor(RFResUtils.getColor(getBaseContext(), R.color.rf_color_white_100_alpha_0));
        }
        this.f36292e.getBackground().mutate();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f36305t = false;
        this.f36298k.mo94267a();
        OnDismissListener onDismissListener = this.f36291d;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public void setArgs(Bundle bundle) {
        super.setArgs(bundle);
    }

    public Bundle getArgs() {
        return super.getArgs();
    }

    /* access modifiers changed from: protected */
    public boolean addComponent(Component component) {
        return super.addComponent(component);
    }

    public boolean onHandleBack() {
        if (this.f36297j != null) {
            return true;
        }
        dismiss();
        return true;
    }

    public ControllerChangeHandler getPushHandler() {
        return this.f36300o;
    }

    public ControllerChangeHandler getPopHandler() {
        return new EmptyChangeHandler(false);
    }

    /* access modifiers changed from: protected */
    public void setContentView(int i) {
        m27335c();
        LayoutInflater.from(getBaseContext()).inflate(i, this.f36295h);
    }

    /* access modifiers changed from: protected */
    public void setContentView(View view) {
        m27335c();
        this.f36295h.addView(view);
    }

    /* access modifiers changed from: protected */
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m27335c();
        this.f36295h.addView(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void setContentView(Page page) {
        m27335c();
        if (this.f36297j == null) {
            this.f36297j = getInstrument(this.f36295h, "", true);
        }
        PageInstrument pageInstrument = this.f36297j;
        if (pageInstrument != null) {
            pageInstrument.setPagePushCallback(new PageInstrument.IPagePushCallback() {
                public final void pageConfigureOnPush(Page page) {
                    RFFloating.this.m27327a(page);
                }
            });
            this.f36297j.registerPageLifecycleCallback(this.f36306u);
            if (!this.f36297j.hasRootPage()) {
                this.f36297j.setRootPage(page);
                return;
            }
            return;
        }
        throw new RuntimeException("InnerPageInstrument create failed");
    }

    public void pushPage(Page page) {
        pushPage(page, 0);
    }

    public void pushPage(Page page, int i) {
        PageInstrument pageInstrument;
        if (page != null && (pageInstrument = this.f36297j) != null) {
            if (i == 1) {
                pageInstrument.setRootPage(page);
            } else if (pageInstrument.hasRootPage()) {
                this.f36297j.pushPage(page);
            } else {
                this.f36297j.setRootPage(page);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setType(int i) {
        if (this.f36304s != i) {
            this.f36304s = i;
            if (!RFUtils.isPadFlavor()) {
                int i2 = i == 1 ? -2 : -1;
                ViewGroup.LayoutParams layoutParams = this.f36294g.getLayoutParams();
                layoutParams.height = i2;
                this.f36294g.setLayoutParams(layoutParams);
            }
            m27332b();
        }
    }

    /* access modifiers changed from: protected */
    public RFFloatingNavBar getNavBar() {
        return (RFFloatingNavBar) getArgs().getSerializable(f36289m);
    }

    /* access modifiers changed from: protected */
    public void setGestureEnable(boolean z) {
        RFFloatingControllerProxy rFFloatingControllerProxy = (RFFloatingControllerProxy) getArgs().getSerializable(f36288l);
        if (rFFloatingControllerProxy != null) {
            rFFloatingControllerProxy.setGestureEnable(z);
        }
    }

    /* renamed from: c */
    private void m27335c() {
        if (this.f36297j != null) {
            m27337d();
        } else {
            this.f36295h.removeAllViews();
        }
    }

    /* renamed from: d */
    private void m27337d() {
        PageInstrument pageInstrument = this.f36297j;
        if (pageInstrument != null) {
            pageInstrument.popToRoot();
            this.f36297j.pop();
            this.f36297j.unregisterPageLifecycleCallback(this.f36306u);
            this.f36297j = null;
        }
    }

    /* renamed from: e */
    private int m27338e() {
        if (this.f36302q >= 2147483646) {
            this.f36302q = 0;
        }
        int i = this.f36302q + 1;
        this.f36302q = i;
        return i;
    }

    private class RFFloatingGesture implements RFExpandRelativeLayout.OnGestureListener {
        private static final int ANIMATION_TIME = 300;
        private static final int HEX_FF = 255;
        private boolean isDisallow = false;
        private boolean isEnableGesture = true;
        private boolean isHitNavBar = false;
        private boolean isIntercept = false;
        private boolean isMove = false;
        private float mDistanceX;
        private float mDistanceY;
        private View mHitView = null;
        private float mLastX;
        private float mLastY;
        private List<View> mScrollableViewList = new ArrayList();
        private Rect mTempHitRect = new Rect();
        private final int mTouchSlop = ViewConfiguration.get(RFFloating.this.getBaseContext()).getScaledTouchSlop();
        private float mTouchX;
        private float mTouchY;
        private int mTranslateHeight = 0;
        private VelocityTracker mVelocityTracker;

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public RFFloatingGesture(View view) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    RFFloating.RFFloatingGesture.this.lambda$new$0$RFFloating$RFFloatingGesture(view, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$RFFloating$RFFloatingGesture(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            initScrollableViews();
        }

        private void initScrollableViews() {
            this.mScrollableViewList.clear();
            RFViewScrollChecker.scanScrollableViews(RFFloating.this.f36295h, this.mScrollableViewList);
            Collections.reverse(this.mScrollableViewList);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
            if (r4 != 3) goto L_0x0132;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean dispatchTouchEvent(android.view.MotionEvent r4) {
            /*
                r3 = this;
                float r0 = r4.getRawX()
                r3.mTouchX = r0
                float r0 = r4.getRawY()
                r3.mTouchY = r0
                r0 = 0
                r3.isIntercept = r0
                r3.acquireVelocityTracker(r4)
                int r4 = r4.getAction()
                r1 = 1
                if (r4 == 0) goto L_0x00dc
                if (r4 == r1) goto L_0x009b
                r2 = 2
                if (r4 == r2) goto L_0x0023
                r0 = 3
                if (r4 == r0) goto L_0x009b
                goto L_0x0132
            L_0x0023:
                boolean r4 = r3.isEnableGesture
                if (r4 != 0) goto L_0x0029
                goto L_0x0132
            L_0x0029:
                boolean r4 = r3.isDisallow
                if (r4 == 0) goto L_0x0035
                boolean r4 = r3.isHitViewDisallow()
                if (r4 != 0) goto L_0x0035
                goto L_0x0132
            L_0x0035:
                float r4 = r3.mTouchX
                float r2 = r3.mLastX
                float r4 = r4 - r2
                r3.mDistanceX = r4
                float r4 = r3.mTouchY
                float r2 = r3.mLastY
                float r4 = r4 - r2
                r3.mDistanceY = r4
                android.view.VelocityTracker r4 = r3.mVelocityTracker
                r2 = 1000(0x3e8, float:1.401E-42)
                r4.computeCurrentVelocity(r2)
                boolean r4 = r3.isMove
                if (r4 != 0) goto L_0x0090
                float r4 = r3.mDistanceY
                r2 = 0
                int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0132
                boolean r4 = r3.isHitNavBar
                if (r4 != 0) goto L_0x0063
                android.view.View r4 = r3.mHitView
                if (r4 == 0) goto L_0x0063
                boolean r4 = com.didi.rfusion.widget.floating.RFViewScrollChecker.isScrollTop((android.view.View) r4)
                if (r4 == 0) goto L_0x0132
            L_0x0063:
                float r4 = r3.mDistanceY
                float r4 = java.lang.Math.abs(r4)
                float r2 = r3.mDistanceX
                float r2 = java.lang.Math.abs(r2)
                int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0081
                float r4 = r3.mDistanceY
                float r4 = java.lang.Math.abs(r4)
                int r2 = r3.mTouchSlop
                float r2 = (float) r2
                int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0081
                r0 = 1
            L_0x0081:
                r3.isMove = r0
                if (r0 == 0) goto L_0x0132
                float r4 = r3.mDistanceX
                float r0 = r3.mDistanceY
                r3.onDragStart(r4, r0)
                r3.isIntercept = r1
                goto L_0x0132
            L_0x0090:
                float r4 = r3.mDistanceX
                float r0 = r3.mDistanceY
                r3.onDraging(r4, r0)
                r3.isIntercept = r1
                goto L_0x0132
            L_0x009b:
                boolean r4 = r3.isEnableGesture
                if (r4 != 0) goto L_0x00a1
                goto L_0x0132
            L_0x00a1:
                boolean r4 = r3.isDisallow
                if (r4 == 0) goto L_0x00ad
                boolean r4 = r3.isHitViewDisallow()
                if (r4 != 0) goto L_0x00ad
                goto L_0x0132
            L_0x00ad:
                float r4 = r3.mTouchX
                float r0 = r3.mLastX
                float r4 = r4 - r0
                r3.mDistanceX = r4
                float r4 = r3.mTouchY
                float r0 = r3.mLastY
                float r4 = r4 - r0
                r3.mDistanceY = r4
                boolean r4 = r3.isMove
                if (r4 == 0) goto L_0x00d8
                android.view.VelocityTracker r4 = r3.mVelocityTracker
                float r4 = r4.getYVelocity()
                r0 = 1133903872(0x43960000, float:300.0)
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r4 <= 0) goto L_0x00cf
                r3.startCollapseAnim()
                goto L_0x00d6
            L_0x00cf:
                float r4 = r3.mDistanceX
                float r0 = r3.mDistanceY
                r3.onDragEnd(r4, r0)
            L_0x00d6:
                r3.isIntercept = r1
            L_0x00d8:
                r3.releaseVelocityTracker()
                goto L_0x0132
            L_0x00dc:
                r3.isHitNavBar = r0
                r3.isMove = r0
                r3.isDisallow = r0
                r4 = 0
                r3.mHitView = r4
                com.didi.rfusion.widget.floating.RFFloating r4 = com.didi.rfusion.widget.floating.RFFloating.this
                com.didi.rfusion.widget.floating.a r4 = r4.f36299n
                java.lang.Integer r4 = r4.mo94308a()
                if (r4 == 0) goto L_0x0101
                com.didi.rfusion.widget.floating.RFFloating r2 = com.didi.rfusion.widget.floating.RFFloating.this
                com.didi.rfusion.widget.floating.a r2 = r2.f36299n
                int r4 = r4.intValue()
                boolean r4 = r2.mo94313d(r4)
                if (r4 == 0) goto L_0x0102
            L_0x0101:
                r0 = 1
            L_0x0102:
                r3.isEnableGesture = r0
                com.didi.rfusion.widget.floating.RFFloating r4 = com.didi.rfusion.widget.floating.RFFloating.this
                android.widget.FrameLayout r4 = r4.f36292e
                int r4 = r4.getHeight()
                com.didi.rfusion.widget.floating.RFFloating r0 = com.didi.rfusion.widget.floating.RFFloating.this
                com.didi.rfusion.widget.floating.RFRoundRelativeLayout r0 = r0.f36293f
                int r0 = r0.getTop()
                int r4 = r4 - r0
                r3.mTranslateHeight = r4
                float r4 = r3.mTouchX
                float r0 = r3.mTouchY
                boolean r4 = r3.isHitNavBar(r4, r0)
                if (r4 == 0) goto L_0x0128
                r3.isHitNavBar = r1
                goto L_0x0132
            L_0x0128:
                float r4 = r3.mTouchX
                float r0 = r3.mTouchY
                android.view.View r4 = r3.getHitScrollableView(r4, r0)
                r3.mHitView = r4
            L_0x0132:
                float r4 = r3.mTouchX
                r3.mLastX = r4
                float r4 = r3.mTouchY
                r3.mLastY = r4
                boolean r4 = r3.isIntercept
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.floating.RFFloating.RFFloatingGesture.dispatchTouchEvent(android.view.MotionEvent):boolean");
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            this.isDisallow = z;
        }

        private boolean isHitViewDisallow() {
            View view;
            if (this.isDisallow && (view = this.mHitView) != null && (view instanceof ViewGroup)) {
                ((ViewGroup) view).requestDisallowInterceptTouchEvent(false);
                if (this.isDisallow) {
                    return true;
                }
                ((ViewGroup) this.mHitView).requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }

        private boolean isHitNavBar(float f, float f2) {
            return RFFloating.this.f36296i.getGlobalVisibleRect(this.mTempHitRect) && this.mTempHitRect.contains((int) f, (int) f2);
        }

        private View getHitScrollableView(float f, float f2) {
            for (View next : this.mScrollableViewList) {
                if (next.isShown() && next.getGlobalVisibleRect(this.mTempHitRect) && this.mTempHitRect.contains((int) f, (int) f2)) {
                    return next;
                }
            }
            return null;
        }

        private void acquireVelocityTracker(MotionEvent motionEvent) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
        }

        private void releaseVelocityTracker() {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        }

        private void onDragStart(float f, float f2) {
            moveFloating(Math.max(RFFloating.this.f36293f.getTranslationY() + f2, 0.0f));
            RFusionConfig.IRFusionLogger d = RFFloating.this.f36290c;
            d.info(RFFloating.f36287b, "onDragStart: start drag = " + f2);
        }

        private void onDraging(float f, float f2) {
            moveFloating(Math.max(RFFloating.this.f36293f.getTranslationY() + f2, 0.0f));
        }

        private void onDragEnd(float f, float f2) {
            if (RFFloating.this.f36293f.getTranslationY() != 0.0f) {
                if (RFFloating.this.f36293f.getTranslationY() < ((float) RFFloating.this.f36293f.getHeight()) / 2.0f) {
                    startExpandAnim();
                } else {
                    startCollapseAnim();
                }
                RFusionConfig.IRFusionLogger d = RFFloating.this.f36290c;
                d.info(RFFloating.f36287b, "onDragEnd: end drag = " + f2);
            }
        }

        private void startExpandAnim() {
            int calculateTime = calculateTime(RFFloating.this.f36293f.getTranslationY());
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{RFFloating.this.f36293f.getTranslationY(), 0.0f});
            ofFloat.setDuration((long) calculateTime);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RFFloating.RFFloatingGesture.this.lambda$startExpandAnim$1$RFFloating$RFFloatingGesture(valueAnimator);
                }
            });
            ofFloat.start();
        }

        public /* synthetic */ void lambda$startExpandAnim$1$RFFloating$RFFloatingGesture(ValueAnimator valueAnimator) {
            moveFloating(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        private void startCollapseAnim() {
            int calculateTime = calculateTime(((float) this.mTranslateHeight) - RFFloating.this.f36293f.getTranslationY());
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{RFFloating.this.f36293f.getTranslationY(), (float) this.mTranslateHeight});
            ofFloat.setDuration((long) calculateTime);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RFFloating.RFFloatingGesture.this.lambda$startCollapseAnim$2$RFFloating$RFFloatingGesture(valueAnimator);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    RFFloating.this.m27325a((Bundle) null);
                }
            });
            ofFloat.start();
        }

        public /* synthetic */ void lambda$startCollapseAnim$2$RFFloating$RFFloatingGesture(ValueAnimator valueAnimator) {
            moveFloating(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        private void moveFloating(float f) {
            float min = Math.min(Math.max(f, 0.0f), (float) this.mTranslateHeight);
            if (RFFloating.this.f36293f.getTranslationY() != min) {
                float f2 = 1.0f - (min / ((float) this.mTranslateHeight));
                RFFloating.this.f36293f.setTranslationY(min);
                RFFloating.this.f36292e.getBackground().setAlpha((int) (f2 * 255.0f));
            }
        }

        private int calculateTime(float f) {
            return (int) ((f / ((float) this.mTranslateHeight)) * 300.0f);
        }
    }
}
