package com.didi.entrega.customer.base.binder;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemPresenter;
import com.didi.entrega.customer.base.binder.CustomerMvpItemView;

public class CustomerMvpItemPresenter<V extends CustomerMvpItemView, T, L extends Repo> extends MvpItemPresenter<V, T> {

    /* renamed from: a */
    private ScopeContext f21652a;

    /* renamed from: b */
    private ComponentLogicUnit f21653b;

    /* renamed from: c */
    private Class<L> f21654c;

    public final L getItemLogic() {
        ComponentLogicUnit componentLogicUnit = this.f21653b;
        if (componentLogicUnit != null) {
            return componentLogicUnit.getLogic(this.f21654c);
        }
        throw new IllegalStateException("If you call getItemLogic in Binder, componentLogicUnit cannot be null!");
    }

    public final ScopeContext getScopeContext() {
        return this.f21652a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo64581a(ScopeContext scopeContext) {
        this.f21652a = scopeContext;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo64582a(ComponentLogicUnit componentLogicUnit) {
        this.f21653b = componentLogicUnit;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo64583a(Class<L> cls) {
        this.f21654c = cls;
    }
}
