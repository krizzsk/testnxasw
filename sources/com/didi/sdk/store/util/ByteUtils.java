package com.didi.sdk.store.util;

import java.nio.ByteBuffer;

public class ByteUtils {

    /* renamed from: a */
    private static ByteBuffer f40259a = ByteBuffer.allocate(8);

    public static byte[] longToBytes(long j) {
        f40259a.putLong(0, j);
        return f40259a.array();
    }

    public static long bytesToLong(byte[] bArr) {
        f40259a.put(bArr, 0, bArr.length);
        f40259a.flip();
        return f40259a.getLong();
    }
}
