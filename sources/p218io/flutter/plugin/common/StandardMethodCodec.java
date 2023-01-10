package p218io.flutter.plugin.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p218io.flutter.plugin.common.StandardMessageCodec;

/* renamed from: io.flutter.plugin.common.StandardMethodCodec */
public final class StandardMethodCodec implements MethodCodec {
    public static final StandardMethodCodec INSTANCE = new StandardMethodCodec(StandardMessageCodec.INSTANCE);

    /* renamed from: a */
    private final StandardMessageCodec f60547a;

    public StandardMethodCodec(StandardMessageCodec standardMessageCodec) {
        this.f60547a = standardMessageCodec;
    }

    public ByteBuffer encodeMethodCall(MethodCall methodCall) {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        this.f60547a.writeValue(exposedByteArrayOutputStream, methodCall.method);
        this.f60547a.writeValue(exposedByteArrayOutputStream, methodCall.arguments);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return allocateDirect;
    }

    public MethodCall decodeMethodCall(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object readValue = this.f60547a.readValue(byteBuffer);
        Object readValue2 = this.f60547a.readValue(byteBuffer);
        if ((readValue instanceof String) && !byteBuffer.hasRemaining()) {
            return new MethodCall((String) readValue, readValue2);
        }
        throw new IllegalArgumentException("Method call corrupted");
    }

    public ByteBuffer encodeSuccessEnvelope(Object obj) {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        exposedByteArrayOutputStream.write(0);
        this.f60547a.writeValue(exposedByteArrayOutputStream, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return allocateDirect;
    }

    public ByteBuffer encodeErrorEnvelope(String str, String str2, Object obj) {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        exposedByteArrayOutputStream.write(1);
        this.f60547a.writeValue(exposedByteArrayOutputStream, str);
        this.f60547a.writeValue(exposedByteArrayOutputStream, str2);
        if (obj instanceof Throwable) {
            this.f60547a.writeValue(exposedByteArrayOutputStream, m45644a((Throwable) obj));
        } else {
            this.f60547a.writeValue(exposedByteArrayOutputStream, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return allocateDirect;
    }

    public ByteBuffer encodeErrorEnvelopeWithStacktrace(String str, String str2, Object obj, String str3) {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        exposedByteArrayOutputStream.write(1);
        this.f60547a.writeValue(exposedByteArrayOutputStream, str);
        this.f60547a.writeValue(exposedByteArrayOutputStream, str2);
        if (obj instanceof Throwable) {
            this.f60547a.writeValue(exposedByteArrayOutputStream, m45644a((Throwable) obj));
        } else {
            this.f60547a.writeValue(exposedByteArrayOutputStream, obj);
        }
        this.f60547a.writeValue(exposedByteArrayOutputStream, str3);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return allocateDirect;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r0 == 1) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decodeEnvelope(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L_0x0011
            r1 = 1
            if (r0 != r1) goto L_0x004a
            goto L_0x001e
        L_0x0011:
            io.flutter.plugin.common.StandardMessageCodec r0 = r4.f60547a
            java.lang.Object r0 = r0.readValue(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L_0x001e
            return r0
        L_0x001e:
            io.flutter.plugin.common.StandardMessageCodec r0 = r4.f60547a
            java.lang.Object r0 = r0.readValue(r5)
            io.flutter.plugin.common.StandardMessageCodec r1 = r4.f60547a
            java.lang.Object r1 = r1.readValue(r5)
            io.flutter.plugin.common.StandardMessageCodec r2 = r4.f60547a
            java.lang.Object r2 = r2.readValue(r5)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L_0x004a
            if (r1 == 0) goto L_0x003a
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x004a
        L_0x003a:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L_0x004a
            io.flutter.plugin.common.FlutterException r5 = new io.flutter.plugin.common.FlutterException
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r0, r1, r2)
            throw r5
        L_0x004a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.plugin.common.StandardMethodCodec.decodeEnvelope(java.nio.ByteBuffer):java.lang.Object");
    }

    /* renamed from: a */
    private static String m45644a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
