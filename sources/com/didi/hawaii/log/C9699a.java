package com.didi.hawaii.log;

import android.text.TextUtils;
import com.didi.hawaii.basic.ApolloHawaii;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

/* renamed from: com.didi.hawaii.log.a */
/* compiled from: HWBinaryLogger */
final class C9699a {

    /* renamed from: a */
    private static final String f25736a = "hawaiiPB";

    /* renamed from: b */
    private static final String f25737b = "{phonenumber}_binary_{hawaii}{date:yyyyMMdd}-{count}.txt";

    /* renamed from: c */
    private static final HWLogger2 f25738c = new HWLogger2(f25737b);

    /* renamed from: d */
    private static Logger f25739d = null;

    /* renamed from: a */
    private static byte[] m20441a(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    /* renamed from: a */
    private static byte[] m20442a(long j) {
        return new byte[]{(byte) ((int) j), (byte) ((int) (j >> 8)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 24)), (byte) ((int) (j >> 32)), (byte) ((int) (j >> 40)), (byte) ((int) (j >> 48)), (byte) ((int) (j >> 56))};
    }

    private C9699a() {
    }

    /* renamed from: a */
    static void m20439a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f25738c.setPhoneNumber(str);
        }
    }

    /* renamed from: b */
    static void m20443b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f25738c.setPath(str);
        }
    }

    /* renamed from: c */
    static void m20445c(String str) {
        if (!TextUtils.isEmpty(str)) {
            f25738c.setPackageName(str);
        }
    }

    /* renamed from: a */
    static void m20440a(byte[] bArr, byte b, long j) {
        byte[] b2 = m20444b(bArr, b, j);
        if (ApolloHawaii.useNewLogSDK()) {
            Logger a = m20438a();
            if (a != null) {
                a.write(b2);
                return;
            }
            return;
        }
        f25738c.log(b2);
    }

    /* renamed from: a */
    private static synchronized Logger m20438a() {
        synchronized (C9699a.class) {
            if (f25739d != null) {
                Logger logger = f25739d;
                return logger;
            }
            Logger logger2 = LoggerFactory.getLogger("", f25736a);
            f25739d = logger2;
            return logger2;
        }
    }

    /* renamed from: b */
    private static byte[] m20444b(byte[] bArr, byte b, long j) {
        int length = bArr.length + 9;
        byte[] bArr2 = new byte[(length + 4)];
        System.arraycopy(m20441a(length), 0, bArr2, 0, 4);
        bArr2[4] = b;
        System.arraycopy(m20442a(j), 0, bArr2, 5, 8);
        System.arraycopy(bArr, 0, bArr2, 13, bArr.length);
        return bArr2;
    }
}
