package com.didi.map.sdk.sharetrack.google.inner.utils;

import android.text.TextUtils;
import java.util.HashSet;

public class OraErrorCodeUtil {
    public static final String ETA_EDA_TIMEOUT = "30071";
    public static final String ROUTE_PLAN_TIMEOUT = "30070";

    /* renamed from: a */
    private static HashSet<String> f31357a;

    static {
        HashSet<String> hashSet = new HashSet<>();
        f31357a = hashSet;
        hashSet.add(ROUTE_PLAN_TIMEOUT);
        f31357a.add(ETA_EDA_TIMEOUT);
    }

    public static boolean canBeRetry(String str) {
        if (!TextUtils.isEmpty(str) && f31357a.contains(str)) {
            return true;
        }
        return false;
    }
}
