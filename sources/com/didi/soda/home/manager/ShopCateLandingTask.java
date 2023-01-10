package com.didi.soda.home.manager;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.task.CustomerAsyncTask;
import com.didi.soda.home.topgun.manager.HomeFeedParam;

public class ShopCateLandingTask extends CustomerAsyncTask<HomeEntity> {

    /* renamed from: a */
    private static final String f45167a = "ShopCateLandingTask";

    /* renamed from: d */
    private static final int f45168d = 20;

    /* renamed from: b */
    private CustomerRpcService f45169b = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private HomeFeedParam f45170c;

    public ShopCateLandingTask(CRpcCallBackWithTraceId cRpcCallBackWithTraceId, HomeFeedParam homeFeedParam) {
        super(cRpcCallBackWithTraceId);
        this.f45170c = homeFeedParam;
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m32588i(f45167a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m32588i(f45167a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        super.onWorkThread();
        LogUtil.m32588i(f45167a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<HomeEntity> execute() {
        return this.f45169b.getCateIndex(this.f45170c.getFilterParam(), this.f45170c.getCateId(), this.f45170c.getPageIndex(), 20, this.f45170c.getRecId());
    }
}
