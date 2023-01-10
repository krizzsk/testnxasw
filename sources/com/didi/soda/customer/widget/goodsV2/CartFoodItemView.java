package com.didi.soda.customer.widget.goodsV2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class CartFoodItemView extends ConstraintLayout implements View.OnClickListener {
    public static final int TYPE_BUSINESS_INVALID = 101;
    public static final int TYPE_ITEM_INVALID = 102;
    public static final int TYPE_NORMAL = 100;

    /* renamed from: a */
    private TextView f44459a;

    /* renamed from: b */
    private TextView f44460b;

    /* renamed from: c */
    private TextView f44461c;

    /* renamed from: d */
    private TextView f44462d;

    /* renamed from: e */
    private TextView f44463e;

    /* renamed from: f */
    private ImageView f44464f;

    /* renamed from: g */
    private ImageView f44465g;

    /* renamed from: h */
    private TextView f44466h;

    /* renamed from: i */
    private LinearLayout f44467i;

    /* renamed from: j */
    private GoodsQuantityListener f44468j;

    /* renamed from: k */
    private FoodItemModel f44469k;

    public static class FoodItemModel {
        public int amount;
        public String currentPrice;
        public String desc;
        public String mduId;
        public CharSequence name;
        public String originalPrice;
    }

    public CartFoodItemView(Context context) {
        super(context);
        m33011a();
    }

    public CartFoodItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33011a();
    }

    public CartFoodItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33011a();
    }

    public CartFoodItemView setData(FoodItemModel foodItemModel) {
        this.f44469k = foodItemModel;
        this.f44459a.setText(foodItemModel.name);
        if (TextUtils.isEmpty(foodItemModel.desc)) {
            this.f44460b.setVisibility(8);
        } else {
            this.f44460b.setText(foodItemModel.desc);
            this.f44460b.setVisibility(0);
        }
        if (!TextUtils.isEmpty(foodItemModel.originalPrice) && !foodItemModel.originalPrice.equals(foodItemModel.currentPrice)) {
            this.f44461c.setText(foodItemModel.originalPrice);
        }
        this.f44462d.setText(foodItemModel.currentPrice);
        TextView textView = this.f44466h;
        textView.setText("" + foodItemModel.amount);
        return this;
    }

    public CartFoodItemView setListener(GoodsQuantityListener goodsQuantityListener) {
        this.f44468j = goodsQuantityListener;
        return this;
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public CartFoodItemView setType(int i) {
        if (i == 101) {
            this.f44459a.setTextColor(getResources().getColor(R.color.rf_color_gery_1_0_000000));
            this.f44460b.setTextColor(getResources().getColor(R.color.rf_color_gery_3_60_999999));
            setAddOrSubtractEnable(false);
            this.f44462d.setVisibility(0);
            this.f44461c.setVisibility(0);
            this.f44463e.setVisibility(8);
            this.f44467i.setVisibility(0);
        } else if (i == 102) {
            this.f44467i.setVisibility(4);
            this.f44463e.setVisibility(0);
            this.f44459a.setTextColor(getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC));
            this.f44460b.setTextColor(getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC));
            this.f44462d.setVisibility(8);
            this.f44461c.setVisibility(8);
        } else {
            this.f44467i.setVisibility(0);
            this.f44459a.setTextColor(getResources().getColor(R.color.rf_color_gery_1_0_000000));
            this.f44460b.setTextColor(getResources().getColor(R.color.rf_color_gery_3_60_999999));
            this.f44462d.setVisibility(0);
            this.f44461c.setVisibility(0);
            setAddOrSubtractEnable(true);
            this.f44463e.setVisibility(8);
        }
        return this;
    }

    public void onClick(View view) {
        GoodsQuantityListener goodsQuantityListener;
        if (view.getId() == R.id.customer_iv_add) {
            GoodsQuantityListener goodsQuantityListener2 = this.f44468j;
            if (goodsQuantityListener2 != null) {
                goodsQuantityListener2.onAddGoodsClick(this.f44469k.mduId, this.f44465g, (Bundle) null);
            }
        } else if (view.getId() == R.id.customer_iv_subtract && (goodsQuantityListener = this.f44468j) != null) {
            goodsQuantityListener.onSubtractGoodsClick(this.f44469k.mduId, (Bundle) null);
        }
    }

    private void setAddOrSubtractEnable(boolean z) {
        this.f44465g.setEnabled(z);
        this.f44464f.setEnabled(z);
        this.f44466h.setEnabled(z);
    }

    /* renamed from: a */
    private void m33011a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_food_area, this);
        this.f44459a = (TextView) findViewById(R.id.customer_tv_food_name);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44459a, IToolsService.FontType.MEDIUM);
        this.f44460b = (TextView) findViewById(R.id.customer_tv_food_desc);
        TextView textView = (TextView) findViewById(R.id.customer_tv_food_original_price);
        this.f44461c = textView;
        textView.getPaint().setFlags(16);
        this.f44462d = (TextView) findViewById(R.id.customer_tv_food_current_price);
        this.f44467i = (LinearLayout) findViewById(R.id.customer_counter_container);
        this.f44464f = (ImageView) findViewById(R.id.customer_iv_subtract);
        this.f44465g = (ImageView) findViewById(R.id.customer_iv_add);
        this.f44466h = (TextView) findViewById(R.id.customer_tv_amount);
        this.f44463e = (TextView) findViewById(R.id.customer_tv_item_invalidation);
        this.f44465g.setOnClickListener(this);
        this.f44464f.setOnClickListener(this);
    }
}
