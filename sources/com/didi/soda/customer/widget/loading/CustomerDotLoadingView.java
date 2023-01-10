package com.didi.soda.customer.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.customer.foundation.skin.SkinUtil;

public class CustomerDotLoadingView extends DotLoadingView {
    public CustomerDotLoadingView(Context context) {
        super(context);
        m33137a();
    }

    public CustomerDotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33137a();
    }

    public CustomerDotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33137a();
    }

    /* renamed from: a */
    private void m33137a() {
        setColor(SkinUtil.getDotLoadingNormalColor(), SkinUtil.getDotLoadingHighlightColor());
    }
}
