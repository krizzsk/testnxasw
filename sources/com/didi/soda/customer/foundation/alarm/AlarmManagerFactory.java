package com.didi.soda.customer.foundation.alarm;

import android.os.Build;

public final class AlarmManagerFactory {

    /* renamed from: a */
    private static volatile AlarmAdapter f43496a;

    private AlarmManagerFactory() {
    }

    public static AlarmAdapter getAdapter() {
        if (f43496a == null) {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            if ("HUAWEI".equalsIgnoreCase(str)) {
                f43496a = new AlarmCustomAdapter();
            } else if ("Xiaomi".equalsIgnoreCase(str)) {
                f43496a = new AlarmCustomAdapter();
            } else {
                if ((str2.startsWith("MI") && str2.compareTo("MI 2") >= 0) || str2.equals("K-Touch S2")) {
                    f43496a = new AlarmCustomAdapter();
                }
                f43496a = new AlarmAdapter();
            }
        }
        return f43496a;
    }
}
