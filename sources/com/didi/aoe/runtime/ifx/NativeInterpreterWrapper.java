package com.didi.aoe.runtime.ifx;

import android.content.res.AssetManager;
import com.didi.aoe.runtime.ifx.Interpreter;
import java.util.Map;

final class NativeInterpreterWrapper {

    /* renamed from: a */
    private long f10054a;

    /* renamed from: b */
    private boolean f10055b;

    /* renamed from: c */
    private IfxTensor[] f10056c;

    /* renamed from: d */
    private IfxTensor[] f10057d;

    /* renamed from: e */
    private boolean f10058e;

    private static native long allocateTensors(long j);

    private static native long createInterpreter(boolean z, int i);

    private static native void delete(long j);

    private static native int getInputCount(long j);

    private static native int getOutputCount(long j);

    private static native boolean loadModel(String str, String str2, int i, long j);

    private static native boolean loadModelFromAssets(AssetManager assetManager, String str, String str2, int i, long j);

    private static native void preTreatment(int i, byte[] bArr, int i2, int i3, int i4, int i5, float[] fArr, float[] fArr2, long j, long j2);

    private static native int run(long j);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45167a(int i, int[] iArr) {
    }

    NativeInterpreterWrapper(AssetManager assetManager, String str, String str2, int i, Interpreter.Options options) {
        options = options == null ? new Interpreter.Options() : options;
        long createInterpreter = createInterpreter(options.lightMode, options.numThreads);
        this.f10054a = createInterpreter;
        boolean loadModelFromAssets = loadModelFromAssets(assetManager, str, str2, i, createInterpreter);
        this.f10055b = loadModelFromAssets;
        if (loadModelFromAssets) {
            m8732e();
        }
    }

    NativeInterpreterWrapper(String str, String str2, int i, Interpreter.Options options) {
        options = options == null ? new Interpreter.Options() : options;
        long createInterpreter = createInterpreter(options.lightMode, options.numThreads);
        this.f10054a = createInterpreter;
        boolean loadModel = loadModel(str, str2, i, createInterpreter);
        this.f10055b = loadModel;
        if (loadModel) {
            m8732e();
        }
    }

    /* renamed from: e */
    private void m8732e() {
        this.f10056c = new IfxTensor[getInputCount(this.f10054a)];
        this.f10057d = new IfxTensor[getOutputCount(this.f10054a)];
        allocateTensors(this.f10054a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45168a(byte[] bArr, int i, int i2, int i3, int i4, float[] fArr, float[] fArr2, int i5) {
        int i6 = i5;
        if (i6 < this.f10056c.length) {
            preTreatment(i5, bArr, i, i2, i3, i4, fArr, fArr2, this.f10054a, mo45165a(i6).mo45149c());
            this.f10058e = true;
            return;
        }
        throw new IllegalArgumentException("Input error: Inputs index should small than max.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IfxTensor mo45165a(int i) {
        if (i >= 0) {
            IfxTensor[] ifxTensorArr = this.f10056c;
            if (i < ifxTensorArr.length) {
                IfxTensor ifxTensor = ifxTensorArr[i];
                if (ifxTensor != null) {
                    return ifxTensor;
                }
                IfxTensor a = IfxTensor.m8718a(this.f10054a, i, true);
                ifxTensorArr[i] = a;
                return a;
            }
        }
        throw new IllegalArgumentException("Invalid input Tensor index: " + i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public IfxTensor mo45170b(int i) {
        if (i >= 0) {
            IfxTensor[] ifxTensorArr = this.f10057d;
            if (i < ifxTensorArr.length) {
                IfxTensor ifxTensor = ifxTensorArr[i];
                if (ifxTensor != null || !this.f10055b) {
                    return ifxTensor;
                }
                IfxTensor a = IfxTensor.m8718a(this.f10054a, i, false);
                ifxTensorArr[i] = a;
                return a;
            }
        }
        throw new IllegalArgumentException("Invalid output Tensor index: " + i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45166a() {
        int i = 0;
        this.f10055b = false;
        this.f10058e = false;
        long j = this.f10054a;
        if (j > 0) {
            delete(j);
            this.f10054a = 0;
        }
        if (this.f10056c != null) {
            int i2 = 0;
            while (true) {
                IfxTensor[] ifxTensorArr = this.f10056c;
                if (i2 >= ifxTensorArr.length) {
                    break;
                }
                if (ifxTensorArr[i2] != null) {
                    ifxTensorArr[i2].mo45145a();
                    this.f10056c[i2] = null;
                }
                i2++;
            }
        }
        if (this.f10057d != null) {
            while (true) {
                IfxTensor[] ifxTensorArr2 = this.f10057d;
                if (i < ifxTensorArr2.length) {
                    if (ifxTensorArr2[i] != null) {
                        ifxTensorArr2[i].mo45145a();
                        this.f10057d[i] = null;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45169a(Object[] objArr, Map<Integer, Object> map) {
        if (!this.f10058e && (objArr == null || objArr.length == 0)) {
            throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
        } else if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException("Input error: Outputs should not be null or empty.");
        } else {
            if (!(objArr == null || objArr.length == 0)) {
                for (int i = 0; i < objArr.length; i++) {
                    int[] c = mo45165a(i).mo45150c(objArr[i]);
                    if (c != null) {
                        mo45167a(i, c);
                    }
                }
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    mo45165a(i2).mo45146a(objArr[i2]);
                }
            }
            if (run(this.f10054a) == 0 && this.f10055b) {
                for (int i3 = 0; i3 < this.f10057d.length; i3++) {
                    mo45170b(i3).mo45148b();
                }
                for (Map.Entry next : map.entrySet()) {
                    mo45170b(((Integer) next.getKey()).intValue()).mo45147b(next.getValue());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo45171b() {
        return this.f10055b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo45172c() {
        return this.f10056c.length;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo45173d() {
        return this.f10057d.length;
    }
}
