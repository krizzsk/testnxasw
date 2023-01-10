package com.didi.payment.transfer.utils;

import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.transfer.DebugUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransOmegaUtil {

    /* renamed from: a */
    private static Map<String, Object> f34033a = new HashMap();

    /* renamed from: b */
    private static Set<String> f34034b;

    static {
        HashSet hashSet = new HashSet();
        f34034b = hashSet;
        hashSet.add(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
        f34034b.add(TransGlobalOmegaKey.KEY_WALLET_PAGEID);
        f34034b.add(TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS);
        f34034b.add(TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
    }

    public static void trackEvent(String str) {
        m25937a(str, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, String str2, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, obj);
        m25937a(str, hashMap);
    }

    public static void trackEventWithGlobal(String str, String... strArr) {
        trackEventWithGlobal(str, (Map<String, Object>) null, strArr);
    }

    public static void trackEventWithGlobal(String str, Map<String, Object> map, String... strArr) {
        HashMap hashMap = new HashMap();
        if (!CollectionUtil.isEmpty((Map<?, ?>) map)) {
            for (String next : map.keySet()) {
                hashMap.put(next, map.get(next));
            }
        }
        for (String str2 : strArr) {
            if (!f34034b.contains(str2) || !f34033a.containsKey(str2)) {
                hashMap.put(str2, "");
            } else {
                hashMap.put(str2, f34033a.get(str2));
            }
        }
        if (DebugUtil.isAppInDebugMode()) {
            DebugUtil.justLog("Trans_Omega eventId: %s, params: %s", str, m25936a(hashMap));
        }
        FinOmegaSDK.trackEvent(str, hashMap);
    }

    /* renamed from: a */
    private static String m25936a(Map<String, Object> map) {
        if (CollectionUtil.isEmpty((Map<?, ?>) map)) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Const.joLeft);
        for (String next : map.keySet()) {
            sb.append(next);
            sb.append(":");
            sb.append(map.get(next));
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void trackEvent(String str, String str2, Object obj, String str3, Object obj2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, obj);
        hashMap.put(str3, obj2);
        m25937a(str, hashMap);
    }

    /* renamed from: a */
    private static void m25937a(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (!CollectionUtil.isEmpty((Map<?, ?>) f34033a)) {
            for (String next : f34033a.keySet()) {
                map.put(next, f34033a.get(next));
            }
        }
        if (DebugUtil.isAppInDebugMode()) {
            DebugUtil.justLog("Trans_Omega eventId: %s, params: %s", str, m25936a(map));
        }
        FinOmegaSDK.trackEvent(str, map);
    }

    public static void addGlobalParam(String str, Object obj) {
        f34033a.put(str, obj);
    }

    public static void removeGlobalParam(String str) {
        f34033a.remove(str);
    }

    public static void clearGlobalParams() {
        f34033a.clear();
    }

    public static void trackEvent(String str, String str2, Object obj, String str3, Object obj2, String str4, Object obj3, String str5, Object obj4) {
        HashMap hashMap = new HashMap();
        hashMap.put(str2, obj);
        hashMap.put(str3, obj2);
        hashMap.put(str4, obj3);
        hashMap.put(str5, obj4);
        m25937a(str, hashMap);
    }

    public static void addOmegaGlobalParam(String str, Object obj) {
        FinOmegaSDK.putGlobalKV(str, obj);
    }
}
