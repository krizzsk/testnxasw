package com.kwai.koom.javaoom;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.kwai.koom.javaoom.KOOMEnableChecker;
import com.kwai.koom.javaoom.KOOMProgressListener;
import com.kwai.koom.javaoom.analysis.HeapAnalysisListener;
import com.kwai.koom.javaoom.analysis.HeapAnalysisTrigger;
import com.kwai.koom.javaoom.analysis.ReanalysisChecker;
import com.kwai.koom.javaoom.common.KConfig;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.common.KSoLoader;
import com.kwai.koom.javaoom.common.KUtils;
import com.kwai.koom.javaoom.dump.HeapDumpListener;
import com.kwai.koom.javaoom.dump.HeapDumpTrigger;
import com.kwai.koom.javaoom.monitor.TriggerReason;
import com.kwai.koom.javaoom.report.HeapReportUploader;
import com.kwai.koom.javaoom.report.HprofUploader;
import java.io.File;

/* renamed from: com.kwai.koom.javaoom.a */
/* compiled from: KOOMInternal */
class C21294a implements HeapAnalysisListener, HeapDumpListener {

    /* renamed from: a */
    private static final String f58349a = "KOOM";

    /* renamed from: b */
    private HeapDumpTrigger f58350b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public HeapAnalysisTrigger f58351c;

    /* renamed from: d */
    private KOOMProgressListener f58352d;

    /* renamed from: e */
    private Handler f58353e;

    /* renamed from: f */
    private boolean f58354f;

    /* renamed from: g */
    private HprofUploader f58355g;

    /* renamed from: h */
    private HeapReportUploader f58356h;

    private C21294a() {
    }

    public C21294a(Application application) {
        KUtils.startup();
        m44234a(application);
        this.f58350b = new HeapDumpTrigger();
        this.f58351c = new HeapAnalysisTrigger();
        new Handler(Looper.getMainLooper()).post(new KOOMInternal$1(this));
    }

    /* renamed from: a */
    private void m44234a(Application application) {
        KGlobalConfig.setApplication(application);
        KGlobalConfig.setKConfig(KConfig.defaultConfig());
    }

    /* renamed from: a */
    public void mo174047a(KConfig kConfig) {
        KGlobalConfig.setKConfig(kConfig);
    }

    /* renamed from: a */
    public void mo174043a() {
        HandlerThread handlerThread = new HandlerThread("koom");
        handlerThread.start();
        this.f58353e = new Handler(handlerThread.getLooper());
        m44238g();
    }

