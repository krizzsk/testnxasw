package com.didi.soda.business.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Path;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.utils.RFDisplayUtils;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;

public class BusinessDeliveryFeeTips extends FrameLayout {

    /* renamed from: a */
    private static final String f42354a = "BusinessDeliveryFeeTips";

    /* renamed from: b */
    private ViewGroup f42355b;

    /* renamed from: c */
    private TextView f42356c;

    /* renamed from: d */
    private RFIconView f42357d;

    /* renamed from: e */
    private ImageView f42358e;

    /* renamed from: f */
    private ConstraintLayout f42359f;

    /* renamed from: g */
    private C14310a f42360g;

    /* renamed from: h */
    private ObjectAnimator f42361h;

    /* renamed from: i */
    private ObjectAnimator f42362i;

    /* renamed from: j */
    private ObjectAnimator f42363j;

    /* renamed from: k */
    private int f42364k;

    /* renamed from: l */
    private boolean f42365l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f42366m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f42367n;

    /* renamed from: o */
    private int f42368o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public OnTransitionListener f42369p;

    interface OnTransitionListener {
        void onTipsHide();

        void onTipsShow();
    }

    public BusinessDeliveryFeeTips(Context context) {
        this(context, (AttributeSet) null);
    }

    public BusinessDeliveryFeeTips(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BusinessDeliveryFeeTips(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f42364k = 0;
        this.f42365l = false;
        this.f42366m = true;
        this.f42367n = false;
        this.f42368o = 0;
        m31853a();
        m31858b();
        m31861c();
        m31862d();
    }

    /* renamed from: a */
    private void m31853a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_business_delivery_fee_tips, this);
        this.f42355b = (ViewGroup) findViewById(R.id.customer_business_content_container);
        this.f42356c = (TextView) findViewById(R.id.customer_tv_delivery_fee_content);
        this.f42357d = (RFIconView) findViewById(R.id.customer_iv_delivery_fee_close);
        this.f42358e = (ImageView) findViewById(R.id.customer_delivery_fee_arrow);
        this.f42359f = (ConstraintLayout) findViewById(R.id.customer_business_shadow_container);
        this.f42356c.setOnClickListener((View.OnClickListener) null);
    }

    /* renamed from: b */
    private void m31858b() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, (float) (-RFDisplayUtils.dp2px(5.0f)), 0.0f})});
        this.f42361h = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setRepeatCount(-1);
        this.f42361h.setRepeatMode(2);
        Path path = new Path();
        path.quadTo(0.19f, 0.5f, 0.33f, 0.5f);
        path.cubicTo(0.5f, 0.55f, 0.5f, 1.0f, 1.0f, 1.0f);
        this.f42361h.setInterpolator(PathInterpolatorCompat.create(path));
        this.f42361h.setDuration(900);
        this.f42361h.setStartDelay(400);
    }

    /* renamed from: c */
    private void m31861c() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f}), ofFloat});
        this.f42362i = ofPropertyValuesHolder;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (BusinessDeliveryFeeTips.this.f42367n) {
                    BusinessDeliveryFeeTips.this.m31864e();
                }
                if (BusinessDeliveryFeeTips.this.f42369p != null) {
                    BusinessDeliveryFeeTips.this.f42369p.onTipsShow();
                }
            }
        });
        this.f42362i.setDuration(300);
        this.f42362i.setInterpolator(decelerateInterpolator);
    }

    /* renamed from: d */
    private void m31862d() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.0f}), ofFloat});
        this.f42363j = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(300);
        this.f42363j.setInterpolator(decelerateInterpolator);
        this.f42363j.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BusinessDeliveryFeeTips.this.m31866f();
                BusinessDeliveryFeeTips.super.setVisibility(8);
                if (BusinessDeliveryFeeTips.this.f42369p != null) {
                    BusinessDeliveryFeeTips.this.f42369p.onTipsHide();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f42365l = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                BusinessDeliveryFeeTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (BusinessDeliveryFeeTips.this.f42366m && BusinessDeliveryFeeTips.this.getVisibility() == 0) {
                    BusinessDeliveryFeeTips.this.m31870i();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f42362i.isRunning()) {
            this.f42362i.end();
        }
        if (this.f42363j.isRunning()) {
            this.f42363j.end();
        }
        m31866f();
        this.f42365l = false;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (i == 0) {
            m31869h();
        } else {
            m31868g();
        }
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            if (!this.f42365l || !this.f42366m) {
                super.setVisibility(i);
            } else if (i == 0) {
                m31870i();
            } else if (i == 8) {
                m31871j();
            } else {
                super.setVisibility(i);
            }
        }
    }

    public void setText(int i) {
        this.f42356c.setText(i);
    }

    public void setText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            setVisibility(0);
            this.f42356c.setText(charSequence);
            return;
        }
        setVisibility(8);
    }

    public void setContentMaxLine(int i) {
        TextView textView = this.f42356c;
        if (i < 1) {
            i = 1;
        }
        textView.setMaxLines(i);
    }

    public void bindAnchorView(View view) {
        if (view != null) {
            int[] a = m31857a(view, new int[]{0, 0});
            this.f42360g = new C14310a(a[0] + (view.getWidth() / 2), a[1] + view.getHeight(), view.getWidth(), view.getHeight());
        }
    }

    /* renamed from: a */
    private int[] m31857a(View view, int[] iArr) {
        iArr[0] = view.getLeft();
        iArr[1] = view.getTop();
        ViewParent parent = view.getParent();
        while (parent != null && parent != getParent()) {
            View view2 = (View) parent;
            iArr[0] = iArr[0] + view2.getLeft();
            iArr[1] = iArr[1] + view2.getTop();
            parent = parent.getParent();
        }
        return iArr;
    }

    public void setEnableTransition(boolean z) {
        this.f42366m = z;
    }

    public void startShake() {
        this.f42367n = true;
        m31864e();
    }

    public void stopShake() {
        this.f42367n = false;
        m31866f();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m31864e() {
        if (!this.f42361h.isRunning() && this.f42365l) {
            this.f42361h.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m31866f() {
        if (this.f42361h.isRunning()) {
            this.f42361h.end();
        }
    }

    /* renamed from: g */
    private void m31868g() {
        if (this.f42361h.isRunning()) {
            this.f42361h.pause();
        }
    }

    /* renamed from: h */
    private void m31869h() {
        if (this.f42361h.isPaused()) {
            this.f42361h.resume();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m31870i() {
        if (this.f42363j.isRunning()) {
            this.f42363j.end();
        }
        super.setVisibility(0);
        m31872k();
        this.f42362i.start();
    }

    /* renamed from: j */
    private void m31871j() {
        if (this.f42362i.isRunning()) {
            this.f42362i.end();
        }
        m31872k();
        this.f42363j.start();
    }

    /* renamed from: k */
    private void m31872k() {
        int i;
        int i2;
        int i3 = this.f42364k;
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
        this.f42357d.setOnClickListener(onClickListener);
        this.f42357d.setVisibility(onClickListener != null ? 0 : 8);
    }

    /* access modifiers changed from: package-private */
    public void setTransitionListener(OnTransitionListener onTransitionListener) {
        this.f42369p = onTransitionListener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m31854a(i, i2, i3, i4);
    }

    /* renamed from: a */
    private void m31854a(int i, int i2, int i3, int i4) {
        int i5;
        int measuredWidth;
        int i6;
        int measuredWidth2;
        if (this.f42360g != null) {
            int dip2px = DisplayUtils.dip2px(getContext(), 16.0f) - this.f42359f.getPaddingLeft();
            int dip2px2 = DisplayUtils.dip2px(getContext(), 6.0f);
            int measuredWidth3 = this.f42355b.getMeasuredWidth() / 2;
            if (this.f42360g.f42457c < this.f42359f.getPaddingLeft() + dip2px + dip2px2 + (this.f42358e.getMeasuredWidth() / 2)) {
                i5 = this.f42359f.getPaddingLeft() + dip2px2;
            } else {
                if (this.f42360g.f42457c > ((getMeasuredWidth() - dip2px) - this.f42359f.getPaddingRight()) - dip2px2) {
                    dip2px = (getMeasuredWidth() - dip2px) - this.f42355b.getMeasuredWidth();
                    measuredWidth3 = (this.f42355b.getMeasuredWidth() - this.f42359f.getPaddingRight()) - dip2px2;
                    measuredWidth = this.f42358e.getMeasuredWidth();
                } else {
                    if (measuredWidth3 >= this.f42360g.f42457c - dip2px) {
                        i6 = this.f42360g.f42457c - dip2px;
                        measuredWidth2 = this.f42358e.getMeasuredWidth() / 2;
                    } else if (measuredWidth3 > (getMeasuredWidth() - dip2px) - this.f42360g.f42457c) {
                        dip2px = (getMeasuredWidth() - dip2px) - this.f42355b.getMeasuredWidth();
                        i6 = this.f42360g.f42457c - dip2px;
                        measuredWidth2 = this.f42358e.getMeasuredWidth() / 2;
                    } else {
                        dip2px = this.f42360g.f42457c - measuredWidth3;
                        measuredWidth = this.f42358e.getMeasuredWidth() / 2;
                    }
                    i5 = i6 - measuredWidth2;
                }
                i5 = measuredWidth3 - measuredWidth;
            }
            this.f42355b.layout(dip2px, this.f42360g.f42458d, this.f42355b.getMeasuredWidth() + dip2px, this.f42360g.f42458d + this.f42355b.getMeasuredHeight());
            ImageView imageView = this.f42358e;
            imageView.layout(i5, imageView.getTop(), this.f42358e.getMeasuredWidth() + i5, this.f42358e.getTop() + this.f42358e.getMeasuredHeight());
        }
    }
}
