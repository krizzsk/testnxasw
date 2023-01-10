package com.didi.foundation.sdk.liveconnection;

public class Request {

    /* renamed from: a */
    private int f23059a;

    /* renamed from: b */
    private byte[] f23060b;

    /* renamed from: c */
    private byte[] f23061c;

    /* renamed from: d */
    private boolean f23062d;

    public Request() {
        this.f23061c = new byte[8];
    }

    public Request(int i, byte[] bArr, byte[] bArr2, boolean z) {
        this.f23059a = i;
        this.f23060b = bArr;
        if (bArr2 == null) {
            this.f23061c = new byte[8];
        } else {
            this.f23061c = bArr2;
        }
        this.f23062d = z;
    }

    public int getMessageType() {
        return this.f23059a;
    }

    public void setMessageType(int i) {
        this.f23059a = i;
    }

    public byte[] getData() {
        return this.f23060b;
    }

    public void setData(byte[] bArr) {
        this.f23060b = bArr;
    }

    public byte[] getSeqIdOut() {
        return this.f23061c;
    }

    public void setSeqIdOut(byte[] bArr) {
        this.f23061c = bArr;
    }

    public boolean isNeedResponse() {
        return this.f23062d;
    }
}
