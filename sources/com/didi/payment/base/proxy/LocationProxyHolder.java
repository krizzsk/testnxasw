package com.didi.payment.base.proxy;

public class LocationProxyHolder {

    /* renamed from: a */
    private static ILocationProxy f32379a;

    public interface ILocationProxy {
        void requestLocationAndCityId();
    }

    public static ILocationProxy getProxy() {
        return f32379a;
    }

    public static void setProxy(ILocationProxy iLocationProxy) {
        f32379a = iLocationProxy;
    }
}
