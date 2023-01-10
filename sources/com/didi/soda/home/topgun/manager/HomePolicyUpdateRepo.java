package com.didi.soda.home.topgun.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.LiveData;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.repo.CustomerResource;

public class HomePolicyUpdateRepo extends Repo<CustomerResource<Long>> {
    public static long DEFAULT_VALUE;

    /* renamed from: a */
    private LiveData<Long> f45503a = new LiveData<>();

    public void setPolicyUpdateConfirmTime(Long l) {
        this.f45503a.setValue(l);
    }

    public Subscription subscribePolicyUpdateConfirmTime(ScopeContext scopeContext, Action<Long> action) {
        return this.f45503a.from().shutViscidityNotice().subscribe(scopeContext, action);
    }
}
