package com.didi.entrega.customer.base.binder;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemUnit;
import com.didi.entrega.customer.base.binder.CustomerMvpItemPresenter;
import com.didi.entrega.customer.base.binder.CustomerMvpItemView;

public abstract class CustomerMvpItemUnit<V extends CustomerMvpItemView<P, T, VH>, P extends CustomerMvpItemPresenter<V, T, L>, T, VH extends ItemViewHolder<T>, L extends Repo> extends MvpItemUnit<V, P, T, VH> {

    /* renamed from: a */
    private ScopeContext f21655a;

    /* renamed from: b */
    private ComponentLogicUnit f21656b;

    /* renamed from: c */
    private Class<L> f21657c;

    /* access modifiers changed from: protected */
    public void setupPresenter(CustomerMvpItemPresenter customerMvpItemPresenter) {
        customerMvpItemPresenter.mo64581a(this.f21655a);
        customerMvpItemPresenter.mo64582a(this.f21656b);
        customerMvpItemPresenter.mo64583a(this.f21657c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo64586a(ScopeContext scopeContext) {
        this.f21655a = scopeContext;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo64587a(ComponentLogicUnit componentLogicUnit) {
        this.f21656b = componentLogicUnit;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo64588a(Class<L> cls) {
        this.f21657c = cls;
    }
}
