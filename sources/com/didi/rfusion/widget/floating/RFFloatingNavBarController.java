package com.didi.rfusion.widget.floating;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.config.RFusionConfig;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.floating.RFFloatingNavBarController;
import com.taxis99.R;

final class RFFloatingNavBarController {

    /* renamed from: a */
    private static final String f36314a = "RFFloatingNavBarControl";

    /* renamed from: b */
    private static final int f36315b = 100;

    /* renamed from: c */
    private static final int f36316c = 255;

    /* renamed from: d */
    private static C12383c f36317d = new C12383c((RFFloatingTextAttr) null, (RFFloatingIconAttr) null, (RFFloatingTextAttr) null, true, false, RFResUtils.getColor(R.color.rf_color_white_100_FFFFFF));
    /* access modifiers changed from: private */

    /* renamed from: e */
    public RFusionConfig.IRFusionLogger f36318e = RFLogger.getLogger();

    /* renamed from: f */
    private FloatingNavBar f36319f;

    /* renamed from: g */
    private View f36320g;

    /* renamed from: h */
    private SparseArray<C12383c> f36321h = new SparseArray<>();

    /* renamed from: i */
    private Integer f36322i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Integer f36323j;

    /* renamed from: k */
    private boolean f36324k = false;

    /* renamed from: l */
    private ValueAnimator f36325l;

    /* renamed from: m */
    private ValueAnimator f36326m;

    /* renamed from: n */
    private boolean f36327n = true;

    RFFloatingNavBarController() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94274a(View view) {
        this.f36319f = new FloatingNavBar((ViewGroup) view.findViewById(R.id.rf_fl_nav_bar_container));
        this.f36320g = view.findViewById(R.id.rf_nav_bar_shadow);
        this.f36324k = true;
        m27357c();
    }

