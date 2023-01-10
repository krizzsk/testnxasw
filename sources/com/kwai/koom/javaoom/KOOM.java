package com.kwai.koom.javaoom;

import android.app.Application;
import com.kwai.koom.javaoom.analysis.HeapAnalysisTrigger;
import com.kwai.koom.javaoom.common.KConfig;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.dump.HeapDumpTrigger;
import com.kwai.koom.javaoom.report.HeapReportUploader;
import com.kwai.koom.javaoom.report.HprofUploader;

public class KOOM {

    /* renamed from: b */
    private static KOOM f58343b = null;

    /* renamed from: c */
    private static boolean f58344c = false;

    /* renamed from: d */
    private static final String f58345d = "koom";

    /* renamed from: a */
    private C21294a f58346a;

    private KOOM() {
    }

    private KOOM(Application application) {
        if (!f58344c) {
            init(application);
        }
        this.f58346a = new C21294a(application);
    }

    public static void init(Application application) {
        KLog.init(new KLog.DefaultLogger());
        if (f58344c) {
            KLog.m44291i(f58345d, "already init!");
            return;
        }
        f58344c = true;
        if (f58343b == null) {
            f58343b = new KOOM(application);
        }
        f58343b.start();
    }

    public static KOOM getInstance() {
        return f58343b;
    }

    public void start() {
        this.f58346a.mo174043a();
    }

    public void stop() {
        this.f58346a.mo174053b();
    }

    public void setProgressListener(KOOMProgressListener kOOMProgressListener) {
        this.f58346a.mo174045a(kOOMProgressListener);
    }

    public String getReportDir() {
        return this.f58346a.mo174054c();
    }

    public String getHprofDir() {
        return this.f58346a.mo174055d();
    }

    public boolean setRootDir(String str) {
        return this.f58346a.mo174052a(str);
    }

    public void setKConfig(KConfig kConfig) {
        this.f58346a.mo174047a(kConfig);
    }

    public void setHprofUploader(HprofUploader hprofUploader) {
        this.f58346a.mo174051a(hprofUploader);
    }

    public void setHeapReportUploader(HeapReportUploader heapReportUploader) {
        this.f58346a.mo174050a(heapReportUploader);
    }

    public void setHeapDumpTrigger(HeapDumpTrigger heapDumpTrigger) {
        this.f58346a.mo174049a(heapDumpTrigger);
    }

    public void setHeapAnalysisTrigger(HeapAnalysisTrigger heapAnalysisTrigger) {
        this.f58346a.mo174046a(heapAnalysisTrigger);
    }

    public void manualTrigger() {
        this.f58346a.mo174056e();
    }

    public void manualTriggerOnCrash() {
        this.f58346a.mo174057f();
    }

    public void setLogger(KLog.KLogger kLogger) {
        KLog.init(kLogger);
    }
}
