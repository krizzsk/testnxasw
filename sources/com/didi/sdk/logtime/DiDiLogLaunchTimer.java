package com.didi.sdk.logtime;

import java.util.HashSet;
import java.util.Set;

public class DiDiLogLaunchTimer {
    public static final String KEY_APP_LAUNCHING_TIME = "app_launch_time";
    public static final String KEY_TIME = "app_launch_time";
    public static final String KEY_TIME_LAUNCHING = "launching";
    public static final String KEY_TIME_MAINLAUNCH = "main_launching";
    public static final String KEY_TIME_MAPCREATE = "map_create_finish";
    public static final String KEY_TIME_MAPINIT = "map_init_finish";
    public static final String KEY_TIME_RENDER = "main_render_time";
    public static final String KEY_TIME_TOTAL = "app_launch_total";

    /* renamed from: a */
    private static final Set<String> f39508a = new HashSet();

    /* renamed from: b */
    private static final Set<String> f39509b = new HashSet();

    static {
        f39508a.add(KEY_TIME_LAUNCHING);
        f39508a.add(KEY_TIME_MAINLAUNCH);
        f39508a.add("app_launch_time");
        f39509b.add(KEY_TIME_LAUNCHING);
        f39509b.add(KEY_TIME_MAPINIT);
        f39509b.add(KEY_TIME_MAPCREATE);
        f39509b.add(KEY_TIME_MAINLAUNCH);
        f39509b.add("app_launch_time");
        f39509b.add(KEY_TIME_RENDER);
    }

    public static boolean isStatisticsPoint(String str) {
        return f39508a.contains(str);
    }

    public static boolean isMainPoint(String str) {
        return f39509b.contains(str);
    }
}
