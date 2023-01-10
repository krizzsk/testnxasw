package com.didi.soda.order.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.taxis99.R;

public class OrderExtraInfoItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f46169a;

    /* renamed from: b */
    private TextView f46170b;

    public OrderExtraInfoItemView(Context context) {
        super(context);
        m34294a();
    }

    public OrderExtraInfoItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34294a();
    }

    public OrderExtraInfoItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34294a();
    }

    public void setText(String str, String str2) {
        this.f46169a.setText(str);
        this.f46170b.setText(str2);
    }

    /* renamed from: a */
    private void m34294a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_extra_info, this);
        this.f46169a = (TextView) findViewById(R.id.customer_tv_title);
        this.f46170b = (TextView) findViewById(R.id.customer_tv_desc);
    }
}
