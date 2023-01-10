package com.didi.dimina.webview.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;

public class NetworkUtil {
    public static final int NET_TYPE_2G = 2;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_4G = 5;
    public static final int NET_TYPE_5G = 6;
    public static final int NET_TYPE_MOBILE = 4;
    public static final int NET_TYPE_NONE = -1;
    public static final int NET_TYPE_UNKNOWN = -2;
    public static final int NET_TYPE_WIFI = 1;

    /* renamed from: a */
    private static final String f20293a = "NetworkUtil";

    /* renamed from: b */
    private static final boolean f20294b = false;

    /* renamed from: c */
    private static final int f20295c = 6;

    /* renamed from: d */
    private static final int f20296d = 9;

    /* renamed from: e */
    private static final int f20297e = 2;

    /* renamed from: f */
    private static final int f20298f = 7;

    /* renamed from: g */
    private static final int f20299g = 12;

    /* renamed from: h */
    private static final int f20300h = 13;

    /* renamed from: i */
    private static final int f20301i = 14;

    /* renamed from: j */
    private static final int f20302j = 15;

    /* renamed from: k */
    private static ConnectivityManager f20303k;

    /* renamed from: a */
    private static ConnectivityManager m17108a(Context context) {
        if (f20303k == null) {
            try {
                f20303k = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Exception unused) {
                f20303k = null;
            }
        }
        return f20303k;
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equalsIgnoreCase("WIFI")) {
                return 1;
            }
            if (typeName.equalsIgnoreCase("MOBILE")) {
                return m17109b(context);
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0054 A[RETURN] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m17109b(android.content.Context r5) {
        /*
            java.lang.String r5 = com.didi.dimina.webview.util.WsgSafeUtil.getNetworkType(r5)
            int r0 = r5.hashCode()
            r1 = 1621(0x655, float:2.272E-42)
            r2 = 1
            r3 = 3
            r4 = 2
            if (r0 == r1) goto L_0x003a
            r1 = 1652(0x674, float:2.315E-42)
            if (r0 == r1) goto L_0x0030
            r1 = 1683(0x693, float:2.358E-42)
            if (r0 == r1) goto L_0x0026
            r1 = 1714(0x6b2, float:2.402E-42)
            if (r0 == r1) goto L_0x001c
            goto L_0x0044
        L_0x001c:
            java.lang.String r0 = "5G"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0044
            r5 = 3
            goto L_0x0045
        L_0x0026:
            java.lang.String r0 = "4G"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0044
            r5 = 2
            goto L_0x0045
        L_0x0030:
            java.lang.String r0 = "3G"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0044
            r5 = 1
            goto L_0x0045
        L_0x003a:
            java.lang.String r0 = "2G"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0044
            r5 = 0
            goto L_0x0045
        L_0x0044:
            r5 = -1
        L_0x0045:
            if (r5 == 0) goto L_0x0054
            if (r5 == r2) goto L_0x0053
            if (r5 == r4) goto L_0x0051
            if (r5 == r3) goto L_0x004f
            r5 = -2
            return r5
        L_0x004f:
            r5 = 6
            return r5
        L_0x0051:
            r5 = 5
            return r5
        L_0x0053:
            return r3
        L_0x0054:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.util.NetworkUtil.m17109b(android.content.Context):int");
    }

    public static int getSimpleNetworkType(Context context) {
        ConnectivityManager a = m17108a(context);
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
