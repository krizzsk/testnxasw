package com.didi.rfusion.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.passenger.C11267R;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.config.RFusionConfig;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.loading.RFLottieLoadingView;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.sofa.animation.Animator;
import com.didichuxing.sofa.animation.AnimatorListenerAdapter;
import com.didichuxing.sofa.animation.SofaAnimatorCompat;
import com.taxis99.R;

public class RFSlideButton extends FrameLayout {

    /* renamed from: a */
    private static final String f36122a = "RFSlideButton";

    /* renamed from: b */
    private static final float f36123b = 0.3f;

    /* renamed from: c */
    private RFusionConfig.IRFusionLogger f36124c;

    /* renamed from: d */
    private ImageView f36125d;

    /* renamed from: e */
    private View f36126e;

    /* renamed from: f */
    private RFLottieLoadingView f36127f;

    /* renamed from: g */
    private LinearLayout f36128g;

    /* renamed from: h */
    private RFTextView f36129h;

    /* renamed from: i */
    private RFTextView f36130i;

    /* renamed from: j */
    private float f36131j;

    /* renamed from: k */
    private float f36132k;

    /* renamed from: l */
    private float f36133l;

    /* renamed from: m */
    private float f36134m;

    /* renamed from: n */
    private float f36135n;

    /* renamed from: o */
    private int f36136o;

    /* renamed from: p */
    private float f36137p;

    /* renamed from: q */
    private long f36138q;

    /* renamed from: r */
    private OnSlideActionListener f36139r;

    public interface OnSlideActionListener {
        void onActionCancel(RFSlideButton rFSlideButton);

        void onActionConfirmed(RFSlideButton rFSlideButton);

        void onTouchActionDown(RFSlideButton rFSlideButton);

        void onTouchActionMove(RFSlideButton rFSlideButton);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public RFSlideButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFSlideButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFSlideButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36124c = RFLogger.getLogger();
        this.f36138q = 0;
        m27181a();
        m27182a(attributeSet);
    }

