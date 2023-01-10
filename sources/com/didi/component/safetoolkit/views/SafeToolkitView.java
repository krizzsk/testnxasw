package com.didi.component.safetoolkit.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.event.SafeToolkitVisibilityEvent;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.model.SafeToolkitBean;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.ISafeToolkitView;
import com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter;
import com.didi.component.safetoolkit.utils.SafetoolkitOmegaUtils;
import com.didi.component.safetoolkit.views.bubbles.BubbleView;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.view.LazyInflateView;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;

public class SafeToolkitView extends LazyInflateView implements ISafeToolkitView {
    public static final int EXPAND_ANIMATION_DURATION_MILLS = 1000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f17319a = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f17320b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f17321c;

    /* renamed from: d */
    private FrameLayout f17322d;

    /* renamed from: e */
    private ImageView f17323e;

    /* renamed from: f */
    private ImageView f17324f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f17325g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f17326h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AbsSafeToolkitPresenter f17327i;

    /* renamed from: j */
    private BubbleView f17328j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ViewGroup f17329k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f17330l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ValueAnimator f17331m;

    /* renamed from: n */
    private View.OnClickListener f17332n = null;

    /* renamed from: o */
    private int f17333o = 100;

    /* renamed from: p */
    private View.OnClickListener f17334p = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SafeToolkitView.this.f17327i.onActionClick();
        }
    };

    public SafeToolkitView(Context context) {
        super(context, (ViewGroup) null, R.layout.sf_safe_toolkit_entrance);
    }

    /* access modifiers changed from: protected */
    public void onInflate(View view) {
        this.f17320b = view;
        this.f17321c = (ImageView) view.findViewById(R.id.sf_safe_toolkit_entrance);
        this.f17322d = (FrameLayout) this.f17320b.findViewById(R.id.sf_safe_toolkit_breath_container);
        this.f17323e = (ImageView) this.f17320b.findViewById(R.id.sf_safe_toolkit_breath_inner_view);
        this.f17324f = (ImageView) this.f17320b.findViewById(R.id.sf_safe_toolkit_breath_outer_view);
        if (GlobalApolloUtil.isRiderSafetyToolkitIcon()) {
            this.f17321c.setImageDrawable(getContext().getResources().getDrawable(R.drawable.safe_toolkit_icon_new_selector));
        } else {
            this.f17321c.setImageDrawable(getContext().getResources().getDrawable(R.drawable.safe_toolkit_icon_selector));
        }
        View.OnClickListener onClickListener = this.f17332n;
        if (onClickListener != null) {
            this.f17321c.setOnClickListener(onClickListener);
        }
        this.f17328j = (BubbleView) this.f17320b.findViewById(R.id.sf_safe_toolkit_bubble);
        ViewGroup viewGroup = (ViewGroup) this.f17320b.findViewById(R.id.sf_safe_toolkit_welcome_bubble_container);
        this.f17329k = viewGroup;
        this.f17325g = (TextView) viewGroup.findViewById(R.id.sf_safe_toolkit_welcome_bubble_msg);
        this.f17326h = (ImageView) this.f17329k.findViewById(R.id.sf_safe_toolkit_welcome_bubble_more);
        int i = this.f17333o;
        if (i < 0) {
            this.f17320b.setTranslationY((float) i);
        }
    }

    public View getView() {
        return getRealView();
    }

    public void setPresenter(AbsSafeToolkitPresenter absSafeToolkitPresenter) {
        this.f17327i = absSafeToolkitPresenter;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f17321c;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        } else {
            this.f17332n = onClickListener;
        }
    }

    public void setVisibility(final boolean z) {
        int i = 0;
        if (z || this.isInflated) {
            super.inflate();
            if (!z) {
                i = 4;
            }
            if (i != this.f17320b.getVisibility()) {
                this.f17320b.setVisibility(i);
                this.f17320b.postDelayed(new Runnable() {
                    public void run() {
                        int measuredHeight = (int) (((float) SafeToolkitView.this.getView().getMeasuredHeight()) - TypedValue.applyDimension(1, 2.0f, SafeToolkitView.this.getView().getResources().getDisplayMetrics()));
                        if (measuredHeight < 0) {
                            measuredHeight = 0;
                        }
                        if (z) {
                            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, new SafeToolkitVisibilityEvent(measuredHeight, true));
                        } else {
                            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, new SafeToolkitVisibilityEvent(measuredHeight, false));
                        }
                        Logger c = SafeToolkitView.this.f17319a;
                        c.info("SafeToolkitView#setVisibility#postDelayed : isVisible : " + z + " , isInflated : " + SafeToolkitView.this.isInflated + " , height : " + measuredHeight, new Object[0]);
                    }
                }, 300);
                return;
            }
            return;
        }
        BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_VISIBILITY_CHANGED, new SafeToolkitVisibilityEvent(0, false));
        Logger logger = this.f17319a;
        logger.info("SafeToolkitView#setVisibility: isVisible : " + z + " , isInflated : " + this.isInflated + " , height : 0", new Object[0]);
    }

    public boolean isVisibility() {
        View view = this.f17320b;
        return view != null && view.getVisibility() == 0;
    }

    public void setTranslationY(int i) {
        if (this.isInflated) {
            getView().setTranslationY((float) i);
        } else {
            this.f17333o = i;
        }
    }

    public void setSafeToolkitStatusAndShow(final SafeToolkitBean.SafeToolkitData safeToolkitData) {
        if (!isVisibility() || this.f17328j == null) {
            return;
        }
        if (safeToolkitData == null || safeToolkitData.show == 0) {
            dismissBubble((Runnable) null);
        } else if (safeToolkitData.state == 7 || !isWelcomeShown()) {
            int i = safeToolkitData.state;
            final String str = safeToolkitData.content;
            int parseColor = Color.parseColor("#FFFF7F41");
            int parseColor2 = Color.parseColor("#FF333333");
            int dimension = (int) getView().getResources().getDimension(R.dimen.normal_bubble_text_max_width);
            m14554a();
            int windowWidth = UiUtils.getWindowWidth((Activity) this.mContext);
            switch (i) {
                case 1:
                    int parseColor3 = Color.parseColor("#FFFF525D");
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_bubble_allert_gif);
                    this.f17328j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor3);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 2:
                    int parseColor4 = Color.parseColor("#FFD0021B");
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_bubble_field);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor4);
                    this.f17328j.setOnClickListener(this.f17334p);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 3:
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_bubble_loading_gif);
                    this.f17328j.setMsg(dimension, str, parseColor2);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 4:
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_bubble_succ);
                    this.f17328j.setMsg(dimension, str, parseColor2);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 5:
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_bubble_location_icon);
                    this.f17328j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.setAction(this.f17334p);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 6:
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_bubble_people);
                    this.f17328j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.setAction(this.f17334p);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 7:
                    if (!isBubbleShown()) {
                        m14560a(str, 12);
                        m14561a(str, (Runnable) null);
                        break;
                    } else {
                        dismissBubble(new Runnable() {
                            public void run() {
                                SafeToolkitView.this.m14560a(str, 12);
                                SafeToolkitView.this.m14561a(str, (Runnable) null);
                            }
                        });
                        break;
                    }
                case 8:
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_bubble_edit);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor);
                    this.f17328j.setAction(this.f17334p);
                    CarOrder order = CarOrderHelper.getOrder();
                    if (order != null && !TextUtils.isEmpty(order.oid) && !TextUtils.isEmpty(str)) {
                        this.f17328j.showBubble((Runnable) null);
                        break;
                    }
                case 9:
                    int dimension2 = (int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width);
                    if (TripRecordingManager.Companion.getInstance().isRecording()) {
                        this.f17328j.setIconResources(R.drawable.sf_toolkit_dialog_record_audio_open_icon);
                        safeToolkitData.content = this.mContext.getResources().getString(R.string.sf_safe_toolkit_bubble_trip_audio_recording);
                    } else {
                        this.f17328j.setIconResources(R.drawable.sf_toolkit_dialog_record_audio_close_icon);
                        this.f17328j.setMsg(dimension2, str, parseColor2);
                    }
                    this.f17328j.setActionVisible(false);
                    this.f17328j.setOnClickListener(this.f17334p);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 10:
                    this.f17328j.setIconResources(R.drawable.sf_toolkit_dialog_record_audio_open_icon);
                    this.f17328j.setMsg((int) getView().getResources().getDimension(R.dimen.reporting_bubble_text_max_width), str, parseColor2);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.setOnClickListener(this.f17334p);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 11:
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_monitor_start);
                    this.f17328j.setMsg((int) (((double) windowWidth) * 0.3d), str, parseColor2);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 12:
                    ViewGroup.LayoutParams layoutParams = this.f17322d.getLayoutParams();
                    layoutParams.width = UiUtils.dip2px(getContext(), 63.0f);
                    layoutParams.height = UiUtils.dip2px(getContext(), 63.0f);
                    this.f17322d.setLayoutParams(layoutParams);
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_monitor_warning);
                    this.f17328j.setMsg((int) (((double) windowWidth) * 0.35d), str, -1);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.isMonitorWarningStyle(true);
                    BreathViewHelper.startBreath(this.f17323e, this.f17324f);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 13:
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_monitor_pre);
                    this.f17328j.setMsg((int) (((double) windowWidth) * 0.4d), str, parseColor);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.setAction(this.f17334p);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 14:
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_monitor_start);
                    this.f17328j.setMsg((int) (((double) windowWidth) * 0.3d), str, parseColor2);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.showBubble((Runnable) null);
                    break;
                case 15:
                    this.f17328j.setIconResources(R.drawable.sf_safe_toolkit_monitor_pre);
                    this.f17328j.setMsg((int) (((double) windowWidth) * 0.3d), str, parseColor2);
                    this.f17328j.setActionVisible(false);
                    this.f17328j.showBubble((Runnable) null);
                    break;
            }
            SafetoolkitOmegaUtils.sendBubbleShow(i);
        } else {
            dismissWelcome(new Runnable() {
                public void run() {
                    SafeToolkitView.this.setSafeToolkitStatusAndShow(safeToolkitData);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14560a(final String str, final int i) {
        if (this.f17325g.getLayout() == null) {
            this.f17325g.post(new Runnable() {
                public void run() {
                    SafeToolkitView.this.m14560a(str, i);
                }
            });
            return;
        }
        this.f17325g.setTextSize(2, (float) i);
        this.f17325g.setText(str);
        if (m14562a(this.f17325g) && i >= 9) {
            m14560a(str, i - 1);
        }
    }

    /* renamed from: a */
    private boolean m14562a(TextView textView) {
        Layout layout = textView.getLayout();
        if (layout == null || layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14561a(String str, final Runnable runnable) {
        if (isVisibility() && !isBubbleShown()) {
            this.f17325g.post(new Runnable() {
                public void run() {
                    SafeToolkitView.this.f17325g.measure(0, 0);
                    int measuredWidth = SafeToolkitView.this.f17325g.getMeasuredWidth();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) SafeToolkitView.this.f17325g.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    SafeToolkitView.this.f17325g.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) SafeToolkitView.this.f17326h.getLayoutParams();
                    SafeToolkitView.this.m14555a(measuredWidth + layoutParams.leftMargin + layoutParams2.leftMargin + layoutParams2.width, runnable);
                }
            });
        }
    }

    public void dismissWelcome(Runnable runnable) {
        if (isVisibility() && isWelcomeShown()) {
            m14559a(runnable);
        }
    }

    public boolean isBubbleShown() {
        BubbleView bubbleView = this.f17328j;
        if (bubbleView != null) {
            return bubbleView.isBubbleShown();
        }
        return false;
    }

    public void dismissBubble(Runnable runnable) {
        BubbleView bubbleView = this.f17328j;
        if (bubbleView != null) {
            bubbleView.dismissBubble(runnable);
        }
    }

    public boolean isWelcomeShown() {
        return this.f17330l;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14555a(final int i, final Runnable runnable) {
        this.f17329k.setVisibility(0);
        this.f17329k.post(new Runnable() {
            public void run() {
                if (SafeToolkitView.this.f17331m == null) {
                    ValueAnimator unused = SafeToolkitView.this.f17331m = new ValueAnimator();
                    SafeToolkitView.this.f17331m.setDuration(1000);
                } else {
                    SafeToolkitView.this.f17331m.cancel();
                    SafeToolkitView.this.f17331m.removeAllUpdateListeners();
                    SafeToolkitView.this.f17331m.removeAllListeners();
                }
                SafeToolkitView.this.f17331m.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        SafeToolkitView.this.f17329k.setVisibility(0);
                        boolean unused = SafeToolkitView.this.f17330l = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                int measuredWidth = SafeToolkitView.this.f17321c.getMeasuredWidth();
                SafeToolkitView.this.f17331m.setIntValues(new int[]{measuredWidth, i + measuredWidth});
                SafeToolkitView.this.f17331m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SafeToolkitView.this.f17329k.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        SafeToolkitView.this.f17329k.setLayoutParams(layoutParams);
                        SafeToolkitView.this.f17329k.invalidate();
                    }
                });
                SafeToolkitView.this.f17331m.start();
            }
        });
    }

    /* renamed from: a */
    private void m14559a(final Runnable runnable) {
        this.f17329k.post(new Runnable() {
            public void run() {
                if (SafeToolkitView.this.f17331m == null) {
                    ValueAnimator unused = SafeToolkitView.this.f17331m = new ValueAnimator();
                    SafeToolkitView.this.f17331m.setDuration(500);
                } else {
                    SafeToolkitView.this.f17331m.cancel();
                    SafeToolkitView.this.f17331m.removeAllUpdateListeners();
                    SafeToolkitView.this.f17331m.removeAllListeners();
                }
                SafeToolkitView.this.f17331m.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        SafeToolkitView.this.f17329k.setVisibility(0);
                        boolean unused = SafeToolkitView.this.f17330l = false;
                    }

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SafeToolkitView.this.f17329k.getLayoutParams();
                        layoutParams.width = SafeToolkitView.this.f17321c.getMeasuredWidth();
                        SafeToolkitView.this.f17329k.setLayoutParams(layoutParams);
                        SafeToolkitView.this.f17329k.setVisibility(4);
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                int measuredWidth = SafeToolkitView.this.f17321c.getMeasuredWidth();
                SafeToolkitView.this.f17331m.setIntValues(new int[]{SafeToolkitView.this.f17329k.getMeasuredWidth(), measuredWidth});
                SafeToolkitView.this.f17331m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SafeToolkitView.this.f17329k.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        SafeToolkitView.this.f17329k.setLayoutParams(layoutParams);
                        SafeToolkitView.this.f17329k.invalidate();
                    }
                });
                SafeToolkitView.this.f17331m.start();
            }
        });
    }

    public void resetBreathAnim() {
        m14554a();
    }

    public void setDismissedByAlpha(boolean z) {
        ObjectAnimator objectAnimator;
        View view = this.f17320b;
        if (view != null) {
            if (z) {
                objectAnimator = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f}).setDuration(300);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SafeToolkitView.this.f17320b.setVisibility(4);
                    }
                });
            } else {
                objectAnimator = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f}).setDuration(300);
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SafeToolkitView.this.f17320b.setVisibility(0);
                    }
                });
            }
            objectAnimator.start();
        }
    }

    /* renamed from: a */
    private void m14554a() {
        ViewGroup.LayoutParams layoutParams = this.f17322d.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.f17322d.setLayoutParams(layoutParams);
        this.f17323e.clearAnimation();
        this.f17324f.clearAnimation();
        this.f17328j.isMonitorWarningStyle(false);
        this.f17323e.setVisibility(8);
        this.f17324f.setVisibility(8);
    }
}
