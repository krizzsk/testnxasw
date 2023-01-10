package com.didi.component.framework.base;

import android.content.Context;
import com.didi.component.business.secondconf.RideConfImpl;
import com.didi.sdk.app.business.BusinessInitCallback;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.misconfig.p154v2.SecondConfProxy;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.paxadsdk.AdLoaderConfig;
import com.didi.sdk.paxadsdk.GlobalAdManager;
import com.didi.sdk.util.DebugUtils;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "ride", value = {BusinessInitCallback.class})
public class RideInitCallback extends BusinessInitCallback {
    public void onSyncInit(Context context) {
        GlobalAdManager.getInstance().initial(context, new AdLoaderConfig.Builder().showIndicatorOnView(DebugUtils.isDebug()).build());
        SecondConfProxy.getInstance().addSecondConf("ride", RideConfImpl.getInstance());
    }

    public void onSwitchToBusiness(Context context, String str) {
        m12878a();
    }

    /* renamed from: a */
    private void m12878a() {
        RideConfImpl instance = RideConfImpl.getInstance();
        DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
        if (lastLocation != null) {
            instance.getSecConfigFromNet(lastLocation.getLongitude(), lastLocation.getLatitude(), OneConfStore.getInstance().getCityId());
        }
    }
}
