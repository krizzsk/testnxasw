package com.didi.entrega.customer.app;

import android.app.Application;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.foundation.sdk.application.ability.NetDetectAbility;

public class NetDetectHelper {

    /* renamed from: a */
    private static final String f21646a = "2003";

    /* renamed from: b */
    private static boolean f21647b = false;

    /* renamed from: c */
    private static NetDetectAbility f21648c;

    public static void init(Application application) {
        boolean isNetDetectEnable = CustomerApolloUtil.isNetDetectEnable();
        f21647b = isNetDetectEnable;
        if (isNetDetectEnable) {
            NetDetectAbility Builder = new NetDetectAbility.Builder().setContext(application).setApolloToggle("sailing_net_detect_monitor_experiments").setDataType("2003").setTripCountry(LocationUtil.getPoiCountryCode()).Builder();
            f21648c = Builder;
            Builder.init();
            f21648c.startDetection(5000);
        }
    }

    public static void resume() {
        NetDetectAbility netDetectAbility;
        if (f21647b && (netDetectAbility = f21648c) != null) {
            netDetectAbility.resumeDetection();
        }
    }

    public static void stop() {
        NetDetectAbility netDetectAbility;
        if (f21647b && (netDetectAbility = f21648c) != null) {
            netDetectAbility.stopDetection();
        }
    }
}
