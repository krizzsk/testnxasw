package com.didi.sdk.audiorecorder.utils;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class ByteArrayAllocator {

    /* renamed from: a */
    private static final int f38328a = 10;

    /* renamed from: b */
    private static final int f38329b = 3000;

    /* renamed from: c */
    private static AtomicInteger f38330c = new AtomicInteger(0);

    /* renamed from: d */
    private static AtomicLong f38331d = new AtomicLong(0);

    private ByteArrayAllocator() {
    }

    public static byte[] allocate(int i) {
        byte[] bArr = null;
        if (!m28897b()) {
            return null;
        }
        try {
            bArr = new byte[i];
            m28896a();
            return bArr;
        } catch (OutOfMemoryError unused) {
            System.gc();
            try {
                bArr = new byte[i];
                m28896a();
                return bArr;
            } catch (OutOfMemoryError unused2) {
                f38330c.incrementAndGet();
                f38331d.set(SystemClock.elapsedRealtime());
                return bArr;
            }
        }
    }

    /* renamed from: a */
    private static void m28896a() {
        if (f38330c.get() != 0) {
            f38330c.set(0);
        }
    }

    /* renamed from: b */
    private static boolean m28897b() {
        if (f38330c.get() <= 10) {
            return true;
        }
        long j = f38331d.get();
        if (j == 0 || SystemClock.elapsedRealtime() - j > 3000) {
            return true;
        }
        return false;
    }
}
