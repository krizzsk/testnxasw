package com.didi.soda.goodsV2.component.purchase;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class GoodsPurchaseComponent extends MvpComponent<GoodsPurchaseView, GoodsPurchasePresenter> {

    /* renamed from: a */
    private GoodsPurchasePresenter f44937a;

    public GoodsPurchaseComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onPageResult(Bundle bundle) {
        GoodsPurchasePresenter goodsPurchasePresenter = this.f44937a;
        if (goodsPurchasePresenter != null) {
            goodsPurchasePresenter.onPageResult(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public GoodsPurchaseView onCreateView() {
        return new GoodsPurchaseView();
    }

    /* access modifiers changed from: protected */
    public GoodsPurchasePresenter onCreatePresenter() {
        GoodsPurchasePresenter goodsPurchasePresenter = new GoodsPurchasePresenter();
        this.f44937a = goodsPurchasePresenter;
        return goodsPurchasePresenter;
    }
}
