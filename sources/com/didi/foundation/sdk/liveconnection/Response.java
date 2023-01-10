package com.didi.foundation.sdk.liveconnection;

public class Response {

    /* renamed from: a */
    private int f23063a;

    /* renamed from: b */
    private byte[] f23064b;

    /* renamed from: c */
    private byte[] f23065c;

    public Response(int i, byte[] bArr, byte[] bArr2) {
        this.f23063a = i;
        this.f23064b = bArr;
        this.f23065c = bArr2;
    }

    public int getMessageType() {
        return this.f23063a;
    }

    public byte[] getSeqId() {
        return this.f23064b;
    }

    public byte[] getData() {
        return this.f23065c;
    }
}
