package com.didi.sdk.logging.model;

public class BinaryLog extends AbstractLog {

    /* renamed from: a */
    private byte[] f39340a;

    public String getContent() {
        throw new UnsupportedOperationException();
    }

    public String getTag() {
        throw new UnsupportedOperationException();
    }

    public String getMsg() {
        throw new UnsupportedOperationException();
    }

    public byte[] getData() {
        return this.f39340a;
    }

    public BinaryLog(byte[] bArr) {
        this.f39340a = bArr;
    }
}
