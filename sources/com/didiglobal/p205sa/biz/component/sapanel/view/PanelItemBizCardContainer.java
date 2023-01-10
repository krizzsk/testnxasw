package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import com.didi.global.globaluikit.utils.UiUtils;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.PanelItemBizCardContainer */
public class PanelItemBizCardContainer extends SaShadowCard {
    public PanelItemBizCardContainer(Context context) {
        super(context);
        m40060a();
    }

    public PanelItemBizCardContainer(Context context, AttributeSet attributeSet) {
        super(context);
        m40060a();
    }

    /* renamed from: a */
    private void m40060a() {
        int parseColor = Color.parseColor("#1A89A2AE");
        int dip2px = UiUtils.dip2px(getContext(), 10.0f);
        setShadowLimit(dip2px);
        setPadding(0, 0, 0, dip2px);
        setmShadowColor(parseColor);
    }
}
