package com.didi.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class CacheSharedPreferences {

    /* renamed from: a */
    private static CacheSharedPreferences f40280a;

    /* renamed from: c */
    private static Context f40281c;

    /* renamed from: b */
    private String f40282b = "h5_native_cache";

    /* renamed from: d */
    private SharedPreferences f40283d;

    /* renamed from: e */
    private SharedPreferences.Editor f40284e;

    private CacheSharedPreferences() {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(f40281c, "h5_native_cache", 0);
        this.f40283d = sharedPreferences;
        this.f40284e = sharedPreferences.edit();
    }

    public static synchronized CacheSharedPreferences getInstance() {
        CacheSharedPreferences cacheSharedPreferences;
        synchronized (CacheSharedPreferences.class) {
            if (f40280a == null) {
                f40280a = new CacheSharedPreferences();
            }
            cacheSharedPreferences = f40280a;
        }
        return cacheSharedPreferences;
    }

    public static void init(Context context) {
        f40281c = context;
    }

    public void setNativeCache(String str, String str2) {
        this.f40284e.putString(str, str2).apply();
    }

    public String getNativeCache(String str) {
        return this.f40283d.getString(str, "[]");
    }
}
