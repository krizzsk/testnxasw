package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

public class NativeUint8Array extends NativeTypedArrayView<Integer> {
    private static final String CLASS_NAME = "Uint8Array";
    private static final long serialVersionUID = -3349419704390398895L;

    public int getBytesPerElement() {
        return 1;
    }

    public String getClassName() {
        return CLASS_NAME;
    }

    public NativeUint8Array() {
    }

    public NativeUint8Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2);
    }

    public NativeUint8Array(int i) {
        this(new NativeArrayBuffer(i), 0, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeUint8Array().exportAsJSClass(4, scriptable, z);
    }

    /* access modifiers changed from: protected */
    public NativeTypedArrayView construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeUint8Array(nativeArrayBuffer, i, i2);
    }

    /* access modifiers changed from: protected */
    public NativeTypedArrayView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeUint8Array) {
            return (NativeUint8Array) scriptable;
        }
        throw incompatibleCallError(idFunctionObject);
    }

    /* access modifiers changed from: protected */
    public Object js_get(int i) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        return ByteIo.readUint8(this.arrayBuffer.buffer, i + this.offset);
    }

    /* access modifiers changed from: protected */
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeUint8(this.arrayBuffer.buffer, i + this.offset, Conversions.toUint8(obj));
        return null;
    }

    public Integer get(int i) {
        if (!checkIndex(i)) {
            return (Integer) js_get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public Integer set(int i, Integer num) {
        if (!checkIndex(i)) {
            return (Integer) js_set(i, num);
        }
        throw new IndexOutOfBoundsException();
    }
}
