package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

public class NativeUint16Array extends NativeTypedArrayView<Integer> {
    private static final int BYTES_PER_ELEMENT = 2;
    private static final String CLASS_NAME = "Uint16Array";
    private static final long serialVersionUID = 7700018949434240321L;

    public int getBytesPerElement() {
        return 2;
    }

    public String getClassName() {
        return CLASS_NAME;
    }

    public NativeUint16Array() {
    }

    public NativeUint16Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 2);
    }

    public NativeUint16Array(int i) {
        this(new NativeArrayBuffer(i * 2), 0, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeUint16Array().exportAsJSClass(4, scriptable, z);
    }

    /* access modifiers changed from: protected */
    public NativeTypedArrayView construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeUint16Array(nativeArrayBuffer, i, i2);
    }

    /* access modifiers changed from: protected */
    public NativeTypedArrayView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeUint16Array) {
            return (NativeUint16Array) scriptable;
        }
        throw incompatibleCallError(idFunctionObject);
    }

    /* access modifiers changed from: protected */
    public Object js_get(int i) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        return ByteIo.readUint16(this.arrayBuffer.buffer, (i * 2) + this.offset, false);
    }

    /* access modifiers changed from: protected */
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeUint16(this.arrayBuffer.buffer, (i * 2) + this.offset, Conversions.toUint16(obj), false);
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
