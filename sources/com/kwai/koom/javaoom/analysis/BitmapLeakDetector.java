package com.kwai.koom.javaoom.analysis;

import android.graphics.Bitmap;
import com.kwai.koom.javaoom.common.KLog;
import kshark.HeapField;
import kshark.HeapGraph;
import kshark.HeapObject;

public class BitmapLeakDetector extends LeakDetector {

    /* renamed from: a */
    static final /* synthetic */ boolean f58364a = (!BitmapLeakDetector.class.desiredAssertionStatus());

    /* renamed from: d */
    private static final String f58365d = "android.graphics.Bitmap";

    /* renamed from: e */
    private static final String f58366e = "BitmapLeakDetector";

    /* renamed from: f */
    private long f58367f;

    /* renamed from: g */
    private ClassCounter f58368g;

    public String className() {
        return f58365d;
    }

    public String leakReason() {
        return "Bitmap Size";
    }

    private BitmapLeakDetector() {
    }

    public BitmapLeakDetector(HeapGraph heapGraph) {
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(f58365d);
        if (f58364a || findClassByName != null) {
            this.f58367f = findClassByName.getObjectId();
            this.f58368g = new ClassCounter();
            return;
        }
        throw new AssertionError();
    }

    public long classId() {
        return this.f58367f;
    }

    public Class<?> clazz() {
        return Bitmap.class;
    }

    public boolean isLeak(HeapObject.HeapInstance heapInstance) {
        if (this.f58398b) {
            KLog.m44291i(f58366e, "run isLeak");
        }
        this.f58368g.instancesCount++;
        HeapField heapField = heapInstance.get(f58365d, "mWidth");
        HeapField heapField2 = heapInstance.get(f58365d, "mHeight");
        if (!f58364a && heapField2 == null) {
            throw new AssertionError();
        } else if (f58364a || heapField != null) {
            boolean z = false;
            if (heapField2.getValue().getAsInt() == null || heapField.getValue().getAsInt() == null) {
                KLog.m44290e(f58366e, "ABNORMAL fieldWidth or fieldHeight is null");
                return false;
            }
            int intValue = heapField.getValue().getAsInt().intValue();
            int intValue2 = heapField2.getValue().getAsInt().intValue();
            if (intValue * intValue2 >= 1049088) {
                z = true;
            }
            if (z) {
                KLog.m44290e(f58366e, "bitmap leak : " + heapInstance.getInstanceClassName() + " width:" + intValue + " height:" + intValue2);
                ClassCounter classCounter = this.f58368g;
                classCounter.leakInstancesCount = classCounter.leakInstancesCount + 1;
            }
            return z;
        } else {
            throw new AssertionError();
        }
    }

    public ClassCounter instanceCount() {
        return this.f58368g;
    }
}
