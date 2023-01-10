package com.didi.soda.address.component.feed;

import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.util.LocationUtil;

class AddressFeedMessagePresenter$1 implements LocationUtil.LocationCallback {
    final /* synthetic */ C14191a this$0;

    AddressFeedMessagePresenter$1(C14191a aVar) {
        this.this$0 = aVar;
    }

    public void onLocationError() {
        LogUtil.m32588i("AddressFeedMessagePresenter", "onLocationError");
        this.this$0.m31048b((HomeAddressEntity) null);
        this.this$0.m31058j();
    }

    public void onLocationSuccess(LatLng latLng) {
        LogUtil.m32588i("AddressFeedMessagePresenter", "onLocationSuccess");
        this.this$0.m31056h();
    }
}
