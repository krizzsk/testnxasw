package com.didi.soda.customer.base.binder;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemPresenter;
import com.didi.soda.customer.base.binder.CustomerMvpItemView;

public class CustomerMvpItemPresenter<V extends CustomerMvpItemView, T, L extends Repo> extends MvpItemPresenter<V, T> {

    /* renamed from: a */
    private ScopeContext f42915a;

    /* renamed from: b */
    private ComponentLogicUnit f42916b;

    /* renamed from: c */
    private Class<L> f42917c;

    public final L getItemLogic() {
        ComponentLogicUnit componentLogicUnit = this.f42916b;
        if (componentLogicUnit != null) {
            return componentLogicUnit.getLogic(this.f42917c);
        }
        throw new IllegalStateException("If you call getItemLogic in Binder, componentLogicUnit cannot be null!");
    }

    public final ScopeContext getScopeContext() {
        return this.f42915a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo108162a(ScopeContext scopeContext) {
        this.f42915a = scopeContext;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo108163a(ComponentLogicUnit componentLogicUnit) {
        this.f42916b = componentLogicUnit;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo108164a(Class<L> cls) {
        this.f42917c = cls;
    }
}
