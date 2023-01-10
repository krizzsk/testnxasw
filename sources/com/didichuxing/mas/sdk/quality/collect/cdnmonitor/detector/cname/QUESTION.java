package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.cname;

public class QUESTION {

    /* renamed from: a */
    private short f50341a;

    /* renamed from: b */
    private short f50342b;

    public QUESTION(short s, short s2) {
        this.f50341a = s;
        this.f50342b = s2;
    }

    public byte[] toByteArray() {
        short s = this.f50341a;
        short s2 = this.f50342b;
        return new byte[]{(byte) (s >> 8), (byte) s, (byte) (s2 >> 8), (byte) s2};
    }
}
