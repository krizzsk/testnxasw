package com.didi.soda.globalcart.view;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.globalcart.view.Style;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, mo148868d2 = {"Lcom/didi/soda/globalcart/view/OldStyle;", "Lcom/didi/soda/globalcart/view/Style;", "()V", "dishCollapseCount", "", "getDishCollapseCount", "()I", "getResId", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.globalcart.view.b */
/* compiled from: BillItemsInfoItemView.kt */
final class C14679b implements Style {

    /* renamed from: a */
    private final int f44915a = 2;

    /* renamed from: b */
    public int mo112899b() {
        return R.layout.customer_widget_cart_items_container_view;
    }

    /* renamed from: a */
    public void mo112897a(ComponentModel componentModel, ScopeContext scopeContext) {
        Style.DefaultImpls.setData(this, componentModel, scopeContext);
    }

    /* renamed from: a */
    public void mo112898a(BillItemsInfoItemView billItemsInfoItemView) {
        Style.DefaultImpls.initView(this, billItemsInfoItemView);
    }

    /* renamed from: a */
    public int mo112896a() {
        return this.f44915a;
    }
}
