package com.didi.soda.customer.base.pages.grid;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.soda.customer.base.pages.grid.Contract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/soda/customer/base/pages/grid/ScenePresenter;", "Lcom/didi/soda/customer/base/pages/grid/Contract$AbsScenePresenter;", "()V", "listManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "updateSceneDataBlock", "Lkotlin/Function0;", "Lcom/didi/soda/customer/base/pages/grid/GridPageData;", "getUpdateSceneDataBlock", "()Lkotlin/jvm/functions/Function0;", "setUpdateSceneDataBlock", "(Lkotlin/jvm/functions/Function0;)V", "initDataManagers", "", "onCreate", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GridPresenter.kt */
public final class ScenePresenter extends Contract.AbsScenePresenter {

    /* renamed from: a */
    private ChildDataListManager<RecyclerModel> f42964a;

    /* renamed from: b */
    private Function0<GridPageData> f42965b;

    public final Function0<GridPageData> getUpdateSceneDataBlock() {
        return this.f42965b;
    }

    public final void setUpdateSceneDataBlock(Function0<GridPageData> function0) {
        this.f42965b = function0;
    }

    public void onCreate() {
        ChildDataListManager<RecyclerModel> childDataListManager;
        super.onCreate();
        Function0<GridPageData> function0 = this.f42965b;
        GridPageData invoke = function0 == null ? null : function0.invoke();
        if (invoke != null && (!invoke.getItems().isEmpty()) && (childDataListManager = this.f42964a) != null) {
            childDataListManager.addAll(invoke.getItems());
        }
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f42964a == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f42964a = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }
}
