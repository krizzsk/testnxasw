package com.didi.nova.assembly.p128ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.nova.assembly.p128ui.shimmer.Shimmer;
import com.didi.nova.assembly.p128ui.shimmer.ShimmerTextView;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.sofa.animation.Animator;
import com.didichuxing.sofa.animation.AnimatorBuilder;
import com.didichuxing.sofa.animation.AnimatorListenerAdapter;
import com.didichuxing.sofa.animation.SofaAnimatorCompat;
import com.taxis99.R;

/* renamed from: com.didi.nova.assembly.ui.SlideButton */
public class SlideButton extends FrameLayout {

    /* renamed from: a */
    private static final String f31658a = "SodaSlideButton";

    /* renamed from: b */
    private static final float f31659b = 0.3f;

    /* renamed from: c */
    private ShimmerTextView f31660c;

    /* renamed from: d */
    private ImageView f31661d;

    /* renamed from: e */
    private View f31662e;

    /* renamed from: f */
    private View f31663f;

    /* renamed from: g */
    private LottieAnimationView f31664g;

    /* renamed from: h */
    private Shimmer f31665h;

    /* renamed from: i */
    private float f31666i;

    /* renamed from: j */
    private float f31667j;

    /* renamed from: k */
    private float f31668k;

    /* renamed from: l */
    private float f31669l;

    /* renamed from: m */
    private float f31670m;

    /* renamed from: n */
    private int f31671n;

    /* renamed from: o */
    private float f31672o;

    /* renamed from: p */
    private boolean f31673p;

    /* renamed from: q */
    private long f31674q;

    /* renamed from: r */
    private CustomStyle f31675r;

    /* renamed from: s */
    private OnSlideActionListener f31676s;

    /* renamed from: t */
    private boolean f31677t;

    /* renamed from: u */
    private boolean f31678u;

    /* renamed from: com.didi.nova.assembly.ui.SlideButton$OnSlideActionListener */
    public interface OnSlideActionListener {
        void onActionCancel(SlideButton slideButton);

        void onActionConfirmed(SlideButton slideButton);

        void onTouchActionDown(SlideButton slideButton);

        void onTouchActionMove(SlideButton slideButton);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public SlideButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlideButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31673p = false;
        this.f31674q = 0;
        this.f31675r = CustomStyle.DEFAULT_STYLE;
        this.f31677t = true;
        this.f31678u = false;
        m24199a();
    }

    /* renamed from: a */
    private void m24199a() {
        View inflate = inflate(getContext(), R.layout.slide_button, this);
        this.f31660c = (ShimmerTextView) findViewById(R.id.shimmer_text_view);
        this.f31661d = (ImageView) findViewById(R.id.icon_arrow);
        this.f31662e = findViewById(R.id.foreground_view);
        this.f31663f = inflate;
        this.f31664g = (LottieAnimationView) findViewById(R.id.loading_view);
        this.f31662e.setClickable(false);
        this.f31664g.setVisibility(8);
        setText((int) R.string.soda_assembly_online);
        setStyle(this.f31675r);
        m24203b();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m24202a("onLayout() called with: changed = [" + z + "], left = [" + i + "], top = [" + i2 + "], right = [" + i3 + "], bottom = [" + i4 + Const.jaRight);
        if (z) {
            this.f31670m = 0.0f;
            this.f31671n = getWidth();
            m24202a("onLayout mViewInitialX: " + this.f31670m + " mViewWidth: " + this.f31671n);
        }
    }

    /* renamed from: b */
    private void m24203b() {
        Shimmer shimmer = new Shimmer();
        this.f31665h = shimmer;
        shimmer.setDuration(3000);
    }

    /* renamed from: c */
    private void m24206c() {
        m24202a("startShimmer ShimmerEnable: " + this.f31677t);
        if (this.f31677t) {
            this.f31665h.start(this.f31660c);
        }
    }

    /* renamed from: d */
    private void m24207d() {
        m24202a("stopShimmer");
        this.f31665h.cancel();
    }

    /* renamed from: a */
    private void m24202a(String str) {
        SystemUtils.log(3, f31658a, str, (Throwable) null, "com.didi.nova.assembly.ui.SlideButton", 145);
    }

    /* renamed from: b */
    private void m24205b(String str) {
        SystemUtils.log(3, f31658a, str, (Throwable) null, "com.didi.nova.assembly.ui.SlideButton", 149);
    }

    public void startLoading() {
        m24202a("startLoading mLoading: " + this.f31673p);
        if (!this.f31673p) {
            this.f31673p = true;
            this.f31664g.setVisibility(0);
            this.f31664g.playAnimation();
        }
    }

