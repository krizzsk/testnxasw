package com.didi.aoe.runtime.ifx;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public final class IfxTensor {
    public static final int SHAPE_C = 2;
    public static final int SHAPE_CSETP = 5;
    public static final int SHAPE_DIMS = 3;
    public static final int SHAPE_ELEMSIZE = 4;
    public static final int SHAPE_H = 1;
    public static final int SHAPE_SIZE = 6;
    public static final int SHAPE_W = 0;

    /* renamed from: a */
    private long f10050a;

    /* renamed from: b */
    private int[] f10051b;

    private static native ByteBuffer buffer(long j);

    private static native long create(long j, int i, boolean z);

    private static native void delete(long j);

    private static native int numBytes(long j);

    private static native void readMultiDimensionalArray(long j, Object obj);

    private static native int[] shape(long j);

    private static native void writeDirectBuffer(long j, ByteBuffer byteBuffer);

    private static native void writeMultiDimensionalArray(long j, Object obj);

    /* renamed from: a */
    static IfxTensor m8718a(long j, int i, boolean z) {
        return new IfxTensor(create(j, i, z));
    }

    private IfxTensor(long j) {
        this.f10050a = j;
        this.f10051b = shape(j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45145a() {
        this.f10050a = 0;
    }

    public int[] shape() {
        return this.f10051b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo45148b() {
        this.f10051b = shape(this.f10050a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo45149c() {
        return this.f10050a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45146a(Object obj) {
        m8724g(obj);
        if (!m8723f(obj)) {
            writeMultiDimensionalArray(this.f10050a, obj);
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (!byteBuffer.isDirect() || byteBuffer.order() != ByteOrder.nativeOrder()) {
            m8720d().put(byteBuffer);
        } else {
            writeDirectBuffer(this.f10050a, byteBuffer);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Object mo45147b(Object obj) {
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            ByteBuffer d = m8720d();
            if (d != null) {
                byteBuffer.put(d);
            }
            return obj;
        }
        readMultiDimensionalArray(this.f10050a, obj);
        return obj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int[] mo45150c(Object obj) {
        if (m8723f(obj)) {
            return null;
        }
        int[] d = m8721d(obj);
        if (Arrays.equals(this.f10051b, d)) {
            return null;
        }
        return d;
    }

    /* renamed from: d */
    static int[] m8721d(Object obj) {
        int[] iArr = new int[m8722e(obj)];
        m8719a(obj, 0, iArr);
        return iArr;
    }

    /* renamed from: e */
    static int m8722e(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return 0;
        }
        if (Array.getLength(obj) != 0) {
            return m8722e(Array.get(obj, 0)) + 1;
        }
        throw new IllegalArgumentException("Array lengths cannot be 0.");
    }

    /* renamed from: a */
    static void m8719a(Object obj, int i, int[] iArr) {
        if (iArr != null && i != iArr.length) {
            int length = Array.getLength(obj);
            if (iArr[i] == 0) {
                iArr[i] = length;
            } else if (iArr[i] != length) {
                throw new IllegalArgumentException(String.format("Mismatched lengths (%d and %d) in dimension %d", new Object[]{Integer.valueOf(iArr[i]), Integer.valueOf(length), Integer.valueOf(i)}));
            }
            for (int i2 = 0; i2 < length; i2++) {
                m8719a(Array.get(obj, i2), i + 1, iArr);
            }
        }
    }

    /* renamed from: f */
    private static boolean m8723f(Object obj) {
        return obj instanceof ByteBuffer;
    }

    public int numBytes() {
        return numBytes(this.f10050a);
    }

    /* renamed from: g */
    private void m8724g(Object obj) {
        if (m8723f(obj)) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            if (byteBuffer.capacity() != numBytes()) {
                throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite buffer with %d bytes and a ByteBuffer with %d bytes.", new Object[]{Integer.valueOf(numBytes()), Integer.valueOf(byteBuffer.capacity())}));
            }
        }
    }

    /* renamed from: d */
    private ByteBuffer m8720d() {
        ByteBuffer buffer = buffer(this.f10050a);
        if (buffer != null) {
            buffer.order(ByteOrder.nativeOrder());
        }
        return buffer;
    }
}
