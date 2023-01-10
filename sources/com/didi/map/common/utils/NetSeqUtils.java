package com.didi.map.common.utils;

import com.didi.hawaii.utils.Md5Util;
import java.util.concurrent.atomic.AtomicInteger;

public final class NetSeqUtils {

    /* renamed from: a */
    private static final int f26936a = 10;

    /* renamed from: b */
    private static String f26937b;

    /* renamed from: c */
    private static boolean f26938c;

    /* renamed from: d */
    private static AtomicInteger f26939d;

    private NetSeqUtils() {
    }

    public static void init() {
        f26937b = m21243a();
        f26939d = new AtomicInteger(0);
        f26938c = true;
    }

    public static boolean isInited() {
        return f26938c;
    }

    /* renamed from: a */
    private static String m21243a() {
        String obtainIMei = SystemUtil.obtainIMei();
        StringBuilder sb = new StringBuilder(obtainIMei.length() + 20);
        sb.append(obtainIMei);
        String l = Long.toString(System.currentTimeMillis());
        int length = l.length();
        sb.append(l.substring(length - 10, length));
        sb.append((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E9d));
        return Md5Util.getMD5(sb.toString());
    }

    public static String getSessionId() {
        return f26937b;
    }

    public static String getSeqNumber() {
        if (f26939d == null) {
            return "";
        }
        return f26939d.incrementAndGet() + "";
    }
}
