package com.didi.mapbizinterface.utils;

import com.didichuxing.apollo.sdk.Apollo;

public class ApolloUtils {

    /* renamed from: a */
    private static final String f31540a = "map_biz_interface_debug_log";

    public static boolean isDebugLogEnabled() {
        return Apollo.getToggle(f31540a).allow();
    }
}
