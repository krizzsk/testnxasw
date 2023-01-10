package com.didi.component.bubbleLayout.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.bubbleLayout.anycar.AnycarBubbleLayout;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.animator.GlobalXPanelAnimatorImpl;
import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class BubbleAnimationLayout extends RelativeLayout {

    /* renamed from: d */
    private static final String f12967d = "BubbleLayout";

    /* renamed from: e */
    private static final int f12968e = 1;

    /* renamed from: f */
    private static final int f12969f = 2;

    /* renamed from: g */
    private static final int f12970g = 3;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f12971A;

    /* renamed from: B */
    private int f12972B;

    /* renamed from: C */
    private AppCompatTextView f12973C;

    /* renamed from: D */
    private boolean f12974D;

    /* renamed from: E */
    private boolean f12975E;

    /* renamed from: F */
    private AnycarBubbleLayout f12976F;

    /* renamed from: G */
    private boolean f12977G;

    /* renamed from: a */
    int f12978a;

    /* renamed from: b */
    int f12979b;

    /* renamed from: c */
    int f12980c;

    /* renamed from: h */
    private int f12981h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f12982i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f12983j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f12984k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View f12985l;

    /* renamed from: m */
    private RecyclerView f12986m;

    /* renamed from: n */
    private IGlobalXPanelAnimator f12987n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f12988o;

    /* renamed from: p */
    private int f12989p;

    /* renamed from: q */
    private float f12990q;

    /* renamed from: r */
    private float f12991r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f12992s;

    /* renamed from: t */
    private final int f12993t;

    /* renamed from: u */
    private final int f12994u;

    /* renamed from: v */
    private final int f12995v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f12996w;

    /* renamed from: x */
    private boolean f12997x;

    /* renamed from: y */
    private IGlobalXPanelAnimator.VisibilityChangedListener f12998y;

    /* renamed from: z */
    private VelocityTracker f12999z;

    public static class StaticConfig {
        public static int AUTO_RECOVER_DURATION = 500;
        public static int FAULT_OFFSET = 5;
        public static int PULL_GUIDE_DURATION = 800;
        public static int PULL_UP_DURATION = 400;
        public static int TOUCH_THRESHOLD_Y_PIX = 7;
        public static int TOUCH_VELOCITY_THRESHOLD_AUTO_SCROLL = 100;
        public static int TOUCH_Y_THRESHOLD_AUTO_SCROLL = 150;
    }

    private int getLayoutId() {
        return R.layout.bubble_overlay_view;
    }

    public BubbleAnimationLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public BubbleAnimationLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleAnimationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12988o = 0;
        this.f12989p = 0;
        this.f12992s = UiUtils.dip2px(getContext(), 129.0f);
        this.f12993t = UiUtils.dip2px(getContext(), 80.0f);
        this.f12994u = UiUtils.dip2px(getContext(), 13.0f);
        this.f12995v = UiUtils.dip2px(getContext(), 22.0f);
        this.f12996w = 2;
        this.f12997x = false;
        this.f12971A = false;
        this.f12972B = 0;
        this.f12978a = 0;
        this.f12979b = 0;
        this.f12980c = 0;
        this.f12977G = true;
        m10947a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f12989p = getMeasuredHeight();
    }

    /* renamed from: a */
    private void m10947a() {
        StaticConfig.TOUCH_THRESHOLD_Y_PIX = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f12987n = new GlobalXPanelAnimatorImpl();
        this.f12999z = VelocityTracker.obtain();
        this.f12998y = new IGlobalXPanelAnimator.VisibilityChangedListener() {
            public void onHidden() {
            }

            public void onHiddenStart() {
            }

            public void onShownStart() {
            }

            public void onShown() {
                BubbleAnimationLayout.this.m10979m();
            }
        };
    }

    public void bindAnycarView(AnycarBubbleLayout anycarBubbleLayout) {
        this.f12976F = anycarBubbleLayout;
    }

    public void bindView(View view, View view2, View view3, View view4) {
        this.f12982i = view;
        this.f12983j = view2;
        this.f12984k = view3;
        view2.post(new Runnable() {
            public void run() {
                GLog.m11354d(BubbleAnimationLayout.f12967d, "run: mFormView.getMeasuredHeight  = " + BubbleAnimationLayout.this.f12983j.getMeasuredHeight());
                if (!FormStore.getInstance().ismGroupFormViewChanged()) {
                    BubbleAnimationLayout bubbleAnimationLayout = BubbleAnimationLayout.this;
                    int unused = bubbleAnimationLayout.f12992s = bubbleAnimationLayout.f12983j.getMeasuredHeight();
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.f12982i.findViewById(R.id.new_estimate_all_list);
        this.f12986m = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false) {
                public boolean canScrollVertically() {
                    return BubbleAnimationLayout.this.f12996w == 1 || BubbleAnimationLayout.this.f12996w == 3;
                }
            });
        }
        m10956b();
    }

    public void hideViewByAnycar() {
        this.f12983j.setVisibility(8);
        this.f12984k.setVisibility(8);
        this.f12982i.setVisibility(8);
        setPadding(0, 0, 0, 0);
    }

    public void hideAnycarByOldEstimate() {
        int i = this.f12988o;
        if (i == 0 || i == 1) {
            this.f12984k.setVisibility(8);
            this.f12983j.setVisibility(0);
            this.f12982i.setVisibility(0);
            setPadding(0, UiUtils.dip2px(getContext(), 10.0f), 0, 0);
        }
    }

    /* renamed from: b */
    private void m10956b() {
        RecyclerView recyclerView = this.f12986m;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                }

                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    GLog.m11354d(BubbleAnimationLayout.f12967d, "onScrollStateChanged: " + i);
                    if (i == 0) {
                        if (recyclerView.computeVerticalScrollOffset() <= 0) {
                            int unused = BubbleAnimationLayout.this.f12996w = 1;
                        } else {
                            int unused2 = BubbleAnimationLayout.this.f12996w = 3;
                        }
                        GLog.m11354d(BubbleAnimationLayout.f12967d, "state赋值199: " + BubbleAnimationLayout.this.f12996w);
                    }
                }
            });
        }
    }

    public void setTopOffsetY(int i) {
        this.f12981h = i;
        m10960c();
    }

    public void setBottomCardHeight(int i) {
        this.f12992s = i;
        m10960c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10960c() {
        if (this.f12996w == 2) {
            m10961d();
            post(new Runnable() {
                public void run() {
                    BubbleAnimationLayout.this.m10979m();
                }
            });
        }
    }

    public void setCanPullUp(boolean z) {
        this.f12997x = z;
    }

    /* renamed from: d */
    private void m10961d() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12982i.getLayoutParams();
        marginLayoutParams.topMargin = getPullDownStateMargin();
        this.f12982i.setLayoutParams(marginLayoutParams);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (m10965e() || motionEvent.getRawY() <= ((float) this.f12993t)) {
            return false;
        }
        if ((this.f12983j.getVisibility() == 0 && motionEvent.getRawY() >= ((float) (this.f12989p - this.f12992s))) || this.f12971A || this.f12988o != 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            float y = motionEvent.getY();
            this.f12990q = y;
            this.f12991r = y;
        } else if (action == 2) {
            GLog.m11354d(f12967d, "move, state: " + this.f12996w);
            float y2 = motionEvent.getY();
            int i = this.f12996w;
            if (i == 3) {
                return false;
            }
            if (i == 1) {
                if (Math.abs(y2 - this.f12990q) > ((float) StaticConfig.TOUCH_THRESHOLD_Y_PIX)) {
                    float f = this.f12990q;
                    if (f - y2 < 0.0f) {
                        return true;
                    }
                    if (f - y2 > 0.0f) {
                        this.f12996w = 3;
                        GLog.m11354d(f12967d, "state赋值292: " + this.f12996w);
                        return false;
                    }
                }
            } else if (Math.abs(y2 - this.f12990q) > ((float) StaticConfig.TOUCH_THRESHOLD_Y_PIX)) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0077, code lost:
        if (r0 != 4) goto L_0x00db;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.m10965e()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r9.f12988o
            r2 = 2
            r3 = 3
            r4 = 1
            if (r0 == r3) goto L_0x0011
            if (r0 != r2) goto L_0x0020
        L_0x0011:
            float r0 = r10.getRawY()
            int r5 = r9.f12989p
            int r6 = r9.f12972B
            int r5 = r5 - r6
            float r5 = (float) r5
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0020
            return r4
        L_0x0020:
            int r0 = r9.f12988o
            if (r0 == r4) goto L_0x0025
            return r1
        L_0x0025:
            float r0 = r10.getRawY()
            int r5 = r9.f12993t
            float r5 = (float) r5
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0041
            boolean r0 = r9.f12974D
            if (r0 == 0) goto L_0x003c
            r9.f12974D = r1
            r9.f12975E = r1
            r9.m10951a((android.view.MotionEvent) r10)
            goto L_0x0041
        L_0x003c:
            boolean r10 = super.onTouchEvent(r10)
            return r10
        L_0x0041:
            android.view.View r0 = r9.f12983j
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0063
            float r0 = r10.getRawY()
            int r5 = r9.f12989p
            int r6 = r9.f12992s
            int r5 = r5 - r6
            float r5 = (float) r5
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0063
            boolean r0 = r9.f12974D
            if (r0 == 0) goto L_0x0062
            r9.f12974D = r1
            r9.f12975E = r1
            r9.m10951a((android.view.MotionEvent) r10)
        L_0x0062:
            return r4
        L_0x0063:
            boolean r0 = r9.f12971A
            if (r0 == 0) goto L_0x0068
            return r4
        L_0x0068:
            boolean r0 = r9.f12997x
            if (r0 == 0) goto L_0x00db
            int r0 = r10.getAction()
            if (r0 == r4) goto L_0x00d4
            if (r0 == r2) goto L_0x007a
            if (r0 == r3) goto L_0x00d4
            r2 = 4
            if (r0 == r2) goto L_0x00d4
            goto L_0x00db
        L_0x007a:
            r9.f12974D = r4
            float r0 = r10.getY()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onTouchEvent: move = "
            r1.append(r2)
            float r2 = r9.f12991r
            float r2 = r0 - r2
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "BubbleLayout"
            com.didi.component.common.util.GLog.m11354d(r2, r1)
            float r1 = r9.f12991r
            float r1 = r0 - r1
            double r5 = (double) r1
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r5 = r5 + r7
            int r1 = (int) r5
            r9.m10949a((int) r1)
            r9.f12991r = r0
            boolean r0 = r9.f12975E
            if (r0 != 0) goto L_0x00db
            if (r1 > 0) goto L_0x00db
            r9.f12975E = r4
            com.didi.component.core.event.BaseEventPublisher r0 = com.didi.component.core.event.BaseEventPublisher.getPublisher()
            r5 = 8
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "event_confirm_sense_top_window_visibility"
            r0.publish(r6, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY "
            r0.append(r5)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.didi.component.common.util.GLog.m11354d(r2, r0)
            goto L_0x00db
        L_0x00d4:
            r9.m10951a((android.view.MotionEvent) r10)
            r9.f12975E = r1
            r9.f12974D = r1
        L_0x00db:
            int r0 = r9.f12996w
            if (r0 == r4) goto L_0x00f6
            if (r0 == r3) goto L_0x00f6
            float r0 = r10.getY()
            android.view.View r1 = r9.f12982i
            int r1 = r1.getTop()
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00f1
            goto L_0x00f6
        L_0x00f1:
            boolean r10 = super.onTouchEvent(r10)
            return r10
        L_0x00f6:
            android.view.VelocityTracker r0 = r9.f12999z
            r0.addMovement(r10)
            android.view.VelocityTracker r10 = r9.f12999z
            r10.getYVelocity()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.bubbleLayout.view.BubbleAnimationLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: e */
    private boolean m10965e() {
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            return PageCompDataTransfer.getInstance().getConfirmListener().getIsAnyCar();
        }
        return false;
    }

    public void showEstimatePage() {
        final ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        int i = this.f12988o;
        if (i == 0) {
            this.f12984k.setVisibility(8);
            m10969g();
            AnycarBubbleLayout anycarBubbleLayout = this.f12976F;
            if (anycarBubbleLayout != null) {
                anycarBubbleLayout.setVisibility(0);
                this.f12976F.showEstimateWithAnimation(true);
            }
            this.f12988o = 1;
            if (confirmListener != null) {
                confirmListener.setCurrentPage(1);
            }
        } else if (i != 3) {
        } else {
            if (m10965e()) {
                this.f12976F.setVisibility(0);
                this.f12976F.showEstimateWithAnimation(false);
                this.f12984k.setVisibility(8);
                this.f12988o = 1;
                if (confirmListener != null) {
                    confirmListener.setCurrentPage(1);
                    return;
                }
                return;
            }
            this.f12982i.setVisibility(4);
            post(new Runnable() {
                public void run() {
                    if (BubbleAnimationLayout.this.m10967f()) {
                        int unused = BubbleAnimationLayout.this.f12988o = 1;
                        ConfirmListener confirmListener = confirmListener;
                        if (confirmListener != null) {
                            confirmListener.setCurrentPage(BubbleAnimationLayout.this.f12988o);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m10967f() {
        if (this.f12985l == null) {
            this.f12985l = LayoutInflater.from(getContext()).inflate(getLayoutId(), this, false);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.f12985l.findViewById(R.id.form_btn);
        this.f12973C = appCompatTextView;
        appCompatTextView.setText(R.string.global_confirm_btn);
        if (this.f12985l.getParent() != null) {
            return false;
        }
        this.f12978a = this.f12984k.getMeasuredHeight();
        this.f12979b = this.f12982i.getMeasuredHeight() - UiUtils.dip2px(getContext(), 10.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f12978a);
        layoutParams.addRule(12);
        addView(this.f12985l, layoutParams);
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{this.f12978a, this.f12979b}).setDuration((long) StaticConfig.PULL_UP_DURATION);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GLog.m11354d(BubbleAnimationLayout.f12967d, "onAnimationUpdate: " + valueAnimator.getAnimatedValue());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BubbleAnimationLayout.this.f12985l.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BubbleAnimationLayout.this.f12985l.setLayoutParams(layoutParams);
            }
        });
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BubbleAnimationLayout.this.f12984k.setVisibility(8);
                BubbleAnimationLayout.this.f12982i.setVisibility(0);
                BubbleAnimationLayout.this.f12983j.setVisibility(0);
                BubbleAnimationLayout bubbleAnimationLayout = BubbleAnimationLayout.this;
                bubbleAnimationLayout.removeView(bubbleAnimationLayout.f12985l);
                BubbleAnimationLayout.this.m10979m();
            }
        });
        duration.start();
        return true;
    }

    private int getPullDownStateMargin() {
        return (this.f12989p - this.f12981h) - this.f12992s;
    }

    /* renamed from: g */
    private void m10969g() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12982i.getLayoutParams();
        marginLayoutParams.topMargin = getPullDownStateMargin();
        this.f12982i.setLayoutParams(marginLayoutParams);
        setTranslationY((float) (this.f12981h + this.f12992s));
        showBottomCard();
        this.f12982i.setVisibility(0);
        post(new Runnable() {
            public void run() {
                final ViewPropertyAnimator animate = BubbleAnimationLayout.this.animate();
                animate.translationY(0.0f);
                animate.setDuration((long) StaticConfig.PULL_UP_DURATION);
                animate.setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        animate.setListener((Animator.AnimatorListener) null);
                        if (!GlobalSPUtil.isShowBubblePullGuide(BubbleAnimationLayout.this.getContext())) {
                            BubbleAnimationLayout.this.m10979m();
                        }
                        BubbleAnimationLayout.this.m10960c();
                    }
                });
                animate.start();
            }
        });
    }

    public void showConfirmAddressPage() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (this.f12988o != 1) {
            this.f12983j.setVisibility(8);
            this.f12982i.setVisibility(8);
            AnycarBubbleLayout anycarBubbleLayout = this.f12976F;
            if (anycarBubbleLayout != null) {
                anycarBubbleLayout.setVisibility(8);
            }
            this.f12987n.initPrepare(this.f12984k);
            this.f12987n.show(this.f12984k, 0, this.f12998y);
            this.f12988o = 3;
            if (confirmListener != null) {
                confirmListener.setCurrentPage(3);
                return;
            }
            return;
        }
        if (confirmListener != null) {
            confirmListener.updateAlpha(1.0f);
        }
        AnycarBubbleLayout anycarBubbleLayout2 = this.f12976F;
        if (anycarBubbleLayout2 != null) {
            anycarBubbleLayout2.setVisibility(8);
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.EVENT_ESTIMATE_IS_ONE_CAR, false);
        if (m10971h()) {
            this.f12988o = 3;
            if (confirmListener != null) {
                confirmListener.setCurrentPage(3);
            }
        }
    }

    /* renamed from: h */
    private boolean m10971h() {
        if (this.f12985l == null) {
            this.f12985l = LayoutInflater.from(getContext()).inflate(getLayoutId(), this, false);
        }
        if (this.f12985l.getParent() != null) {
            return false;
        }
        this.f12984k.setVisibility(4);
        this.f12984k.post(new Runnable() {
            public void run() {
                BubbleAnimationLayout bubbleAnimationLayout = BubbleAnimationLayout.this;
                bubbleAnimationLayout.f12978a = bubbleAnimationLayout.f12984k.getMeasuredHeight();
                BubbleAnimationLayout bubbleAnimationLayout2 = BubbleAnimationLayout.this;
                bubbleAnimationLayout2.f12979b = bubbleAnimationLayout2.f12982i.getMeasuredHeight() - UiUtils.dip2px(BubbleAnimationLayout.this.getContext(), 4.0f);
                BubbleAnimationLayout.this.f12982i.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BubbleAnimationLayout.this.f12979b);
                layoutParams.addRule(12);
                BubbleAnimationLayout bubbleAnimationLayout3 = BubbleAnimationLayout.this;
                bubbleAnimationLayout3.addView(bubbleAnimationLayout3.f12985l, layoutParams);
                BubbleAnimationLayout.this.m10972i();
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m10972i() {
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{this.f12979b, this.f12978a}).setDuration((long) StaticConfig.PULL_UP_DURATION);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GLog.m11354d(BubbleAnimationLayout.f12967d, "onAnimationUpdate: " + valueAnimator.getAnimatedValue());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BubbleAnimationLayout.this.f12985l.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BubbleAnimationLayout.this.f12985l.setLayoutParams(layoutParams);
            }
        });
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BubbleAnimationLayout.this.f12984k.setVisibility(0);
                BubbleAnimationLayout.this.f12982i.setVisibility(8);
                BubbleAnimationLayout.this.f12983j.setVisibility(8);
                BubbleAnimationLayout bubbleAnimationLayout = BubbleAnimationLayout.this;
                bubbleAnimationLayout.removeView(bubbleAnimationLayout.f12985l);
                BubbleAnimationLayout.this.m10979m();
            }
        });
        duration.start();
    }

    public void hideAndShow() {
        int i = this.f12996w;
        if (i != 2 && i != 0) {
            scrollToBottom();
        }
    }

    /* renamed from: a */
    private void m10951a(MotionEvent motionEvent) {
        m10974j();
        int currentMarginTop = getCurrentMarginTop();
        this.f12999z.computeCurrentVelocity(1000);
        if (this.f12999z.getYVelocity() > ((float) StaticConfig.TOUCH_VELOCITY_THRESHOLD_AUTO_SCROLL)) {
            if (motionEvent.getY() - this.f12990q > ((float) (StaticConfig.TOUCH_Y_THRESHOLD_AUTO_SCROLL / 3))) {
                scrollToBottom();
                return;
            } else if (this.f12990q - motionEvent.getY() > ((float) (StaticConfig.TOUCH_Y_THRESHOLD_AUTO_SCROLL / 3))) {
                scrollToTop();
                return;
            }
        }
        if (motionEvent.getY() - this.f12990q > ((float) StaticConfig.TOUCH_Y_THRESHOLD_AUTO_SCROLL)) {
            scrollToBottom();
        } else if (this.f12990q - motionEvent.getY() > ((float) StaticConfig.TOUCH_Y_THRESHOLD_AUTO_SCROLL)) {
            scrollToTop();
        } else if (currentMarginTop > (this.f12989p * 3) / 10) {
            scrollToBottom();
        } else {
            scrollToTop();
        }
    }

    /* renamed from: j */
    private void m10974j() {
        HashMap hashMap = new HashMap();
        String estimateModelTraceId = FormStore.getInstance().getEstimateModelTraceId();
        if (estimateModelTraceId != null) {
            hashMap.put(ParamConst.TRACE_ID, estimateModelTraceId);
        }
        OmegaSDKAdapter.trackEvent("gp_orderconfirm_modeXpanel_sp", (Map<String, Object>) hashMap);
    }

    public void scrollToTop() {
        m10950a(-getCurrentMarginTop(), -0.5f, true);
        traceTopEvent();
    }

    public void traceTopEvent() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        HashMap hashMap = new HashMap();
        if (newEstimateItem.carConfig != null) {
            hashMap.put("bubble_id", newEstimateItem.carConfig.estimateId);
        }
        hashMap.put("estimate_trace_id", FormStore.getInstance().getEstimateModelTraceId());
        hashMap.put("info_list", FormStore.getInstance().getInfoList());
        GlobalOmegaUtils.trackEvent("gp_orderconfirm_modeList_sw");
    }

    public void scrollToBottom() {
        m10950a(getPullDownStateMargin() - getCurrentMarginTop(), 0.5f, false);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, 0);
    }

    /* renamed from: a */
    private void m10950a(final int i, final float f, final boolean z) {
        long abs = (long) (this.f12989p != 0 ? (StaticConfig.AUTO_RECOVER_DURATION * Math.abs(i)) / this.f12989p : StaticConfig.AUTO_RECOVER_DURATION);
        this.f12980c = 0;
        GLog.m11354d(f12967d, "performScrollAnimation: 时长 " + abs);
        this.f12971A = true;
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(abs);
        duration.setInterpolator(new TimeInterpolator() {
            public float getInterpolation(float f) {
                return ((-f) * f) + (f * 2.0f);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) i)) + f);
                GLog.m11354d(BubbleAnimationLayout.f12967d, "onAnimationUpdate: currentY " + floatValue);
                BubbleAnimationLayout bubbleAnimationLayout = BubbleAnimationLayout.this;
                bubbleAnimationLayout.m10949a(floatValue - bubbleAnimationLayout.f12980c);
                BubbleAnimationLayout.this.f12980c = floatValue;
            }
        });
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = BubbleAnimationLayout.this.f12971A = false;
                if (z) {
                    BubbleAnimationLayout.this.m10976k();
                } else {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_BOTTOM);
                }
                BubbleAnimationLayout.this.m10979m();
            }
        });
        duration.start();
    }

    private int getCurrentMarginTop() {
        return ((ViewGroup.MarginLayoutParams) this.f12982i.getLayoutParams()).topMargin;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10949a(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12982i.getLayoutParams();
        marginLayoutParams.topMargin += i;
        if (marginLayoutParams.topMargin < 0) {
            marginLayoutParams.topMargin = 0;
        }
        if (marginLayoutParams.topMargin <= (-(this.f12981h - this.f12993t)) + StaticConfig.FAULT_OFFSET) {
            marginLayoutParams.topMargin = -(this.f12981h - this.f12993t);
            m10976k();
        }
        if (marginLayoutParams.topMargin >= getPullDownStateMargin() - StaticConfig.FAULT_OFFSET) {
            marginLayoutParams.topMargin = getPullDownStateMargin();
            m10957b(i);
            if (FormStore.getInstance().getNewEstimateItem() != null) {
                showBottomCard();
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_TOP_MARGIN_CHANGED, true);
            }
        }
        if (marginLayoutParams.topMargin < getPullDownStateMargin() - this.f12994u) {
            hideBottomCard();
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_TOP_MARGIN_CHANGED, false);
        }
        this.f12982i.setLayoutParams(marginLayoutParams);
        m10978l();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, Integer.valueOf(this.f12981h));
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m10976k() {
        GLog.m11354d(f12967d, "onPullToTop: ");
        this.f12996w = 1;
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_TOP);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, 8);
    }

    /* renamed from: b */
    private void m10957b(int i) {
        GLog.m11354d(f12967d, "onPullToBottom: ");
        this.f12996w = 2;
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_BOTTOM);
        if (this.f12988o == 1 && this.f12972B != 0 && i > 0) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Location.EVENT_BEST_VIEW);
        }
    }

    /* renamed from: l */
    private void m10978l() {
        float currentMarginTop = (((float) getCurrentMarginTop()) - ((float) this.f12993t)) / ((float) (getPullDownStateMargin() - this.f12993t));
        if (currentMarginTop < 0.0f) {
            currentMarginTop = 0.0f;
        } else if (currentMarginTop > 1.0f) {
            currentMarginTop = 1.0f;
        }
        m10948a(currentMarginTop);
    }

    /* renamed from: a */
    private void m10948a(float f) {
        int i = 128 - ((int) (128.0f * f));
        setBackgroundColor(Color.argb(i, 0, 0, 0));
        if (i >= 180 && this.f12977G) {
            this.f12977G = false;
        } else if (i < 180 && !this.f12977G) {
            this.f12977G = true;
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_RECOMMAND_SLIDE, Float.valueOf(f));
    }

    public void hideBottomCard() {
        if (this.f12983j.getVisibility() != 8) {
            this.f12983j.setVisibility(8);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_BOTTOM_FORM_HINTED);
        }
    }

    public void showBottomCard() {
        if (this.f12983j.getVisibility() != 0) {
            this.f12983j.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m10979m() {
        Integer num = 0;
        int i = this.f12988o;
        if (i == 1) {
            num = Integer.valueOf((this.f12981h + this.f12992s) - this.f12995v);
        } else if (i == 3) {
            num = Integer.valueOf(this.f12984k.getMeasuredHeight());
        }
        this.f12972B = num.intValue();
        GLog.m11354d(f12967d, "onDefaultHeightChanged: " + num);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, num);
    }

    public void refreshBestView() {
        m10979m();
    }
}
