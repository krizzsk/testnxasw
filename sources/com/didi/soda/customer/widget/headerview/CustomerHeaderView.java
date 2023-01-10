package com.didi.soda.customer.widget.headerview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.app.nova.support.view.pullToRefresh.IRefreshView;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class CustomerHeaderView extends FrameLayout implements IRefreshView {

    /* renamed from: a */
    private static final int f44544a = Color.parseColor("#FFFFFF");

    /* renamed from: b */
    private static final int f44545b = Color.parseColor("#F5F5F7");

    /* renamed from: c */
    private static final int f44546c = Color.parseColor("#00FFFFFF");

    /* renamed from: d */
    private static final int f44547d = Color.parseColor("#FAFAFA");

    /* renamed from: e */
    private static final int f44548e = 5;

    /* renamed from: f */
    private LottieLoadingView f44549f;

    /* renamed from: g */
    private RelativeLayout f44550g;

    /* renamed from: h */
    private HeaderStyle f44551h;

    /* renamed from: i */
    private boolean f44552i;

    public enum HeaderStyle {
        WHITE,
        GRAY,
        ORANGE,
        TRANSPARENT,
        TRANSPARENT_ORANGE_LOADING,
        HISTORY
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
        m33075a();
    }

    public void changeStyle(HeaderStyle headerStyle) {
        if (this.f44551h != headerStyle) {
            m33076a(headerStyle);
        }
    }

    public void onMove(boolean z, int i) {
        if (this.f44549f != null && !this.f44552i && Math.abs(i) > 5) {
            this.f44549f.start();
            this.f44552i = true;
        }
        if (this.f44549f != null && this.f44552i && Math.abs(i) <= 5) {
            this.f44549f.stop();
            this.f44552i = false;
        }
    }

    /* renamed from: a */
    private void m33075a() {
        this.f44550g = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_header_view, this, true).findViewById(R.id.customer_rl_header_container);
        m33076a(HeaderStyle.WHITE);
    }

    /* renamed from: a */
    private void m33076a(HeaderStyle headerStyle) {
        if (headerStyle == HeaderStyle.ORANGE) {
            setBackgroundResource(R.drawable.customer_skin_shape_home_header_default);
            if (!GlobalContext.isEmbed()) {
                this.f44550g.removeAllViews();
                LottieLoadingView lottieLoadingView = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_orange_header_view, this.f44550g, false);
                this.f44549f = lottieLoadingView;
                this.f44550g.addView(lottieLoadingView);
            }
        } else if (headerStyle == HeaderStyle.GRAY) {
            setBackgroundColor(f44545b);
            if (!GlobalContext.isEmbed()) {
                this.f44550g.removeAllViews();
                LottieLoadingView lottieLoadingView2 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_white_header_view, this.f44550g, false);
                this.f44549f = lottieLoadingView2;
                this.f44550g.addView(lottieLoadingView2);
            }
        } else if (headerStyle == HeaderStyle.TRANSPARENT) {
            setBackgroundColor(f44546c);
            if (!GlobalContext.isEmbed()) {
                this.f44550g.removeAllViews();
                LottieLoadingView lottieLoadingView3 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_white_header_view, this.f44550g, false);
                this.f44549f = lottieLoadingView3;
                lottieLoadingView3.setAnimation((int) R.raw.customer_white_loading);
                this.f44550g.addView(this.f44549f);
            }
        } else if (headerStyle == HeaderStyle.TRANSPARENT_ORANGE_LOADING) {
            setBackgroundColor(f44546c);
            if (!GlobalContext.isEmbed()) {
                this.f44550g.removeAllViews();
                LottieLoadingView lottieLoadingView4 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_white_header_view, this.f44550g, false);
                this.f44549f = lottieLoadingView4;
                this.f44550g.addView(lottieLoadingView4);
            }
        } else if (headerStyle == HeaderStyle.HISTORY) {
            setBackgroundColor(f44547d);
            if (!GlobalContext.isEmbed()) {
                this.f44550g.removeAllViews();
                LottieLoadingView lottieLoadingView5 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_white_header_view, this.f44550g, false);
                this.f44549f = lottieLoadingView5;
                this.f44550g.addView(lottieLoadingView5);
                this.f44550g.getLayoutParams().height = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_140);
                RelativeLayout relativeLayout = this.f44550g;
                relativeLayout.setPadding(relativeLayout.getPaddingLeft(), 0, this.f44550g.getPaddingRight(), this.f44550g.getPaddingBottom());
                this.f44550g.setGravity(17);
            }
        } else {
            setBackgroundColor(f44544a);
            if (!GlobalContext.isEmbed()) {
                this.f44550g.removeAllViews();
                LottieLoadingView lottieLoadingView6 = (LottieLoadingView) LayoutInflater.from(getContext()).inflate(R.layout.widget_white_header_view, this.f44550g, false);
                this.f44549f = lottieLoadingView6;
                this.f44550g.addView(lottieLoadingView6);
            }
        }
        this.f44551h = headerStyle;
    }
}
