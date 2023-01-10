package com.didi.soda.order.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.order.builder.FoodItem;
import com.taxis99.R;

public class OrderDetailBuyGiftItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f46111a;

    /* renamed from: b */
    private TextView f46112b;

    /* renamed from: c */
    private TextView f46113c;

    /* renamed from: d */
    private TextView f46114d;

    public OrderDetailBuyGiftItemView(Context context) {
        super(context);
        m34259a();
    }

    public OrderDetailBuyGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34259a();
    }

    public OrderDetailBuyGiftItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34259a();
    }

    public OrderDetailBuyGiftItemView setData(FoodItem foodItem) {
        this.f46111a.setText(foodItem.mName);
        if (!foodItem.mCurrentPrice.equals(foodItem.mOriginalPrice)) {
            this.f46112b.setText(foodItem.mOriginalPrice);
        }
        this.f46113c.setText(foodItem.mCurrentPrice);
        this.f46114d.setText(getResources().getString(R.string.customer_order_amount, new Object[]{Integer.valueOf(foodItem.mAmount)}));
        return this;
    }

    /* renamed from: a */
    private void m34259a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_detail_buy_gift_area, this);
        this.f46111a = (TextView) findViewById(R.id.customer_tv_food_name);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46111a, IToolsService.FontType.MEDIUM);
        TextView textView = (TextView) findViewById(R.id.customer_tv_food_original_price);
        this.f46112b = textView;
        textView.getPaint().setFlags(16);
        this.f46113c = (TextView) findViewById(R.id.customer_tv_food_current_price);
        this.f46114d = (TextView) findViewById(R.id.customer_tv_gift_count);
    }
}
