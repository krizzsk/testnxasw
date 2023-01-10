package com.kwai.koom.javaoom.analysis;

import android.app.Activity;
import com.kwai.koom.javaoom.common.KLog;
import kshark.HeapField;
import kshark.HeapGraph;
import kshark.HeapObject;

public class ActivityLeakDetector extends LeakDetector {

    /* renamed from: a */
    static final /* synthetic */ boolean f58357a = (!ActivityLeakDetector.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final String f58358d = "ActivityLeakDetector";

    /* renamed from: e */
    private static final String f58359e = "android.app.Activity";

    /* renamed from: f */
    private static final String f58360f = "mFinished";

    /* renamed from: g */
    private static final String f58361g = "mDestroyed";

    /* renamed from: h */
    private long f58362h;

    /* renamed from: i */
    private ClassCounter f58363i;

    public String className() {
        return f58359e;
    }

    public String leakReason() {
        return "Activity Leak";
    }

    private ActivityLeakDetector() {
    }

    public ActivityLeakDetector(HeapGraph heapGraph) {
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(f58359e);
        if (f58357a || findClassByName != null) {
            this.f58362h = findClassByName.getObjectId();
            this.f58363i = new ClassCounter();
            return;
        }
        throw new AssertionError();
    }

    public long classId() {
        return this.f58362h;
    }

    public Class<?> clazz() {
        return Activity.class;
    }

    public boolean isLeak(HeapObject.HeapInstance heapInstance) {
        if (this.f58398b) {
            KLog.m44291i(f58358d, "run isLeak");
        }
        this.f58363i.instancesCount++;
        HeapField heapField = heapInstance.get(f58359e, f58361g);
        HeapField heapField2 = heapInstance.get(f58359e, f58360f);
        if (!f58357a && heapField == null) {
            throw new AssertionError();
        } else if (f58357a || heapField2 != null) {
            boolean z = false;
            if (heapField.getValue().getAsBoolean() == null || heapField2.getValue().getAsBoolean() == null) {
                KLog.m44290e(f58358d, "ABNORMAL destroyField or finishedField is null");
                return false;
            }
            if (heapField.getValue().getAsBoolean().booleanValue() || heapField2.getValue().getAsBoolean().booleanValue()) {
                z = true;
            }
            if (z) {
                if (this.f58398b) {
                    KLog.m44290e(f58358d, "activity leak : " + heapInstance.getInstanceClassName());
                }
                this.f58363i.leakInstancesCount++;
            }
            return z;
        } else {
            throw new AssertionError();
        }
    }

    public ClassCounter instanceCount() {
        return this.f58363i;
    }
}
