package com.didi.consume.phone.proxy;

public class LoadingProxyHolder {

    /* renamed from: a */
    private static ILoadingProxy f18143a;

    public interface ILoadingProxy {
        void dismissLoading();

        void showLoading();
    }

    public static void releaseProxy() {
        f18143a = null;
    }

    public static ILoadingProxy getProxy() {
        return f18143a;
    }

    public static void setProxy(ILoadingProxy iLoadingProxy) {
        f18143a = iLoadingProxy;
    }
}
