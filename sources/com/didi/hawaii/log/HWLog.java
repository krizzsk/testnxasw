package com.didi.hawaii.log;

import com.didi.hawaii.basic.ApolloHawaii;

public final class HWLog {

    /* renamed from: BM */
    public static final int f25700BM = 1;
    public static final String BUFFER_ID = "hawaii";
    public static final byte TYPE_ORDER_ROUTE_PB = 1;
    public static final byte TYPE_OTHER = Byte.MAX_VALUE;
    public static final byte TYPE_TRAFFIC_PB = 3;

    /* renamed from: a */
    private static int f25701a = 4;

    /* renamed from: b */
    private static int f25702b = 4;

    /* renamed from: c */
    private static int f25703c = 4;

    /* renamed from: d */
    private static int f25704d = 4;

    /* renamed from: e */
    private static final String f25705e = "HWLog";

    /* renamed from: f */
    private static final boolean f25706f = ApolloHawaii.isUseOneLogger();

    /* renamed from: g */
    private static final String[] f25707g = {"", "UnKnown/", "V/", "D/", "I/", "W/", "E/"};

    /* renamed from: h */
    private static HWLogCallback f25708h = null;

    /* renamed from: a */
    private static boolean m20429a(int i, int i2) {
        return i >= i2;
    }

    public static void setCallback(HWLogCallback hWLogCallback) {
    }

    private HWLog() {
    }

    public static void initControlLevel(int i, int i2, int i3, int i4) {
        f25701a = i;
        f25702b = i2;
        f25703c = i3;
        f25704d = i4;
    }

    public static int getJniLogControl() {
        return f25704d;
    }

    public static boolean jniLogOpen() {
        return f25704d <= 6;
    }

    /* renamed from: v */
    public static void m20434v(int i, String str, String str2) {
        m20427a(i, 2, str, str2);
    }

    /* renamed from: d */
    public static void m20430d(int i, String str, String str2) {
        m20427a(i, 3, str, str2);
    }

    /* renamed from: d */
    public static void m20431d(String str, String str2) {
        m20430d(1, str, str2);
    }

    /* renamed from: i */
    public static void m20433i(String str, String str2) {
        m20427a(1, 4, str, str2);
    }

    /* renamed from: w */
    public static void m20435w(int i, String str, String str2) {
        m20427a(i, 5, str, str2);
    }

    /* renamed from: e */
    public static void m20432e(int i, String str, String str2) {
        m20427a(i, 6, str, str2);
    }

    public static void printNative(int i, String str) {
        HWLogCallback hWLogCallback = f25708h;
        if (hWLogCallback == null) {
            C9701c.m20455c(str);
        } else {
            m20428a("JNI", i, str, hWLogCallback);
        }
    }

    public static void binary_i(byte b, byte[] bArr, long j) {
        m20426a(b, 4, bArr, j);
    }

    /* renamed from: a */
    private static void m20427a(int i, int i2, String str, String str2) {
        HWLogCallback hWLogCallback = f25708h;
        if (hWLogCallback != null) {
            m20428a(str, i, str2, hWLogCallback);
        } else if (m20429a(i2, f25702b)) {
            C9701c.m20451a(str, str2);
        }
    }

    /* renamed from: a */
    private static void m20428a(String str, int i, String str2, HWLogCallback hWLogCallback) {
        if (i == 1 && f25706f) {
            hWLogCallback.onLog(str2);
        }
    }

    /* renamed from: a */
    private static void m20426a(byte b, int i, byte[] bArr, long j) {
        if (m20429a(i, f25703c)) {
            C9699a.m20440a(bArr, b, j);
        }
    }
}
