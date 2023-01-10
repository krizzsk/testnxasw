package com.kwai.koom.javaoom.common;

import android.app.Application;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.kwai.koom.javaoom.common.KConstants;

public class KVData {

    /* renamed from: a */
    private static boolean f58451a;

    /* renamed from: b */
    private static SharedPreferences f58452b;

    /* renamed from: c */
    private static SharedPreferences f58453c;

    public static void init() {
        Application application = KGlobalConfig.getApplication();
        f58452b = SystemUtils.getSharedPreferences(application, KConstants.C21298SP.TRIGGER_TIMES_NAME, 0);
        f58453c = SystemUtils.getSharedPreferences(application, KConstants.C21298SP.FIRST_LAUNCH_TIME_NAME, 0);
        f58451a = true;
    }

    public static void addTriggerTime(String str) {
        if (!f58451a) {
            init();
        }
        f58452b.edit().putInt(str, getTriggerTimes(str) + 1).apply();
    }

    public static int getTriggerTimes(String str) {
        if (!f58451a) {
            init();
        }
        return f58452b.getInt(str, 0);
    }

    public static long firstLaunchTime(String str) {
        if (!f58451a) {
            init();
        }
        long j = f58453c.getLong(str, 0);
        if (j != 0) {
            return j;
        }
        long currentTimeMillis = System.currentTimeMillis();
        f58453c.edit().putLong(str, currentTimeMillis).apply();
        return currentTimeMillis;
    }
}
