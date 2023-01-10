package com.didi.safety.god.manager;

public class SGActivityDelegateHolder {

    /* renamed from: a */
    private static volatile SafetyGodActivityDelegate f37362a;

    public static void setActivityDelegate(SafetyGodActivityDelegate safetyGodActivityDelegate) {
        f37362a = safetyGodActivityDelegate;
    }

    public static SafetyGodActivityDelegate getActivityDelegate() {
        return f37362a;
    }
}
