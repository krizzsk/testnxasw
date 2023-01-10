package com.kwai.koom.javaoom.analysis;

import android.view.Window;
import com.kwai.koom.javaoom.common.KLog;
import kshark.HeapGraph;
import kshark.HeapObject;

public class WindowLeakDetector extends LeakDetector {

    /* renamed from: a */
    static final /* synthetic */ boolean f58409a = (!WindowLeakDetector.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final String f58410d = "WindowLeakDetector";

    /* renamed from: e */
    private static final String f58411e = "android.view.Window";

    /* renamed from: f */
    private static final int f58412f = 1;

    /* renamed from: g */
    private long f58413g;

    /* renamed from: h */
    private ClassCounter f58414h;

    public String className() {
        return f58411e;
    }

    public int generation() {
        return 1;
    }

    public String leakReason() {
        return "Window";
    }

    private WindowLeakDetector() {
    }

    public WindowLeakDetector(HeapGraph heapGraph) {
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(f58411e);
        if (f58409a || findClassByName != null) {
            this.f58413g = findClassByName.getObjectId();
            this.f58414h = new ClassCounter();
            return;
        }
        throw new AssertionError();
    }

    public long classId() {
        return this.f58413g;
    }

    public boolean isLeak(HeapObject.HeapInstance heapInstance) {
        if (this.f58398b) {
            KLog.m44291i(f58410d, "run isLeak");
        }
        this.f58414h.instancesCount++;
        return false;
    }

    public ClassCounter instanceCount() {
        return this.f58414h;
    }

    public Class<?> clazz() {
        return Window.class;
    }
}
