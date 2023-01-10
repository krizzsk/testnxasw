package com.didi.soda.home.topgun.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.performance.ConversionOmegaHelper;
import com.didi.soda.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.home.topgun.manager.HomeFeedRefreshRepo;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerHomeManager;

public class CustomerHomeManager implements ICustomerHomeManager {

    /* renamed from: a */
    private static final String f45476a = "CustomerHomeManager";

    public String getManagerName() {
        return f45476a;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void refreshHomeByAddress(AddressEntity addressEntity, int i) {
        LogUtil.m32584d(f45476a, "start refreshHomeByAddress");
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).setDeliveryAddress(addressEntity, true, i);
        m33806a(5);
    }

    public void locateThenRefreshHome(final int i) {
        if (i == 1) {
            ConversionOmegaHelper.trackStartLoc();
        }
        LaunchAppTracker.Companion.beginTrace("GetLoc");
        LaunchAppTracker.Companion.beginTrace("GetLocWaitMain");
        LocationUtil.getCurrentLocationOnce(new LocationUtil.LocationCallbackWithTrack() {
            public void onLocationError() {
                LogUtil.m32588i(CustomerHomeManager.f45476a, "locateThenRefreshHome onLocationError");
                ((HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class)).abortPreLoad();
                LaunchAppTracker.Companion.clear();
                PerformanceOmegaHelper.getInstance().reset();
                ConversionOmegaHelper.trackLocation((LatLng) null);
                CustomerHomeManager.this.m33806a(i);
            }

            public void onLocationSuccess(LatLng latLng) {
                if (i == 1) {
                    ((HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class)).beginPreLoad();
                }
                LogUtil.m32588i(CustomerHomeManager.f45476a, "locateThenRefreshHome onLocationSuccess");
                ConversionOmegaHelper.trackLocation(latLng);
                PerformanceOmegaHelper.getInstance().trackAppRunDuration(EventConst.Performance.LOCATIONMANAGER);
                LaunchAppTracker.Companion.endTrace("GetLocStart");
                LaunchAppTracker.Companion.endTrace("GetLoc");
                CustomerHomeManager.this.m33806a(i);
            }

            public void onTrack() {
                LaunchAppTracker.Companion.endTrace("GetLocWaitMain");
                LaunchAppTracker.Companion.beginTrace("GetLocStart");
            }
        }, CustomerApolloUtil.getStartGpsTimeout());
    }

    public void refreshHomeByCityInfo(double d, double d2, String str) {
        ((HomeFeedRefreshRepo) RepoFactory.getRepo(HomeFeedRefreshRepo.class)).setCityInfo(HomeFeedRefreshRepo.CityInfo.create(d, d2, str));
        m33806a(7);
    }

    public void subscribeHomeRefreshMessage(ScopeContext scopeContext, Action<Integer> action) {
        ((HomeFeedRefreshRepo) RepoFactory.getRepo(HomeFeedRefreshRepo.class)).subscribe(scopeContext, action);
    }

    public void activityInvalidedRefreshHome() {
        m33806a(5);
    }

    public void subscribeHomeData(ScopeContext scopeContext, Action1<CustomerResource<HomeEntity>> action1) {
        ((HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class)).subscribe(scopeContext, action1);
    }

    public void refreshTab() {
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).refreshTab();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33806a(int i) {
        LogUtil.m32584d(f45476a, "start refreshHome:" + i);
        ((HomeFeedRefreshRepo) RepoFactory.getRepo(HomeFeedRefreshRepo.class)).setValue(Integer.valueOf(i));
    }
}
