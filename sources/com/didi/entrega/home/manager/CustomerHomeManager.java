package com.didi.entrega.home.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;
import com.didi.entrega.manager.base.ICustomerHomeManager;

public class CustomerHomeManager implements ICustomerHomeManager {

    /* renamed from: a */
    private static final String f22556a = "CustomerHomeManager";

    /* renamed from: b */
    private HomeFeedRepo f22557b;

    public String getManagerName() {
        return f22556a;
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onCreate() {
        this.f22557b = (HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class);
    }

    public void locateThenRefreshHome(final int i) {
        LocationUtil.getCurrentLocationOnce(new LocationUtil.LocationCallback() {
            public void onLocationError() {
                CustomerHomeManager.this.m18560a(i);
            }

            public void onLocationSuccess(LatLng latLng) {
                LogUtil.m18185i(CustomerHomeManager.f22556a, "locateThenRefreshHome onLocationSuccess");
                CustomerHomeManager.this.m18560a(i);
            }
        }, CustomerApolloUtil.getStartGpsTimeout());
    }

    public void refreshHomeByCityInfo() {
        m18560a(7);
    }

    public void fetchFeedIndex(ScopeContext scopeContext, int i) {
        this.f22557b.fetchFeedIndex(scopeContext, i);
    }

    public void subscribeFeedIndex(ScopeContext scopeContext, Action1<CustomerResource<HomeFeedEntity>> action1) {
        this.f22557b.from().shutViscidityNotice().subscribe(scopeContext, action1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18560a(int i) {
        LogUtil.m18181d(f22556a, "start refreshHome:" + i);
        HomeFeedRefreshRepo.Companion.setStatus(i);
    }
}
