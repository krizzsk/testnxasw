package com.didi.payment.base.proxy;

public class LoadingProxyHolder {

    /* renamed from: a */
    private static ILoadingProxy f32378a;

    public interface ILoadingProxy {
        void dismissLoading();

        void showLoading();
    }

    public static void releaseProxy() {
        f32378a = null;
    }

    public static ILoadingProxy getProxy() {
        return f32378a;
    }

    public static void setProxy(ILoadingProxy iLoadingProxy) {
        f32378a = iLoadingProxy;
    }
}
