package com.didi.beatles.p101im.plugin.robot;

import com.didi.beatles.p101im.utils.IMLog;
import java.util.Map;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotConstant */
public final class IMRobotConstant {
    public static final int PLUGIN_ID_ROBOT = 3;

    /* renamed from: a */
    private static String f11310a;

    /* renamed from: b */
    private static Map<String, String> f11311b;

    /* renamed from: c */
    private static int f11312c;

    private IMRobotConstant() {
    }

    public static void setData(String str, Map<String, String> map, int i) {
        IMLog.m10020d("IMRobotConstant", "[setData] orderId=" + str);
        f11310a = str;
        f11311b = map;
        f11312c = i;
    }

    public static String getOrderId() {
        return f11310a;
    }

    public static Map<String, String> getExtraTraceMap() {
        return f11311b;
    }

    public static int getActionSource() {
        return f11312c;
    }
}
