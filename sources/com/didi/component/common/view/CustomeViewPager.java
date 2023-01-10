package com.didi.component.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C11267R;
import com.duolingo.open.rtlviewpager.RtlViewPager;

public class CustomeViewPager extends RtlViewPager {

    /* renamed from: a */
    private boolean f13652a = true;

    /* renamed from: b */
    private boolean f13653b = false;

    public CustomeViewPager(Context context) {
        super(context);
    }

    public CustomeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CustomeViewPager);
        this.f13652a = obtainStyledAttributes.getBoolean(0, true);
        this.f13653b = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f13653b) {
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
            }
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public boolean canScrollHorizontally(int i) {
        return this.f13652a;
    }
}
