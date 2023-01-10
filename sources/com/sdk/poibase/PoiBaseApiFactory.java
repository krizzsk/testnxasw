package com.sdk.poibase;

import android.content.Context;
import com.didi.sdk.util.SystemUtil;

public class PoiBaseApiFactory {
    @Deprecated
    public static IPoiBaseApi createDidiApi(Context context, PoiBizType poiBizType) {
        return createDidiApi(context);
    }

    public static IPoiBaseApi createDidiApi(Context context) {
        if (context != null) {
            SystemUtil.init(context);
            return C21489a.m44428a(context.getApplicationContext());
        }
        throw new RuntimeException("context is null");
    }
}
