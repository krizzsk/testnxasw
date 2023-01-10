package com.didi.entrega.customer.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.entrega.customer.foundation.skin.SkinUtil;

public class CustomerDotLoadingView extends DotLoadingView {
    public CustomerDotLoadingView(Context context) {
        super(context);
        m18449a();
    }

    public CustomerDotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18449a();
    }

    public CustomerDotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18449a();
    }

    /* renamed from: a */
    private void m18449a() {
        setColor(SkinUtil.getDotLoadingNormalColor(), SkinUtil.getDotLoadingHighlightColor());
    }
}
