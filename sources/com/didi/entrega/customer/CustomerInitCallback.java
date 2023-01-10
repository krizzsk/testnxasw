package com.didi.entrega.customer;

import android.app.Application;
import android.content.Context;
import com.didi.entrega.customer.app.CustomerActivityManager;
import com.didi.entrega.customer.foundation.p113im.ImMessageHelper;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.tracker.error.OmegaErrorHandler;
import com.didi.entrega.customer.service.CustomerServiceHelper;
import com.didi.entrega.customer.service.CustomerServiceIRegister;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.timemachine.CustomerTimeMachineConfig;
import com.didi.entrega.customer.timemachine.TimeMachineEngine;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.sdk.app.business.BusinessInitCallback;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Map;

@ServiceProvider(alias = "sodaEntrega", value = {BusinessInitCallback.class})
public class CustomerInitCallback extends BusinessInitCallback implements CustomerServiceIRegister {
    public void onSyncInit(Context context) {
        CustomerServiceManager.init(this);
        TimeMachineEngine.getInstance().init(new CustomerTimeMachineConfig());
        CustomerManagerLoader.init();
        CustomerActivityManager.getInstance().init((Application) context.getApplicationContext());
        ImMessageHelper.getInstance().setRiderCommonWords(context);
        LocationService.getInstance().startLocation(context);
        ErrorTracker.init(new OmegaErrorHandler());
    }

    public Map<Class, Class> getRegisterService() {
        return CustomerServiceHelper.getRegisterService();
    }
}
