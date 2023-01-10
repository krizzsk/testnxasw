package com.didiglobal.xpanelnew.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.xpanelnew.anim.XPanelAnimListener;
import com.didiglobal.xpanelnew.anim.XPanelAnimShadowFrame;
import com.didiglobal.xpanelnew.base.XpCardProperty;
import com.didiglobal.xpanelnew.base.XpConfig;
import com.didiglobal.xpanelnew.base.XpOmegaConfig;
import com.didiglobal.xpanelnew.callback.IXpCallback;
import com.didiglobal.xpanelnew.callback.IXpView;
import com.didiglobal.xpanelnew.message.IMessageDataListener;
import com.didiglobal.xpanelnew.message.IXpMessageContainer;
import com.didiglobal.xpanelnew.message.XpMessageLayout;
import com.didiglobal.xpanelnew.omega.XPanelOmegaTracker;
import com.didiglobal.xpanelnew.sdk.IXpanelNew;
import com.didiglobal.xpanelnew.util.XpLog;
import com.didiglobal.xpanelnew.util.XpUtils;
import com.didiglobal.xpanelnew.view.widget.XpBottomView;
import com.didiglobal.xpanelnew.view.widget.XpScrollView;
import com.didiglobal.xpanelnew.view.widget.XpTopView;
import com.taxis99.R;
import global.didi.pay.newview.pix.IPixView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XpanelView implements IXpView, IXpanelNew, XpScrollView.OnScrollListener, XpScrollView.OnVisibilityChangedListener {

    /* renamed from: F */
    private static int f54175F = 0;

    /* renamed from: a */
    private static final String f54176a = "Xpanel";

    /* renamed from: c */
    private static final float f54177c = 10.0f;

    /* renamed from: d */
    private static final float f54178d = 10.0f;

    /* renamed from: e */
    private static final int f54179e = 97;

    /* renamed from: f */
    private static final int f54180f = 300;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f54181A;

    /* renamed from: B */
    private int f54182B = 0;

    /* renamed from: C */
    private int f54183C = 0;

    /* renamed from: D */
    private int f54184D = 0;

    /* renamed from: E */
    private int f54185E = 0;

    /* renamed from: G */
    private int f54186G = 0;

    /* renamed from: H */
    private int f54187H;

    /* renamed from: I */
    private int f54188I;

    /* renamed from: J */
    private int f54189J;

    /* renamed from: K */
    private int f54190K;

    /* renamed from: L */
    private float f54191L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f54192M = true;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public IXpCallback f54193N;

    /* renamed from: O */
    private String f54194O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public float f54195P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public int f54196Q;

    /* renamed from: R */
    private boolean f54197R;

    /* renamed from: S */
    private int f54198S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public XPanelOmegaTracker f54199T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public boolean f54200U;

    /* renamed from: V */
    private boolean f54201V;

    /* renamed from: W */
    private List<XpCardProperty> f54202W = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: X */
    public boolean f54203X;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public int f54204Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public boolean f54205Z = false;

    /* renamed from: aa */
    private List<XpCardProperty> f54206aa = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public boolean f54207ab;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Logger f54208b = LoggerFactory.getLogger(XpLog.sTAG);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Context f54209g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Activity f54210h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f54211i = new Handler(Looper.getMainLooper());

    /* renamed from: j */
    private XpConfig f54212j;

    /* renamed from: k */
    private LayoutInflater f54213k;

    /* renamed from: l */
    private FrameLayout f54214l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public XpScrollView f54215m;
    protected int mDownHeight;
    protected int mScrollerHeight;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LinearLayout f54216n;

    /* renamed from: o */
    private XpTopView f54217o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public XpBottomView f54218p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CardView f54219q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View f54220r;

    /* renamed from: s */
    private View f54221s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f54222t;

    /* renamed from: u */
    private XpTopView.IXpSpaceViewHeightCalculate f54223u;

    /* renamed from: v */
    private XpBottomView.IBottomViewHeightCaculate f54224v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public XpMessageLayout f54225w;

    /* renamed from: x */
    private TextView f54226x;

    /* renamed from: y */
    private int f54227y;

    /* renamed from: z */
    private int f54228z;

    public void destroy() {
    }

    public void onScrolling() {
    }

    public XpanelView(Activity activity) {
        this.f54209g = activity;
        this.f54210h = activity;
        this.f54199T = new XPanelOmegaTracker(this);
    }

    public void init(XpConfig xpConfig) {
        if (xpConfig == null) {
            xpConfig = new XpConfig.Builder().build();
        }
        XpLog.m40350d("lxsConfig", IPixView.PAGE_STATUS_INIT + xpConfig.getDefaultDpSecondCardShowHeight());
        m40375a(xpConfig);
        m40368a();
    }

    public void setXpScrollEnabled(boolean z) {
        XpScrollView xpScrollView = this.f54215m;
        if (xpScrollView != null) {
            xpScrollView.setScrollEnabled(z);
        }
    }

    /* renamed from: a */
    private void m40368a() {
        LayoutInflater from = LayoutInflater.from(this.f54209g);
        this.f54213k = from;
        FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.xpanel_new_view, (ViewGroup) null);
        this.f54214l = frameLayout;
        XpScrollView xpScrollView = (XpScrollView) frameLayout.findViewById(R.id.xp_scroll_view);
        this.f54215m = xpScrollView;
        xpScrollView.setOnScrollListener(this);
        this.f54215m.setBlockFlinging(true);
        this.f54215m.setOnVisibilityChangedListener(this);
        this.f54216n = (LinearLayout) this.f54214l.findViewById(R.id.xp_cell_container);
        this.f54219q = (CardView) this.f54214l.findViewById(R.id.xp_bg_back_msg);
        this.f54220r = this.f54214l.findViewById(R.id.xp_bg_view);
        this.f54219q.setRadius((float) this.f54196Q);
        if (this.f54219q.getLayoutParams() != null && (this.f54219q.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.f54219q.getLayoutParams()).bottomMargin = -this.f54196Q;
        }
        TextView textView = (TextView) this.f54213k.inflate(R.layout.xpanel_title_layout, this.f54219q, false);
        this.f54226x = textView;
        this.f54219q.addView(textView, 0);
        XpMessageLayout xpMessageLayout = new XpMessageLayout(this.f54209g, this.f54196Q);
        this.f54225w = xpMessageLayout;
        xpMessageLayout.setVisibility(8);
        this.f54225w.setMessageDataListener(new IMessageDataListener() {
            public void notifyAdd() {
                XpanelView.this.f54193N.doXpanelStatusHeight(2, XpanelView.this.f54181A + XpanelView.this.getMessageRealHeight());
                XpanelView.this.m40417n();
                XpanelView.this.m40419o();
                XpanelView.this.m40409j();
                XpanelView.this.m40405h();
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(XpUtils.dip2px(this.f54209g, 10.0f), 0, XpUtils.dip2px(this.f54209g, 10.0f), 0);
        this.f54214l.addView(this.f54225w, 2, layoutParams);
        this.f54215m.setDirectionListener(new XpScrollView.XpScrollViewListener() {
            public void direction(int i) {
            }

            public void event(float f, float f2) {
                float unused = XpanelView.this.f54195P = f2;
                XpLog.m40349d("event: " + f2);
            }

            public int getAreaCanScrollAboveFirstCard() {
                if (XpanelView.this.m40420p() != 0) {
                    return XpanelView.this.getMessageRealHeight();
                }
                return 0;
            }
        });
        this.f54215m.setXpMsgContainerListener(new XpScrollView.XpMsgContainerListener() {
            public Rect getMsgContainerRect() {
                Rect rect = new Rect();
                XpanelView.this.f54225w.getGlobalVisibleRect(rect);
                rect.bottom = rect.top + XpanelView.this.getMessageRealHeight();
                return rect;
            }
        });
        this.f54215m.setXpMsgClickListener(new XpScrollView.XpMsgClickListener() {
            public void onClick() {
                if (XpanelView.this.getStatus() != 1) {
                    XpanelView xpanelView = XpanelView.this;
                    boolean unused = xpanelView.m40381a(xpanelView.f54225w.getView());
                }
            }
        });
        this.f54221s = this.f54214l.findViewById(R.id.xp_scroll_mark);
    }

    public View getView() {
        return this.f54214l;
    }

    public int getScrollerRealHeight() {
        return XpUtils.getScreenHeight(this.f54210h) - this.mScrollerHeight;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m40381a(View view) {
        if (!(view instanceof ViewGroup)) {
            return view.callOnClick();
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (!viewGroup.getChildAt(0).callOnClick()) {
            return m40381a(viewGroup.getChildAt(0));
        }
        return false;
    }

    /* renamed from: a */
    private void m40375a(XpConfig xpConfig) {
        this.f54212j = xpConfig;
        this.f54181A = XpUtils.dip2px(this.f54209g, 250.0f);
        this.mDownHeight = XpUtils.dip2px(this.f54209g, xpConfig.getDefaultDpFoldHeight());
        this.f54196Q = XpUtils.dip2px(this.f54209g, xpConfig.getCardRoundedCornerDp());
        this.mScrollerHeight = XpUtils.getScreenHeight(this.f54210h) - XpUtils.dip2px(this.f54209g, 97.0f);
        f54175F = XpUtils.dip2px(this.f54209g, 30.0f);
        m40386b();
        this.f54228z = (int) (((double) XpUtils.getScreenHeight(this.f54210h)) * 0.65d);
        this.f54198S = (int) (((double) XpUtils.getScreenHeight(this.f54210h)) * 0.6d);
        this.f54187H = XpUtils.getScreenWidth(this.f54209g) - (XpUtils.dip2px(this.f54209g, 10.0f) * 2);
    }

    /* renamed from: a */
    private void m40376a(XpOmegaConfig xpOmegaConfig) {
        XPanelOmegaTracker xPanelOmegaTracker = this.f54199T;
        if (xPanelOmegaTracker != null) {
            xPanelOmegaTracker.setXPanelItemShowCallback(xpOmegaConfig.getxPanelOmegaCallback());
        }
    }

    /* renamed from: b */
    private void m40386b() {
        this.f54182B = XpUtils.dip2px(this.f54209g, 97.0f);
        this.f54184D = XpUtils.getScreenHeight(this.f54210h) - this.mDownHeight;
    }

    /* renamed from: a */
    private void m40370a(final int i) {
        this.f54217o = new XpTopView(this.f54209g);
        C181295 r0 = new XpTopView.IXpSpaceViewHeightCalculate() {
            public int measureHeight(int i) {
                return XpanelView.this.mScrollerHeight - i;
            }
        };
        this.f54223u = r0;
        this.f54217o.setSpaceViewHeightCalculate(r0);
        this.f54216n.addView(this.f54217o);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40369a(float f) {
        if (!this.f54197R) {
            this.f54218p = new XpBottomView(this.f54209g);
            int i = 0;
            int i2 = this.mScrollerHeight;
            if (f < ((float) i2)) {
                i = i2 - ((int) f);
            }
            this.f54204Y = i;
            C181306 r4 = new XpBottomView.IBottomViewHeightCaculate() {
                public int measureBottomHeight() {
                    return XpanelView.this.f54204Y;
                }
            };
            this.f54224v = r4;
            this.f54218p.bindInterface(r4);
            this.f54216n.addView(this.f54218p);
            this.f54197R = true;
        }
    }

    public void setData(List<XpCardProperty> list) {
        if (!this.f54205Z) {
            setDataWithAnimator(list, false);
        }
    }

    public void addCard(final XpCardProperty xpCardProperty, final int i) {
        m40373a(xpCardProperty.getView(), i, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (XpanelView.this.f54199T != null) {
                    XpanelView.this.f54199T.addCurrentCardProperties(xpCardProperty, i);
                    UIThreadHandler.post(new Runnable() {
                        public void run() {
                            XpanelView.this.f54199T.omegaShowTrack(XpanelView.this.f54207ab);
                        }
                    }, 1000);
                }
            }
        });
    }

    public void setDataWithAnimator(List<XpCardProperty> list, boolean z) {
        if (list != null && !list.isEmpty() && !this.f54205Z) {
            if (this.f54201V) {
                this.f54202W = list;
            } else {
                m40380a(list, z);
            }
        }
    }

    /* renamed from: a */
    private void m40380a(final List<XpCardProperty> list, boolean z) {
        if (this.f54216n != null) {
            final List<RoundCornerRelativeLayout> a = m40367a(list);
            if (!z || m40392c()) {
                m40397e();
                m40379a(a, list, false);
            } else if (getStatus() == 2) {
                final XPanelAnimShadowFrame xPanelAnimShadowFrame = new XPanelAnimShadowFrame(this.f54209g, this.f54196Q, 300);
                xPanelAnimShadowFrame.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                RoundCornerRelativeLayout roundCornerRelativeLayout = (RoundCornerRelativeLayout) this.f54216n.getChildAt(1);
                RoundCornerRelativeLayout roundCornerRelativeLayout2 = a.get(0);
                roundCornerRelativeLayout.setDrawingCacheEnabled(true);
                roundCornerRelativeLayout2.setDrawingCacheEnabled(true);
                xPanelAnimShadowFrame.setAnimView(roundCornerRelativeLayout, roundCornerRelativeLayout2);
                ((ViewGroup) this.f54210h.getWindow().getDecorView()).addView(xPanelAnimShadowFrame);
                xPanelAnimShadowFrame.setAnimatorEndListener(new XPanelAnimShadowFrame.AnimatorEndListener() {
                    public void onAnimatorEnd() {
                        ((ViewGroup) XpanelView.this.f54210h.getWindow().getDecorView()).removeView(xPanelAnimShadowFrame);
                        XpanelView.this.m40397e();
                        XpanelView.this.m40379a((List<RoundCornerRelativeLayout>) a, (List<XpCardProperty>) list, false);
                        XpanelView.this.f54215m.setDoingAnim(false);
                        boolean unused = XpanelView.this.f54205Z = false;
                    }

                    public void onAnimatorStart() {
                        boolean unused = XpanelView.this.f54205Z = true;
                        XpanelView.this.f54215m.setDoingAnim(true);
                    }
                });
            } else {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f54216n, "alpha", new float[]{1.0f, 0.0f});
                ofFloat.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        boolean unused = XpanelView.this.f54205Z = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        XpanelView.this.m40397e();
                        XpanelView.this.m40379a((List<RoundCornerRelativeLayout>) a, (List<XpCardProperty>) list, true);
                        XpanelView.this.f54215m.setDoingAnim(false);
                        boolean unused = XpanelView.this.f54205Z = false;
                    }
                });
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f54225w, "alpha", new float[]{1.0f, 0.0f});
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
                animatorSet.setDuration(300);
                animatorSet.start();
                this.f54215m.setDoingAnim(true);
            }
        }
    }

    /* renamed from: c */
    private boolean m40392c() {
        LinearLayout linearLayout = this.f54216n;
        if (linearLayout != null && linearLayout.getChildCount() >= 3) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private List<RoundCornerRelativeLayout> m40367a(List<XpCardProperty> list) {
        View view;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            XpCardProperty xpCardProperty = list.get(i);
            if (!(xpCardProperty == null || (view = xpCardProperty.getView()) == null)) {
                if (view.getParent() != null && (view.getParent() instanceof RoundCornerRelativeLayout)) {
                    ((RoundCornerRelativeLayout) view.getParent()).removeAllViews();
                }
                RoundCornerRelativeLayout d = m40394d();
                d.addView(view, new ViewGroup.LayoutParams(-1, -2));
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private RoundCornerRelativeLayout m40394d() {
        RoundCornerRelativeLayout roundCornerRelativeLayout = (RoundCornerRelativeLayout) this.f54213k.inflate(R.layout.xpanel_card_parent_layout, this.f54216n, false);
        roundCornerRelativeLayout.setRadius(this.f54196Q);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) this.f54196Q);
        gradientDrawable.setColor(-1);
        roundCornerRelativeLayout.setBackground(gradientDrawable);
        return roundCornerRelativeLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40379a(List<RoundCornerRelativeLayout> list, List<XpCardProperty> list2, final boolean z) {
        m40370a(this.mDownHeight);
        final int size = list2.size();
        XpLog.m40350d(f54176a, "cardcount:" + size);
        for (int i = 0; i < list.size(); i++) {
            this.f54216n.addView(list.get(i));
        }
        this.f54216n.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                XpLog.m40350d(XpanelView.f54176a, "onPreDraw");
                XpanelView.this.f54216n.getViewTreeObserver().removeOnPreDrawListener(this);
                if (XpanelView.this.f54216n.getChildAt(1) != null && Build.VERSION.SDK_INT >= 21) {
                    XpanelView.this.f54216n.getChildAt(1).setTranslationZ(60.0f);
                }
                int i = 0;
                for (int i2 = 1; i2 < XpanelView.this.f54216n.getChildCount(); i2++) {
                    if (XpanelView.this.f54216n.getChildAt(i2) instanceof RoundCornerRelativeLayout) {
                        i += XpanelView.this.f54216n.getChildAt(i2).getMeasuredHeight() + XpUtils.dip2px(XpanelView.this.f54209g, 10.0f);
                    }
                }
                XpanelView.this.m40369a((float) i);
                XpanelView.this.f54211i.post(new Runnable() {
                    public void run() {
                        XpanelView.this.m40387b(size);
                        boolean unused = XpanelView.this.f54222t = false;
                        XpanelView.this.f54215m.setLastStatus(XpanelView.this.f54215m.getStatus());
                        XpanelView.this.defaultState(z);
                        XpanelView.this.f54208b.info("三态：addView 默认态", new Object[0]);
                    }
                });
                return false;
            }
        });
        this.f54206aa = list2;
        this.f54199T.setCurrentCardProperties(list2);
        List<XpCardProperty> list3 = this.f54202W;
        if (list3 != null && list3.size() > 0) {
            this.f54202W.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m40397e() {
        RoundCornerRelativeLayout roundCornerRelativeLayout;
        int childCount = this.f54216n.getChildCount();
        for (int i = 0; i <= childCount - 1; i++) {
            if ((this.f54216n.getChildAt(i) instanceof RoundCornerRelativeLayout) && (roundCornerRelativeLayout = (RoundCornerRelativeLayout) this.f54216n.getChildAt(i)) != null) {
                roundCornerRelativeLayout.removeAllViews();
            }
        }
        this.f54216n.removeAllViews();
        this.f54197R = false;
    }

    public void setShowOneCard() {
        m40387b(1);
        XpScrollView xpScrollView = this.f54215m;
        xpScrollView.setLastStatus(xpScrollView.getStatus());
        defaultState();
        this.f54208b.info("三态：多张卡片只展示一张卡片，默认态", new Object[0]);
    }

    public void firstCardHeightWillChangeTo(XpConfig xpConfig) {
        m40375a(xpConfig);
        m40387b(-1);
        XpScrollView xpScrollView = this.f54215m;
        xpScrollView.setLastStatus(xpScrollView.getStatus());
        this.f54203X = true;
        UIThreadHandler.post(new Runnable() {
            public void run() {
                boolean unused = XpanelView.this.f54203X = false;
            }
        }, 600);
        if (getStatus() != 1) {
            defaultState();
        }
    }

    public void cardHeightChange(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 1; i5 < this.f54216n.getChildCount(); i5++) {
            if (this.f54216n.getChildAt(i5) instanceof RoundCornerRelativeLayout) {
                i4 += this.f54216n.getChildAt(i5).getMeasuredHeight() + XpUtils.dip2px(this.f54209g, 10.0f);
                XpLog.m40350d("xpanel_bottom", "item height = " + this.f54216n.getChildAt(i5).getMeasuredHeight());
            }
        }
        int measuredHeight = i4 - (this.f54216n.getChildAt(i).getMeasuredHeight() - i2);
        if (this.f54218p == null) {
            m40369a((float) measuredHeight);
            return;
        }
        int i6 = this.mScrollerHeight;
        if (measuredHeight < i6) {
            i3 = i6 - measuredHeight;
        }
        this.f54204Y = i3;
        this.f54218p.requestLayout();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40387b(int i) {
        if (!m40413l()) {
            if (this.f54212j.getFirstCardHeightWillChangeTo() != 0) {
                this.f54181A = XpUtils.dip2px(this.f54209g, this.f54212j.getDefaultDpSecondCardShowHeight() + 10.0f) + this.f54212j.getFirstCardHeightWillChangeTo();
                XpLog.m40350d("setConfigValue", this.f54212j.getDefaultDpSecondCardShowHeight() + ";" + this.f54212j.getFirstCardHeightWillChangeTo());
            } else if (this.f54212j.getOneCardAndXDp() != 0.0f) {
                this.f54181A = this.f54216n.getChildAt(1).getMeasuredHeight() + XpUtils.dip2px(this.f54209g, this.f54212j.getOneCardAndXDp() + 10.0f);
            } else if (i == 1) {
                this.f54181A = this.f54216n.getChildAt(1).getMeasuredHeight() + XpUtils.dip2px(this.f54209g, 10.0f);
            } else {
                this.f54181A = this.f54216n.getChildAt(1).getMeasuredHeight() + XpUtils.dip2px(this.f54209g, this.f54212j.getDefaultDpSecondCardShowHeight() + 10.0f);
            }
            int messageRealHeight = this.f54181A + getMessageRealHeight();
            int i2 = this.f54198S;
            if (messageRealHeight > i2) {
                this.f54181A = i2 - getMessageRealHeight();
            }
            int i3 = this.f54181A;
            int i4 = this.mDownHeight;
            if (i3 <= i4) {
                this.f54181A = i4 + 1;
            }
            XpLog.m40350d("lxsConfig", "setConfigValue" + this.f54212j.getDefaultDpSecondCardShowHeight() + " mLastDefaultShow: " + this.f54181A);
            this.f54183C = XpUtils.getScreenHeight(this.f54210h) - this.f54181A;
        }
    }

    /* renamed from: a */
    private void m40374a(XpCardProperty xpCardProperty, int i) {
        XpBottomView xpBottomView = this.f54218p;
        if (xpBottomView != null) {
            this.f54216n.removeView(xpBottomView);
        }
        View view = xpCardProperty.getView();
        if (view != null) {
            this.f54216n.addView(view, i);
        }
        this.f54211i.post(new Runnable() {
            public void run() {
                int i = 0;
                for (int i2 = 1; i2 < XpanelView.this.f54216n.getChildCount(); i2++) {
                    i += XpanelView.this.f54216n.getChildAt(i2).getMeasuredHeight();
                }
                XpanelView.this.m40369a((float) i);
            }
        });
    }

    public void setXpCallback(IXpCallback iXpCallback) {
        this.f54193N = iXpCallback;
        iXpCallback.onCardWithCallback(this.f54187H);
    }

    public void addViewWhenDefault(View view, int i) {
        LinearLayout linearLayout = this.f54216n;
        if (linearLayout != null) {
            if (i > 1) {
                linearLayout.addView(view, i);
            } else {
                m40372a(view, i);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r0 = m40394d();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m40373a(android.view.View r8, int r9, android.animation.Animator.AnimatorListener r10) {
        /*
            r7 = this;
            android.widget.LinearLayout r0 = r7.f54216n
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.didi.global.globaluikit.widget.RoundCornerRelativeLayout r0 = r7.m40394d()
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            android.view.ViewGroup$LayoutParams r1 = new android.view.ViewGroup$LayoutParams
            r2 = -1
            r3 = -2
            r1.<init>(r2, r3)
            android.view.ViewParent r2 = r8.getParent()
            if (r2 == 0) goto L_0x002a
            android.view.ViewParent r2 = r8.getParent()
            boolean r2 = r2 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x002a
            android.view.ViewParent r2 = r8.getParent()
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r2.removeView(r8)
        L_0x002a:
            r0.addView(r8, r1)
            android.widget.LinearLayout r1 = r7.f54216n
            r1.addView(r0, r9)
            r9 = 0
            r0.measure(r9, r9)
            int r1 = r0.getMeasuredHeight()
            r2 = 2
            int[] r3 = new int[r2]
            r3[r9] = r9
            r4 = 1
            r3[r4] = r1
            android.animation.ValueAnimator r1 = android.animation.ValueAnimator.ofInt(r3)
            com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType r3 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT
            android.view.animation.Interpolator r3 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(r3)
            r1.setInterpolator(r3)
            com.didiglobal.xpanelnew.view.XpanelView$13 r3 = new com.didiglobal.xpanelnew.view.XpanelView$13
            r3.<init>(r0)
            r1.addUpdateListener(r3)
            com.didiglobal.xpanelnew.view.XpanelView$14 r3 = new com.didiglobal.xpanelnew.view.XpanelView$14
            r3.<init>(r0)
            r1.addListener(r3)
            int[] r3 = new int[r2]
            r3[r9] = r9
            android.content.Context r5 = r7.f54209g
            r6 = 1092616192(0x41200000, float:10.0)
            int r5 = com.didiglobal.xpanelnew.util.XpUtils.dip2px(r5, r6)
            r3[r4] = r5
            android.animation.ValueAnimator r3 = android.animation.ValueAnimator.ofInt(r3)
            com.didiglobal.xpanelnew.view.XpanelView$15 r5 = new com.didiglobal.xpanelnew.view.XpanelView$15
            r5.<init>(r0)
            r3.addUpdateListener(r5)
            float[] r0 = new float[r2]
            r0 = {0, 1065353216} // fill-array
            java.lang.String r5 = "alpha"
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r5, r0)
            com.didiglobal.xpanelnew.view.widget.MountainInterpolator r0 = new com.didiglobal.xpanelnew.view.widget.MountainInterpolator
            r0.<init>()
            r8.setInterpolator(r0)
            android.animation.AnimatorSet r0 = new android.animation.AnimatorSet
            r0.<init>()
            r5 = 3
            android.animation.Animator[] r5 = new android.animation.Animator[r5]
            r5[r9] = r1
            r5[r4] = r8
            r5[r2] = r3
            r0.playTogether(r5)
            r8 = 400(0x190, double:1.976E-321)
            r0.setDuration(r8)
            r0.addListener(r10)
            r0.start()
            com.didiglobal.xpanelnew.view.widget.XpScrollView r8 = r7.f54215m
            r8.setDoingAnim(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xpanelnew.view.XpanelView.m40373a(android.view.View, int, android.animation.Animator$AnimatorListener):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m40400f() {
        int i = 0;
        int i2 = 0;
        for (int i3 = 1; i3 < this.f54216n.getChildCount(); i3++) {
            if (this.f54216n.getChildAt(i3) instanceof RoundCornerRelativeLayout) {
                i2 += this.f54216n.getChildAt(i3).getMeasuredHeight() + XpUtils.dip2px(this.f54209g, 10.0f);
                XpLog.m40350d("xpanel_bottom", "item height = " + this.f54216n.getChildAt(i3).getMeasuredHeight());
            }
        }
        if (this.f54218p == null) {
            m40369a((float) i2);
            return;
        }
        int i4 = this.mScrollerHeight;
        if (i2 < i4) {
            i = i4 - i2;
        }
        this.f54204Y = i;
        this.f54218p.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r0 = r0.getChildAt(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeCard(final int r10) {
        /*
            r9 = this;
            android.widget.LinearLayout r0 = r9.f54216n
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.view.View r0 = r0.getChildAt(r10)
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            int r1 = r0.getMeasuredHeight()
            r2 = 2
            int[] r3 = new int[r2]
            r4 = 0
            r3[r4] = r1
            r5 = 1
            r3[r5] = r4
            android.animation.ValueAnimator r3 = android.animation.ValueAnimator.ofInt(r3)
            com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType r6 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT
            android.view.animation.Interpolator r6 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(r6)
            r3.setInterpolator(r6)
            com.didiglobal.xpanelnew.view.XpanelView$16 r6 = new com.didiglobal.xpanelnew.view.XpanelView$16
            r6.<init>(r0)
            r3.addUpdateListener(r6)
            int[] r6 = new int[r2]
            android.content.Context r7 = r9.f54209g
            r8 = 1092616192(0x41200000, float:10.0)
            int r7 = com.didiglobal.xpanelnew.util.XpUtils.dip2px(r7, r8)
            r6[r4] = r7
            r6[r5] = r4
            android.animation.ValueAnimator r6 = android.animation.ValueAnimator.ofInt(r6)
            com.didiglobal.xpanelnew.view.XpanelView$17 r7 = new com.didiglobal.xpanelnew.view.XpanelView$17
            r7.<init>(r0)
            r6.addUpdateListener(r7)
            float[] r7 = new float[r2]
            r7 = {1065353216, 0} // fill-array
            java.lang.String r8 = "alpha"
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r0, r8, r7)
            android.animation.AnimatorSet r7 = new android.animation.AnimatorSet
            r7.<init>()
            r8 = 3
            android.animation.Animator[] r8 = new android.animation.Animator[r8]
            r8[r4] = r3
            r8[r5] = r0
            r8[r2] = r6
            r7.playTogether(r8)
            r2 = 400(0x190, double:1.976E-321)
            r7.setDuration(r2)
            com.didiglobal.xpanelnew.view.XpanelView$18 r0 = new com.didiglobal.xpanelnew.view.XpanelView$18
            r0.<init>(r1, r10)
            r7.addListener(r0)
            r7.start()
            com.didiglobal.xpanelnew.view.widget.XpScrollView r10 = r9.f54215m
            r10.setDoingAnim(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xpanelnew.view.XpanelView.removeCard(int):void");
    }

    /* renamed from: a */
    private List<Animator> m40366a(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        int i2 = i;
        while (i2 <= this.f54216n.getChildCount()) {
            int i3 = i2 + 1;
            if (i3 < this.f54216n.getChildCount()) {
                View childAt = this.f54216n.getChildAt(i3);
                if (i2 < i + 1 && z) {
                    childAt.setTranslationY((float) (-childAt.getHeight()));
                }
                arrayList.add(ObjectAnimator.ofFloat(childAt, "TranslationY", new float[]{(float) (-childAt.getMeasuredHeight()), 0.0f}));
            }
            i2 = i3;
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m40372a(View view, int i) {
        final float f;
        final RoundCornerRelativeLayout roundCornerRelativeLayout = (RoundCornerRelativeLayout) this.f54216n.getChildAt(i);
        int[] iArr = new int[2];
        roundCornerRelativeLayout.getLocationOnScreen(iArr);
        final RoundCornerRelativeLayout d = m40394d();
        int width = roundCornerRelativeLayout.getWidth();
        int height = roundCornerRelativeLayout.getHeight();
        d.addView(view);
        this.f54216n.addView(d, i);
        RoundCornerRelativeLayout roundCornerRelativeLayout2 = new RoundCornerRelativeLayout(this.f54209g);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        roundCornerRelativeLayout2.setRadius((int) roundCornerRelativeLayout.getTopLeftRadius());
        roundCornerRelativeLayout2.setLayoutParams(layoutParams);
        roundCornerRelativeLayout2.setBackground(this.f54225w.getChildAt(0).getBackground());
        roundCornerRelativeLayout2.setX((float) iArr[0]);
        roundCornerRelativeLayout2.setY((float) iArr[1]);
        final FrameLayout frameLayout = new FrameLayout(this.f54209g);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        frameLayout.addView(roundCornerRelativeLayout2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(roundCornerRelativeLayout2, "Alpha", new float[]{1.0f, 0.0f});
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        if (Build.VERSION.SDK_INT >= 21) {
            float translationZ = d.getTranslationZ();
            d.setTranslationZ(100.0f + translationZ);
            f = translationZ;
        } else {
            f = 0.0f;
        }
        arrayList.addAll(m40366a(i, true));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new XPanelAnimListener() {
            public void onAnimationStart(Animator animator) {
                ((FrameLayout) XpanelView.this.f54210h.getWindow().getDecorView()).addView(frameLayout);
                if (Build.VERSION.SDK_INT >= 21) {
                    roundCornerRelativeLayout.setTranslationZ(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                XpanelView.this.f54215m.setDoingAnim(false);
                ((FrameLayout) XpanelView.this.f54210h.getWindow().getDecorView()).removeView(frameLayout);
                if (Build.VERSION.SDK_INT >= 21) {
                    d.setTranslationZ(f);
                }
            }
        });
        animatorSet.setDuration(1000);
        animatorSet.start();
        this.f54215m.setDoingAnim(true);
    }

    /* renamed from: a */
    private void m40371a(int i, int i2) {
        int lastStatus = this.f54215m.getLastStatus();
        if (i == 2) {
            int i3 = this.f54182B;
            if (i3 < i2 && i2 < i3 + f54175F) {
                upState();
                this.f54208b.info("三态：下拉，吸顶", new Object[0]);
            } else if (this.f54182B + f54175F <= i2 && i2 <= this.f54183C) {
                defaultState();
                this.f54208b.info("三态：下拉，默认", new Object[0]);
            } else if (this.f54183C >= i2 || i2 > this.f54184D || this.f54215m.getLastStatus() == 3) {
                Logger logger = this.f54208b;
                logger.info("三态：下拉 currentY：" + i2, new Object[0]);
            } else {
                bottomState();
                if (i2 == this.f54184D) {
                    m40417n();
                    m40419o();
                    m40409j();
                    m40405h();
                }
                this.f54208b.info("三态：下拉，吸底", new Object[0]);
            }
        } else if (i2 <= this.f54228z && this.f54215m.getLastStatus() != 1) {
            upState();
            this.f54208b.info("三态：上拉，吸顶", new Object[0]);
        } else if (this.f54228z >= i2 || i2 >= this.f54184D) {
            Logger logger2 = this.f54208b;
            logger2.info("三态：上拉 currentY" + i2, new Object[0]);
        } else {
            defaultState();
            Logger logger3 = this.f54208b;
            logger3.info("三态：上拉，默认" + this.f54228z + "--" + this.f54183C, new Object[0]);
        }
        m40388b(i, lastStatus);
    }

    /* renamed from: b */
    private void m40388b(int i, int i2) {
        int i3 = 2;
        String str = i == 2 ? "xpanel_pull_down" : "xpanel_pull_up";
        if (i2 != 1) {
            i3 = i2 != 2 ? i2 != 3 ? -1 : 1 : 0;
        }
        if (i3 >= 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("from_pos", Integer.valueOf(i3));
            SystemUtils.log(6, "omegaScrollTrack", str + ":" + i3, (Throwable) null, "com.didiglobal.xpanelnew.view.XpanelView", 1109);
            OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: g */
    private int m40402g() {
        LinearLayout linearLayout = this.f54216n;
        if (linearLayout == null || linearLayout.getChildCount() < 2 || this.f54216n.getChildAt(1) == null) {
            return 0;
        }
        int[] iArr = new int[2];
        this.f54216n.getChildAt(1).getLocationOnScreen(iArr);
        XpLog.m40350d(f54176a, iArr[1] + " !! " + this.f54215m.getTop() + " @ " + XpUtils.getScreenHeight(this.f54210h) + " $ " + this.mScrollerHeight);
        return iArr[1];
    }

    public int getFirstCardHeight() {
        return XpUtils.getScreenHeight(this.f54210h) - m40402g();
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        m40417n();
        m40419o();
        m40409j();
        m40405h();
        XpLog.m40352e("onScrollChanged x: " + i + "; y:" + i2 + "; oldx: " + i3 + "; oldy:" + i4);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m40405h() {
        if (getFirstCardHeight() <= this.f54181A || (this.f54203X && getStatus() != 1)) {
            this.f54214l.setBackgroundColor(0);
            return;
        }
        int firstCardHeight = getFirstCardHeight();
        int i = this.f54181A;
        float min = Math.min(Math.max((float) (((double) (firstCardHeight - i)) / (((double) (this.mScrollerHeight - i)) * 0.5d)), 0.0f), 1.0f);
        this.f54214l.setBackgroundColor(Color.parseColor("#0A121A"));
        this.f54214l.getBackground().setAlpha((int) (((double) min) * 0.7d * 255.0d));
    }

    public void onScrollStopped(float f) {
        XpLog.m40350d("lxs Slop", f + " : " + ViewConfiguration.get(this.f54209g).getScaledTouchSlop());
        if (f >= ((float) ViewConfiguration.get(this.f54209g).getScaledTouchSlop())) {
            m40371a(this.f54215m.getDirection(), m40402g());
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (XpanelView.this.f54207ab) {
                        XpanelView.this.f54199T.omegaShowTrack(true);
                    }
                }
            }, 500);
        }
    }

    /* renamed from: i */
    private boolean m40407i() {
        return XpUtils.dip2px(this.f54209g, 97.0f) > m40402g();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m40409j() {
        if (this.f54215m.getStatus() == 1) {
            if (this.f54215m.getLastStatus() == 1 && getFirstCardHeight() <= this.mScrollerHeight) {
                this.f54190K = getFirstCardHeight() + this.f54226x.getMeasuredHeight() + this.f54196Q;
                this.f54219q.getLayoutParams().height = this.f54190K;
                IXpCallback iXpCallback = this.f54193N;
                if (iXpCallback != null && !this.f54200U) {
                    iXpCallback.doXPanelHeightChange(this.f54190K - this.f54196Q);
                }
                this.f54219q.requestLayout();
                this.f54220r.getLayoutParams().height = this.f54190K - this.f54196Q;
                this.f54220r.requestLayout();
                this.f54221s.setTranslationY((float) (-(((getFirstCardHeight() + this.f54226x.getMeasuredHeight()) - XpUtils.dip2px(this.f54209g, 5.0f)) - this.f54221s.getMeasuredHeight())));
            }
        } else if (!m40407i()) {
            this.f54190K = getFirstCardHeight();
            this.f54189J = this.f54187H;
            int firstCardHeight = getFirstCardHeight();
            int i = this.f54181A;
            float f = (float) (((double) (firstCardHeight - i)) / (((double) (this.mScrollerHeight - i)) * 0.5d));
            this.f54191L = f;
            float max = Math.max(f, 0.0f);
            this.f54191L = max;
            this.f54191L = Math.min(max, 1.0f);
            int dip2px = (int) (((float) XpUtils.dip2px(this.f54209g, 10.0f)) * this.f54191L);
            if (m40420p() > 0) {
                this.f54190K += getMessageRealHeight();
            }
            int i2 = this.f54190K + dip2px;
            this.f54190K = i2;
            this.f54189J += dip2px * 2;
            this.f54190K = i2 + this.f54196Q;
            this.f54219q.getLayoutParams().height = this.f54190K;
            IXpCallback iXpCallback2 = this.f54193N;
            if (iXpCallback2 != null && !this.f54200U) {
                iXpCallback2.doXPanelHeightChange(this.f54190K - this.f54196Q);
            }
            this.f54219q.getLayoutParams().width = this.f54189J;
            if (!this.f54203X) {
                this.f54219q.setAlpha(this.f54191L);
            }
            XpLog.m40349d("bgwidth" + dip2px + "mMsgBgRatio" + this.f54191L);
            this.f54219q.requestLayout();
            this.f54220r.getLayoutParams().height = this.f54190K - this.f54196Q;
            this.f54220r.requestLayout();
        }
    }

    public int getMessageRealHeight() {
        if (m40420p() == 0) {
            return 0;
        }
        return m40420p() - (this.f54196Q * 2);
    }

    public void fistCardHeightChange(int i) {
        if (getStatus() == 1) {
            for (int i2 = 2; i2 < this.f54216n.getChildCount(); i2++) {
                this.f54216n.getChildAt(i2).setTranslationY((float) (-(XpUtils.dip2px(this.f54209g, 10.0f) + i)));
            }
        }
    }

    public LinearLayout getCellContainer() {
        return this.f54216n;
    }

    public void upState() {
        LinearLayout linearLayout = this.f54216n;
        if (linearLayout != null && linearLayout.getChildAt(1) != null) {
            int[] iArr = new int[2];
            this.f54216n.getChildAt(1).getLocationOnScreen(iArr);
            int i = iArr[1];
            this.f54215m.setCurrentStatus(1);
            XpLog.m40353e(f54176a, "currentY:" + i + ", status:" + XpUtils.getStatusBarHeight(this.f54209g) + ", 97: " + XpUtils.dip2px(this.f54209g, 97.0f));
            this.f54215m.smoothScrollBy(0, i - XpUtils.dip2px(this.f54209g, 97.0f));
            this.f54193N.doXpanelStatusHeight(1, this.mScrollerHeight + this.f54226x.getMeasuredHeight());
            if (this.f54215m.getDirection() == 1) {
                m40410k();
            }
            this.f54208b.info("state吸顶态", new Object[0]);
        }
    }

    /* renamed from: k */
    private void m40410k() {
        XpanelView xpanelView = this;
        int i = 2;
        char c = 0;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{xpanelView.f54190K, xpanelView.mScrollerHeight + xpanelView.f54226x.getMeasuredHeight() + xpanelView.f54196Q});
        ofInt.setDuration(100);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XpanelView.this.f54219q.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (XpanelView.this.f54193N != null) {
                    XpanelView.this.f54193N.doXPanelHeightChange(((Integer) valueAnimator.getAnimatedValue()).intValue() - XpanelView.this.f54196Q);
                }
                XpanelView.this.f54219q.requestLayout();
                XpanelView.this.f54220r.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue() - XpanelView.this.f54196Q;
                XpanelView.this.f54220r.requestLayout();
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{xpanelView.f54189J, xpanelView.f54215m.getWidth()});
        ofInt2.setDuration(100);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XpanelView.this.f54219q.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                XpanelView.this.f54219q.requestLayout();
            }
        });
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{xpanelView.f54191L, 1.0f});
        ofFloat.setDuration(100);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XpanelView.this.f54219q.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(xpanelView.f54221s, "translationY", new float[]{(float) (-(((xpanelView.mScrollerHeight + xpanelView.f54226x.getMeasuredHeight()) - XpUtils.dip2px(xpanelView.f54209g, 5.0f)) - xpanelView.f54221s.getMeasuredHeight()))});
        ofFloat2.setDuration(100);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(xpanelView.f54225w, "alpha", new float[]{1.0f, 0.0f});
        ofFloat3.setDuration(150);
        if (!m40413l()) {
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(xpanelView.f54216n.getChildAt(1), "alpha", new float[]{1.0f, 0.0f});
            ofFloat4.setDuration(200);
            if (Build.VERSION.SDK_INT >= 21) {
                xpanelView.f54216n.getChildAt(1).setZ(0.0f);
            }
            int measuredHeight = xpanelView.f54216n.getChildAt(1).getMeasuredHeight() + XpUtils.dip2px(xpanelView.f54209g, 10.0f);
            XpLog.m40350d("xpanel_upstate", "translationY: " + measuredHeight);
            ArrayList arrayList = new ArrayList();
            int i2 = 2;
            while (i2 < xpanelView.f54216n.getChildCount()) {
                View childAt = xpanelView.f54216n.getChildAt(i2);
                float[] fArr = new float[i];
                fArr[c] = 0.0f;
                fArr[1] = (float) (-measuredHeight);
                arrayList.add(ObjectAnimator.ofFloat(childAt, "translationY", fArr).setDuration(300));
                i2++;
                i = 2;
                c = 0;
                xpanelView = this;
            }
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            arrayList.add(ofInt);
            arrayList.add(ofInt2);
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            animatorSet.playTogether(arrayList);
            animatorSet.start();
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = XpanelView.this.f54200U = false;
                    XpanelView.this.f54215m.setDoingAnim(false);
                    boolean unused2 = XpanelView.this.f54192M = false;
                    XpanelView.this.f54216n.getChildAt(1).setVisibility(4);
                    XpanelView.this.f54225w.setVisibility(4);
                }
            });
            this.f54215m.setDoingAnim(true);
            this.f54200U = true;
        }
    }

    /* renamed from: l */
    private boolean m40413l() {
        LinearLayout linearLayout = this.f54216n;
        if (linearLayout == null || linearLayout.getChildCount() <= 2 || this.f54216n.getChildAt(1) == null) {
            return true;
        }
        return false;
    }

    public void defaultState(boolean z) {
        LinearLayout linearLayout = this.f54216n;
        if (linearLayout != null && linearLayout.getChildAt(1) != null) {
            if (!this.f54222t) {
                this.f54199T.omegaShowTrack(true);
                this.f54222t = true;
            }
            int[] iArr = new int[2];
            this.f54216n.getChildAt(1).getLocationOnScreen(iArr);
            int i = iArr[1];
            this.f54215m.setCurrentStatus(2);
            this.f54215m.smoothScrollBy(0, -((XpUtils.getScreenHeight(this.f54210h) - i) - this.f54181A), this.f54192M ? 600 : 300);
            if (z) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(XpanelView.this.f54216n, "alpha", new float[]{0.0f, 1.0f});
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(XpanelView.this.f54225w, "alpha", new float[]{0.0f, 1.0f});
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
                        animatorSet.setDuration(300);
                        animatorSet.start();
                    }
                }, 250);
            }
            this.f54193N.doXpanelStatusHeight(2, this.f54181A + getMessageRealHeight());
            XpLog.m40353e(f54176a, "default: doXpanelStatusHeight: " + (this.f54181A + getMessageRealHeight()) + ", mLastDefaultShow: " + this.f54181A + ", msgHeight: " + getMessageRealHeight() + ", 250: " + XpUtils.dip2px(this.f54209g, 250.0f) + ", screen: " + XpUtils.getScreenHeight(this.f54210h));
            m40414m();
            this.f54208b.info("state默认态", new Object[0]);
        }
    }

    public void defaultState() {
        defaultState(false);
    }

    /* renamed from: m */
    private void m40414m() {
        int i;
        int i2;
        ObjectAnimator objectAnimator;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (!this.f54192M) {
            this.f54225w.setVisibility(0);
            this.f54216n.getChildAt(1).setVisibility(0);
            int i8 = 2;
            if (m40420p() != 0) {
                if (this.f54215m.getStatus() == 2) {
                    i2 = this.f54181A + getMessageRealHeight() + this.f54196Q;
                    i6 = (this.f54181A + getMessageRealHeight()) - XpUtils.dip2px(this.f54209g, 5.0f);
                    i7 = this.f54221s.getMeasuredHeight();
                } else {
                    i2 = this.mDownHeight + getMessageRealHeight() + this.f54196Q;
                    i6 = (this.mDownHeight + getMessageRealHeight()) - XpUtils.dip2px(this.f54209g, 5.0f);
                    i7 = this.f54221s.getMeasuredHeight();
                }
                i = i6 - i7;
            } else {
                if (this.f54215m.getStatus() == 2) {
                    int i9 = this.f54181A;
                    i3 = this.f54196Q + i9;
                    i5 = i9 - XpUtils.dip2px(this.f54209g, 5.0f);
                    i4 = this.f54221s.getMeasuredHeight();
                } else {
                    int i10 = this.mDownHeight;
                    i3 = this.f54196Q + i10;
                    i5 = i10 - XpUtils.dip2px(this.f54209g, 5.0f);
                    i4 = this.f54221s.getMeasuredHeight();
                }
                int i11 = i3;
                i = i5 - i4;
                i2 = i11;
            }
            float[] fArr = {(float) (-i)};
            String str = "translationY";
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f54221s, str, fArr);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(150);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f54190K, i2});
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.setDuration(100);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    XpanelView.this.f54219q.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (XpanelView.this.f54193N != null) {
                        XpanelView.this.f54193N.doXPanelHeightChange(((Integer) valueAnimator.getAnimatedValue()).intValue() - XpanelView.this.f54196Q);
                    }
                    XpanelView.this.f54219q.requestLayout();
                    XpanelView.this.f54220r.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue() - XpanelView.this.f54196Q;
                    XpanelView.this.f54220r.requestLayout();
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{this.f54215m.getWidth(), this.f54187H});
            ofInt2.setInterpolator(new DecelerateInterpolator());
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    XpanelView.this.f54219q.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    XpanelView.this.f54219q.requestLayout();
                }
            });
            ofInt2.setDuration(100);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    XpanelView.this.f54219q.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat2.setDuration(100);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f54225w, "alpha", new float[]{0.0f, 1.0f});
            ofFloat3.setDuration(200);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f54216n.getChildAt(1), "alpha", new float[]{0.0f, 1.0f});
            ofFloat4.setDuration(150);
            int measuredHeight = this.f54216n.getChildAt(1).getMeasuredHeight() + XpUtils.dip2px(this.f54209g, 10.0f);
            XpLog.m40350d("xpanel_downstate", "translationY: " + measuredHeight);
            ArrayList arrayList = new ArrayList();
            int i12 = 2;
            while (true) {
                objectAnimator = ofFloat;
                if (i12 >= this.f54216n.getChildCount()) {
                    break;
                }
                View childAt = this.f54216n.getChildAt(i12);
                float[] fArr2 = new float[i8];
                fArr2[0] = (float) (-measuredHeight);
                fArr2[1] = 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(childAt, str, fArr2).setDuration(300));
                i12++;
                str = str;
                ofFloat = objectAnimator;
                i8 = 2;
            }
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            if (Build.VERSION.SDK_INT >= 21) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f54216n.getChildAt(1), "translationZ", new float[]{0.0f, 60.0f});
                ofFloat5.setDuration(300);
                arrayList.add(ofFloat5);
            }
            arrayList.add(ofInt);
            arrayList.add(ofInt2);
            arrayList.add(ofFloat2);
            arrayList.add(objectAnimator);
            animatorSet.playTogether(arrayList);
            animatorSet.start();
            this.f54215m.setDoingAnim(true);
            this.f54200U = true;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    XpanelView.this.f54215m.setDoingAnim(false);
                    boolean unused = XpanelView.this.f54200U = false;
                    boolean unused2 = XpanelView.this.f54192M = true;
                    if (Build.VERSION.SDK_INT >= 21) {
                        XpanelView.this.f54216n.getChildAt(1).setTranslationZ(60.0f);
                    }
                }
            });
        }
    }

    public void bottomState() {
        LinearLayout linearLayout = this.f54216n;
        if (linearLayout != null && linearLayout.getChildAt(1) != null) {
            int[] iArr = new int[2];
            this.f54216n.getChildAt(1).getLocationOnScreen(iArr);
            int i = iArr[1];
            this.f54215m.setCurrentStatus(3);
            this.f54215m.smoothScrollBy(0, -((XpUtils.getScreenHeight(this.f54210h) - i) - this.mDownHeight), this.f54192M ? 600 : 250);
            this.f54193N.doXpanelStatusHeight(3, this.mDownHeight + getMessageRealHeight());
            m40414m();
            this.f54208b.info("state吸底态", new Object[0]);
        }
    }

    public IXpMessageContainer getMessageContainer() {
        return this.f54225w;
    }

    public void setTitle(String str) {
        this.f54194O = str;
        this.f54226x.setText(str);
    }

    public void refreshMsgHeight() {
        this.f54211i.post(new Runnable() {
            public void run() {
                XpanelView.this.m40417n();
                XpanelView.this.m40419o();
                XpanelView.this.m40409j();
                XpanelView.this.m40405h();
                XpanelView.this.f54193N.doXpanelStatusHeight(2, XpanelView.this.f54181A + XpanelView.this.getMessageRealHeight());
                XpanelView.this.f54193N.doXPanelHeightChange(XpanelView.this.getFirstCardHeight() + XpanelView.this.getMessageRealHeight());
                XpLog.m40353e("doXPanelHeightChange xpanelend", "refreshMsgHeight:  getFirstCardHeight: " + XpanelView.this.getFirstCardHeight() + " getMessageRealHeight: " + XpanelView.this.getMessageRealHeight());
            }
        });
    }

    public void setConfig(XpConfig xpConfig) {
        XpLog.m40350d("lxsConfig", "setConfig" + xpConfig.getDefaultDpSecondCardShowHeight());
        m40375a(xpConfig);
    }

    public void setOmegaConfig(XpOmegaConfig xpOmegaConfig) {
        m40376a(xpOmegaConfig);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m40417n() {
        if (this.f54225w.getVisibility() == 0 && !m40407i()) {
            this.f54225w.setTranslationY((float) (-(getFirstCardHeight() - (this.f54196Q * 2))));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m40419o() {
        if (this.f54215m.getLastStatus() != 1 && this.f54215m.getStatus() == 1) {
            return;
        }
        if (this.f54215m.getLastStatus() == 1 && this.f54215m.getStatus() != 1) {
            return;
        }
        if (m40420p() <= 0 || this.f54225w.getVisibility() != 0) {
            if (m40420p() <= 0 && !m40407i()) {
                this.f54221s.setTranslationY((float) (-((getFirstCardHeight() - XpUtils.dip2px(this.f54209g, 5.0f)) - this.f54221s.getMeasuredHeight())));
            }
        } else if (!m40407i()) {
            this.f54221s.setTranslationY((float) (-(((getFirstCardHeight() + getMessageRealHeight()) - XpUtils.dip2px(this.f54209g, 5.0f)) - this.f54221s.getMeasuredHeight())));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public int m40420p() {
        XpMessageLayout xpMessageLayout = this.f54225w;
        if (xpMessageLayout == null) {
            return 0;
        }
        return xpMessageLayout.getCurrentHeight();
    }

    public int getStatus() {
        return this.f54215m.getStatus();
    }

    public void onResume() {
        this.f54201V = false;
        if (this.f54202W.size() > 0) {
            m40380a(this.f54202W, false);
        }
    }

    public void onPause() {
        this.f54201V = true;
    }

    public void onVisibilityChanged(int i) {
        if (this.f54199T != null) {
            boolean z = i == 0;
            if (this.f54207ab != z) {
                if (i == 0) {
                    this.f54199T.setCurrentCardProperties(this.f54206aa);
                } else {
                    this.f54199T.removeCurrentCardProperties();
                }
                this.f54207ab = z;
                this.f54199T.omegaShowTrack(z);
            }
        }
    }
}
