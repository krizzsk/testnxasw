package com.didi.rfusion.widget.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.passenger.C11267R;

public class RFSuperFrameLayout extends FrameLayout {

    /* renamed from: a */
    private int f36371a;

    /* renamed from: b */
    private int f36372b;

    public RFSuperFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFSuperFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFSuperFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36371a = 0;
        this.f36372b = 0;
        m27409a(attributeSet);
    }

    /* renamed from: a */
    private void m27409a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.RFSuperFrameLayout);
        this.f36371a = (int) obtainStyledAttributes.getDimension(0, (float) this.f36371a);
        this.f36372b = (int) obtainStyledAttributes.getDimension(1, (float) this.f36372b);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f36371a > 0) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size, this.f36371a), Integer.MIN_VALUE);
            } else if (mode == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(this.f36371a, Integer.MIN_VALUE);
            } else if (mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size, this.f36371a), 1073741824);
            }
        }
        if (this.f36372b > 0) {
            int size2 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i);
            if (mode2 == Integer.MIN_VALUE) {
                i = View.MeasureSpec.makeMeasureSpec(Math.min(size2, this.f36372b), Integer.MIN_VALUE);
            } else if (mode2 == 0) {
                i = View.MeasureSpec.makeMeasureSpec(this.f36372b, Integer.MIN_VALUE);
            } else if (mode2 == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.min(size2, this.f36372b), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setMaxHeight(int i) {
        if (this.f36371a != i) {
            this.f36371a = i;
            postInvalidate();
        }
    }

    public void setMaxWidth(int i) {
        if (this.f36372b != i) {
            this.f36372b = i;
            postInvalidate();
        }
    }
}
