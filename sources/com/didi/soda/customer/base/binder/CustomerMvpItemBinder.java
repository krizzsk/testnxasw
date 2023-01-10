package com.didi.soda.customer.base.binder;

import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.RvLifecycleObservable;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.RvLifecycleObserver;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.app.ComponentLogicProvider;
import com.didi.soda.customer.app.ScopeContextProvider;
import com.didi.soda.customer.base.binder.CustomerMvpItemUnit;

public abstract class CustomerMvpItemBinder<T, VH extends ItemViewHolder<T>, U extends CustomerMvpItemUnit, L extends Repo> extends MvpItemBinder<T, VH, U> implements ComponentLogicProvider, ScopeContextProvider {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RvLifecycleObserver f42914a;

    public abstract Class<L> bindItemLogicType();

    public CustomerMvpItemBinder() {
        m32077a();
    }

    public CustomerMvpItemBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    /* access modifiers changed from: protected */
    public void setupItemUnit(U u) {
        u.mo108167a(provideScopeContext());
        u.mo108168a(provideComponentLogicUnit());
        u.mo108169a(bindItemLogicType());
    }

    /* access modifiers changed from: protected */
    public RvLifecycleObservable onCreateRvContainerLifecycle() {
        return new RvLifecycleObservable() {
            public void subscribe(RvLifecycleObserver rvLifecycleObserver) {
                RvLifecycleObserver unused = CustomerMvpItemBinder.this.f42914a = rvLifecycleObserver;
            }
        };
    }

    /* renamed from: a */
    private void m32077a() {
        provideScopeContext().addObserver(new IScopeLifecycle() {
            public void onCreate(ILive iLive) {
            }

            public void onPause(ILive iLive) {
            }

            public void onResume(ILive iLive) {
            }

            public void onDestroy(ILive iLive) {
                if (CustomerMvpItemBinder.this.f42914a != null) {
                    CustomerMvpItemBinder.this.f42914a.onDestroy();
                }
                RvLifecycleObserver unused = CustomerMvpItemBinder.this.f42914a = null;
            }

            public void onStart(ILive iLive) {
                if (CustomerMvpItemBinder.this.f42914a != null) {
                    CustomerMvpItemBinder.this.f42914a.onAttach();
                }
            }

            public void onStop(ILive iLive) {
                if (CustomerMvpItemBinder.this.f42914a != null) {
                    CustomerMvpItemBinder.this.f42914a.onDetach();
                }
            }
        });
    }
}
