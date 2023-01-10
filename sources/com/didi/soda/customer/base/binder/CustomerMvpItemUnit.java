package com.didi.soda.customer.base.binder;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemUnit;
import com.didi.soda.customer.base.binder.CustomerMvpItemPresenter;
import com.didi.soda.customer.base.binder.CustomerMvpItemView;

public abstract class CustomerMvpItemUnit<V extends CustomerMvpItemView<P, T, VH>, P extends CustomerMvpItemPresenter<V, T, L>, T, VH extends ItemViewHolder<T>, L extends Repo> extends MvpItemUnit<V, P, T, VH> {

    /* renamed from: a */
    private ScopeContext f42918a;

    /* renamed from: b */
    private ComponentLogicUnit f42919b;

    /* renamed from: c */
    private Class<L> f42920c;

    /* access modifiers changed from: protected */
    public void setupPresenter(CustomerMvpItemPresenter customerMvpItemPresenter) {
        customerMvpItemPresenter.mo108162a(this.f42918a);
        customerMvpItemPresenter.mo108163a(this.f42919b);
        customerMvpItemPresenter.mo108164a(this.f42920c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo108167a(ScopeContext scopeContext) {
        this.f42918a = scopeContext;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo108168a(ComponentLogicUnit componentLogicUnit) {
        this.f42919b = componentLogicUnit;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo108169a(Class<L> cls) {
        this.f42920c = cls;
    }
}
