package com.didi.sdk.home.view;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.core.IMSessionMessageListener;
import com.didi.beatles.p101im.module.IMSessionUnreadCallback;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.app.ITitleBarDelegate;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.didi.sdk.events.CustomerDataStatus;
import com.didi.sdk.events.IMRefreshEvent;
import com.didi.sdk.events.RedDotStatusChangedEvent;
import com.didi.sdk.events.RedDotStatusEvent;
import com.didi.sdk.events.RemotionalMessageEvent;
import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.dpush.LogUtil;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.NetWorkTitleBar;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.utils.UiUtils;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class HomeNewTitleBarFragment extends Fragment implements View.OnClickListener, ITitleBarDelegate {

    /* renamed from: b */
    private static final String f39173b = "HomeNewTitleBarFragment";

    /* renamed from: a */
    final Handler f39174a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f39175c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ImageView f39176d;

    /* renamed from: e */
    private FrameLayout f39177e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f39178f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f39179g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f39180h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f39181i = 2;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public float f39182j = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f39183k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public NetWorkTitleBar f39184l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public NetWorkTitleBar.OnViewVisibilityChangeListener f39185m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View f39186n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public LEGOBubble f39187o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f39188p = 0;

    /* renamed from: q */
    private IMSessionMessageListener f39189q = new IMSessionMessageListener() {
        public void onSessionMessageArrive(Set<Long> set) {
            HomeNewTitleBarFragment.this.m29508b();
        }
    };

    /* renamed from: r */
    private Logger f39190r = LoggerFactory.getLogger("TopEntranceLayout");

    /* renamed from: s */
    private NetWorkTitleBar.OnViewVisibilityChangeListener f39191s = new NetWorkTitleBar.OnViewVisibilityChangeListener() {
        public void onNetWorkStateChanged(View view) {
            if (HomeNewTitleBarFragment.this.needHandleNetWorkState()) {
                if (HomeNewTitleBarFragment.this.f39185m != null) {
                    HomeNewTitleBarFragment.this.f39185m.onNetWorkStateChanged(HomeNewTitleBarFragment.this.f39184l);
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) HomeNewTitleBarFragment.this.f39186n.getLayoutParams();
                if (view.getVisibility() == 0) {
                    layoutParams.topMargin = (int) HomeNewTitleBarFragment.this.m29503a().getDimension(R.dimen.home_network_error_height);
                } else {
                    layoutParams.topMargin = (int) HomeNewTitleBarFragment.this.m29503a().getDimension(R.dimen.home_network_normal_height);
                }
            }
        }
    };

    /* renamed from: t */
    private View.OnClickListener f39192t = new View.OnClickListener() {
        public void onClick(View view) {
            int i;
            AutoTrackHelper.trackViewOnClick(view);
            if (HomeNewTitleBarFragment.this.f39187o != null && HomeNewTitleBarFragment.this.f39187o.isShowing()) {
                HomeNewTitleBarFragment.this.f39187o.dismiss();
            }
            HomeNewTitleBarFragment.this.f39179g.setVisibility(8);
            HashMap hashMap = new HashMap();
            hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
            hashMap.put("country_code", NationTypeUtil.getNationComponentData().getLocCountry());
            int i2 = 0;
            if (!NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
                OneLoginFacade.getAction().go2Login(HomeNewTitleBarFragment.this.getContext());
                i = 0;
            } else {
                EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.OPEN_SIDEBAR));
                i = 1;
            }
            hashMap.put("is_login", Integer.valueOf(i));
            hashMap.put("product_id", Integer.valueOf(ConfProxy.getInstance().getSelectedGroupId()));
            if (HomeNewTitleBarFragment.this.f39178f.getVisibility() == 0) {
                i2 = 2;
            } else if (HomeNewTitleBarFragment.this.f39175c.getVisibility() == 0) {
                i2 = 1;
            }
            hashMap.put("redpoint", Integer.valueOf(i2));
            hashMap.put("redpointtype", Integer.valueOf(HomeNewTitleBarFragment.this.f39181i));
            OmegaSDKAdapter.trackEvent("pas_home_profile_ck", (Map<String, Object>) hashMap);
        }
    };

    /* access modifiers changed from: protected */
    public void emotionMessageShow() {
    }

    public int getLayoutId() {
        return R.layout.f_new_titlebar;
    }

    public boolean needHandleNetWorkState() {
        return true;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public void onLeaveHome() {
    }

    public void setOnViewVisibilityChangeListener(NetWorkTitleBar.OnViewVisibilityChangeListener onViewVisibilityChangeListener) {
        this.f39185m = onViewVisibilityChangeListener;
        NetWorkTitleBar netWorkTitleBar = this.f39184l;
        if (netWorkTitleBar != null) {
            netWorkTitleBar.setOnViewVisibilityChangeListener(this.f39191s);
        }
    }

    public boolean isHideNetworkTitlteBar() {
        return this.f39184l.getVisibility() != 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Resources m29503a() {
        return DIDIApplicationDelegate.getAppContext().getResources();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        IMEngine.getInstance(getContext());
        IMEngine.addSessionMessageListener(this.f39189q);
        m29508b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m29508b() {
        EventBus.getDefault().post(new IMRefreshEvent());
        IMEngine.getAllUnreadMessageCount(new IMSessionUnreadCallback() {
            public void unReadCount(int i) {
                long unused = HomeNewTitleBarFragment.this.f39188p = (long) i;
                if (i > 0) {
                    EventBus.getDefault().post(new RedDotStatusChangedEvent(true));
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        IMEngine.getInstance(getContext());
        IMEngine.removeSessionMessageListener(this.f39189q);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int layoutId = getLayoutId();
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(layoutId);
        if (viewByResId == null) {
            viewByResId = layoutInflater.inflate(layoutId, (ViewGroup) null);
        }
        this.f39183k = viewByResId;
        ImageView imageView = (ImageView) viewByResId.findViewById(R.id.new_titlebar_left_btn);
        this.f39176d = imageView;
        imageView.setOnClickListener(this.f39192t);
        this.f39177e = (FrameLayout) this.f39183k.findViewById(R.id.new_titlebar_right);
        this.f39175c = (ImageView) this.f39183k.findViewById(R.id.new_titlebar_redDot);
        this.f39178f = (TextView) this.f39183k.findViewById(R.id.new_titlebar_message_redot);
        this.f39179g = (TextView) this.f39183k.findViewById(R.id.new_titlebar_message_tv);
        this.f39180h = (TextView) this.f39183k.findViewById(R.id.new_titlebar_remotional_tv);
        this.f39186n = this.f39183k.findViewById(R.id.home_new_toptitle_layout);
        this.f39184l = (NetWorkTitleBar) this.f39183k.findViewById(R.id.new_networkTitleBar);
        if (needHandleNetWorkState()) {
            this.f39184l.setOnViewVisibilityChangeListener(this.f39191s);
        }
        return this.f39183k;
    }

    public void onResume() {
        super.onResume();
        m29508b();
        NetWorkTitleBar netWorkTitleBar = this.f39184l;
        if (netWorkTitleBar != null) {
            netWorkTitleBar.refreshOnResume();
        }
        View view = this.f39183k;
        if (view != null) {
            view.post(new Runnable() {
                public void run() {
                    HomeNewTitleBarFragment homeNewTitleBarFragment = HomeNewTitleBarFragment.this;
                    float unused = homeNewTitleBarFragment.f39182j = (float) homeNewTitleBarFragment.f39183k.getTop();
                    if (HomeNewTitleBarFragment.this.f39183k != null) {
                        HomeNewTitleBarFragment.this.f39183k.setY(HomeNewTitleBarFragment.this.f39182j);
                    }
                }
            });
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void isShowRedDot(RedDotStatusEvent redDotStatusEvent) {
        int i = 0;
        if (this.f39188p > 0) {
            this.f39175c.setVisibility(0);
            return;
        }
        ImageView imageView = this.f39175c;
        if (!redDotStatusEvent.isShow) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void hideTitleBar() {
        View view = this.f39183k;
        if (view != null) {
            view.setVisibility(8);
            NetWorkTitleBar.OnViewVisibilityChangeListener onViewVisibilityChangeListener = this.f39185m;
            if (onViewVisibilityChangeListener != null) {
                onViewVisibilityChangeListener.onNetWorkStateChanged(this.f39184l);
            }
        }
    }

    public void restoreTitleBar() {
        if (this.f39176d != null) {
            this.f39183k.setVisibility(0);
            LogcatUtil.m39237d(f39173b, "mDefault: " + this.f39182j);
            this.f39183k.setY(this.f39182j);
            this.f39183k.setAlpha(1.0f);
            this.f39176d.setVisibility(0);
            this.f39176d.setOnClickListener(this.f39192t);
            NetWorkTitleBar.OnViewVisibilityChangeListener onViewVisibilityChangeListener = this.f39185m;
            if (onViewVisibilityChangeListener != null) {
                onViewVisibilityChangeListener.onNetWorkStateChanged(this.f39184l);
            }
        }
    }

    public void updateTitleBarLeftBtn(int i, View.OnClickListener onClickListener) {
        ImageView imageView = this.f39176d;
        if (imageView != null) {
            imageView.setImageResource(i);
            this.f39176d.setOnClickListener(onClickListener);
        }
    }

    public void hideTitleBarRightBtn() {
        LogcatUtil.m39237d(f39173b, "add view");
        this.f39177e.setVisibility(8);
    }

    public void addViewToRightRegion(View view) {
        LogcatUtil.m39237d(f39173b, "add View");
        this.f39177e.setVisibility(0);
        this.f39177e.removeAllViews();
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (view != null) {
            this.f39177e.addView(view);
        }
    }

    public void resetTitleBarYPosition(int i) {
        LogcatUtil.m39237d(f39173b, "top:  " + this.f39183k.getTop() + ", y: " + this.f39183k.getY());
        View view = this.f39183k;
        if (view != null) {
            view.setY(this.f39182j + ((float) i));
        }
    }

    public void resetTitleBarAlpha(float f) {
        View view = this.f39183k;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showMessage(com.didi.sdk.events.RemotionalMessageEvent r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getType()
            int r1 = r0.hashCode()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1673503419: goto L_0x002e;
                case -1186119954: goto L_0x0024;
                case -503344496: goto L_0x001a;
                case 899859624: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0038
        L_0x0010:
            java.lang.String r1 = "customerData"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x001a:
            java.lang.String r1 = "emotionalData"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            r0 = 0
            goto L_0x0039
        L_0x0024:
            java.lang.String r1 = "imData"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            r0 = 2
            goto L_0x0039
        L_0x002e:
            java.lang.String r1 = "didiPassData"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0038
            r0 = 3
            goto L_0x0039
        L_0x0038:
            r0 = -1
        L_0x0039:
            if (r0 == 0) goto L_0x0051
            if (r0 == r5) goto L_0x004b
            if (r0 == r4) goto L_0x0048
            if (r0 == r3) goto L_0x0042
            goto L_0x0056
        L_0x0042:
            r6.f39181i = r3
            r6.m29505a((com.didi.sdk.events.RemotionalMessageEvent) r7)
            goto L_0x0056
        L_0x0048:
            r6.f39181i = r4
            goto L_0x0056
        L_0x004b:
            r6.f39181i = r5
            r6.m29512c((com.didi.sdk.events.RemotionalMessageEvent) r7)
            goto L_0x0056
        L_0x0051:
            r6.f39181i = r2
            r6.m29509b((com.didi.sdk.events.RemotionalMessageEvent) r7)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.home.view.HomeNewTitleBarFragment.showMessage(com.didi.sdk.events.RemotionalMessageEvent):void");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dismissCustomerMessage(CustomerDataStatus customerDataStatus) {
        this.f39178f.setVisibility(8);
    }

    /* renamed from: a */
    private void m29505a(final RemotionalMessageEvent remotionalMessageEvent) {
        this.f39174a.postDelayed(new Runnable() {
            public void run() {
                RemotionalMessageEvent remotionalMessageEvent = remotionalMessageEvent;
                if (remotionalMessageEvent != null && remotionalMessageEvent.getDidiPassData() != null) {
                    if (!TextUtils.isEmpty(remotionalMessageEvent.getDidiPassData().text) && remotionalMessageEvent.getDidiPassData().type == 2 && !TextUtils.isEmpty(remotionalMessageEvent.getDidiPassData().leftIcon) && HomeNewTitleBarFragment.this.getActivity() != null && HomeNewTitleBarFragment.this.f39176d != null) {
                        if (HomeNewTitleBarFragment.this.f39187o != null && HomeNewTitleBarFragment.this.f39187o.isShowing()) {
                            HomeNewTitleBarFragment.this.f39187o.dismiss();
                            LEGOBubble unused = HomeNewTitleBarFragment.this.f39187o = null;
                        }
                        LEGOBubble.Builder builder = new LEGOBubble.Builder(HomeNewTitleBarFragment.this.getActivity());
                        builder.setText(remotionalMessageEvent.getDidiPassData().text);
                        builder.setTextProps(14, 1, 1);
                        builder.setLeftDrawable(remotionalMessageEvent.getDidiPassData().leftIcon);
                        builder.setCloseBtnVisible(true);
                        builder.setOutSideTouch(false);
                        builder.setCloseBtnListener(new BubbleCloseListener() {
                            public void onClick(LEGOBubble lEGOBubble) {
                                if (HomeNewTitleBarFragment.this.f39187o != null && HomeNewTitleBarFragment.this.f39187o.isShowing()) {
                                    HomeNewTitleBarFragment.this.f39187o.dismiss();
                                }
                            }
                        });
                        builder.setContentViewOnClick(new View.OnClickListener() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                if (HomeNewTitleBarFragment.this.f39187o != null && HomeNewTitleBarFragment.this.f39187o.isShowing()) {
                                    HomeNewTitleBarFragment.this.f39187o.dismiss();
                                }
                            }
                        });
                        builder.setDirection("left");
                        if (!TextUtils.isEmpty(remotionalMessageEvent.getDidiPassData().backColor)) {
                            builder.setBgColor(Color.parseColor(remotionalMessageEvent.getDidiPassData().backColor));
                        }
                        LEGOBubble unused2 = HomeNewTitleBarFragment.this.f39187o = builder.build();
                        if (!HomeNewTitleBarFragment.this.f39187o.isShowing() && HomeNewTitleBarFragment.this.f39176d != null && HomeNewTitleBarFragment.this.f39176d.getRootView().isAttachedToWindow()) {
                            HomeNewTitleBarFragment.this.f39187o.show(HomeNewTitleBarFragment.this.f39176d, ResourcesHelper.getDimensionPixelSize(HomeNewTitleBarFragment.this.getActivity(), R.dimen.new_ui_didi_pass_bubble_offset_x), -ResourcesHelper.getDimensionPixelSize(HomeNewTitleBarFragment.this.getActivity(), R.dimen.new_ui_didi_pass_bubble_offset_y));
                        }
                    } else if (remotionalMessageEvent.getDidiPassData().type == 1 && HomeNewTitleBarFragment.this.f39175c != null) {
                        HomeNewTitleBarFragment.this.f39175c.setVisibility(0);
                    }
                }
            }
        }, 500);
    }

    public View getDrawImg() {
        return this.f39176d;
    }

    /* access modifiers changed from: protected */
    public boolean noNeedHandleRemotionMessage(RemotionalMessageEvent remotionalMessageEvent) {
        TopBarData topBarData = ConfProxy.getInstance().getTopBarData();
        boolean z = (topBarData == null || topBarData.selectedGroup == null || "ride".equals(topBarData.selectedGroup.getGroupType())) ? false : true;
        boolean equals = "emotionalData".equals(remotionalMessageEvent.getType());
        if (!z || !equals) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private void m29509b(final RemotionalMessageEvent remotionalMessageEvent) {
        this.f39174a.postDelayed(new Runnable() {
            public void run() {
                LogUtil.m29960d(HomeNewTitleBarFragment.f39173b, "do Message Animation");
                if (!HomeNewTitleBarFragment.this.noNeedHandleRemotionMessage(remotionalMessageEvent)) {
                    HomeNewTitleBarFragment.this.emotionMessageShow();
                    HomeNewTitleBarFragment.this.f39180h.setText(remotionalMessageEvent.getText());
                    HomeNewTitleBarFragment.this.f39180h.post(new Runnable() {
                        public void run() {
                            HomeNewTitleBarFragment.this.f39174a.postDelayed(new Runnable() {
                                public void run() {
                                    HomeNewTitleBarFragment.this.f39180h.setVisibility(0);
                                    HomeNewTitleBarFragment.this.m29511c();
                                    HomeNewTitleBarFragment.this.m29514d();
                                }
                            }, 3000);
                        }
                    });
                }
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m29511c() {
        final GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        int width = this.f39180h.getWidth();
        LogUtil.m29960d(f39173b, "情感化消息长度：" + width);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f39176d.getWidth(), width});
        ofInt.setDuration(500);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeNewTitleBarFragment.this.f39180h.setWidth(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{UiUtils.dip2px(getContext(), 25.0f), UiUtils.dip2px(getContext(), 20.0f)});
        ofInt2.setDuration(500);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                gradientDrawable.setCornerRadius((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
                HomeNewTitleBarFragment.this.f39180h.setBackground(gradientDrawable);
            }
        });
        ofInt.start();
        ofInt2.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m29514d() {
        this.f39174a.postDelayed(new Runnable() {
            public void run() {
                final GradientDrawable gradientDrawable = (GradientDrawable) HomeNewTitleBarFragment.this.f39180h.getBackground();
                int width = HomeNewTitleBarFragment.this.f39180h.getWidth();
                LogUtil.m29960d(HomeNewTitleBarFragment.f39173b, "情感化消息长度：" + width);
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{width, HomeNewTitleBarFragment.this.f39176d.getWidth()});
                ofInt.setDuration(500);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HomeNewTitleBarFragment.this.f39180h.setWidth(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{UiUtils.dip2px(HomeNewTitleBarFragment.this.getContext(), 20.0f), UiUtils.dip2px(HomeNewTitleBarFragment.this.getContext(), 25.0f)});
                ofInt2.setDuration(500);
                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        GradientDrawable gradientDrawable = gradientDrawable;
                        if (gradientDrawable != null) {
                            gradientDrawable.setCornerRadius((float) intValue);
                        }
                        HomeNewTitleBarFragment.this.f39180h.setBackground(gradientDrawable);
                    }
                });
                ofInt.start();
                ofInt2.start();
            }
        }, 3000);
    }

    /* renamed from: c */
    private void m29512c(final RemotionalMessageEvent remotionalMessageEvent) {
        this.f39174a.postDelayed(new Runnable() {
            public void run() {
                String number = remotionalMessageEvent.getNumber();
                try {
                    if (Long.valueOf(Long.parseLong(number)).longValue() > 99) {
                        HomeNewTitleBarFragment.this.f39178f.setText("99+");
                    } else {
                        HomeNewTitleBarFragment.this.f39178f.setText(number);
                    }
                    HomeNewTitleBarFragment.this.f39178f.setVisibility(0);
                } catch (Exception unused) {
                    HomeNewTitleBarFragment.this.f39178f.setVisibility(8);
                }
                ScaleAnimation scaleAnimation = GlobalUIKitAnimationFactory.getScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, (float) (HomeNewTitleBarFragment.this.f39178f.getWidth() / 2), (float) (HomeNewTitleBarFragment.this.f39178f.getHeight() / 2), GlobalUIKitAnimationFactory.InterpolatorType.EASY_IN, false, true, 400, 0, 0, (Animation.AnimationListener) null);
                LogUtil.m29960d(HomeNewTitleBarFragment.f39173b, "redot's width=" + HomeNewTitleBarFragment.this.f39179g.getWidth());
                HomeNewTitleBarFragment.this.f39178f.startAnimation(scaleAnimation);
                HomeNewTitleBarFragment.this.f39179g.setText(remotionalMessageEvent.getText());
                HomeNewTitleBarFragment.this.f39179g.setVisibility(0);
                TranslateAnimation translateAnimation = GlobalUIKitAnimationFactory.getTranslateAnimation((float) (-HomeNewTitleBarFragment.this.f39179g.getWidth()), 0.0f, 0.0f, 0.0f, GlobalUIKitAnimationFactory.InterpolatorType.EASY_IN, false, true, 1000, 0, 0, (Animation.AnimationListener) null);
                LogUtil.m29960d(HomeNewTitleBarFragment.f39173b, "messsageTv" + HomeNewTitleBarFragment.this.f39179g.getWidth());
                translateAnimation.setDuration(1000);
                HomeNewTitleBarFragment.this.f39179g.startAnimation(translateAnimation);
                HomeNewTitleBarFragment.this.f39174a.postDelayed(new Runnable() {
                    public void run() {
                        HomeNewTitleBarFragment.this.f39179g.startAnimation(GlobalUIKitAnimationFactory.getTranslateAnimation(0.0f, (float) (-HomeNewTitleBarFragment.this.f39179g.getWidth()), 0.0f, 0.0f, GlobalUIKitAnimationFactory.InterpolatorType.EASY_IN, true, true, 1000, 0, 0, (Animation.AnimationListener) null));
                    }
                }, 3000);
            }
        }, 1000);
    }
}
