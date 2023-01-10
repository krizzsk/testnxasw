package com.didi.entrega.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.passenger.C11267R;

public class MaxHeightMeasure {

    /* renamed from: a */
    private static final float f22165a = 0.0f;

    /* renamed from: b */
    private static final float f22166b = 0.0f;

    /* renamed from: c */
    private float f22167c = 0.0f;

    /* renamed from: d */
    private float f22168d = 0.0f;

    public MaxHeightMeasure(Context context, AttributeSet attributeSet) {
        initAttrs(context, attributeSet);
    }

    public void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaMaxHeightMeasure);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.f22168d = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == 1) {
                this.f22167c = obtainStyledAttributes.getFloat(index, 0.0f);
            }
        }
        if (this.f22168d <= 0.0f && this.f22167c > 0.0f) {
            this.f22168d = ((float) CustomerSystemUtil.getScreenHeight(context)) * this.f22167c;
        }
        obtainStyledAttributes.recycle();
    }

    public int onMeasureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        float f = this.f22168d;
        if (f <= 0.0f) {
            return i;
        }
        if (((float) size) > f) {
            size = (int) f;
        }
        return View.MeasureSpec.makeMeasureSpec(size, mode);
    }
}
