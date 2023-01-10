package com.didichuxing.sofa.permission;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class RequestCodeManager {

    /* renamed from: a */
    private static AtomicInteger f51716a = new AtomicInteger(0);

    /* renamed from: b */
    private static Map<String[], Integer> f51717b = new HashMap();

    /* renamed from: a */
    private static boolean m38869a(int i) {
        return i <= 0;
    }

    private RequestCodeManager() {
    }

    /* renamed from: a */
    private static int m38868a() {
        if (f51716a.get() >= 20) {
            f51716a.set(0);
        }
        return f51716a.incrementAndGet();
    }

    public static int get(String... strArr) {
        int intValue = f51717b.containsKey(strArr) ? f51717b.get(strArr).intValue() : 0;
        if (!m38869a(intValue)) {
            return intValue;
        }
        int a = m38868a();
        f51717b.put(strArr, Integer.valueOf(a));
        return a;
    }
}
