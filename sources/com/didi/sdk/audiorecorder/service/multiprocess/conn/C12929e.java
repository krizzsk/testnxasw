package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import com.didi.sdk.audiorecorder.service.multiprocess.conn.MultiProcessRecordServiceConnection;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.conn.e */
/* compiled from: ResetConnectionStrategy */
class C12929e {

    /* renamed from: a */
    private static final int f38263a = 3;

    /* renamed from: b */
    private static final int f38264b = 18;

    /* renamed from: c */
    private final long[] f38265c = new long[4];

    /* renamed from: d */
    private MultiProcessRecordServiceConnection.ServiceConnectTask f38266d;

    C12929e(MultiProcessRecordServiceConnection.ServiceConnectTask serviceConnectTask) {
        this.f38266d = serviceConnectTask;
    }

    /* renamed from: a */
    public void mo97606a() {
        if (m28858b()) {
            this.f38266d.disconnect();
            this.f38266d.connect();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0018  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m28858b() {
        /*
            r10 = this;
            long[] r0 = r10.f38265c
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            java.lang.System.arraycopy(r0, r3, r0, r2, r1)
            long[] r0 = r10.f38265c
            long r4 = android.os.SystemClock.elapsedRealtime()
            r0[r3] = r4
            r0 = 0
        L_0x0012:
            long[] r1 = r10.f38265c
            int r4 = r1.length
            int r4 = r4 - r2
            if (r0 >= r4) goto L_0x0030
            r4 = r1[r0]
            int r0 = r0 + 1
            r6 = r1[r0]
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x0031
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x0031
            long r4 = r4 - r6
            r6 = 18000(0x4650, double:8.893E-320)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0012
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.service.multiprocess.conn.C12929e.m28858b():boolean");
    }
}
