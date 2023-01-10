package com.didi.payment.base.push;

public class PushMessage {

    /* renamed from: a */
    private String f32382a;

    /* renamed from: b */
    private byte[] f32383b;

    public PushMessage(String str, byte[] bArr) {
        this.f32382a = str;
        this.f32383b = bArr;
    }

    public PushMessage() {
    }

    public String getTopic() {
        return this.f32382a;
    }

    public void setTopic(String str) {
        this.f32382a = str;
    }

    public byte[] getData() {
        return this.f32383b;
    }

    public void setData(byte[] bArr) {
        this.f32383b = bArr;
    }
}
