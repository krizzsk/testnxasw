package com.didi.soda.home.topgun.manager;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.task.CustomerAsyncTask;
import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.topgun.manager.HomeFeedRefreshRepo;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;

public class HomeFeedTask extends CustomerAsyncTask<HomeEntity> {

    /* renamed from: a */
    private static final String f45491a = "HomeFeedTask";

    /* renamed from: b */
    private CustomerRpcService f45492b = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private HomeFeedParam f45493c;

    public HomeFeedTask(CRpcCallBackWithTraceId cRpcCallBackWithTraceId, HomeFeedParam homeFeedParam) {
        super(cRpcCallBackWithTraceId);
        this.f45493c = homeFeedParam;
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m32588i(f45491a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m32588i(f45491a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        LaunchAppTracker.Companion.endTraceInThread("FeedAddQueue");
        super.onWorkThread();
        LogUtil.m32588i(f45491a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<HomeEntity> execute() {
        AddressEntity addressEntity;
        if (this.f45493c.getScene() == 7) {
            addressEntity = new AddressEntity();
            HomeFeedRefreshRepo.CityInfo cityInfo = ((HomeFeedRefreshRepo) RepoFactory.getRepo(HomeFeedRefreshRepo.class)).getCityInfo();
            if (cityInfo != null) {
                addressEntity.poi = new AddressEntity.PoiEntity();
                addressEntity.poi.lng = cityInfo.mLng;
                addressEntity.poi.lat = cityInfo.mLat;
                addressEntity.poi.cityId = cityInfo.mCityId;
            }
        } else {
            addressEntity = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getCacheAddress();
        }
        return this.f45492b.getHomeFeedV3(this.f45493c.getScene(), addressEntity.poi, addressEntity.getAid(), this.f45493c.getFilterParam(), this.f45493c.getPageIndex(), this.f45493c.getRecId());
    }
}
