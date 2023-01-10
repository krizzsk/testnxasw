package com.didi.soda.customer.widget.guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.util.DisplayUtils;
import com.didi.rfusion.utils.RFDisplayUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;

public class NewCustomerGuideContainer extends ConstraintLayout {

    /* renamed from: a */
    private static final String f44530a = "NewCustomerGuideContainer";

    /* renamed from: b */
    private ImageView f44531b;

    /* renamed from: c */
    private CustomerAppCompatTextView f44532c;

    /* renamed from: d */
    private RFIconView f44533d;

    /* renamed from: e */
    private LinearLayout f44534e;

    /* renamed from: f */
    private RelativeLayout f44535f;

    /* renamed from: g */
    private ObjectAnimator f44536g;

    /* renamed from: h */
    private ObjectAnimator f44537h;

    /* renamed from: i */
    private ObjectAnimator f44538i;

    /* renamed from: j */
    private boolean f44539j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f44540k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f44541l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public OnTransitionListener f44542m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public OnDismissListener f44543n;

    public interface OnDismissListener {
        void onDismiss();
    }

    public interface OnTransitionListener {
        void onTipsHide();

        void onTipsShow();
    }

    public NewCustomerGuideContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewCustomerGuideContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewCustomerGuideContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44539j = false;
        this.f44540k = false;
        this.f44541l = true;
        m33054a();
        m33060c();
        m33061d();
        m33064e();
    }

    /* renamed from: a */
    private void m33054a() {
        setBackgroundResource(R.color.transparent);
        LayoutInflater.from(getContext()).inflate(R.layout.customer_new_guide_view, this, true);
        this.f44531b = (ImageView) findViewById(R.id.customer_iv_icon_guide);
        this.f44532c = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_content_guide);
        this.f44533d = (RFIconView) findViewById(R.id.customer_iv_close_guide);
        this.f44534e = (LinearLayout) findViewById(R.id.customer_guide_root_container);
        this.f44535f = (RelativeLayout) findViewById(R.id.customer_guider_outer_container);
        this.f44533d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewCustomerGuideContainer.this.setVisibility(8);
            }
        });
        setClipChildren(false);
        this.f44532c.post(new Runnable() {
            public final void run() {
                NewCustomerGuideContainer.this.m33074m();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        LogUtil.m32586e(f44530a, "dispatchTouchEvent-----${ev?.action}");
        OnDismissListener onDismissListener = this.f44543n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33074m() {
        ViewGroup.LayoutParams layoutParams = this.f44534e.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f44532c.getMeasuredHeight() + DisplayUtils.dp2px(getContext(), 32.0f);
            this.f44534e.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: c */
    private void m33060c() {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, (float) (-RFDisplayUtils.dp2px(5.0f)), 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f44535f, new PropertyValuesHolder[]{ofFloat});
        this.f44536g = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setRepeatCount(-1);
        this.f44536g.setRepeatMode(2);
        Path path = new Path();
        path.quadTo(0.19f, 0.5f, 0.33f, 0.5f);
        path.cubicTo(0.5f, 0.55f, 0.5f, 1.0f, 1.0f, 1.0f);
        this.f44536g.setInterpolator(PathInterpolatorCompat.create(path));
        this.f44536g.setDuration(900);
        this.f44536g.setStartDelay(400);
    }

    /* renamed from: d */
    private void m33061d() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f44535f, new PropertyValuesHolder[]{ofFloat2, ofFloat3, ofFloat});
        this.f44537h = ofPropertyValuesHolder;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (NewCustomerGuideContainer.this.f44540k) {
                    NewCustomerGuideContainer.this.m33065f();
                }
                if (NewCustomerGuideContainer.this.f44542m != null) {
                    NewCustomerGuideContainer.this.f44542m.onTipsShow();
                }
            }
        });
        this.f44537h.setDuration(300);
        this.f44537h.setInterpolator(decelerateInterpolator);
    }

    /* renamed from: e */
    private void m33064e() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.0f});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f44535f, new PropertyValuesHolder[]{ofFloat2, ofFloat3, ofFloat});
        this.f44538i = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(300);
        this.f44538i.setInterpolator(decelerateInterpolator);
        this.f44538i.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                NewCustomerGuideContainer.this.m33067g();
                NewCustomerGuideContainer.super.setVisibility(8);
                if (NewCustomerGuideContainer.this.f44542m != null) {
                    NewCustomerGuideContainer.this.f44542m.onTipsHide();
                }
                if (NewCustomerGuideContainer.this.f44543n != null) {
                    NewCustomerGuideContainer.this.f44543n.onDismiss();
                }
            }
        });
    }

    public void setEnableTransition(boolean z) {
        this.f44541l = z;
    }

    public void startShake() {
        this.f44540k = true;
        m33065f();
    }

    public void stopShake() {
        this.f44540k = false;
        m33067g();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m33065f() {
        if (!this.f44536g.isRunning() && this.f44539j) {
            this.f44536g.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m33067g() {
        if (this.f44536g.isRunning()) {
            this.f44536g.end();
        }
    }

    /* renamed from: h */
    private void m33069h() {
        if (this.f44536g.isRunning()) {
            this.f44536g.pause();
        }
    }

    /* renamed from: i */
    private void m33070i() {
        if (this.f44536g.isPaused()) {
            this.f44536g.resume();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m33071j() {
        if (this.f44538i.isRunning()) {
            this.f44538i.end();
        }
        super.setVisibility(0);
        m33073l();
        this.f44537h.start();
    }

    /* renamed from: k */
    private void m33072k() {
        if (this.f44537h.isRunning()) {
            this.f44537h.end();
        }
        m33073l();
        this.f44538i.start();
    }

    /* renamed from: l */
    private void m33073l() {
        int measuredHeight = getMeasuredHeight();
        setPivotX((float) (getMeasuredWidth() / 2));
        setPivotY((float) measuredHeight);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f44539j = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                NewCustomerGuideContainer.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (NewCustomerGuideContainer.this.f44541l && NewCustomerGuideContainer.this.getVisibility() == 0) {
                    NewCustomerGuideContainer.this.m33071j();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f44537h.isRunning()) {
            this.f44537h.end();
        }
        if (this.f44538i.isRunning()) {
            this.f44538i.end();
        }
        m33067g();
        this.f44539j = false;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (i == 0) {
            m33070i();
        } else {
            m33069h();
        }
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            if (!this.f44539j || !this.f44541l) {
                super.setVisibility(i);
            } else if (i == 0) {
                m33071j();
            } else if (i == 8) {
                m33072k();
            } else {
                super.setVisibility(i);
            }
        }
    }

    public void setOnListener(View.OnClickListener onClickListener) {
        this.f44533d.setOnClickListener(onClickListener);
        this.f44533d.setVisibility(onClickListener != null ? 0 : 8);
    }

    public void setTransitionListener(OnTransitionListener onTransitionListener) {
        this.f44542m = onTransitionListener;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f44543n = onDismissListener;
    }
}