    /* renamed from: a */
    private void m27182a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.RFSlideButton);
        String string = obtainStyledAttributes.getString(1);
        String string2 = obtainStyledAttributes.getString(2);
        boolean z = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        setText(string);
        setTips(string2);
        setEnabled(z);
    }

    /* renamed from: a */
    private void m27181a() {
        inflate(getContext(), R.layout.rf_btn_slide, this);
        this.f36125d = (ImageView) findViewById(R.id.rf_icon_arrow);
        this.f36126e = findViewById(R.id.rf_rl_foreground);
        this.f36127f = (RFLottieLoadingView) findViewById(R.id.rf_llv_loading);
        this.f36128g = (LinearLayout) findViewById(R.id.rf_ll_content);
        this.f36129h = (RFTextView) findViewById(R.id.rf_tv_text);
        this.f36130i = (RFTextView) findViewById(R.id.rf_tv_tips);
        this.f36126e.setClickable(false);
        this.f36125d.setImageResource(R.drawable.rf_icon_btn_slide_arrow);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m27184a("onLayout() called with: changed = [" + z + "], left = [" + i + "], top = [" + i2 + "], right = [" + i3 + "], bottom = [" + i4 + Const.jaRight);
        if (z) {
            this.f36135n = 0.0f;
            this.f36136o = getWidth();
            m27184a("onLayout mViewInitialX: " + this.f36135n + " mViewWidth: " + this.f36136o);
        }
    }

    /* renamed from: a */
    private void m27184a(String str) {
        this.f36124c.info(f36122a, str);
    }

    /* renamed from: b */
    private void m27187b(String str) {
        this.f36124c.info(f36122a, str);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f36126e.setEnabled(z);
    }

    public void setText(String str) {
        this.f36129h.setText(str);
    }

    public void setTips(String str) {
        this.f36130i.setText(str);
        if (TextUtils.isEmpty(str)) {
            this.f36130i.setVisibility(8);
            this.f36128g.setPadding((int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_slide_text_margin_left), 0, (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_slide_text_margin_right), 0);
            return;
        }
        this.f36130i.setVisibility(0);
        this.f36128g.setPadding((int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_slide_text_margin_left_large), 0, (int) RFResUtils.getDimens(getContext(), R.dimen.rf_btn_slide_text_margin_right), 0);
    }

    public void setLoading(boolean z) {
        if (z) {
            this.f36127f.show();
            return;
        }
        m27190e();
        this.f36127f.hide();
    }

    public void setOnSlideActionListener(OnSlideActionListener onSlideActionListener) {
        this.f36139r = onSlideActionListener;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f36127f.isRunning()) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f36131j = motionEvent.getRawX();
            m27184a("ACTION_DOWN mRawXStart: " + this.f36131j);
            m27191f();
        } else if (actionMasked == 1) {
            requestDisallowInterceptTouchEvent(false);
            float rawX = motionEvent.getRawX();
            this.f36133l = rawX;
            this.f36134m = rawX - this.f36131j;
            m27184a("ACTION_UP mRawXEnd: " + this.f36133l + " mMoveDeltaX:" + this.f36134m + " mViewWidth: " + this.f36136o);
            if (this.f36134m <= ((float) this.f36136o) * 0.3f) {
                m27187b("action not confirmed");
                m27188c();
            } else {
                m27187b("action confirmed");
                m27185b();
            }
        } else if (actionMasked == 2) {
            float rawX2 = motionEvent.getRawX();
            this.f36132k = rawX2;
            this.f36134m = rawX2 - this.f36131j;
            m27184a("ACTION_MOVE mRawXMove: " + this.f36132k + " mRawXStart: " + this.f36131j + " mMoveDeltaX: " + this.f36134m);
            if (Math.abs(this.f36134m) > ((float) this.f36136o) * 0.02f) {
                requestDisallowInterceptTouchEvent(true);
                float max = Math.max(this.f36134m, this.f36135n);
                m27192g();
                setSlideX(max);
                m27189d();
            }
        } else if (actionMasked == 3) {
            m27193h();
        }
        return true;
    }

    /* renamed from: b */
    private void m27185b() {
        float f = this.f36137p;
        float f2 = this.f36135n + ((float) this.f36136o);
        SofaAnimatorCompat.play(this).property("SlideX", f, f2).property("TextAlpha", getTextAlpha(), 0.0f).duration((int) ((Math.abs(f2 - f) / ((float) this.f36136o)) * 1000.0f)).decelerate().withListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator, View view) {
                super.onAnimationEnd(animator, view);
                RFSlideButton.this.m27194i();
            }
        }).build().start();
    }

    /* renamed from: c */
    private void m27188c() {
        float f = this.f36137p;
        float f2 = this.f36135n;
        if (f == f2) {
            m27193h();
            return;
        }
        SofaAnimatorCompat.play(this).property("SlideX", f, f2).property("TextAlpha", getTextAlpha(), 1.0f).duration((int) ((Math.abs(f2 - f) / ((float) this.f36136o)) * 1000.0f)).withListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator, View view) {
                super.onAnimationEnd(animator, view);
                RFSlideButton.this.m27193h();
            }
        }).build().start();
    }

    /* renamed from: d */
    private void m27189d() {
        float x = (this.f36126e.getX() * 1.0f) / ((float) this.f36136o);
        m27184a("fadeForegroundTextViewOnActionMove mViewWidth: " + this.f36136o + " foregroundView.getX(): " + this.f36126e.getX() + " ratio: " + x);
        setTextAlpha(Math.max(1.0f - x, 0.2f));
    }

    /* access modifiers changed from: protected */
    public void setTextAlpha(float f) {
        this.f36129h.setAlpha(f);
    }

    /* access modifiers changed from: protected */
    public float getTextAlpha() {
        return this.f36129h.getAlpha();
    }

    /* access modifiers changed from: protected */
    public void setSlideX(float f) {
        m27184a("setSlideX: " + f);
        this.f36137p = f;
        this.f36126e.setX(f);
    }

    /* renamed from: e */
    private void m27190e() {
        m27184a("ensureForegroundViewPosition mSlideX: " + this.f36137p + ", mViewInitialX: " + this.f36135n);
        float f = this.f36137p;
        float f2 = this.f36135n;
        if (f != f2) {
            setSlideX(f2);
        }
    }

    /* renamed from: f */
    private void m27191f() {
        this.f36126e.setSelected(true);
        m27184a("actionDown");
        OnSlideActionListener onSlideActionListener = this.f36139r;
        if (onSlideActionListener != null) {
            onSlideActionListener.onTouchActionDown(this);
        }
    }

    /* renamed from: g */
    private void m27192g() {
        m27184a("actionMove");
        OnSlideActionListener onSlideActionListener = this.f36139r;
        if (onSlideActionListener != null) {
            onSlideActionListener.onTouchActionMove(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m27193h() {
        this.f36126e.setSelected(false);
        m27184a("actionCancel");
        OnSlideActionListener onSlideActionListener = this.f36139r;
        if (onSlideActionListener != null) {
            onSlideActionListener.onActionCancel(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m27194i() {
        this.f36126e.setSelected(false);
        m27184a("actionConfirmed");
        long currentTimeMillis = System.currentTimeMillis() - this.f36138q;
        m27187b("actionConfirmed timeInterval: " + currentTimeMillis + " System.currentTimeMillis(): " + System.currentTimeMillis() + " mLastActionConfirmedTime: " + this.f36138q);
        if (currentTimeMillis <= 1000) {
            m27187b("Action is too frequent and return!");
            return;
        }
        this.f36138q = System.currentTimeMillis();
        OnSlideActionListener onSlideActionListener = this.f36139r;
        if (onSlideActionListener != null) {
            onSlideActionListener.onActionConfirmed(this);
        }
    }
}
