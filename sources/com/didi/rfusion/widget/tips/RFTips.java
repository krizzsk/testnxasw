package com.didi.rfusion.widget.tips;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.rfusion.utils.RFDisplayUtils;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFTips extends FrameLayout {

    /* renamed from: a */
    private static final String f36691a = "RFTips";

    /* renamed from: b */
    private ImageView f36692b;

    /* renamed from: c */
    private RFTextView f36693c;

    /* renamed from: d */
    private RFIconView f36694d;

    /* renamed from: e */
    private ObjectAnimator f36695e;

    /* renamed from: f */
    private ObjectAnimator f36696f;

    /* renamed from: g */
    private ObjectAnimator f36697g;

    /* renamed from: h */
    private int f36698h;

    /* renamed from: i */
    private boolean f36699i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f36700j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f36701k;

    /* renamed from: l */
    private int f36702l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public OnTransitionListener f36703m;

    interface OnTransitionListener {
        void onTipsHide();

        void onTipsShow();
    }

    public RFTips(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFTips(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFTips(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36698h = 0;
        this.f36699i = false;
        this.f36700j = true;
        this.f36701k = false;
        this.f36702l = 0;
        m27673a();
        m27676b();
        m27679c();
        m27680d();
    }

    /* renamed from: a */
    private void m27673a() {
        LayoutInflater.from(getContext()).inflate(R.layout.rf_tips, this);
        this.f36692b = (ImageView) findViewById(R.id.rf_iv_icon);
        this.f36693c = (RFTextView) findViewById(R.id.rf_tv_content);
        this.f36694d = (RFIconView) findViewById(R.id.rf_iv_close);
        post(new Runnable() {
            public final void run() {
                RFTips.this.m27691l();
            }
        });
        setArrowLocation(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m27691l() {
        Rect rect = new Rect();
        this.f36694d.getHitRect(rect);
        setTouchDelegate(new TouchDelegate(new Rect(rect.left - ((int) RFResUtils.getDimens(R.dimen.rf_tips_close_margin_left)), rect.top - ((int) RFResUtils.getDimens(R.dimen.rf_tips_padding_height)), rect.right + (((int) RFResUtils.getDimens(R.dimen.rf_tips_padding_width)) * 2), rect.bottom + (((int) RFResUtils.getDimens(R.dimen.rf_tips_padding_width)) * 2)), this.f36694d));
    }

    /* renamed from: b */
    private void m27676b() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, (float) (-RFDisplayUtils.dp2px(5.0f)), 0.0f})});
        this.f36695e = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setRepeatCount(-1);
        this.f36695e.setRepeatMode(2);
        Path path = new Path();
        path.quadTo(0.19f, 0.5f, 0.33f, 0.5f);
        path.cubicTo(0.5f, 0.55f, 0.5f, 1.0f, 1.0f, 1.0f);
        this.f36695e.setInterpolator(PathInterpolatorCompat.create(path));
        this.f36695e.setDuration(900);
        this.f36695e.setStartDelay(400);
    }

    /* renamed from: c */
    private void m27679c() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f}), ofFloat});
        this.f36696f = ofPropertyValuesHolder;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (RFTips.this.f36701k) {
                    RFTips.this.m27682e();
                }
                if (RFTips.this.f36703m != null) {
                    RFTips.this.f36703m.onTipsShow();
                }
            }
        });
        this.f36696f.setDuration(300);
        this.f36696f.setInterpolator(decelerateInterpolator);
    }

    /* renamed from: d */
    private void m27680d() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.0f}), ofFloat});
        this.f36697g = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(300);
        this.f36697g.setInterpolator(decelerateInterpolator);
        this.f36697g.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                RFTips.this.m27684f();
                RFTips.super.setVisibility(8);
                if (RFTips.this.f36703m != null) {
                    RFTips.this.f36703m.onTipsHide();
                }
            }
        });
    }

    public void setIcon(int i) {
        this.f36692b.setVisibility(0);
        this.f36692b.setImageDrawable(RFResUtils.getDrawable(i));
    }

    public void setIcon(Drawable drawable) {
        if (drawable == null) {
            this.f36692b.setVisibility(8);
            return;
        }
        this.f36692b.setVisibility(0);
        this.f36692b.setImageDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f36699i = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                RFTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RFTips.this.f36700j && RFTips.this.getVisibility() == 0) {
                    RFTips.this.m27688i();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f36696f.isRunning()) {
            this.f36696f.end();
        }
        if (this.f36697g.isRunning()) {
            this.f36697g.end();
        }
        m27684f();
        this.f36699i = false;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (i == 0) {
            m27687h();
        } else {
            m27686g();
        }
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            if (!this.f36699i || !this.f36700j) {
                super.setVisibility(i);
            } else if (i == 0) {
                m27688i();
            } else if (i == 8) {
                m27689j();
            } else {
                super.setVisibility(i);
            }
        }
    }

    public void setIconVisible(boolean z) {
        this.f36692b.setVisibility(z ? 0 : 8);
    }

    public void setText(int i) {
        this.f36693c.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.f36693c.setText(charSequence);
    }

    public void setType(int i) {
        if (this.f36702l != i) {
            this.f36702l = i;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            this.f36693c.setTextColor(RFResUtils.getColor(z ? R.color.rf_color_white_100_FFFFFF : R.color.rf_color_gery_1_0_000000));
            this.f36694d.setTextColor(RFResUtils.getColor(z ? R.color.rf_selector_tips_close_dark : R.color.rf_selector_tips_close));
            setArrowLocation(this.f36698h);
        }
    }

    public void setArrowLocation(int i) {
        this.f36698h = i;
        boolean z = this.f36702l == 1;
        if (i == 0) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_top_center_dark : R.drawable.rf_bg_tip_top_center);
        } else if (i == 1) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_top_left_dark : R.drawable.rf_bg_tip_top_left);
        } else if (i == 2) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_top_right_dark : R.drawable.rf_bg_tip_top_right);
        } else if (i == 3) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_bottom_center_dark : R.drawable.rf_bg_tip_bottom_center);
        } else if (i == 4) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_bottom_left_dark : R.drawable.rf_bg_tip_bottom_left);
        } else if (i == 5) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_bottom_right_dark : R.drawable.rf_bg_tip_bottom_right);
        }
    }

    public void setEnableTransition(boolean z) {
        this.f36700j = z;
    }

    public void startShake() {
        this.f36701k = true;
        m27682e();
    }

    public void stopShake() {
        this.f36701k = false;
        m27684f();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m27682e() {
        if (!this.f36695e.isRunning() && this.f36699i) {
            this.f36695e.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m27684f() {
        if (this.f36695e.isRunning()) {
            this.f36695e.end();
        }
    }

    /* renamed from: g */
    private void m27686g() {
        if (this.f36695e.isRunning()) {
            this.f36695e.pause();
        }
    }

    /* renamed from: h */
    private void m27687h() {
        if (this.f36695e.isPaused()) {
            this.f36695e.resume();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m27688i() {
        if (this.f36697g.isRunning()) {
            this.f36697g.end();
        }
        super.setVisibility(0);
        m27690k();
        this.f36696f.start();
    }

    /* renamed from: j */
    private void m27689j() {
        if (this.f36696f.isRunning()) {
            this.f36696f.end();
        }
        m27690k();
        this.f36697g.start();
    }

    /* renamed from: k */
    private void m27690k() {
        int i;
        int i2;
        int i3 = this.f36698h;
        int i4 = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    i4 = getMeasuredWidth() / 2;
                    i = getMeasuredHeight();
                } else if (i3 == 4) {
                    i = getMeasuredHeight();
                } else if (i3 != 5) {
                    i2 = getMeasuredWidth() / 2;
                } else {
                    i4 = getMeasuredWidth();
                    i = getMeasuredHeight();
                }
                setPivotX((float) i4);
                setPivotY((float) i);
            }
            i2 = getMeasuredWidth();
            i4 = i2;
        }
        i = 0;
        setPivotX((float) i4);
        setPivotY((float) i);
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.f36694d.setOnClickListener(onClickListener);
        this.f36694d.setVisibility(onClickListener != null ? 0 : 8);
    }

    /* access modifiers changed from: package-private */
    public void setTransitionListener(OnTransitionListener onTransitionListener) {
        this.f36703m = onTransitionListener;
    }
}
