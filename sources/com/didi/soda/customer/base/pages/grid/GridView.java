package com.didi.soda.customer.base.pages.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaGridLayoutManager;
import com.didi.soda.customer.base.pages.grid.Contract;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/soda/customer/base/pages/grid/GridView;", "Lcom/didi/soda/customer/base/pages/grid/Contract$AbsSceneView;", "()V", "correspond", "Lcom/didi/soda/customer/base/pages/grid/ICorrespond;", "getCorrespond", "()Lcom/didi/soda/customer/base/pages/grid/ICorrespond;", "setCorrespond", "(Lcom/didi/soda/customer/base/pages/grid/ICorrespond;)V", "recyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "generateNovaRecyclerView", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "", "onCreate", "onGridItemBindEvent", "model", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "position", "", "onGridItemClickEvent", "setupNovaRecyclerView", "novaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GridView.kt */
public final class GridView extends Contract.AbsSceneView {

    /* renamed from: a */
    private NovaRecyclerView f42962a;

    /* renamed from: b */
    private ICorrespond f42963b;

    public final ICorrespond getCorrespond() {
        return this.f42963b;
    }

    public final void setCorrespond(ICorrespond iCorrespond) {
        this.f42963b = iCorrespond;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        this.f42962a = new NovaRecyclerView(getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        NovaRecyclerView novaRecyclerView = this.f42962a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            novaRecyclerView = null;
        }
        viewGroup.addView(novaRecyclerView, layoutParams);
        return viewGroup;
    }

    public void onCreate() {
        super.onCreate();
        NovaRecyclerView novaRecyclerView = this.f42962a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            novaRecyclerView = null;
        }
        novaRecyclerView.setLayoutManager(new NovaGridLayoutManager(getContext(), 1, false));
    }

    /* access modifiers changed from: protected */
    public NovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f42962a;
        if (novaRecyclerView != null) {
            return novaRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public void setupNovaRecyclerView(INovaRecyclerView iNovaRecyclerView) {
        super.setupNovaRecyclerView(iNovaRecyclerView);
        if (iNovaRecyclerView != null) {
            iNovaRecyclerView.setItemDecorationEnable(true);
        }
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        C14404a aVar = new C14404a();
        aVar.setBoundMarginPx(CustomerExtentionKt.getPx(R.dimen.rf_dimen_22));
        registerBinder(new GridPageItemBinder(new GridView$initItemBinders$1(this), new GridView$initItemBinders$2(this), aVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32114a(GridItemModel gridItemModel, int i) {
        LogUtil.m32584d("TAG", ">>>>> bind position = " + i + ' ');
        ICorrespond iCorrespond = this.f42963b;
        if (iCorrespond != null) {
            iCorrespond.onGridItemBindEvent(gridItemModel, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m32115b(GridItemModel gridItemModel, int i) {
        LogUtil.m32584d("TAG", Intrinsics.stringPlus(">>>>> click position = ", Integer.valueOf(i)));
        ICorrespond iCorrespond = this.f42963b;
        if (iCorrespond != null) {
            iCorrespond.onGridItemClickEvent(gridItemModel, i);
        }
    }
}
