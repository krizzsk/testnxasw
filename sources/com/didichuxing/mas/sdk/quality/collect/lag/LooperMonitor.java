package com.didichuxing.mas.sdk.quality.collect.lag;

import android.os.SystemClock;
import android.util.Printer;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.backend.ScreenChangeReceiver;

class LooperMonitor implements Printer {

    /* renamed from: a */
    private static long f50677a = 3000;

    /* renamed from: b */
    private long f50678b = f50677a;

    /* renamed from: c */
    private long f50679c = 0;

    /* renamed from: d */
    private long f50680d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public BlockListener f50681e = null;

    /* renamed from: f */
    private boolean f50682f = false;

    /* renamed from: g */
    private final boolean f50683g;

    public interface BlockListener {
        void onBlockEvent(long j, long j2, long j3, long j4);
    }

    public LooperMonitor(BlockListener blockListener, long j, boolean z) {
        if (blockListener != null) {
            this.f50681e = blockListener;
            this.f50678b = j;
            this.f50683g = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public void println(String str) {
        if (!this.f50682f) {
            this.f50679c = System.currentTimeMillis();
            this.f50680d = SystemClock.currentThreadTimeMillis();
            this.f50682f = true;
            m37759a();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f50682f = false;
        if (m37760a(currentTimeMillis)) {
            m37762b(currentTimeMillis);
        }
        m37761b();
    }

    /* renamed from: a */
    private boolean m37760a(long j) {
        return j - this.f50679c > this.f50678b && AppStateMonitor.getInstance().isInForeground() && ScreenChangeReceiver.SCREEN_STATE == ScreenChangeReceiver.ScreenState.ON;
    }

    /* renamed from: b */
    private void m37762b(long j) {
        final long j2 = this.f50679c;
        final long j3 = this.f50680d;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        final long j4 = j;
        HandlerThreadFactory.getWriteLogThreadHandler().post(new Runnable() {
            public void run() {
                LooperMonitor.this.f50681e.onBlockEvent(j2, j4, j3, currentThreadTimeMillis);
            }
        });
    }

    /* renamed from: a */
    private void m37759a() {
        if (BlockCanaryInternals.m37753a().f50672b != null) {
            BlockCanaryInternals.m37753a().f50672b.mo124921a();
        }
        if (BlockCanaryInternals.m37753a().f50673c != null) {
            BlockCanaryInternals.m37753a().f50673c.mo124921a();
        }
    }

    /* renamed from: b */
    private void m37761b() {
        if (BlockCanaryInternals.m37753a().f50672b != null) {
            BlockCanaryInternals.m37753a().f50672b.mo124922b();
        }
        if (BlockCanaryInternals.m37753a().f50673c != null) {
            BlockCanaryInternals.m37753a().f50673c.mo124922b();
        }
    }
}
