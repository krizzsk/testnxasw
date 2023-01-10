package com.kwai.koom.javaoom.analysis;

import androidx.fragment.app.Fragment;
import com.kwai.koom.javaoom.common.KLog;
import kshark.HeapField;
import kshark.HeapGraph;
import kshark.HeapObject;

public class FragmentLeakDetector extends LeakDetector {

    /* renamed from: a */
    static final /* synthetic */ boolean f58374a = (!FragmentLeakDetector.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final String f58375d = "android.app.Fragment";

    /* renamed from: e */
    private static final String f58376e = "android.support.v4.app.Fragment";

    /* renamed from: f */
    private static final String f58377f = "androidx.fragment.app.Fragment";

    /* renamed from: g */
    private static final String f58378g = "mFragmentManager";

    /* renamed from: h */
    private static final String f58379h = "mCalled";

    /* renamed from: l */
    private static final String f58380l = "FragmentLeakDetector";

    /* renamed from: m */
    private static final int f58381m = 1;

    /* renamed from: i */
    private long f58382i;

    /* renamed from: j */
    private String f58383j = f58377f;

    /* renamed from: k */
    private ClassCounter f58384k;

    public int generation() {
        return 1;
    }

    public String leakReason() {
        return "Fragment Leak";
    }

    public FragmentLeakDetector(HeapGraph heapGraph) {
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(f58377f);
        if (findClassByName == null) {
            findClassByName = heapGraph.findClassByName(f58375d);
            this.f58383j = f58375d;
        }
        if (findClassByName == null) {
            findClassByName = heapGraph.findClassByName(f58376e);
            this.f58383j = f58376e;
        }
        if (f58374a || findClassByName != null) {
            this.f58382i = findClassByName.getObjectId();
            this.f58384k = new ClassCounter();
            return;
        }
        throw new AssertionError();
    }

    public long classId() {
        return this.f58382i;
    }

    public String className() {
        return this.f58383j;
    }

    public boolean isLeak(HeapObject.HeapInstance heapInstance) {
        if (this.f58398b) {
            KLog.m44291i(f58380l, "run isLeak");
        }
        this.f58384k.instancesCount++;
        HeapField heapField = heapInstance.get(this.f58383j, f58378g);
        boolean z = false;
        if (heapField != null && heapField.getValue().getAsObject() == null) {
            HeapField heapField2 = heapInstance.get(this.f58383j, f58379h);
            if (heapField2 == null || heapField2.getValue().getAsBoolean() == null) {
                KLog.m44290e(f58380l, "ABNORMAL mCalledField is null");
                return false;
            }
            z = heapField2.getValue().getAsBoolean().booleanValue();
            if (z) {
                if (this.f58398b) {
                    KLog.m44290e(f58380l, "fragment leak : " + heapInstance.getInstanceClassName());
                }
                this.f58384k.leakInstancesCount++;
            }
        }
        return z;
    }

    public ClassCounter instanceCount() {
        return this.f58384k;
    }

    public Class<?> clazz() {
        return Fragment.class;
    }
}
