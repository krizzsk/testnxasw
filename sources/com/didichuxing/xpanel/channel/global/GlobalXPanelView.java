package com.didichuxing.xpanel.channel.global;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.base.IState;
import com.didichuxing.xpanel.base.IStateChangeListener;
import com.didichuxing.xpanel.base.IXPanelViewPrivate;
import com.didichuxing.xpanel.base.XPanelBaseView;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.channel.global.impl.IGlobalXPanelView;
import com.didichuxing.xpanel.channel.global.impl.IXPanelCallBack;
import com.didichuxing.xpanel.channel.global.impl.IXPanelMeasureHelper;
import com.didichuxing.xpanel.channel.global.impl.IXPanelSpaceInterceptor;
import com.didichuxing.xpanel.channel.global.widget.BezierInterpolator;
import com.didichuxing.xpanel.channel.global.widget.XPanelBottomView;
import com.didichuxing.xpanel.channel.global.widget.XPanelHeaderBarView;
import com.didichuxing.xpanel.channel.global.widget.XPanelHeardBarTopView;
import com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView;
import com.didichuxing.xpanel.channel.global.widget.XPanelSpaceView;
import com.didichuxing.xpanel.message.IMessageDataListener;
import com.didichuxing.xpanel.message.IXPanelMessageContainer;
import com.didichuxing.xpanel.message.XPanelMessageLayout;
import com.didichuxing.xpanel.models.AbsXPanelAgentModelView;
import com.didichuxing.xpanel.models.IXPanelModel;
import com.didichuxing.xpanel.models.IXPanelModelView;
import com.didichuxing.xpanel.models.ModelsFactory;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.util.Utils;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalXPanelView extends XPanelBaseView<XPanelRecyclerView, XPanelLayoutManager> implements IXPanelViewPrivate, IGlobalXPanelView, IMessageDataListener {
    public static int STYLE_DEFAULT_HALF_HEIGHT = 1002;
    public static int STYLE_DEFAULT_SHOW_HEIGHT = 1001;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public static int f51904X = 0;

    /* renamed from: b */
    private static final float f51905b = 0.6f;

    /* renamed from: A */
    private View f51906A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public ArrayList<XPanelCardData> f51907B = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: C */
    public XPanelRecyclerAdapter f51908C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f51909D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f51910E = false;
    @Deprecated

    /* renamed from: F */
    private XPanelHeaderBarView f51911F = null;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public XPanelMessageLayout f51912G = null;

    /* renamed from: H */
    private int f51913H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public ViewGroup f51914I;

    /* renamed from: J */
    private View f51915J;

    /* renamed from: K */
    private View f51916K;

    /* renamed from: L */
    private XPanelHeardBarTopView f51917L = null;
    @Deprecated

    /* renamed from: M */
    private TextView f51918M;

    /* renamed from: N */
    private IXPanelSpaceInterceptor f51919N;

    /* renamed from: O */
    private long f51920O = -1;

    /* renamed from: P */
    private int f51921P;

    /* renamed from: Q */
    private boolean f51922Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public boolean f51923R = true;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public boolean f51924S = false;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public int f51925T = 0;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public int f51926U = 0;

    /* renamed from: V */
    private int f51927V = 0;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public int f51928W;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public float f51929Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public float f51930Z = 3.0f;

    /* renamed from: a */
    private final String f51931a = "GlobalXPanelView";
    /* access modifiers changed from: private */

    /* renamed from: aa */
    public XPanelSpaceView f51932aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public XPanelCardData f51933ab;
    /* access modifiers changed from: private */

    /* renamed from: ac */
    public XPanelBottomView f51934ac;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public XPanelCardData f51935ad;

    /* renamed from: ae */
    private boolean f51936ae = true;
    /* access modifiers changed from: private */

    /* renamed from: af */
    public boolean f51937af = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IXPanelCallBack f51938c;
    public boolean changeDefaultHeight = false;

    /* renamed from: d */
    private boolean f51939d = false;
    public boolean defaultShowBottomShader = false;

    /* renamed from: e */
    private int f51940e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f51941f = true;

    /* renamed from: g */
    private boolean f51942g = false;

    /* renamed from: h */
    private boolean f51943h = false;

    /* renamed from: i */
    private int f51944i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public IXPanelAgentClickListener f51945j;

    /* renamed from: k */
    private Interpolator f51946k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f51947l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f51948m;
    protected int mDefaultSecondHeight;
    protected int mDownHeight;
    protected int mScreenHeight;
    protected int mTopOffset;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f51949n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f51950o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Bitmap f51951p;

    /* renamed from: q */
    private RotateBitmapDrawable f51952q;

    /* renamed from: r */
    private int f51953r = 0;

    /* renamed from: s */
    private float f51954s;

    /* renamed from: t */
    private float f51955t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f51956u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f51957v = 0;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f51958w = 0;

    /* renamed from: x */
    private FrameLayout f51959x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public Drawable f51960y;

    /* renamed from: z */
    private View f51961z;

    public void changeXPanelShowHeight(boolean z) {
    }

    public void disableXPanelDownBtn() {
    }

    public void enableXPanelDownBtn() {
    }

    public ViewGroup getHandleView() {
        return null;
    }

    public void hideMessageTip() {
    }

    public void notifyRemove() {
    }

    public void setXPanelShadowBg(Drawable drawable) {
    }

    public void showMessageTip(String str) {
    }

    public GlobalXPanelView(Context context) {
        super(context);
    }

    public static class XPanelConfig {
        static int STYLE_PERCENT_HEIGHT = 2;
        public static final int style = 2;
        public float cardRoundedCorner = 3.0f;
        public boolean changeDownStatusHeight = false;
        public boolean default_show_bottom_shader = false;
        public int default_show_height = 0;
        public int divider_color;
        public int divider_height = 1;
        public boolean enable_divider = true;
        public boolean enable_min_height = true;
        /* access modifiers changed from: private */
        @Deprecated
        public boolean enable_top_bar = false;
        public float max_show_height = 0.5f;
        public float move_show_bg_length = 0.0f;
        public int second_default_height = Integer.MIN_VALUE;
        public boolean style_state = false;
        public boolean support_scroll = true;

        private XPanelConfig() {
        }

        public static XPanelConfig getDefault() {
            XPanelConfig createPercentConfig = createPercentConfig();
            createPercentConfig.max_show_height = 0.5f;
            createPercentConfig.move_show_bg_length = 0.5f;
            return createPercentConfig;
        }

        public static XPanelConfig createPercentConfig() {
            XPanelConfig xPanelConfig = new XPanelConfig();
            xPanelConfig.enable_top_bar = false;
            xPanelConfig.enable_divider = true;
            return xPanelConfig;
        }
    }

    public void init(XPanelConfig xPanelConfig, View view) {
        if (!this.f51939d) {
            this.f51939d = true;
            if (xPanelConfig == null) {
                xPanelConfig = XPanelConfig.getDefault();
            }
            m39049a(xPanelConfig, view);
        }
    }

    /* renamed from: a */
    private void m39049a(XPanelConfig xPanelConfig, View view) {
        if (xPanelConfig == null) {
            xPanelConfig = XPanelConfig.getDefault();
        }
        LogcatUtil.m39239i("GlobalXPanelView", "start initConfig with config:" + xPanelConfig.hashCode());
        this.f51946k = new BezierInterpolator(0.07f, 0.14f, 0.13f, 1.0f);
        f51904X = Utils.dip2px(this.mContext, 30.0f);
        this.f51940e = (int) TypedValue.applyDimension(1, 40.0f, this.mContext.getResources().getDisplayMetrics());
        this.f51921P = XPanelConfig.style;
        this.f51941f = xPanelConfig.support_scroll;
        this.defaultShowBottomShader = xPanelConfig.default_show_bottom_shader;
        this.changeDefaultHeight = xPanelConfig.changeDownStatusHeight;
        if (xPanelConfig.second_default_height != Integer.MIN_VALUE) {
            this.mDefaultSecondHeight = xPanelConfig.second_default_height;
        } else {
            this.mDefaultSecondHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_default_second_height);
        }
        if (this.f51921P == XPanelConfig.STYLE_PERCENT_HEIGHT) {
            this.f51955t = xPanelConfig.move_show_bg_length;
            this.f51954s = xPanelConfig.max_show_height;
            if (xPanelConfig.enable_top_bar) {
                this.f51922Q = true;
                XPanelHeaderBarView xPanelHeaderBarView = new XPanelHeaderBarView(this.mContext);
                this.f51911F = xPanelHeaderBarView;
                xPanelHeaderBarView.setBarOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        ((XPanelLayoutManager) GlobalXPanelView.this.mLayoutManager).scrollToPosition(0);
                    }
                });
                XPanelHeardBarTopView xPanelHeardBarTopView = new XPanelHeardBarTopView(this.mContext);
                this.f51917L = xPanelHeardBarTopView;
                this.f51911F.bindXPanelHeardBarTopView(xPanelHeardBarTopView);
            }
            this.f51923R = true;
            this.f51958w = xPanelConfig.default_show_height;
            if (!xPanelConfig.enable_min_height || !this.f51941f) {
                this.f51910E = false;
            } else {
                this.f51910E = true;
                this.mDownHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_down_height);
            }
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.oc_x_panel_view, (ViewGroup) null);
            }
            this.f51959x = (FrameLayout) view;
            if (Build.VERSION.SDK_INT < 23) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.f51959x.setTouchscreenBlocksFocus(false);
                }
                this.f51959x.setFocusable(true);
                this.f51959x.setFocusableInTouchMode(true);
                this.f51959x.requestFocus();
            }
            ColorDrawable colorDrawable = new ColorDrawable(-1);
            this.f51960y = colorDrawable;
            colorDrawable.setAlpha(0);
            this.f51959x.setBackground(this.f51960y);
            this.f51914I = (ViewGroup) this.f51959x.findViewById(R.id.oc_x_panel_navi_layout);
            this.f51915J = this.f51959x.findViewById(R.id.oc_x_panel_navi_icon);
            this.f51916K = this.f51959x.findViewById(R.id.oc_x_panel_navi_shadow);
            this.f51914I.setVisibility(8);
            this.f51916K.setVisibility(8);
            this.f51914I.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalXPanelView.this.m39076c();
                }
            });
            this.f51914I.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        float unused = GlobalXPanelView.this.f51929Y = motionEvent.getY();
                        return false;
                    } else if (action != 1) {
                        return false;
                    } else {
                        float y = motionEvent.getY() - GlobalXPanelView.this.f51929Y;
                        if (y <= 0.0f || y < ((float) Utils.dip2px(GlobalXPanelView.this.mContext, 10.0f))) {
                            return false;
                        }
                        GlobalXPanelView.this.m39076c();
                        return true;
                    }
                }
            });
            TextView textView = (TextView) this.f51959x.findViewById(R.id.oc_x_panel_tip);
            this.f51918M = textView;
            textView.setVisibility(8);
            this.f51961z = this.f51959x.findViewById(R.id.oc_x_panel_down);
            this.mCardRecyclerView = (XPanelRecyclerView) this.f51959x.findViewById(R.id.oc_x_panel_list);
            ((XPanelRecyclerView) this.mCardRecyclerView).setOverScrollMode(0);
            ((XPanelRecyclerView) this.mCardRecyclerView).setFlingListener(new XPanelRecyclerView.IFlingListener() {
                public boolean onFling() {
                    return GlobalXPanelView.this.m39052a(false);
                }
            });
            this.f51932aa = new XPanelSpaceView(this.mContext);
            this.f51961z.setVisibility(8);
            XPanelCardData build = new XPanelCardData.Builder().view(this.f51932aa, false).build();
            this.f51933ab = build;
            this.f51907B.add(build);
            this.mLayoutManager = new XPanelLayoutManager(this.mContext);
            this.f51932aa.setXPanelMeasureHelper((IXPanelMeasureHelper) this.mLayoutManager);
            ((XPanelRecyclerView) this.mCardRecyclerView).setLayoutManager(this.mLayoutManager);
            this.f51908C = new XPanelRecyclerAdapter();
            ((XPanelRecyclerView) this.mCardRecyclerView).setAdapter(this.f51908C);
            ((XPanelRecyclerView) this.mCardRecyclerView).bindHandView(this.f51932aa);
            ((XPanelRecyclerView) this.mCardRecyclerView).setBottomSpace(this.mDownHeight);
            XPanelBottomView xPanelBottomView = new XPanelBottomView(this.mContext);
            this.f51934ac = xPanelBottomView;
            xPanelBottomView.bindInterface((XPanelBottomView.BottomCaculate) this.mLayoutManager);
            XPanelCardData build2 = new XPanelCardData.Builder().mo128018id("xpanel_bottom").view(this.f51934ac, false).build();
            this.f51935ad = build2;
            this.f51907B.add(build2);
            if (this.f51941f) {
                ((XPanelRecyclerView) this.mCardRecyclerView).addOnScrollListener(new XPanelOnScrollListener());
            }
            int statusBarHeight = Utils.getStatusBarHeight(this.mContext);
            this.f51913H = statusBarHeight;
            setTopOffset(statusBarHeight);
            XPanelMessageLayout xPanelMessageLayout = new XPanelMessageLayout(this.mContext);
            this.f51912G = xPanelMessageLayout;
            xPanelMessageLayout.setMessageDataListener(this);
            if (this.f51941f) {
                this.f51912G.setOnClickListener(new PullUpClickListener());
            }
            this.f51912G.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            this.f51959x.addView(this.f51912G, 1, layoutParams);
            if (xPanelConfig.enable_divider) {
                m39072b(this.mContext.getResources().getDimensionPixelSize(R.dimen._10dip));
            }
            registerState((IState) this.mCardRecyclerView);
            this.f51908C.notifyList((List<XPanelCardData>) null, this.f51907B);
            this.f51908C.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                public void onChanged() {
                    super.onChanged();
                    GlobalXPanelView.this.mo128056a();
                }
            });
            this.f51930Z = xPanelConfig.cardRoundedCorner;
            return;
        }
        throw new RuntimeException("error param: XPane—lConfig param is not legal:mStyle= " + this.f51921P);
    }

    private class XPanelOnScrollListener extends RecyclerView.OnScrollListener {
        private XPanelOnScrollListener() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, newState=" + i);
            if (i == 0) {
                boolean unused = GlobalXPanelView.this.m39052a(true);
                if (GlobalXPanelView.this.f51960y.getAlpha() > 0 && ((XPanelRecyclerView) GlobalXPanelView.this.mCardRecyclerView).getStatus() != 1 && GlobalXPanelView.this.f51914I.getVisibility() == 8) {
                    GlobalXPanelView.this.f51960y.setAlpha(0);
                }
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            GlobalXPanelView.this.m39082d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m39052a(boolean z) {
        boolean z2 = true;
        View findViewByPosition = ((XPanelLayoutManager) this.mLayoutManager).findViewByPosition(1);
        LogcatUtil.m39239i("GlobalXPanelView", "@doScroll, start, needCheckState=" + z + ", mCardRecyclerView.getState()=" + ((XPanelRecyclerView) this.mCardRecyclerView).getState());
        if (Utils.isDebug(this.mContext)) {
            LogcatUtil.m39239i("GlobalXPanelView", "mSpaceView.getParent(): " + this.f51932aa.getParent());
        }
        if (findViewByPosition == null) {
            return false;
        }
        if (z && ((XPanelRecyclerView) this.mCardRecyclerView).getState() == 1) {
            return false;
        }
        int top = findViewByPosition.getTop() + this.f51947l;
        int i = this.f51944i;
        int status = ((XPanelRecyclerView) this.mCardRecyclerView).getStatus();
        if (((XPanelRecyclerView) this.mCardRecyclerView).getDirection() < 0.0f) {
            LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 上拉，top=" + top);
            if (top >= 0 && (top < this.f51928W || i - this.f51926U >= f51904X)) {
                ((XPanelRecyclerView) this.mCardRecyclerView).setCurrentStatus(1);
                LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 上拉，吸顶态");
                ((XPanelRecyclerView) this.mCardRecyclerView).smoothScrollBy(0, top - 0);
                LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 新状态=" + ((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                this.f51938c.doXPanelScrollStatusChange(((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                return z2;
            } else if (top >= this.f51928W && top < this.mScreenHeight - this.mDownHeight) {
                ((XPanelRecyclerView) this.mCardRecyclerView).setCurrentStatus(2);
                LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 上拉，默认态");
                ((XPanelRecyclerView) this.mCardRecyclerView).smoothScrollBy(0, this.f51926U - i);
                LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 新状态=" + ((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                this.f51938c.doXPanelScrollStatusChange(((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                return z2;
            } else if (top >= this.mScreenHeight - this.f51926U) {
                ((XPanelRecyclerView) this.mCardRecyclerView).setCurrentStatus(3);
                LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 上拉，回缩态");
                if (!(((XPanelRecyclerView) this.mCardRecyclerView).getStatus() == status || this.f51938c == null)) {
                    LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 新状态=" + ((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                    this.f51938c.doXPanelScrollStatusChange(((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                }
                return z2;
            }
        } else if (((XPanelRecyclerView) this.mCardRecyclerView).getDirection() > 0.0f) {
            LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 下拉，top=" + top);
            if (top > 0 && top < f51904X) {
                ((XPanelRecyclerView) this.mCardRecyclerView).setCurrentStatus(1);
                LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 下拉，吸顶态");
                ((XPanelRecyclerView) this.mCardRecyclerView).smoothScrollBy(0, top - 0);
                LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 新状态=" + ((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                this.f51938c.doXPanelScrollStatusChange(((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                return z2;
            } else if (top < f51904X || top > this.mScreenHeight - this.f51926U) {
                int i2 = this.mScreenHeight;
                if (top <= i2 - this.f51926U || top >= i2 - this.mDownHeight) {
                    ((XPanelRecyclerView) this.mCardRecyclerView).setCurrentStatus(3);
                    ((XPanelRecyclerView) this.mCardRecyclerView).smoothScrollBy(0, -(i - this.mDownHeight), this.f51946k);
                } else {
                    ((XPanelRecyclerView) this.mCardRecyclerView).setCurrentStatus(3);
                    LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 下拉，回缩态");
                    ((XPanelRecyclerView) this.mCardRecyclerView).smoothScrollBy(0, -(i - this.mDownHeight), this.f51946k);
                }
                LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 新状态=" + ((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                this.f51938c.doXPanelScrollStatusChange(((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                return z2;
            } else {
                ((XPanelRecyclerView) this.mCardRecyclerView).setCurrentStatus(2);
                LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 下拉，默认态");
                ((XPanelRecyclerView) this.mCardRecyclerView).smoothScrollBy(0, -(i - this.f51926U));
                LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 新状态=" + ((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                this.f51938c.doXPanelScrollStatusChange(((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
                return z2;
            }
        }
        z2 = false;
        LogcatUtil.m39237d("GlobalXPanelView", "@onScrollStateChanged, 新状态=" + ((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
        this.f51938c.doXPanelScrollStatusChange(((XPanelRecyclerView) this.mCardRecyclerView).getStatus());
        return z2;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m39076c() {
        ((XPanelRecyclerView) this.mCardRecyclerView).smoothScrollToPosition(0);
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                ((XPanelRecyclerView) GlobalXPanelView.this.mCardRecyclerView).smoothScrollBy(0, GlobalXPanelView.this.f51926U - GlobalXPanelView.this.m39093h());
                ((XPanelRecyclerView) GlobalXPanelView.this.mCardRecyclerView).setCurrentStatus(2);
                if (GlobalXPanelView.this.f51938c != null) {
                    GlobalXPanelView.this.f51938c.doXPanelScrollStatusChange(2);
                }
            }
        }, 100);
    }

    /* renamed from: b */
    private void m39072b(int i) {
        this.f51947l = this.mContext.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_shader_top);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.oc_x_panel_shader_bottom);
        this.f51948m = dimensionPixelSize;
        this.f51909D = (i - this.f51947l) - dimensionPixelSize;
        ((XPanelRecyclerView) this.mCardRecyclerView).addItemDecoration(new OwnItemDecoration(this.f51909D));
        ((XPanelRecyclerView) this.mCardRecyclerView).setDecoration(this.f51909D);
        ((XPanelRecyclerView) this.mCardRecyclerView).setCardShaderTop(this.f51947l);
    }

    private class OwnItemDecoration extends RecyclerView.ItemDecoration {
        private int mPadding;

        public OwnItemDecoration(int i) {
            this.mPadding = i;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = ((XPanelRecyclerView) GlobalXPanelView.this.mCardRecyclerView).getChildAdapterPosition(view);
            if (childAdapterPosition != 0 && childAdapterPosition != GlobalXPanelView.this.f51908C.getItemCount() - 1) {
                rect.set(0, 0, 0, this.mPadding);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m39077c(int i) {
        return (i == -1 || i == 0 || i == this.f51908C.getItemCount() - 1 || i == this.f51908C.getItemCount() + -2) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m39082d() {
        int findLastVisibleItemPosition;
        boolean z = ((XPanelRecyclerView) this.mCardRecyclerView).getDirection() < 0.0f;
        if (z != this.f51942g) {
            if (z && (findLastVisibleItemPosition = ((XPanelLayoutManager) this.mLayoutManager).findLastVisibleItemPosition()) != -1 && findLastVisibleItemPosition < this.f51907B.size()) {
                Map<String, Object> a = m39046a(this.f51907B.get(findLastVisibleItemPosition));
                a.put("pull_type", 2);
                XPanelOmegaUtils.trackEvent("xpanel_pull_up", a);
            }
            this.f51942g = z;
        }
        this.f51944i = m39093h();
        m39100k();
        m39098j();
        IXPanelCallBack iXPanelCallBack = this.f51938c;
        if (iXPanelCallBack != null) {
            iXPanelCallBack.doXPanelMoveChange(m39090g());
        }
        m39086e();
        if (z) {
            m39104m();
        } else {
            m39106n();
        }
        m39102l();
    }

    /* renamed from: e */
    private void m39086e() {
        if (this.f51941f) {
            int i = this.f51926U;
            int i2 = this.f51944i;
            if (i2 <= i) {
                LogcatUtil.m39237d("GlobalXPanelView", "@doScrollAnimation, alpha=0");
                this.f51960y.setAlpha(0);
                this.f51914I.setVisibility(8);
                this.f51916K.setVisibility(8);
                return;
            }
            int i3 = this.f51949n;
            if (i2 <= i3) {
                int i4 = i2 - i;
                int i5 = i3 - i;
                float min = Math.min(Math.max(((float) i4) / ((float) i5), 0.25f), 1.0f);
                LogcatUtil.m39237d("GlobalXPanelView", "@doScrollAnimation, top=" + i4 + ", canMove=" + i5 + ", alpha=" + min);
                this.f51960y.setAlpha((int) (min * 255.0f));
                this.f51914I.setVisibility(8);
                this.f51916K.setVisibility(8);
            } else if (i2 > i3) {
                this.f51960y.setAlpha(255);
                int i6 = this.f51944i;
                int i7 = this.f51949n;
                m39047a(i6 - i7, this.f51956u - i7);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public int m39087f() {
        XPanelMessageLayout xPanelMessageLayout = this.f51912G;
        if (xPanelMessageLayout == null) {
            return 0;
        }
        return xPanelMessageLayout.getCurrentHeight();
    }

    /* renamed from: g */
    private int m39090g() {
        if (isListEmpty()) {
            return 0;
        }
        return (this.f51944i - this.f51947l) + m39087f();
    }

    /* renamed from: a */
    private void m39047a(int i, int i2) {
        if (i2 > 0 && this.f51941f) {
            float min = Math.min(Math.max(((float) i) / ((float) i2), 0.0f), 1.0f);
            LogcatUtil.m39237d("GlobalXPanelView", "@checkNavigationAlpha, top=" + i + ", canMove=" + i2 + ", alpha=" + min);
            this.f51914I.setAlpha(min);
            this.f51916K.setAlpha(min);
            if (min == 0.0f) {
                this.f51914I.setVisibility(8);
                this.f51916K.setVisibility(8);
                return;
            }
            this.f51914I.setVisibility(0);
            this.f51916K.setVisibility(0);
            if (Build.VERSION.SDK_INT < 23) {
                if (this.f51951p == null) {
                    this.f51951p = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.oc_x_panel_navi_arrow);
                    RotateBitmapDrawable rotateBitmapDrawable = new RotateBitmapDrawable(this.mContext.getResources(), this.f51951p);
                    this.f51952q = rotateBitmapDrawable;
                    this.f51915J.setBackground(rotateBitmapDrawable);
                }
                this.f51952q.updateRotate(min * -90.0f);
                return;
            }
            this.f51915J.setRotation(min * -90.0f);
        }
    }

    private class RotateBitmapDrawable extends BitmapDrawable {
        private float angle;

        public RotateBitmapDrawable(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        /* access modifiers changed from: package-private */
        public void updateRotate(float f) {
            this.angle = f;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            canvas.save();
            canvas.rotate(this.angle, (float) (GlobalXPanelView.this.f51951p.getWidth() / 2), (float) (GlobalXPanelView.this.f51951p.getHeight() / 2));
            super.draw(canvas);
            canvas.restore();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public int m39093h() {
        return this.f51932aa.getParent() == null ? this.f51956u : this.f51956u - this.f51932aa.getBottom();
    }

    /* renamed from: i */
    private int m39095i() {
        if (this.f51932aa.getParent() == null) {
            return this.f51956u;
        }
        return (this.f51956u - this.f51932aa.getBottom()) - this.f51947l;
    }

    /* access modifiers changed from: protected */
    public void moveOutCard(XPanelCardData xPanelCardData) {
        if (xPanelCardData != null) {
            xPanelCardData.moveOut((Map<String, Object>) null);
        }
    }

    /* access modifiers changed from: protected */
    public void halfMoveOutCard(XPanelCardData xPanelCardData) {
        if (xPanelCardData != null) {
            xPanelCardData.moveHalfOut((Map<String, Object>) null);
        }
    }

    /* access modifiers changed from: protected */
    public void allMoveOutCard(XPanelCardData xPanelCardData) {
        if (xPanelCardData != null) {
            xPanelCardData.moveAllOut((Map<String, Object>) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[Catch:{ Exception -> 0x00ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c A[Catch:{ Exception -> 0x00ab }] */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m39098j() {
        /*
            r12 = this;
            boolean r0 = r12.f51943h
            r1 = 1
            if (r0 != 0) goto L_0x0026
            java.util.ArrayList<com.didichuxing.xpanel.base.XPanelCardData> r0 = r12.f51907B
            java.lang.Object r0 = r0.clone()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L_0x000d:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x0025
            java.lang.Object r2 = r0.get(r1)
            com.didichuxing.xpanel.base.XPanelCardData r2 = (com.didichuxing.xpanel.base.XPanelCardData) r2
            r12.moveOutCard(r2)
            r12.halfMoveOutCard(r2)
            r12.allMoveOutCard(r2)
            int r1 = r1 + 1
            goto L_0x000d
        L_0x0025:
            return
        L_0x0026:
            androidx.recyclerview.widget.LinearLayoutManager r0 = r12.mLayoutManager
            com.didichuxing.xpanel.channel.global.GlobalXPanelView$XPanelLayoutManager r0 = (com.didichuxing.xpanel.channel.global.GlobalXPanelView.XPanelLayoutManager) r0
            int r0 = r0.findFirstVisibleItemPosition()
            androidx.recyclerview.widget.LinearLayoutManager r2 = r12.mLayoutManager
            com.didichuxing.xpanel.channel.global.GlobalXPanelView$XPanelLayoutManager r2 = (com.didichuxing.xpanel.channel.global.GlobalXPanelView.XPanelLayoutManager) r2
            int r2 = r2.findLastVisibleItemPosition()
            r3 = -1
            if (r0 == r3) goto L_0x00af
            if (r2 == r3) goto L_0x00af
            com.didichuxing.xpanel.base.BorderRecyclerView r3 = r12.mCardRecyclerView     // Catch:{ Exception -> 0x00ab }
            com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView r3 = (com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView) r3     // Catch:{ Exception -> 0x00ab }
            int r3 = r3.getMeasuredHeight()     // Catch:{ Exception -> 0x00ab }
            java.util.ArrayList<com.didichuxing.xpanel.base.XPanelCardData> r4 = r12.f51907B     // Catch:{ Exception -> 0x00ab }
            java.lang.Object r4 = r4.clone()     // Catch:{ Exception -> 0x00ab }
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ Exception -> 0x00ab }
            int r5 = r4.size()     // Catch:{ Exception -> 0x00ab }
            r6 = 1
        L_0x0050:
            int r7 = r5 + -1
            if (r6 >= r7) goto L_0x00af
            java.lang.Object r7 = r4.get(r6)     // Catch:{ Exception -> 0x00ab }
            com.didichuxing.xpanel.base.XPanelCardData r7 = (com.didichuxing.xpanel.base.XPanelCardData) r7     // Catch:{ Exception -> 0x00ab }
            if (r6 < r0) goto L_0x00a8
            if (r6 > r2) goto L_0x00a8
            androidx.recyclerview.widget.LinearLayoutManager r8 = r12.mLayoutManager     // Catch:{ Exception -> 0x00ab }
            com.didichuxing.xpanel.channel.global.GlobalXPanelView$XPanelLayoutManager r8 = (com.didichuxing.xpanel.channel.global.GlobalXPanelView.XPanelLayoutManager) r8     // Catch:{ Exception -> 0x00ab }
            int r9 = r6 - r0
            android.view.View r8 = r8.getChildAt(r9)     // Catch:{ Exception -> 0x00ab }
            int r9 = r8.getTop()     // Catch:{ Exception -> 0x00ab }
            int r9 = r3 - r9
            int r10 = r8.getBottom()     // Catch:{ Exception -> 0x00ab }
            int r10 = r3 - r10
            if (r10 >= 0) goto L_0x007f
            int r10 = r12.f51940e     // Catch:{ Exception -> 0x00ab }
            if (r9 < r10) goto L_0x007b
            goto L_0x007f
        L_0x007b:
            r12.moveOutCard(r7)     // Catch:{ Exception -> 0x00ab }
            goto L_0x0082
        L_0x007f:
            r7.moveIn()     // Catch:{ Exception -> 0x00ab }
        L_0x0082:
            r12.checkCardAllShow(r7, r9, r8)     // Catch:{ Exception -> 0x00ab }
            int r10 = r8.getMeasuredHeight()     // Catch:{ Exception -> 0x00ab }
            int r10 = r10 / 2
            boolean r11 = r12.f51942g     // Catch:{ Exception -> 0x00ab }
            if (r11 == 0) goto L_0x009c
            int r9 = r9 - r10
            if (r9 > 0) goto L_0x00a8
            int r8 = r8.getTop()     // Catch:{ Exception -> 0x00ab }
            if (r8 < 0) goto L_0x00a8
            r7.moveHalfIn()     // Catch:{ Exception -> 0x00ab }
            goto L_0x00a8
        L_0x009c:
            int r9 = r9 - r10
            if (r9 < 0) goto L_0x00a8
            int r8 = r8.getTop()     // Catch:{ Exception -> 0x00ab }
            if (r8 < 0) goto L_0x00a8
            r12.halfMoveOutCard(r7)     // Catch:{ Exception -> 0x00ab }
        L_0x00a8:
            int r6 = r6 + 1
            goto L_0x0050
        L_0x00ab:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.channel.global.GlobalXPanelView.m39098j():void");
    }

    /* access modifiers changed from: protected */
    public void checkCardAllShow(XPanelCardData xPanelCardData, int i, View view) {
        if (i < view.getMeasuredHeight() || (-view.getTop()) > 0) {
            allMoveOutCard(xPanelCardData);
        } else {
            allMoveInCard(xPanelCardData);
        }
    }

    /* access modifiers changed from: protected */
    public void allMoveInCard(XPanelCardData xPanelCardData) {
        if (xPanelCardData != null) {
            xPanelCardData.moveAllIn((Map<String, Object>) null);
        }
    }

    /* renamed from: a */
    private Map<String, Object> m39046a(XPanelCardData xPanelCardData) {
        if (xPanelCardData != null) {
            return xPanelCardData.getOmegaParams((Map<String, Object>) null);
        }
        return new HashMap();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m39100k() {
        if (this.f51906A != null) {
            int i = this.f51932aa.getParent() == null ? this.f51956u : this.f51944i - this.f51947l;
            int i2 = i < this.f51956u ? 1 : 2;
            if (this.f51953r != i2) {
                this.f51953r = i2;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f51906A.getLayoutParams();
                int dimensionPixelSize = (!this.f51941f || i2 != 1) ? 0 : this.mContext.getResources().getDimensionPixelSize(R.dimen._10dip);
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
                this.f51906A.setLayoutParams(layoutParams);
            }
            this.f51906A.setTranslationY((float) (-i));
            this.f51906A.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m39102l() {
        IXPanelCallBack iXPanelCallBack;
        if (m39087f() > 0 && this.f51912G.getVisibility() == 0) {
            int i = this.f51944i;
            int i2 = i - this.f51947l;
            int i3 = this.f51949n;
            if (i < i3) {
                this.f51912G.setAlpha(1.0f);
                this.f51912G.setTranslationY((float) (-i2));
                if (this.f51927V != i2 && (iXPanelCallBack = this.f51938c) != null) {
                    this.f51927V = i2;
                    iXPanelCallBack.doXPanelMoveChange(m39090g());
                    return;
                }
                return;
            }
            this.f51912G.setAlpha(1.0f - Math.min(Math.max((float) (((i - i3) + 80) / 100), 0.0f), 1.0f));
        }
    }

    /* renamed from: m */
    private void m39104m() {
        this.f51920O = System.currentTimeMillis();
        IXPanelCallBack iXPanelCallBack = this.f51938c;
        if (iXPanelCallBack != null) {
            iXPanelCallBack.doXPanelPullStateChange(true);
        }
        this.f51936ae = true;
        ((XPanelRecyclerView) this.mCardRecyclerView).setKeepState(true);
    }

    /* renamed from: n */
    private void m39106n() {
        m39112q();
        IXPanelCallBack iXPanelCallBack = this.f51938c;
        if (iXPanelCallBack != null) {
            iXPanelCallBack.doXPanelPullStateChange(false);
        }
        ((XPanelRecyclerView) this.mCardRecyclerView).setKeepState(false);
        this.f51936ae = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public int m39107o() {
        return (int) (this.f51954s * ((float) Utils.getScreenHeight(this.mContext)));
    }

    public void resetPosition() {
        ((XPanelRecyclerView) this.mCardRecyclerView).smoothScrollBy(0, -(this.mScreenHeight - this.f51926U));
    }

    public void moveToResetPosition() {
        if (this.mCardRecyclerView != null) {
            ((XPanelRecyclerView) this.mCardRecyclerView).smoothScrollBy(0, -(this.mScreenHeight - this.mDownHeight));
        }
    }

    public View getView() {
        return this.f51959x;
    }

    public void bindAgentClickListener(IXPanelAgentClickListener iXPanelAgentClickListener) {
        this.f51945j = iXPanelAgentClickListener;
    }

    public void notifyAll(final List<XPanelCardData> list, final boolean z) {
        this.mHandler.post(new Runnable() {
            public void run() {
                Activity activity;
                if (!(GlobalXPanelView.this.mContext instanceof Activity) || ((activity = (Activity) GlobalXPanelView.this.mContext) != null && !activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()))) {
                    List list = (List) GlobalXPanelView.this.f51907B.clone();
                    GlobalXPanelView.this.f51907B.clear();
                    list.remove(0);
                    List list2 = list;
                    if (list2 != null && list2.size() >= 0) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            XPanelCardData xPanelCardData = (XPanelCardData) list.get(size);
                            if (list.contains(xPanelCardData)) {
                                list.remove(xPanelCardData);
                            }
                        }
                        GlobalXPanelView.this.f51907B.addAll(list);
                    }
                    GlobalXPanelView.this.f51907B.add(0, GlobalXPanelView.this.f51933ab);
                    GlobalXPanelView.this.f51907B.add(GlobalXPanelView.this.f51935ad);
                    boolean unused = GlobalXPanelView.this.f51937af = true;
                    GlobalXPanelView.this.f51908C.notifyList(list, GlobalXPanelView.this.f51907B);
                    boolean unused2 = GlobalXPanelView.this.mAppend = z;
                    return;
                }
                LogcatUtil.m39237d("GlobalXPanelView", "ACTIVITY has destroyed");
            }
        });
    }

    public void setXPanelShadowBg(int i) {
        this.f51959x.setBackgroundColor(i);
    }

    public void setXPanelCallBack(IXPanelCallBack iXPanelCallBack) {
        this.f51938c = iXPanelCallBack;
    }

    public boolean isListEmpty() {
        return this.f51908C.getItemCount() <= 2;
    }

    public XPanelHeaderBarView getHeaderBarView() {
        return this.f51911F;
    }

    public IXPanelMessageContainer getMessageContainer() {
        return this.f51912G;
    }

    public void destroy() {
        LogcatUtil.m39239i("GlobalXPanelView", "destroy....");
        unRegisterState((IState) this.mCardRecyclerView);
    }

    public void addStateChangeListener(IStateChangeListener iStateChangeListener) {
        setStateListener(iStateChangeListener);
    }

    public void scrollLength(int i) {
        if (((XPanelRecyclerView) this.mCardRecyclerView).getScrollState() == 0 && ((XPanelRecyclerView) this.mCardRecyclerView).getStatus() == 2) {
            ((XPanelRecyclerView) this.mCardRecyclerView).smoothScrollBy(0, i, new DecelerateInterpolator());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        ((com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView) r3.mCardRecyclerView).setHalfIndex(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return -1;
     */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m39109p() {
        /*
            r3 = this;
            com.didichuxing.xpanel.channel.global.GlobalXPanelView$XPanelRecyclerAdapter r0 = r3.f51908C
            java.util.List r0 = r0.getContentList()
            monitor-enter(r0)
            if (r0 == 0) goto L_0x0022
            int r1 = r0.size()     // Catch:{ all -> 0x002d }
            r2 = 3
            if (r1 < r2) goto L_0x0022
            int r1 = r0.size()     // Catch:{ all -> 0x002d }
            if (r1 != r2) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 2
        L_0x0019:
            com.didichuxing.xpanel.base.BorderRecyclerView r2 = r3.mCardRecyclerView     // Catch:{ all -> 0x002d }
            com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView r2 = (com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView) r2     // Catch:{ all -> 0x002d }
            r2.setHalfIndex(r1)     // Catch:{ all -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r1
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            com.didichuxing.xpanel.base.BorderRecyclerView r0 = r3.mCardRecyclerView
            com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView r0 = (com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView) r0
            r1 = 0
            r0.setHalfIndex(r1)
            r0 = -1
            return r0
        L_0x002d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.channel.global.GlobalXPanelView.m39109p():int");
    }

    public View findViewByXPanelCardData(XPanelCardData xPanelCardData) {
        int indexOf = this.f51908C.mContentList.indexOf(xPanelCardData);
        if (indexOf == -1) {
            return null;
        }
        return ((XPanelLayoutManager) this.mLayoutManager).findViewByPosition(indexOf);
    }

    public void setBottomMaxShowHeight(boolean z) {
        if (this.f51910E != z) {
            this.f51910E = z;
            if (z) {
                if (this.f51924S) {
                    clearFirstDefault(STYLE_DEFAULT_HALF_HEIGHT, this.f51925T);
                } else {
                    clearFirstDefault(STYLE_DEFAULT_SHOW_HEIGHT, this.f51958w);
                }
            } else if (this.f51932aa.getParent() != null) {
                this.f51932aa.requestLayout();
            }
        }
    }

    public void setTopOffset(int i) {
        if (this.mTopOffset != i) {
            this.mTopOffset = i;
            FrameLayout frameLayout = this.f51959x;
            frameLayout.setPadding(frameLayout.getPaddingLeft(), this.mTopOffset, this.f51959x.getPaddingRight(), this.f51959x.getPaddingBottom());
        }
    }

    public void setNavigationText(CharSequence charSequence) {
        ViewGroup viewGroup = this.f51914I;
        if (viewGroup != null) {
            ((TextView) viewGroup.findViewById(R.id.oc_navi_title)).setText(charSequence);
        }
    }

    public void setLoadingView(View view) {
        FrameLayout.LayoutParams layoutParams;
        if (view == null || view.getParent() != null) {
            LogcatUtil.m39238e("GlobalXPanelView", "setLoadingView error! v == null or v.getParent() != null");
            return;
        }
        this.f51906A = view;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(layoutParams2);
        }
        int dimensionPixelSize = this.f51941f ? this.mContext.getResources().getDimensionPixelSize(R.dimen._10dip) : 0;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        layoutParams.gravity = 81;
        this.f51959x.addView(this.f51906A, layoutParams);
        this.f51906A.setVisibility(4);
        this.f51953r = 1;
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                GlobalXPanelView.this.m39100k();
            }
        }, 100);
    }

    public void onResume() {
        XPanelOmegaUtils.trackEvent("xpanel_sw");
        this.f51943h = true;
        if (this.f51936ae) {
            this.f51920O = System.currentTimeMillis();
        }
    }

    public void onPause() {
        this.f51943h = false;
        m39112q();
    }

    /* renamed from: q */
    private void m39112q() {
        if (this.f51936ae) {
            HashMap hashMap = new HashMap();
            hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f51920O));
            XPanelOmegaUtils.trackEvent("xpanel_sw_time", hashMap);
        }
    }

    public void bindSpaceInterceptor(IXPanelSpaceInterceptor iXPanelSpaceInterceptor) {
        this.f51919N = iXPanelSpaceInterceptor;
    }

    public void setMinShowHeight(int i) {
        this.f51940e = i;
    }

    public TextView getMessageTip() {
        return this.f51918M;
    }

    private class CommonHolder extends RecyclerView.ViewHolder {
        public CommonHolder(View view) {
            super(view);
            GlobalXPanelView.this.m39048a(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39048a(View view) {
        RecyclerView.LayoutParams layoutParams;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (!(layoutParams2 instanceof RecyclerView.LayoutParams)) {
                if (layoutParams2 != null) {
                    layoutParams = new RecyclerView.LayoutParams(layoutParams2);
                } else {
                    layoutParams = new RecyclerView.LayoutParams(-1, -2);
                }
                view.setLayoutParams(layoutParams);
            }
        }
    }

    private class XPanelRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final int NO_INVALID;
        private Handler handler;
        /* access modifiers changed from: private */
        public List<XPanelCardData> mContentList;
        private HashMap<Integer, View> mViewMap;

        private XPanelRecyclerAdapter() {
            this.handler = new Handler(Looper.getMainLooper());
            this.mContentList = new ArrayList();
            this.mViewMap = new HashMap<>();
            this.NO_INVALID = -1;
        }

        private class ModelHolder extends RecyclerView.ViewHolder {
            private IXPanelModelView mModelView;

            public ModelHolder(View view, IXPanelModelView iXPanelModelView) {
                super(view);
                this.mModelView = iXPanelModelView;
                GlobalXPanelView.this.m39048a(view);
            }

            public void bind(XPanelCardData xPanelCardData) {
                IXPanelModelView iXPanelModelView = this.mModelView;
                if (iXPanelModelView instanceof AbsXPanelAgentModelView) {
                    ((AbsXPanelAgentModelView) iXPanelModelView).bindCardData(xPanelCardData);
                    ((AbsXPanelAgentModelView) this.mModelView).bindListener(GlobalXPanelView.this.f51945j);
                }
                if (xPanelCardData.object instanceof IXPanelModel) {
                    this.mModelView.initData(xPanelCardData);
                    this.mModelView.bind(xPanelCardData.object);
                }
            }
        }

        public List<XPanelCardData> getContentList() {
            return this.mContentList;
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            RecyclerView.ViewHolder viewHolder;
            View view = this.mViewMap.get(Integer.valueOf(i));
            if (view == null) {
                IXPanelModelView newTemplateView = ModelsFactory.get().newTemplateView(GlobalXPanelView.this.mContext, i);
                View view2 = newTemplateView.getView();
                newTemplateView.setRoundCorner(GlobalXPanelView.this.f51930Z);
                viewHolder = new ModelHolder(view2, newTemplateView);
                view = view2;
            } else {
                LogcatUtil.m39238e("GlobalXPanelView", "view复用：" + view.getClass().getName() + ", viewType=" + i);
                viewHolder = new CommonHolder(view);
            }
            if (!(view == GlobalXPanelView.this.f51932aa || view == GlobalXPanelView.this.f51934ac)) {
                view.setClickable(true);
            }
            return viewHolder;
        }

        public void notifyList(final List<XPanelCardData> list, final List<XPanelCardData> list2) {
            if (((XPanelRecyclerView) GlobalXPanelView.this.mCardRecyclerView).isComputingLayout()) {
                this.handler.removeCallbacksAndMessages((Object) null);
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        if (((XPanelRecyclerView) GlobalXPanelView.this.mCardRecyclerView).isAttachedToWindow()) {
                            XPanelRecyclerAdapter.this.notifyList(list, list2);
                        }
                    }
                }, 200);
                return;
            }
            doNotifyList(list, list2);
        }

        private void doNotifyList(List<XPanelCardData> list, List<XPanelCardData> list2) {
            synchronized (this.mContentList) {
                this.mContentList.clear();
                boolean unused = GlobalXPanelView.this.f51923R = true;
                if (list != null) {
                    for (XPanelCardData removeXPanelCard : list) {
                        removeXPanelCard(removeXPanelCard);
                    }
                }
                if (list2 != null) {
                    for (XPanelCardData addXPanelCard : list2) {
                        addXPanelCard(addXPanelCard);
                    }
                    this.mContentList.addAll(list2);
                }
            }
            try {
                notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
                LogcatUtil.m39238e("GlobalXPanelView", "notifyDataSetChanged error" + e);
                for (XPanelCardData next : this.mContentList) {
                    LogcatUtil.m39238e("GlobalXPanelView", "id: " + next.f51896id + ", position" + next.cardPosition + ",template: " + next.mTemplate);
                }
                LogUtils.m36180e(this.mViewMap.toString());
                for (Integer num : this.mViewMap.keySet()) {
                    LogcatUtil.m39238e("GlobalXPanelView", this.mViewMap.get(num).getClass().getName());
                }
            }
        }

        private int getViewHolderCode(XPanelCardData xPanelCardData) {
            if (xPanelCardData.content != null) {
                return xPanelCardData.content.hashCode();
            }
            return -1;
        }

        private void removeXPanelCard(XPanelCardData xPanelCardData) {
            xPanelCardData.moveOut();
            this.mViewMap.remove(Integer.valueOf(getViewHolderCode(xPanelCardData)));
            xPanelCardData.destroy();
        }

        private void addXPanelCard(XPanelCardData xPanelCardData) {
            int viewHolderCode = getViewHolderCode(xPanelCardData);
            if (viewHolderCode != -1 && !this.mViewMap.containsKey(Integer.valueOf(viewHolderCode))) {
                this.mViewMap.put(Integer.valueOf(viewHolderCode), xPanelCardData.content.getView());
            }
        }

        public int getItemViewType(int i) {
            XPanelCardData xPanelCardData = this.mContentList.get(i);
            int viewHolderCode = getViewHolderCode(xPanelCardData);
            if (viewHolderCode != -1) {
                return viewHolderCode;
            }
            if (xPanelCardData.object instanceof IXPanelModel) {
                return ModelsFactory.getTemplateType(((IXPanelModel) xPanelCardData.object).getTemplate());
            }
            return ModelsFactory.getTemplateType(xPanelCardData.mTemplate);
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (i != 0) {
                XPanelCardData xPanelCardData = this.mContentList.get(i);
                xPanelCardData.mCardRoundCorner = GlobalXPanelView.this.f51930Z;
                xPanelCardData.bindData();
                xPanelCardData.cardPosition = i - 1;
                xPanelCardData.position = i;
                xPanelCardData.length = GlobalXPanelView.this.f51907B.size() - 2;
                xPanelCardData.allCardLength = GlobalXPanelView.this.f51907B.size();
                if (viewHolder instanceof ModelHolder) {
                    ((ModelHolder) viewHolder).bind(xPanelCardData);
                }
            }
        }

        public int getItemCount() {
            return this.mContentList.size();
        }
    }

    public class XPanelLayoutManager extends LinearLayoutManager implements IXPanelMeasureHelper, XPanelBottomView.BottomCaculate {
        private int mHalfIndex;
        private RecyclerView.Recycler mRecycler;
        /* access modifiers changed from: private */
        public RecyclerView.State mState;

        public XPanelLayoutManager(Context context) {
            super(context);
        }

        public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
            if (this.mRecycler != recycler) {
                this.mRecycler = recycler;
            }
            if (this.mState != state) {
                this.mState = state;
            }
            super.onMeasure(recycler, state, i, i2);
            int unused = GlobalXPanelView.this.f51956u = View.MeasureSpec.getSize(i2);
            GlobalXPanelView.this.mScreenHeight = View.MeasureSpec.getSize(i2);
            GlobalXPanelView globalXPanelView = GlobalXPanelView.this;
            int unused2 = globalXPanelView.f51928W = (int) (((double) globalXPanelView.mScreenHeight) * 0.5d);
            LogcatUtil.m39237d("GlobalXPanelView", "mCurrentRecycleHeight=" + GlobalXPanelView.this.f51956u + ", mUpThreshold=" + GlobalXPanelView.this.f51928W + ", sPullValue=" + GlobalXPanelView.f51904X);
        }

        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            this.mHalfIndex = GlobalXPanelView.this.m39109p();
            if (GlobalXPanelView.this.f51932aa != null) {
                GlobalXPanelView.this.f51932aa.forceLayout();
            }
            if (GlobalXPanelView.this.f51934ac != null) {
                GlobalXPanelView.this.f51934ac.forceLayout();
            }
            super.onLayoutChildren(recycler, state);
        }

        public void onLayoutCompleted(RecyclerView.State state) {
            super.onLayoutCompleted(state);
            LogcatUtil.m39237d("GlobalXPanelView", "@onLayoutCompleted....");
            GlobalXPanelView.this.m39082d();
            if (GlobalXPanelView.this.f51937af) {
                boolean unused = GlobalXPanelView.this.f51937af = false;
                if (GlobalXPanelView.this.f51910E) {
                    GlobalXPanelView.this.f51938c.doXPanelContentChange();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c0, code lost:
            if (r12 <= r3) goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c2, code lost:
            r2 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c4, code lost:
            r2 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c9, code lost:
            if (r15.getParent() != null) goto L_0x00d0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cb, code lost:
            r0.mRecycler.recycleView(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d0, code lost:
            r12 = r3;
            r10 = r11;
         */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x0252  */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x0256  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x0273  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int measureHeight(int r17) {
            /*
                r16 = this;
                r0 = r16
                androidx.recyclerview.widget.RecyclerView$State r1 = r0.mState
                r2 = 0
                if (r1 == 0) goto L_0x02cb
                androidx.recyclerview.widget.RecyclerView$Recycler r1 = r0.mRecycler
                if (r1 != 0) goto L_0x000d
                goto L_0x02cb
            L_0x000d:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r1 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                int r1 = r1.f51956u
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "@measureHeight, contentHeight="
                r3.append(r4)
                r3.append(r1)
                java.lang.String r3 = r3.toString()
                java.lang.String r4 = "GlobalXPanelView"
                com.didichuxing.xpanel.util.LogcatUtil.m39239i(r4, r3)
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r3 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                int r3 = r3.m39107o()
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r5 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                com.didichuxing.xpanel.channel.global.GlobalXPanelView$XPanelRecyclerAdapter r5 = r5.f51908C
                java.util.List r5 = r5.getContentList()
                r6 = 2
                java.lang.String r7 = "begin calculation"
                com.didichuxing.xpanel.util.LogcatUtil.m39239i(r4, r7)     // Catch:{ Exception -> 0x022c }
                int r7 = r5.size()     // Catch:{ Exception -> 0x022c }
                r8 = -1
                r9 = 1
                if (r7 <= r6) goto L_0x0204
                int r10 = r7 + -2
                r11 = 1
                r12 = 0
                r13 = 0
            L_0x004c:
                int r14 = r7 + -1
                if (r11 >= r14) goto L_0x00e5
                java.lang.Object r14 = r5.get(r11)     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.base.XPanelCardData r14 = (com.didichuxing.xpanel.base.XPanelCardData) r14     // Catch:{ Exception -> 0x0202 }
                androidx.recyclerview.widget.RecyclerView$Recycler r15 = r0.mRecycler     // Catch:{ Exception -> 0x0202 }
                android.view.View r15 = r15.getViewForPosition(r11)     // Catch:{ Exception -> 0x0202 }
                if (r15 == 0) goto L_0x00de
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                r6.m39048a((android.view.View) r15)     // Catch:{ Exception -> 0x0202 }
                r0.measureChildWithMargins(r15, r2, r2)     // Catch:{ Exception -> 0x0202 }
                int r6 = r15.getMeasuredHeight()     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                boolean r2 = r2.m39077c((int) r11)     // Catch:{ Exception -> 0x0202 }
                if (r2 == 0) goto L_0x0079
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r2 = r2.f51909D     // Catch:{ Exception -> 0x0202 }
                int r6 = r6 + r2
            L_0x0079:
                if (r11 != r9) goto L_0x0080
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int unused = r2.f51926U = r6     // Catch:{ Exception -> 0x0202 }
            L_0x0080:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0202 }
                r2.<init>()     // Catch:{ Exception -> 0x0202 }
                java.lang.String r9 = "第"
                r2.append(r9)     // Catch:{ Exception -> 0x0202 }
                r2.append(r11)     // Catch:{ Exception -> 0x0202 }
                java.lang.String r9 = "张卡片:id="
                r2.append(r9)     // Catch:{ Exception -> 0x0202 }
                java.lang.String r9 = r14.f51896id     // Catch:{ Exception -> 0x0202 }
                r2.append(r9)     // Catch:{ Exception -> 0x0202 }
                java.lang.String r9 = ",height="
                r2.append(r9)     // Catch:{ Exception -> 0x0202 }
                r2.append(r6)     // Catch:{ Exception -> 0x0202 }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.util.LogcatUtil.m39239i(r4, r2)     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int unused = r2.f51957v = r3     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                boolean r2 = r2.f51941f     // Catch:{ Exception -> 0x0202 }
                if (r2 != 0) goto L_0x00b5
                int r12 = r12 + r6
                goto L_0x00d3
            L_0x00b5:
                if (r11 != r10) goto L_0x00bc
                if (r12 <= r3) goto L_0x00ba
                goto L_0x00bc
            L_0x00ba:
                r13 = 0
                goto L_0x00bd
            L_0x00bc:
                r13 = 1
            L_0x00bd:
                int r12 = r12 + r6
                if (r12 < r3) goto L_0x00d3
                if (r12 <= r3) goto L_0x00c4
                r2 = 2
                goto L_0x00c5
            L_0x00c4:
                r2 = 1
            L_0x00c5:
                android.view.ViewParent r6 = r15.getParent()     // Catch:{ Exception -> 0x022d }
                if (r6 != 0) goto L_0x00d0
                androidx.recyclerview.widget.RecyclerView$Recycler r6 = r0.mRecycler     // Catch:{ Exception -> 0x022d }
                r6.recycleView(r15)     // Catch:{ Exception -> 0x022d }
            L_0x00d0:
                r12 = r3
                r10 = r11
                goto L_0x00e6
            L_0x00d3:
                android.view.ViewParent r2 = r15.getParent()     // Catch:{ Exception -> 0x0202 }
                if (r2 != 0) goto L_0x00de
                androidx.recyclerview.widget.RecyclerView$Recycler r2 = r0.mRecycler     // Catch:{ Exception -> 0x0202 }
                r2.recycleView(r15)     // Catch:{ Exception -> 0x0202 }
            L_0x00de:
                int r11 = r11 + 1
                r2 = 0
                r6 = 2
                r9 = 1
                goto L_0x004c
            L_0x00e5:
                r2 = 1
            L_0x00e6:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r6 = r6.f51958w     // Catch:{ Exception -> 0x0202 }
                if (r6 <= 0) goto L_0x0118
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r6 = r6.f51958w     // Catch:{ Exception -> 0x0202 }
                if (r6 < r12) goto L_0x0105
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r7 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r7 = r7.f51948m     // Catch:{ Exception -> 0x0202 }
                int r7 = r12 - r7
                int unused = r6.f51926U = r7     // Catch:{ Exception -> 0x0202 }
                goto L_0x0184
            L_0x0105:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r7 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r7 = r7.f51958w     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r9 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r9 = r9.f51947l     // Catch:{ Exception -> 0x0202 }
                int r7 = r7 + r9
                int unused = r6.f51926U = r7     // Catch:{ Exception -> 0x0202 }
                goto L_0x0184
            L_0x0118:
                if (r13 != 0) goto L_0x014d
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r6 = r6.f51926U     // Catch:{ Exception -> 0x0202 }
                if (r6 >= r12) goto L_0x0123
                goto L_0x014d
            L_0x0123:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                boolean r6 = r6.defaultShowBottomShader     // Catch:{ Exception -> 0x0202 }
                if (r6 == 0) goto L_0x012f
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int unused = r6.f51926U = r12     // Catch:{ Exception -> 0x0202 }
                goto L_0x013c
            L_0x012f:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r7 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r7 = r7.f51948m     // Catch:{ Exception -> 0x0202 }
                int r7 = r12 - r7
                int unused = r6.f51926U = r7     // Catch:{ Exception -> 0x0202 }
            L_0x013c:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                boolean r6 = r6.changeDefaultHeight     // Catch:{ Exception -> 0x0202 }
                if (r6 == 0) goto L_0x0184
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r7 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r7 = r7.f51926U     // Catch:{ Exception -> 0x0202 }
                r6.mDownHeight = r7     // Catch:{ Exception -> 0x0202 }
                goto L_0x0184
            L_0x014d:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r7 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r7 = r7.f51926U     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r9 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r9 = r9.mDefaultSecondHeight     // Catch:{ Exception -> 0x0202 }
                int r7 = r7 + r9
                int unused = r6.f51926U = r7     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r7 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r7 = r7.f51926U     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r9 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r9 = r9.f51947l     // Catch:{ Exception -> 0x0202 }
                int r7 = r7 + r9
                int unused = r6.f51926U = r7     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                boolean r6 = r6.changeDefaultHeight     // Catch:{ Exception -> 0x0202 }
                if (r6 == 0) goto L_0x0184
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r7 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r7 = r7.f51926U     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r9 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r9 = r9.mDefaultSecondHeight     // Catch:{ Exception -> 0x0202 }
                int r7 = r7 - r9
                r6.mDownHeight = r7     // Catch:{ Exception -> 0x0202 }
            L_0x0184:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r7 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r7 = r7.f51926U     // Catch:{ Exception -> 0x0202 }
                int r3 = java.lang.Math.min(r7, r3)     // Catch:{ Exception -> 0x0202 }
                int unused = r6.f51926U = r3     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r3 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.base.BorderRecyclerView r3 = r3.mCardRecyclerView     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView r3 = (com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView) r3     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r6 = r6.mScreenHeight     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r7 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r7 = r7.f51926U     // Catch:{ Exception -> 0x0202 }
                int r6 = r6 - r7
                r3.setDefaulStautsTop(r6)     // Catch:{ Exception -> 0x0202 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0202 }
                r3.<init>()     // Catch:{ Exception -> 0x0202 }
                java.lang.String r6 = "默认态卡片的高度: mLastDefaultShow="
                r3.append(r6)     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r6 = r6.f51926U     // Catch:{ Exception -> 0x0202 }
                r3.append(r6)     // Catch:{ Exception -> 0x0202 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.util.LogcatUtil.m39239i(r4, r3)     // Catch:{ Exception -> 0x0202 }
                if (r13 != 0) goto L_0x01dd
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r3 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r3 = r3.mDownHeight     // Catch:{ Exception -> 0x0202 }
                if (r3 >= r12) goto L_0x01cc
                goto L_0x01dd
            L_0x01cc:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r3 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                boolean r3 = r3.defaultShowBottomShader     // Catch:{ Exception -> 0x0202 }
                if (r3 == 0) goto L_0x01d4
                r3 = r12
                goto L_0x01e8
            L_0x01d4:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r3 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r3 = r3.f51948m     // Catch:{ Exception -> 0x0202 }
                int r3 = r12 - r3
                goto L_0x01e8
            L_0x01dd:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r3 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r3 = r3.mDownHeight     // Catch:{ Exception -> 0x0202 }
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r6 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this     // Catch:{ Exception -> 0x0202 }
                int r6 = r6.f51947l     // Catch:{ Exception -> 0x0202 }
                int r3 = r3 + r6
            L_0x01e8:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ff }
                r6.<init>()     // Catch:{ Exception -> 0x01ff }
                java.lang.String r7 = "卡片露出的最小高度: minHeight="
                r6.append(r7)     // Catch:{ Exception -> 0x01ff }
                r6.append(r3)     // Catch:{ Exception -> 0x01ff }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01ff }
                com.didichuxing.xpanel.util.LogcatUtil.m39239i(r4, r6)     // Catch:{ Exception -> 0x01ff }
                r6 = r3
                r3 = r12
                goto L_0x0208
            L_0x01ff:
                r6 = r3
                r3 = r12
                goto L_0x022e
            L_0x0202:
                r3 = r12
                goto L_0x022d
            L_0x0204:
                r2 = 1
                r3 = 0
                r6 = 0
                r10 = -1
            L_0x0208:
                if (r10 == r8) goto L_0x022e
                r7 = 1
            L_0x020b:
                int r8 = r5.size()     // Catch:{ Exception -> 0x022a }
                if (r7 >= r8) goto L_0x022e
                java.lang.Object r8 = r5.get(r7)     // Catch:{ Exception -> 0x022a }
                com.didichuxing.xpanel.base.XPanelCardData r8 = (com.didichuxing.xpanel.base.XPanelCardData) r8     // Catch:{ Exception -> 0x022a }
                if (r7 != r10) goto L_0x021d
                r8.defaultStatus = r2     // Catch:{ Exception -> 0x022a }
                r9 = 1
                goto L_0x0227
            L_0x021d:
                if (r7 >= r10) goto L_0x0223
                r9 = 1
                r8.defaultStatus = r9     // Catch:{ Exception -> 0x022a }
                goto L_0x0227
            L_0x0223:
                r9 = 1
                r11 = 3
                r8.defaultStatus = r11     // Catch:{ Exception -> 0x022a }
            L_0x0227:
                int r7 = r7 + 1
                goto L_0x020b
            L_0x022a:
                goto L_0x022e
            L_0x022c:
                r3 = 0
            L_0x022d:
                r6 = 0
            L_0x022e:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = "RecyclerView的高度:"
                r2.append(r7)
                r2.append(r1)
                java.lang.String r7 = ",其他卡片之和："
                r2.append(r7)
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                com.didichuxing.xpanel.util.LogcatUtil.m39239i(r4, r2)
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                boolean r2 = r2.f51941f
                if (r2 == 0) goto L_0x0253
                r3 = r6
            L_0x0253:
                int r1 = r1 - r3
                if (r1 >= 0) goto L_0x0257
                r1 = 0
            L_0x0257:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "end calculation 透明卡片的高度:"
                r2.append(r3)
                r2.append(r1)
                java.lang.String r2 = r2.toString()
                com.didichuxing.xpanel.util.LogcatUtil.m39239i(r4, r2)
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                int r2 = r2.f51950o
                if (r1 == r2) goto L_0x02aa
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                int unused = r2.f51950o = r1
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                boolean r2 = r2.f51910E
                if (r2 != 0) goto L_0x02aa
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                com.didichuxing.xpanel.channel.global.impl.IXPanelCallBack r2 = r2.f51938c
                if (r2 == 0) goto L_0x02aa
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                int r2 = r2.m39087f()
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r3 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                int r3 = r3.f51956u
                int r3 = r3 - r1
                int r3 = r3 + r2
                if (r2 <= 0) goto L_0x029f
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                int r2 = r2.f51947l
                goto L_0x02a0
            L_0x029f:
                r2 = 0
            L_0x02a0:
                int r3 = r3 - r2
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                com.didichuxing.xpanel.channel.global.impl.IXPanelCallBack r2 = r2.f51938c
                r2.doXPanelShowHeightChange(r3)
            L_0x02aa:
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                boolean r2 = r2.f51923R
                if (r2 == 0) goto L_0x02ca
                int r2 = r5.size()
                r3 = 2
                if (r2 <= r3) goto L_0x02ca
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                boolean r2 = r2.f51941f
                if (r2 == 0) goto L_0x02ca
                com.didichuxing.xpanel.channel.global.GlobalXPanelView r2 = com.didichuxing.xpanel.channel.global.GlobalXPanelView.this
                r3 = 0
                boolean unused = r2.f51923R = r3
                r16.postMeasure()
            L_0x02ca:
                return r1
            L_0x02cb:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.channel.global.GlobalXPanelView.XPanelLayoutManager.measureHeight(int):int");
        }

        private void postMeasure() {
            GlobalXPanelView.this.mHandler.post(new Runnable() {
                public void run() {
                    if (GlobalXPanelView.this.mContext instanceof Activity) {
                        Activity activity = (Activity) GlobalXPanelView.this.mContext;
                        if ((Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) || activity.isFinishing() || activity == null) {
                            return;
                        }
                    }
                    if (((XPanelLayoutManager) GlobalXPanelView.this.mLayoutManager).mState == null || ((XPanelLayoutManager) GlobalXPanelView.this.mLayoutManager).mState.isPreLayout() || ((XPanelLayoutManager) GlobalXPanelView.this.mLayoutManager).mState.getItemCount() != GlobalXPanelView.this.f51908C.getItemCount()) {
                        GlobalXPanelView.this.mHandler.post(this);
                        return;
                    }
                    ((XPanelRecyclerView) GlobalXPanelView.this.mCardRecyclerView).setCurrentStatus(2);
                    int access$6300 = XPanelLayoutManager.this.measureDefaultHeight();
                    if (GlobalXPanelView.this.f51938c != null) {
                        GlobalXPanelView.this.f51938c.doXPanelShowHeightChange(access$6300 + GlobalXPanelView.this.m39087f());
                    }
                    ((XPanelRecyclerView) GlobalXPanelView.this.mCardRecyclerView).scrollBy(0, XPanelLayoutManager.this.measureMoveLength());
                    int unused = GlobalXPanelView.this.f51949n = (int) (((float) GlobalXPanelView.this.f51926U) + (((float) (GlobalXPanelView.this.f51956u - GlobalXPanelView.this.f51926U)) * GlobalXPanelView.f51905b));
                    LogcatUtil.m39237d("GlobalXPanelView", "mMaskLayerShowThreshold=" + GlobalXPanelView.this.f51949n);
                    GlobalXPanelView.this.m39082d();
                }
            });
        }

        /* access modifiers changed from: private */
        public int measureMoveLength() {
            if (GlobalXPanelView.this.f51908C.getContentList().size() <= 2 || ((XPanelLayoutManager) GlobalXPanelView.this.mLayoutManager).getChildCount() == 0) {
                return 0;
            }
            View childAt = ((XPanelLayoutManager) GlobalXPanelView.this.mLayoutManager).getChildAt(0);
            if (childAt == GlobalXPanelView.this.f51932aa) {
                return GlobalXPanelView.this.f51926U - GlobalXPanelView.this.m39093h();
            }
            int position = ((XPanelLayoutManager) GlobalXPanelView.this.mLayoutManager).getPosition(childAt);
            int i = 0;
            for (int i2 = 1; i2 < position; i2++) {
                View view = null;
                try {
                    view = this.mRecycler.getViewForPosition(i2);
                } catch (Exception e) {
                    e.printStackTrace();
                    HashMap hashMap = new HashMap();
                    hashMap.put("error_positon", Integer.valueOf(i2));
                    hashMap.put("first_position", Integer.valueOf(position));
                    XPanelOmegaUtils.trackEvent("tech_xpanel_crash_in_viewholder", hashMap);
                }
                if (view != null) {
                    measureChildWithMargins(childAt, 0, 0);
                    int measuredHeight = childAt.getMeasuredHeight() + (GlobalXPanelView.this.m39077c(i2) ? GlobalXPanelView.this.f51909D : 0);
                    if (childAt.getParent() == null) {
                        this.mRecycler.recycleView(childAt);
                    }
                    i += measuredHeight;
                }
            }
            return -(i + (-childAt.getTop()) + (GlobalXPanelView.this.f51956u - GlobalXPanelView.this.f51926U));
        }

        /* access modifiers changed from: private */
        public int measureDefaultHeight() {
            List<XPanelCardData> contentList = GlobalXPanelView.this.f51908C.getContentList();
            if (contentList.size() <= 2) {
                return 0;
            }
            if (!GlobalXPanelView.this.f51924S) {
                int i = GlobalXPanelView.this.f51926U;
                LogcatUtil.m39237d("GlobalXPanelView", "@measureDefaultHeight, 第一次展示卡片, height=" + i);
                return Math.min(i, (int) (((double) Utils.getScreenHeight(GlobalXPanelView.this.mContext)) * 0.5d));
            }
            int ah = GlobalXPanelView.this.f51925T;
            int i2 = 1;
            int i3 = 0;
            while (i2 < contentList.size() && i2 <= ah) {
                try {
                    View findViewByPosition = ((XPanelLayoutManager) GlobalXPanelView.this.mLayoutManager).findViewByPosition(i2);
                    if (findViewByPosition == null) {
                        findViewByPosition = this.mRecycler.getViewForPosition(i2);
                    }
                    if (findViewByPosition != null) {
                        GlobalXPanelView.this.m39048a(findViewByPosition);
                        measureChildWithMargins(findViewByPosition, 0, 0);
                        int measuredHeight = findViewByPosition.getMeasuredHeight() + (GlobalXPanelView.this.m39077c(i2) ? GlobalXPanelView.this.f51909D : 0);
                        if (findViewByPosition.getParent() == null) {
                            this.mRecycler.recycleView(findViewByPosition);
                        }
                        if (i2 > GlobalXPanelView.this.f51925T) {
                            return i3;
                        }
                        i3 += measuredHeight;
                    }
                    i2++;
                } catch (Exception unused) {
                    return GlobalXPanelView.this.f51926U;
                }
            }
            return i3;
        }

        public int computeHorizontalScrollExtent(RecyclerView.State state) {
            return super.computeHorizontalScrollExtent(state);
        }

        private int getMaxBottomCardsHeight() {
            return GlobalXPanelView.this.mDownHeight;
        }

        public void getMessageRect(Rect rect) {
            if (GlobalXPanelView.this.f51912G == null || GlobalXPanelView.this.f51912G.getCurrentHeight() <= 0 || GlobalXPanelView.this.f51912G.isPressed()) {
                rect.set(0, 0, 0, 0);
                return;
            }
            int dip2px = Utils.dip2px(GlobalXPanelView.this.mContext, 45.0f);
            int currentHeight = GlobalXPanelView.this.f51912G.getCurrentHeight();
            if (currentHeight >= dip2px) {
                currentHeight -= dip2px;
            }
            rect.set(0, currentHeight, GlobalXPanelView.this.f51912G.getMeasuredWidth(), 0);
        }

        public int measureBottomHeight() {
            int i = 0;
            if (this.mHalfIndex == -1 || !GlobalXPanelView.this.f51941f) {
                return 0;
            }
            if (((XPanelLayoutManager) GlobalXPanelView.this.mLayoutManager).findViewByPosition(this.mHalfIndex) == null) {
                return Utils.dip2px(GlobalXPanelView.this.mContext, 20.0f);
            }
            int size = GlobalXPanelView.this.f51908C.getContentList().size() - 2;
            for (int i2 = 1; i2 <= size; i2++) {
                View findViewByPosition = ((XPanelLayoutManager) GlobalXPanelView.this.mLayoutManager).findViewByPosition(i2);
                if (findViewByPosition != null) {
                    i += findViewByPosition.getMeasuredHeight() + GlobalXPanelView.this.f51909D;
                }
            }
            int D = (GlobalXPanelView.this.f51956u - i) + GlobalXPanelView.this.f51947l;
            if (D < 0) {
                D = Utils.dip2px(GlobalXPanelView.this.mContext, 20.0f);
            }
            LogcatUtil.m39237d("GlobalXPanelView", "@measureBottomHeight, bottomHeight=" + D);
            return D;
        }
    }

    public void clearFirstDefault(int i, int i2) {
        LogcatUtil.m39239i("GlobalXPanelView", "@clearFirstDefault, style=" + i + ", height=" + i2);
        this.f51923R = true;
        if (i == STYLE_DEFAULT_SHOW_HEIGHT) {
            this.f51924S = false;
            this.f51958w = i2;
        } else if (i == STYLE_DEFAULT_HALF_HEIGHT) {
            this.f51924S = true;
            this.f51958w = 0;
            this.mDefaultSecondHeight = i2;
        }
        if (this.f51932aa.getParent() == null) {
            ((XPanelLayoutManager) this.mLayoutManager).scrollToPosition(0);
        } else {
            this.f51932aa.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo128057a(int i) {
        View findViewByPosition = ((XPanelLayoutManager) this.mLayoutManager).findViewByPosition(1);
        if (findViewByPosition != null) {
            int[] iArr = new int[2];
            findViewByPosition.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            LogcatUtil.m39237d("GlobalXPanelView", "@checkFirstCardPosition, screen_y=" + i2);
            int i3 = i2 + this.f51947l;
            int dip2px = Utils.dip2px(this.mContext, 5.0f);
            if (i > i3 - dip2px) {
                clearFirstDefault(STYLE_DEFAULT_SHOW_HEIGHT, this.f51926U - ((i - i3) + dip2px));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo128056a() {
        if (this.f51911F != null && this.f51922Q && this.f51907B.size() >= 2) {
            int childCount = ((XPanelLayoutManager) this.mLayoutManager).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ((XPanelLayoutManager) this.mLayoutManager).getChildAt(i);
                if (childAt != this.f51932aa && ((float) childAt.getBottom()) >= this.f51911F.getTranslationY() + ((float) this.f51911F.getMeasuredHeight())) {
                    int i2 = -1;
                    Drawable background = childAt.getBackground();
                    if (background instanceof ColorDrawable) {
                        i2 = ((ColorDrawable) background).getColor();
                    }
                    this.f51911F.setForegroundColor(i2);
                    return;
                }
            }
        }
    }

    public void notifyAdd() {
        this.mHandler.post(new Runnable() {
            public void run() {
                GlobalXPanelView.this.m39102l();
            }
        });
    }

    private class PullUpClickListener implements View.OnClickListener {
        private PullUpClickListener() {
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (GlobalXPanelView.this.f51932aa != null && GlobalXPanelView.this.f51932aa.getParent() != null) {
                ((XPanelRecyclerView) GlobalXPanelView.this.mCardRecyclerView).smoothScrollBy(0, GlobalXPanelView.this.f51932aa.getBottom() + GlobalXPanelView.this.f51947l);
            }
        }
    }
}
