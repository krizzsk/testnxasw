package com.didi.soda.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MaxHeightScrollView extends ScrollView {

    /* renamed from: a */
    private MaxHeightMeasure f44164a;

    /* renamed from: b */
    private OnScrollChangeListener f44165b;

    public interface OnScrollChangeListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public MaxHeightScrollView(Context context) {
        super(context);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32874a(attributeSet);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32874a(attributeSet);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.f44165b = onScrollChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, this.f44164a.onMeasureHeight(i2));
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangeListener onScrollChangeListener = this.f44165b;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    private void m32874a(AttributeSet attributeSet) {
        this.f44164a = new MaxHeightMeasure(getContext(), attributeSet);
    }
}
