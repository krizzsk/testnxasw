package com.didi.hawaii.net.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.didi.hawaii.utils.StringUtil;
import com.didi.sdk.apm.SystemUtils;

public class HttpContext {

    /* renamed from: a */
    private static Context f26432a;

    /* renamed from: b */
    private static HttpContext f26433b;

    public static HttpContext getInstance() {
        if (f26433b == null) {
            f26433b = new HttpContext();
        }
        return f26433b;
    }

    private HttpContext() {
    }

    public void init(Context context) {
        f26432a = context.getApplicationContext();
    }

    public static boolean isInitialized() {
        return f26432a != null;
    }

    public static Context getContext() {
        return f26432a;
    }

    public static boolean isNetAvailable() {
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) getContext().getSystemService("connectivity"));
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWifi() {
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) getContext().getSystemService("connectivity"));
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isPorxyPrefer() {
        if (!isWifi() && !StringUtil.isEmpty(Proxy.getDefaultHost())) {
            return true;
        }
        return false;
    }

    public static boolean isWAPFeePage(String str) {
        return str != null && str.contains("vnd.wap.wml");
    }
}
