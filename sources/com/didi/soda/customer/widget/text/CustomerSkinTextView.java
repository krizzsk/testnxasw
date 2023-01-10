package com.didi.soda.customer.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;

public class CustomerSkinTextView extends CustomerAppCompatTextView {
    public CustomerSkinTextView(Context context) {
        super(context);
        m33223a();
    }

    public CustomerSkinTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33223a();
    }

    public CustomerSkinTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33223a();
    }

    public void setBackgroundResourceKeepPadding(int i) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        super.setBackgroundResource(i);
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    /* renamed from: a */
    private void m33223a() {
        setTextColor(SkinUtil.getBrandPrimaryColor());
    }
}
