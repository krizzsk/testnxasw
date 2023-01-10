package com.didi.addressnew.view.enhance;

import android.view.View;
import com.sdk.poibase.model.RpcPoi;

public class AddressItemEnhancerImpl implements IAddressItemEnhancer {

    /* renamed from: a */
    private IAddressItemEnhancer f9426a;

    public AddressItemEnhancerImpl(IAddressItemEnhancer iAddressItemEnhancer) {
        this.f9426a = iAddressItemEnhancer;
    }

    public void enhance(View view, int i, RpcPoi rpcPoi) {
        IAddressItemEnhancer iAddressItemEnhancer = this.f9426a;
        if (iAddressItemEnhancer != null) {
            iAddressItemEnhancer.enhance(view, i, rpcPoi);
        }
    }
}
