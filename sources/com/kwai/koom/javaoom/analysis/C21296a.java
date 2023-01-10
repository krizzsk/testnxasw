package com.kwai.koom.javaoom.analysis;

import android.util.Pair;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.report.HeapAnalyzeReporter;
import java.util.List;
import kshark.ApplicationLeak;
import kshark.LibraryLeak;

/* renamed from: com.kwai.koom.javaoom.analysis.a */
/* compiled from: KHeapAnalyzer */
class C21296a {

    /* renamed from: a */
    private static final String f58415a = "HeapAnalyzer";

    /* renamed from: b */
    private C21297b f58416b;

    public C21296a(KHeapFile kHeapFile) {
        this.f58416b = new C21297b(kHeapFile.hprof);
    }

    /* renamed from: a */
    public boolean mo174086a() {
        KLog.m44291i(f58415a, "analyze");
        Pair<List<ApplicationLeak>, List<LibraryLeak>> a = this.f58416b.mo174087a();
        if (a == null) {
            return false;
        }
        HeapAnalyzeReporter.addGCPath(a, this.f58416b.f58419a);
        HeapAnalyzeReporter.done();
        return true;
    }
}
