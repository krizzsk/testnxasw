package com.didi.payment.base.utils;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.Map;

public class PayLogUtils {

    /* renamed from: a */
    private static final boolean f32469a = true;

    /* renamed from: b */
    private static boolean f32470b = false;

    /* renamed from: c */
    private static String f32471c = "PayLog";

    /* renamed from: a */
    private static void m24616a(int i, String str, String str2) {
    }

    /* renamed from: v */
    public static void m24624v(String str, String str2, String str3) {
        String format = String.format("[%s] %s", new Object[]{str2, str3});
        m24616a(2, str, format);
        LoggerFactory.getLogger(f32471c).trace("[%s] %s", str, format);
    }

    /* renamed from: d */
    public static void m24617d(String str, String str2) {
        m24618d(str, "", str2);
    }

    /* renamed from: d */
    public static void m24618d(String str, String str2, String str3) {
        String format = String.format("[%s] %s", new Object[]{str2, str3});
        m24616a(3, str, format);
        LoggerFactory.getLogger(f32471c).debug("[%s] %s", str, format);
    }

    /* renamed from: i */
    public static void m24623i(String str, String str2, String str3) {
        String format = String.format("[%s] %s", new Object[]{str2, str3});
        m24616a(4, str, format);
        LoggerFactory.getLogger(f32471c).info("[%s] %s", str, format);
    }

    /* renamed from: w */
    public static void m24625w(String str, String str2, String str3) {
        String format = String.format("[%s] %s", new Object[]{str2, str3});
        m24616a(5, str, format);
        LoggerFactory.getLogger(f32471c).warn("[%s] %s", str, format);
    }

    /* renamed from: e */
    public static void m24620e(String str, String str2) {
        m24621e(str, "", str2);
    }

    /* renamed from: e */
    public static void m24621e(String str, String str2, String str3) {
        String format = String.format("[%s] %s", new Object[]{str2, str3});
        m24616a(6, str, format);
        LoggerFactory.getLogger(f32471c).error("[%s] %s", str, format);
    }

    /* renamed from: e */
    public static void m24622e(String str, String str2, String str3, Throwable th) {
        String format = String.format("[%s] %s %s", new Object[]{str2, str3, Log.getStackTraceString(th)});
        m24616a(6, str, format);
        LoggerFactory.getLogger(f32471c).error("[%s] %s", str, format);
    }

    /* renamed from: d */
    public static void m24619d(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.joLeft);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                Object key = next.getKey();
                Object value = next.getValue();
                sb.append(key);
                sb.append(":");
                sb.append(value);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");
        String sb2 = sb.toString();
        m24616a(3, str, sb2);
        LoggerFactory.getLogger(f32471c).debug("[%s] %s", str, sb2);
    }

    public static void setDebug(boolean z) {
        String str = f32471c;
        SystemUtils.log(4, str, "set debug to " + z, (Throwable) null, "com.didi.payment.base.utils.PayLogUtils", 113);
        f32470b = z;
    }
}
