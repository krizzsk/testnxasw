package com.didi.entrega.customer.foundation.alarm;

import android.os.Build;

public final class AlarmManagerFactory {

    /* renamed from: a */
    private static volatile AlarmAdapter f21754a;

    private AlarmManagerFactory() {
    }

    public static AlarmAdapter getAdapter() {
        if (f21754a == null) {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            if ("HUAWEI".equalsIgnoreCase(str)) {
                f21754a = new AlarmCustomAdapter();
            } else if ("Xiaomi".equalsIgnoreCase(str)) {
                f21754a = new AlarmCustomAdapter();
            } else {
                if ((str2.startsWith("MI") && str2.compareTo("MI 2") >= 0) || str2.equals("K-Touch S2")) {
                    f21754a = new AlarmCustomAdapter();
                }
                f21754a = new AlarmAdapter();
            }
        }
        return f21754a;
    }
}
