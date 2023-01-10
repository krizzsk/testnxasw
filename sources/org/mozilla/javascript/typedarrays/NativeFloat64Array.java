package org.mozilla.javascript.typedarrays;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

public class NativeFloat64Array extends NativeTypedArrayView<Double> {
    private static final int BYTES_PER_ELEMENT = 8;
    private static final String CLASS_NAME = "Float64Array";
    private static final long serialVersionUID = -1255405650050639335L;

    public int getBytesPerElement() {
        return 8;
    }

    public String getClassName() {
        return CLASS_NAME;
    }

    public NativeFloat64Array() {
    }

    public NativeFloat64Array(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2 * 8);
    }

    public NativeFloat64Array(int i) {
        this(new NativeArrayBuffer(i * 8), 0, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeFloat64Array().exportAsJSClass(4, scriptable, z);
    }

    /* access modifiers changed from: protected */
    public NativeTypedArrayView construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeFloat64Array(nativeArrayBuffer, i, i2);
    }

    /* access modifiers changed from: protected */
    public NativeTypedArrayView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeFloat64Array) {
            return (NativeFloat64Array) scriptable;
        }
        throw incompatibleCallError(idFunctionObject);
    }

    /* access modifiers changed from: protected */
    public Object js_get(int i) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        return Double.valueOf(Double.longBitsToDouble(ByteIo.readUint64Primitive(this.arrayBuffer.buffer, (i * 8) + this.offset, false)));
    }

    /* access modifiers changed from: protected */
    public Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeUint64(this.arrayBuffer.buffer, (i * 8) + this.offset, Double.doubleToLongBits(ScriptRuntime.toNumber(obj)), false);
        return null;
    }

    public Double get(int i) {
        if (!checkIndex(i)) {
            return (Double) js_get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public Double set(int i, Double d) {
        if (!checkIndex(i)) {
            return (Double) js_set(i, d);
        }
        throw new IndexOutOfBoundsException();
    }
}
