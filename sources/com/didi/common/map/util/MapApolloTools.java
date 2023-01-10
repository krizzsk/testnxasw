package com.didi.common.map.util;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class MapApolloTools {

    /* renamed from: a */
    private static final String f12786a = "MapApolloTools";

    public static boolean isEnableHawaiiDynamicLayer() {
        return false;
    }

    public static boolean isDiDiMapEnabled() {
        IExperiment experiment;
        IExperiment experiment2;
        IExperiment experiment3;
        try {
            String a = m10777a();
            IToggle iToggle = null;
            IToggle toggle = !TextUtils.isEmpty(a) ? Apollo.getToggle(a) : null;
            if (toggle == null || !toggle.allow() || (experiment3 = toggle.getExperiment()) == null) {
                IToggle toggle2 = Apollo.getToggle("global_android_map_vendor_toggle");
                if (!(toggle2 == null || !toggle2.allow() || (experiment2 = toggle2.getExperiment()) == null)) {
                    String str = (String) experiment2.getParam("didi", "0");
                    DLog.m10773d(f12786a, "didiMapSmallTest-->isDiDiMapEnabled:" + str, new Object[0]);
                    if (Integer.valueOf(str).intValue() == 1) {
                        return true;
                    }
                }
                String b = m10778b();
                if (!TextUtils.isEmpty(b)) {
                    iToggle = Apollo.getToggle(b);
                }
                if (!(iToggle == null || !iToggle.allow() || (experiment = iToggle.getExperiment()) == null)) {
                    int intValue = ((Integer) experiment.getParam("map_type", 0)).intValue();
                    DLog.m10773d(f12786a, "didiMapABTest->>isDiDiMapEnabled :" + intValue, new Object[0]);
                    if (intValue == 1) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            int intValue2 = ((Integer) experiment3.getParam("mapType_Android", 0)).intValue();
            DLog.m10773d(f12786a, "didiMapBigTest-->isDiDiMapEnabled:" + intValue2, new Object[0]);
            if (intValue2 == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            DLog.m10773d(f12786a, "isDiDiMapEnabled:" + e.toString(), new Object[0]);
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static String m10777a() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_caiman_parameter");
            if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
                return null;
            }
            String str = (String) experiment.getParam("caiman_passenger_ab", "");
            DLog.m10773d(f12786a, "big experiment key:" + str, new Object[0]);
            return str;
        } catch (Exception e) {
            DLog.m10773d(f12786a, "getBigExperimentKey" + e.toString(), new Object[0]);
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static String m10778b() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_caiman_parameter");
            if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
                return null;
            }
            String str = (String) experiment.getParam("dmap_passenger", "");
            DLog.m10773d(f12786a, "didi map ab test key" + str, new Object[0]);
            return str;
        } catch (Exception e) {
            DLog.m10773d(f12786a, "getDidiMapAbTestKey" + e.toString(), new Object[0]);
            e.printStackTrace();
            return null;
        }
    }

    public static boolean getDidiMapEnableVectorGraph() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_vector_graphv_toggle");
            if (!(toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null)) {
                int intValue = ((Integer) experiment.getParam("enable", 0)).intValue();
                DLog.m10773d("global_map_vector_graphv_toggle", "enable" + intValue, new Object[0]);
                if (intValue == 1) {
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
