package com.didichuxing.afanty;

import com.didichuxing.afanty.common.AfantyConfig;
import com.didichuxing.omega.sdk.feedback.FeedbackActivator;
import com.didichuxing.omega.sdk.feedback.FloatingViewState;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import com.didichuxing.omega.sdk.uicomponents.floatingview.FloatingViewApi;

public class AfantySDK {

    /* renamed from: a */
    private static boolean f48189a = false;

    /* renamed from: b */
    private static String f48190b = "liaoyuan";

    public static boolean isReportToOmegaServer() {
        return f48189a;
    }

    public static void setReportToOmegaServer(boolean z) {
        f48189a = z;
    }

    public static String getTiyanFrom() {
        return f48190b;
    }

    public static void setTiyanFrom(String str) {
        f48190b = str;
    }

    public static void setLanguage(AfantyConfig.IGetLanguage iGetLanguage) {
        AfantyConfig.iGetLanguage = iGetLanguage;
        FloatingViewApi.uninit();
        FloatingViewState.getInstance().clearDynamicMenuItem();
        FeedbackActivator.loadDynamicMenu(SwarmUtil.getApplication());
    }
}
