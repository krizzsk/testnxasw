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

public class OrderDetailFoodsItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f46119a;

    /* renamed from: b */
    private TextView f46120b;

    /* renamed from: c */
    private TextView f46121c;

    /* renamed from: d */
    private TextView f46122d;

    /* renamed from: e */
    private TextView f46123e;

    /* renamed from: f */
    private TextView f46124f;

    public OrderDetailFoodsItemView(Context context) {
        super(context);
        m34261a();
    }

    public OrderDetailFoodsItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34261a();
    }

    public OrderDetailFoodsItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34261a();
    }

    public OrderDetailFoodsItemView setData(FoodItem foodItem) {
        this.f46119a.setText(foodItem.mName);
        if (!TextUtils.isEmpty(foodItem.mDesc)) {
            this.f46120b.setText(foodItem.mDesc);
            this.f46120b.setVisibility(0);
        } else {
            this.f46120b.setVisibility(8);
        }
        if (TextUtils.isEmpty(foodItem.mOriginalPrice) || foodItem.mCurrentPrice.equals(foodItem.mOriginalPrice)) {
            this.f46122d.setVisibility(8);
        } else {
            this.f46122d.setText(foodItem.mOriginalPrice);
        }
        if (!TextUtils.isEmpty(foodItem.mCurrentPrice)) {
            this.f46121c.setText(foodItem.mCurrentPrice);
        } else {
            this.f46121c.setVisibility(8);
        }
        this.f46123e.setText(Html.fromHtml(getResources().getString(R.string.customer_order_amount, new Object[]{Integer.valueOf(foodItem.mAmount)})));
        if (!TextUtils.isEmpty(foodItem.mAbnormalDesc)) {
            this.f46124f.setText(foodItem.mAbnormalDesc);
            this.f46124f.setVisibility(0);
        } else {
            this.f46124f.setVisibility(8);
        }
        return this;
    }

    /* renamed from: a */
    private void m34261a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_food, this);
        this.f46119a = (TextView) findViewById(R.id.customer_tv_food_name);
        this.f46120b = (TextView) findViewById(R.id.customer_tv_food_desc);
        this.f46123e = (TextView) findViewById(R.id.customer_tv_food_count);
        this.f46121c = (TextView) findViewById(R.id.customer_tv_food_current_price);
        this.f46122d = (TextView) findViewById(R.id.customer_tv_food_original_price);
        this.f46124f = (TextView) findViewById(R.id.customer_abnormal_desc_tv);
        this.f46122d.getPaint().setFlags(16);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46119a, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46123e, IToolsService.FontType.MEDIUM);
    }
}