    /* renamed from: c */
    private void m27357c() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 255});
        this.f36325l = ofInt;
        ofInt.setDuration(100);
        this.f36325l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFFloatingNavBarController.this.m27356b(valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{255, 0});
        this.f36326m = ofInt2;
        ofInt2.setDuration(100);
        this.f36326m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFFloatingNavBarController.this.m27351a(valueAnimator);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m27356b(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue == 0) {
            this.f36320g.setVisibility(0);
        }
        this.f36320g.getBackground().setAlpha(intValue);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27351a(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f36320g.getBackground().setAlpha(intValue);
        if (intValue == 255) {
            this.f36320g.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94272a(int i, C12383c cVar) {
        if (!m27361d(i)) {
            Integer num = this.f36322i;
            if (num != null) {
                this.f36321h.remove(num.intValue());
            }
            this.f36321h.put(i, cVar.clone());
            Integer valueOf = Integer.valueOf(i);
            this.f36322i = valueOf;
            if (this.f36323j == null) {
                mo94273a(valueOf.intValue(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94268a(int i) {
        if (!m27361d(i)) {
            this.f36321h.put(i, m27359d());
        }
    }

    /* renamed from: d */
    private C12383c m27359d() {
        C12383c cVar;
        Integer num = this.f36323j;
        if (num != null) {
            cVar = this.f36321h.get(num.intValue()).clone();
        } else {
            cVar = f36317d.clone();
            this.f36318e.info(f36314a, "createNavBarModel: curNavBarId is not exist");
        }
        cVar.f36346e = false;
        return cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94275b(int i) {
        Integer num = this.f36322i;
        if (num == null || i != num.intValue()) {
            this.f36321h.remove(i);
            Integer num2 = this.f36323j;
            if (num2 != null && num2.intValue() == i) {
                this.f36323j = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94273a(int i, boolean z) {
        C12383c f = m27365f(i);
        if (f != null) {
            Integer num = this.f36323j;
            if (num == null || num.intValue() != i) {
                Integer valueOf = Integer.valueOf(i);
                this.f36323j = valueOf;
                if (valueOf.equals(this.f36322i)) {
                    m27350a(i, true, f);
                } else if (this.f36327n) {
                    m27350a(i, true, f);
                    this.f36327n = false;
                } else {
                    m27350a(i, false, f);
                    this.f36319f.changeNavBar(z);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94267a() {
        this.f36319f.clear();
    }

    /* renamed from: a */
    private void m27350a(int i, boolean z, C12383c cVar) {
        m27355b(i, z, cVar);
        m27358c(i, z, cVar);
        m27360d(i, z, cVar);
        m27366f(i, z, cVar);
        m27363e(i, z, cVar);
        m27354b(i, cVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo94278b() {
        return this.f36322i != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94271a(int i, RFFloatingTextAttr rFFloatingTextAttr) {
        C12383c f = m27365f(i);
        if (f != null) {
            m27362e();
            f.f36342a = rFFloatingTextAttr;
            m27355b(i, true, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94270a(int i, RFFloatingIconAttr rFFloatingIconAttr) {
        C12383c f = m27365f(i);
        if (f != null) {
            m27362e();
            f.f36343b = rFFloatingIconAttr;
            m27358c(i, true, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94276b(int i, RFFloatingTextAttr rFFloatingTextAttr) {
        C12383c f = m27365f(i);
        if (f != null) {
            m27362e();
            f.f36344c = rFFloatingTextAttr;
            m27360d(i, true, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94277b(int i, boolean z) {
        C12383c f = m27365f(i);
        if (f != null) {
            m27362e();
            f.f36346e = z;
            m27354b(i, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94269a(int i, int i2) {
        C12383c f = m27365f(i);
        if (f != null) {
            m27362e();
            f.f36347f = i2;
            m27366f(i, true, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo94279c(int i, boolean z) {
        C12383c f = m27365f(i);
        if (f != null) {
            m27362e();
            f.f36345d = z;
            m27363e(i, true, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo94280c(int i) {
        C12383c f = m27365f(i);
        if (f == null) {
            return false;
        }
        m27362e();
        return f.f36345d;
    }

    /* renamed from: b */
    private void m27355b(int i, boolean z, C12383c cVar) {
        if (m27364e(i)) {
            m27352a(this.f36319f.getTitleView(z), (Object) cVar.f36342a);
        }
    }

    /* renamed from: c */
    private void m27358c(int i, boolean z, C12383c cVar) {
        if (m27364e(i)) {
            m27352a(this.f36319f.getLeftButton(z), (Object) cVar.f36343b);
        }
    }

    /* renamed from: d */
    private void m27360d(int i, boolean z, C12383c cVar) {
        if (m27364e(i)) {
            m27352a(this.f36319f.getRightButton(z), (Object) cVar.f36344c);
            this.f36319f.calculateNavBar(z);
        }
    }

    /* renamed from: a */
    private void m27352a(TextView textView, Object obj) {
        View.OnClickListener onClickListener;
        int i;
        String str;
        int i2 = 4;
        if (obj == null) {
            textView.setVisibility(4);
            textView.setOnClickListener((View.OnClickListener) null);
            textView.setText("");
            textView.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
            return;
        }
        if (obj instanceof RFFloatingTextAttr) {
            RFFloatingTextAttr rFFloatingTextAttr = (RFFloatingTextAttr) obj;
            str = rFFloatingTextAttr.f36328a;
            i = rFFloatingTextAttr.f36329b;
            onClickListener = rFFloatingTextAttr.f36330c;
        } else if (obj instanceof RFFloatingIconAttr) {
            RFFloatingIconAttr rFFloatingIconAttr = (RFFloatingIconAttr) obj;
            str = rFFloatingIconAttr.getIcon();
            i = rFFloatingIconAttr.f36312b;
            onClickListener = rFFloatingIconAttr.f36313c;
        } else {
            onClickListener = null;
            str = null;
            i = -1;
        }
        if (!TextUtils.isEmpty(str)) {
            i2 = 0;
        }
        textView.setVisibility(i2);
        textView.setText(str);
        if (i > 0) {
            textView.setTextColor(i);
        } else {
            textView.setTextColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
        }
        if (onClickListener == null) {
            textView.setOnClickListener((View.OnClickListener) null);
        } else {
            textView.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: b */
    private void m27354b(int i, C12383c cVar) {
        if (m27364e(i)) {
            if (cVar.f36346e != (this.f36320g.getVisibility() == 0) && cVar.f36345d) {
                this.f36325l.cancel();
                this.f36326m.cancel();
                if (cVar.f36346e) {
                    this.f36325l.start();
                } else {
                    this.f36326m.start();
                }
            }
        }
    }

    /* renamed from: e */
    private void m27363e(int i, boolean z, C12383c cVar) {
        if (m27364e(i)) {
            int i2 = 0;
            this.f36319f.getNavBar(z).setVisibility(cVar.f36345d ? 0 : 8);
            if (cVar.f36346e) {
                View view = this.f36320g;
                if (!cVar.f36345d) {
                    i2 = 8;
                }
                view.setVisibility(i2);
            }
        }
    }

    /* renamed from: f */
    private void m27366f(int i, boolean z, C12383c cVar) {
        if (m27364e(i)) {
            this.f36319f.getNavBar(z).setBackgroundColor(cVar.f36347f);
        }
    }

    /* renamed from: e */
    private void m27362e() {
        if (!this.f36324k) {
            throw new RuntimeException("Please use RFFloatingNavBar between onCreate() and onDestroy ()");
        }
    }

    /* renamed from: d */
    private boolean m27361d(int i) {
        return this.f36321h.indexOfKey(i) >= 0;
    }

    /* renamed from: e */
    private boolean m27364e(int i) {
        Integer num = this.f36323j;
        if (num != null && num.intValue() == i) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private C12383c m27365f(int i) {
        return this.f36321h.get(i);
    }

    private class FloatingNavBar {
        private static final String TAG_NAV_BAR = "tag_nav_bar";
        private static final int WHAT_ANIM_START = 1000;
        /* access modifiers changed from: private */
        public AnimatorSet mAnimatorSet;
        private ViewGroup mFromNavBar;
        private Handler mHandler = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1000 && FloatingNavBar.this.mAnimatorSet != null) {
                    FloatingNavBar.this.mAnimatorSet.start();
                }
            }
        };
        /* access modifiers changed from: private */
        public ViewGroup mParent;
        private ViewGroup mToNavBar;

        public FloatingNavBar(ViewGroup viewGroup) {
            this.mParent = viewGroup;
            this.mFromNavBar = createNavBarView(viewGroup);
            this.mToNavBar = createNavBarView(viewGroup);
            viewGroup.addView(this.mFromNavBar);
        }

        private ViewGroup createNavBarView(ViewGroup viewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rf_floating_nav_bar, viewGroup, false);
            viewGroup2.setTag(TAG_NAV_BAR);
            viewGroup2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    RFFloatingNavBarController.FloatingNavBar.this.mo94287x9e3266ea(view, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
            return viewGroup2;
        }

        /* renamed from: lambda$createNavBarView$0$RFFloatingNavBarController$FloatingNavBar */
        public /* synthetic */ void mo94287x9e3266ea(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            calculateNavBar(view);
        }

        /* access modifiers changed from: private */
        public ViewGroup getNavBar(boolean z) {
            return z ? this.mFromNavBar : this.mToNavBar;
        }

        public TextView getTitleView(boolean z) {
            return getTitleView((View) getNavBar(z));
        }

        private TextView getTitleView(View view) {
            return (TextView) view.findViewById(R.id.rf_tv_title);
        }

        public TextView getLeftButton(boolean z) {
            return getLeftButton((View) getNavBar(z));
        }

        private TextView getLeftButton(View view) {
            return (TextView) view.findViewById(R.id.rf_tv_left_btn);
        }

        public TextView getRightButton(boolean z) {
            return getRightButton((View) getNavBar(z));
        }

        private TextView getRightButton(View view) {
            return (TextView) view.findViewById(R.id.rf_tv_right_btn);
        }

        public void changeNavBar(boolean z) {
            RFusionConfig.IRFusionLogger b = RFFloatingNavBarController.this.f36318e;
            b.info("changeNavBar", "change:" + RFFloatingNavBarController.this.f36323j);
            startChangeAnim(z);
            changeNavBarInternal();
        }

        private void startChangeAnim(final boolean z) {
            final ViewGroup navBar = getNavBar(true);
            final ViewGroup navBar2 = getNavBar(false);
            if (this.mHandler.hasMessages(1000)) {
                this.mHandler.removeMessages(1000);
                if (!isAnimRunning()) {
                    this.mAnimatorSet.start();
                    this.mAnimatorSet.end();
                }
            }
            if (isAnimRunning()) {
                this.mAnimatorSet.end();
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimatorSet = animatorSet;
            if (z) {
                animatorSet.play(ObjectAnimator.ofFloat(navBar, View.TRANSLATION_X, new float[]{(float) (-this.mParent.getMeasuredWidth())}));
                this.mAnimatorSet.play(ObjectAnimator.ofFloat(navBar2, View.TRANSLATION_X, new float[]{(float) this.mParent.getMeasuredWidth(), 0.0f}));
            } else {
                animatorSet.play(ObjectAnimator.ofFloat(navBar, View.TRANSLATION_X, new float[]{(float) this.mParent.getMeasuredWidth()}));
                this.mAnimatorSet.play(ObjectAnimator.ofFloat(navBar2, View.TRANSLATION_X, new float[]{(float) (-this.mParent.getMeasuredWidth()), 0.0f}));
            }
            this.mAnimatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    FloatingNavBar.this.mParent.addView(navBar2);
                    RFFloatingNavBarController.this.f36318e.info(RFFloatingNavBarController.f36314a, "onAnimationStart");
                }

                public void onAnimationEnd(Animator animator) {
                    RFFloatingNavBarController.this.f36318e.info(RFFloatingNavBarController.f36314a, "onAnimationEnd");
                    navBar2.setTranslationX(0.0f);
                    navBar.setTranslationX((float) (z ? -FloatingNavBar.this.mParent.getMeasuredWidth() : FloatingNavBar.this.mParent.getMeasuredWidth()));
                    FloatingNavBar.this.mParent.removeView(navBar);
                }
            });
            this.mHandler.sendEmptyMessage(1000);
        }

        /* access modifiers changed from: protected */
        public void calculateNavBar(boolean z) {
            calculateNavBar((View) getNavBar(z));
        }

        private void calculateNavBar(View view) {
            Object tag = view.getTag();
            if (view.getParent() != null && (tag instanceof String) && TextUtils.equals((String) tag, TAG_NAV_BAR)) {
                TextView titleView = getTitleView(view);
                TextView leftButton = getLeftButton(view);
                TextView rightButton = getRightButton(view);
                int measuredWidth = leftButton.getMeasuredWidth() + ((int) RFResUtils.getDimens(R.dimen.rf_dimen_48));
                int measuredWidth2 = view.getMeasuredWidth() - (view.getPaddingLeft() + view.getPaddingRight());
                int max = rightButton.getVisibility() == 0 ? measuredWidth2 - (Math.max(measuredWidth, rightButton.getMeasuredWidth() + ((int) RFResUtils.getDimens(R.dimen.rf_dimen_48))) * 2) : measuredWidth2 - (measuredWidth * 2);
                ViewGroup.LayoutParams layoutParams = titleView.getLayoutParams();
                if (layoutParams.width != max) {
                    layoutParams.width = max;
                    titleView.setLayoutParams(layoutParams);
                    RFusionConfig.IRFusionLogger b = RFFloatingNavBarController.this.f36318e;
                    StringBuilder sb = new StringBuilder();
                    sb.append("calculateNavBar: rightButton visible = ");
                    sb.append(rightButton.getVisibility() == 0);
                    sb.append(" resultTitleSpace = ");
                    sb.append(max);
                    b.info(RFFloatingNavBarController.f36314a, sb.toString());
                }
            }
        }

        private void changeNavBarInternal() {
            ViewGroup viewGroup = this.mFromNavBar;
            this.mFromNavBar = this.mToNavBar;
            this.mToNavBar = viewGroup;
        }

        private boolean isAnimRunning() {
            AnimatorSet animatorSet = this.mAnimatorSet;
            return animatorSet != null && animatorSet.isRunning();
        }

        public void clear() {
            this.mHandler.removeCallbacksAndMessages((Object) null);
        }
    }
}
