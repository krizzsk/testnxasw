package com.kwai.koom.javaoom.analysis;

import com.kwai.koom.javaoom.common.KLog;
import kshark.HeapGraph;
import kshark.HeapObject;

public class NativeAllocationRegistryLeakDetector extends LeakDetector {

    /* renamed from: a */
    private static final String f58400a = "NativeAllocation";

    /* renamed from: d */
    private static final String f58401d = "libcore.util.NativeAllocationRegistry";

    /* renamed from: e */
    private static final String f58402e = "libcore.util.NativeAllocationRegistry$CleanerThunk";

    /* renamed from: f */
    private static final int f58403f = 1;

    /* renamed from: g */
    private boolean f58404g;

    /* renamed from: h */
    private long f58405h;

    /* renamed from: i */
    private long f58406i;

    /* renamed from: j */
    private ClassCounter f58407j;

    public String className() {
        return f58401d;
    }

    public Class<?> clazz() {
        return null;
    }

    public int generation() {
        return 1;
    }

    public String leakReason() {
        return f58400a;
    }

    private NativeAllocationRegistryLeakDetector() {
    }

    public NativeAllocationRegistryLeakDetector(HeapGraph heapGraph) {
        if (this.f58398b) {
            KLog.m44291i(f58400a, "run isLeak");
        }
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(f58401d);
        HeapObject.HeapClass findClassByName2 = heapGraph.findClassByName(f58402e);
        if (findClassByName != null) {
            this.f58405h = findClassByName.getObjectId();
        } else {
            this.f58404g = false;
        }
        if (findClassByName2 != null) {
            this.f58406i = findClassByName2.getObjectId();
        } else {
            this.f58404g = false;
        }
        this.f58407j = new ClassCounter();
        this.f58404g = true;
    }

    public boolean isSubClass(long j) {
        if (!this.f58404g) {
            return false;
        }
        long a = ClassHierarchyFetcher.m44257a(j, generation());
        if (a == this.f58405h || a == this.f58406i) {
            return true;
        }
        return false;
    }

    public long classId() {
        return this.f58405h;
    }

    public boolean isLeak(HeapObject.HeapInstance heapInstance) {
        if (!this.f58404g) {
            return false;
        }
        this.f58407j.instancesCount++;
        return false;
    }

    public ClassCounter instanceCount() {
        return this.f58407j;
    }
}
