package com.didi.payment.base.utils;

import android.content.Context;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class RoamingUtil {

    /* renamed from: a */
    private static final String f32474a = "app_roaming_wallet_url_toggle";

    public static String getRomaingHost(Context context) {
        if (AreaUtil.isTripInChina(context)) {
            return "";
        }
        IToggle toggle = Apollo.getToggle(f32474a);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("host", "");
        }
        return "";
    }
}
