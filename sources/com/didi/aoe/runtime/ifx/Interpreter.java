package com.didi.aoe.runtime.ifx;

import android.content.res.AssetManager;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

public final class Interpreter {

    /* renamed from: a */
    private static final Logger f10052a = LoggerFactory.getLogger("IfxNativeInterpreter");

    /* renamed from: b */
    private NativeInterpreterWrapper f10053b;

    static {
        try {
            System.loadLibrary("aoe_ifx");
            f10052a.debug("IFX Init success", new Object[0]);
        } catch (UnsatisfiedLinkError unused) {
            f10052a.info("library not found!", new Object[0]);
        }
    }

    public Interpreter(AssetManager assetManager, String str, String str2, int i, Options options) {
        this.f10053b = new NativeInterpreterWrapper(assetManager, str, str2, i, options);
    }

    public Interpreter(String str, String str2, int i, Options options) {
        this.f10053b = new NativeInterpreterWrapper(str, str2, i, options);
    }

    public void preTreatment(byte[] bArr, int i, int i2, int i3, int i4, float[] fArr, float[] fArr2, int i5) {
        m8731a();
        this.f10053b.mo45168a(bArr, i, i2, i3, i4, fArr, fArr2, i5);
    }

    public void run(Object obj, Object obj2) {
        Object[] objArr;
        HashMap hashMap = new HashMap();
        hashMap.put(0, obj2);
        if (obj == null) {
            objArr = null;
        } else {
            objArr = new Object[]{obj};
        }
        runForMultipleInputsOutputs(objArr, hashMap);
    }

    public void runForMultipleInputsOutputs(Object[] objArr, Map<Integer, Object> map) {
        m8731a();
        this.f10053b.mo45169a(objArr, map);
    }

    public IfxTensor getOutputTensor(int i) {
        m8731a();
        return this.f10053b.mo45170b(i);
    }

    public int getInputTensorCount() {
        m8731a();
        return this.f10053b.mo45172c();
    }

    public IfxTensor getInputTensor(int i) {
        m8731a();
        return this.f10053b.mo45165a(i);
    }

    public int getOutputTensorCount() {
        m8731a();
        return this.f10053b.mo45173d();
    }

    public void close() {
        NativeInterpreterWrapper nativeInterpreterWrapper = this.f10053b;
        if (nativeInterpreterWrapper != null) {
            nativeInterpreterWrapper.mo45166a();
            this.f10053b = null;
        }
    }

    public boolean isLoadModelSuccess() {
        m8731a();
        return this.f10053b.mo45171b();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    /* renamed from: a */
    private void m8731a() {
        if (this.f10053b == null) {
            throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
        }
    }

    public static class Options {
        boolean lightMode = true;
        int numThreads = 4;

        public Options setNumberThreads(int i) {
            this.numThreads = i;
            return this;
        }

        public Options setLightMode(boolean z) {
            this.lightMode = z;
            return this;
        }
    }
}
