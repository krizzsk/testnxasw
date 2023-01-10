package com.didi.soda.customer.widget.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.taxis99.R;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

public class MarkerInfoWindowView extends FrameLayout {

    /* renamed from: a */
    private TextView f44693a;

    /* renamed from: b */
    private TextView f44694b;

    /* renamed from: c */
    private View f44695c;

    /* renamed from: d */
    private ObjectAnimator f44696d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f44697e;

    /* renamed from: f */
    private int f44698f;

    /* renamed from: g */
    private int f44699g;

    /* renamed from: h */
    private int f44700h;

    public MarkerInfoWindowView(Context context) {
        super(context);
        m33170b();
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33170b();
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33170b();
    }

    public MarkerInfoWindowView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m33170b();
    }

    public void hideViewImmediately() {
        this.f44697e = 8;
        setVisibility(8);
    }

    public void hideViewWithAnim() {
        this.f44697e = 8;
        updateView((String) null, (CharSequence) null);
    }

    public void showView(String str, CharSequence charSequence) {
        if (!TextUtils.isEmpty(str)) {
            this.f44697e = 0;
            setVisibility(0);
            updateView(str, charSequence);
            m33171c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f44696d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f44696d = null;
        }
    }

    public void updateView(String str, CharSequence charSequence) {
        int i = 8;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(charSequence)) {
            this.f44697e = 0;
            setVisibility(0);
            this.f44693a.setText(str);
            this.f44693a.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
            this.f44694b.setText(charSequence);
            this.f44694b.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
            View view = this.f44695c;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(charSequence)) {
                i = 0;
            }
            view.setVisibility(i);
            return;
        }
        this.f44693a.setVisibility(8);
        this.f44694b.setVisibility(8);
        this.f44695c.setVisibility(8);
        this.f44697e = 8;
        m33172d();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public void updateLocation(int i, int i2, boolean z) {
        this.f44698f = i;
        this.f44699g = i2;
        Context context = getContext();
        this.f44700h = z ? DisplayUtils.dip2px(context, 34.0f) : -DisplayUtils.dip2px(context, 30.0f);
        m33169a();
    }

    /* renamed from: a */
    private void m33169a() {
        measure(View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f44698f - (measuredWidth / 2);
        layoutParams.topMargin = (this.f44699g - measuredHeight) + this.f44700h;
        layoutParams.rightMargin = -measuredWidth;
        layoutParams.bottomMargin = -measuredHeight;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* renamed from: b */
    private void m33170b() {
        View inflate = inflate(getContext(), R.layout.customer_layout_marker_station, (ViewGroup) null);
        this.f44693a = (TextView) inflate.findViewById(R.id.customer_custom_distance_text);
        this.f44694b = (TextView) inflate.findViewById(R.id.customer_custom_eta_text);
        this.f44695c = inflate.findViewById(R.id.customer_custom_tips_divider);
        addView(inflate);
        setVisibility(8);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f}), ofFloat});
        this.f44696d = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(200);
        this.f44696d.setInterpolator(new DecelerateInterpolator());
        this.f44696d.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MarkerInfoWindowView markerInfoWindowView = MarkerInfoWindowView.this;
                markerInfoWindowView.setVisibility(markerInfoWindowView.f44697e);
            }
        });
    }

    /* renamed from: c */
    private void m33171c() {
        ObjectAnimator objectAnimator = this.f44696d;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.f44696d.end();
            }
            setScaleX(0.0f);
            setScaleX(0.0f);
            setAlpha(0.0f);
            this.f44696d.setStartDelay(1200);
            this.f44696d.start();
        }
    }

    /* renamed from: d */
    private void m33172d() {
        if (this.f44696d != null && isShown()) {
            if (this.f44696d.isRunning()) {
                this.f44696d.end();
            }
            this.f44696d.setStartDelay(0);
            this.f44696d.reverse();
        }
    }
}
