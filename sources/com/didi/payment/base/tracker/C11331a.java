package com.didi.payment.base.tracker;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.payment.base.tracker.a */
/* compiled from: PayOmegaTracker */
class C11331a implements IPayTracker {

    /* renamed from: a */
    private static final String f32439a = "PayOmegaTracker";

    /* renamed from: b */
    private static Map<String, Object> f32440b;

    C11331a() {
    }

    public void trackEvent(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            createEvent(str).attrs(map).track();
        }
    }

    public void trackEvent(String str) {
        createEvent(str).track();
    }

    public ErrorEvent createErrorEvent(String str, String str2, String str3) {
        return new ErrorEvent(str, str2, str3);
    }

    public Event createEvent(String str) {
        return new Event(str);
    }

    public void putGlobal(String str, Object obj) {
        FinOmegaSDK.putGlobalKV(str, obj);
    }

    public void removeGlobal(String str) {
        FinOmegaSDK.removeGlobalKV(str);
    }

    public void putWalletGlobal(String str, Object obj) {
        if (f32440b == null) {
            f32440b = new HashMap();
        }
        f32440b.put(str, obj);
    }

    public void removeWalletGlobal(String str) {
        Map<String, Object> map = f32440b;
        if (map != null) {
            map.remove(str);
        }
    }

    public void trackEventWithWalletGlobal(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            createEvent(str).attrs(f32440b).track();
            return;
        }
        map.putAll(f32440b);
        createEvent(str).attrs(map).track();
    }
}
