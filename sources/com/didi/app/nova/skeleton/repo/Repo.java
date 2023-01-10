package com.didi.app.nova.skeleton.repo;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.Service;
import com.didi.app.nova.skeleton.repo.LiveData;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.soda.nova.skeleton.dsl.DslRepo;
import com.didichuxing.foundation.rpc.Rpc;

public abstract class Repo<T> implements Service, DslRepo {

    /* renamed from: a */
    private LiveData<T> f10346a = new LiveData<>();

    /* access modifiers changed from: protected */
    public void onCreate() {
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public LiveData<T> getLiveData() {
        return this.f10346a;
    }

    public void setValue(T t) {
        this.f10346a.setValue(t);
    }

    public T getValue() {
        return this.f10346a.getValue();
    }

    public void autoRelease(ScopeContext scopeContext, Cancelable cancelable) {
        scopeContext.getLiveHandler().bind(cancelable);
    }

    public void autoRelease(ScopeContext scopeContext, Rpc rpc) {
        autoRelease(scopeContext, (Cancelable) new RpcCancelable(rpc));
    }

    public LiveData.SubscribeFilter from() {
        return this.f10346a.from();
    }

    public Subscription subscribe(ScopeContext scopeContext, Action<T> action) {
        return from().subscribe(scopeContext, action);
    }

    static class RpcCancelable implements Cancelable {
        Rpc rpc;

        RpcCancelable(Rpc rpc2) {
            this.rpc = rpc2;
        }

        public void cancel() {
            this.rpc.cancel();
        }
    }
}
