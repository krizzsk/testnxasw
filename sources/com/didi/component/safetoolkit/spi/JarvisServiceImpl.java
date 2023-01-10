package com.didi.component.safetoolkit.spi;

import android.content.Context;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.sharetrip.CommonTripShareManager;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.api.requests.SafeToolkitBffRequest;
import com.didi.component.safetoolkit.event.UpdateJarvisEvent;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.safetoolkit.api.ISfJarvisService;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.gson.JsonObject;
import java.io.IOException;

@ServiceProvider(alias = "ride", value = {ISfJarvisService.class})
public class JarvisServiceImpl implements ISfJarvisService {

    /* renamed from: a */
    private CommonTripShareManager f17300a;

    /* renamed from: b */
    private GGKDrawer f17301b;

    public void startSocialShare(boolean z) {
        BaseEventPublisher.getPublisher().publish("event_Share_before_accepted", Boolean.valueOf(z));
    }

    public void monitorAbnormalClick(Context context, String str) {
        SafeToolkitBffRequest.reportUserState(context, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS);
            }
        }, str);
    }

    public void requestJarvisStatus(int i) {
        UpdateJarvisEvent updateJarvisEvent = new UpdateJarvisEvent();
        updateJarvisEvent.openManualRecord = i;
        BaseEventPublisher.getPublisher().publish("event_update_jarvis", updateJarvisEvent);
    }

    public void nullShieldClick(Context context) {
        if (!OneLoginFacade.getStore().isLoginNow()) {
            OneLoginFacade.getAction().go2Login(context);
        }
    }
}
