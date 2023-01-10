package com.didi.payment.base.proxy;

import java.util.HashMap;

public class HttpHeaderProxyHolder {

    /* renamed from: a */
    private static IHeaderProxy f32376a;

    public interface IHeaderProxy {
        HashMap<String, String> getHeaders();
    }

    public static IHeaderProxy getProxy() {
        return f32376a;
    }

    public static void setProxy(IHeaderProxy iHeaderProxy) {
        f32376a = iHeaderProxy;
    }
}
