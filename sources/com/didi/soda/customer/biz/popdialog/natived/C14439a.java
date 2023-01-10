package com.didi.soda.customer.biz.popdialog.natived;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.biz.popdialog.PromoCodeStorage;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.rpc.entity.NAPopUpParamsEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.repo.CustomerResource;

/* renamed from: com.didi.soda.customer.biz.popdialog.natived.a */
/* compiled from: NAPopDialogRepo */
class C14439a extends Repo<CustomerResource<NAPopDialogEntity>> {

    /* renamed from: a */
    private CustomerRpcService f43085a = CustomerRpcManagerProxy.get();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108533a(NAPopUpParamsEntity nAPopUpParamsEntity, CustomerRpcCallback<NAPopDialogEntity> customerRpcCallback) {
        String str = ((PromoCodeStorage) SingletonFactory.get(PromoCodeStorage.class)).getData().promoCode;
        if (CustomerApolloUtil.isSkipPromoCode()) {
            this.f43085a.fetchPopDialog(nAPopUpParamsEntity.position, GsonUtil.toJson(nAPopUpParamsEntity.popUpExtEntity), customerRpcCallback);
        } else {
            this.f43085a.fetchPopDialog(nAPopUpParamsEntity.position, GsonUtil.toJson(nAPopUpParamsEntity.popUpExtEntity), str, customerRpcCallback);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108534a(String str, CustomerRpcCallback<Object> customerRpcCallback) {
        this.f43085a.reportPopDialogExposure(str, customerRpcCallback);
    }
}
