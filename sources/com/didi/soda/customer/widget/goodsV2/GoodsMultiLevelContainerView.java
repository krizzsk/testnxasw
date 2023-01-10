package com.didi.soda.customer.widget.goodsV2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.taxis99.R;
import java.util.List;

public class GoodsMultiLevelContainerView extends LinearLayout {

    /* renamed from: a */
    private LinearLayout f44484a;

    public GoodsMultiLevelContainerView(Context context) {
        super(context);
        m33017a(context);
    }

    public GoodsMultiLevelContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33017a(context);
    }

    /* renamed from: a */
    private void m33017a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.customer_widget_goods_multi_level_container_layout_v2, this);
        this.f44484a = (LinearLayout) findViewById(R.id.customer_multi_subitem_desc_layout);
    }

    public GoodsMultiLevelContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33017a(context);
    }

    public void setDate(List<SelectSubItemState.MultiSubItemDesc> list) {
        this.f44484a.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            SelectSubItemState.MultiSubItemDesc multiSubItemDesc = list.get(i);
            if (multiSubItemDesc != null) {
                this.f44484a.addView(m33016a(multiSubItemDesc));
            }
        }
    }

    /* renamed from: a */
    private View m33016a(SelectSubItemState.MultiSubItemDesc multiSubItemDesc) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_multi_level_item_view_v2, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.customer_tv_all_subitem_content);
        TextView textView2 = (TextView) inflate.findViewById(R.id.customer_tv_all_subitem_price);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(textView, IToolsService.FontType.NORMAL);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(textView2, IToolsService.FontType.BOLD);
        textView.setText(multiSubItemDesc.desc);
        if (multiSubItemDesc.price <= 0) {
            textView2.setVisibility(4);
        } else {
            textView2.setVisibility(0);
            textView2.setText("+" + LocalizationUtils.CurrencyUtils.getCurrency((long) multiSubItemDesc.price, multiSubItemDesc.currency));
        }
        return inflate;
    }
}
