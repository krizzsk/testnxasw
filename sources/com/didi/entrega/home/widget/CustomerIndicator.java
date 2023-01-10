package com.didi.entrega.home.widget;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerIndicator extends LinearLayout {

    /* renamed from: a */
    private Context f22592a;

    /* renamed from: b */
    private int f22593b;

    /* renamed from: c */
    private int f22594c;

    /* renamed from: d */
    private int f22595d;

    /* renamed from: e */
    private int f22596e;

    /* renamed from: f */
    private int f22597f;

    /* renamed from: g */
    private List<View> f22598g;

    /* renamed from: h */
    private int f22599h;

    public CustomerIndicator(Context context) {
        this(context, (AttributeSet) null);
        m18589a(context, (AttributeSet) null);
    }

    public CustomerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m18589a(context, attributeSet);
    }

    public CustomerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22592a = null;
        this.f22598g = null;
        this.f22599h = 0;
        m18589a(context, attributeSet);
    }

    public void initIndicator(int i) {
        List<View> list = this.f22598g;
        if (list == null) {
            this.f22598g = new ArrayList();
        } else {
            list.clear();
            removeAllViews();
        }
        if (i > 1) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f22594c, this.f22593b);
            int i2 = this.f22595d;
            layoutParams.setMargins(i2, i2, i2, i2);
            for (int i3 = 0; i3 < i; i3++) {
                View view = new View(this.f22592a);
                view.setBackgroundResource(R.drawable.entrega_banner_indicator_bg);
                ((GradientDrawable) view.getBackground()).setColor(this.f22597f);
                addView(view, layoutParams);
                this.f22598g.add(view);
            }
            if (this.f22598g.size() > 0) {
                ((GradientDrawable) this.f22598g.get(0).getBackground()).setColor(this.f22596e);
            }
            this.f22599h = 0;
        }
    }

    public void setSelectedPage(int i) {
        List<View> list = this.f22598g;
        if (list != null && list.size() > 0) {
            if (i >= this.f22598g.size()) {
                i = this.f22598g.size() - 1;
            }
            int i2 = this.f22599h;
            if (i != i2) {
                m18588a(i2, this.f22596e, this.f22597f);
                m18588a(i, this.f22597f, this.f22596e);
                this.f22599h = i;
            }
        }
    }

    /* renamed from: a */
    private void m18588a(int i, int i2, int i3) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt((GradientDrawable) this.f22598g.get(i).getBackground(), "color", new int[]{i2, i3});
        ofInt.setDuration(260);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.start();
    }

    /* renamed from: a */
    private void m18589a(Context context, AttributeSet attributeSet) {
        this.f22592a = context;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaIndicator);
            this.f22596e = obtainStyledAttributes.getColor(3, context.getResources().getColor(R.color.rf_color_white_100_FFFFFF));
            this.f22597f = obtainStyledAttributes.getColor(4, context.getResources().getColor(R.color.rf_color_gery_16_93_5C000000));
            this.f22594c = (int) obtainStyledAttributes.getDimension(2, (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_22));
            this.f22593b = (int) obtainStyledAttributes.getDimension(0, (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_6));
            this.f22595d = (int) obtainStyledAttributes.getDimension(1, (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_8));
            obtainStyledAttributes.recycle();
        }
        setGravity(17);
        setOrientation(0);
    }
}
