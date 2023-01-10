package com.didi.soda.home.component.category.landing;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.datasource.page.UpdateUtils;
import com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, mo148868d2 = {"com/didi/soda/home/component/category/landing/ShopCategoryLandingPresenter$isFilterNone$1", "Lcom/didi/soda/datasource/page/UpdateUtils$DiffCallback;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "isTarget", "", "pos", "", "oldTarget", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ShopCategoryLandingPresenter.kt */
public final class ShopCategoryLandingPresenter$isFilterNone$1 implements UpdateUtils.DiffCallback<RecyclerModel> {
    ShopCategoryLandingPresenter$isFilterNone$1() {
    }

    public boolean isTarget(int i, RecyclerModel recyclerModel) {
        return recyclerModel instanceof HomeNoResultRvModel;
    }
}
