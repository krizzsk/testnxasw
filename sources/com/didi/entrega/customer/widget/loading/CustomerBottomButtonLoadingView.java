package com.didi.entrega.customer.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import com.taxis99.R;

public class CustomerBottomButtonLoadingView extends DotLoadingView {
    public CustomerBottomButtonLoadingView(Context context) {
        super(context);
        m18448a();
    }

    public CustomerBottomButtonLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18448a();
    }

    public CustomerBottomButtonLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18448a();
    }

    /* renamed from: a */
    private void m18448a() {
        setColor(getContext().getResources().getColor(R.color.rf_color_disable_1_100), getContext().getResources().getColor(R.color.rf_color_jianbian_2));
    }
}
