package com.map.global.nav.libc.common;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.example.compapollovisitor.ApolloVisitHelper;

public class ApolloUtil {

    /* renamed from: a */
    private static final String f58536a = "NBApolloUtil";

    /* renamed from: b */
    private static boolean f58537b = true;

    /* renamed from: c */
    private static IToggle f58538c = Apollo.getToggle("global_map_match_yaw_config_toggle_new");

    /* renamed from: d */
    private static final int f58539d = 2;

    /* renamed from: e */
    private static final float f58540e = 0.45f;

    /* renamed from: f */
    private static boolean f58541f;

    /* renamed from: g */
    private static boolean f58542g;

    /* renamed from: h */
    private static final IToggle f58543h;

    /* renamed from: i */
    private static final boolean f58544i;

    public static float getCornerYawDistanceRadio() {
        return f58540e;
    }

    public static int getCornerYawStrategy() {
        return 2;
    }

    static {
        ApolloVisitHelper.getInstance().addApolloKey("global_map_match_yaw_config_toggle_new");
        IToggle iToggle = f58538c;
        boolean z = true;
        if (iToggle != null && iToggle.allow()) {
        }
        f58541f = false;
        IToggle toggle = Apollo.getToggle("globalmap_enable_filter_jump_point");
        if (toggle != null && toggle.allow() && 1 == ((Integer) toggle.getExperiment().getParam("filter_jump_point", 0)).intValue()) {
            f58541f = true;
        }
        f58542g = true;
        IToggle toggle2 = Apollo.getToggle("map_driver_use_car_image_toggle");
        if (toggle2 == null || !toggle2.allow()) {
            f58542g = true;
            DLog.m10773d(f58536a, "map_driver_use_car_image_toggle not allowed", new Object[0]);
        } else {
            f58542g = false;
            DLog.m10773d(f58536a, "map_driver_use_car_image_toggle allowed", new Object[0]);
        }
        IToggle toggle3 = Apollo.getToggle("global_map_sctx_simulation_toggle");
        f58543h = toggle3;
        if (toggle3 == null || !toggle3.allow()) {
            f58544i = false;
            return;
        }
        if (((Integer) f58543h.getExperiment().getParam("simulation_time_mode_ntp", 0)).intValue() <= 0) {
            z = false;
        }
        f58544i = z;
    }

    public static float getFilterAccuracy() {
        IToggle iToggle;
        if (!f58537b || (iToggle = f58538c) == null) {
            return 1000.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("filterAccuracy", Float.valueOf(1000.0f))).floatValue();
    }

    public static int getMinSnapOffsetRadius() {
        IToggle iToggle;
        if (!f58537b || (iToggle = f58538c) == null) {
            return 30;
        }
        return ((Integer) iToggle.getExperiment().getParam("m_Min_offsetRadius", 30)).intValue();
    }

    public static int getMaxSnapOffsetRadius() {
        IToggle iToggle;
        if (!f58537b || (iToggle = f58538c) == null) {
            return 100;
        }
        return ((Integer) iToggle.getExperiment().getParam("m_Max_offsetRadius", 100)).intValue();
    }

    public static float getValidAngleDiff() {
        IToggle iToggle;
        if (!f58537b || (iToggle = f58538c) == null) {
            return 30.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("m_valid_angleDiff", Float.valueOf(30.0f))).floatValue();
    }

    public static float getYawValidAngleDiff() {
        IToggle iToggle;
        if (!f58537b || (iToggle = f58538c) == null) {
            return 30.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("yaw_valid_angleDiff", Float.valueOf(30.0f))).floatValue();
    }

    public static int getMinOffsetRadius() {
        IToggle iToggle;
        if (!f58537b || (iToggle = f58538c) == null) {
            return 30;
        }
        return ((Integer) iToggle.getExperiment().getParam("yaw_Min_offsetRadius", 30)).intValue();
    }

    public static int getMaxOffsetRadius() {
        IToggle iToggle;
        if (!f58537b || (iToggle = f58538c) == null) {
            return 100;
        }
        return ((Integer) iToggle.getExperiment().getParam("yaw_Max_offsetRadius", 100)).intValue();
    }

    public static float getYawDirectSpeed() {
        IToggle iToggle;
        if (!f58537b || (iToggle = f58538c) == null) {
            return 1.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("yaw_direct_speed", Float.valueOf(1.0f))).floatValue();
    }

    public static float getYawOutWayCredit() {
        IToggle iToggle;
        if (!f58537b || (iToggle = f58538c) == null) {
            return 1.0f;
        }
        return ((Float) iToggle.getExperiment().getParam("yaw_outWay_credit", Float.valueOf(1.0f))).floatValue();
    }

    public static int getYawAccuracyOffset() {
        IToggle iToggle;
        if (!f58537b || (iToggle = f58538c) == null) {
            return 10;
        }
        return ((Integer) iToggle.getExperiment().getParam("yaw_accuracy_offset", 10)).intValue();
    }

    public static double getMaxCarHeadLevel() {
        IToggle toggle = Apollo.getToggle("map_light_nav_car_head_level");
        double d = 16.25d;
        if (toggle != null && toggle.allow()) {
            d = ((Double) toggle.getExperiment().getParam("android_max_level", Double.valueOf(16.25d))).doubleValue();
        }
        if (d < 15.5d) {
            return 15.5d;
        }
        return d;
    }

    public static DMKMapMatchABConfig getDMKMapMatchABConfig() {
        DMKMapMatchABConfig dMKMapMatchABConfig = new DMKMapMatchABConfig();
        dMKMapMatchABConfig.enableJumpFilter = f58541f;
        return dMKMapMatchABConfig;
    }

    public static boolean shouldRemoveCarImage() {
        return f58542g;
    }

    public static boolean isSctxSimulationTimestampNTP() {
        return f58544i;
    }
}
