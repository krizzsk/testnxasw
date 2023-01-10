package com.didi.component.safetoolkit.views.bubbles;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.didi.component.safetoolkit.views.animation.ViewSizeAnimation;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class BubbleView extends LinearLayout {
    public static final int EXPAND_ANIMATION_DURATION_MILLS = 800;
    public static final float START_ANIMATION_FRACTION_1 = 0.5f;
    public static final int UPDATESIZE_ANMATION_DURATION_MILLS = 800;

    /* renamed from: a */
    List<Runnable> f17342a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f17343b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f17344c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f17345d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f17346e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f17347f;

    /* renamed from: g */
    private SpringAnimation f17348g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f17349h;

    /* renamed from: i */
    private ViewSizeAnimation f17350i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ValueAnimator f17351j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f17352k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f17353l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f17354m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f17355n;

    public interface HideActionAnimationCallback {
        void onAnimationEnd(int i);
    }

    public BubbleView(Context context) {
        super(context);
        m14576a(context);
    }

    public BubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14576a(context);
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14576a(context);
    }

    /* renamed from: a */
    private void m14576a(Context context) {
        setOrientation(0);
        setBackgroundResource(R.drawable.sf_safe_toolkit_bubble_bg);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.sf_safe_toolkit_bubble_layout, this, true);
        this.f17343b = (ImageView) findViewById(R.id.sf_safe_toolkit_bubble_icon);
        this.f17344c = (TextView) findViewById(R.id.sf_safe_toolkit_bubble_msg);
        this.f17345d = (TextView) findViewById(R.id.sf_safe_toolkit_bubble_action);
        this.f17344c.setAlpha(0.0f);
        this.f17343b.setImageAlpha(0);
    }

    public void setMsgVisible(boolean z) {
        TextView textView = this.f17344c;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setActionVisible(boolean z) {
        if (z != this.f17349h) {
            this.f17354m = true;
        }
        this.f17349h = z;
        TextView textView = this.f17345d;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        if (!this.f17349h) {
            setOnClickListener((View.OnClickListener) null);
        }
    }

    public boolean isActionVisible() {
        return this.f17349h;
    }

    public void setIconResources(int i) {
        if (this.f17343b != null) {
            try {
                ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(Integer.valueOf(i)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).fitCenter()).into(this.f17343b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setMsg(int i, String str, int i2) {
        setMsg(i, str, i2, -1);
    }

    public void setMsg(int i, String str, int i2, int i3) {
        TextView textView = this.f17344c;
        if (textView != null) {
            textView.setVisibility(0);
            this.f17344c.setMaxWidth(i);
            this.f17344c.setText(str);
            if (i3 > 0) {
                this.f17344c.setTextSize((float) i3);
            }
            this.f17344c.setTextColor(i2);
            int measureText = (int) this.f17344c.getPaint().measureText(this.f17344c.getText().toString());
            if (measureText > this.f17344c.getMaxWidth()) {
                measureText = this.f17344c.getMaxWidth();
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17344c.getLayoutParams();
            layoutParams.width = measureText;
            this.f17344c.setLayoutParams(layoutParams);
        }
    }

    public void setAction(String str, int i, View.OnClickListener onClickListener) {
        if (this.f17345d != null) {
            setOnClickListener(onClickListener);
            this.f17345d.setTextColor(i);
            this.f17345d.setText(str);
            int measureText = (int) this.f17345d.getPaint().measureText(this.f17345d.getText().toString());
            if (measureText > this.f17345d.getMaxWidth()) {
                measureText = this.f17345d.getMaxWidth();
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17345d.getLayoutParams();
            layoutParams.width = measureText;
            this.f17345d.setLayoutParams(layoutParams);
        }
    }

    public void setAction(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void isMonitorWarningStyle(boolean z) {
        setBackgroundResource(z ? R.drawable.sf_safe_toolkit_monitor_bubble_blue_bg : R.drawable.sf_safe_toolkit_bubble_bg);
    }

    public void onAnimationStarted() {
        this.f17344c.setVisibility(4);
        if (this.f17349h) {
            this.f17345d.setVisibility(4);
            this.f17345d.setAlpha(0.0f);
        }
        this.f17343b.setImageAlpha(0);
        this.f17344c.setAlpha(0.0f);
    }

    public void onAnimationEnded() {
        this.f17344c.setVisibility(0);
        this.f17344c.setAlpha(1.0f);
        this.f17343b.setImageAlpha(255);
        if (this.f17349h) {
            showActionAlphaAnimation();
        }
        this.f17346e = false;
    }

    public void onAnimationUpdate(int i, int i2, int i3, int i4, float f) {
        if (!this.f17346e && f >= 0.5f) {
            this.f17346e = true;
            m14575a();
            m14580b();
        }
    }

    public void hideActionAlphaAnimation(final HideActionAnimationCallback hideActionAnimationCallback) {
        this.f17345d.setVisibility(0);
        this.f17345d.setAlpha(1.0f);
        this.f17345d.post(new Runnable() {
            public void run() {
                final int measuredWidth = BubbleView.this.f17345d.getMeasuredWidth();
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setFloatValues(new float[]{1.0f, 0.0f});
                valueAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        BubbleView.this.f17345d.setAlpha(0.0f);
                        BubbleView.this.f17345d.setVisibility(8);
                        if (hideActionAnimationCallback != null) {
                            hideActionAnimationCallback.onAnimationEnd(measuredWidth + ((LinearLayout.LayoutParams) BubbleView.this.f17345d.getLayoutParams()).leftMargin);
                        }
                    }
                });
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BubbleView.this.f17345d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                valueAnimator.setDuration(300);
                valueAnimator.start();
            }
        });
    }

    public void showActionAlphaAnimation() {
        this.f17345d.setVisibility(0);
        this.f17345d.setAlpha(0.0f);
        this.f17345d.post(new Runnable() {
            public void run() {
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        BubbleView.this.f17345d.setAlpha(1.0f);
                    }
                });
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BubbleView.this.f17345d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                valueAnimator.setDuration(300);
                valueAnimator.setStartDelay(100);
                valueAnimator.start();
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showBubble(final java.lang.Runnable r13) {
        /*
            r12 = this;
            boolean r3 = r12.f17349h
            int r0 = r12.getVisibility()
            if (r0 == 0) goto L_0x000c
            r0 = 4
            r12.setVisibility(r0)
        L_0x000c:
            boolean r0 = r12.f17355n
            if (r0 == 0) goto L_0x001b
            java.util.List<java.lang.Runnable> r0 = r12.f17342a
            com.didi.component.safetoolkit.views.bubbles.BubbleView$3 r1 = new com.didi.component.safetoolkit.views.bubbles.BubbleView$3
            r1.<init>(r13)
            r0.add(r1)
            return
        L_0x001b:
            android.widget.TextView r0 = r12.f17344c
            r1 = 0
            r0.measure(r1, r1)
            android.widget.TextView r0 = r12.f17344c
            int r4 = r0.getMeasuredWidth()
            int r0 = r12.f17352k
            int r0 = r4 - r0
            android.widget.TextView r2 = r12.f17345d
            r2.measure(r1, r1)
            android.widget.TextView r2 = r12.f17345d
            int r5 = r2.getMeasuredWidth()
            int r2 = r12.f17353l
            int r2 = r5 - r2
            int r6 = r12.getTargetViewWidth()
            boolean r7 = r12.f17354m
            java.lang.String r8 = "showBubble"
            if (r7 == 0) goto L_0x006e
            if (r3 != 0) goto L_0x006e
            android.widget.TextView r1 = r12.f17345d
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            int r1 = r1.leftMargin
            int r1 = -r1
            int r2 = r12.f17353l
            int r2 = -r2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "1 isActionVisibilityChanged:"
            r7.append(r9)
            boolean r9 = r12.f17354m
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            com.didi.component.common.util.GLog.m11360i(r8, r7)
        L_0x006a:
            r11 = r2
            r2 = r1
            r1 = r11
            goto L_0x00c6
        L_0x006e:
            boolean r7 = r12.f17354m
            if (r7 == 0) goto L_0x0095
            if (r3 == 0) goto L_0x0095
            android.widget.TextView r1 = r12.f17345d
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            int r1 = r1.leftMargin
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "2 isActionVisibilityChanged:"
            r7.append(r9)
            boolean r9 = r12.f17354m
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            com.didi.component.common.util.GLog.m11360i(r8, r7)
            goto L_0x006a
        L_0x0095:
            if (r3 != 0) goto L_0x00ae
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "3 isActionVisibilityChanged:"
            r2.append(r7)
            boolean r7 = r12.f17354m
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            com.didi.component.common.util.GLog.m11360i(r8, r2)
            goto L_0x00c5
        L_0x00ae:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "-1 isActionVisibilityChanged:"
            r7.append(r9)
            boolean r9 = r12.f17354m
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            com.didi.component.common.util.GLog.m11360i(r8, r7)
            r1 = r2
        L_0x00c5:
            r2 = 0
        L_0x00c6:
            int r7 = r6 + r0
            int r7 = r7 + r1
            int r7 = r7 + r2
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "targetWidth:"
            r9.append(r10)
            r9.append(r7)
            java.lang.String r10 = " msgOffset:"
            r9.append(r10)
            r9.append(r0)
            java.lang.String r0 = " actionWidth:"
            r9.append(r0)
            r9.append(r1)
            java.lang.String r0 = " marginLeft:"
            r9.append(r0)
            r9.append(r2)
            java.lang.String r0 = " nowTotalWidth:"
            r9.append(r0)
            r9.append(r6)
            java.lang.String r0 = r9.toString()
            com.didi.component.common.util.GLog.m11360i(r8, r0)
            int r0 = r12.getTargetViewWidth()
            if (r0 != r7) goto L_0x0119
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "targetWidth equals measureWidth:"
            r13.append(r0)
            r13.append(r7)
            java.lang.String r13 = r13.toString()
            com.didi.component.common.util.GLog.m11360i(r8, r13)
            return
        L_0x0119:
            com.didi.component.safetoolkit.views.animation.ViewSizeAnimation r0 = new com.didi.component.safetoolkit.views.animation.ViewSizeAnimation
            r0.<init>(r12, r7)
            r12.f17350i = r0
            boolean r0 = r12.isBubbleShown()
            r1 = 800(0x320, double:3.953E-321)
            if (r0 == 0) goto L_0x013c
            com.didi.component.safetoolkit.views.animation.ViewSizeAnimation r0 = r12.f17350i
            r0.setDuration(r1)
            com.didi.component.safetoolkit.views.animation.ViewSizeAnimation r8 = r12.f17350i
            com.didi.component.safetoolkit.views.bubbles.BubbleView$4 r9 = new com.didi.component.safetoolkit.views.bubbles.BubbleView$4
            r0 = r9
            r1 = r12
            r2 = r7
            r6 = r13
            r0.<init>(r2, r3, r4, r5, r6)
            r8.setAnimationListener(r9)
            goto L_0x0155
        L_0x013c:
            com.didi.component.safetoolkit.views.animation.ViewSizeAnimation r0 = r12.f17350i
            r0.setDuration(r1)
            com.didi.component.safetoolkit.views.animation.ViewSizeAnimation r0 = r12.f17350i
            com.didi.component.safetoolkit.views.bubbles.BubbleView$5 r1 = new com.didi.component.safetoolkit.views.bubbles.BubbleView$5
            r1.<init>(r3, r13)
            r0.setAnimationListener(r1)
            com.didi.component.safetoolkit.views.animation.ViewSizeAnimation r13 = r12.f17350i
            com.didi.component.safetoolkit.views.bubbles.BubbleView$6 r0 = new com.didi.component.safetoolkit.views.bubbles.BubbleView$6
            r0.<init>()
            r13.setAnimationUpdater(r0)
        L_0x0155:
            com.didi.component.safetoolkit.views.animation.ViewSizeAnimation r13 = r12.f17350i
            r12.startAnimation(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.safetoolkit.views.bubbles.BubbleView.showBubble(java.lang.Runnable):void");
    }

    private int getTargetViewWidth() {
        return getLayoutParams().width;
    }

    public void dismissBubble(final Runnable runnable) {
        ValueAnimator valueAnimator = this.f17351j;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f17351j = valueAnimator2;
            valueAnimator2.setDuration(400);
        } else {
            valueAnimator.cancel();
            this.f17351j.removeAllUpdateListeners();
            this.f17351j.removeAllListeners();
        }
        this.f17351j.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                boolean unused = BubbleView.this.f17347f = false;
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) BubbleView.this.getLayoutParams();
                layoutParams.width = BubbleView.this.m14572a(79);
                BubbleView.this.setLayoutParams(layoutParams);
                BubbleView.this.setVisibility(8);
                BubbleView.this.setAlpha(1.0f);
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
                int unused = BubbleView.this.f17352k = 0;
                int unused2 = BubbleView.this.f17353l = 0;
                BubbleView.this.f17343b.setVisibility(4);
                BubbleView.this.f17344c.setVisibility(8);
                BubbleView.this.f17344c.setAlpha(0.0f);
                BubbleView.this.f17343b.setImageAlpha(0);
                BubbleView.this.f17345d.setVisibility(8);
                boolean unused3 = BubbleView.this.f17349h = false;
                boolean unused4 = BubbleView.this.f17354m = false;
                boolean unused5 = BubbleView.this.f17346e = false;
            }
        });
        post(new Runnable() {
            public void run() {
                BubbleView.this.f17351j.setFloatValues(new float[]{1.0f, 0.0f});
                BubbleView.this.f17351j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BubbleView.this.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                BubbleView.this.f17351j.start();
            }
        });
    }

    /* renamed from: a */
    private void m14575a() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                BubbleView.this.f17344c.setAlpha(0.0f);
                BubbleView.this.f17344c.setVisibility(0);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BubbleView.this.f17344c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.setDuration(400);
        valueAnimator.start();
        ValueAnimator valueAnimator2 = new ValueAnimator();
        valueAnimator2.setIntValues(new int[]{0, 255});
        valueAnimator2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                BubbleView.this.f17343b.setImageAlpha(0);
                BubbleView.this.f17343b.setVisibility(0);
            }
        });
        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BubbleView.this.f17343b.setImageAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimator2.setDuration(400);
        valueAnimator2.start();
    }

    public boolean isBubbleShown() {
        return this.f17347f;
    }

    /* renamed from: b */
    private void m14580b() {
        this.f17344c.setVisibility(0);
        TextView textView = this.f17344c;
        textView.setTranslationX((float) (textView.getMeasuredWidth() * 2));
        SpringAnimation springAnimation = new SpringAnimation(this.f17344c, SpringAnimation.TRANSLATION_X, 0.0f);
        this.f17348g = springAnimation;
        springAnimation.getSpring().setDampingRatio(0.85f);
        this.f17348g.getSpring().setStiffness(30.0f);
        this.f17348g.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m14572a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }
}
