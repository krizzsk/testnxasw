package com.didi.foundation.sdk.swarm;

import com.didi.foundation.sdk.location.BaseLocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;

class LocationServiceImpl$1 extends BaseLocationListener {
    final /* synthetic */ C8981d this$0;

    LocationServiceImpl$1(C8981d dVar) {
        this.this$0 = dVar;
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        this.this$0.m19104a(dIDILocation);
    }
}
