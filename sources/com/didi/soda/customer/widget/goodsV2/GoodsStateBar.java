package com.didi.soda.customer.widget.goodsV2;

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
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goodsV2.contract.GoodsAmountModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseHeaderRvModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GoodsStateBar extends ConstraintLayout {

    /* renamed from: a */
    private CustomerPriceView f44500a;

    /* renamed from: b */
    private TextView f44501b;

    /* renamed from: c */
    private NovaFlowLayout f44502c;

    /* renamed from: d */
    private FrameLayout f44503d;

    /* renamed from: e */
    private List<GoodActTagLayout> f44504e = new ArrayList();

    /* renamed from: f */
    private CustomerAppCompatTextView f44505f;

    public GoodsStateBar(Context context) {
        super(context);
        m33033c();
    }

    public GoodsStateBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33033c();
    }

    public GoodsStateBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33033c();
    }

    public GoodsStateBar setGoodsAmountModel(GoodsAmountModel goodsAmountModel) {
        if (goodsAmountModel.mGoodsItemState == GoodsItemState.FOR_SALE) {
            this.f44501b.setTextColor(SkinUtil.getBrandPrimaryColor());
        } else {
            this.f44501b.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_3_60_999999));
        }
        return this;
    }

    public GoodsStateBar setMarketingTip(SpannableStringBuilder spannableStringBuilder) {
        if (this.f44501b == null) {
            return this;
        }
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            this.f44501b.setVisibility(0);
            this.f44501b.setText(spannableStringBuilder);
        } else {
            this.f44501b.setVisibility(8);
        }
        return this;
    }

    public GoodsStateBar setPrice(String str, String str2) {
        CustomerPriceView customerPriceView = this.f44500a;
        if (customerPriceView != null) {
            customerPriceView.setPriceStr(str, str2);
        }
        return this;
    }

    public GoodsStateBar setPriceLight(boolean z) {
        CustomerPriceView customerPriceView = this.f44500a;
        if (customerPriceView != null) {
            customerPriceView.setPriceLight(z);
        }
        return this;
    }

    public GoodsStateBar setLimitLabel(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f44505f.setVisibility(8);
        } else {
            this.f44505f.setVisibility(0);
            this.f44505f.setText(str);
        }
        return this;
    }

    public GoodsStateBar setActTag(List<ActTagEntity> list) {
        if (list == null || list.size() <= 0) {
            this.f44502c.setVisibility(8);
        } else {
            m33032b();
            for (ActTagEntity next : list) {
                if (!TextUtils.isEmpty(next.richText)) {
                    GoodActTagLayout a = m33031a();
                    if (a == null) {
                        a = new GoodActTagLayout(getContext());
                    }
                    this.f44502c.addView(a);
                    a.setActTag(next);
                    this.f44502c.setVisibility(0);
                }
            }
        }
        return this;
    }

    public GoodsStateBar setActTag(GoodsPurchaseHeaderRvModel.ActTagModel actTagModel, GoodsItemState goodsItemState, View.OnClickListener onClickListener) {
        if (actTagModel == null || TextUtils.isEmpty(actTagModel.content)) {
            this.f44502c.setVisibility(8);
        } else {
            this.f44502c.setVisibility(0);
            m33032b();
            GoodActTagLayout a = m33031a();
            if (a == null) {
                a = new GoodActTagLayout(getContext());
                a.setOnClickListener(onClickListener);
            }
            this.f44502c.addView(a);
            a.setActTag(actTagModel, goodsItemState);
        }
        return this;
    }

    /* renamed from: a */
    private GoodActTagLayout m33031a() {
        if (this.f44504e.size() > 0) {
            return this.f44504e.remove(0);
        }
        return null;
    }

    /* renamed from: b */
    private void m33032b() {
        int childCount = this.f44502c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f44502c.getChildAt(i);
            if (childAt instanceof GoodActTagLayout) {
                this.f44504e.add((GoodActTagLayout) childAt);
            }
        }
        this.f44502c.removeAllViews();
    }

    /* renamed from: c */
    private void m33033c() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_goods_state_bar_v2, this);
        this.f44500a = (CustomerPriceView) findViewById(R.id.customer_custom_goods_price);
        this.f44501b = (TextView) findViewById(R.id.customer_tv_goods_marketing_tips);
        this.f44502c = (NovaFlowLayout) findViewById(R.id.customer_tv_goods_act_tag);
        this.f44503d = (FrameLayout) findViewById(R.id.customer_fl_price_container);
        this.f44505f = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_goods_limit_des);
        this.f44500a.setFontType(IToolsService.FontType.BOLD, IToolsService.FontType.LIGHT);
    }
}
