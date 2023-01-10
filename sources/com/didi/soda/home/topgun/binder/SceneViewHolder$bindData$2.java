package com.didi.soda.home.topgun.binder;

import com.didi.soda.customer.base.pages.grid.GridItemModel;
import com.didi.soda.home.topgun.binder.model.SceneComponentModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, mo148868d2 = {"<anonymous>", "", "itemModel", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "itemPosition", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeSceneBinder.kt */
final class SceneViewHolder$bindData$2 extends Lambda implements Function2<GridItemModel, Integer, Unit> {
    final /* synthetic */ SceneViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SceneViewHolder$bindData$2(SceneViewHolder sceneViewHolder) {
        super(2);
        this.this$0 = sceneViewHolder;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((GridItemModel) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(GridItemModel gridItemModel, int i) {
        Intrinsics.checkNotNullParameter(gridItemModel, "itemModel");
        HomeSceneLogic access$getLogic$p = this.this$0.f45255a;
        Object item = this.this$0.getItem();
        Intrinsics.checkNotNullExpressionValue(item, "item");
        access$getLogic$p.onSceneItemBind((SceneComponentModel) item, gridItemModel, i);
    }
}
