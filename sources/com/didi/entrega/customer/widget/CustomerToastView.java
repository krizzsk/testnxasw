package com.didi.entrega.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.taxis99.R;

public class CustomerToastView extends LinearLayout {

    /* renamed from: a */
    private static final int f22133a = 200;

    /* renamed from: b */
    private ImageView f22134b;

    /* renamed from: c */
    private TextView f22135c;

    /* renamed from: d */
    private boolean f22136d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ViewGroup f22137e;

    public CustomerToastView(Context context, ViewGroup viewGroup) {
        super(context);
        m18318a(context);
        this.f22137e = viewGroup;
    }

    public CustomerToastView(Context context, AttributeSet attributeSet, ViewGroup viewGroup) {
        super(context, attributeSet);
        m18318a(context);
        this.f22137e = viewGroup;
    }

    public CustomerToastView(Context context, AttributeSet attributeSet, int i, ViewGroup viewGroup) {
        super(context, attributeSet, i);
        m18318a(context);
        this.f22137e = viewGroup;
    }

    public void hide() {
        m18317a();
        this.f22136d = false;
    }

    public boolean isShow() {
        return this.f22136d;
    }

    public void show() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = CustomerSystemUtil.getImmersiveStatusBarHeight(getContext());
        setLayoutParams(layoutParams);
        measure(View.MeasureSpec.makeMeasureSpec(this.f22137e.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f22137e.getHeight(), 0));
        this.f22137e.addView(this);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-getMeasuredHeight()), 0.0f);
        translateAnimation.setDuration(200);
        startAnimation(translateAnimation);
        this.f22136d = true;
    }

    public void updateContent(ToastUtil.Type type, String str) {
        this.f22135c.setText(str);
    }

    /* renamed from: a */
    private void m18317a() {
        if (this.f22137e.indexOfChild(this) >= 0) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-getMeasuredHeight()));
            translateAnimation.setDuration(200);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (CustomerToastView.this.f22137e != null) {
                        CustomerToastView.this.f22137e.removeView(this);
                    }
                }
            });
            startAnimation(translateAnimation);
        }
    }

    /* renamed from: a */
    private void m18318a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.entrega_toast_view, this, true);
        this.f22134b = (ImageView) inflate.findViewById(R.id.iv_toast_icon);
        this.f22135c = (TextView) inflate.findViewById(R.id.tv_toast_msg);
    }
}
