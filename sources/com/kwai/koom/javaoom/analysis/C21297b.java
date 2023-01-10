package com.kwai.koom.javaoom.analysis;

import android.util.Pair;
import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.report.HeapAnalyzeReporter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.C2404Reflection;
import kshark.AndroidReferenceMatchers;
import kshark.ApplicationLeak;
import kshark.GcRoot;
import kshark.HeapAnalyzer;
import kshark.HeapGraph;
import kshark.HeapObject;
import kshark.Hprof;
import kshark.HprofHeapGraph;
import kshark.LibraryLeak;
import kshark.ProguardMapping;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.kwai.koom.javaoom.analysis.b */
/* compiled from: SuspicionLeaksFinder */
class C21297b {

    /* renamed from: b */
    private static final String f58417b = "LeaksFinder";

    /* renamed from: h */
    private static final int f58418h = 45;

    /* renamed from: a */
    public Map<Long, String> f58419a;

    /* renamed from: c */
    private Set<Long> f58420c = new HashSet();

    /* renamed from: d */
    private KHeapFile.Hprof f58421d;

    /* renamed from: e */
    private HeapGraph f58422e;

    /* renamed from: f */
    private List<LeakDetector> f58423f = new ArrayList();

    /* renamed from: g */
    private Set<Integer> f58424g = new HashSet();

    public C21297b(KHeapFile.Hprof hprof) {
        this.f58421d = hprof;
    }

    /* renamed from: e */
    private void m44276e() {
        m44274a((LeakDetector) new ActivityLeakDetector(this.f58422e));
        m44274a((LeakDetector) new FragmentLeakDetector(this.f58422e));
        m44274a((LeakDetector) new BitmapLeakDetector(this.f58422e));
        m44274a((LeakDetector) new NativeAllocationRegistryLeakDetector(this.f58422e));
        m44274a((LeakDetector) new WindowLeakDetector(this.f58422e));
        ClassHierarchyFetcher.m44260a(this.f58424g);
        this.f58419a = new HashMap();
    }

    /* renamed from: a */
    private void m44274a(LeakDetector leakDetector) {
        this.f58423f.add(leakDetector);
        this.f58424g.add(Integer.valueOf(leakDetector.generation()));
    }

    /* renamed from: a */
    public Pair<List<ApplicationLeak>, List<LibraryLeak>> mo174087a() {
        if (!m44279h()) {
            return null;
        }
        m44276e();
        mo174088b();
        return mo174089c();
    }

    /* renamed from: b */
    public void mo174088b() {
        KLog.m44291i(f58417b, "start find leaks");
        for (HeapObject.HeapInstance next : this.f58422e.getInstances()) {
            if (!next.isPrimitiveWrapper()) {
                ClassHierarchyFetcher.m44259a(next.getInstanceClassId(), next.getInstanceClass().getClassHierarchy());
                for (LeakDetector next2 : this.f58423f) {
                    if (next2.isSubClass(next.getInstanceClassId()) && next2.isLeak(next) && next2.instanceCount().leakInstancesCount <= 45) {
                        this.f58420c.add(Long.valueOf(next.getObjectId()));
                        this.f58419a.put(Long.valueOf(next.getObjectId()), next2.leakReason());
                    }
                }
            }
        }
        HeapAnalyzeReporter.addClassInfo(this.f58423f);
        m44277f();
        m44278g();
    }

    /* renamed from: f */
    private void m44277f() {
        for (HeapObject.HeapPrimitiveArray next : this.f58422e.getPrimitiveArrays()) {
            int arrayLength = next.getArrayLength();
            if (arrayLength >= 262144) {
                String arrayClassName = next.getArrayClassName();
                String primitiveType = next.getPrimitiveType().toString();
                KLog.m44290e(f58417b, "primitive arrayName:" + arrayClassName + " typeName:" + primitiveType + " objectId:" + (next.getObjectId() & InternalZipConstants.ZIP_64_SIZE_LIMIT) + " arraySize:" + arrayLength);
                this.f58420c.add(Long.valueOf(next.getObjectId()));
                Map<Long, String> map = this.f58419a;
                Long valueOf = Long.valueOf(next.getObjectId());
                map.put(valueOf, "primitive array size over threshold:" + arrayLength + "," + (arrayLength / KConstants.Bytes.f58429KB) + "KB");
            }
        }
    }

    /* renamed from: g */
    private void m44278g() {
        for (HeapObject.HeapObjectArray next : this.f58422e.getObjectArrays()) {
            int arrayLength = next.getArrayLength();
            if (arrayLength >= 262144) {
                String arrayClassName = next.getArrayClassName();
                KLog.m44291i(f58417b, "object arrayName:" + arrayClassName + " objectId:" + next.getObjectId());
                this.f58420c.add(Long.valueOf(next.getObjectId()));
                Map<Long, String> map = this.f58419a;
                Long valueOf = Long.valueOf(next.getObjectId());
                map.put(valueOf, "object array size over threshold:" + arrayLength);
            }
        }
    }

    /* renamed from: c */
    public Pair<List<ApplicationLeak>, List<LibraryLeak>> mo174089c() {
        KLog.m44291i(f58417b, "findPath object size:" + this.f58420c.size());
        kotlin.Pair<List<ApplicationLeak>, List<LibraryLeak>> findLeaks = new HeapAnalyzer($$Lambda$b$mv2JeW4XED0joeF8YMa1OiQof6E.INSTANCE).findLeaks(new HeapAnalyzer.FindLeakInput(this.f58422e, AndroidReferenceMatchers.Companion.getAppDefaults(), false, Collections.emptyList()), this.f58420c, true);
        return new Pair<>(findLeaks.getFirst(), findLeaks.getSecond());
    }

    /* renamed from: h */
    private boolean m44279h() {
        KLog.m44291i(f58417b, "build index file:" + this.f58421d.path);
        if (this.f58421d.file() == null || !this.f58421d.file().exists()) {
            KLog.m44290e(f58417b, "hprof file is not exists : " + this.f58421d.path + "!!");
            return false;
        }
        this.f58422e = HprofHeapGraph.Companion.indexHprof(Hprof.Companion.open(this.f58421d.file()), (ProguardMapping) null, SetsKt.setOf(C2404Reflection.getOrCreateKotlinClass(GcRoot.JniGlobal.class), C2404Reflection.getOrCreateKotlinClass(GcRoot.JniLocal.class), C2404Reflection.getOrCreateKotlinClass(GcRoot.NativeStack.class), C2404Reflection.getOrCreateKotlinClass(GcRoot.StickyClass.class), C2404Reflection.getOrCreateKotlinClass(GcRoot.ThreadBlock.class), C2404Reflection.getOrCreateKotlinClass(GcRoot.ThreadObject.class), C2404Reflection.getOrCreateKotlinClass(GcRoot.JniMonitor.class)));
        return true;
    }

    /* renamed from: d */
    public Map<Long, String> mo174090d() {
        return this.f58419a;
    }
}
