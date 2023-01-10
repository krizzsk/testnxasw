package com.didi.payment.base.proxy;

import java.util.Map;

public class FireBaseProxyHolder {

    /* renamed from: a */
    private static IFireBaseProxy f32375a;

    public interface IFireBaseProxy {
        void trackEvent(String str, Map<String, Object> map);
    }

    public static IFireBaseProxy getProxy() {
        return f32375a;
    }

    public static void setProxy(IFireBaseProxy iFireBaseProxy) {
        f32375a = iFireBaseProxy;
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        IFireBaseProxy iFireBaseProxy = f32375a;
        if (iFireBaseProxy != null) {
            iFireBaseProxy.trackEvent(str, map);
        }
    }
}
