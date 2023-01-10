package com.didi.soda.business.manager;

import com.didi.soda.business.component.search.helper.SearchMenuPageInfo;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.BusinessSearchResultEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.task.CustomerAsyncTask;

public class BusinessSearchMenuTask extends CustomerAsyncTask<BusinessSearchResultEntity> {

    /* renamed from: a */
    private static final String f42312a = "BusinessSearchMenuTask";

    /* renamed from: b */
    private CustomerRpcService f42313b = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private SearchMenuPageInfo f42314c;

    public BusinessSearchMenuTask(CustomerRpcCallback customerRpcCallback, SearchMenuPageInfo searchMenuPageInfo) {
        super(customerRpcCallback);
        this.f42314c = searchMenuPageInfo;
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m32588i(f42312a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m32588i(f42312a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        super.onWorkThread();
        LogUtil.m32588i(f42312a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<BusinessSearchResultEntity> execute() {
        return this.f42313b.getShopSearchMenu(this.f42314c.getShopId(), this.f42314c.mKeyWord, this.f42314c.mKeyWordType, this.f42314c.mRecId, this.f42314c.mTraceCnt);
    }
}
