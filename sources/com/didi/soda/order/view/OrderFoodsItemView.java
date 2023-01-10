package com.didi.soda.order.view;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.order.builder.FoodItem;
import com.taxis99.R;

public class OrderFoodsItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f46171a;

    /* renamed from: b */
    private TextView f46172b;

    /* renamed from: c */
    private TextView f46173c;

    public OrderFoodsItemView(Context context) {
        super(context);
        m34295a();
    }

    public OrderFoodsItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34295a();
    }

    public OrderFoodsItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34295a();
    }

    public OrderFoodsItemView setData(FoodItem foodItem) {
        this.f46171a.setText(foodItem.mName);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46171a, IToolsService.FontType.MEDIUM);
        this.f46172b.setText(Html.fromHtml(getResources().getString(R.string.customer_order_amount, new Object[]{Integer.valueOf(foodItem.mAmount)})));
        if (!TextUtils.isEmpty(foodItem.mAbnormalDesc)) {
            this.f46173c.setText(foodItem.mAbnormalDesc);
            this.f46173c.setVisibility(0);
        } else {
            this.f46173c.setVisibility(8);
        }
        return this;
    }

    /* renamed from: a */
    private void m34295a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_preview_food, this);
        this.f46171a = (TextView) findViewById(R.id.customer_tv_food_name);
        this.f46172b = (TextView) findViewById(R.id.customer_tv_food_count);
        this.f46173c = (TextView) findViewById(R.id.customer_abnormal_desc_tv);
    }
}
