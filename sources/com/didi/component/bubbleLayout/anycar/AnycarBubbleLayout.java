package com.didi.component.bubbleLayout.anycar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.bubbleLayout.anycar.AanycarAbnormalView;
import com.didi.component.bubbleLayout.anycar.AnycarEstimatePanelLayout;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGlobalConfig;
import com.didi.travel.psnger.model.response.anycar.AnyCarResponse;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.didi.travel.psnger.model.response.estimate.EstimateAbnormalModel;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnycarBubbleLayout extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f12850A = (UiUtils.dip2px(getContext(), 70.0f) + UiUtils.getStatusBarHeight(getContext()));

    /* renamed from: B */
    private LinearLayout f12851B;

    /* renamed from: C */
    private TextView f12852C;

    /* renamed from: D */
    private FrameLayout f12853D;

    /* renamed from: E */
    private LinearLayout f12854E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public LinearLayout f12855F;

    /* renamed from: G */
    private TextView f12856G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public RelativeLayout f12857H;

    /* renamed from: I */
    private TextView f12858I;

    /* renamed from: J */
    private TextView f12859J;

    /* renamed from: K */
    private TextView f12860K;

    /* renamed from: L */
    private ImageView f12861L;

    /* renamed from: M */
    private ImageView f12862M;

    /* renamed from: N */
    private LinearLayout f12863N;

    /* renamed from: O */
    private LinearLayout f12864O;

    /* renamed from: P */
    private ImageView f12865P;

    /* renamed from: Q */
    private TextView f12866Q;

    /* renamed from: R */
    private TextView f12867R;

    /* renamed from: S */
    private ImageView f12868S;

    /* renamed from: T */
    private ImageView f12869T;

    /* renamed from: U */
    private LinearLayout f12870U;

    /* renamed from: V */
    private LinearLayout f12871V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public int f12872W;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public int f12873X;

    /* renamed from: Y */
    private boolean f12874Y = false;

    /* renamed from: Z */
    private View f12875Z;

    /* renamed from: a */
    int f12876a = UiUtils.dip2px(getContext(), 110.0f);

    /* renamed from: aa */
    private View f12877aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public AanycarAbnormalView f12878ab;

    /* renamed from: ac */
    private boolean f12879ac = false;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f12880ad = 0;

    /* renamed from: ae */
    private final int f12881ae = UiUtils.dip2px(getContext(), 40.0f);

    /* renamed from: af */
    private final int f12882af = UiUtils.dip2px(getContext(), 90.0f);

    /* renamed from: ag */
    private int f12883ag = 0;

    /* renamed from: ah */
    private final int f12884ah = UiUtils.dip2px(getContext(), 174.0f);
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public int f12885ai = 0;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public boolean f12886aj = false;

    /* renamed from: ak */
    private boolean f12887ak = false;

    /* renamed from: b */
    int f12888b = UiUtils.dip2px(getContext(), 60.0f);

    /* renamed from: c */
    int f12889c = 0;

    /* renamed from: d */
    private final Logger f12890d = LoggerFactory.getLogger("AnycarBubbleLayout");
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f12891e;

    /* renamed from: f */
    private Context f12892f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f12893g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f12894h = 48;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f12895i = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public float f12896j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f12897k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f12898l = 3;

    /* renamed from: m */
    private RecyclerView f12899m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public AnycarEstimatePanelLayout f12900n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public LinearLayout f12901o;

    /* renamed from: p */
    private AnyCarMessageView f12902p;

    /* renamed from: q */
    private LinearLayout f12903q;

    /* renamed from: r */
    private LinearLayout f12904r;

    /* renamed from: s */
    private FrameLayout f12905s;

    /* renamed from: t */
    private LinearLayout f12906t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public View f12907u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f12908v = 0;

    /* renamed from: w */
    private float f12909w = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final int f12910x = UiUtils.dip2px(getContext(), 11.0f);
    /* access modifiers changed from: private */

    /* renamed from: y */
    public final int f12911y = UiUtils.dip2px(getContext(), 20.0f);

    /* renamed from: z */
    private int f12912z = UiUtils.dip2px(getContext(), 67.0f);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10858a(String str) {
        Logger logger = this.f12890d;
        logger.info("dongxt ---- " + str, new Object[0]);
    }

    public AnycarBubbleLayout(Context context) {
        super(context);
        m10854a(context);
    }

    public AnycarBubbleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10854a(context);
    }

    public AnycarBubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10854a(context);
    }

    public LinearLayout getContentView() {
        return this.f12904r;
    }

    public LinearLayout getFormContentView() {
        return this.f12906t;
    }

    public void showLoading() {
        showEstimateWithAnimation(true);
    }

    public void showEstimateWithAnimation(boolean z) {
        m10858a("showEstimateWithAnimation loading =" + z + "/ isloading =" + this.f12879ac);
        if (z != this.f12879ac) {
            int i = 0;
            this.f12889c = 0;
            this.f12879ac = z;
            this.f12880ad = 0;
            this.f12908v = 0;
            this.f12853D.setVisibility(8);
            this.f12854E.setVisibility(8);
            this.f12851B.setVisibility(8);
            if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
                PageCompDataTransfer.getInstance().getConfirmListener().updateAlpha(1.0f);
            }
            this.f12877aa.setVisibility(0);
            this.f12878ab.setVisibility(8);
            this.f12901o.setVisibility(8);
            this.f12900n.setVisibility(0);
            this.f12900n.setLockDispatchTouchEvent(z);
            this.f12899m.setVisibility(z ? 0 : 8);
            View view = this.f12875Z;
            if (z) {
                i = 8;
            }
            view.setVisibility(i);
            this.f12899m.post(new Runnable() {
                public void run() {
                    int defauleHeight = AnycarBubbleLayout.this.getDefauleHeight();
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m10858a("showEstimateWithAnimation ----current " + defauleHeight);
                    AnycarBubbleLayout.this.f12900n.peek(defauleHeight, (Runnable) null, 0);
                }
            });
        }
    }

    public void bindView(View view, View view2) {
        this.f12875Z = view;
        this.f12877aa = view2;
        this.f12900n.post(new Runnable() {
            public void run() {
                int defauleHeight = AnycarBubbleLayout.this.getDefauleHeight();
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m10858a("update ----current " + defauleHeight);
                AnycarBubbleLayout.this.f12900n.peek(defauleHeight, (Runnable) null, 0);
            }
        });
    }

    /* renamed from: a */
    private void m10854a(Context context) {
        this.f12892f = context;
        this.f12891e = LayoutInflater.from(context).inflate(R.layout.anycar_estimate_layout, this, true);
        this.f12894h = UiUtils.dip2px(this.f12892f, 24.0f);
        this.f12901o = (LinearLayout) this.f12891e.findViewById(R.id.message_ll);
        this.f12902p = (AnyCarMessageView) this.f12891e.findViewById(R.id.anycar_msg);
        this.f12903q = (LinearLayout) this.f12891e.findViewById(R.id.content_ll);
        this.f12904r = (LinearLayout) this.f12891e.findViewById(R.id.estimate_content_ll);
        this.f12905s = (FrameLayout) this.f12891e.findViewById(R.id.panel_view_content);
        this.f12906t = (LinearLayout) this.f12891e.findViewById(R.id.form_view_content);
        this.f12851B = (LinearLayout) this.f12891e.findViewById(R.id.slide_tips_ll);
        this.f12852C = (TextView) this.f12891e.findViewById(R.id.slide_tips_tv);
        this.f12851B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.f12900n.expand();
            }
        });
        this.f12907u = this.f12891e.findViewById(R.id.baseline_v);
        FrameLayout frameLayout = (FrameLayout) this.f12891e.findViewById(R.id.preference_fl);
        this.f12853D = frameLayout;
        frameLayout.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.preference_top_fl);
        this.f12854E = linearLayout;
        linearLayout.setVisibility(8);
        m10850a();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.loading_rv);
        this.f12899m = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f12892f, 1, false));
        this.f12899m.setAdapter(new InnerAdapter(this.f12892f));
        AanycarAbnormalView aanycarAbnormalView = (AanycarAbnormalView) findViewById(R.id.anycar_abnormal);
        this.f12878ab = aanycarAbnormalView;
        aanycarAbnormalView.setClickListener(new AanycarAbnormalView.BtnClickListener() {
            public void click() {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM);
                AnycarBubbleLayout.this.showLoading();
                AnycarBubbleLayout.this.f12878ab.setVisibility(8);
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        });
        AnycarEstimatePanelLayout anycarEstimatePanelLayout = (AnycarEstimatePanelLayout) findViewById(R.id.wrapper);
        this.f12900n = anycarEstimatePanelLayout;
        anycarEstimatePanelLayout.registerWrapperDispatchEvent(new AnycarEstimatePanelLayout.INestChildDispatchTouchEvent() {
            public void dispatchWrapperTouchEvent(MotionEvent motionEvent) {
            }

            public void dispatchWrapperOrigineTouchEvent(MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    float unused = AnycarBubbleLayout.this.f12896j = motionEvent.getY();
                } else if (action == 1 || action == 3) {
                    float y = motionEvent.getY();
                    float abs = Math.abs(y - AnycarBubbleLayout.this.f12896j);
                    boolean z = y < AnycarBubbleLayout.this.f12896j && abs > ((float) AnycarBubbleLayout.this.f12894h);
                    boolean z2 = y > AnycarBubbleLayout.this.f12896j && abs > ((float) AnycarBubbleLayout.this.f12894h);
                    int showState = AnycarBubbleLayout.this.f12900n.getShowState();
                    int defauleHeight = AnycarBubbleLayout.this.getDefauleHeight();
                    int bottomHeight = AnycarBubbleLayout.this.getBottomHeight();
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m10858a("SCROLL_DIRECTION======== deltaY=" + AnycarBubbleLayout.this.f12895i + "/ status=" + showState + "/ defalutH=" + defauleHeight + "? bottomH=" + bottomHeight + "？ SCROLL_DIRECTION=" + AnycarBubbleLayout.this.f12897k);
                    AnycarBubbleLayout anycarBubbleLayout2 = AnycarBubbleLayout.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("SCROLL_DIRECTION======== mPanelHight=");
                    sb.append(AnycarBubbleLayout.this.f12893g);
                    sb.append("、 isCanScrollUp=");
                    sb.append(AnycarBubbleLayout.this.isCanScrollUp());
                    anycarBubbleLayout2.m10858a(sb.toString());
                    AnycarBubbleLayout anycarBubbleLayout3 = AnycarBubbleLayout.this;
                    anycarBubbleLayout3.m10858a("SCROLL_DIRECTION  downY=" + AnycarBubbleLayout.this.f12896j + "/ moveY =" + y + "/ yDiff=" + abs + "/ isSlideUp=" + z + "/ isSlideDown=" + z2);
                    if (abs == 0.0f || AnycarBubbleLayout.this.f12895i <= ((float) AnycarBubbleLayout.this.f12900n.getLockTopLimit())) {
                        AnycarBubbleLayout.this.m10858a("SCROLL_DIRECTION  break");
                        AnycarBubbleLayout.this.updateSwipeTips(true);
                    } else if (z) {
                        AnycarBubbleLayout.this.m10858a(" 向上滑动");
                        int unused2 = AnycarBubbleLayout.this.f12897k = 1;
                        if (AnycarBubbleLayout.this.f12895i < ((float) (defauleHeight - AnycarBubbleLayout.this.f12894h)) && AnycarBubbleLayout.this.isCanScrollUp()) {
                            AnycarBubbleLayout.this.f12900n.expand();
                            AnycarBubbleLayout.this.m10858a("onNestChildScrollRelease=====up=== expand");
                        } else if (AnycarBubbleLayout.this.f12895i < ((float) (bottomHeight - AnycarBubbleLayout.this.f12894h))) {
                            AnycarBubbleLayout.this.m10858a("onNestChildScrollRelease======up== peek");
                            AnycarBubbleLayout.this.f12900n.peek(defauleHeight);
                        } else {
                            AnycarBubbleLayout.this.m10858a("onNestChildScrollRelease=====up=== current");
                            if (showState == 0) {
                                defauleHeight = AnycarBubbleLayout.this.getBottomHeight();
                            }
                            AnycarBubbleLayout.this.f12900n.updateStatus(showState, defauleHeight);
                        }
                    } else if (z2) {
                        AnycarBubbleLayout.this.m10858a("向下滑动");
                        int unused3 = AnycarBubbleLayout.this.f12897k = 2;
                        if (AnycarBubbleLayout.this.f12895i > ((float) (AnycarBubbleLayout.this.f12894h + defauleHeight))) {
                            AnycarBubbleLayout.this.m10858a("onNestChildScrollRelease====down==== hiden");
                            AnycarBubbleLayout.this.f12900n.hiden(bottomHeight);
                        } else if (AnycarBubbleLayout.this.f12895i > ((float) AnycarBubbleLayout.this.f12894h)) {
                            AnycarBubbleLayout.this.m10858a("onNestChildScrollRelease====down==== peek");
                            AnycarBubbleLayout.this.f12900n.peek(defauleHeight);
                        } else {
                            AnycarBubbleLayout.this.m10858a("onNestChildScrollRelease====down==== current");
                            if (showState == 0) {
                                defauleHeight = AnycarBubbleLayout.this.getBottomHeight();
                            }
                            AnycarBubbleLayout.this.f12900n.updateStatus(showState, defauleHeight);
                        }
                    } else {
                        int unused4 = AnycarBubbleLayout.this.f12897k = 0;
                        AnycarBubbleLayout.this.m10858a("onNestChildScrollRelease======= current");
                        if (showState == 0) {
                            defauleHeight = AnycarBubbleLayout.this.getBottomHeight();
                        }
                        AnycarBubbleLayout.this.f12900n.updateStatus(showState, defauleHeight);
                    }
                }
            }
        });
        this.f12900n.registerNestScrollChildCallback(new AnycarEstimatePanelLayout.INestChildScrollChange() {
            public void onFingerUp(float f) {
            }

            public void onNestChildHorizationScroll(MotionEvent motionEvent, float f, float f2) {
            }

            public void onNestChildScrollChange(float f, float f2) {
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m10858a("onNestChildScrollChange deltaY = " + f + "/ velocityY=" + f2 + "/ preferenceTopAnimaH=" + AnycarBubbleLayout.this.f12876a + "? alphaLimit=" + AnycarBubbleLayout.this.f12888b);
                float unused = AnycarBubbleLayout.this.f12895i = f;
                AnycarBubbleLayout.this.m10851a(f);
            }

            public void onNestChildScrollRelease(float f, int i) {
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m10858a("onNestChildScrollRelease deltaY = " + f + "/ velocityY=" + i + "/ preferenceH=" + AnycarBubbleLayout.this.f12908v);
                AnycarBubbleLayout.this.m10851a(f);
            }

            public void onNestScrollingState(int i) {
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m10858a("onNestChildScrollRelease onNestScrollingState state= " + i);
                if (i == 1) {
                    AnycarBubbleLayout anycarBubbleLayout2 = AnycarBubbleLayout.this;
                    anycarBubbleLayout2.m10851a(anycarBubbleLayout2.f12895i);
                    AnycarBubbleLayout.this.updateSwipeTips(false);
                    AnycarBubbleLayout anycarBubbleLayout3 = AnycarBubbleLayout.this;
                    anycarBubbleLayout3.m10852a((int) anycarBubbleLayout3.f12895i);
                }
            }
        });
        this.f12900n.setSheetDirection(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10852a(int i) {
        int i2 = i + this.f12881ae;
        if (this.f12908v != 0) {
            i2 += this.f12850A;
        }
        m10862b(i2);
        this.f12907u.post(new Runnable() {
            public void run() {
                if (AnycarBubbleLayout.this.f12900n.getShowState() != 2) {
                    Rect rect = new Rect();
                    AnycarBubbleLayout.this.f12907u.getGlobalVisibleRect(rect);
                    Rect rect2 = new Rect();
                    AnycarBubbleLayout.this.f12891e.getGlobalVisibleRect(rect2);
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m10858a("updateRect  baselineRect=" + rect.toString() + "/ bottom =" + rect.bottom + "/ currentdeltaY=" + AnycarBubbleLayout.this.f12895i);
                    AnycarBubbleLayout anycarBubbleLayout2 = AnycarBubbleLayout.this;
                    anycarBubbleLayout2.m10858a("updateRect  baselineRect  rootRect =" + rect2.toString() + "/ bottom =" + rect2.bottom + " mMessaeHeight =" + AnycarBubbleLayout.this.f12880ad);
                    int unused = AnycarBubbleLayout.this.f12885ai = ((rect2.bottom - rect.top) - AnycarBubbleLayout.this.f12910x) + AnycarBubbleLayout.this.f12880ad;
                    if (AnycarBubbleLayout.this.f12908v == 0) {
                        BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, Integer.valueOf(AnycarBubbleLayout.this.f12885ai));
                    } else {
                        AnycarBubbleLayout.this.f12855F.post(new Runnable() {
                            public void run() {
                                int measuredHeight = AnycarBubbleLayout.this.f12855F.getMeasuredHeight();
                                int measuredHeight2 = AnycarBubbleLayout.this.f12857H.getMeasuredHeight();
                                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                                anycarBubbleLayout.m10858a("EVENT_HEIGHT_CHANGED / mBestViewHeight =" + AnycarBubbleLayout.this.f12885ai + "/ any_car_preference_card_narrow h= " + measuredHeight + "/anycar_preference_expand_content h=  " + measuredHeight2);
                                if (AnycarBubbleLayout.this.f12855F.getVisibility() != 0) {
                                    measuredHeight = 0;
                                }
                                if (AnycarBubbleLayout.this.f12857H.getVisibility() != 0) {
                                    measuredHeight2 = measuredHeight;
                                }
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, Integer.valueOf(AnycarBubbleLayout.this.f12885ai + measuredHeight2));
                            }
                        });
                    }
                }
            }
        });
    }

    public int getDefauleHeight() {
        int measuredHeight = this.f12900n.getMeasuredHeight();
        this.f12883ag = measuredHeight;
        int i = (int) (((float) measuredHeight) * this.f12909w);
        int measuredHeight2 = this.f12903q.getMeasuredHeight();
        int i2 = measuredHeight2 + 0;
        this.f12893g = i2;
        if (i2 < i) {
            i = i2;
        }
        m10858a("===========deault hight =" + i + "、 mBestViewHeight=" + this.f12885ai + "、 messageH=" + 0 + "/ contentH=" + measuredHeight2 + "? real_h=" + this.f12893g + "/ maxH =" + this.f12883ag);
        return this.f12883ag - i;
    }

    public int getBottomHeight() {
        int i = (this.f12883ag - 0) - this.f12882af;
        m10858a("===========getBottomHight  =" + i + "/ messageH=" + 0 + "/ minestimateH " + this.f12882af);
        return i;
    }

    public boolean isCanScrollUp() {
        return this.f12893g >= ((int) (((float) this.f12883ag) * this.f12909w));
    }

    public void handleMsg() {
        final int i;
        int i2;
        CarMessageModel anyCarMsg = getAnyCarMsg();
        if (anyCarMsg == null) {
            i = this.f12886aj ? 2 : 0;
            this.f12886aj = false;
        } else {
            if (!this.f12886aj) {
                GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_bubble_sw");
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.f12886aj = true;
            this.f12901o.setVisibility(0);
            this.f12902p.setData(anyCarMsg);
            i = i2;
        }
        this.f12901o.post(new Runnable() {
            public void run() {
                int i;
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                int unused = anycarBubbleLayout.f12880ad = anycarBubbleLayout.f12901o.getMeasuredHeight() - AnycarBubbleLayout.this.f12911y;
                AnycarBubbleLayout anycarBubbleLayout2 = AnycarBubbleLayout.this;
                anycarBubbleLayout2.m10858a("===mMessaeHeight====" + AnycarBubbleLayout.this.f12880ad + "/ preferenceTopMaxH =" + AnycarBubbleLayout.this.f12850A + "、 " + AnycarBubbleLayout.this.f12886aj + "/ animatorType " + i);
                int i2 = i;
                if (i2 != 0) {
                    if (i2 == 1) {
                        i = 0;
                    } else {
                        i = AnycarBubbleLayout.this.f12880ad;
                    }
                    ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i == 1 ? AnycarBubbleLayout.this.f12880ad : 0});
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                            anycarBubbleLayout.m10858a("msgAnimator h " + intValue + "/ mMessaeHeight=" + AnycarBubbleLayout.this.f12880ad);
                            if (intValue != AnycarBubbleLayout.this.f12880ad) {
                                int unused = AnycarBubbleLayout.this.f12880ad = intValue;
                                AnycarBubbleLayout.this.m10851a(AnycarBubbleLayout.this.f12895i);
                                AnycarBubbleLayout.this.m10852a(AnycarBubbleLayout.this.getDefauleHeight());
                            }
                            if (AnycarBubbleLayout.this.f12880ad < 1 && i == 2) {
                                AnycarBubbleLayout.this.f12901o.setVisibility(8);
                            }
                        }
                    });
                    ofInt.setDuration(300);
                    ofInt.start();
                    return;
                }
                if (!AnycarBubbleLayout.this.f12886aj) {
                    int unused2 = AnycarBubbleLayout.this.f12880ad = 0;
                }
                AnycarBubbleLayout anycarBubbleLayout3 = AnycarBubbleLayout.this;
                anycarBubbleLayout3.m10851a(anycarBubbleLayout3.f12895i);
                AnycarBubbleLayout.this.m10852a(AnycarBubbleLayout.this.getDefauleHeight());
            }
        });
    }

    private CarMessageModel getAnyCarMsg() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        CarMessageModel carMessageModel = null;
        if (confirmListener == null) {
            return null;
        }
        List<AnyCarEstimateItemModel> selectedAnyCarItems = confirmListener.getSelectedAnyCarItems();
        int i = Integer.MIN_VALUE;
        if (!CollectionUtil.isEmpty((Collection<?>) selectedAnyCarItems)) {
            for (AnyCarEstimateItemModel next : selectedAnyCarItems) {
                if (!(next == null || next.mAnyCarEstimateNetItem.carMessage == null || next.mAnyCarEstimateNetItem.carMessage.level < i)) {
                    i = next.mAnyCarEstimateNetItem.carMessage.level;
                    carMessageModel = next.mAnyCarEstimateNetItem.carMessage;
                }
            }
            Logger logger = this.f12890d;
            StringBuilder sb = new StringBuilder();
            sb.append("lxsanycar msg");
            sb.append((carMessageModel == null || carMessageModel.msg == null) ? "空的" : carMessageModel.msg.getContent());
            logger.debug(sb.toString(), new Object[0]);
            return carMessageModel;
        }
        this.f12890d.debug("lxsanycar msg空的", new Object[0]);
        return null;
    }

    public void handleAbnormal(boolean z) {
        boolean z2;
        EstimateAbnormalModel estimateAbnormalModel;
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || confirmListener.getAnyCarResponse() == null || (estimateAbnormalModel = confirmListener.getAnyCarResponse().abnormalModels) == null) {
            z2 = false;
        } else {
            z2 = true;
            updateAbnormal(estimateAbnormalModel);
        }
        if (z && !z2) {
            updateAbnormal((EstimateAbnormalModel) null);
        }
    }

    public void updateAbnormal(EstimateAbnormalModel estimateAbnormalModel) {
        this.f12854E.setVisibility(8);
        this.f12851B.setVisibility(8);
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            PageCompDataTransfer.getInstance().getConfirmListener().updateAlpha(1.0f);
        }
        this.f12901o.setVisibility(8);
        this.f12900n.setVisibility(8);
        this.f12853D.setVisibility(8);
        this.f12877aa.setVisibility(8);
        this.f12875Z.setVisibility(8);
        this.f12878ab.setVisibility(0);
        this.f12878ab.setData(estimateAbnormalModel);
    }

    public class InnerAdapter extends RecyclerView.Adapter<InnerViewHolder> {
        private Context mContext;
        private LayoutInflater mInflater;

        public void onBindViewHolder(InnerViewHolder innerViewHolder, int i) {
        }

        public InnerAdapter(Context context) {
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
        }

        public InnerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new InnerViewHolder(this.mInflater.inflate(R.layout.anycar_loading, viewGroup, false));
        }

        public int getItemCount() {
            return AnycarBubbleLayout.this.f12898l;
        }
    }

    public class InnerViewHolder extends RecyclerView.ViewHolder {
        public InnerViewHolder(View view) {
            super(view);
        }
    }

    /* renamed from: a */
    private void m10850a() {
        findViewById(R.id.status_bar_v).getLayoutParams().height = UiUtils.getStatusBarHeight(this.f12892f);
        this.f12866Q = (TextView) findViewById(R.id.anycar_preference_top_left_button_title);
        this.f12867R = (TextView) findViewById(R.id.anycar_preference_top_right_button_title);
        this.f12868S = (ImageView) findViewById(R.id.anycar_preference_top_left_button_icon);
        this.f12869T = (ImageView) findViewById(R.id.anycar_preference_top_right_button_icon);
        this.f12871V = (LinearLayout) findViewById(R.id.anycar_preference_top_right_ll);
        this.f12870U = (LinearLayout) findViewById(R.id.anycar_preference_top_left_ll);
        ((ImageView) findViewById(R.id.anycar_preference_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                int defauleHeight = AnycarBubbleLayout.this.getDefauleHeight();
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m10858a("top back ----current " + defauleHeight);
                AnycarBubbleLayout.this.f12900n.peek(defauleHeight);
            }
        });
        this.f12870U.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m10858a(" anycar_preference_top_left_ll click");
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m10853a(anycarBubbleLayout.f12872W, true);
            }
        });
        this.f12871V.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m10858a(" anycar_preference_top_right_ll click");
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m10853a(anycarBubbleLayout.f12873X, true);
            }
        });
        this.f12855F = (LinearLayout) findViewById(R.id.any_car_preference_card_narrow);
        this.f12856G = (TextView) findViewById(R.id.anycar_preference_narrow_title);
        this.f12857H = (RelativeLayout) findViewById(R.id.anycar_preference_expand_content);
        this.f12858I = (TextView) findViewById(R.id.anycar_preference_expand_title);
        this.f12859J = (TextView) findViewById(R.id.anycar_preference_left_button_title);
        this.f12860K = (TextView) findViewById(R.id.anycar_preference_right_button_title);
        this.f12861L = (ImageView) findViewById(R.id.anycar_preference_left_button_icon);
        this.f12862M = (ImageView) findViewById(R.id.anycar_preference_right_button_icon);
        this.f12864O = (LinearLayout) findViewById(R.id.anycar_preference_right_ll);
        this.f12863N = (LinearLayout) findViewById(R.id.anycar_preference_left_ll);
        this.f12855F.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m10858a(" any_car_preference_card_narrow click");
                GlobalOmegaUtils.trackEvent("ibt_gp_anycar_prefbtn_ck");
                AnycarBubbleLayout.this.m10859a(true);
            }
        });
        ((ImageView) findViewById(R.id.anycar_preference_card_close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m10858a(" anycar_preference_card_close close");
                AnycarBubbleLayout.this.m10865b(true);
                GlobalOmegaUtils.trackEvent("ibt_gp_anycar_pref_choice_quit_ck");
            }
        });
        this.f12863N.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m10858a(" anycar_preference_left_ll click");
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m10853a(anycarBubbleLayout.f12872W, true);
            }
        });
        this.f12864O.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m10858a(" anycar_preference_right_ll click");
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m10853a(anycarBubbleLayout.f12873X, true);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10851a(float f) {
        int defauleHeight = getDefauleHeight();
        this.f12901o.setTranslationY((((((float) this.f12850A) + f) + ((float) this.f12881ae)) - ((float) this.f12880ad)) + ((float) this.f12910x));
        float f2 = (float) defauleHeight;
        if (f < f2) {
            float f3 = (f2 - f) / f2;
            m10858a("updatePreferenceAlpha bg ==alphe " + f3);
            this.f12891e.setBackgroundColor(Color.parseColor("#EAEEF3"));
            if (f3 <= 0.95f) {
                this.f12891e.getBackground().setAlpha((int) (f3 * 255.0f));
            } else {
                this.f12891e.getBackground().setAlpha((int) 242.25f);
            }
        } else {
            this.f12891e.setBackgroundColor(Color.parseColor("#00000000"));
            this.f12891e.getBackground().setAlpha(0);
            this.f12907u.setTranslationY(f);
        }
        if ((this.f12908v == 0 || this.f12899m.getVisibility() == 0) && this.f12853D.getVisibility() == 0) {
            this.f12853D.setVisibility(8);
        }
        m10858a("updatePreferenceAlpha== delatY = " + f + "、 preferenceTopAnimaH=" + this.f12876a);
        int i = this.f12876a;
        if (f < ((float) i)) {
            float abs = Math.abs(f - ((float) i));
            float f4 = 1.0f - (abs / ((float) this.f12888b));
            float f5 = abs - ((float) this.f12912z);
            m10858a("updatePreferenceAlpha== alpha = " + f4 + "、 step = " + abs + "/ toplimit = " + this.f12912z + "? topstep=" + f5);
            if (f4 < 0.0f) {
                if (this.f12908v != 0) {
                    m10858a("updatePreferenceAlpha== preference_top_fl.getAlpha() = " + this.f12854E.getAlpha() + "、 preference_top_fl.getTranslationY()=" + this.f12854E.getTranslationY());
                    if (this.f12908v != 0 && this.f12853D.getVisibility() == 0) {
                        this.f12853D.setVisibility(8);
                    }
                    if (this.f12908v != 0 && this.f12854E.getVisibility() == 8) {
                        this.f12854E.setVisibility(0);
                        if (!this.f12887ak) {
                            this.f12887ak = true;
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", 2);
                            GlobalOmegaUtils.trackEvent("ibt_gp_anycar_prefbtn_sw", (Map<String, Object>) hashMap);
                        }
                    }
                    if (!(this.f12908v == 0 || this.f12854E.getTranslationY() == 0.0f)) {
                        this.f12854E.setTranslationY(0.0f);
                    }
                    if (!(this.f12908v == 0 || this.f12854E.getAlpha() == 1.0f)) {
                        this.f12854E.setAlpha(1.0f);
                    }
                }
                if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
                    PageCompDataTransfer.getInstance().getConfirmListener().updateAlpha(0.0f);
                    return;
                }
                return;
            }
            if (this.f12908v != 0) {
                if (this.f12853D.getVisibility() == 8) {
                    this.f12853D.setVisibility(0);
                }
                this.f12853D.setTranslationY((((f - ((float) this.f12908v)) + ((float) this.f12850A)) + ((float) this.f12881ae)) - ((float) this.f12880ad));
                this.f12853D.setAlpha(f4);
                if (this.f12854E.getVisibility() == 8) {
                    this.f12854E.setVisibility(0);
                    if (!this.f12887ak) {
                        this.f12887ak = true;
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("type", 2);
                        GlobalOmegaUtils.trackEvent("ibt_gp_anycar_prefbtn_sw", (Map<String, Object>) hashMap2);
                    }
                }
                if (f5 < 0.0f) {
                    this.f12854E.setTranslationY(f5);
                } else {
                    this.f12854E.setTranslationY(0.0f);
                }
                this.f12854E.setAlpha(1.0f - f4);
            }
            if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
                PageCompDataTransfer.getInstance().getConfirmListener().updateAlpha(f4);
                return;
            }
            return;
        }
        if (this.f12908v != 0) {
            if (this.f12854E.getVisibility() == 0) {
                this.f12854E.setVisibility(8);
            }
            this.f12887ak = false;
            if (this.f12853D.getVisibility() == 8) {
                this.f12853D.setVisibility(0);
            }
            if (this.f12853D.getAlpha() != 1.0f) {
                this.f12853D.setAlpha(1.0f);
            }
            this.f12853D.setTranslationY((((f - ((float) this.f12908v)) + ((float) this.f12850A)) + ((float) this.f12881ae)) - ((float) this.f12880ad));
        }
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            PageCompDataTransfer.getInstance().getConfirmListener().updateAlpha(1.0f);
        }
    }

    public void updatePreferenceStatus(boolean z) {
        ConfirmListener confirmListener;
        int i;
        String str;
        String str2;
        if (this.f12908v != 0 && (confirmListener = PageCompDataTransfer.getInstance().getConfirmListener()) != null) {
            List<AnyCarEstimateItemModel> selectedAnyCarItems = confirmListener.getSelectedAnyCarItems();
            if (selectedAnyCarItems == null || selectedAnyCarItems.size() <= 1) {
                this.f12863N.setEnabled(false);
                this.f12864O.setEnabled(false);
                this.f12870U.setEnabled(false);
                this.f12871V.setEnabled(false);
                this.f12861L.setEnabled(false);
                this.f12862M.setEnabled(false);
                this.f12868S.setEnabled(false);
                this.f12869T.setEnabled(false);
                this.f12859J.setTextColor(Color.parseColor("#D4D7D9"));
                this.f12860K.setTextColor(Color.parseColor("#D4D7D9"));
                this.f12866Q.setTextColor(Color.parseColor("#D4D7D9"));
                this.f12867R.setTextColor(Color.parseColor("#D4D7D9"));
                this.f12863N.setEnabled(false);
                this.f12864O.setEnabled(false);
                this.f12870U.setEnabled(false);
                this.f12871V.setEnabled(false);
                i = 1;
            } else {
                i = selectedAnyCarItems.size();
                this.f12863N.setEnabled(true);
                this.f12864O.setEnabled(true);
                this.f12870U.setEnabled(true);
                this.f12871V.setEnabled(true);
                this.f12861L.setEnabled(true);
                this.f12862M.setEnabled(true);
                this.f12868S.setEnabled(true);
                this.f12869T.setEnabled(true);
                this.f12863N.setEnabled(true);
                this.f12864O.setEnabled(true);
                this.f12870U.setEnabled(true);
                this.f12871V.setEnabled(true);
                int preference = confirmListener.getPreference();
                String str3 = "#FF6A00";
                this.f12859J.setTextColor(Color.parseColor(preference == this.f12872W ? str3 : "#000000"));
                TextView textView = this.f12860K;
                if (preference == this.f12873X) {
                    str = str3;
                } else {
                    str = "#000000";
                }
                textView.setTextColor(Color.parseColor(str));
                TextView textView2 = this.f12866Q;
                if (preference == this.f12872W) {
                    str2 = str3;
                } else {
                    str2 = "#000000";
                }
                textView2.setTextColor(Color.parseColor(str2));
                TextView textView3 = this.f12867R;
                if (preference != this.f12873X) {
                    str3 = "#000000";
                }
                textView3.setTextColor(Color.parseColor(str3));
            }
            if (z) {
                if (this.f12889c == 1 && i == 2 && !this.f12874Y) {
                    m10859a(z);
                } else if (this.f12889c == 2 && i == 1 && this.f12874Y) {
                    m10865b(z);
                }
            }
            this.f12889c = i;
        }
    }

    public void updatePreferenceData() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            AnyCarResponse anyCarResponse = confirmListener.getAnyCarResponse();
            if (!(anyCarResponse == null || anyCarResponse.globalConfig == null)) {
                String str = anyCarResponse.globalConfig.slideTips;
                if (this.f12852C != null && !TextUtils.isEmpty(str)) {
                    this.f12852C.setText(str);
                }
                AnyCarGlobalConfig.AnyCarPreference anyCarPreference = anyCarResponse.globalConfig.preference;
                if (anyCarPreference == null || anyCarPreference.collapseTitle == null) {
                    this.f12908v = 0;
                    this.f12853D.setVisibility(8);
                    this.f12855F.setVisibility(8);
                    this.f12857H.setVisibility(8);
                } else {
                    this.f12908v = UiUtils.dip2px(this.f12892f, 80.0f);
                    boolean z = anyCarPreference.isExpand == 1;
                    this.f12874Y = z;
                    if (z) {
                        this.f12855F.setVisibility(8);
                        this.f12857H.setVisibility(0);
                    } else {
                        this.f12855F.setVisibility(0);
                        this.f12857H.setVisibility(8);
                    }
                    anyCarPreference.collapseTitle.bindTextView(this.f12856G);
                    anyCarPreference.title.bindTextView(this.f12858I);
                    if (anyCarPreference.options != null && anyCarPreference.options.size() == 2) {
                        this.f12872W = anyCarPreference.options.get(0).type;
                        this.f12873X = anyCarPreference.options.get(1).type;
                        m10853a(anyCarPreference.userType, false);
                        this.f12859J.setText(anyCarPreference.options.get(0).title);
                        this.f12860K.setText(anyCarPreference.options.get(1).title);
                        this.f12866Q.setText(anyCarPreference.options.get(0).title);
                        this.f12867R.setText(anyCarPreference.options.get(1).title);
                    }
                }
                if (this.f12874Y) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", 1);
                    GlobalOmegaUtils.trackEvent("ibt_gp_anycar_prefbtn_sw", (Map<String, Object>) hashMap);
                }
            }
            updatePreferenceStatus(false);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12905s.getLayoutParams();
        if (this.f12908v == 0) {
            layoutParams.topMargin = this.f12881ae;
        } else {
            layoutParams.topMargin = this.f12850A + this.f12881ae;
        }
        this.f12905s.setLayoutParams(layoutParams);
        m10852a(getDefauleHeight());
    }

    /* renamed from: b */
    private void m10862b(int i) {
        final ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            final Rect rect = new Rect();
            rect.top = i;
            rect.left = 0;
            rect.right = UiUtils.getScreenWidth(this.f12892f);
            rect.bottom = this.f12883ag;
            confirmListener.setAnycarEstimteRect(rect);
            this.f12855F.post(new Runnable() {
                public void run() {
                    Rect rect = new Rect();
                    if (AnycarBubbleLayout.this.f12855F.getVisibility() == 0) {
                        AnycarBubbleLayout.this.f12855F.getGlobalVisibleRect(rect);
                    }
                    if (AnycarBubbleLayout.this.f12857H.getVisibility() == 0) {
                        AnycarBubbleLayout.this.f12857H.getGlobalVisibleRect(rect);
                    }
                    if (rect.top == 0) {
                        confirmListener.setPreferenceRect((Rect) null);
                    } else {
                        confirmListener.setPreferenceRect(rect);
                    }
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m10858a("updateRect " + rect.toString() + "/ preference_rect=" + rect.toString());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10853a(int i, boolean z) {
        String str;
        String str2;
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            PageCompDataTransfer.getInstance().getConfirmListener().setPreference(i);
        }
        if (z) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_PREFERENCE_CHANGE);
            HashMap hashMap = new HashMap();
            hashMap.put("type", Integer.valueOf(i));
            GlobalOmegaUtils.trackEvent("ibt_gp_anycar_pref_choice_ck", (Map<String, Object>) hashMap);
        }
        boolean z2 = true;
        this.f12861L.setSelected(i == this.f12872W);
        this.f12862M.setSelected(i == this.f12873X);
        this.f12868S.setSelected(i == this.f12872W);
        this.f12869T.setSelected(i == this.f12873X);
        this.f12863N.setSelected(i == this.f12872W);
        this.f12864O.setSelected(i == this.f12873X);
        this.f12870U.setSelected(i == this.f12872W);
        LinearLayout linearLayout = this.f12871V;
        if (i != this.f12873X) {
            z2 = false;
        }
        linearLayout.setSelected(z2);
        String str3 = "#FF6A00";
        this.f12859J.setTextColor(Color.parseColor(i == this.f12872W ? str3 : "#000000"));
        TextView textView = this.f12860K;
        if (i == this.f12873X) {
            str = str3;
        } else {
            str = "#000000";
        }
        textView.setTextColor(Color.parseColor(str));
        TextView textView2 = this.f12866Q;
        if (i == this.f12872W) {
            str2 = str3;
        } else {
            str2 = "#000000";
        }
        textView2.setTextColor(Color.parseColor(str2));
        TextView textView3 = this.f12867R;
        if (i != this.f12873X) {
            str3 = "#000000";
        }
        textView3.setTextColor(Color.parseColor(str3));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10859a(boolean z) {
        this.f12874Y = true;
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f12892f, R.anim.anycar_preference_expand_alpha_animation);
            this.f12857H.startAnimation(AnimationUtils.loadAnimation(this.f12892f, R.anim.anycar_preference_expand_animation));
            this.f12857H.setVisibility(0);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    AnycarBubbleLayout.this.f12855F.setVisibility(8);
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m10852a((int) anycarBubbleLayout.f12895i);
                }
            });
            this.f12855F.startAnimation(loadAnimation);
        } else {
            this.f12857H.setVisibility(0);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", 1);
        GlobalOmegaUtils.trackEvent("ibt_gp_anycar_prefbtn_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10865b(boolean z) {
        this.f12874Y = false;
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f12892f, R.anim.anycar_preference_narrow_animation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    AnycarBubbleLayout.this.f12857H.setVisibility(8);
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m10852a((int) anycarBubbleLayout.f12895i);
                }
            });
            this.f12857H.startAnimation(loadAnimation);
            m10848a(100, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (AnycarBubbleLayout.this.f12855F != null && AnycarBubbleLayout.this.f12855F.isAttachedToWindow()) {
                        if (AnycarBubbleLayout.this.f12855F.getVisibility() == 8) {
                            AnycarBubbleLayout.this.f12855F.setVisibility(0);
                        }
                        AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                        anycarBubbleLayout.m10858a("alpha = " + valueAnimator.getAnimatedValue());
                        AnycarBubbleLayout.this.f12855F.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }).start();
            return;
        }
        this.f12857H.setVisibility(8);
    }

    /* renamed from: a */
    private ValueAnimator m10848a(long j, long j2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
        ofFloat.setDuration(j);
        ofFloat.setStartDelay(j2);
        ofFloat.addUpdateListener(animatorUpdateListener);
        return ofFloat;
    }

    public void updateSwipeTips(boolean z) {
        if (this.f12900n.getShowState() != 1 || z || this.f12879ac) {
            this.f12851B.setVisibility(8);
            return;
        }
        try {
            int[] viewLocation = UiUtils.getViewLocation(this.f12877aa);
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener == null || confirmListener.getItemStatusListener() == null || !confirmListener.getItemStatusListener().isSwipe(viewLocation[1])) {
                this.f12851B.setVisibility(8);
            } else {
                this.f12851B.setVisibility(0);
            }
        } catch (Exception unused) {
            this.f12851B.setVisibility(8);
        }
    }
}