    public void stopLoading() {
        m24208e();
        m24213j();
        m24206c();
        setForegroundTextViewAlpha(1.0f);
    }

    /* renamed from: e */
    private void m24208e() {
        m24202a("stopLoading mLoading: " + this.f31673p);
        if (this.f31673p) {
            this.f31664g.cancelAnimation();
            this.f31664g.setVisibility(8);
            this.f31673p = false;
        }
    }

    public void setShimmerColor(int i) {
        this.f31660c.setReflectionColor(getContext().getResources().getColor(i));
    }

    public void setText(CharSequence charSequence) {
        this.f31660c.setText(charSequence);
    }

    public void setText(int i) {
        this.f31660c.setText(i);
    }

    public void setTextSize(float f) {
        this.f31660c.setTextSize(f);
    }

    public void setTextColor(int i) {
        this.f31660c.setTextColor(getResources().getColor(i));
    }

    public void setStyle(CustomStyle customStyle) {
        this.f31675r = customStyle;
        m24209f();
    }

    public void setShimmerEnable(boolean z) {
        this.f31677t = z;
    }

    public void setForegroundTextFadeEnable(boolean z) {
        this.f31678u = z;
    }

    /* renamed from: f */
    private void m24209f() {
        m24200a(this.f31675r.getForegroundResId(), this.f31675r.getBackgroundResId());
        setShimmerColor(this.f31675r.getShimmerColorResId());
    }

    public void setOnSlideActionListener(OnSlideActionListener onSlideActionListener) {
        this.f31676s = onSlideActionListener;
    }

    public void setIconArrow(int i) {
        this.f31661d.setImageResource(i);
        this.f31661d.setVisibility(0);
    }

