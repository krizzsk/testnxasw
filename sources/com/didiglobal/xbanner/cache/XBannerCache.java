package com.didiglobal.xbanner.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class XBannerCache {

    /* renamed from: a */
    private static final String f54014a = "XBannerCache";

    /* renamed from: b */
    private static volatile XBannerCache f54015b = null;

    /* renamed from: c */
    private static final String f54016c = "X_BANNER_SHARED_PRES";

    /* renamed from: d */
    private SharedPreferences f54017d;

    private XBannerCache(Context context) {
        this.f54017d = SystemUtils.getSharedPreferences(context, f54016c, 0);
    }

    public static XBannerCache getInstance(Context context) {
        if (f54015b == null) {
            synchronized (XBannerCache.class) {
                if (f54015b == null) {
                    f54015b = new XBannerCache(context);
                }
            }
        }
        return f54015b;
    }

    public void setExpandNowCount(String str, int i) {
        int i2 = this.f54017d.getInt(str, 0);
        SystemUtils.log(6, f54014a, "displayCount:" + i + "count:" + i2, (Throwable) null, "com.didiglobal.xbanner.cache.XBannerCache", 33);
        int i3 = i == -1 ? i : i2 + 1;
        if (i3 <= i + 1) {
            this.f54017d.edit().putInt(str, i3).apply();
        }
    }

    public boolean isExpandNeedShow(String str, int i) {
        int i2 = this.f54017d.getInt(str, 0);
        SystemUtils.log(6, f54014a, "displayCount:" + i + "tempCount:" + i2, (Throwable) null, "com.didiglobal.xbanner.cache.XBannerCache", 42);
        if (i2 < 0 || i < 0) {
            return true;
        }
        if (i != 0 && i2 < i) {
            return true;
        }
        return false;
    }
}
