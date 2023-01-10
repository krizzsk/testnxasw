package com.didi.sdk.global.sign.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.taxis99.R;

public class ExpandShrinkView extends LinearLayout {

    /* renamed from: a */
    private View f39121a;

    /* renamed from: b */
    private View f39122b;

    public ExpandShrinkView(Context context) {
        super(context);
        m29457a(context);
    }

    public ExpandShrinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29457a(context);
    }

    public ExpandShrinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29457a(context);
    }

    /* renamed from: a */
    private void m29457a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.one_payment_v_global_pay_list_expand_shrink, this, true);
        this.f39121a = inflate.findViewById(R.id.tv_more);
        this.f39122b = inflate.findViewById(R.id.tv_less);
    }

    public void setIsExpand(boolean z) {
        if (z) {
            this.f39121a.setVisibility(8);
            this.f39122b.setVisibility(0);
            return;
        }
        this.f39121a.setVisibility(0);
        this.f39122b.setVisibility(8);
    }
}
