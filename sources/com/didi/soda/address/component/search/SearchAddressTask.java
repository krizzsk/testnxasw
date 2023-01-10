package com.didi.soda.address.component.search;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.address.SearchPoiEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.task.CustomerAsyncTask;

public class SearchAddressTask extends CustomerAsyncTask<SearchPoiEntity> {

    /* renamed from: a */
    private static final String f41400a = "SearchAddressTask";

    /* renamed from: b */
    private CustomerRpcService f41401b = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private String f41402c;

    public SearchAddressTask(CustomerRpcCallback customerRpcCallback, String str) {
        super(customerRpcCallback);
        this.f41402c = str;
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m32588i(f41400a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m32588i(f41400a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        super.onWorkThread();
        LogUtil.m32588i(f41400a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<SearchPoiEntity> execute() {
        return this.f41401b.getTextSearch(this.f41402c);
    }
}
