package com.didi.onehybrid.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;

public class NetworkUtil {
    public static final int NET_TYPE_2G = 2;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_4G = 5;
    public static final int NET_TYPE_MOBILE = 4;
    public static final int NET_TYPE_NONE = -1;
    public static final int NET_TYPE_WIFI = 1;

    /* renamed from: a */
    private static final String f32195a = "NetworkUtil";

    /* renamed from: b */
    private static final boolean f32196b = false;

    /* renamed from: c */
    private static final int f32197c = 6;

    /* renamed from: d */
    private static final int f32198d = 9;

    /* renamed from: e */
    private static final int f32199e = 2;

    /* renamed from: f */
    private static final int f32200f = 7;

    /* renamed from: g */
    private static final int f32201g = 12;

    /* renamed from: h */
    private static final int f32202h = 13;

    /* renamed from: i */
    private static final int f32203i = 14;

    /* renamed from: j */
    private static final int f32204j = 15;

    /* renamed from: k */
    private static ConnectivityManager f32205k;

    /* renamed from: a */
    private static ConnectivityManager m24478a(Context context) {
        if (f32205k == null) {
            try {
                f32205k = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Exception unused) {
                f32205k = null;
            }
        }
        return f32205k;
    }

    public static int getSimpleNetworkType(Context context) {
        ConnectivityManager a = m24478a(context);
        if (a == null) {
            return -1;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception unused) {
        }
        if (networkInfo == null) {
            return -1;
        }
        int type = networkInfo.getType();
        if (type == 1 || type == 6 || type == 9) {
            return 1;
        }
        if (type == 0) {
            return 4;
        }
        if (type == 2 || type == 7) {
            return -1;
        }
        return 4;
    }

    public static boolean isNetworkWifi(Context context) {
        return getSimpleNetworkType(context) == 1;
    }

    public static boolean isAvailable(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }
}
