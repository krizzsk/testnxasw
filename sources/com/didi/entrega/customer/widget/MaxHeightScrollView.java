package com.didi.entrega.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MaxHeightScrollView extends ScrollView {

    /* renamed from: a */
    private MaxHeightMeasure f22169a;

    /* renamed from: b */
    private OnScrollChangeListener f22170b;

    public interface OnScrollChangeListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public MaxHeightScrollView(Context context) {
        super(context);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18324a(attributeSet);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18324a(attributeSet);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.f22170b = onScrollChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, this.f22169a.onMeasureHeight(i2));
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollChangeListener onScrollChangeListener = this.f22170b;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    private void m18324a(AttributeSet attributeSet) {
        this.f22169a = new MaxHeightMeasure(getContext(), attributeSet);
    }
}
