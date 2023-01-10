package com.didi.soda.customer.widget.search;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goods.CustomerPriceView;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import com.taxis99.R;

public class SearchBusinessDishView extends FrameLayout {

    /* renamed from: a */
    private CustomerAppCompatTextView f44726a;

    /* renamed from: b */
    private ImageView f44727b;

    /* renamed from: c */
    private CustomerPriceView f44728c;

    /* renamed from: d */
    private CustomerAppCompatTextView f44729d;

    /* renamed from: e */
    private View f44730e;

    /* renamed from: f */
    private ConstraintLayout f44731f;

    public SearchBusinessDishView(Context context) {
        super(context);
        m33188a();
    }

    public SearchBusinessDishView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33188a();
    }

    public SearchBusinessDishView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33188a();
    }

    public SearchBusinessDishView setData(SearchFoodItemView.SearchFoodItemModel searchFoodItemModel) {
        String str;
        int i;
        this.f44726a.setText(searchFoodItemModel.name);
        if (TextUtils.isEmpty(searchFoodItemModel.imgUrl)) {
            this.f44727b.setVisibility(8);
        } else {
            this.f44727b.setVisibility(0);
            FlyImageLoader.loadImage4x3(getContext(), searchFoodItemModel.imgUrl).placeholder((int) R.drawable.customer_skin_img_business_goods_item_default).transform(new RoundedCornersTransformation(getContext(), DisplayUtils.dip2px(getContext(), 4.0f), 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f44727b);
        }
        if (searchFoodItemModel.specialPrice >= 0) {
            str = LocalizationUtils.CurrencyUtils.getCurrencyDisplay(searchFoodItemModel.specialPriceDisplay, (long) searchFoodItemModel.specialPrice, searchFoodItemModel.currency, "search");
        } else {
            str = LocalizationUtils.CurrencyUtils.getCurrencyDisplay(searchFoodItemModel.priceDisplay, (long) searchFoodItemModel.price, searchFoodItemModel.currency, "search");
        }
        String currencyDisplay = searchFoodItemModel.specialPrice >= 0 ? LocalizationUtils.CurrencyUtils.getCurrencyDisplay(searchFoodItemModel.priceDisplay, (long) searchFoodItemModel.price, searchFoodItemModel.currency, "search") : "";
        this.f44728c.setFontType(IToolsService.FontType.LIGHT, IToolsService.FontType.LIGHT);
        this.f44728c.setPriceStr(str, currencyDisplay);
        if (GoodsDataHelper.isNormal(searchFoodItemModel.status)) {
            this.f44729d.setVisibility(8);
            i = DisplayUtils.dip2px(getContext(), 59.0f);
        } else {
            this.f44729d.setVisibility(0);
            i = DisplayUtils.dip2px(getContext(), 68.0f);
        }
        ViewGroup.LayoutParams layoutParams = this.f44731f.getLayoutParams();
        layoutParams.height = i;
        this.f44731f.setLayoutParams(layoutParams);
        return this;
    }

    public SearchBusinessDishView setClickListener(View.OnClickListener onClickListener) {
        this.f44730e.setOnClickListener(onClickListener);
        return this;
    }

    /* renamed from: a */
    private void m33188a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_search_dish_item_view, this);
        this.f44726a = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_name);
        this.f44727b = (ImageView) findViewById(R.id.customer_iv_image);
        this.f44728c = (CustomerPriceView) findViewById(R.id.customer_custom_price);
        this.f44729d = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_sold_out);
        this.f44730e = findViewById(R.id.customer_view_item_mark);
        this.f44731f = (ConstraintLayout) findViewById(R.id.customer_cl_item_container);
    }
}
