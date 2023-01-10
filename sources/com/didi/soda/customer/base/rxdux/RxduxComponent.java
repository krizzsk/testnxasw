package com.didi.soda.customer.base.rxdux;

import android.view.ViewGroup;
import com.appsflyer.internal.referrer.Payload;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.ScopeContextBase;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.jadux.Reducer;
import com.didi.soda.jadux.Store;
import p218io.reactivex.disposables.Disposable;
import p218io.reactivex.functions.Consumer;

public abstract class RxduxComponent<V extends IView, P extends IPresenter, StateT> extends MvpComponent<V, P> {

    /* renamed from: a */
    private Disposable f42967a = null;

    /* renamed from: b */
    private Store<StateT> f42968b = null;

    /* access modifiers changed from: protected */
    public abstract Reducer<StateT> createReducer();

    /* access modifiers changed from: protected */
    public abstract StateT initState();

    public RxduxComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public ScopeContextBase onCreateScopeContext(ScopeContext scopeContext) {
        return super.onCreateScopeContext(scopeContext);
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        super.onAttach();
        m32117c();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.f42967a;
        if (disposable != null && !disposable.isDisposed()) {
            this.f42967a.dispose();
        }
    }

    /* renamed from: c */
    private void m32117c() {
        this.f42968b = new Store().createStore(createReducer(), initState());
        ScopeContext scopeContext = getScopeContext();
        scopeContext.attach(getScopeContext().alias() + Payload.TYPE_STORE, this.f42968b);
        this.f42967a = this.f42968b.subscribe(new Consumer<StateT>() {
            public void accept(StateT statet) {
                if (RxduxComponent.this.getPresenter() instanceof RxduxPresenter) {
                    ((RxduxPresenter) RxduxComponent.this.getPresenter()).updateState(statet);
                }
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th) {
                th.printStackTrace();
            }
        });
    }
}