    /* renamed from: g */
    private void m44238g() {
        this.f58353e.postDelayed(new Runnable() {
            public final void run() {
                C21294a.this.m44239h();
            }
        }, 10000);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m44239h() {
        try {
            if (this.f58354f) {
                KLog.m44291i(f58349a, "already started!");
                return;
            }
            this.f58354f = true;
            this.f58350b.setHeapDumpListener(this);
            this.f58351c.setHeapAnalysisListener(this);
            if (KOOMEnableChecker.doCheck() != KOOMEnableChecker.Result.NORMAL) {
                KLog.m44290e(f58349a, "koom start failed, check result: " + KOOMEnableChecker.doCheck());
            } else if (new ReanalysisChecker().detectReanalysisFile() != null) {
                KLog.m44291i(f58349a, "detected reanalysis file");
                this.f58351c.trigger(TriggerReason.analysisReason(TriggerReason.AnalysisReason.REANALYSIS));
            } else {
                this.f58350b.startTrack();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo174053b() {
        HeapDumpTrigger heapDumpTrigger = this.f58350b;
        if (heapDumpTrigger != null) {
            heapDumpTrigger.stopTrack();
        }
        HeapAnalysisTrigger heapAnalysisTrigger = this.f58351c;
        if (heapAnalysisTrigger != null) {
            heapAnalysisTrigger.stopTrack();
        }
    }

    /* renamed from: a */
    public void mo174048a(KSoLoader kSoLoader) {
        KGlobalConfig.setSoLoader(kSoLoader);
    }

    /* renamed from: a */
    public boolean mo174052a(String str) {
        if (!new File(str).exists()) {
            return false;
        }
        KGlobalConfig.setRootDir(str);
        return true;
    }

    /* renamed from: c */
    public String mo174054c() {
        return KGlobalConfig.getReportDir();
    }

    /* renamed from: d */
    public String mo174055d() {
        return KGlobalConfig.getHprofDir();
    }

    /* renamed from: a */
    public void mo174049a(HeapDumpTrigger heapDumpTrigger) {
        this.f58350b = heapDumpTrigger;
    }

    /* renamed from: a */
    public void mo174046a(HeapAnalysisTrigger heapAnalysisTrigger) {
        this.f58351c = heapAnalysisTrigger;
    }

    /* renamed from: a */
    public void mo174045a(KOOMProgressListener kOOMProgressListener) {
        this.f58352d = kOOMProgressListener;
    }

    /* renamed from: a */
    public void mo174044a(KOOMProgressListener.Progress progress) {
        KOOMProgressListener kOOMProgressListener = this.f58352d;
        if (kOOMProgressListener != null) {
            kOOMProgressListener.onProgress(progress);
        }
    }

    public void onHeapDumpTrigger(TriggerReason.DumpReason dumpReason) {
        KLog.m44291i(f58349a, "onHeapDumpTrigger");
        mo174044a(KOOMProgressListener.Progress.HEAP_DUMP_START);
    }

    public void onHeapDumped(TriggerReason.DumpReason dumpReason) {
        KLog.m44291i(f58349a, "onHeapDumped");
        mo174044a(KOOMProgressListener.Progress.HEAP_DUMPED);
        if (dumpReason != TriggerReason.DumpReason.MANUAL_TRIGGER_ON_CRASH) {
            this.f58351c.startTrack();
        } else {
            KLog.m44291i(f58349a, "reanalysis next launch when trigger on crash");
        }
    }

    public void onHeapDumpFailed() {
        mo174044a(KOOMProgressListener.Progress.HEAP_DUMP_FAILED);
    }

    public void onHeapAnalysisTrigger() {
        KLog.m44291i(f58349a, "onHeapAnalysisTrigger");
        mo174044a(KOOMProgressListener.Progress.HEAP_ANALYSIS_START);
    }

    public void onHeapAnalyzed() {
        KLog.m44291i(f58349a, "onHeapAnalyzed");
        mo174044a(KOOMProgressListener.Progress.HEAP_ANALYSIS_DONE);
        m44237a(KHeapFile.getKHeapFile());
    }

    public void onHeapAnalyzeFailed() {
        mo174044a(KOOMProgressListener.Progress.HEAP_ANALYSIS_FAILED);
    }

    /* renamed from: a */
    private void m44237a(KHeapFile kHeapFile) {
        m44235a(kHeapFile.hprof);
        m44236a(kHeapFile.report);
    }

    /* renamed from: a */
    private void m44235a(KHeapFile.Hprof hprof) {
        HprofUploader hprofUploader = this.f58355g;
        if (hprofUploader != null) {
            hprofUploader.upload(hprof.file());
        }
        HprofUploader hprofUploader2 = this.f58355g;
        if (hprofUploader2 == null || hprofUploader2.deleteWhenUploaded()) {
            KLog.m44291i(f58349a, "delete " + hprof.path);
            hprof.delete();
        }
    }

    /* renamed from: a */
    private void m44236a(KHeapFile.Report report) {
        HeapReportUploader heapReportUploader = this.f58356h;
        if (heapReportUploader != null) {
            heapReportUploader.upload(report.file());
        }
        HeapReportUploader heapReportUploader2 = this.f58356h;
        if (heapReportUploader2 != null && heapReportUploader2.deleteWhenUploaded()) {
            KLog.m44291i(f58349a, "report delete");
            report.delete();
        }
    }

    /* renamed from: a */
    public void mo174051a(HprofUploader hprofUploader) {
        this.f58355g = hprofUploader;
    }

    /* renamed from: a */
    public void mo174050a(HeapReportUploader heapReportUploader) {
        this.f58356h = heapReportUploader;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m44240i() {
        if (!this.f58354f) {
            m44239h();
        }
        if (this.f58354f) {
            this.f58350b.trigger(TriggerReason.dumpReason(TriggerReason.DumpReason.MANUAL_TRIGGER));
        }
    }

    /* renamed from: e */
    public void mo174056e() {
        this.f58353e.post(new Runnable() {
            public final void run() {
                C21294a.this.m44240i();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m44241j() {
        if (!this.f58354f) {
            m44239h();
        }
        if (this.f58354f) {
            this.f58350b.trigger(TriggerReason.dumpReason(TriggerReason.DumpReason.MANUAL_TRIGGER_ON_CRASH));
        }
    }

    /* renamed from: f */
    public void mo174057f() {
        this.f58353e.post(new Runnable() {
            public final void run() {
                C21294a.this.m44241j();
            }
        });
    }
}
