package com.didichuxing.afanty.common.collector;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.p172v2.store.IStoreCallback;
import com.yanzhenjie.permission.runtime.Permission;

public class NetworkCollector {

    /* renamed from: a */
    private static ConnectivityManager f48212a;

    /* renamed from: b */
    private static Context f48213b;

    /* renamed from: c */
    private static TelephonyManager f48214c;

    public static void init(Context context) {
        f48213b = context;
    }

    public static String getNetworkType() {
        try {
            if (f48212a == null) {
                f48212a = (ConnectivityManager) f48213b.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(f48212a);
            if (activeNetworkInfo == null) {
                return "UNKNOWN";
            }
            if (!activeNetworkInfo.isConnected()) {
                return IStoreCallback.DEFAULT_API_DETAIL_KEY;
            }
            return activeNetworkInfo.getTypeName().toUpperCase();
        } catch (Throwable unused) {
            return "UNKNOWN";
        }
    }

    public static boolean isAvailable(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    public static String getIMSI(String str) {
        try {
            if (f48213b.checkCallingOrSelfPermission(Permission.READ_PHONE_STATE) != 0) {
                return str;
            }
            if (f48214c == null) {
                f48214c = (TelephonyManager) f48213b.getSystemService("phone");
            }
            return f48214c.getSubscriberId();
        } catch (Exception unused) {
            return "";
        }
    }
}
