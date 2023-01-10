package com.didi.safety.god.util;

import android.os.Handler;
import android.os.SystemClock;

public abstract class DFCountDownTimer {

    /* renamed from: e */
    private static final int f37585e = 1;

    /* renamed from: a */
    private final long f37586a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final long f37587b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f37588c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f37589d = false;

    /* renamed from: f */
    private Handler f37590f = new Handler() {
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r9) {
            /*
                r8 = this;
                com.didi.safety.god.util.DFCountDownTimer r9 = com.didi.safety.god.util.DFCountDownTimer.this
                monitor-enter(r9)
                com.didi.safety.god.util.DFCountDownTimer r0 = com.didi.safety.god.util.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                boolean r0 = r0.f37589d     // Catch:{ all -> 0x004f }
                if (r0 == 0) goto L_0x000d
                monitor-exit(r9)     // Catch:{ all -> 0x004f }
                return
            L_0x000d:
                com.didi.safety.god.util.DFCountDownTimer r0 = com.didi.safety.god.util.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                long r0 = r0.f37588c     // Catch:{ all -> 0x004f }
                long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x004f }
                long r0 = r0 - r2
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 > 0) goto L_0x0024
                com.didi.safety.god.util.DFCountDownTimer r0 = com.didi.safety.god.util.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                r0.onFinish()     // Catch:{ all -> 0x004f }
                goto L_0x004d
            L_0x0024:
                long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x004f }
                com.didi.safety.god.util.DFCountDownTimer r6 = com.didi.safety.god.util.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                r6.onTick(r0)     // Catch:{ all -> 0x004f }
                com.didi.safety.god.util.DFCountDownTimer r0 = com.didi.safety.god.util.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                long r0 = r0.f37587b     // Catch:{ all -> 0x004f }
                long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x004f }
                long r6 = r6 - r4
                long r0 = r0 - r6
            L_0x0039:
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 >= 0) goto L_0x0045
                com.didi.safety.god.util.DFCountDownTimer r4 = com.didi.safety.god.util.DFCountDownTimer.this     // Catch:{ all -> 0x004f }
                long r4 = r4.f37587b     // Catch:{ all -> 0x004f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.util.DFCountDownTimer.C126611.handleMessage(android.os.Message):void");
        }
    };

    public abstract void onFinish();

    public abstract void onTick(long j);

    public DFCountDownTimer(long j, long j2) {
        this.f37586a = j;
        this.f37587b = j2;
    }

    public final synchronized void cancel() {
        this.f37589d = true;
        this.f37590f.removeMessages(1);
    }

    public final synchronized DFCountDownTimer start() {
        this.f37589d = false;
        if (this.f37586a <= 0) {
            onFinish();
            return this;
        }
        this.f37588c = SystemClock.elapsedRealtime() + this.f37586a;
        this.f37590f.sendMessage(this.f37590f.obtainMessage(1));
        return this;
    }
}
