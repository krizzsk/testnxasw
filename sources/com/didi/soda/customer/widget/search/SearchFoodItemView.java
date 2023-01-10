package com.didi.soda.customer.widget.search;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.ImageBottomTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.widget.goods.CustomerPriceView;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import com.taxis99.R;
import java.util.List;

public class SearchFoodItemView extends FrameLayout {

    /* renamed from: a */
    private TextView f44737a;

    /* renamed from: b */
    private ImageView f44738b;

    /* renamed from: c */
    private View f44739c;

    /* renamed from: d */
    private CustomerPriceView f44740d;

    /* renamed from: e */
    private TextView f44741e;

    /* renamed from: f */
    private View f44742f;

    /* renamed from: g */
    private ConstraintLayout f44743g;

    public SearchFoodItemView(Context context) {
        super(context);
        m33194a();
    }

    public SearchFoodItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33194a();
    }

    public SearchFoodItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33194a();
    }

    public SearchFoodItemView setData(SearchFoodItemModel searchFoodItemModel) {
        String str;
        int i;
        this.f44737a.setText(searchFoodItemModel.name);
        if (TextUtils.isEmpty(searchFoodItemModel.imgUrl)) {
            this.f44738b.setVisibility(8);
            this.f44739c.setVisibility(8);
        } else {
            this.f44738b.setVisibility(0);
            FlyImageLoader.loadImage4x3(getContext(), searchFoodItemModel.imgUrl).placeholder((int) R.drawable.customer_skin_img_business_goods_item_default).transform(new RoundedCornersTransformation(getContext(), DisplayUtils.dip2px(getContext(), 2.0f), 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f44738b);
            if (GoodsDataHelper.isNormal(searchFoodItemModel.status)) {
                this.f44739c.setVisibility(8);
            } else {
                this.f44739c.setVisibility(0);
            }
        }
        if (searchFoodItemModel.specialPrice >= 0) {
            str = LocalizationUtils.CurrencyUtils.getCurrencyDisplay(searchFoodItemModel.specialPriceDisplay, (long) searchFoodItemModel.specialPrice, searchFoodItemModel.currency, "search");
        } else {
            str = LocalizationUtils.CurrencyUtils.getCurrencyDisplay(searchFoodItemModel.priceDisplay, (long) searchFoodItemModel.price, searchFoodItemModel.currency, "search");
        }
        this.f44740d.setPriceStr(str, searchFoodItemModel.specialPrice >= 0 ? LocalizationUtils.CurrencyUtils.getCurrencyDisplay(searchFoodItemModel.priceDisplay, (long) searchFoodItemModel.price, searchFoodItemModel.currency, "search") : "");
        if (GoodsDataHelper.isNormal(searchFoodItemModel.status)) {
            this.f44737a.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
            this.f44740d.setEnabled(true);
            this.f44741e.setVisibility(8);
            i = DisplayUtils.dip2px(getContext(), 76.0f);
        } else {
            this.f44737a.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
            this.f44740d.setEnabled(false);
            this.f44741e.setVisibility(0);
            i = DisplayUtils.dip2px(getContext(), 96.0f);
        }
        this.f44743g.setMinHeight(i);
        return this;
    }

    public SearchFoodItemView setClickListener(View.OnClickListener onClickListener) {
        this.f44742f.setOnClickListener(onClickListener);
        return this;
    }

    /* renamed from: a */
    private void m33194a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_search_food_item_view, this);
        this.f44737a = (TextView) findViewById(R.id.customer_tv_name);
        this.f44738b = (ImageView) findViewById(R.id.customer_iv_image);
        this.f44739c = findViewById(R.id.customer_view_image_mask);
        this.f44740d = (CustomerPriceView) findViewById(R.id.customer_custom_price);
        this.f44741e = (TextView) findViewById(R.id.customer_tv_sold_out);
        this.f44742f = findViewById(R.id.customer_view_item_mark);
        this.f44743g = (ConstraintLayout) findViewById(R.id.customer_cl_item_container);
    }

    public static class SearchFoodItemModel {
        public String buttonUrl;
        public String currency;
        public String goodsId;
        public ImageBottomTagEntity imgBottomTag;
        public String imgUrl;
        public String itemImg;
        public String itemName;
        public String itemStatusDesc;
        public String itemUniKey;
        public int maxLevel;
        public String name;
        public int position;
        public int price;
        public String priceDisplay;
        public List<PromptEntity> priceInfo;
        public String shopId;
        public int specialPrice;
        public String specialPriceDisplay;
        public int status;
        public List<PromptEntity> tags;
        public String url;
        public ViewMoreEntity viewMoreEntity;

        public static SearchFoodItemModel convertGoodsItemEntity(GoodsItemEntity goodsItemEntity, int i) {
            SearchFoodItemModel searchFoodItemModel = new SearchFoodItemModel();
            searchFoodItemModel.shopId = goodsItemEntity.shopId;
            searchFoodItemModel.goodsId = goodsItemEntity.itemId;
            searchFoodItemModel.itemUniKey = goodsItemEntity.itemUniqKey;
            searchFoodItemModel.name = goodsItemEntity.itemName;
            searchFoodItemModel.imgUrl = goodsItemEntity.headImg;
            searchFoodItemModel.price = goodsItemEntity.price;
            searchFoodItemModel.specialPrice = goodsItemEntity.specialPrice;
            searchFoodItemModel.currency = goodsItemEntity.currency;
            searchFoodItemModel.status = goodsItemEntity.status;
            searchFoodItemModel.position = i;
            searchFoodItemModel.priceDisplay = goodsItemEntity.priceDisplay;
            searchFoodItemModel.specialPriceDisplay = goodsItemEntity.specialPriceDisplay;
            searchFoodItemModel.imgBottomTag = goodsItemEntity.imgBottomTag;
            searchFoodItemModel.maxLevel = goodsItemEntity.maxLevel;
            searchFoodItemModel.url = goodsItemEntity.url;
            searchFoodItemModel.buttonUrl = goodsItemEntity.buttonUrl;
            return searchFoodItemModel;
        }

        public static SearchFoodItemModel convertModel(GoodsItemEntity goodsItemEntity, int i) {
            SearchFoodItemModel searchFoodItemModel = new SearchFoodItemModel();
            searchFoodItemModel.itemName = goodsItemEntity.itemName;
            searchFoodItemModel.itemImg = goodsItemEntity.itemImg;
            searchFoodItemModel.goodsId = goodsItemEntity.itemId;
            searchFoodItemModel.itemUniKey = goodsItemEntity.itemUniqKey;
            searchFoodItemModel.status = goodsItemEntity.status;
            searchFoodItemModel.priceInfo = goodsItemEntity.priceInfo;
            searchFoodItemModel.tags = goodsItemEntity.tags;
            searchFoodItemModel.itemStatusDesc = goodsItemEntity.itemStatusDesc;
            searchFoodItemModel.position = i;
            searchFoodItemModel.imgBottomTag = goodsItemEntity.imgBottomTag;
            searchFoodItemModel.maxLevel = goodsItemEntity.maxLevel;
            searchFoodItemModel.price = goodsItemEntity.price;
            searchFoodItemModel.specialPrice = goodsItemEntity.specialPrice;
            searchFoodItemModel.url = goodsItemEntity.url;
            searchFoodItemModel.buttonUrl = goodsItemEntity.buttonUrl;
            return searchFoodItemModel;
        }

        public static SearchFoodItemModel convertModel(ViewMoreEntity viewMoreEntity2, int i) {
            SearchFoodItemModel searchFoodItemModel = new SearchFoodItemModel();
            searchFoodItemModel.viewMoreEntity = viewMoreEntity2;
            searchFoodItemModel.position = i;
            return searchFoodItemModel;
        }
    }
}
