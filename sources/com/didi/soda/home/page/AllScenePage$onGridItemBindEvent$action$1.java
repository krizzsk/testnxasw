package com.didi.soda.home.page;

import com.didi.soda.customer.base.pages.grid.GridItemModel;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/soda/home/page/AllScenePage$onGridItemBindEvent$action$1", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;", "run", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AllScenePage.kt */
public final class AllScenePage$onGridItemBindEvent$action$1 extends OnceActionUtil.OnceAction {
    final /* synthetic */ GridItemModel $model;
    final /* synthetic */ int $position;
    final /* synthetic */ AllScenePage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllScenePage$onGridItemBindEvent$action$1(AllScenePage allScenePage, GridItemModel gridItemModel, int i, Object[] objArr) {
        super(objArr);
        this.this$0 = allScenePage;
        this.$model = gridItemModel;
        this.$position = i;
    }

    public void run() {
        HomeOmegaHelper.getInstance().trackSceneComponentSw(this.this$0.f45174a, this.this$0.f45175b, this.$model, this.$position, 1);
    }
}
