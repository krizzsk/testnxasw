package com.didi.trackupload.sdk.core;

public class UploadFlags {
    public static final long FLAG_SEND_TYPE_HTTP = 16;
    public static final long FLAG_SEND_TYPE_PUSH = 8;
    public static final long FLAG_TRY_ONCE_LOCATE = 4;

    /* renamed from: a */
    static final long f46578a = 2;

    /* renamed from: b */
    static final long f46579b = 65536;

    /* renamed from: c */
    static final long f46580c = 131072;

    /* renamed from: d */
    static final long f46581d = 262144;

    /* renamed from: e */
    private static final long f46582e = 1;

    /* renamed from: f */
    private static final long f46583f = 32768;

    public static boolean hasFlag(long j, long j2) {
        return (j & j2) != 0;
    }

    /* renamed from: a */
    static long m34754a(long... jArr) {
        long j = 0;
        if (jArr != null && jArr.length > 0) {
            for (long j2 : jArr) {
                j |= j2;
            }
        }
        return j;
    }

    /* renamed from: a */
    static boolean m34755a(long j, long... jArr) {
        if (jArr == null || jArr.length <= 0) {
            return true;
        }
        for (long j2 : jArr) {
            if ((j2 & j) == 0) {
                return false;
            }
        }
        return true;
    }
}
