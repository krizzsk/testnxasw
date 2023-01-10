package com.didi.soda.customer.widget.cart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;

public class CustomerMaxFeeExplainViewGroup extends LinearLayout {

    /* renamed from: a */
    private Context f44280a;

    public CustomerMaxFeeExplainViewGroup(Context context) {
        super(context);
        this.f44280a = context;
    }

    public CustomerMaxFeeExplainViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44280a = context;
    }

    public CustomerMaxFeeExplainViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44280a = context;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int screenHeight = (CustomerSystemUtil.getScreenHeight(this.f44280a) - CustomerSystemUtil.getStatusBarHeight(this.f44280a)) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_48px);
        if (size > screenHeight) {
            size = screenHeight;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }
}
