package com.didi.map;

import com.didi.hawaii.utils.JsonUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class MapApolloHawaii {
    public static final int BASE_MAP_VERSION = getSupport3DBaseMapVersion();
    public static final boolean GL_THREAD_LAG_TRACTLOG = m21142b();
    public static final String HAWAII_TRAFFIC_THREAD_INTERRUPT = "hawaii_traffic_thread_interrupt";
    public static final boolean USE_NEW_BLUE_BUBBLE = m21141a();

    /* renamed from: a */
    private static final String f26667a = "hawaii_android_omega_net_failed";

    /* renamed from: b */
    private static final String f26668b = "hawaii_android_omega_net_success";

    /* renamed from: c */
    private static final String f26669c = "hawaii_android_map_log_enable";

    /* renamed from: d */
    private static final String f26670d = "MapLogState";

    /* renamed from: e */
    private static final String f26671e = "didimap_android_hwi_navi_feature_toggle";

    /* renamed from: f */
    private static final String f26672f = "hawaii_andriod_map_overpass3d";

    /* renamed from: g */
    private static final String f26673g = "NAVI_FEATURE";

    /* renamed from: h */
    private static final String f26674h = "hawaii_map_wms_config";

    /* renamed from: i */
    private static final String f26675i = "hawaii_map_fishbone_bubbles";

    /* renamed from: j */
    private static final String f26676j = "glMapLib_Support3DBaseMap_android";

    /* renamed from: k */
    private static final String f26677k = "hawaii_android_map_fishbone_bubble_only";

    /* renamed from: l */
    private static final String f26678l = "hawaii_android_show_curvy_route_name";

    /* renamed from: m */
    private static final String f26679m = "hawaii_handmap_SupportJsonStyle";

    /* renamed from: n */
    private static final String f26680n = "hawaii_android_track_load_lib";

    /* renamed from: o */
    private static final String f26681o = "hawaii_android_setlogcase";

    /* renamed from: p */
    private static final String f26682p = "hawaii_map_guard_config";

    /* renamed from: q */
    private static final String f26683q = "hawaii_android_map_talkback";

    /* renamed from: r */
    private static final String f26684r = "hawaii_mapjni_post";

    /* renamed from: s */
    private static final String f26685s = "hawaii_mapdata_filter_language";

    /* renamed from: t */
    private static final int f26686t = m21145e();

    /* renamed from: u */
    private static final boolean f26687u = m21146f();

    /* renamed from: v */
    private static final String f26688v = "hawaii_android_traffic_lock_switch";

    /* renamed from: w */
    private static final String f26689w = "hawaii_map_set_native_apollo_callback";

    /* renamed from: x */
    private static final String f26690x = "hawaii_render_log_controll";

    /* renamed from: y */
    private static final boolean f26691y = m21143c();

    /* renamed from: z */
    private static final boolean f26692z = m21144d();

    public static boolean isMapResPack() {
        return true;
    }

    /* renamed from: a */
    private static boolean m21141a() {
        return Apollo.getToggle("hawaii_android_use_new_bluebubble").allow();
    }

    /* renamed from: b */
    private static boolean m21142b() {
        return Apollo.getToggle("hawaii_glthread_lag_tracelog").allow();
    }

    public static boolean isNativeLogEnable() {
        return f26691y;
    }

    public static boolean isNativeOmegaEnable() {
        return f26692z;
    }

    public static boolean getSupportJsonStyle() {
        IToggle toggle = Apollo.getToggle(f26679m);
        if ((toggle.allow() ? ((Integer) toggle.getExperiment().getParam("support_json_style", 0)).intValue() : 0) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isOmegaNetFailed() {
        return Apollo.getToggle(f26667a).allow();
    }

    public static boolean isOmegaNetSuccess() {
        return Apollo.getToggle(f26668b).allow();
    }

    public static boolean isSetLogCaseLogCallback() {
        return Apollo.getToggle(f26681o).allow();
    }

    /* renamed from: c */
    private static boolean m21143c() {
        IToggle toggle = Apollo.getToggle(f26690x);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("native_log_enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m21144d() {
        IToggle toggle = Apollo.getToggle(f26690x);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("native_omega_enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isSetMapNativeApolloCallback() {
        return Apollo.getToggle(f26689w).allow();
    }

    public static boolean isMapJniPost() {
        return Apollo.getToggle(f26684r).allow();
    }

    public static boolean isMapLogOpen() {
        return Apollo.getToggle(f26669c).allow();
    }

    public static String getMapLogState() {
        return (String) Apollo.getToggle(f26669c).getExperiment().getParam(f26670d, "");
    }

    public static boolean isNavFeatureOpen() {
        return Apollo.getToggle(f26671e).allow();
    }

    public static String getNavFeature() {
        return (String) Apollo.getToggle(f26671e).getExperiment().getParam(f26673g, "");
    }

    public static boolean canShowRouteBubbles() {
        String navFeature = getNavFeature();
        if (navFeature != null && navFeature.length() > 0) {
            try {
                String string = JsonUtil.getString(new JSONObject(navFeature), "canShowRouteBubbles");
                if (string == null || string.length() <= 0 || !string.equalsIgnoreCase("1")) {
                    return false;
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String getAndriodMapOverpass3dConfig() {
        IToggle toggle = Apollo.getToggle(f26672f);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("config", "");
        }
        return "";
    }

    public static boolean isMapWmsConfig() {
        return Apollo.getToggle(f26674h).allow();
    }

    public static String getMapWmsConfig() {
        IToggle toggle = Apollo.getToggle(f26674h);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("config", "");
        }
        return "";
    }

    public static boolean isOpenFbRoadName() {
        return Apollo.getToggle(f26675i).allow();
    }

    public static int getSupport3DBaseMapVersion() {
        return f26686t;
    }

    /* renamed from: e */
    private static int m21145e() {
        IToggle toggle = Apollo.getToggle(f26676j);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("version", 4)).intValue();
        }
        return 4;
    }

    public static String getFishboneBubbleOnlyConfig() {
        IToggle toggle = Apollo.getToggle(f26677k);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("config", "");
        }
        return "";
    }

    public static String getShowCurvyRouteName() {
        IToggle toggle = Apollo.getToggle(f26678l);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("canShowCurvyRouteName", "");
        }
        return "";
    }

    public static boolean isTrackInLoadLib() {
        return Apollo.getToggle(f26680n).allow();
    }

    public static HashMap<String, Integer> getGuardConfig() {
        IToggle toggle = Apollo.getToggle(f26682p);
        if (toggle.allow()) {
            try {
                HashMap<String, Integer> hashMap = new HashMap<>();
                IExperiment experiment = toggle.getExperiment();
                hashMap.put("crashNumMax", (Integer) experiment.getParam("crashNumMax", 0));
                hashMap.put("timeMax", (Integer) experiment.getParam("timeMax", 0));
                hashMap.put("timeFirst", (Integer) experiment.getParam("timeFirst", 0));
                return hashMap;
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static boolean isTalkbackOpen() {
        return Apollo.getToggle(f26683q).allow();
    }

    /* renamed from: f */
    private static boolean m21146f() {
        return Apollo.getToggle(f26688v).allow();
    }

    public static boolean isCloseTrafficLock() {
        return f26687u;
    }

    public static boolean isFilterMapData() {
        return Apollo.getToggle(f26685s).allow();
    }
}
