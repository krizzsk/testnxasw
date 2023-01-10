package com.didi.sdk.appsflyer;

import com.didi.sdk.util.AppUtils;

public class AppsFlyerUtil {

    /* renamed from: a */
    private static final String f38008a = "appsflyer_id";

    public static String getAppsFlyerKey() {
        String metaDataByKey = AppUtils.getMetaDataByKey(f38008a);
        return metaDataByKey == null ? "" : metaDataByKey;
    }
}
