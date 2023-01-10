package com.didi.dqr.pdf417.encoder;

/* renamed from: com.didi.dqr.pdf417.encoder.a */
/* compiled from: BarcodeRow */
final class C8473a {

    /* renamed from: a */
    private final byte[] f20860a;

    /* renamed from: b */
    private int f20861b = 0;

    C8473a(int i) {
        this.f20860a = new byte[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63515a(int i, byte b) {
        this.f20860a[i] = b;
    }

    /* renamed from: a */
    private void m17605a(int i, boolean z) {
        this.f20860a[i] = z ? (byte) 1 : 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63516a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f20861b;
            this.f20861b = i3 + 1;
            m17605a(i3, z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo63517a(int i) {
        int length = this.f20860a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.f20860a[i2 / i];
        }
        return bArr;
    }
}
