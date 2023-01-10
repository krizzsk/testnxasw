package com.kwai.koom.javaoom.analysis;

import android.app.Application;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.common.KTrigger;
import com.kwai.koom.javaoom.common.KTriggerStrategy;
import com.kwai.koom.javaoom.monitor.TriggerReason;
import com.kwai.koom.javaoom.report.HeapAnalyzeReporter;

public class HeapAnalysisTrigger implements KTrigger {

    /* renamed from: a */
    private static final String f58385a = "HeapAnalysisTrigger";

    /* renamed from: b */
    private HeapAnalysisListener f58386b;

    /* renamed from: c */
    private boolean f58387c;

    /* renamed from: d */
    private KTriggerStrategy f58388d;

    /* renamed from: e */
    private volatile boolean f58389e;

    /* renamed from: f */
    private TriggerReason f58390f;

    public void stopTrack() {
    }

    public void setHeapAnalysisListener(HeapAnalysisListener heapAnalysisListener) {
        this.f58386b = heapAnalysisListener;
    }

    public void startTrack() {
        if (strategy() == KTriggerStrategy.RIGHT_NOW) {
            trigger(TriggerReason.analysisReason(TriggerReason.AnalysisReason.RIGHT_NOW));
        }
    }

    public void doAnalysis(Application application) {
        HeapAnalyzeService.runAnalysis(application, this.f58386b);
    }

    public void trigger(TriggerReason triggerReason) {
        if (!this.f58389e) {
            KLog.m44291i(f58385a, "reTrigger when foreground");
            this.f58390f = triggerReason;
            return;
        }
        KLog.m44291i(f58385a, "trigger reason:" + triggerReason.analysisReason);
        if (this.f58387c) {
            KLog.m44291i(f58385a, "Only once trigger!");
            return;
        }
        this.f58387c = true;
        HeapAnalyzeReporter.addAnalysisReason(triggerReason.analysisReason);
        if (triggerReason.analysisReason == TriggerReason.AnalysisReason.REANALYSIS) {
            HeapAnalyzeReporter.recordReanalysis();
        }
        HeapAnalysisListener heapAnalysisListener = this.f58386b;
        if (heapAnalysisListener != null) {
            heapAnalysisListener.onHeapAnalysisTrigger();
        }
        try {
            doAnalysis(KGlobalConfig.getApplication());
        } catch (Exception e) {
            KLog.m44290e(f58385a, "doAnalysis failed");
            e.printStackTrace();
            HeapAnalysisListener heapAnalysisListener2 = this.f58386b;
            if (heapAnalysisListener2 != null) {
                heapAnalysisListener2.onHeapAnalyzeFailed();
            }
        }
    }

    public void setStrategy(KTriggerStrategy kTriggerStrategy) {
        this.f58388d = kTriggerStrategy;
    }

    public KTriggerStrategy strategy() {
        KTriggerStrategy kTriggerStrategy = this.f58388d;
        if (kTriggerStrategy != null) {
            return kTriggerStrategy;
        }
        return KTriggerStrategy.RIGHT_NOW;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onBackground() {
        KLog.m44291i(f58385a, "onBackground");
        this.f58389e = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onForeground() {
        KLog.m44291i(f58385a, "onForeground");
        this.f58389e = true;
        TriggerReason triggerReason = this.f58390f;
        if (triggerReason != null) {
            this.f58390f = null;
            trigger(triggerReason);
        }
    }
}
