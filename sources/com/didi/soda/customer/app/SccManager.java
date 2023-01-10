package com.didi.soda.customer.app;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.IdentityEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;

public class SccManager {

    /* renamed from: a */
    private static final String f42910a = "SccManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f42911b;

    public String getScc() {
        return this.f42911b;
    }

    public void initData() {
        m32071a();
        CustomerRpcManagerProxy.get().getIdentity(new CustomerRpcCallback<IdentityEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                LogUtil.m32588i(SccManager.f42910a, "fetch params error, code = " + sFRpcException.getCode() + ", msg = " + sFRpcException.getOriginalMessage());
            }

            public void onRpcSuccess(IdentityEntity identityEntity, long j) {
                if (identityEntity != null) {
                    String unused = SccManager.this.f42911b = identityEntity.scc;
                }
            }
        });
    }

    /* renamed from: a */
    private void m32071a() {
        this.f42911b = null;
    }
}
