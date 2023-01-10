package com.didi.soda.customer.widget.goods;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.nova.assembly.p128ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.foundation.rpc.entity.ActTagEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goodsV2.GoodActTagLayout;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goodsV2.model.GoodsPurchaseHeaderRvModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GoodsStateBar extends ConstraintLayout {

    /* renamed from: a */
    private CustomerPriceView f44454a;

    /* renamed from: b */
    private TextView f44455b;

    /* renamed from: c */
    private NovaFlowLayout f44456c;

    /* renamed from: d */
    private FrameLayout f44457d;

    /* renamed from: e */
    private List<GoodActTagLayout> f44458e = new ArrayList();

    public GoodsStateBar(Context context) {
        super(context);
        m33010c();
    }

    public GoodsStateBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33010c();
    }

    public GoodsStateBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33010c();
    }

    public GoodsStateBar setGoodsAmountModel(GoodsAmountModel goodsAmountModel) {
        if (goodsAmountModel.mGoodsItemState == GoodsItemState.FOR_SALE) {
            this.f44455b.setTextColor(SkinUtil.getBrandPrimaryColor());
        } else {
            this.f44455b.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
        }
        return this;
    }

    public GoodsStateBar setMarketingTip(SpannableStringBuilder spannableStringBuilder) {
        if (this.f44455b == null) {
            return this;
        }
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            this.f44455b.setVisibility(0);
            this.f44455b.setText(spannableStringBuilder);
        } else {
            this.f44455b.setVisibility(8);
        }
        return this;
    }

    public GoodsStateBar setMaxPriceWidth(int i) {
        CustomerPriceView customerPriceView = this.f44454a;
        if (customerPriceView != null) {
            customerPriceView.setMaxWidth(i);
        }
        return this;
    }

    public GoodsStateBar setPrice(String str, String str2) {
        CustomerPriceView customerPriceView = this.f44454a;
        if (customerPriceView != null) {
            customerPriceView.setPriceStr(str, str2);
        }
        return this;
    }

    public GoodsStateBar setActTag(List<ActTagEntity> list) {
        if (list == null || list.size() <= 0) {
            this.f44456c.setVisibility(8);
        } else {
            this.f44456c.setVisibility(0);
            m33009b();
            for (ActTagEntity next : list) {
                GoodActTagLayout a = m33008a();
                if (a == null) {
                    a = new GoodActTagLayout(getContext());
                }
                this.f44456c.addView(a);
                a.setActTag(next);
            }
        }
        return this;
    }

    public GoodsStateBar setActTag(GoodsPurchaseHeaderRvModel.ActTagModel actTagModel, GoodsItemState goodsItemState) {
        if (actTagModel != null) {
            this.f44456c.setVisibility(0);
            m33009b();
            GoodActTagLayout a = m33008a();
            if (a == null) {
                a = new GoodActTagLayout(getContext());
            }
            this.f44456c.addView(a);
            a.setActTag(actTagModel, goodsItemState);
        } else {
            this.f44456c.setVisibility(8);
        }
        return this;
    }

    /* renamed from: a */
    private GoodActTagLayout m33008a() {
        if (this.f44458e.size() > 0) {
            return this.f44458e.remove(0);
        }
        return null;
    }

    /* renamed from: b */
    private void m33009b() {
        int childCount = this.f44456c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f44456c.getChildAt(i);
            if (childAt instanceof GoodActTagLayout) {
                this.f44458e.add((GoodActTagLayout) childAt);
            }
        }
        this.f44456c.removeAllViews();
    }

    /* renamed from: c */
    private void m33010c() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_goods_state_bar, this);
        this.f44454a = (CustomerPriceView) findViewById(R.id.customer_custom_goods_price);
        this.f44455b = (TextView) findViewById(R.id.customer_tv_goods_marketing_tips);
        this.f44456c = (NovaFlowLayout) findViewById(R.id.customer_tv_goods_act_tag);
        this.f44457d = (FrameLayout) findViewById(R.id.customer_fl_price_container);
        this.f44454a.setFontType(IToolsService.FontType.LIGHT, IToolsService.FontType.LIGHT);
    }
}
