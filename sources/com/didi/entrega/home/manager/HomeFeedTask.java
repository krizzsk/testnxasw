package com.didi.entrega.home.manager;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcService;
import com.didi.entrega.customer.foundation.rpc.net.CRpcResult;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.task.CustomerAsyncTask;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;

public class HomeFeedTask extends CustomerAsyncTask<HomeFeedEntity> {

    /* renamed from: a */
    private static final String f22560a = "HomeFeedTask";

    /* renamed from: b */
    private final CustomerRpcService f22561b = CustomerRpcManagerProxy.get();

    public HomeFeedTask(CustomerRpcCallback customerRpcCallback) {
        super(customerRpcCallback);
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m18185i(f22560a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m18185i(f22560a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        super.onWorkThread();
        LogUtil.m18185i(f22560a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<HomeFeedEntity> execute() {
        return this.f22561b.feedIndex();
    }
}
