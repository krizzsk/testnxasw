package com.kwai.koom.javaoom.analysis;

import com.kwai.koom.javaoom.common.KUtils;
import kshark.HeapObject;

public abstract class LeakDetector {

    /* renamed from: b */
    boolean f58398b = true;

    /* renamed from: c */
    int f58399c = 0;

    public abstract long classId();

    public abstract String className();

    public abstract Class<?> clazz();

    public abstract ClassCounter instanceCount();

    /* access modifiers changed from: package-private */
    public abstract boolean isLeak(HeapObject.HeapInstance heapInstance);

    public abstract String leakReason();

    /* access modifiers changed from: package-private */
    public boolean isSubClass(long j) {
        return ClassHierarchyFetcher.m44257a(j, generation()) == classId();
    }

    public int generation() {
        int i = this.f58399c;
        if (i != 0) {
            return i;
        }
        int computeGenerations = KUtils.computeGenerations(clazz());
        this.f58399c = computeGenerations;
        return computeGenerations;
    }
}
