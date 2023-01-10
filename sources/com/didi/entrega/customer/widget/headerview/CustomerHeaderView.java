package com.didi.entrega.customer.widget.headerview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.app.nova.support.view.pullToRefresh.IRefreshView;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class CustomerHeaderView extends FrameLayout implements IRefreshView {

    /* renamed from: a */
    private static final int f22312a = Color.parseColor("#FFFFFF");

    /* renamed from: b */
    private static final int f22313b = Color.parseColor("#F5F5F7");

    /* renamed from: c */
    private static final int f22314c = 5;

    /* renamed from: d */
    private LottieLoadingView f22315d;

    /* renamed from: e */
    private RelativeLayout f22316e;

    /* renamed from: f */
    private HeaderStyle f22317f;

    /* renamed from: g */
    private boolean f22318g;

    public enum HeaderStyle {
        WHITE,
        GRAY,
        ORANGE
    }

    public void onComplete() {
    }

    public void onPullToRefresh() {
    }

    public void onRelease(boolean z) {
    }

    public void onReset() {
    }

    public CustomerHeaderView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomerHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomerHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18390a();
    }

    public void changeStyle(HeaderStyle headerStyle) {
        if (this.f22317f != headerStyle) {
            m18391a(headerStyle);
        }
    }

    public void onMove(boolean z, int i) {
        if (this.f22315d != null && !this.f22318g && Math.abs(i) > 5) {
            this.f22315d.start();
            this.f22318g = true;
        }
        if (this.f22315d != null && this.f22318g && Math.abs(i) <= 5) {
            this.f22315d.stop();
            this.f22318g = false;
        }
    }

    /* renamed from: a */
    private void m18390a() {
        this.f22316e = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.entrega_customer_widget_header_view, this, true).findViewById(R.id.customer_rl_header_container);
        m18391a(HeaderStyle.WHITE);
    }

    /* renamed from: a */
    private void m18391a(HeaderStyle headerStyle) {
        if (headerStyle == HeaderStyle.ORANGE) {
            setBackgroundResource(R.drawable.entrega_skin_shape_home_header_default);
            LottieLoadingView lottieLoadingView = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.entrega_widget_orange_header_view, this.f22316e, false);
            this.f22315d = lottieLoadingView;
            this.f22316e.addView(lottieLoadingView);
        } else if (headerStyle == HeaderStyle.GRAY) {
            setBackgroundColor(f22313b);
            this.f22316e.removeAllViews();
            LottieLoadingView lottieLoadingView2 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.entrega_widget_white_header_view, this.f22316e, false);
            this.f22315d = lottieLoadingView2;
            this.f22316e.addView(lottieLoadingView2);
        } else {
            setBackgroundColor(f22312a);
            this.f22316e.removeAllViews();
            LottieLoadingView lottieLoadingView3 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.entrega_widget_white_header_view, this.f22316e, false);
            this.f22315d = lottieLoadingView3;
            this.f22316e.addView(lottieLoadingView3);
        }
        this.f22317f = headerStyle;
    }
}
