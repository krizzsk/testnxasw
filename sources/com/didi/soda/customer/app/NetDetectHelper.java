package com.didi.soda.customer.app;

import android.app.Application;
import com.didi.foundation.sdk.application.ability.NetDetectAbility;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;

public class NetDetectHelper {

    /* renamed from: a */
    private static final String f42907a = "2003";

    /* renamed from: b */
    private static boolean f42908b = false;

    /* renamed from: c */
    private static NetDetectAbility f42909c;

    public static void init(Application application) {
        boolean isNetDetectEnable = CustomerApolloUtil.isNetDetectEnable();
        f42908b = isNetDetectEnable;
        if (isNetDetectEnable) {
            NetDetectAbility Builder = new NetDetectAbility.Builder().setContext(application).setApolloToggle("sailing_net_detect_monitor_experiments").setDataType("2003").setTripCountry(LocationUtil.getPoiCountryCode()).Builder();
            f42909c = Builder;
            Builder.init();
            f42909c.startDetection(5000);
        }
    }

    public static void resume() {
        NetDetectAbility netDetectAbility;
        if (f42908b && (netDetectAbility = f42909c) != null) {
            netDetectAbility.resumeDetection();
        }
    }

    public static void stop() {
        NetDetectAbility netDetectAbility;
        if (f42908b && (netDetectAbility = f42909c) != null) {
            netDetectAbility.stopDetection();
        }
    }
}
