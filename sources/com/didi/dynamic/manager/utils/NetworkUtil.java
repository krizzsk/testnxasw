package com.didi.dynamic.manager.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkUtil {
    public static final int NET_TYPE_2G = 2;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_4G = 5;
    public static final int NET_TYPE_MOBILE = 4;
    public static final int NET_TYPE_NONE = -1;
    public static final int NET_TYPE_WIFI = 1;

    /* renamed from: a */
    private static final String f21246a = "DM.NetworkUtil";

    /* renamed from: b */
    private static final boolean f21247b = false;

    /* renamed from: c */
    private static final int f21248c = 6;

    /* renamed from: d */
    private static final int f21249d = 9;

    /* renamed from: e */
    private static final int f21250e = 2;

    /* renamed from: f */
    private static final int f21251f = 7;

    /* renamed from: g */
    private static final int f21252g = 12;

    /* renamed from: h */
    private static final int f21253h = 13;

    /* renamed from: i */
    private static final int f21254i = 14;

    /* renamed from: j */
    private static final int f21255j = 15;

    /* renamed from: k */
    private static ConnectivityManager f21256k = null;

    /* renamed from: l */
    private static volatile int f21257l = -1;

    /* renamed from: a */
    private static ConnectivityManager m17950a(Context context) {
        if (f21256k == null) {
            f21256k = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f21256k;
    }

    public static int getNetworkType(Context context) {
        ConnectivityManager a = m17950a(context);
        if (a == null) {
            f21257l = -1;
            return -1;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception unused) {
        }
        if (networkInfo != null) {
            int type = networkInfo.getType();
            int subtype = networkInfo.getSubtype();
            if (type == 1 || type == 6 || type == 9) {
                f21257l = 1;
                return 1;
            } else if (type == 0 || (type == 7 && subtype > 0)) {
                if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) {
                    f21257l = 3;
                    return 3;
                } else if (subtype == 13) {
                    f21257l = 5;
                    return 5;
                } else {
                    f21257l = 2;
                    return 2;
                }
            } else if (type == 2 || type == 7) {
                f21257l = -1;
                return -1;
            } else {
                f21257l = 2;
                return 2;
            }
        } else {
            f21257l = -1;
            return -1;
        }
    }

    public static int getSimpleNetworkType(Context context) {
        ConnectivityManager a = m17950a(context);
        if (a == null) {
            f21257l = -1;
            return -1;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception unused) {
        }
        if (networkInfo != null) {
            int type = networkInfo.getType();
            if (type == 1 || type == 6 || type == 9) {
                f21257l = 1;
                return 1;
            } else if (type == 0) {
                f21257l = 4;
                return 4;
            } else if (type == 2 || type == 7) {
                f21257l = -1;
                return -1;
            } else {
                f21257l = 4;
                return 4;
            }
        } else {
            f21257l = -1;
            return -1;
        }
    }

    public static boolean isNetworkAvaialble(Context context) {
        ConnectivityManager a = m17950a(context);
        if (a == null) {
            return false;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception e) {
            Log.m17933w(f21246a, (Throwable) e);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static String m17951b(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager a = m17950a(context);
        if (a == null) {
            return null;
        }
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            String hostAddress = nextElement.getHostAddress();
                            if (!nextElement.isLoopbackAddress() && !TextUtils.isEmpty(hostAddress)) {
                                return hostAddress;
                            }
                        }
                    }
                }
            } catch (SocketException e) {
                Log.m17931w(f21246a, "Failed to get network IP with exception: " + e);
            }
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m17952c(Context context) {
        ConnectivityManager a = m17950a(context);
        if (a == null) {
            return false;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = SystemUtils.getActiveNetworkInfo(a);
        } catch (Exception unused) {
        }
        if (networkInfo == null || networkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkWifi(Context context) {
        return getSimpleNetworkType(context) == 1;
    }

    public static int getLastNetworkType() {
        return f21257l;
    }
}
