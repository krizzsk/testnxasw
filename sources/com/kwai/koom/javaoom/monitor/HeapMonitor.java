package com.kwai.koom.javaoom.monitor;

import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.monitor.TriggerReason;

public class HeapMonitor implements Monitor {

    /* renamed from: a */
    private static final String f58464a = "HeapMonitor";

    /* renamed from: b */
    private HeapThreshold f58465b;

    /* renamed from: c */
    private int f58466c = 0;

    /* renamed from: d */
    private HeapStatus f58467d;

    /* renamed from: e */
    private volatile boolean f58468e = false;

    public void setThreshold(Threshold threshold) {
        if (threshold instanceof HeapThreshold) {
            this.f58465b = (HeapThreshold) threshold;
            return;
        }
        throw new RuntimeException("Must be HeapThreshold!");
    }

    public TriggerReason getTriggerReason() {
        return TriggerReason.dumpReason(TriggerReason.DumpReason.HEAP_OVER_THRESHOLD);
    }

    public boolean isTrigger() {
        if (!this.f58468e) {
            return false;
        }
        HeapStatus a = m44299a();
        if (a.isOverMaxThreshold) {
            KLog.m44291i(f58464a, "heap used is over max ratio, force trigger and over times reset to 0");
            this.f58466c = 0;
            return true;
        }
        if (a.isOverThreshold) {
            KLog.m44291i(f58464a, "heap status used:" + (a.used / ((long) KConstants.Bytes.f58430MB)) + ", max:" + (a.max / ((long) KConstants.Bytes.f58430MB)) + ", last over times:" + this.f58466c);
            if (!this.f58465b.ascending()) {
                this.f58466c++;
            } else if (this.f58467d == null || a.used >= this.f58467d.used || a.isOverMaxThreshold) {
                this.f58466c++;
            } else {
                KLog.m44291i(f58464a, "heap status used is not ascending, and over times reset to 0");
                this.f58466c = 0;
            }
        } else {
            this.f58466c = 0;
        }
        this.f58467d = a;
        if (this.f58466c >= this.f58465b.overTimes()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private HeapStatus m44299a() {
        HeapStatus heapStatus = new HeapStatus();
        heapStatus.max = Runtime.getRuntime().maxMemory();
        heapStatus.used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        float f = (((float) heapStatus.used) * 100.0f) / ((float) heapStatus.max);
        boolean z = true;
        heapStatus.isOverThreshold = f > this.f58465b.value();
        if (f <= this.f58465b.maxValue()) {
            z = false;
        }
        heapStatus.isOverMaxThreshold = z;
        return heapStatus;
    }

    static class HeapStatus {
        boolean isOverMaxThreshold;
        boolean isOverThreshold;
        long max;
        long used;

        HeapStatus() {
        }
    }

    public MonitorType monitorType() {
        return MonitorType.HEAP;
    }

    public void start() {
        this.f58468e = true;
        if (this.f58465b == null) {
            this.f58465b = KGlobalConfig.getHeapThreshold();
        }
        KLog.m44291i(f58464a, "start HeapMonitor, HeapThreshold ratio:" + this.f58465b.value() + ", max over times: " + this.f58465b.overTimes());
    }

    public void stop() {
        KLog.m44291i(f58464a, "stop");
        this.f58468e = false;
    }

    public int pollInterval() {
        return this.f58465b.pollInterval();
    }
}
