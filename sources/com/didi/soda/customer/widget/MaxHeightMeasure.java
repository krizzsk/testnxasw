package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;

public class MaxHeightMeasure {

    /* renamed from: a */
    private static final float f44160a = 0.0f;

    /* renamed from: b */
    private static final float f44161b = 0.0f;

    /* renamed from: c */
    private float f44162c = 0.0f;

    /* renamed from: d */
    private float f44163d = 0.0f;

    public MaxHeightMeasure(Context context, AttributeSet attributeSet) {
        initAttrs(context, attributeSet);
    }

    public void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.MaxHeightMeasure);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.f44163d = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 1) {
                this.f44162c = obtainStyledAttributes.getFloat(index, 0.0f);
            }
        }
        if (this.f44163d <= 0.0f && this.f44162c > 0.0f) {
            this.f44163d = ((float) CustomerSystemUtil.getScreenHeight(context)) * this.f44162c;
        }
        obtainStyledAttributes.recycle();
    }

    public int onMeasureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        float f = this.f44163d;
        if (f <= 0.0f) {
            return i;
        }
        if (((float) size) > f) {
            size = (int) f;
        }
        return View.MeasureSpec.makeMeasureSpec(size, mode);
    }
}
