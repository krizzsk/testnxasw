package com.didichuxing.mlcp.drtc.utils;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.didichuxing.mlcp.drtc.utils.b */
/* compiled from: ByteArrayAllocator */
public final class C16716b {

    /* renamed from: a */
    private static AtomicInteger f51016a = new AtomicInteger(0);

    /* renamed from: b */
    private static AtomicLong f51017b = new AtomicLong(0);

    /* renamed from: a */
    public static byte[] m38162a(int i) {
        byte[] bArr = null;
        if (!m38163b()) {
            return null;
        }
        try {
            bArr = new byte[i];
            m38161a();
            return bArr;
        } catch (OutOfMemoryError unused) {
            System.gc();
            try {
                bArr = new byte[i];
                m38161a();
                return bArr;
            } catch (OutOfMemoryError unused2) {
                f51016a.incrementAndGet();
                f51017b.set(SystemClock.elapsedRealtime());
                return bArr;
            }
        }
    }

    /* renamed from: b */
    private static boolean m38163b() {
        if (f51016a.get() <= 10) {
            return true;
        }
        long j = f51017b.get();
        if (j == 0 || SystemClock.elapsedRealtime() - j > 3000) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m38161a() {
        if (f51016a.get() != 0) {
            f51016a.set(0);
        }
    }
}
