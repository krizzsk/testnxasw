package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname;

import java.nio.ByteBuffer;
import kotlin.UShort;

public class DNSInput {

    /* renamed from: a */
    private ByteBuffer f50337a;

    public DNSInput(byte[] bArr) {
        this.f50337a = ByteBuffer.wrap(bArr);
    }

    public int readU16() {
        return this.f50337a.getShort() & UShort.MAX_VALUE;
    }

    public void jump(int i) {
        this.f50337a.position(i);
        ByteBuffer byteBuffer = this.f50337a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public int readU8() {
        return this.f50337a.get() & 255;
    }

    public int current() {
        return this.f50337a.position();
    }
}
