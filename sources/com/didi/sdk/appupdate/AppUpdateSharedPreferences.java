package com.didi.sdk.appupdate;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class AppUpdateSharedPreferences {

    /* renamed from: a */
    private static final String f38020a = "app_update_sp";

    /* renamed from: b */
    private static final String f38021b = "app_update_sp_last_time";

    /* renamed from: c */
    private final Context f38022c;

    /* renamed from: d */
    private final SharedPreferences f38023d;

    /* renamed from: e */
    private final SharedPreferences.Editor f38024e;

    public AppUpdateSharedPreferences(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f38022c = applicationContext;
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(applicationContext, f38020a, 0);
        this.f38023d = sharedPreferences;
        this.f38024e = sharedPreferences.edit();
    }

    public void setAppUpdateLastTime(long j) {
        this.f38024e.putLong(f38021b, j).commit();
    }

    public long getAppUpdateLastTime() {
        return this.f38023d.getLong(f38021b, 0);
    }
}
