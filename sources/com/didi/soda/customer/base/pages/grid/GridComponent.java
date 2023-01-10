package com.didi.soda.customer.base.pages.grid;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0003H\u0014J\b\u0010\u0011\u001a\u00020\u0002H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/soda/customer/base/pages/grid/GridComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/customer/base/pages/grid/GridView;", "Lcom/didi/soda/customer/base/pages/grid/ScenePresenter;", "correspond", "Lcom/didi/soda/customer/base/pages/grid/ICorrespond;", "viewGroup", "Landroid/view/ViewGroup;", "(Lcom/didi/soda/customer/base/pages/grid/ICorrespond;Landroid/view/ViewGroup;)V", "updateSceneDataBlock", "Lkotlin/Function0;", "Lcom/didi/soda/customer/base/pages/grid/GridPageData;", "getUpdateSceneDataBlock", "()Lkotlin/jvm/functions/Function0;", "setUpdateSceneDataBlock", "(Lkotlin/jvm/functions/Function0;)V", "onCreatePresenter", "onCreateView", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GridComponent.kt */
public final class GridComponent extends MvpComponent<GridView, ScenePresenter> {

    /* renamed from: a */
    private final ICorrespond f42949a;

    /* renamed from: b */
    private Function0<GridPageData> f42950b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridComponent(ICorrespond iCorrespond, ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.f42949a = iCorrespond;
    }

    public final Function0<GridPageData> getUpdateSceneDataBlock() {
        return this.f42950b;
    }

    public final void setUpdateSceneDataBlock(Function0<GridPageData> function0) {
        this.f42950b = function0;
    }

    /* access modifiers changed from: protected */
    public ScenePresenter onCreatePresenter() {
        ScenePresenter scenePresenter = new ScenePresenter();
        scenePresenter.setUpdateSceneDataBlock(getUpdateSceneDataBlock());
        return scenePresenter;
    }

    /* access modifiers changed from: protected */
    public GridView onCreateView() {
        GridView gridView = new GridView();
        gridView.setCorrespond(this.f42949a);
        return gridView;
    }
}
