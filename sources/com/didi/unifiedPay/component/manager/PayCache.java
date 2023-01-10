package com.didi.unifiedPay.component.manager;

import java.util.HashMap;

public class PayCache {

    /* renamed from: b */
    private static PayCache f47023b = null;

    /* renamed from: c */
    private static final String f47024c = "LAST_PAY_FAILED_SHOW";

    /* renamed from: a */
    private HashMap<String, Object> f47025a = new HashMap<>();

    public static synchronized PayCache getInstance() {
        PayCache payCache;
        synchronized (PayCache.class) {
            if (f47023b == null) {
                f47023b = new PayCache();
            }
            payCache = f47023b;
        }
        return payCache;
    }

    public void setLastPayFailShowed(String str) {
        HashMap<String, Object> hashMap = this.f47025a;
        hashMap.put(f47024c + str, 1);
    }

    public boolean isLastPayFailShow(String str) {
        HashMap<String, Object> hashMap = this.f47025a;
        return hashMap.containsKey(f47024c + str);
    }
}
