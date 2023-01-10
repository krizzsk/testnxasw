package com.didi.soda.customer.widget;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerIndicator extends LinearLayout {

    /* renamed from: a */
    private Context f44079a;

    /* renamed from: b */
    private int f44080b;

    /* renamed from: c */
    private int f44081c;

    /* renamed from: d */
    private int f44082d;

    /* renamed from: e */
    private int f44083e;

    /* renamed from: f */
    private int f44084f;

    /* renamed from: g */
    private List<View> f44085g;

    /* renamed from: h */
    private int f44086h;

    public CustomerIndicator(Context context) {
        this(context, (AttributeSet) null);
        m32843a(context, (AttributeSet) null);
    }

    public CustomerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m32843a(context, attributeSet);
    }

    public CustomerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44079a = null;
        this.f44085g = null;
        this.f44086h = 0;
        m32843a(context, attributeSet);
    }

    public void initIndicator(int i) {
        List<View> list = this.f44085g;
        if (list == null) {
            this.f44085g = new ArrayList();
        } else {
            list.clear();
            removeAllViews();
        }
        if (i > 1) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f44081c, this.f44080b);
            int i2 = this.f44082d;
            layoutParams.setMargins(i2, i2, i2, i2);
            for (int i3 = 0; i3 < i; i3++) {
                View view = new View(this.f44079a);
                view.setBackgroundResource(R.drawable.customer_banner_indicator_bg);
                ((GradientDrawable) view.getBackground()).setColor(this.f44084f);
                addView(view, layoutParams);
                this.f44085g.add(view);
            }
            if (this.f44085g.size() > 0) {
                ((GradientDrawable) this.f44085g.get(0).getBackground()).setColor(this.f44083e);
            }
            this.f44086h = 0;
        }
    }

    public void setSelectedPage(int i) {
        List<View> list = this.f44085g;
        if (list != null && list.size() > 0) {
            if (i >= this.f44085g.size()) {
                i = this.f44085g.size() - 1;
            }
            int i2 = this.f44086h;
            if (i != i2) {
                m32842a(i2, this.f44083e, this.f44084f);
                m32842a(i, this.f44084f, this.f44083e);
                this.f44086h = i;
            }
        }
    }

    /* renamed from: a */
    private void m32842a(int i, int i2, int i3) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt((GradientDrawable) this.f44085g.get(i).getBackground(), "color", new int[]{i2, i3});
        ofInt.setDuration(260);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.start();
    }

    /* renamed from: a */
    private void m32843a(Context context, AttributeSet attributeSet) {
        this.f44079a = context;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CustomerIndicator);
            this.f44083e = obtainStyledAttributes.getColor(3, context.getResources().getColor(R.color.rf_color_white_100_FFFFFF));
            this.f44084f = obtainStyledAttributes.getColor(4, context.getResources().getColor(R.color.rf_color_gery_16_93_5C000000));
            this.f44081c = (int) obtainStyledAttributes.getDimension(2, (float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_22px));
            this.f44080b = (int) obtainStyledAttributes.getDimension(0, (float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_6px));
            this.f44082d = (int) obtainStyledAttributes.getDimension(1, (float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px));
            obtainStyledAttributes.recycle();
        }
        setGravity(17);
        setOrientation(0);
    }
}
