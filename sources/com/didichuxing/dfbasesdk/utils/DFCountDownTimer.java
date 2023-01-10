package com.didichuxing.dfbasesdk.utils;

import android.os.Handler;
import android.os.SystemClock;

public abstract class DFCountDownTimer {

    /* renamed from: e */
    private static final int f49375e = 1;

    /* renamed from: a */
    private final long f49376a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final long f49377b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f49378c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f49379d = false;

    /* renamed from: f */
    private Handler f49380f = new Handler() {
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r9) {
            /*
                r8 = this;
                com.didichuxing.dfbasesdk.utils.DFCountDownTimer r9 = com.didichuxing.dfbasesdk.utils.DFCountDownTimer.this
                monitor-enter(r9)
                com.didichuxing.dfbasesdk.utils.DFCountDownTimer r0 = com.didichuxing.dfbasesdk.utils.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                boolean r0 = r0.f49379d     // Catch:{ all -> 0x004f }
                if (r0 == 0) goto L_0x000d
                monitor-exit(r9)     // Catch:{ all -> 0x004f }
                return
            L_0x000d:
                com.didichuxing.dfbasesdk.utils.DFCountDownTimer r0 = com.didichuxing.dfbasesdk.utils.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                long r0 = r0.f49378c     // Catch:{ all -> 0x004f }
                long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x004f }
                long r0 = r0 - r2
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 > 0) goto L_0x0024
                com.didichuxing.dfbasesdk.utils.DFCountDownTimer r0 = com.didichuxing.dfbasesdk.utils.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                r0.onFinish()     // Catch:{ all -> 0x004f }
                goto L_0x004d
            L_0x0024:
                long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x004f }
                com.didichuxing.dfbasesdk.utils.DFCountDownTimer r6 = com.didichuxing.dfbasesdk.utils.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                r6.onTick(r0)     // Catch:{ all -> 0x004f }
                com.didichuxing.dfbasesdk.utils.DFCountDownTimer r0 = com.didichuxing.dfbasesdk.utils.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                long r0 = r0.f49377b     // Catch:{ all -> 0x004f }
                long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x004f }
                long r6 = r6 - r4
                long r0 = r0 - r6
            L_0x0039:
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 >= 0) goto L_0x0045
                com.didichuxing.dfbasesdk.utils.DFCountDownTimer r4 = com.didichuxing.dfbasesdk.utils.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                long r4 = r4.f49377b     // Catch:{ all -> 0x004f }
                long r0 = r0 + r4
                goto L_0x0039
            L_0x0045:
                r2 = 1
                android.os.Message r2 = r8.obtainMessage(r2)     // Catch:{ all -> 0x004f }
                r8.sendMessageDelayed(r2, r0)     // Catch:{ all -> 0x004f }
            L_0x004d:
                monitor-exit(r9)     // Catch:{ all -> 0x004f }
                return
            L_0x004f:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x004f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.utils.DFCountDownTimer.C161241.handleMessage(android.os.Message):void");
        }
    };

    public abstract void onFinish();

    public abstract void onTick(long j);

    public DFCountDownTimer(long j, long j2) {
        this.f49376a = j;
        this.f49377b = j2;
    }

    public final synchronized void cancel() {
        this.f49379d = true;
        this.f49380f.removeMessages(1);
    }

    public final synchronized DFCountDownTimer start() {
        this.f49379d = false;
        if (this.f49376a <= 0) {
            onFinish();
            return this;
        }
        this.f49378c = SystemClock.elapsedRealtime() + this.f49376a;
        this.f49380f.sendMessage(this.f49380f.obtainMessage(1));
        return this;
    }
}
