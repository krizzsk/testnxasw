package com.didi.entrega.order.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.customer.map.infowindow.AbInfoWindowView;
import com.didi.entrega.customer.map.marker.InfoWindowViewBuildConfig;
import com.taxis99.R;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

public class MarkerInfoWindowView extends AbInfoWindowView {

    /* renamed from: a */
    private TextView f22783a;

    /* renamed from: b */
    private TextView f22784b;

    /* renamed from: c */
    private View f22785c;

    /* renamed from: d */
    private View f22786d;

    /* renamed from: e */
    private View f22787e;

    /* renamed from: f */
    private ImageView f22788f;

    /* renamed from: g */
    private ObjectAnimator f22789g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f22790h;

    /* renamed from: i */
    private int f22791i;

    /* renamed from: j */
    private int f22792j;

    /* renamed from: k */
    private int f22793k;

    /* renamed from: a */
    private int m18762a(int i) {
        return (i == 1400 || i == 1500) ? R.drawable.entraga_shape_bill_map_orange_bg : R.drawable.entraga_shape_bill_map_green_bg;
    }

    /* renamed from: b */
    private int m18765b(int i) {
        return (1400 == i || 1500 == i) ? R.drawable.entrega_tips_map_triangle_orange : R.drawable.entrega_tips_map_triangle_green;
    }

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.entrega_customer_layout_marker_station;
    }

    public MarkerInfoWindowView(Context context) {
        super(context);
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setMarkInfoWindowRes(int i) {
        View view = this.f22786d;
        if (view != null) {
            view.setBackgroundResource(m18762a(i));
        }
        ImageView imageView = this.f22788f;
        if (imageView != null) {
            imageView.setImageResource(m18765b(i));
        }
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.f22787e = view;
        this.f22783a = (TextView) view.findViewById(R.id.customer_tv_current_title);
        this.f22784b = (TextView) this.f22787e.findViewById(R.id.customer_tv_current_content);
        this.f22785c = this.f22787e.findViewById(R.id.customer_tv_title_arrow);
        this.f22788f = (ImageView) this.f22787e.findViewById(R.id.customer_iv_bottom_triangle);
        this.f22786d = this.f22787e.findViewById(R.id.customer_cl_marker_station_layout);
        setVisibility(8);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f}), ofFloat});
        this.f22789g = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(200);
        this.f22789g.setInterpolator(new DecelerateInterpolator());
        this.f22789g.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MarkerInfoWindowView markerInfoWindowView = MarkerInfoWindowView.this;
                markerInfoWindowView.setVisibility(markerInfoWindowView.f22790h);
            }
        });
    }

    public void updateView(InfoWindowViewBuildConfig infoWindowViewBuildConfig) {
        if (infoWindowViewBuildConfig != null) {
            setVisibility(0);
            setMarkInfoWindowRes(infoWindowViewBuildConfig.getOrderStatus().intValue());
            if (!TextUtils.isEmpty(infoWindowViewBuildConfig.getTitle())) {
                this.f22783a.setVisibility(0);
                this.f22783a.setText(infoWindowViewBuildConfig.getTitle());
            } else {
                this.f22783a.setVisibility(8);
            }
            if (!TextUtils.isEmpty(infoWindowViewBuildConfig.getSubDesc())) {
                this.f22784b.setVisibility(0);
                this.f22784b.setText(infoWindowViewBuildConfig.getSubDesc());
                return;
            }
            this.f22784b.setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public void updateView(String str, CharSequence charSequence, boolean z) {
        int i = 8;
        if (!TextUtils.isEmpty(str)) {
            this.f22790h = 0;
            setVisibility(0);
            this.f22783a.setText(str);
            this.f22783a.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            this.f22784b.setText(charSequence);
            this.f22784b.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
            View view = this.f22785c;
            if (z) {
                i = 0;
            }
            view.setVisibility(i);
            return;
        }
        this.f22790h = 8;
        m18767c();
    }

    public void hideViewImmediately() {
        this.f22790h = 8;
        setVisibility(8);
    }

    public void hideViewWithAnim() {
        this.f22790h = 8;
        updateView((String) null, (CharSequence) null, false);
    }

    public void showView(String str, CharSequence charSequence, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f22790h = 0;
            setVisibility(0);
            updateView(str, charSequence, z);
            m18766b();
        }
    }

    public void updateLocation(int i, int i2, boolean z) {
        int i3;
        this.f22791i = i;
        this.f22792j = i2;
        if (z) {
            i3 = 0;
        } else {
            i3 = -DisplayUtils.dip2px(getContext(), 12.0f);
        }
        this.f22793k = i3;
        m18764a();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f22789g;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f22789g = null;
        }
    }

    /* renamed from: a */
    private void m18764a() {
        measure(View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f22791i - (measuredWidth / 2);
        layoutParams.topMargin = (this.f22792j - measuredHeight) + this.f22793k;
        layoutParams.rightMargin = -measuredWidth;
        layoutParams.bottomMargin = -measuredHeight;
        setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m18766b() {
        ObjectAnimator objectAnimator = this.f22789g;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.f22789g.end();
            }
            setScaleX(0.0f);
            setScaleX(0.0f);
            setAlpha(0.0f);
            this.f22789g.setStartDelay(1200);
            this.f22789g.start();
        }
    }

    /* renamed from: c */
    private void m18767c() {
        if (this.f22789g != null && isShown()) {
            if (this.f22789g.isRunning()) {
                this.f22789g.end();
            }
            this.f22789g.setStartDelay(0);
            this.f22789g.reverse();
        }
    }
}
