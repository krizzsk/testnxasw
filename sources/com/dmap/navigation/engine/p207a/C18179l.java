package com.dmap.navigation.engine.p207a;

import com.didichuxing.apollo.sdk.IToggle;
import com.dmap.apollo.ApolloDelegate;

/* renamed from: com.dmap.navigation.engine.a.l */
/* compiled from: ApolloUtil */
public final class C18179l {

    /* renamed from: a */
    private static final ApolloDelegate f54369a = new ApolloDelegate();

    /* renamed from: b */
    public static boolean m40459b() {
        return f54369a.getToggleCache("hawaii_zhongyan_switch").allow();
    }

    /* renamed from: c */
    public static int m40460c() {
        IToggle toggleCache = f54369a.getToggleCache("hw_navi_mm_config");
        if (toggleCache.allow()) {
            return ((Integer) toggleCache.getExperiment().getParam("dia_version", 0)).intValue();
        }
        return 0;
    }

    public static boolean isTrafficEventOpen() {
        return f54369a.getToggleCache("hawaii_android_traffic_event").allow();
    }

    public static boolean isOpenFbRoadName() {
        return f54369a.getToggleCache("hawaii_map_fishbone_bubbles").allow();
    }

    /* renamed from: d */
    public static int m40461d() {
        IToggle toggleCache = f54369a.getToggleCache("hawaii_android_navi_mm_for_fishbone");
        if (toggleCache.allow()) {
            return ((Integer) toggleCache.getExperiment().getParam("fishbone", 0)).intValue();
        }
        return 0;
    }

    /* renamed from: e */
    public static boolean m40462e() {
        return f54369a.getToggleCache("hawaii_android_navi_multi_route").allow();
    }

    /* renamed from: f */
    public static boolean m40463f() {
        IToggle toggleCache = f54369a.getToggleCache("gray_map_navi_basemap_camera_v2");
        if ((toggleCache.allow() ? ((Integer) toggleCache.getExperiment().getParam("camera_v2_show", 0)).intValue() : 0) == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public static boolean m40464g() {
        IToggle toggleCache = f54369a.getToggleCache("map_drive_navi_pic_vector");
        if (toggleCache.allow()) {
            int intValue = ((Integer) toggleCache.getExperiment().getParam("vector", 0)).intValue();
            if (intValue == 1) {
                return true;
            }
            if (intValue == 0) {
            }
        }
        return false;
    }
}
