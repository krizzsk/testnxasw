package com.didi.soda.customer.biz.popdialog;

import com.didi.app.nova.skeleton.repo.LiveData;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.repo.CustomerResource;

public class HomePopConfigRepo extends Repo<CustomerResource<Object>> {

    /* renamed from: a */
    private LiveData<Boolean> f43067a = new LiveData<>();

    HomePopConfigRepo() {
        m32189a();
    }

    public void setLoginFetchHomePopFlag(boolean z) {
        this.f43067a.setValue(Boolean.valueOf(z));
    }

    public boolean isLoginFetchHomePop() {
        return this.f43067a.getValue().booleanValue();
    }

    /* renamed from: a */
    private void m32189a() {
        this.f43067a.setValue(true);
    }
}
