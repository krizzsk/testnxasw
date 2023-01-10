package com.didichuxing.mas.sdk.quality.collect.lag;

import android.os.Looper;
import com.didichuxing.mas.sdk.quality.collect.lag.LooperMonitor;
import com.didichuxing.mas.sdk.quality.collect.lag.internal.BlockInfo;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BlockCanaryInternals {

    /* renamed from: d */
    private static BlockCanaryInternals f50669d;

    /* renamed from: e */
    private static BlockCanaryContext f50670e;

    /* renamed from: a */
    LooperMonitor f50671a;

    /* renamed from: b */
    C16602e f50672b = new C16602e(Looper.getMainLooper().getThread(), f50670e.provideDumpInterval());

    /* renamed from: c */
    C16600c f50673c = new C16600c(f50670e.provideDumpInterval());
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<C16599b> f50674f = new LinkedList();

    public BlockCanaryInternals() {
        m37755a(new LooperMonitor(new LooperMonitor.BlockListener() {
            public void onBlockEvent(long j, long j2, long j3, long j4) {
                long j5 = j;
                long j6 = j2;
                ArrayList<String> a = BlockCanaryInternals.this.f50672b.mo124927a(j5, j6);
                if (!a.isEmpty()) {
                    BlockInfo flushString = BlockInfo.newInstance().setMainThreadTimeCost(j, j2, j3, j4).setCpuBusyFlag(BlockCanaryInternals.this.f50673c.mo124924a(j5, j6)).setRecentCpuRate(BlockCanaryInternals.this.f50673c.mo124925d()).setThreadStackEntries(a).flushString();
                    if (BlockCanaryInternals.this.f50674f.size() != 0) {
                        for (C16599b onBlock : BlockCanaryInternals.this.f50674f) {
                            onBlock.onBlock(BlockCanaryInternals.getContext().provideContext(), flushString);
                        }
                    }
                }
            }
        }, getContext().provideBlockThreshold(), getContext().stopWhenDebugging()));
    }

    /* renamed from: a */
    static BlockCanaryInternals m37753a() {
        if (f50669d == null) {
            synchronized (BlockCanaryInternals.class) {
                if (f50669d == null) {
                    f50669d = new BlockCanaryInternals();
                }
            }
        }
        return f50669d;
    }

    public static void setContext(BlockCanaryContext blockCanaryContext) {
        f50670e = blockCanaryContext;
    }

    public static BlockCanaryContext getContext() {
        return f50670e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo124911a(C16599b bVar) {
        this.f50674f.add(bVar);
    }

    /* renamed from: a */
    private void m37755a(LooperMonitor looperMonitor) {
        this.f50671a = looperMonitor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo124912b() {
        return (long) (((float) getContext().provideBlockThreshold()) * 0.8f);
    }

    private static class BlockLogFileFilter implements FilenameFilter {
        private String TYPE = ".log";

        BlockLogFileFilter() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(this.TYPE);
        }
    }
}
