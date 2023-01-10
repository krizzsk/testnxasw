package com.didi.dimina.container.p065ui.statusbar;

import android.text.TextUtils;

/* renamed from: com.didi.dimina.container.ui.statusbar.OSUtils */
public class OSUtils {

    /* renamed from: a */
    private static final String f19612a = "ro.miui.ui.version.name";

    /* renamed from: b */
    private static final String f19613b = "ro.build.version.emui";

    /* renamed from: c */
    private static final String f19614c = "ro.build.display.id";

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(m16676a(f19612a, ""));
    }

    public static boolean isMIUI6Later() {
        String mIUIVersion = getMIUIVersion();
        if (mIUIVersion.isEmpty()) {
            return false;
        }
        try {
            if (Integer.valueOf(mIUIVersion.substring(1)).intValue() >= 6) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static String getMIUIVersion() {
        return isMIUI() ? m16676a(f19612a, "") : "";
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(m16676a(f19613b, ""));
    }

    public static String getEMUIVersion() {
        return isEMUI() ? m16676a(f19613b, "") : "";
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1");
    }

    public static boolean isEMUI3_0() {
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    public static boolean isEMUI3_x() {
        return isEMUI3_0() || isEMUI3_1();
    }

    public static boolean isFlymeOS() {
        return m16675a().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Later() {
        int i;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains("os")) {
                i = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
            } else {
                i = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
            }
            if (i >= 4) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFlymeOS5() {
        int i;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains("os")) {
                i = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
            } else {
                i = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
            }
            if (i == 5) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static String getFlymeOSVersion() {
        return isFlymeOS() ? m16676a(f19614c, "") : "";
    }

    /* renamed from: a */
    private static String m16675a() {
        return m16676a(f19614c, "");
    }

    /* renamed from: a */
    private static String m16676a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, str2});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
