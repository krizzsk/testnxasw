package com.didi.global.ninja.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import com.didi.sdk.apm.SystemUtils;

public class SharedPreferencesUtils {

    /* renamed from: a */
    private static final String f24802a = "#";

    /* renamed from: b */
    private static final String f24803b = "ninja-sp";

    /* renamed from: e */
    private static volatile SharedPreferencesUtils f24804e;

    /* renamed from: c */
    private Context f24805c;

    /* renamed from: d */
    private String f24806d = "";

    private SharedPreferencesUtils(Context context) {
        this.f24805c = context.getApplicationContext();
        try {
            this.f24806d = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SharedPreferencesUtils getInstance(Context context) {
        if (f24804e == null) {
            synchronized (SharedPreferencesUtils.class) {
                if (f24804e == null) {
                    f24804e = new SharedPreferencesUtils(context);
                }
            }
        }
        return f24804e;
    }

    public void writeSPInt(String str, int i) {
        SystemUtils.getSharedPreferences(this.f24805c, m19882a(), 0).edit().putInt(str, i).commit();
    }

    public int readSPInt(String str, int i) {
        return SystemUtils.getSharedPreferences(this.f24805c, m19882a(), 0).getInt(str, i);
    }

    public void writeSPLong(String str, long j) {
        SystemUtils.getSharedPreferences(this.f24805c, m19882a(), 0).edit().putLong(str, j).commit();
    }

    public long readSPLong(String str, long j) {
        return SystemUtils.getSharedPreferences(this.f24805c, m19882a(), 0).getLong(str, j);
    }

    /* renamed from: a */
    private String m19882a() {
        return "ninja-sp#" + this.f24806d;
    }
}
