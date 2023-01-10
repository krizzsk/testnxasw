package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import android.content.Context;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationStrategyFactory */
public class LocationStrategyFactory {
    private LocationStrategyFactory() {
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationStrategyFactory$SingletonHolder */
    private static class SingletonHolder {
        static LocationStrategyFactory INSTANCE = new LocationStrategyFactory();

        private SingletonHolder() {
        }
    }

    public static LocationStrategyFactory getIntance() {
        return SingletonHolder.INSTANCE;
    }

    public C15953c createLocationStrategy(Context context, int i) {
        if (i == 0) {
            DLog.m36225d("loc type wgs84");
            return new C15952b(context);
        }
        DLog.m36225d("loc type gcj02");
        return new C15952b(context);
    }
}
