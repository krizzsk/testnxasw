package com.kwai.koom.javaoom.dump;

import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.common.KTrigger;
import com.kwai.koom.javaoom.common.KTriggerStrategy;
import com.kwai.koom.javaoom.common.KVData;
import com.kwai.koom.javaoom.monitor.HeapMonitor;
import com.kwai.koom.javaoom.monitor.MonitorManager;
import com.kwai.koom.javaoom.monitor.MonitorTriggerListener;
import com.kwai.koom.javaoom.monitor.MonitorType;
import com.kwai.koom.javaoom.monitor.TriggerReason;
import com.kwai.koom.javaoom.report.HeapAnalyzeReporter;

public class HeapDumpTrigger implements KTrigger {

    /* renamed from: a */
    private static final String f58454a = "HeapDumpTrigger";

    /* renamed from: b */
    private MonitorManager f58455b;

    /* renamed from: c */
    private HeapDumper f58456c = new ForkJvmHeapDumper();

    /* renamed from: d */
    private boolean f58457d;

    /* renamed from: e */
    private HeapDumpListener f58458e;

    public HeapDumpTrigger() {
        MonitorManager monitorManager = new MonitorManager();
        this.f58455b = monitorManager;
        monitorManager.addMonitor(new HeapMonitor());
    }

    public void setHeapDumper(HeapDumper heapDumper) {
        this.f58456c = heapDumper;
    }

    public void startTrack() {
        this.f58455b.start();
        this.f58455b.setTriggerListener(new MonitorTriggerListener() {
            public final boolean onTrigger(MonitorType monitorType, TriggerReason triggerReason) {
                return HeapDumpTrigger.this.m44298a(monitorType, triggerReason);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m44298a(MonitorType monitorType, TriggerReason triggerReason) {
        trigger(triggerReason);
        return true;
    }

    public void stopTrack() {
        this.f58455b.stop();
    }

    public void doHeapDump(TriggerReason.DumpReason dumpReason) {
        KLog.m44291i(f58454a, "doHeapDump");
        KHeapFile.getKHeapFile().buildFiles();
        HeapAnalyzeReporter.addDumpReason(dumpReason);
        HeapAnalyzeReporter.addDeviceRunningInfo();
        if (this.f58456c.dump(KHeapFile.getKHeapFile().hprof.path)) {
            this.f58458e.onHeapDumped(dumpReason);
            return;
        }
        KLog.m44290e(f58454a, "heap dump failed!");
        this.f58458e.onHeapDumpFailed();
        KHeapFile.delete();
    }

    public KTriggerStrategy strategy() {
        return KTriggerStrategy.RIGHT_NOW;
    }

    public void trigger(TriggerReason triggerReason) {
        if (this.f58457d) {
            KLog.m44290e(f58454a, "Only once trigger!");
            return;
        }
        this.f58457d = true;
        this.f58455b.stop();
        KLog.m44291i(f58454a, "trigger reason:" + triggerReason.dumpReason);
        HeapDumpListener heapDumpListener = this.f58458e;
        if (heapDumpListener != null) {
            heapDumpListener.onHeapDumpTrigger(triggerReason.dumpReason);
        }
        try {
            doHeapDump(triggerReason.dumpReason);
        } catch (Exception e) {
            KLog.m44290e(f58454a, "doHeapDump failed");
            e.printStackTrace();
            HeapDumpListener heapDumpListener2 = this.f58458e;
            if (heapDumpListener2 != null) {
                heapDumpListener2.onHeapDumpFailed();
            }
        }
        KVData.addTriggerTime(KGlobalConfig.getRunningInfoFetcher().appVersion());
    }

    public void setHeapDumpListener(HeapDumpListener heapDumpListener) {
        this.f58458e = heapDumpListener;
    }
}
