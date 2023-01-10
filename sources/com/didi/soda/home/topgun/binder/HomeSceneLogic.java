package com.didi.soda.home.topgun.binder;

import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.customer.base.pages.grid.GridItemModel;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.home.topgun.binder.model.SceneComponentModel;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/HomeSceneLogic;", "Lcom/didi/soda/customer/base/binder/logic/BinderLogic;", "Lcom/didi/soda/customer/base/binder/logic/EmptyLogicRepo;", "()V", "bindLogicRepoType", "Ljava/lang/Class;", "onSceneItemBind", "", "model", "Lcom/didi/soda/home/topgun/binder/model/SceneComponentModel;", "itemModel", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "itemPosition", "", "onSceneItemClick", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeSceneBinder.kt */
public final class HomeSceneLogic extends BinderLogic<EmptyLogicRepo> {
    public Class<EmptyLogicRepo> bindLogicRepoType() {
        return EmptyLogicRepo.class;
    }

    public final void onSceneItemBind(SceneComponentModel sceneComponentModel, GridItemModel gridItemModel, int i) {
        Intrinsics.checkNotNullParameter(sceneComponentModel, "model");
        Intrinsics.checkNotNullParameter(gridItemModel, "itemModel");
        HomeOmegaHelper.getInstance().trackSceneComponentSw(String.valueOf(ExtentionsKt.orZero(Integer.valueOf(sceneComponentModel.mIndexInModule))), String.valueOf(ExtentionsKt.orZero(Integer.valueOf(sceneComponentModel.mAbsoluteIndex))), gridItemModel, i, 0);
    }

    public final void onSceneItemClick(SceneComponentModel sceneComponentModel, GridItemModel gridItemModel, int i) {
        Intrinsics.checkNotNullParameter(sceneComponentModel, "model");
        Intrinsics.checkNotNullParameter(gridItemModel, "itemModel");
        SceneComponentModel.Companion.performClickFromScene(gridItemModel.getUrl(), Integer.valueOf(gridItemModel.getType()), gridItemModel.getTitle(), sceneComponentModel.mRecId, new HomeSceneLogic$onSceneItemClick$1(gridItemModel, sceneComponentModel));
        HomeOmegaHelper.getInstance().trackSceneComponentCk(String.valueOf(ExtentionsKt.orZero(Integer.valueOf(sceneComponentModel.mIndexInModule))), String.valueOf(ExtentionsKt.orZero(Integer.valueOf(sceneComponentModel.mAbsoluteIndex))), gridItemModel, i, 0);
    }
}
