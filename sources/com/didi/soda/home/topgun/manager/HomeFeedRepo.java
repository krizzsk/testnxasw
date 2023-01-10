package com.didi.soda.home.topgun.manager;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;

public class HomeFeedRepo extends Repo<CustomerResource<HomeEntity>> {

    /* renamed from: a */
    private SerialTaskQueue f45487a = new SerialTaskQueue();

    /* renamed from: b */
    private HomePreLoadFeed f45488b;

    /* renamed from: c */
    private boolean f45489c = false;

    /* renamed from: d */
    private boolean f45490d = false;

    public void abortPreLoad() {
        this.f45490d = true;
    }

    public void beginPreLoad() {
        if (this.f45489c) {
            LaunchAppTracker.Companion.log(">>>>> 开启过预加载 <<<<<<");
            return;
        }
        this.f45489c = true;
        if (this.f45490d) {
            LaunchAppTracker.Companion.log(">>>>> 预加载被废弃 <<<<<<");
        } else if (FallbackController.isOpenPreFeed()) {
            LaunchAppTracker.Companion.log(">>>>> 开启FeedIndexV2预加载 <<<<<<");
            if (!AddressUtil.checkAddressValidWithPermission(((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getCacheAddress())) {
                LaunchAppTracker.Companion.log(">>>>> 地址校验不通过，不去请求");
                return;
            }
            LaunchAppTracker.Companion.log(">>>>> 地址校验通过，开始预加载请求");
            HomePreLoadFeed homePreLoadFeed = new HomePreLoadFeed();
            this.f45488b = homePreLoadFeed;
            homePreLoadFeed.preLoadFeedFeed(this.f45487a);
        } else {
            LaunchAppTracker.Companion.log(">>>>> 未开启FeedIndexV2预加载 <<<<<<");
        }
    }

    public void fetchFeed(ScopeContext scopeContext, HomeFeedParam homeFeedParam) {
        HomePreLoadFeed homePreLoadFeed;
        final int pageIndex = homeFeedParam.getPageIndex();
        final int scene = homeFeedParam.getScene();
        LaunchAppTracker.Companion.beginTrace("RequestFeedIndex");
        C148041 r1 = new CRpcCallBackWithTraceId<HomeEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                String str;
                if (sFRpcException.getCode() > 0) {
                    LaunchAppTracker.Companion.endTrace("RequestFeedIndex");
                    PerformanceOmegaHelper.getInstance().trackAppRunDuration(EventConst.Performance.REQUESTFEEDDATACALLBACK);
                } else {
                    LaunchAppTracker.Companion.clear();
                    PerformanceOmegaHelper.getInstance().reset();
                }
                if (sFRpcException.getResult() instanceof CRpcResult) {
                    str = ((CRpcResult) sFRpcException.getResult()).getUrl();
                } else {
                    str = "";
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("url", str);
                }
                bundle.putInt(ParamConst.PAGE_NUMBER, pageIndex);
                bundle.putString(ParamConst.TRACE_ID, "");
                bundle.putInt("scene", scene);
                HomeEntity homeEntity = sFRpcException.getResult() != null ? (HomeEntity) sFRpcException.getResult().getData() : null;
                HomeFeedRepo.this.setValue(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage(), homeEntity, bundle));
                track(sFRpcException.getCode(), sFRpcException.getOriginalMessage(), false, (homeEntity == null || homeEntity.getMFeedEntity() == null || !homeEntity.getMFeedEntity().getMHasMore().booleanValue()) ? false : true);
            }

            public void onRpcSuccess(HomeEntity homeEntity, long j, String str) {
                LaunchAppTracker.Companion.endTrace("RequestFeedIndex");
                PerformanceOmegaHelper.getInstance().trackAppRunDuration(EventConst.Performance.REQUESTFEEDDATACALLBACK);
                Bundle bundle = new Bundle();
                bundle.putInt(ParamConst.PAGE_NUMBER, pageIndex);
                bundle.putString(ParamConst.TRACE_ID, str);
                bundle.putInt("scene", scene);
                HomeFeedRepo.this.setValue(CustomerResource.success(homeEntity, bundle));
                track(0, (String) null, true, (homeEntity == null || homeEntity.getMFeedEntity() == null || !homeEntity.getMFeedEntity().getMHasMore().booleanValue()) ? false : true);
            }

            private void track(int i, String str, boolean z, boolean z2) {
                HomeOmegaHelper.getInstance().trackFeedDataSw(i, str, z, z2);
            }
        };
        if (this.f45490d || (homePreLoadFeed = this.f45488b) == null || !homePreLoadFeed.isBeginPreLoad()) {
            LaunchAppTracker.Companion.beginTrace("FeedAddQueue");
            this.f45487a.append(new HomeFeedTask(r1, homeFeedParam), SerialTaskQueue.AppendMode.ReplaceStrict);
            return;
        }
        this.f45488b.addCallback(r1);
        this.f45488b = null;
    }
}
