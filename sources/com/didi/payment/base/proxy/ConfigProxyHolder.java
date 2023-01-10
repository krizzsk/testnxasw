package com.didi.payment.base.proxy;

import android.content.Context;

public class ConfigProxyHolder {

    /* renamed from: a */
    private static IConfigProxy f32373a;

    /* renamed from: b */
    private static IGlobalPageRouterProxy f32374b;

    public interface IConfigProxy {
        boolean isDebugMode();
    }

    public interface IGlobalPageRouterProxy {
        void toHomeActivity(Context context, boolean z);
    }

    public static void releaseProxy() {
        f32373a = null;
        f32374b = null;
    }

    public static IConfigProxy getProxy() {
        return f32373a;
    }

    public static void setProxy(IConfigProxy iConfigProxy) {
        f32373a = iConfigProxy;
    }

    public static IGlobalPageRouterProxy getGlobalPageRouterProxy() {
        return f32374b;
    }

    public static void setGlobalPageRouterProxy(IGlobalPageRouterProxy iGlobalPageRouterProxy) {
        f32374b = iGlobalPageRouterProxy;
    }
}
