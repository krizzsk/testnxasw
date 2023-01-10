package com.kwai.koom.javaoom.report;

import android.os.Build;
import android.os.Debug;
import android.util.Pair;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.gson.Gson;
import com.kwai.koom.javaoom.analysis.LeakDetector;
import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.common.KUtils;
import com.kwai.koom.javaoom.monitor.TriggerReason;
import com.kwai.koom.javaoom.report.HeapReport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kshark.ApplicationLeak;
import kshark.Leak;
import kshark.LeakTrace;
import kshark.LeakTraceObject;
import kshark.LeakTraceReference;
import kshark.LibraryLeak;
import net.lingala.zip4j.util.InternalZipConstants;

public class HeapAnalyzeReporter {

    /* renamed from: a */
    private static final String f58490a = "HeapAnalyzeReporter";

    /* renamed from: b */
    private static HeapAnalyzeReporter f58491b;

    /* renamed from: c */
    private File f58492c = KHeapFile.getKHeapFile().report.file();

    /* renamed from: d */
    private HeapReport f58493d;

    /* renamed from: e */
    private Gson f58494e = new Gson();

    public HeapAnalyzeReporter() {
        HeapReport c = m44314c();
        this.f58493d = c;
        if (c == null) {
            this.f58493d = new HeapReport();
        }
    }

    /* renamed from: a */
    private static HeapAnalyzeReporter m44307a() {
        HeapAnalyzeReporter heapAnalyzeReporter = f58491b;
        if (heapAnalyzeReporter != null) {
            return heapAnalyzeReporter;
        }
        HeapAnalyzeReporter heapAnalyzeReporter2 = new HeapAnalyzeReporter();
        f58491b = heapAnalyzeReporter2;
        return heapAnalyzeReporter2;
    }

