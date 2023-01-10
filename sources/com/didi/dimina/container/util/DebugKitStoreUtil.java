package com.didi.dimina.container.util;

import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.storage.MMKVUtil;

public class DebugKitStoreUtil {
    public static final String DEBUGKIT_DLOAD_LIMIT = "debugkit_dload_limit";

    /* renamed from: a */
    private static final String f19806a = "debugkit_web_view_jsengine";

    /* renamed from: b */
    private static final String f19807b = "debugkit_web_contents_debugging_enabled";

    /* renamed from: c */
    private static final String f19808c = "debugkit_vconsole_use";

    /* renamed from: d */
    private static final String f19809d = "debugkit_starbox_open";

    /* renamed from: e */
    private static final String f19810e = "debugkit_uncaught_error_board_open";

    public static void setVConsole(String str, boolean z) {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(f19808c + str, Boolean.valueOf(z));
    }

    public static boolean getVConsole(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        return ((Boolean) instance.get(f19808c + str, false)).booleanValue();
    }

    public static boolean getWebContentsDebuggingEnabled() {
        boolean isDebug = Dimina.getConfig().isDebug();
        if (isDebug) {
            return true;
        }
        Object obj = MMKVUtil.getInstance().get(f19807b, Boolean.valueOf(isDebug));
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : isDebug;
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        MMKVUtil.getInstance().save(f19807b, Boolean.valueOf(z));
    }

    public static boolean getWebViewJSEngineEnabled() {
        return ((Boolean) MMKVUtil.getInstance().get(f19806a, false)).booleanValue();
    }

    public static void setWebViewJSEngineEnabled(boolean z) {
        MMKVUtil.getInstance().save(f19806a, Boolean.valueOf(z));
    }

    public static void setDloadLimit(String str, boolean z) {
        MMKVUtil.getInstance().save("debugkit_dload_limit_" + str, DEBUGKIT_DLOAD_LIMIT + z);
    }

    public static String getDloadLimit(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        return (String) instance.get("debugkit_dload_limit_" + str, "debugkit_dload_limitfalse");
    }

    public static void setStarBoxOpen(boolean z) {
        MMKVUtil.getInstance().save(f19809d, Boolean.valueOf(z));
    }

    public static boolean getStarBoxOpen() {
        return ((Boolean) MMKVUtil.getInstance().get(f19809d, false)).booleanValue() || Dimina.getConfig().isDebug();
    }

    public static boolean getUncaughtErrorBoardOpen() {
        return ((Boolean) MMKVUtil.getInstance().get(f19810e, false)).booleanValue();
    }

    public static void setUnCaughtErrorBoardSwitch(boolean z) {
        MMKVUtil.getInstance().save(f19810e, Boolean.valueOf(z));
    }
}
