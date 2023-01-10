package p218io.flutter.plugin.common;

import java.nio.ByteBuffer;

/* renamed from: io.flutter.plugin.common.BinaryCodec */
public final class BinaryCodec implements MessageCodec<ByteBuffer> {
    public static final BinaryCodec INSTANCE = new BinaryCodec();
    public static final BinaryCodec INSTANCE_DIRECT = new BinaryCodec(true);

    /* renamed from: a */
    private final boolean f60516a;

    public ByteBuffer encodeMessage(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    private BinaryCodec() {
        this.f60516a = false;
    }

    private BinaryCodec(boolean z) {
        this.f60516a = z;
    }

    public ByteBuffer decodeMessage(ByteBuffer byteBuffer) {
        if (byteBuffer == null || this.f60516a) {
            return byteBuffer;
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        allocate.put(byteBuffer);
        allocate.rewind();
        return allocate;
    }
}
