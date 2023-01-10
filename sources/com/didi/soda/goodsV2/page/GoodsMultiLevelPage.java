package com.didi.soda.goodsV2.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.goodsV2.component.multilevel.GoodsMultiLevelComponent;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"goodsMultiLevelPage"})
public class GoodsMultiLevelPage extends FloatingCustomerPage {

    /* renamed from: a */
    View f45007a;

    /* renamed from: b */
    ViewGroup f45008b;

    /* renamed from: c */
    private GoodsMultiLevelComponent f45009c;

    public GoodsMultiLevelPage() {
        DiRouter.registerHub(RoutePath.GOODS_MULTI_LEVEL, this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f45007a);
        setType(2);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        GoodsMultiLevelComponent goodsMultiLevelComponent = new GoodsMultiLevelComponent(this.f45008b);
        this.f45009c = goodsMultiLevelComponent;
        addComponent(goodsMultiLevelComponent);
    }

    public void onPageResult(Bundle bundle) {
        GoodsMultiLevelComponent goodsMultiLevelComponent;
        super.onPageResult(bundle);
        if (bundle != null && (goodsMultiLevelComponent = this.f45009c) != null) {
            goodsMultiLevelComponent.onPageResult(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_goods_multi_level, (ViewGroup) getView(), false);
        this.f45007a = inflate;
        this.f45008b = (ViewGroup) inflate.findViewById(R.id.customer_fl_goods_multi_level_container);
    }

    /* access modifiers changed from: protected */
    public void updateFloatingConfig() {
        super.updateFloatingConfig();
        getNavBar().setVisible(false);
        setShowBackground(false);
    }
}