    /* renamed from: b */
    private void m44313b() {
        FileOutputStream fileOutputStream;
        IOException e;
        try {
            String json = this.f58494e.toJson((Object) this.f58493d);
            fileOutputStream = new FileOutputStream(this.f58492c);
            try {
                KLog.m44291i(f58490a, "flushFile " + this.f58492c.getPath() + " str:" + json);
                fileOutputStream.write(json.getBytes());
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            fileOutputStream = null;
            e = e3;
            try {
                e.printStackTrace();
                KUtils.closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                KUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
            KUtils.closeQuietly(fileOutputStream);
            throw th;
        }
        KUtils.closeQuietly(fileOutputStream);
    }

    /* renamed from: c */
    private HeapReport m44314c() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(this.f58492c);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                if (KConstants.Debug.VERBOSE_LOG) {
                    KLog.m44291i(f58490a, "loadFile " + this.f58492c.getPath() + " str:" + str);
                }
                HeapReport heapReport = (HeapReport) this.f58494e.fromJson(str, HeapReport.class);
                KUtils.closeQuietly(fileInputStream);
                return heapReport;
            } catch (IOException unused) {
                fileInputStream2 = fileInputStream;
                KUtils.closeQuietly(fileInputStream2);
                return new HeapReport();
            } catch (Throwable th2) {
                th = th2;
                KUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (IOException unused2) {
            KUtils.closeQuietly(fileInputStream2);
            return new HeapReport();
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = null;
            th = th4;
            KUtils.closeQuietly(fileInputStream);
            throw th;
        }
    }

    /* renamed from: d */
    private HeapReport.RunningInfo m44315d() {
        if (this.f58493d.runningInfo != null) {
            return this.f58493d.runningInfo;
        }
        HeapReport heapReport = this.f58493d;
        HeapReport.RunningInfo runningInfo = new HeapReport.RunningInfo();
        heapReport.runningInfo = runningInfo;
        return runningInfo;
    }

    /* renamed from: e */
    private void m44316e() {
        KLog.m44291i(f58490a, "addRunningInfoInternal");
        HeapReport.RunningInfo d = m44315d();
        d.buildModel = Build.MODEL;
        d.manufacture = Build.MANUFACTURER;
        d.sdkInt = Integer.valueOf(Build.VERSION.SDK_INT);
        d.usageSeconds = KGlobalConfig.getRunningInfoFetcher().usageSeconds();
        d.currentPage = KGlobalConfig.getRunningInfoFetcher().currentPage();
        d.appVersion = KGlobalConfig.getRunningInfoFetcher().appVersion();
        d.nowTime = KUtils.getTimeStamp();
        d.jvmMax = Integer.valueOf((int) (Runtime.getRuntime().maxMemory() / ((long) KConstants.Bytes.f58430MB)));
        d.jvmUsed = Integer.valueOf((int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / ((long) KConstants.Bytes.f58430MB)));
        d.pss = Integer.valueOf((int) (Debug.getPss() / ((long) KConstants.Bytes.f58429KB)));
        KUtils.ProcessStatus processMemoryUsage = KUtils.getProcessMemoryUsage();
        d.vss = Integer.valueOf((int) (processMemoryUsage.vssKbSize / ((long) KConstants.Bytes.f58429KB)));
        d.rss = Integer.valueOf((int) (processMemoryUsage.rssKbSize / ((long) KConstants.Bytes.f58429KB)));
        d.threadCount = Integer.valueOf(processMemoryUsage.threadsCount);
        d.koomVersion = Integer.valueOf(KConstants.KOOMVersion.CODE);
        this.f58493d.runningInfo = d;
        m44313b();
    }

    public static void addDeviceRunningInfo() {
        m44307a().m44316e();
    }

    /* renamed from: a */
    private void m44310a(TriggerReason.DumpReason dumpReason) {
        m44315d().dumpReason = dumpReason.name();
        m44313b();
    }

    public static void addDumpReason(TriggerReason.DumpReason dumpReason) {
        m44307a().m44310a(dumpReason);
    }

    /* renamed from: a */
    private void m44309a(TriggerReason.AnalysisReason analysisReason) {
        m44315d().analysisReason = analysisReason.name();
        m44313b();
    }

    public static void addAnalysisReason(TriggerReason.AnalysisReason analysisReason) {
        m44307a().m44309a(analysisReason);
    }

    /* renamed from: a */
    private void m44311a(List<LeakDetector> list) {
        KLog.m44291i(f58490a, "addClassInfoInternal");
        this.f58493d.classInfos = new ArrayList();
        for (LeakDetector next : list) {
            HeapReport.ClassInfo classInfo = new HeapReport.ClassInfo();
            classInfo.className = next.className();
            classInfo.instanceCount = Integer.valueOf(next.instanceCount().instancesCount);
            classInfo.leakInstanceCount = Integer.valueOf(next.instanceCount().leakInstancesCount);
            this.f58493d.classInfos.add(classInfo);
            KLog.m44291i(f58490a, "class:" + classInfo.className + " all instances:" + classInfo.instanceCount + ", leaked instances:" + classInfo.leakInstanceCount);
        }
        m44313b();
    }

    public static void addClassInfo(List<LeakDetector> list) {
        m44307a().m44311a(list);
    }

    /* renamed from: a */
    private <T extends Leak> void m44312a(List<T> list, Map<Long, String> map) {
        String str;
        List<T> list2 = list;
        if (list2 == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("add ");
        sb.append(list2.get(0) instanceof ApplicationLeak ? "ApplicationLeak " : "LibraryLeak ");
        sb.append(list.size());
        sb.append(" leaks");
        KLog.m44291i(f58490a, sb.toString());
        for (T t : list) {
            HeapReport.GCPath gCPath = new HeapReport.GCPath();
            this.f58493d.gcPaths.add(gCPath);
            gCPath.signature = t.getSignature();
            gCPath.instanceCount = Integer.valueOf(t.getLeakTraces().size());
            LeakTrace leakTrace = t.getLeakTraces().get(0);
            String description = leakTrace.getGcRootType().getDescription();
            gCPath.gcRoot = description;
            LeakTraceObject leakingObject = leakTrace.getLeakingObject();
            String className = leakingObject.getClassName();
            String typeName = leakingObject.getTypeName();
            KLog.m44291i(f58490a, "GC Root:" + description + ", leakObjClazz:" + className + ", leakObjType:" + typeName + ", leaking reason:" + leakingObject.getLeakingStatusReason() + ", leaking id:" + (leakingObject.getObjectId() & InternalZipConstants.ZIP_64_SIZE_LIMIT));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(map.get(Long.valueOf(leakingObject.getObjectId())));
            if (t instanceof ApplicationLeak) {
                str = "";
            } else {
                str = " " + leakingObject.getLeakingStatusReason();
            }
            sb2.append(str);
            gCPath.leakReason = sb2.toString();
            gCPath.path = new ArrayList();
            HeapReport.GCPath.PathItem pathItem = new HeapReport.GCPath.PathItem();
            pathItem.reference = className;
            pathItem.referenceType = typeName;
            for (LeakTraceReference next : leakTrace.getReferencePath()) {
                String referenceName = next.getReferenceName();
                String className2 = next.getOriginObject().getClassName();
                String referenceDisplayName = next.getReferenceDisplayName();
                String referenceGenericName = next.getReferenceGenericName();
                String referenceType = next.getReferenceType().toString();
                String declaredClassName = next.getDeclaredClassName();
                KLog.m44291i(f58490a, "clazz:" + className2 + ", referenceName:" + referenceName + ", referenceDisplayName:" + referenceDisplayName + ", referenceGenericName:" + referenceGenericName + ", referenceType:" + referenceType + ", declaredClassName:" + declaredClassName);
                HeapReport.GCPath.PathItem pathItem2 = new HeapReport.GCPath.PathItem();
                if (!referenceDisplayName.startsWith(Const.jaLeft)) {
                    className2 = className2 + "." + referenceDisplayName;
                }
                pathItem2.reference = className2;
                pathItem2.referenceType = referenceType;
                pathItem2.declaredClass = declaredClassName;
                gCPath.path.add(pathItem2);
            }
            gCPath.path.add(pathItem);
        }
    }

    /* renamed from: a */
    private void m44308a(Pair<List<ApplicationLeak>, List<LibraryLeak>> pair, Map<Long, String> map) {
        if (this.f58493d.gcPaths == null) {
            this.f58493d.gcPaths = new ArrayList();
        }
        m44312a((List) pair.first, map);
        m44312a((List) pair.second, map);
        m44313b();
    }

    public static void addGCPath(Pair<List<ApplicationLeak>, List<LibraryLeak>> pair, Map<Long, String> map) {
        m44307a().m44308a(pair, map);
    }

    /* renamed from: f */
    private void m44317f() {
        this.f58493d.analysisDone = true;
        m44313b();
    }

    public static void done() {
        m44307a().m44317f();
    }

    /* renamed from: g */
    private void m44318g() {
        KLog.m44291i(f58490a, "reAnalysisInternal");
        HeapReport heapReport = this.f58493d;
        int i = 1;
        if (heapReport.reAnalysisTimes != null) {
            i = 1 + this.f58493d.reAnalysisTimes.intValue();
        }
        heapReport.reAnalysisTimes = Integer.valueOf(i);
        m44313b();
    }

    public static void recordReanalysis() {
        m44307a().m44318g();
    }
}
