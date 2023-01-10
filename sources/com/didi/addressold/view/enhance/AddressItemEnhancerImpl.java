package com.didi.addressold.view.enhance;

import android.view.View;
import com.sdk.poibase.model.RpcPoi;

public class AddressItemEnhancerImpl implements IAddressItemEnhancer {

    /* renamed from: a */
    private IAddressItemEnhancer f9806a;

    public AddressItemEnhancerImpl(IAddressItemEnhancer iAddressItemEnhancer) {
        this.f9806a = iAddressItemEnhancer;
    }

    public void enhance(View view, int i, RpcPoi rpcPoi) {
        IAddressItemEnhancer iAddressItemEnhancer = this.f9806a;
        if (iAddressItemEnhancer != null) {
            iAddressItemEnhancer.enhance(view, i, rpcPoi);
        }
    }
}
