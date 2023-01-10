package com.didi.soda.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class CustomerPopWindow extends FrameLayout {

    /* renamed from: a */
    private static final int f44087a = 250;

    /* renamed from: b */
    private TextView f44088b;

    /* renamed from: c */
    private TextView f44089c;

    /* renamed from: d */
    private TextView f44090d;

    /* renamed from: e */
    private PopWindowListener f44091e;

    public CustomerPopWindow(Context context) {
        super(context);
        m32845a(context);
    }

    public CustomerPopWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32845a(context);
    }

    public CustomerPopWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32845a(context);
    }

    public void dismiss() {
        if (getVisibility() == 0) {
            m32848b();
        }
    }

    public void setContent(CharSequence charSequence) {
        this.f44088b.setText(charSequence);
    }

    public void setListener(PopWindowListener popWindowListener) {
        this.f44091e = popWindowListener;
    }

    public void show() {
        if (getVisibility() == 8) {
            m32844a();
        }
    }

    /* renamed from: a */
    private void m32845a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_widget_pop_window, this, true);
        this.f44088b = (TextView) inflate.findViewById(R.id.customer_tv_content);
        this.f44089c = (TextView) inflate.findViewById(R.id.customer_btn_negative);
        this.f44090d = (TextView) inflate.findViewById(R.id.customer_btn_positive);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44089c, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44090d, IToolsService.FontType.MEDIUM);
        this.f44089c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerPopWindow.this.m32847a(false);
            }
        });
        this.f44090d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerPopWindow.this.m32847a(true);
            }
        });
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32847a(boolean z) {
        dismiss();
        PopWindowListener popWindowListener = this.f44091e;
        if (popWindowListener == null) {
            return;
        }
        if (z) {
            popWindowListener.onPositiveButtonClick();
        } else {
            popWindowListener.onNegativeButtonClick();
        }
    }

    /* renamed from: a */
    private void m32844a() {
        measure(0, 0);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-getMeasuredHeight()), 0.0f);
        translateAnimation.setDuration(250);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                CustomerPopWindow.this.setVisibility(0);
            }
        });
        startAnimation(translateAnimation);
    }

    /* renamed from: b */
    private void m32848b() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-getHeight()));
        translateAnimation.setDuration(250);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                CustomerPopWindow.this.setVisibility(8);
                CustomerPopWindow.this.setClickable(true);
            }

            public void onAnimationStart(Animation animation) {
                CustomerPopWindow.this.setClickable(false);
            }
        });
        startAnimation(translateAnimation);
    }
}
