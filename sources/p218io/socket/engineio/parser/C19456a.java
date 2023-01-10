package p218io.socket.engineio.parser;

import java.nio.ByteBuffer;

/* renamed from: io.socket.engineio.parser.a */
/* compiled from: Parser */
class C19456a {
    private C19456a() {
    }

    /* renamed from: a */
    public static byte[] m41083a(byte[][] bArr) {
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        return m41084a(bArr, i);
    }

    /* renamed from: a */
    public static byte[] m41084a(byte[][] bArr, int i) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        if (bArr.length == 1) {
            return bArr[0];
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        for (byte[] put : bArr) {
            allocate.put(put);
        }
        return allocate.array();
    }
}
