package com.didi.map.common;

import android.os.Build;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public final class ApolloHawaii {

    /* renamed from: A */
    private static final String f26847A = "hawaii_android_mapsdk_url";
    public static final boolean ADD_ENGINE_AFTER_FIRST_FRAME = m21208u();

    /* renamed from: B */
    private static final String f26848B = "hawaii_traffic_update_interval";

    /* renamed from: C */
    private static final String f26849C = "map_gl_exception_track";
    public static final boolean CANCEL_TILE_DATA_REQUEST = m21199l();

    /* renamed from: D */
    private static final String f26850D = "hawaii_glmaplib_UseVulkan";

    /* renamed from: E */
    private static final String f26851E = "map_sdk_version_v2_degradeto_v1";

    /* renamed from: F */
    private static final String f26852F = "map_sdk_fix_anr_cicle";

    /* renamed from: G */
    private static final String f26853G = "hawaii_android_new_gesture";

    /* renamed from: H */
    private static final String f26854H = "hawaii_reset_locator_position";
    public static final int HWBUSSThreshold = getHWBUsThreshold();
    public static final boolean HWBUSSThresholdOpen = openHWBUsThreshold();

    /* renamed from: I */
    private static final String f26855I = "hawaii_hwbuss_threshold";
    public static final boolean IS_MJO_MEMORY_LIMIT = m21194g();
    public static final boolean IS_OPEN_MSAA = m21197j();
    public static final boolean IS_RENDER_DROP_FRAME = m21198k();
    public static final boolean IS_USE_BLOCKOPT = m21207t();
    public static boolean IS_USE_TEXTUREVIEW = m21204q();

    /* renamed from: J */
    private static final String f26856J = "hawaii_create_bitmap_force_copy";

    /* renamed from: K */
    private static final String f26857K = "hawaii_map_nav_jam_view_param";

    /* renamed from: L */
    private static final String f26858L = "hawaii_android_navi_multi_route";

    /* renamed from: M */
    private static final String f26859M = "map_sdk_fix_anr_glsurface";
    public static int MEMORY_LIMIT_AVIABLE = 0;
    public static int MEMORY_LIMIT_TIME = 0;
    public static final boolean MJO_ENABLED = m21195h();

    /* renamed from: N */
    private static final String f26860N = "hawaii_fix_traffic_anr";

    /* renamed from: O */
    private static final String f26861O = "map_sdk_fix_arm64_bug";
    public static boolean OPEN_ANIMATE = false;
    public static boolean OPEN_ANIMATE_HAS_DEL_ANIMATE = false;

    /* renamed from: P */
    private static final String f26862P = "gray_map_navi_usedolphinhost";

    /* renamed from: Q */
    private static final String f26863Q = "hawaii_change_language_cancel";

    /* renamed from: R */
    private static final String f26864R = "hawaii_map_apollo_loopmap";
    public static final boolean RESET_LOCATOR_POSITION = m21193f();
    public static float ROTATE_DELTA = 0.0f;

    /* renamed from: S */
    private static final String f26865S = "map_navi_hmi_day_night_changetime";
    public static float SCALE_DELTA = 0.0f;

    /* renamed from: T */
    private static boolean f26866T = m21205r();

    /* renamed from: U */
    private static final String f26867U = "hawaii_map_use_textureview";
    public static final boolean USE_MAPSDK_V2 = true;
    public static boolean USE_NEWBUBBLE = m21188a();
    public static final boolean USE_NEWWAY_CONTEXT = m21202o();
    public static boolean USE_NEW_BLOCK_BUBBLE = m21190c();
    public static final boolean USE_SHARE_CONTEXT = m21201n();
    public static final boolean USE_VULKAN_MAP = m21203p();

    /* renamed from: V */
    private static final int f26868V = isVdrOrgForNavi();

    /* renamed from: a */
    private static final String f26869a = "hawaii_android_report_ops_uithread_check";

    /* renamed from: b */
    private static final String f26870b = "hawaii_android_use_didi_netutils";

    /* renamed from: c */
    private static final String f26871c = "hawaii_android_traffic_event";

    /* renamed from: d */
    private static final String f26872d = "hawaii_android_dynamic_bubbleAB";

    /* renamed from: e */
    private static final String f26873e = "apollo_hawaii_is_use_test_url";

    /* renamed from: f */
    private static final String f26874f = "hawaii_best_view_debug";

    /* renamed from: g */
    private static final String f26875g = "hawaii_map_time_view";

    /* renamed from: h */
    private static final String f26876h = "hawaii_android_log_crash";

    /* renamed from: i */
    private static final String f26877i = "hawaii_android_map_config_server_test_on";

    /* renamed from: j */
    private static final String f26878j = "hawaii_map_glthread_monitor";

    /* renamed from: k */
    private static final String f26879k = "hawaii_map_fishbone_bubbles";

    /* renamed from: l */
    private static final String f26880l = "hawaii_map_lock_glthread";

    /* renamed from: m */
    private static final String f26881m = "hawaii_osmodel_report";

    /* renamed from: n */
    private static final String f26882n = "hawaii_map_mjo_memory_limit";
    public static boolean newMultiBubbleCollision = m21192e();

    /* renamed from: o */
    private static final String f26883o = "map_navi_yaw_vdr";
    public static final boolean openCreateBitmapForceCopy = m21209v();
    public static final boolean openMapLoop = m21200m();

    /* renamed from: p */
    private static final String f26884p = "hawaii_sdk_version_v2_passenger";

    /* renamed from: q */
    private static final String f26885q = "hawaii_mapv2_share_context";

    /* renamed from: r */
    private static float f26886r = 16.5f;

    /* renamed from: s */
    private static float f26887s = 18.5f;

    /* renamed from: t */
    private static final String f26888t = "hawaii_map_area_bubble_refactor";

    /* renamed from: u */
    private static final String f26889u = "hawaii_new_multi_bubble_collision";
    public static final boolean useNewCameraPosition = m21196i();

    /* renamed from: v */
    private static final String f26890v = "map_navi_hmi_android_render";

    /* renamed from: w */
    private static final String f26891w = "hawaii_map_use_bubble";

    /* renamed from: x */
    private static final String f26892x = "gray_map_navi_pic_mjo";

    /* renamed from: y */
    private static final String f26893y = "hawii_camera_position_v2";

    /* renamed from: z */
    private static final String f26894z = "hawaii_map_render_msaa";

    /* renamed from: p */
    private static boolean m21203p() {
        return false;
    }

    public static boolean performanceGlSurfaceView() {
        return true;
    }

    static {
        boolean[] b = m21189b();
        OPEN_ANIMATE = b[0];
        OPEN_ANIMATE_HAS_DEL_ANIMATE = b[1];
        m21210w();
    }

    /* renamed from: a */
    private static boolean m21188a() {
        return !Apollo.getToggle("hawaii_close_new_bubble").allow();
    }

    /* renamed from: b */
    private static boolean[] m21189b() {
        IToggle toggle = Apollo.getToggle("hawaii_bubble_animate");
        if (!toggle.allow()) {
            return new boolean[]{false, false};
        }
        boolean z = false;
        int intValue = ((Integer) toggle.getExperiment().getParam("del_animate", 0)).intValue();
        boolean[] zArr = new boolean[2];
        zArr[0] = true;
        if (intValue == 1) {
            z = true;
        }
        zArr[1] = z;
        return zArr;
    }

    /* renamed from: c */
    private static boolean m21190c() {
        return Apollo.getToggle("apollo_hawaii_jam_bubble_refactor").allow();
    }

    /* renamed from: d */
    private static boolean m21191d() {
        boolean allow = Apollo.getToggle(f26888t).allow();
        HWLog.m20433i("Apollo", "isNewBubbleRefactor allow = " + allow);
        return allow;
    }

    /* renamed from: e */
    private static boolean m21192e() {
        boolean allow = Apollo.getToggle(f26889u).allow();
        HWLog.m20433i("Apollo", "hawaii_new_multi_bubble_collision allow = " + allow);
        return allow;
    }

    /* renamed from: f */
    private static boolean m21193f() {
        return Apollo.getToggle(f26854H).allow();
    }

    /* renamed from: g */
    private static boolean m21194g() {
        IToggle toggle = Apollo.getToggle(f26882n);
        MEMORY_LIMIT_AVIABLE = ((Integer) toggle.getExperiment().getParam("available", 200)).intValue();
        MEMORY_LIMIT_TIME = ((Integer) toggle.getExperiment().getParam("interval", 18)).intValue();
        return toggle.allow();
    }

    /* renamed from: h */
    private static boolean m21195h() {
        return Apollo.getToggle(f26892x).allow();
    }

    /* renamed from: i */
    private static boolean m21196i() {
        return Apollo.getToggle(f26893y).allow();
    }

    /* renamed from: j */
    private static boolean m21197j() {
        return Apollo.getToggle(f26892x).allow() && Apollo.getToggle(f26894z).allow();
    }

    /* renamed from: k */
    private static boolean m21198k() {
        IToggle toggle = Apollo.getToggle(f26890v);
        if (toggle.allow()) {
            SCALE_DELTA = Float.valueOf((String) toggle.getExperiment().getParam("scale_delta", "1.5")).floatValue();
            ROTATE_DELTA = (float) ((Integer) toggle.getExperiment().getParam("rotate_delta", 45)).intValue();
        }
        return toggle.allow();
    }

    /* renamed from: l */
    private static boolean m21199l() {
        return Apollo.getToggle(f26863Q).allow();
    }

    /* renamed from: m */
    private static boolean m21200m() {
        IToggle toggle = Apollo.getToggle(f26864R);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("on", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    private ApolloHawaii() {
    }

    /* renamed from: n */
    private static boolean m21201n() {
        IToggle toggle = Apollo.getToggle(f26885q);
        boolean z = toggle.allow() && MJO_ENABLED;
        if (z) {
            String str = (String) toggle.getExperiment().getParam("os_models", "");
            if (!TextUtils.isEmpty(str)) {
                String str2 = Build.MODEL;
                for (String equals : str.split(",")) {
                    if (str2.equals(equals)) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: o */
    private static boolean m21202o() {
        IToggle toggle = Apollo.getToggle(f26885q);
        if (!USE_SHARE_CONTEXT || ((Integer) toggle.getExperiment().getParam("useNewWayContext", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: q */
    private static boolean m21204q() {
        IToggle toggle = Apollo.getToggle(f26867U);
        if (toggle.allow()) {
            String str = Build.MODEL;
            for (String equals : ((String) toggle.getExperiment().getParam("os_models", "")).split(",")) {
                if (str.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean getTwilightFromNet() {
        return Apollo.getToggle(f26865S).allow();
    }

    public static String getSunriseExtra() {
        IToggle toggle = Apollo.getToggle(f26865S);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("sunrise_time", "10");
        }
        return "10";
    }

    public static String getSunsetExtra() {
        IToggle toggle = Apollo.getToggle(f26865S);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("sunset_time", "10");
        }
        return "10";
    }

    public static long getTrafficUpdateInterval() {
        IToggle toggle = Apollo.getToggle(f26848B);
        if (toggle.allow()) {
            toggle.getExperiment().getParam("interval_time", 2000L);
        }
        return 2000;
    }

    public static boolean isReportUIThreadCheck() {
        return Apollo.getToggle(f26869a).allow();
    }

    public static boolean useDidiNetUtils() {
        return Apollo.getToggle(f26870b).allow();
    }

    public static boolean openMapGLThreadMonitor() {
        return Apollo.getToggle("hawaii_map_glthread_monitor").allow();
    }

    public static boolean isTrafficEventOpen() {
        return Apollo.getToggle(f26871c).allow();
    }

    public static int isHaveMultiRouteBubble() {
        IToggle toggle = Apollo.getToggle(f26872d);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("dynamicBubbleTest", 1)).intValue();
        }
        return 1;
    }

    public static int isVdrOrgForNavi() {
        IToggle toggle = Apollo.getToggle(f26883o);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("vdr_org_for_navi", -1)).intValue();
        }
        return -1;
    }

    public static int getVdrOrgForNavi() {
        return f26868V;
    }

    public static boolean isUseTestUrl() {
        return Apollo.getToggle(f26873e).allow();
    }

    public static boolean isLockGLThread() {
        return f26866T;
    }

    /* renamed from: r */
    private static boolean m21205r() {
        String str = Build.VERSION.RELEASE;
        return "6.0".equals(str) || str.equals("6.0.1") || str.equals("5.1") || str.equals("5.1.1");
    }

    public static boolean isMapUseTestUrl() {
        return Apollo.getToggle(f26877i).allow();
    }

    public static String getTileHost() {
        IToggle toggle = Apollo.getToggle(f26877i);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("tile_server", "");
        }
        return "";
    }

    public static String getConfigHost() {
        IToggle toggle = Apollo.getToggle(f26877i);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("config_server", "");
        }
        return "";
    }

    public static String getTrafficHost() {
        IToggle toggle = Apollo.getToggle(f26877i);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("traffic_server", "");
        }
        return "";
    }

    public static boolean isBestViewDebug() {
        return Apollo.getToggle(f26874f).allow();
    }

    public static String getTestUrlIP() {
        IToggle toggle = Apollo.getToggle(f26873e);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("serverHost", "");
        }
        return "";
    }

    public static String getMapSdkUrl() {
        IToggle toggle = Apollo.getToggle(f26847A);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("url", "");
        }
        return "";
    }

    public static boolean isOpenMapTimeView() {
        return Apollo.getToggle(f26875g).allow();
    }

    public static boolean isOpenMapMemoryView() {
        IToggle toggle = Apollo.getToggle(f26875g);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("MemoryProfile", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isHawaiiLogCrashOpen() {
        return Apollo.getToggle(f26876h).allow();
    }

    public static boolean isUseFishboneBubble() {
        return Apollo.getToggle(f26879k).allow();
    }

    /* renamed from: s */
    private static boolean m21206s() {
        return Apollo.getToggle(f26884p).allow();
    }

    public static boolean isTrackGLException() {
        return Apollo.getToggle(f26849C).allow();
    }

    public static boolean isFixANR() {
        return Apollo.getToggle(f26852F).allow();
    }

    public static boolean isUseNewGesture() {
        return Apollo.getToggle(f26853G).allow();
    }

    /* renamed from: t */
    private static boolean m21207t() {
        IToggle toggle = Apollo.getToggle(f26891w);
        int i = -1;
        if (toggle.allow()) {
            i = ((Integer) toggle.getExperiment().getParam("blockopt", -1)).intValue();
        }
        return i == 1;
    }

    public static boolean useAndroidOGLSurfaceView() {
        return Apollo.getToggle("hawaii_use_androido_glsurfaceview").allow();
    }

    /* renamed from: u */
    private static boolean m21208u() {
        IToggle toggle = Apollo.getToggle(f26859M);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("firstFrame", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean fixTrafficANR() {
        return Apollo.getToggle(f26860N).allow();
    }

    public static boolean fixarm64Bug() {
        return Apollo.getToggle(f26861O).allow();
    }

    public static boolean useDolphinHost() {
        return Apollo.getToggle(f26862P).allow();
    }

    public static boolean openHWBUsThreshold() {
        return Apollo.getToggle(f26855I).allow();
    }

    public static int getHWBUsThreshold() {
        IToggle toggle = Apollo.getToggle(f26855I);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("threshold", 1)).intValue();
        }
        return 1;
    }

    /* renamed from: v */
    private static boolean m21209v() {
        IToggle toggle = Apollo.getToggle(f26856J);
        boolean allow = toggle != null ? toggle.allow() : false;
        HWLog.m20433i("", "CreateBitmapForceCopy:" + allow);
        return allow;
    }

    /* renamed from: w */
    private static void m21210w() {
        IToggle toggle = Apollo.getToggle(f26857K);
        if (toggle.allow()) {
            f26886r = ((Float) toggle.getExperiment().getParam("minScale", Float.valueOf(16.5f))).floatValue();
            f26887s = ((Float) toggle.getExperiment().getParam("maxScale", Float.valueOf(18.5f))).floatValue();
        } else {
            f26886r = 16.5f;
            f26887s = 18.5f;
        }
        HWLog.m20433i("Apollo", "jam view scale between " + f26886r + " and " + f26887s);
    }

    public static float getJamViewMinScale() {
        return f26886r;
    }

    public static float getJamViewMaxScale() {
        return f26887s;
    }
}
