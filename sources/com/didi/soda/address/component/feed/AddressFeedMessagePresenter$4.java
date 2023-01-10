package com.didi.soda.address.component.feed;

import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;

class AddressFeedMessagePresenter$4 extends CustomerRpcCallback<HomeAddressEntity> {
    final /* synthetic */ C14191a this$0;

    AddressFeedMessagePresenter$4(C14191a aVar) {
        this.this$0 = aVar;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        this.this$0.m31048b((HomeAddressEntity) null);
        if (sFRpcException.getCode() == -1) {
            this.this$0.m31058j();
        }
    }

    public void onRpcSuccess(HomeAddressEntity homeAddressEntity, long j) {
        this.this$0.m31048b(homeAddressEntity);
        if (homeAddressEntity == null || !AddressUtil.checkAddressValid(homeAddressEntity.address)) {
            this.this$0.m31058j();
        }
    }
}
