package com.didi.payment.base.tracker;

import java.util.Map;

public class PayTracker {

    /* renamed from: a */
    static final String f32437a = "PayBase";

    /* renamed from: b */
    static final String f32438b = "PayTracker";

    private PayTracker() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    private static class InnerPayTracker {
        static C11331a instance = new C11331a();

        private InnerPayTracker() {
        }
    }

    public static IPayTracker getTracker() {
        return InnerPayTracker.instance;
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        InnerPayTracker.instance.trackEvent(str, map);
    }

    public static void trackEvent(String str) {
        InnerPayTracker.instance.trackEvent(str);
    }

    public static void putGlobal(String str, Object obj) {
        InnerPayTracker.instance.putGlobal(str, obj);
    }

    public static void removeGlobal(String str) {
        InnerPayTracker.instance.removeGlobal(str);
    }

    public static void putWalletGlobal(String str, String str2) {
        InnerPayTracker.instance.putWalletGlobal(str, str2);
    }

    public static void removeWalletGlobal(String str) {
        InnerPayTracker.instance.removeWalletGlobal(str);
    }

    public static void trackEventWithWalletGlobal(String str, Map<String, Object> map) {
        InnerPayTracker.instance.trackEventWithWalletGlobal(str, map);
    }
}