    public ImageView getIconArrowImageView() {
        return this.f31661d;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        m24205b("onTouchEvent event: " + motionEvent + " mLoading: " + this.f31673p);
        if (this.f31673p) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f31666i = motionEvent.getRawX();
            m24202a("ACTION_DOWN mRawXStart: " + this.f31666i);
            m24214k();
        } else if (actionMasked == 1) {
            requestDisallowInterceptTouchEvent(false);
            float rawX = motionEvent.getRawX();
            this.f31668k = rawX;
            this.f31669l = rawX - this.f31666i;
            m24202a("ACTION_UP mRawXEnd: " + this.f31668k + " mMoveDeltaX:" + this.f31669l + " mViewWidth: " + this.f31671n);
            if (this.f31669l <= ((float) this.f31671n) * 0.3f) {
                m24205b("action not confirmed");
                m24211h();
            } else {
                m24205b("action confirmed");
                m24210g();
            }
        } else if (actionMasked == 2) {
            float rawX2 = motionEvent.getRawX();
            this.f31667j = rawX2;
            this.f31669l = rawX2 - this.f31666i;
            m24202a("ACTION_MOVE mRawXMove: " + this.f31667j + " mRawXStart: " + this.f31666i + " mMoveDeltaX: " + this.f31669l);
            if (Math.abs(this.f31669l) > ((float) this.f31671n) * 0.02f) {
                requestDisallowInterceptTouchEvent(true);
                float max = Math.max(this.f31669l, this.f31670m);
                m24215l();
                setSlideX(max);
                m24212i();
            }
        } else if (actionMasked == 3) {
            m24216m();
        }
        return true;
    }

    /* renamed from: g */
    private void m24210g() {
        float f = this.f31672o;
        float f2 = this.f31670m + ((float) this.f31671n);
        int abs = (int) ((Math.abs(f2 - f) / ((float) this.f31671n)) * 1000.0f);
        AnimatorBuilder property = SofaAnimatorCompat.play(this).property("SlideX", f, f2);
        if (this.f31678u) {
            property.property("ForegroundTextViewAlpha", getForegroundTextViewAlpha(), 0.0f);
        }
        property.duration(abs).decelerate().withListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator, View view) {
                super.onAnimationEnd(animator, view);
                SlideButton.this.m24217n();
            }
        }).build().start();
    }

    /* renamed from: h */
    private void m24211h() {
        float f = this.f31672o;
        float f2 = this.f31670m;
        if (f == f2) {
            m24216m();
            return;
        }
        int abs = (int) ((Math.abs(f2 - f) / ((float) this.f31671n)) * 1000.0f);
        AnimatorBuilder property = SofaAnimatorCompat.play(this).property("SlideX", f, f2);
        if (this.f31678u) {
            property.property("ForegroundTextViewAlpha", getForegroundTextViewAlpha(), 1.0f);
        }
        property.duration(abs).withListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator, View view) {
                super.onAnimationEnd(animator, view);
                SlideButton.this.m24216m();
            }
        }).build().start();
    }

    /* renamed from: i */
    private void m24212i() {
        if (this.f31678u) {
            float x = (this.f31662e.getX() * 1.0f) / ((float) this.f31671n);
            m24202a("fadeForegroundTextViewOnActionMove mViewWidth: " + this.f31671n + " foregroundView.getX(): " + this.f31662e.getX() + " ratio: " + x);
            setForegroundTextViewAlpha(Math.max(1.0f - x, 0.2f));
        }
    }

    /* access modifiers changed from: protected */
    public void setSlideX(float f) {
        m24202a("setSlideX: " + f);
        this.f31672o = f;
        this.f31662e.setX(f);
    }

    /* access modifiers changed from: protected */
    public void setForegroundTextViewAlpha(float f) {
        m24202a("setForegroundTextViewAlpha: " + f);
        this.f31660c.setAlpha(f);
    }

    /* access modifiers changed from: protected */
    public float getForegroundTextViewAlpha() {
        return this.f31660c.getAlpha();
    }

    /* renamed from: a */
    private void m24200a(int i, int i2) {
        this.f31662e.setBackgroundResource(i);
        this.f31663f.setBackgroundResource(i2);
    }

    /* renamed from: j */
    private void m24213j() {
        m24202a("ensureForegroundViewPosition mSlideX: " + this.f31672o + ", mViewInitialX: " + this.f31670m);
        float f = this.f31672o;
        float f2 = this.f31670m;
        if (f != f2) {
            setSlideX(f2);
        }
    }

    /* renamed from: k */
    private void m24214k() {
        m24202a("actionDown");
        m24207d();
        OnSlideActionListener onSlideActionListener = this.f31676s;
        if (onSlideActionListener != null) {
            onSlideActionListener.onTouchActionDown(this);
        }
    }

    /* renamed from: l */
    private void m24215l() {
        m24202a("actionMove");
        OnSlideActionListener onSlideActionListener = this.f31676s;
        if (onSlideActionListener != null) {
            onSlideActionListener.onTouchActionMove(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m24216m() {
        m24202a("actionCancel");
        m24206c();
        OnSlideActionListener onSlideActionListener = this.f31676s;
        if (onSlideActionListener != null) {
            onSlideActionListener.onActionCancel(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m24217n() {
        m24202a("actionConfirmed");
        long currentTimeMillis = System.currentTimeMillis() - this.f31674q;
        m24205b("actionConfirmed timeInterval: " + currentTimeMillis + " System.currentTimeMillis(): " + System.currentTimeMillis() + " mLastActionConfirmedTime: " + this.f31674q);
        if (currentTimeMillis <= 1000) {
            m24205b("Action is too frequent and return!");
            return;
        }
        this.f31674q = System.currentTimeMillis();
        OnSlideActionListener onSlideActionListener = this.f31676s;
        if (onSlideActionListener != null) {
            onSlideActionListener.onActionConfirmed(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m24206c();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        m24205b("onDetachedFromWindow");
        super.onDetachedFromWindow();
        m24207d();
    }

    /* renamed from: com.didi.nova.assembly.ui.SlideButton$CustomStyle */
    public static class CustomStyle {
        public static final CustomStyle DEFAULT_STYLE = new CustomStyle(R.drawable.slide_button_foreground_transparent, R.drawable.slide_button_background_orange, R.color.slide_button_shimmer_color_orange, R.color.dot_loading_normal_color, R.color.dot_loading_highlight_color);
        private int backgroundResId;
        private int dotLoadingHighlightColorResId;
        private int dotLoadingNormalColorResId;
        private int foregroundResId;
        private int shimmerColorResId;

        public CustomStyle(int i, int i2, int i3) {
            this(i, i2, i3, R.color.dot_loading_normal_color, R.color.dot_loading_highlight_color);
        }

        public CustomStyle(int i, int i2, int i3, int i4, int i5) {
            this.foregroundResId = i;
            this.backgroundResId = i2;
            this.shimmerColorResId = i3;
            this.dotLoadingNormalColorResId = i4;
            this.dotLoadingHighlightColorResId = i5;
        }

        /* access modifiers changed from: package-private */
        public int getForegroundResId() {
            return this.foregroundResId;
        }

        /* access modifiers changed from: package-private */
        public int getBackgroundResId() {
            return this.backgroundResId;
        }

        /* access modifiers changed from: package-private */
        public int getShimmerColorResId() {
            return this.shimmerColorResId;
        }

        /* access modifiers changed from: package-private */
        public int getDotLoadingHighlightColorResId() {
            return this.dotLoadingHighlightColorResId;
        }

        /* access modifiers changed from: package-private */
        public int getDotLoadingNormalColorResId() {
            return this.dotLoadingNormalColorResId;
        }
    }
}
