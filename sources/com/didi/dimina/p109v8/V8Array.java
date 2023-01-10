package com.didi.dimina.p109v8;

/* renamed from: com.didi.dimina.v8.V8Array */
public class V8Array extends V8Object {
    protected V8Array() {
    }

    public V8Array(C8369V8 v8) {
        super(v8);
        v8.checkThread();
    }

    protected V8Array(C8369V8 v8, Object obj) {
        super(v8, obj);
    }

    /* access modifiers changed from: protected */
    public V8Value createTwin() {
        return new V8Array(this.f20074v8);
    }

    public V8Array twin() {
        return (V8Array) super.twin();
    }

    public String toString() {
        return (this.released || this.f20074v8.isReleased()) ? "[Array released]" : super.toString();
    }

    /* access modifiers changed from: protected */
    public void initialize(long j, Object obj) {
        long initNewV8Array = this.f20074v8.initNewV8Array(j);
        this.released = false;
        addObjectReference(initNewV8Array);
    }

    public int length() {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetSize(this.f20074v8.getV8RuntimePtr(), getHandle());
    }

    public int getType(int i) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.getType(this.f20074v8.getV8RuntimePtr(), getHandle(), i);
    }

    public int getType() {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.getArrayType(this.f20074v8.getV8RuntimePtr(), getHandle());
    }

    public int getType(int i, int i2) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.getType(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getInteger(int i) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetInteger(this.f20074v8.getV8RuntimePtr(), getHandle(), i);
    }

    public boolean getBoolean(int i) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetBoolean(this.f20074v8.getV8RuntimePtr(), getHandle(), i);
    }

    public byte getByte(int i) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetByte(this.f20074v8.getV8RuntimePtr(), getHandle(), i);
    }

    public double getDouble(int i) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetDouble(this.f20074v8.getV8RuntimePtr(), getHandle(), i);
    }

    public String getString(int i) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetString(this.f20074v8.getV8RuntimePtr(), getHandle(), i);
    }

    public int[] getIntegers(int i, int i2) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetIntegers(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getIntegers(int i, int i2, int[] iArr) {
        this.f20074v8.checkThread();
        checkReleased();
        if (i2 <= iArr.length) {
            return this.f20074v8.arrayGetIntegers(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2, iArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public double[] getDoubles(int i, int i2) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetDoubles(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getDoubles(int i, int i2, double[] dArr) {
        this.f20074v8.checkThread();
        checkReleased();
        if (i2 <= dArr.length) {
            return this.f20074v8.arrayGetDoubles(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2, dArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean[] getBooleans(int i, int i2) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetBooleans(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public byte[] getBytes(int i, int i2) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetBytes(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getBooleans(int i, int i2, boolean[] zArr) {
        this.f20074v8.checkThread();
        checkReleased();
        if (i2 <= zArr.length) {
            return this.f20074v8.arrayGetBooleans(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2, zArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getBytes(int i, int i2, byte[] bArr) {
        this.f20074v8.checkThread();
        checkReleased();
        if (i2 <= bArr.length) {
            return this.f20074v8.arrayGetBytes(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2, bArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public String[] getStrings(int i, int i2) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGetStrings(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getStrings(int i, int i2, String[] strArr) {
        this.f20074v8.checkThread();
        checkReleased();
        if (i2 <= strArr.length) {
            return this.f20074v8.arrayGetStrings(this.f20074v8.getV8RuntimePtr(), getHandle(), i, i2, strArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public Object get(int i) {
        this.f20074v8.checkThread();
        checkReleased();
        return this.f20074v8.arrayGet(this.f20074v8.getV8RuntimePtr(), 6, this.objectHandle, i);
    }

    public V8Array getArray(int i) {
        this.f20074v8.checkThread();
        checkReleased();
        Object arrayGet = this.f20074v8.arrayGet(this.f20074v8.getV8RuntimePtr(), 5, this.objectHandle, i);
        if (arrayGet == null || (arrayGet instanceof V8Array)) {
            return (V8Array) arrayGet;
        }
        throw new V8ResultUndefined();
    }

    public V8Object getObject(int i) {
        this.f20074v8.checkThread();
        checkReleased();
        Object arrayGet = this.f20074v8.arrayGet(this.f20074v8.getV8RuntimePtr(), 6, this.objectHandle, i);
        if (arrayGet == null || (arrayGet instanceof V8Object)) {
            return (V8Object) arrayGet;
        }
        throw new V8ResultUndefined();
    }

    public V8Array push(int i) {
        this.f20074v8.checkThread();
        checkReleased();
        this.f20074v8.addArrayIntItem(this.f20074v8.getV8RuntimePtr(), getHandle(), i);
        return this;
    }

    public V8Array push(boolean z) {
        this.f20074v8.checkThread();
        checkReleased();
        this.f20074v8.addArrayBooleanItem(this.f20074v8.getV8RuntimePtr(), getHandle(), z);
        return this;
    }

    public V8Array push(double d) {
        this.f20074v8.checkThread();
        checkReleased();
        this.f20074v8.addArrayDoubleItem(this.f20074v8.getV8RuntimePtr(), getHandle(), d);
        return this;
    }

    public V8Array push(String str) {
        this.f20074v8.checkThread();
        checkReleased();
        if (str == null) {
            this.f20074v8.addArrayNullItem(this.f20074v8.getV8RuntimePtr(), getHandle());
        } else if (str.equals(C8369V8.getUndefined())) {
            this.f20074v8.addArrayUndefinedItem(this.f20074v8.getV8RuntimePtr(), getHandle());
        } else {
            this.f20074v8.addArrayStringItem(this.f20074v8.getV8RuntimePtr(), getHandle(), str);
        }
        return this;
    }

    public V8Array push(V8Value v8Value) {
        this.f20074v8.checkThread();
        checkReleased();
        this.f20074v8.checkRuntime(v8Value);
        if (v8Value == null) {
            this.f20074v8.addArrayNullItem(this.f20074v8.getV8RuntimePtr(), getHandle());
        } else if (v8Value.equals(C8369V8.getUndefined())) {
            this.f20074v8.addArrayUndefinedItem(this.f20074v8.getV8RuntimePtr(), getHandle());
        } else {
            this.f20074v8.addArrayObjectItem(this.f20074v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
        }
        return this;
    }

    public V8Array push(Object obj) {
        Object obj2 = obj;
        this.f20074v8.checkThread();
        checkReleased();
        boolean z = obj2 instanceof V8Value;
        if (z) {
            this.f20074v8.checkRuntime((V8Value) obj2);
        }
        if (obj2 == null) {
            this.f20074v8.addArrayNullItem(this.f20074v8.getV8RuntimePtr(), getHandle());
        } else if (obj2.equals(C8369V8.getUndefined())) {
            this.f20074v8.addArrayUndefinedItem(this.f20074v8.getV8RuntimePtr(), getHandle());
        } else if (obj2 instanceof Double) {
            this.f20074v8.addArrayDoubleItem(this.f20074v8.getV8RuntimePtr(), getHandle(), ((Double) obj2).doubleValue());
        } else if (obj2 instanceof Integer) {
            this.f20074v8.addArrayIntItem(this.f20074v8.getV8RuntimePtr(), getHandle(), ((Integer) obj2).intValue());
        } else if (obj2 instanceof Float) {
            this.f20074v8.addArrayDoubleItem(this.f20074v8.getV8RuntimePtr(), getHandle(), ((Float) obj2).doubleValue());
        } else if (obj2 instanceof Number) {
            this.f20074v8.addArrayDoubleItem(this.f20074v8.getV8RuntimePtr(), getHandle(), ((Number) obj2).doubleValue());
        } else if (obj2 instanceof Boolean) {
            this.f20074v8.addArrayBooleanItem(this.f20074v8.getV8RuntimePtr(), getHandle(), ((Boolean) obj2).booleanValue());
        } else if (obj2 instanceof String) {
            this.f20074v8.addArrayStringItem(this.f20074v8.getV8RuntimePtr(), getHandle(), (String) obj2);
        } else if (z) {
            this.f20074v8.addArrayObjectItem(this.f20074v8.getV8RuntimePtr(), getHandle(), ((V8Value) obj2).getHandle());
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public V8Array pushNull() {
        this.f20074v8.checkThread();
        checkReleased();
        this.f20074v8.addArrayNullItem(this.f20074v8.getV8RuntimePtr(), getHandle());
        return this;
    }

    public V8Array pushUndefined() {
        this.f20074v8.checkThread();
        checkReleased();
        this.f20074v8.addArrayUndefinedItem(this.f20074v8.getV8RuntimePtr(), getHandle());
        return this;
    }

    /* renamed from: com.didi.dimina.v8.V8Array$Undefined */
    static class Undefined extends V8Array {
        public void close() {
        }

        public int hashCode() {
            return 919;
        }

        public boolean isReleased() {
            return false;
        }

        public boolean isUndefined() {
            return true;
        }

        @Deprecated
        public void release() {
        }

        public String toString() {
            return "undefined";
        }

        public Undefined twin() {
            return (Undefined) V8Array.super.twin();
        }

        public boolean equals(Object obj) {
            return (obj instanceof V8Object) && ((V8Object) obj).isUndefined();
        }

        public C8369V8 getRuntime() {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, boolean z) {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, double d) {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, int i) {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        public V8Object addUndefined(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean contains(String str) {
            throw new UnsupportedOperationException();
        }

        public V8Array executeArrayFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public boolean executeBooleanFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public double executeDoubleFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public int executeIntegerFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public String executeStringFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public void executeVoidFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public V8Array getArray(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(String str) {
            throw new UnsupportedOperationException();
        }

        public double getDouble(String str) {
            throw new UnsupportedOperationException();
        }

        public int getInteger(String str) {
            throw new UnsupportedOperationException();
        }

        public String[] getKeys() {
            throw new UnsupportedOperationException();
        }

        public V8Object getObject(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        public String getString(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        public int getType(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            throw new UnsupportedOperationException();
        }

        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            throw new UnsupportedOperationException();
        }

        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            throw new UnsupportedOperationException();
        }

        public V8Object setPrototype(V8Object v8Object) {
            throw new UnsupportedOperationException();
        }

        public Object get(int i) {
            throw new UnsupportedOperationException();
        }

        public V8Array getArray(int i) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(int i) {
            throw new UnsupportedOperationException();
        }

        public boolean[] getBooleans(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        public byte[] getBytes(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        public int getBytes(int i, int i2, byte[] bArr) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(int i) {
            throw new UnsupportedOperationException();
        }

        public int getBooleans(int i, int i2, boolean[] zArr) {
            throw new UnsupportedOperationException();
        }

        public double getDouble(int i) {
            throw new UnsupportedOperationException();
        }

        public double[] getDoubles(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        public int getDoubles(int i, int i2, double[] dArr) {
            throw new UnsupportedOperationException();
        }

        public int getInteger(int i) {
            throw new UnsupportedOperationException();
        }

        public int[] getIntegers(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        public int getIntegers(int i, int i2, int[] iArr) {
            throw new UnsupportedOperationException();
        }

        public V8Object getObject(int i) {
            throw new UnsupportedOperationException();
        }

        public String getString(int i) {
            throw new UnsupportedOperationException();
        }

        public String[] getStrings(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        public int getStrings(int i, int i2, String[] strArr) {
            throw new UnsupportedOperationException();
        }

        public int getType() {
            throw new UnsupportedOperationException();
        }

        public int getType(int i) {
            throw new UnsupportedOperationException();
        }

        public int getType(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        public int length() {
            throw new UnsupportedOperationException();
        }

        public V8Array push(boolean z) {
            throw new UnsupportedOperationException();
        }

        public V8Array push(double d) {
            throw new UnsupportedOperationException();
        }

        public V8Array push(int i) {
            throw new UnsupportedOperationException();
        }

        public V8Array push(String str) {
            throw new UnsupportedOperationException();
        }

        public V8Array push(V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        public V8Array pushUndefined() {
            throw new UnsupportedOperationException();
        }
    }
}
