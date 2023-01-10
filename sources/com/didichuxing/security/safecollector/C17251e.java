package com.didichuxing.security.safecollector;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* renamed from: com.didichuxing.security.safecollector.e */
/* compiled from: NetworkCollector */
final class C17251e {

    /* renamed from: a */
    private static volatile boolean f51579a = false;

    /* renamed from: b */
    private static volatile boolean f51580b = false;

    C17251e() {
    }

    /* renamed from: a */
    public static String m38703a(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(0, 3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static String m38704b(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                return networkOperator.substring(3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static String m38705c(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: d */
    public static String m38706d(Context context) {
        try {
            if (C17249c.f51567b == null) {
                C17249c.f51567b = (TelephonyManager) context.getSystemService("phone");
            }
            return C17249c.f51567b.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }
}
