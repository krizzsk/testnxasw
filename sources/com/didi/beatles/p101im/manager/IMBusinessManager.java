package com.didi.beatles.p101im.manager;

import com.didi.beatles.p101im.utils.IMLog;
import com.threatmetrix.TrustDefender.qqqqqy;

/* renamed from: com.didi.beatles.im.manager.IMBusinessManager */
public class IMBusinessManager {
    public static final int IM_PRODUCTID_BEALES = 259;
    public static final int IM_PRODUCTID_CP = 283;
    public static final int IM_PRODUCTID_QUICK = 260;
    public static final int IM_PRODUCTID_QUICK_DRIVER = 2601;
    public static final int IM_PRODUCTID_SPECIAL = 258;
    public static final int IM_PRODUCTID_TAXI = 257;
    public static final int IM_PRODUCTID_TDC = 276;
    public static final int IM_PRODUCTID_T_DRIVER = 268;
    public static final int IM_PRODUCTID_UBERPP = 281;
    public static final int IM_PRODUCTID_UBERX = 280;

    /* renamed from: a */
    private static long f11072a = 256;

    /* renamed from: b */
    private static long f11073b = 128;

    /* renamed from: c */
    private static long f11074c = 64;

    /* renamed from: d */
    private static long f11075d = 32;

    /* renamed from: e */
    private static long f11076e = 16;

    /* renamed from: f */
    private static long f11077f = 8;

    /* renamed from: g */
    private static long f11078g = 18014398509481984L;

    /* renamed from: h */
    private static long f11079h = 33;

    /* renamed from: i */
    private static long f11080i = 34;

    /* renamed from: j */
    private static long f11081j = 562949953421312L;

    /* renamed from: k */
    private static long f11082k = 281474976710656L;

    /* renamed from: l */
    private static long f11083l = 4222124650659840L;

    /* renamed from: m */
    private static long f11084m = 281474976710656L;

    /* renamed from: n */
    private static long f11085n = (qqqqqy.baaa0061aa - 1);

    /* renamed from: o */
    private static final long f11086o = 9218868437227405312L;

    /* renamed from: p */
    private static final long f11087p = 4503599627370496L;

    public static int getBusinessId(long j) {
        if (j < 65536) {
            return 259;
        }
        long j2 = (j & f11086o) / f11087p;
        long j3 = f11072a;
        if (j2 == j3) {
            return 259;
        }
        if (j2 == f11074c) {
            return 258;
        }
        if (j2 == f11073b) {
            return 260;
        }
        if (j2 == f11075d) {
            return 257;
        }
        if (j2 == f11076e) {
            return 280;
        }
        if (j2 == j3) {
            return 268;
        }
        if (j2 == f11077f) {
            return 281;
        }
        if (j2 == f11079h) {
            return 283;
        }
        if (j2 == f11080i) {
            return 276;
        }
        return (int) j2;
    }

    public static long generateSid(int i, long j) {
        long j2 = (j >> 48) != 1 ? 50 : 49;
        long a = m9633a(i);
        if (a != 0) {
            return (j & f11085n) | (a * f11087p) | (1 << ((int) (j2 - 1)));
        }
        return -1;
    }

    public static long generateSid(int i, long j, boolean z) {
        long j2 = z ? 50 : 49;
        long a = m9633a(i);
        if (a != 0) {
            return (j & f11085n) | (a * f11087p) | (1 << ((int) (j2 - 1)));
        }
        IMLog.m10021e("IMEngine", "The businessId is 0 while generate sid !");
        return -1;
    }

    /* renamed from: a */
    private static long m9633a(int i) {
        if (i == 268) {
            return f11078g;
        }
        if (i == 276) {
            return f11080i;
        }
        if (i == 283) {
            return f11079h;
        }
        if (i == 280) {
            return f11076e;
        }
        if (i == 281) {
            return f11077f;
        }
        switch (i) {
            case 257:
                return f11075d;
            case 258:
                return f11074c;
            case 259:
                return f11072a;
            case 260:
                return f11073b;
            default:
                return (long) i;
        }
    }
}
