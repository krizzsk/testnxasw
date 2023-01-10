package com.didi.map.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloUtils {

    /* renamed from: a */
    private static int f31481a = -1;

    public static boolean getSctxCaseParserOn() {
        IExperiment experiment;
        int i = f31481a;
        if (i >= 0) {
            return i > 0;
        }
        IToggle toggle = Apollo.getToggle("global_map_sctx_case_parser_toggle");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return false;
        }
        int intValue = ((Integer) experiment.getParam("switch_on", 0)).intValue();
        f31481a = intValue;
        if (intValue > 0) {
            return true;
        }
        return false;
    }

    public static boolean oraErrorDoSimulate() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_ora_error_do_simulate_toggle_1");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || ((Integer) experiment.getParam("enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean enableRefreshTraffic() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_refresh_traffic_android_ab");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || ((Integer) experiment.getParam("is_enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }
}
